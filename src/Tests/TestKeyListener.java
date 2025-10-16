package Tests;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestKeyListener extends JFrame implements KeyListener {

    public TestKeyListener() {
        initFrame();
        this.addKeyListener(this);
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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed:"+e.getKeyChar() ); // 按住
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased:"+e.getKeyChar());//松开
    }
}
