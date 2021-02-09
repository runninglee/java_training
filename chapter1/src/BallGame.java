import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {

    //添加小球和桌面图片的路径
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    //指定小球的初始位置
    double x = 100;   //小球的横坐标
    double y = 100;   //小球的纵坐标
    boolean right = true;
    double degree = 3.14 / 3;

    //画窗口的方法: 加载小球和桌面
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);
        //根据角度 degree 改变小球坐标
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
        //边界检测:碰到上下边界
        //500是窗口的高度; 40 是桌子边框, 30 是小球直径, 最后一个 40 是标题栏的高度
        if (y > 500 - 40 - 30 || y < 40 + 40) {
            degree = -degree;
        }
        //边界检测: 碰到左右边界
        //856 是窗口宽度,40 是桌子边框的高度,30 是小球的直径
        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
    }

    //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        //重置窗口,每 25 画一次
        while (true) {
            repaint();
            try {
                Thread.sleep(40);  //大约一秒画 25 次
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("我是李辉, 这是我的 Java 体验课");
        BallGame game = new BallGame();
        game.launchFrame();
    }

}
