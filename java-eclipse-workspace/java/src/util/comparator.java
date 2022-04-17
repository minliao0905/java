package util;
import java.util.Arrays;
import java.util.Comparator;

public class comparator {
    public static void main(String[] args) {
        //注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）
        //而要使用它们对应的类
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //定义一个自定义类MyComparator的对象
//        Comparator<Integer> cmp = new MyComparator();
        Arrays.sort(a, new MyComparator(){
        	  @Override
        	    public int compare(Integer o1, Integer o2) {
        	        return o2-o1;             //降序;
        	    }
        });
        for(int i:a) {
            System.out.print(i+ "\t");
        }
    }
}
//Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口，而不是extends Comparator
class MyComparator implements Comparator<Integer> {
    //如果o1小于o2，我们就返回正值，如果n1大于n2我们就返回负值，
    //这样颠倒一下，就可以实现反向排序了
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
