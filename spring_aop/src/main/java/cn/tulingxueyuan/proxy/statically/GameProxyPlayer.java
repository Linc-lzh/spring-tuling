package cn.tulingxueyuan.proxy.statically;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 代练
 */
public class GameProxyPlayer implements IGamePlayer{

    private String name;
    private GamePlayer gamePlayer;

    public GameProxyPlayer(String name) {
        this.name=name;
        this.gamePlayer=new GamePlayer(name);
    }

    public void start() {
        System.out.println("拿到"+name+"用户名，密码");
        gamePlayer.start();
    }

    public void play() {
        System.out.println("代理击杀了曹贼玩家，赢得了游戏");
    }
}
