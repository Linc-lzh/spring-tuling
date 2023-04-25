package cn.tulingxueyuan.proxy.statically;

import org.junit.Test;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class MainTest  {

    @Test
    public void test(){
        IGamePlayer gamePlayer=new GameProxyPlayer("徐庶");

        gamePlayer.start();
        gamePlayer.play();
    }
}
