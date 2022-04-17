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
    
    //����뾶 //��������С��������//���ݼ�
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
     * �������ݵı�ǩ��ֱ�ӷ��������Ļ���
     */
    public  int[] performClustering(boolean doNormalize) {
    	System.out.println("�����ĸ���:"+inputValues.size());
    	
//    	if(doNormalize)				//�Ƿ����ݹ�һ�����Խ��Ӱ��Ƚϴ�
//    		{dataNormalize();}
    	
    	int k = 0;//�ؼ���
    	
    	List<Integer> unvisitedIndices = new ArrayList<>();   //���δ�����ʵ�����
    	for(int i = 0; i < inputValues.size(); i++) {
    		unvisitedIndices.add(i);
    	}
    	
    	int[] labels = new int[inputValues.size()]; 
    	int iter = 0;
    	while(unvisitedIndices.size() != 0) {
//    		System.out.println("iter..."+iter);
    		//ѡ���һ��δ�����ʵĶ���
//    		int index = (int) (Math.round(Math.random()*(unvisitedIndices.size()-1)));
    		int index = unvisitedIndices.get(0);
    		//��ȡ����������������,���ص�ֱ���ܶȿɴ�Ķ���
    		
    		System.out.println("\n\n��ǰ�ܶȿɴ����Ϊ��"+(index+1));
    		List<Integer> indices = coreObjectTest(index); 
    		
    		//��ֱ���ܶȿɴ�������������������ܶ�����
    		if(indices.size() >= Minpts) {    			
    			k++;			              //���Ķ�����У�Ҳ������Ҫ����չ�ĺ��Ķ���
    			Map<Integer, List<Integer>> mylist = new HashMap<>();
    			mylist.put(index, indices);    //��index ����Ϊ���Ķ��󣬸��ݶ�����ֱ�����Ķ������Ϊ�յ���ֹͣ
    			do {
    				//�Ӻ��Ķ����б���ѡ��һ��
    				int index_c = mylist.entrySet().iterator().next().getKey();
    				labels[index_c] = k;
    				unvisitedIndices.remove(new Integer(index_c));
    				
    				List<Integer> neighborIndices = mylist.get(index_c);    //��ȡ����			
    				mylist.remove(index_c);
        			//��������
        			for(int index_ : neighborIndices) {   
        				if(labels[index_] < 1) {
        					labels[index_] = k;
        					unvisitedIndices.remove(new Integer(index_));	//��δ�����ʵĶ����Ƴ�
            				List<Integer> index_OfNeighborIndices = coreObjectTest(index_);
            				if(index_OfNeighborIndices.size() >= Minpts)    //���ܶȿɴ����
            					mylist.put(index_, index_OfNeighborIndices);
        				}
        			}
    			}
    			while(mylist.size() != 0);
    		} else {  
    			//������Ϊ�������ݣ��ұ�����ѱ�����
    			labels[index] = -1;
    			System.out.println("��ǰѡ��ĵ㲻����Ϊ���Ķ���"+(index+1));
    			unvisitedIndices.remove(new Integer(index));
    		}
    		iter++;
    	}
		return labels; 	
    }
    
    public  void printResult(int[] labels) {
    	// -1������0,δ�����ʣ�������֣���>=1���
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
     * ��ȡһ���������������
     * @param testSampleIndex
     * @return ������Щ������index
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
     * ���ݹ�һ��
     * ���������һ�����Ҳ��޸�weka��DBSCAN��������ô�������һ��
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
     * ŷʽ����
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