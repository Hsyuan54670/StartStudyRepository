package com.xx.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化图片
        initImage();

        //设置显示界面
        this.setVisible(true);
    }

    private void initImage() {
        /*
        该段注释主要是介绍如何将图片显示的过程
        图片是105*105的
        //创建图片ImageIcon的对象存图片
        ImageIcon icon1 = new ImageIcon("D:\\AForAll\\Java\\Projects\\basic-code\\jigsawgame\\image\\animal\\animal1\\1.jpg");
        //创建JLable对象来进行管理图片（容器）
        JLabel jLabel1 = new JLabel(icon1);
        jLabel1.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
        //this.add(jLabel1);
        this.getContentPane().add(jLabel1);
         */
        Random rand = new Random();
        rand.nextInt(3);
        String kind = "";
        final int ANIMAL_NUMBER = 8;
        final int GIRL_NUMBER = 13;
        final int SPORT_NUMBER = 10;
        switch (rand.nextInt(3)) {
            case 0->kind="animal";
            case 1->kind="girl";
            case 2->kind="sport";
        }
        String kindNumber="";
        switch (kind) {
            case "animal"->kindNumber=kind+String.valueOf(rand.nextInt(ANIMAL_NUMBER)+1);
            case "girl"->kindNumber=kind+String.valueOf(rand.nextInt(GIRL_NUMBER)+1);
            case "sport"->kindNumber=kind+String.valueOf(rand.nextInt(SPORT_NUMBER)+1);
        }
        final String locate="D:\\AForAll\\Java\\Projects\\basic-code\\jigsawgame\\image";
        String locateImage =locate+"\\"+kind+"\\"+kindNumber+"\\";
        /*
        按顺序将图片显示
        for(int i=0;i<15;i++){
            String imageLastNumber=locateImage+String.valueOf(i+1)+".jpg";
            System.out.println(imageLastNumber);
            JLabel jLabel = new JLabel(new ImageIcon(imageLastNumber));
            jLabel.setBounds(i%4*105,i/4*105,105,105);
            this.getContentPane().add(jLabel);
        }
        */
        /*
        随机打乱顺序后显示
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=15;i++){
            list.add(i);
        }
        for(int i=0;i<15;i++){
            int index =rand.nextInt(list.size());
            String imageLastNumber=locateImage+String.valueOf(list.get(index))+".jpg";
            list.remove(index);
            System.out.println(imageLastNumber);
            JLabel jLabel = new JLabel(new ImageIcon(imageLastNumber));
            jLabel.setBounds(i%4*105,i/4*105,105,105);
            this.getContentPane().add(jLabel);
        }
         */
    }


    private void initJMenuBar() {

        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单选项
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutJMenu = new JMenu("About");
        //创建菜单条目
        JMenuItem rePlayItem = new JMenuItem("Replay");
        JMenuItem reLoginItem = new JMenuItem("ReLogin");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem accountItem = new JMenuItem("Account");

        //组合菜单条目
        functionJMenu.add(rePlayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(exitItem);

        aboutJMenu.add(accountItem);

        //组合菜单功能
        jMenuBar.add(functionJMenu);

        jMenuBar.add(aboutJMenu);

        //设置界面菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面标题
        this.setTitle("GameJFrame");

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
    }
}
