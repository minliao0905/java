package abstract_factory;

//���ֲ�ƷΪ�����࣬���������ȵĻ����ϡ��ֱ������ֿ�ζ�Ĺ���
//���̳�Dessert���󣬿��ȼ̳�coffee��������
//���ֿ�ζ����������㹤���Ľӿڣ��ֱ���Դ������Ⱥ�������
//���ض�Ӧ��ͬһ���Ʒʱ��ֻ����ø���Ĺ����࣬����Ҫ�޸��������ࡣ
//������������һ�����໥�����������ϵʱ-----����
//
public class Client {
    public static void main(String[] args) {
    	//�����������ζ��ζ��������
    	AmericanDessertFactory Americanfactory = new AmericanDessertFactory();
    	//��ȡ��Ʒ
    	coffee coffee = Americanfactory.createCoffee();
    	Dessert dessert = Americanfactory.createDessert();
    	System.out.println(coffee.getName());  //������ʾ���֣���Ϊ�̳г������͵Ļ�ȡ��Ʒ���ֵķ���
    	dessert.show();                          //����show������ʾ��� ��show����Ϊ�̳г������͵ķ���
    }
}
