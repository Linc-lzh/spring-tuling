package cn.tulingxueyuan.service.impl;

import cn.tulingxueyuan.beans.Role;
import cn.tulingxueyuan.dao.RoleDao;
import cn.tulingxueyuan.dao.UserDao;
import cn.tulingxueyuan.service.RoleService;
import cn.tulingxueyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    RoleDao roleDao;

    public Role get(Integer id) {
        System.out.println("查询Role");
        return roleDao.get(id);
    }

    public void add(Role role) {
        System.out.println("添加Role");
        roleDao.add(role);
    }

    public void delete(Integer id) {
        System.out.println("删除Role");
        roleDao.delete(id);

    }

    public void update(Role role) {
        System.out.println("修改Role");
        roleDao.update(role);
    }
}
