package cn.tulingxueyuan.service.impl;

import cn.tulingxueyuan.beans.User;
import cn.tulingxueyuan.dao.UserDao;
import cn.tulingxueyuan.service.RoleService;
import cn.tulingxueyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public User get(Integer id) {
        System.out.println("查询User");
        return userDao.get(id);
    }

    public void add(User user) {
        System.out.println("添加User");
        userDao.add(user);
    }

    public void delete(Integer id) {
        System.out.println("删除User");
        userDao.delete(id);

    }

    public void update(User user) {
        System.out.println("修改User");
        userDao.update(user);
    }
}
