package cn.tulingxueyuan.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Aspect
@Component
public class LogUtil {


    // 前置通知
    @Before("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void before(){
       /* System.out.println(method.getName()+"方法运行前，参数是"+
                (args==null?"": Arrays.asList(args).toString()));*/

        System.out.println("方法前");
    }

    // 后置通知
    @After("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void after(){
       /* System.out.println(method.getName() +"方法运行后，参数是"+
                (args==null?"": Arrays.asList(args).toString()));*/
        System.out.println("方法后");
    }

    // 后置异常通知
    @AfterThrowing("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterException(){
       // System.out.println("方法报错了:"+ex.getMessage());

        System.out.println("方法异常");
    }

    // 后置返回通知
    @AfterReturning("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterEnd(){
        //System.out.println("方法结束，返回值是:"+returnValue);
        System.out.println("方法返回");

    }
}
