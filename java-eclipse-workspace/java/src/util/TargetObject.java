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
		// 请根据提供的 classPath 获取 step2.Apple 的 Class 对象， 请使用 Class.forName() 方法， 注意捕获异常
		// 通关之后，你也可以修改 clasapath 为其他类路径，分析某个类的能力， 例如: java.util.Date
		String classPath = "util.Apple";
		Class<?> clazz = null;
		/********** Begin *********/
		try {
			clazz = Class.forName(classPath); // 获得类的class对象;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/********** End *********/
		printFields(clazz);
//		printConstructors(clazz);
//		printMethods(clazz);
	}

	/**
	 * 请打印类的每个域,输出格式为：修饰符 类型 变量名;
	 * 
	 * @param clazz
	 */
	public static void printFields(Class<?> clazz) {
		/********** Begin *********/

		Field[] f = clazz.getDeclaredFields(); // 获得域
		for (Field ff : f) {
			Class<?> type = ff.getType(); // getType()
			int mod = ff.getModifiers(); // 获得修饰符为int类型;
			System.out.print(Modifier.toString(mod) + " ");
			System.out.print(type.getName() + " ");
			System.out.println(ff.getName() + ";");
			
		}
		System.out.println("++==================");
       for(Field field:f) {
    	   String modifiers = Modifier.toString(field.getModifiers());
		 //输出修饰符
    	   int mod = field.getModifiers();
		 System.out.print(Modifier.toString(mod)+" ");
		 System.out.print(field.getType().getName()+" ");
		 System.out.println(field.getName());
       }
		
		/********** End *********/

		/********** End *********/
	}

	/**
	 * 打印构造函数,输出格式为：修饰符 方法名称（参数）
	 * 
	 * @param clazz
	 */
	public static void printConstructors(Class clazz) {
		Constructor[] constructors = clazz.getDeclaredConstructors(); // get构造器；
		for (Constructor constructor : constructors) {
			Class[] paramTypes = constructor.getParameterTypes(); // 遍历为class数组；
			/********** Begin *********/
			System.out.print(Modifier.toString(constructor.getModifiers()) + " ");

			System.out.print(constructor.getName() + "(");

			/********** End *********/
			printParamTypes(paramTypes);
		}
	}

	/**
	 * 请针对每个方法打印其签名，格式为：修饰符 返回值类型 方法名称(参数);
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
			// 输出修饰符
			System.out.print(Modifier.toString(method.getModifiers()) + " ");
			System.out.print(method.getReturnType() + " ");
			System.out.print(method.getName() + "(");
			/********** End *********/
			printParamTypes(paramTypes);
		}
	}

	/**
	 * 打印方法参数
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
