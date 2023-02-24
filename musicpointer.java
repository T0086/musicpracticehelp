import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class musicpointer {
    private Frame f;
    private Button bt;
    private TextField tf;

    musicpointer() {
        madeFrame();
    }

    // click on login in and then use key "space" to generate
    public void madeFrame() {
        f = new Frame("FRAME");

        f.setBounds(300, 300, 600, 500);// 对框架的位置和大小进行设置
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));// 设计布局
        bt = new Button("login");
        tf = new TextField(77);
        f.add(tf);
        f.add(bt);
        myEvent();

        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter()// 窗口监听
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        bt.addKeyListener(new KeyAdapter()// 键盘监听按钮
        {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    String l = "";
                    for (int i = 0; i < 10; i++) {
                        int t = getrn(1, 9);
                        String n = Integer.toString(t) + " - " + translate(t);
                        System.out.println(n);
                        l = l + "\n" + n;
                        tf.setText(l);
                    }
                    System.out.println("-------------------------------------------------------------------");
                }
            }

        });
    }

    public String translate(int n) {
        String result = null;
        if (n == 1) {
            result = "do";
        }
        if (n == 2) {
            result = "ri";
        }
        if (n == 3) {
            result = "mi";
        }
        if (n == 4) {
            result = "fa";
        }
        if (n == 5) {
            result = "so";
        }
        if (n == 6) {
            result = "la";
        }
        if (n == 7) {
            result = "xi";
        }
        if (n == 8) {
            result = "do+";
        }
        return result;
    }

    public int getrn(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] agrs) {
        new musicpointer();

    }
}
/*
 * do 5 3
 * ri 4 0
 * mi 4 2
 * fa 4 3
 * so 3 0
 * la 3 2
 * xi 2 0
 * do+ 2 1
 */
