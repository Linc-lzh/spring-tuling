package cn.tulingxueyuan.proxy.dynamic;

import cn.tulingxueyuan.aspect.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class MyInvocationHandler implements InvocationHandler {

    // 被代理的对象
    Object target;

    public MyInvocationHandler( Object target) {
        this.target=target;
    }

    // 代理类的执行方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result=null;
        try {
            //LogUtil.before(method,args);
            result = method.invoke(target, args);
            //LogUtil.after(method,args);
        }
        catch (Exception ex){
            //LogUtil.afterException(ex);
        }
        finally {
            //LogUtil.afterEnd(result);
        }

        return result;
    }
}
