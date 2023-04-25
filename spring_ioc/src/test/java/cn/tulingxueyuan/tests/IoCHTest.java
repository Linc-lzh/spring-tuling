package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.beans.Person;
import cn.tulingxueyuan.beans.User;
import cn.tulingxueyuan.beans.Wife;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.SQLException;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 * spring ioc 基于xml  高级使用
 */
public class IoCHTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        // 加载spring容器
        //ApplicationContext spring的顶层核心接口
        // ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        // FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器
        // AnnotationConfigApplicationContext 根据javaconfig 来配置实例化spring容器
        // 在容器实例化的时候 就会加载所有的bean
        ioc=new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    @Test
    public  void test01() {
        System.out.println("Spring已加载");
    }

    /**
     * 懒加载
     */
    @Test
    public  void test02() {
        System.out.println("Spring已加载");
        Wife wife = ioc.getBean("wife", Wife.class);
        System.out.println(wife);

    }
    /**
     * 作用域
     */
    @Test
    public  void test03() {
        Person person1 = ioc.getBean("person", Person.class); //new Person()
        Person person2 = ioc.getBean("person", Person.class); //new Person()
        System.out.println(person1);

    }

    /**
     *  使用静态工厂方法实例化
     */
    @Test
    public  void test04() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);

    }

    /**
     *  使用实例工厂方法实例化
     */
    @Test
    public  void test05() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);

    }


    /**
     *  自动注入
     */
    @Test
    public  void test06() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);

    }

    /**
     *  生命周期回调
     *  1. 使用接口的方式实现：
     *      1.初始化回调   实现InitializingBean   重写afterPropertiesSet
     *      2.销毁回调     实现DisposableBean   重写destroy
     *  2. 基于配置的方式实现
     */
    @Test
    public  void test07() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);
        ioc.close();
    }

    /**
     * 引用第三方bean  和 引用外部属性资源文件
     */
    @Test
    public  void test08() {
        DruidDataSource datasource = ioc.getBean("dataSource", DruidDataSource.class);
        System.out.println(datasource);
        ioc.close();
    }


    /**
     * SpEL
     */
    @Test
    public  void test09() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);
    }
}
