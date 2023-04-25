package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.beans.Person;
import cn.tulingxueyuan.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 * spring ioc 基于xml  基本使用
 */
public class IoCTest {

    ApplicationContext ioc;
    @Before
    public void before(){
        // 加载spring容器
        //ApplicationContext spring的顶层核心接口
        // ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        // FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器
        // AnnotationConfigApplicationContext 根据javaconfig 来配置实例化spring容器
        // 在容器实例化的时候 就会加载所有的bean
        ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
    }

    @Test
    public  void test01(){
        System.out.println("Spring容器已加载");
        // 获取bean
        // 1.通过类来获取bean    getBean(User.class)
        // 2. 通过bean的名字或者id来获取Bean   (User) ioc.getBean("user");
        // 3. 通过名字+类型
        User bean =  ioc.getBean("user",User.class);

        System.out.println(bean);

    }

    /**
     * 通过别名来获取bean
     */
    @Test
    public void test02(){
        User bean =  ioc.getBean("tulingxueyuan",User.class);

        System.out.println(bean);
    }

    /**
     * 基于setter方法的依赖注入
     */
    @Test
    public void test03(){
        User bean =  ioc.getBean("user6",User.class);

        System.out.println(bean);
    }


    /**
     * 基于构造函数的依赖注入
     */
    @Test
    public void test04(){
        User bean =  ioc.getBean("user7",User.class);

        System.out.println(bean);
    }


    /**
     * 复杂数据类型的依赖注入
     */
    @Test
    public void test05(){
        Person bean =  ioc.getBean("person", Person.class);

        System.out.println(bean);
    }

    /**
     *  使用p命名空间简化基于setter属性注入XML配置
     */
    @Test
    public void test06(){
        Person bean =  ioc.getBean("person2", Person.class);

        System.out.println(bean);
    }


}
