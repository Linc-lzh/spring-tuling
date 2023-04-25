package cn.tulingxueyuan.dao;

import cn.tulingxueyuan.beans.Role;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface RoleDao {

    Role get(Integer id);

    void add(Role role);

    void delete(Integer id);

    void update(Role role);
}
