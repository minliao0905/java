package Person;

import java.util.*;


public class Person01{

    public static void main(String[] args) {
        // �½�Person����
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);
        Person p4 = new Person("EEE", 100);

        // �½�HashSet����
        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        // �Ƚ�p1 �� p2�� ����ӡ���ǵ�hashCode()
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        // �Ƚ�p1 �� p4�� ����ӡ���ǵ�hashCode()
        System.out.printf("p1.equals(p4) : %s; p1(%d) p4(%d)\n", p1.equals(p4), p1.hashCode(), p4.hashCode());
        // ��ӡset
        System.out.printf("set:%s\n", set);
    }

    /**
     * @desc Person�ࡣ
     */
    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " +age;
        }

        /**
         * @desc��дhashCode
         */
        @Override
        public int hashCode(){
            int nameHash =  name.toUpperCase().hashCode();
            return nameHash ^ age;
        }

        /**
         * @desc ����equals����
         */
        @Override
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }

            //�����ͬһ�����󷵻�true����֮����false
            if(this == obj){
                return true;
            }

            //�ж��Ƿ�������ͬ
            if(this.getClass() != obj.getClass()){
                return false;
            }

            Person person = (Person)obj;
            return name.equals(person.name) && age==person.age;
        }
    }
}