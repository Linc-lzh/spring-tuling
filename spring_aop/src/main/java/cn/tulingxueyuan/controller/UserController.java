package cn.tulingxueyuan.controller;


import cn.tulingxueyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
public class UserController {


    @Autowired
     UserService userService;

    public void get(){

        userService.get(1);
    }
}
