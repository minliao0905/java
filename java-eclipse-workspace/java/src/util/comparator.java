package util;
import java.util.Arrays;
import java.util.Comparator;

public class comparator {
    public static void main(String[] args) {
        //ע�⣬Ҫ��ı�Ĭ�ϵ�����˳�򣬲���ʹ�û������ͣ�int,double, char��
        //��Ҫʹ�����Ƕ�Ӧ����
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //����һ���Զ�����MyComparator�Ķ���
//        Comparator<Integer> cmp = new MyComparator();
        Arrays.sort(a, new MyComparator(){
        	  @Override
        	    public int compare(Integer o1, Integer o2) {
        	        return o2-o1;             //����;
        	    }
        });
        for(int i:a) {
            System.out.print(i+ "\t");
        }
    }
}
//Comparator��һ���ӿڣ��������������Լ��������MyComparatorҪimplents�ýӿڣ�������extends Comparator
class MyComparator implements Comparator<Integer> {
    //���o1С��o2�����Ǿͷ�����ֵ�����n1����n2���Ǿͷ��ظ�ֵ��
    //�����ߵ�һ�£��Ϳ���ʵ�ַ���������
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
