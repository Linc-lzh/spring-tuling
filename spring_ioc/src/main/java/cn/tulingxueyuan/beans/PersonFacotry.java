package cn.tulingxueyuan.beans;

import java.util.Date;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class PersonFacotry {
    public Person createPersonFacotryMethod() {
        Child child = new Child();
        child.setName("儿子");
        return child;
    }

    public static Date getNowDate() {
        return new Date();
    }
}
