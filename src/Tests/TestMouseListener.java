package Tests;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestMouseListener extends JFrame implements MouseListener {

    JFrame jFrame=new JFrame();
    JButton jbt = new JButton("Test");
    public TestMouseListener() {
        initFrame();
        jbt.setBounds(0,0,200,300);
        jbt.addMouseListener(this);
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
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked"); //单击
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed"); //按住
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");//松开
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered"); //滑入
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");//滑出

    }
}
