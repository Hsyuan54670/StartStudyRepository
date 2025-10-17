package com.xx.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        //初始化界面
        initJFrame();
    }

    private void initJFrame() {
        //设置标题
        this.setTitle("Login");
        //设置宽高
        this.setSize(488,430);
        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //设置显示
        this.setVisible(true);
    }
}
