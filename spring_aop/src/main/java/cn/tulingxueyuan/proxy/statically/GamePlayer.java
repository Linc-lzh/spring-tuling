package cn.tulingxueyuan.proxy.statically;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class GamePlayer implements  IGamePlayer {
    // 玩家名称
    private String name="";

    public GamePlayer(String name) {
        this.name = name;
    }

    // 登录了游戏
    public void start(){
        System.out.println("登录游戏...");
        System.out.println(name+"开始了游戏");
        this.name=name;
    }
    // 打怪
    public void play()
    {
        System.out.println(name+"被曹贼玩家击杀了");
    }
}
