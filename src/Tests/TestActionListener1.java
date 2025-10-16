package Tests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//使用匿名内部类进行动作监听对象的行为的重写
public class TestActionListener1 extends JFrame {
    public TestActionListener1() {
        initFrame();
        JButton jbt = new JButton("Click Me");
        jbt.setSize(100, 200);

        jbt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jbt.setSize(300,300);
            }
        });
        this.getContentPane().add(jbt);
    }
    private void initFrame(){
        //设置界面标题
        this.setTitle("TestActionListener");

        //设置界面宽高
        this.setSize(608,650);

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        // 取消默认的居中放置,组件才会按照设置的x，y放置。
        this.setLayout(null);

        //设置关闭模式
        this.setDefaultCloseOperation(3);


        this.setVisible(true);
    }

}
