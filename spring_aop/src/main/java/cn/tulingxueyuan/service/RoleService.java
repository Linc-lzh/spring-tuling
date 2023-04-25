package cn.tulingxueyuan.service;


import cn.tulingxueyuan.beans.Role;
import org.springframework.stereotype.Component;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface RoleService {

    Role get(Integer id);

    void add(Role role);

    void delete(Integer id);

    void update(Role role);
}
