package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.service.RoleService;
import cn.tulingxueyuan.service.UserService;
import cn.tulingxueyuan.service.impl.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class IocTest {
    ClassPathXmlApplicationContext ioc;

    @Before
    public void before() {
        ioc = new ClassPathXmlApplicationContext("classpath:/spring_aop.xml");
    }

    @Test
    public void test01() {
        RoleService bean = ioc.getBean(RoleService.class);
        System.out.println(bean.getClass());
        bean.get(1);

    }

}
