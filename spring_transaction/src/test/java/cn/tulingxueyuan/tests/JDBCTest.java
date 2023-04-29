package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.entity.User;
import cn.tulingxueyuan.service.IUserService;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class JDBCTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public  void before(){
        ioc=new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void test01(){
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean);

    }

    /**
     * JdbcTemplate演示
     */
    @Test
    public void test02(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        System.out.println(aLong);
    }

    /**
     * 查询单个值
     */
    @Test
    public void test03(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 查询单个值
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        System.out.println(aLong);
    }

    /**
     * 查询实体
     */
    @Test
    public void test04(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        User user = jdbcTemplate.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));


        /*User user = jdbcTemplate.queryForObject("select * from t_user where id=1",
                (resultSet, i) -> {
                    User o=new User();
                    o.setId(resultSet.getInt("id"));
                    o.setRealname(resultSet.getString("realname"));
                    return o;
                });*/
        System.out.println(user);
    }


    /**
     * 查询List<实体>
     */
    @Test
    public void test05(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        List<User> user = jdbcTemplate.query("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));


        /*User user = jdbcTemplate.queryForObject("select * from t_user where id=1",
                (resultSet, i) -> {
                    User o=new User();
                    o.setId(resultSet.getInt("id"));
                    o.setRealname(resultSet.getString("realname"));
                    return o;
                });*/
        System.out.println(user);
    }

    /**
     * 新增
     */
    @Test
    public void test06(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        int result =
                jdbcTemplate.update("insert into t_user(realname,cardno,balance) values (?,?,?)",
                        "王麻子","12345677",800);

        System.out.println(result);
    }

    /**
     * 修改
     */
    @Test
    public void test07(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        int result =
                jdbcTemplate.update("update t_user set balance=balance+200 where id=?",
                        2);

        System.out.println(result);
    }
    /**
     * 删除
     */
    @Test
    public void test08(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        int result =
                jdbcTemplate.update("delete from t_user where id=?",
                        2);

        System.out.println(result);
    }


    /**
     * 具名参数处理NamedParameterJdbcTemplate
     */
    @Test
    public void test09(){
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        Map<String,Object> map=new HashMap<>();
        map.put("id",4);

        // 数据库字段名和属性名一样 利用BeanPropertyRowMapper
        int result =
                jdbcTemplate.update("delete from t_user where id=:id",map);

        System.out.println(result);
    }


    @Test
    public void test10(){
        IUserService service = ioc.getBean(IUserService.class);

        System.out.println(service.getUser());
    }
}
