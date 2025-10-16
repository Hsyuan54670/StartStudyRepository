package Tests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//使用接口实现法来写动作监听
public class TestActionListener2 extends JFrame implements ActionListener {
    JButton jbt1 = new JButton("Yes");
    JButton jbt2 = new JButton("No");
    public TestActionListener2() {
        initFrame();

        jbt1.setBounds(0,0,100, 50);
        jbt1.addActionListener(this);
        jbt2.setBounds(100,0,100, 50);
        jbt2.addActionListener(this);
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==jbt1){
            jbt1.setSize(jbt1.getWidth()*3/2,jbt1.getHeight()*3/2);
        }else if(source==jbt2){
            Random rand = new Random();
            jbt2.setLocation(rand.nextInt(500),rand.nextInt(500));
            jbt2.setSize(jbt2.getWidth()*2/3,jbt2.getHeight()*2/3);
            //jbt2.setBounds(rand.nextInt(500),rand.nextInt(500),jbt2.getWidth()*2/3,jbt2.getHeight()*2/3);
        }
    }
}
