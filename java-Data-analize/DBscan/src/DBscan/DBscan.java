package DBscan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import au.com.bytecode.opencsv.CSVReader;
 
public class DBscan {
    private static int ATRIBUTE_NUMBER = 2;
    
    //邻域半径 //邻域内最小样本数量//数据集
    private double epsilon = 1;
   
    private static int Minpts = 4;
    
    private static  List<int[]> inputValues= new ArrayList<int[]>();
    static List<String[]> arrayList  = null;

    @SuppressWarnings("null")
	public static void main(String[] args) throws IOException   {
        DBscan one = new DBscan();       
        CSVReader reader;
		reader = new CSVReader(new FileReader("textdata.csv"));
	    arrayList = reader.readAll();
        for(String[] entry: arrayList) {
        	int[] tempdata = new int[2] ;
        	tempdata[0] = Integer.parseInt(entry[0]);
        	tempdata[1] = Integer.parseInt(entry[1]);
//        	System.out.println(tempdata[0]);
        	inputValues.add(tempdata);
        }
        one.printResult(one.performClustering(false));
    }
   
    /**
     * 返回数据的标签不直接返回样本的划分
     */
    public  int[] performClustering(boolean doNormalize) {
    	System.out.println("样本的个数:"+inputValues.size());
    	
//    	if(doNormalize)				//是否数据归一化，对结果影响比较大
//    		{dataNormalize();}
    	
    	int k = 0;//簇计数
    	
    	List<Integer> unvisitedIndices = new ArrayList<>();   //标记未被访问的数据
    	for(int i = 0; i < inputValues.size(); i++) {
    		unvisitedIndices.add(i);
    	}
    	
    	int[] labels = new int[inputValues.size()]; 
    	int iter = 0;
    	while(unvisitedIndices.size() != 0) {
//    		System.out.println("iter..."+iter);
    		//选择出一个未被访问的对象
//    		int index = (int) (Math.round(Math.random()*(unvisitedIndices.size()-1)));
    		int index = unvisitedIndices.get(0);
    		//获取该样本的邻域样本,返回的直接密度可达的对象
    		
    		System.out.println("\n\n当前密度可达对象为："+(index+1));
    		List<Integer> indices = coreObjectTest(index); 
    		
    		//若直接密度可达则遍历对象链，产生密度相连
    		if(indices.size() >= Minpts) {    			
    			k++;			              //核心对象队列，也就是需要被扩展的核心对象
    			Map<Integer, List<Integer>> mylist = new HashMap<>();
    			mylist.put(index, indices);    //以index 对象为核心对象，根据对象链直到核心对象队列为空迭代停止
    			do {
    				//从核心对象列表中选择一个
    				int index_c = mylist.entrySet().iterator().next().getKey();
    				labels[index_c] = k;
    				unvisitedIndices.remove(new Integer(index_c));
    				
    				List<Integer> neighborIndices = mylist.get(index_c);    //获取邻域			
    				mylist.remove(index_c);
        			//遍历邻域
        			for(int index_ : neighborIndices) {   
        				if(labels[index_] < 1) {
        					labels[index_] = k;
        					unvisitedIndices.remove(new Integer(index_));	//从未被访问的队列移除
            				List<Integer> index_OfNeighborIndices = coreObjectTest(index_);
            				if(index_OfNeighborIndices.size() >= Minpts)    //若密度可达，加入
            					mylist.put(index_, index_OfNeighborIndices);
        				}
        			}
    			}
    			while(mylist.size() != 0);
    		} else {  
    			//被定义为噪音数据，且被标记已被访问
    			labels[index] = -1;
    			System.out.println("当前选择的点不可作为核心对象"+(index+1));
    			unvisitedIndices.remove(new Integer(index));
    		}
    		iter++;
    	}
		return labels; 	
    }
    
    public  void printResult(int[] labels) {
    	// -1噪音，0,未被访问（不会出现），>=1类别
    	Map<Integer, ArrayList<Integer>> counts = new HashMap<>();
    	int c = 0;
    	for(int label : labels) {
    		ArrayList<Integer> indices = counts.get(label);
    		if(indices == null) {
    			ArrayList<Integer> list = new ArrayList<>();
    			list.add(c);
    			counts.put(label, list);
    		} else {
    			indices.add(c);
    		}
    		c++;
    	}
    	System.out.println("");
    	counts.forEach((k,v)->{
    		System.out.println("CLUSTER "+k+":"+" "+v.size()+"/"+labels.length);
    	});
    	System.out.println();
    	counts.forEach((k,v)->{
    		System.out.println("CLUSTER "+k+" data indices:");
    		System.out.print("----------");
    		v.forEach((e)->System.out.print(e+1+","));
    		System.out.println();
    	});
    }
    
    /**
     * 获取一个样本邻域的样本
     * @param testSampleIndex
     * @return 返回这些样本的index
     */
    public  List<Integer> coreObjectTest(int testSampleIndex){
    	List<Integer> indices = new ArrayList<>();
    	for(int i = 0; i < inputValues.size(); i++) {
    		if(distance(inputValues.get(testSampleIndex), inputValues.get(i)) <= epsilon) {
    			indices.add(i);
    		System.out.print(i+1+"  ");
    		}
    	}
    	System.out.println("  ");
    	return indices;
    }
    /**
     * 数据归一化
     * 如果不做归一化并且不修改weka中DBSCAN的设置那么结果将大不一样
     * x = (x - min)/(max - min)
     */
    public void dataNormalize() {
    	//x = (x - min)/(max - min)
    	double[] mins = new double[ATRIBUTE_NUMBER];
    	double[] maxs = new double[ATRIBUTE_NUMBER];
    	for(int i = 0; i < ATRIBUTE_NUMBER;i++) {
    		mins[i] = Double.MAX_VALUE;
    		maxs[i] = Double.MIN_VALUE;
    	}
    	for(int i = 0; i < ATRIBUTE_NUMBER; i++) {
    		for(int j = 0; j < inputValues.size();j++) {
    			mins[i] = inputValues.get(j)[i] < mins[i] ? inputValues.get(j)[i] : mins[i];
    			maxs[i] = inputValues.get(j)[i] > maxs[i] ? inputValues.get(j)[i] : maxs[i];
    		}
    	}
    	double[] maxsReduceMins = new double[ATRIBUTE_NUMBER];
    	for(int i = 0; i < ATRIBUTE_NUMBER;i++) {
    		maxsReduceMins[i] = maxs[i] - mins[i];
    	}
    	for(int i = 0; i < ATRIBUTE_NUMBER; i++) {
    		for(int j = 0; j < inputValues.size();j++) {
    			inputValues.get(j)[i] = (int) ((inputValues.get(j)[i] - mins[i])/(maxsReduceMins[i]));
    		}
    	}
    }
    /**
     * 欧式距离
     * @param v1
     * @param v2
     * @return
     */
    public static double distance(int[] v1, int[] v2) {
		double sum = 0;
		for(int i = 0; i < v1.length; i++) {
			sum += Math.pow(v1[i]-v2[i], 2);
		}
		return Math.sqrt(sum);
	}
}