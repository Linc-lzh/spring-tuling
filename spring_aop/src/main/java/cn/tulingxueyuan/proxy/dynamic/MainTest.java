package cn.tulingxueyuan.proxy.dynamic;

import cn.tulingxueyuan.proxy.statically.GamePlayer;
import cn.tulingxueyuan.proxy.statically.IGamePlayer;
import jdk.nashorn.internal.ir.ReturnNode;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 使用jdk动态代理完成增加日志功能:动态生成代理类
 */
public class MainTest {

    @Test
    public void test(){

        /*
        * ClassLoader loader 类加载器  ，通常指定的被代理类的接口的类加载器
        * Class<?>[] interfaces, 类型， 通常指定被来历类的接口的类型
           InvocationHandler h   委托执行的处理类 ：日志功能
        * */
        ICalculator proxy = (ICalculator) MainTest.createProxy(new Calculator());
        proxy.div(1,0);
    }

    /**
     * 公共jdk动态代理对象生成
     * @return
     */
    public  static Object createProxy(Object needProxy){

        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        Class<?>[] interfaces= needProxy.getClass().getInterfaces();

        // 传入被代理的对象
        InvocationHandler handler=new MyInvocationHandler(needProxy);

        // 动态创建代理类
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());

        return o;
    }
}
