package cn.tulingxueyuan;

import cn.tulingxueyuan.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@ComponentScan
public class SecondJavaConfig {
    @Bean
    public User user2(){
        return new User();
    }
}
