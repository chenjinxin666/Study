package 反射;

public class Person {
    public String name;
    protected int age;
    char sex;
    private String address;

    public Person() {
        System.out.println("空参的构造方法");
    }

    public Person(String name) {
        System.out.println("一个参数的构造方法");
        this.name = name;
    }

    protected Person(String name, int age) {
        System.out.println("二个参数的构造方法");
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, char sex) {
        System.out.println("三个参数的构造方法");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private Person(String name, int age, char sex, String address) {
        System.out.println("四个参数的构造方法");
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public void show(Object obj) {
        System.out.println(obj);
    }

    protected int getSum(int a, int b) {
        return a + b;
    }

    String concat(String start, String end) {
        return start + end;
    }

    private void method() {
        System.out.println("哈哈哈");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address + "]";
    }
}

