package abstract_factory;

//两种产品为抽象类，在生产咖啡的基础上。分别定义两种口味的工厂
//甜点继承Dessert抽象，咖啡继承coffee抽象类型
//两种口味工厂引用甜点工厂的接口，分别可以创建咖啡和甜点对象
//加载对应的同一类产品时，只需调用该类的工厂类，不需要修改其他的类。
//当生产对象有一定的相互依赖或关联关系时-----适用
//
public class Client {
    public static void main(String[] args) {
    	//创建意大利风味甜味工厂对象
    	AmericanDessertFactory Americanfactory = new AmericanDessertFactory();
    	//获取甜品
    	coffee coffee = Americanfactory.createCoffee();
    	Dessert dessert = Americanfactory.createDessert();
    	System.out.println(coffee.getName());  //咖啡显示名字，均为继承抽象类型的获取产品名字的方法
    	dessert.show();                          //甜点的show方法表示甜点 ，show方法为继承抽象类型的方法
    }
}
