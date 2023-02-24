import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class musicpointer {
    private Frame f;
    private Button bt;
    private TextArea tf;
    private TextField tf1;

    musicpointer() {
        madeFrame();
    }

    // click on login in and then use key "space" to generate
    public void madeFrame() {
        f = new Frame("FRAME");
        f.setBounds(300, 300, 600, 500);// 对框架的位置和大小进行设置
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));// 设计布局
        f.setBackground(Color.BLACK);// background

        bt = new Button("Click here once");
        // text area
        tf = new TextArea();
        tf.setBounds(200, 300, 200, 200);
        Font font = new Font("Microsoft YaHei", Font.BOLD, 17);
        tf.setFont(font);
        tf.setForeground(Color.black);
        // text field (tips)
        tf1 = new TextField("SPACE for tone / ENTER for chord", 40);
        tf1.setEditable(false);
        // frame
        f.add(tf);
        f.add(bt);
        f.add(tf1);
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
                        l = l + n + "\n";
                        tf.setText(l);
                    }
                    System.out.println("-------------------------------------------------------------------");
                }
                // --------------------------------------------------------------------------------------------------------------------
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String l = "";
                    for (int i = 0; i < 10; i++) {
                        int t = getrn(1, 10);
                        String n = chord(t);
                        System.out.println(n);
                        l = l + n + "\n";
                        tf.setText(l);
                    }
                    System.out.println("-------------------------------------------------------------------");
                }
            }

        });
    }

    public String chord(int n) {
        String result = null;
        if (n == 1) {
            result = "C  -- (21)(42)(53)";
        }
        if (n == 2) {
            result = "A  -- (22)(32)(42)";
        }
        if (n == 3) {
            result = "G  -- (52)(63)(13)";
        }
        if (n == 4) {
            result = "E  -- (31)(52)(42)";
        }
        if (n == 5) {
            result = "D  -- (32)(23)(12)";
        }
        if (n == 6) {
            result = "Am -- (21)(42)(32)";
        }
        if (n == 7) {
            result = "Em -- (52)(42)";
        }
        if (n == 8) {
            result = "Dm -- (32)(23)";
        }
        if (n == 9) {
            result = "F  -- (——>1)(32)(43)(53)";
        }
        return result;
    }

    public String translate(int n) {
        String result = null;
        if (n == 1) {
            result = "do  -- 5 3";
        }
        if (n == 2) {
            result = "ri  -- 4 0";
        }
        if (n == 3) {
            result = "mi  -- 4 2";
        }
        if (n == 4) {
            result = "fa  -- 4 3";
        }
        if (n == 5) {
            result = "so  -- 3 0";
        }
        if (n == 6) {
            result = "la  -- 3 2";
        }
        if (n == 7) {
            result = "xi  -- 2 0";
        }
        if (n == 8) {
            result = "do+ -- 2 1";
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
