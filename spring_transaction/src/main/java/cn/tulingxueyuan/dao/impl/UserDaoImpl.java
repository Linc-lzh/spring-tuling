package cn.tulingxueyuan.dao.impl;

import cn.tulingxueyuan.dao.IUserDao;
import cn.tulingxueyuan.entity.User;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Repository
public class UserDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DruidDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser(){
        return jdbcTemplate.queryForObject("select * from t_user where id=1",new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 张三扣钱
     * 扣钱
     */
    @Override
    public void sub() {
        jdbcTemplate.update("update t_user set balance=balance-200 where id=1");
    }

    /**
     * 李四加钱
     */
    @Override
    public void save() {
        jdbcTemplate.update("update t_user set balance=balance+200 where id=2");
    }


}
