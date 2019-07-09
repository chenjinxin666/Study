package 反射.案例;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//通过配置文件运行类中的方法
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //创建Properties，把week.properties里面的内容加载到属性集合中
        Properties properties = new Properties();
        try(Reader reader = new FileReader("C:\\Users\\YEYILING\\Desktop\\MyStudy\\JavaSE\\反射\\案例\\week.properties");) {
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //取出类名和方法名
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //获取对应类的字节码文件对象
        Class<?> aClass = Class.forName(className);
        //获取方法对象
        Method method = aClass.getDeclaredMethod(methodName);
        //取消java语法检查
        method.setAccessible(true);
        //调用方法
        method.invoke(aClass.newInstance());
    }
}
