package 反射.案例;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//反射调用 ArrayList<String> 的 add 方法
public class ReflectTest3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
         * 给定一个 ArrayList<String> 对象，在这个集合中添加一个整型数据
         * 泛型只存在编译时期，编译成字节码文件之后就会消失
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("hahaha");
        System.out.println(list);

        //获取ArrayList的字节码文件对象
        Class<? extends ArrayList> aClass = list.getClass();
        //获取add方法对象
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,1);
        add.invoke(list,2);
        add.invoke(list,3);
        System.out.println(list);
    }
}
