package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.entity.User;
import cn.tulingxueyuan.service.IUserService;
import cn.tulingxueyuan.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class SpringTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext ioc=new ClassPathXmlApplicationContext("classpath:/spring.xml");
        IUserService bean = (IUserService) ioc.getBean(IUserService.class);
        bean.select(null);
        // 在没有使用aop的情况下 ：class cn.tulingxueyuan.service.impl.UserServiceImpl
        // 当使用了aop的情况下：
        // class com.sun.proxy.$Proxy19
        //      jdk代理所产生的一个动态代理类，当被代理的类实现了接口会默认使用jdk代理
        //class cn.tulingxueyuan.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$f281cf64
        //      cglib代理所所产生的一个动态代理类，当被代理的类没有实现接口就会使用cglib代理


    }
}
