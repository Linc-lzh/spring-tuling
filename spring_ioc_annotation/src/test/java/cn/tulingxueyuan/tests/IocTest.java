package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.beans.Role;
import cn.tulingxueyuan.beans.User;
import cn.tulingxueyuan.controller.UserController;
import cn.tulingxueyuan.service.RoleService;
import cn.tulingxueyuan.service.UserService;
import cn.tulingxueyuan.service.impl.RoleServiceImpl;
import cn.tulingxueyuan.service.impl.UserServiceImpl;
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
        ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");
    }

    @Test
    public void test01() {
        UserController userController = (UserController) ioc.getBean("userController");
        System.out.println(userController);
    }

    @Test
    public void test02() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test03() {
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void test04() {

        Role bean = ioc.getBean(Role.class);
        Role bean2 = ioc.getBean(Role.class);
        Role bean3 = ioc.getBean(Role.class);
    }

    @Test
    public void test05() {

        Role bean = ioc.getBean(Role.class);
        ioc.close();
    }


    @Test
    public void test06() {

        UserService bean = ioc.getBean(UserService.class);
        System.out.println(bean.getClass());


        RoleServiceImpl roleService=new RoleServiceImpl();
        // instanceof  用户判断前面的对象是否是否吗的类，或者子类，或者接口
        if(roleService instanceof  RoleService)
        {
            System.out.println("OK");
            //RETURN
        }


    }
}
