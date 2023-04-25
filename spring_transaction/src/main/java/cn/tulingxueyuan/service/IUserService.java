package cn.tulingxueyuan.service;

import cn.tulingxueyuan.entity.User;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface IUserService {
    User getUser();

    void trans();

    void sub();

    void tranException() throws Exception;
}
