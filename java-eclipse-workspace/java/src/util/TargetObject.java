package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Apple {
	String name;
	 public static Integer weight;
	 private static Integer age;
	 private  Double height;
	  public Apple(Integer weight, Integer age, double height) {
	        this.weight = weight;
	        this.age = age;
	        this.height = height;
	    }
	public Apple() {
	}

	public Apple(String name) {
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class TargetObject {

	public static void main(String[] args) {
		// ������ṩ�� classPath ��ȡ step2.Apple �� Class ���� ��ʹ�� Class.forName() ������ ע�Ⲷ���쳣
		// ͨ��֮����Ҳ�����޸� clasapath Ϊ������·��������ĳ����������� ����: java.util.Date
		String classPath = "util.Apple";
		Class<?> clazz = null;
		/********** Begin *********/
		try {
			clazz = Class.forName(classPath); // ������class����;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/********** End *********/
		printFields(clazz);
//		printConstructors(clazz);
//		printMethods(clazz);
	}

	/**
	 * ���ӡ���ÿ����,�����ʽΪ�����η� ���� ������;
	 * 
	 * @param clazz
	 */
	public static void printFields(Class<?> clazz) {
		/********** Begin *********/

		Field[] f = clazz.getDeclaredFields(); // �����
		for (Field ff : f) {
			Class<?> type = ff.getType(); // getType()
			int mod = ff.getModifiers(); // ������η�Ϊint����;
			System.out.print(Modifier.toString(mod) + " ");
			System.out.print(type.getName() + " ");
			System.out.println(ff.getName() + ";");
			
		}
		System.out.println("++==================");
       for(Field field:f) {
    	   String modifiers = Modifier.toString(field.getModifiers());
		 //������η�
    	   int mod = field.getModifiers();
		 System.out.print(Modifier.toString(mod)+" ");
		 System.out.print(field.getType().getName()+" ");
		 System.out.println(field.getName());
       }
		
		/********** End *********/

		/********** End *********/
	}

	/**
	 * ��ӡ���캯��,�����ʽΪ�����η� �������ƣ�������
	 * 
	 * @param clazz
	 */
	public static void printConstructors(Class clazz) {
		Constructor[] constructors = clazz.getDeclaredConstructors(); // get��������
		for (Constructor constructor : constructors) {
			Class[] paramTypes = constructor.getParameterTypes(); // ����Ϊclass���飻
			/********** Begin *********/
			System.out.print(Modifier.toString(constructor.getModifiers()) + " ");

			System.out.print(constructor.getName() + "(");

			/********** End *********/
			printParamTypes(paramTypes);
		}
	}

	/**
	 * �����ÿ��������ӡ��ǩ������ʽΪ�����η� ����ֵ���� ��������(����);
	 * 
	 * @param clazz
	 */
	public static void printMethods(Class clazz) {
		Method[] methos = clazz.getDeclaredMethods();
		for (Method method : methos) {
			Class[] paramTypes = method.getParameterTypes();
			/********** Begin *********/
			String name = method.getName();
			String modifiers = Modifier.toString(method.getModifiers());
			// ������η�
			System.out.print(Modifier.toString(method.getModifiers()) + " ");
			System.out.print(method.getReturnType() + " ");
			System.out.print(method.getName() + "(");
			/********** End *********/
			printParamTypes(paramTypes);
		}
	}

	/**
	 * ��ӡ��������
	 * 
	 * @param paramTypes
	 */
	private static void printParamTypes(Class[] paramTypes) {
		for (int j = 0; j < paramTypes.length; ++j) {
			if (j > 0) {
				System.out.print(",");
			}
			System.out.print(paramTypes[j].getName());
		}
		System.out.println(");");
	}

}
