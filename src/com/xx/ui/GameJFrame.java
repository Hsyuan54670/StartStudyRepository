package com.xx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    private final int[] arr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    private String locateImage="";
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化图片数组
        initArr();

        //初始化选择图片
        initImage();

        //显示图片
        showImage();

        //移动图片功能
        moveImage();

        //设置显示界面
        this.setVisible(true);
    }
    //打乱图片顺序
    private void initArr() {
        Random rand = new Random();
        for(int i=0;i<arr.length;i++) {
            int index=rand.nextInt(arr.length);
            int tmp=arr[index];
            arr[index]=arr[i];
            arr[i]=tmp;
        }
    }
    //移动图片
    private void moveImage() {
        this.addKeyListener(this);
    }

    //初始化图片从Image包中随机选一个
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

        //****先加载的图片在上方！！！
        //****先加载的图片在上方！！！
        //****先加载的图片在上方！！！

        //生成随机打乱的图片
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
        final String locate="jigsawgame\\image";      //采用相对路径
        locateImage =locate+"\\"+kind+"\\"+kindNumber+"\\";
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

    }

    private void showImage() {

        for(int i=0;i<=15;i++){
            String imageLastNumber=locateImage+String.valueOf(arr[i])+".jpg";
            //System.out.println(imageLastNumber);
            JLabel jLabel = new JLabel(new ImageIcon(imageLastNumber));
            jLabel.setBounds(i%4*105+83,i/4*105+134,105,105);
            //给每一个图片块添加边框
            //BevelBorder类是斜面边框，有0，1两个值，1是凸起来的，像围墙一样让图片凹下去，0是凹下去的，像水渠，让图片凸起来。
            jLabel.setBorder(new BevelBorder(0));
            this.getContentPane().add(jLabel);
        }

        //显示游戏背景图片
        JLabel backgroundLabel = new JLabel(new ImageIcon("jigsawgame\\image\\background.png"));
        backgroundLabel.setBounds(40, 40, backgroundLabel.getPreferredSize().width, backgroundLabel.getPreferredSize().height);
        this.getContentPane().add(backgroundLabel);
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
        this.setSize(608,680);

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        // 取消默认的居中放置,组件才会按照设置的x，y放置。
        this.setLayout(null);

        //设置关闭模式
        this.setDefaultCloseOperation(3);

    }
    private int returnZeroIndex() {
        int index=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==0) {
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //←37 ↑38 →39 ↓40
        int indexZero=returnZeroIndex();
        if(e.getKeyCode()==40){
            if(indexZero>=4) {
                arr[indexZero]=arr[indexZero-4];
                arr[indexZero-4]=0;
            }else{
                System.out.println("非法移动!");
            }
        }else if(e.getKeyCode()==38){
            if(indexZero>=12) {
                System.out.println("非法移动!");
            }else {
                arr[indexZero]=arr[indexZero+4];
                arr[indexZero+4]=0;
            }
        }else if(e.getKeyCode()==39){
            if(indexZero%4==0) {
                System.out.println("非法移动!");
            }else {
                arr[indexZero]=arr[indexZero-1];
                arr[indexZero-1]=0;
            }
        }else if(e.getKeyCode()==37){
            if(indexZero%4==3) {
                System.out.println("非法移动!");
            }else{
                arr[indexZero]=arr[indexZero+1];
                arr[indexZero+1]=0;
            }
        }else if(e.getKeyChar()=='w'){
            //w键一键作弊，直接胜利.
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                arr[i]=arr[i]+1;
            }
            arr[arr.length-1]=0;
        }else if(e.getKeyChar()=='a'){
            //展示原图
            this.getContentPane().removeAll();
            this.getContentPane().repaint();
            JLabel allLabel = new JLabel(new ImageIcon(locateImage+"all.jpg"));
            allLabel.setBounds(83, 134, allLabel.getPreferredSize().width, allLabel.getPreferredSize().height);
            this.getContentPane().add(allLabel);
            //显示游戏背景图片
            JLabel backgroundLabel = new JLabel(new ImageIcon("jigsawgame\\image\\background.png"));
            backgroundLabel.setBounds(40, 40, backgroundLabel.getPreferredSize().width, backgroundLabel.getPreferredSize().height);
            this.getContentPane().add(backgroundLabel);
        }else{
            //无效果
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //每次操作后判断是否完成拼图
        if(isWin()) {
            //显示胜利图标
            this.getContentPane().removeAll();
            this.getContentPane().repaint();
            JLabel winLabel = new JLabel(new ImageIcon("jigsawgame\\image\\win.png"));
            winLabel.setBounds(400, 5, winLabel.getPreferredSize().width, winLabel.getPreferredSize().height);
            this.getContentPane().add(winLabel);
            showImage();
            //关闭键盘监听
            this.removeKeyListener(this);
        }else {
            //更新内容
            this.getContentPane().removeAll();
            this.getContentPane().repaint();
            showImage();
        }

    }

    //判断是否胜利
    private boolean isWin() {
        boolean win=true;
        for(int i=0;i<arr.length;i++) {
            if(i!=arr.length-1&&arr[i]!=i+1) {
                win=false;
                break;
            }
        }
        return win;
    }


}
