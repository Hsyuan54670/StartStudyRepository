package com.xx.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class LoginJFrameV1 extends JFrame implements MouseListener, ActionListener {
    JLabel yzm =new JLabel(productYzm());
    JButton yzmButton =new JButton();
    JButton loginButton =new JButton();
    JButton registerButton =new JButton();
    String addressLocation="jigsawgame\\image\\login\\";
    JLabel loginLabel =new JLabel(new ImageIcon(addressLocation + "登录按钮.png"));
    JLabel registerLabel =new JLabel(new ImageIcon(addressLocation + "注册按钮.png"));
    JLabel background =new JLabel(new ImageIcon(addressLocation + "background.png"));
    JLabel loginLabeling =new JLabel(new ImageIcon(addressLocation + "登录按下.png"));
    JLabel registerLabeling = new JLabel(new ImageIcon(addressLocation + "注册按下.png"));
    public LoginJFrameV1() {
        //初始化界面
        initJFrame();

        //初始化基本ui界面
        initUI();

        //设置显示,该条语句不要放进页面初始化里面
        this.setVisible(true);
    }
    private String productYzm(){
        StringBuilder yzm = new StringBuilder();
        Random rand=new Random();
        for(int i=0;i<4;i++) {
            switch (rand.nextInt(3)) {
                case 0: {
                    yzm.append((char)('a' + rand.nextInt(26)));
                    break;
                }
                case 1: {
                    yzm.append((char)('A' + rand.nextInt(26)));
                    break;
                }
                case 2: {
                    yzm.append((char)('0' + rand.nextInt(10)));
                    break;
                }
                default:
                    break;
            }
        }
        return yzm.toString();
    }
    private void initUI() {

        JLabel usernameLabel = new JLabel(new ImageIcon(addressLocation + "用户名.png"));
        JTextField usernameField = new JTextField();
        usernameField.setBounds(120,100,200,20);
        JLabel passwordLabel = new JLabel(new ImageIcon(addressLocation + "密码.png"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120,150,200,20);
        JLabel yzmLabel = new JLabel(new ImageIcon(addressLocation + "验证码.png"));
        yzmButton.setBounds(300,200,40,20);
        yzm.setBounds(300,200,40,20);
        JTextField YZMField = new JTextField();
        YZMField.setBounds(120,200,150,20);
        yzmButton.setBorderPainted(false);   //去掉按钮边框
        yzmButton.setContentAreaFilled(false); //去掉按钮默认背景
        loginButton.setBounds(100,250,128,47);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.addMouseListener(this);
        registerButton.setBounds(240,250,128,47);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.addMouseListener(this);
        yzmButton.addActionListener(this);
        usernameLabel.setBounds(60, 100, 47, 17);
        passwordLabel.setBounds(60, 150, 32, 16);
        yzmLabel.setBounds(60, 200,56, 21);



        loginLabel.setBounds(100, 250, 128, 47);
        registerLabel.setBounds(240, 250, 128, 47);


        background.setBounds(0, 0, 470, 390);

        this.getContentPane().add(usernameLabel);
        this.getContentPane().add(passwordLabel);
        this.getContentPane().add(yzmLabel);
        this.getContentPane().add(yzm);
        this.getContentPane().add(usernameField);
        this.getContentPane().add(passwordField);
        this.getContentPane().add(YZMField);
        this.getContentPane().add(loginLabel);
        this.getContentPane().add(registerLabel);
        this.getContentPane().add(background);
        this.getContentPane().add(yzmButton);
        this.getContentPane().add(loginButton);
        this.getContentPane().add(registerButton);



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

        //设置x,y模式
        this.setLayout(null);

        //设置关闭模式
        this.setDefaultCloseOperation(3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == yzmButton) {
            yzm.setText(productYzm());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == loginButton) {
            //登录信息匹配
        }else if (source == registerButton) {
            this.setVisible(false);
            new RegisterJFrame();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        this.getContentPane().remove(background);
        if(e.getSource() == loginButton) {
            loginLabeling.setBounds(100, 250, 128, 47);
            this.getContentPane().add(loginLabeling);
            this.getContentPane().remove(loginLabel);
        }else if(e.getSource() == registerButton) {
            registerLabeling.setBounds(240, 250, 128, 47);
            this.getContentPane().add(registerLabeling);
            this.getContentPane().remove(registerLabel);
        }
        this.getContentPane().add(background);
        this.getContentPane().repaint();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        this.getContentPane().remove(background);
        if(e.getSource()==loginButton) {
            this.getContentPane().add(loginLabel);
            this.getContentPane().remove(loginLabeling);
        }else if(e.getSource()==registerButton){
            this.getContentPane().add(registerLabel);
            this.getContentPane().remove(registerLabeling);
        }
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }
}
