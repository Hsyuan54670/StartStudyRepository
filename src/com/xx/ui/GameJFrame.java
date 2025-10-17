package com.xx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    private static int countMove = 0;
    private final int[] arr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    private String locateImage="";
    //创建菜单条目
    private JMenuItem animalItem = new JMenuItem("Animal");
    private JMenuItem girlItem = new JMenuItem("Girl");
    private JMenuItem sportItem = new JMenuItem("Sport");

    private JMenuItem rePlayItem = new JMenuItem("Replay"); //重新开始
    private JMenuItem reLoginItem = new JMenuItem("ReLogin");//重新登录
    private JMenuItem exitItem = new JMenuItem("Exit");//退出游戏

    private JMenuItem accountItem = new JMenuItem("Account"); //关于我们
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化图片数组
        initArr();

        //初始化选择图片
        initImage(null);

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
    private void initImage(Integer kindOf) {
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
        if(kindOf==null) {
            kindOf=rand.nextInt(3);
        }
        switch (kindOf) {
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
    /*
    //重载方法，用于用户主动更换图片
    private void initImage(int kindOf) {

        //生成随机打乱的图片
        Random rand = new Random();
        rand.nextInt(3);
        String kind = "";
        final int ANIMAL_NUMBER = 8;
        final int GIRL_NUMBER = 13;
        final int SPORT_NUMBER = 10;
        switch (kindOf) {
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
        ///
    }
    */
    private void showImage() {
        this.getContentPane().removeAll();   //清空内容
        //加载内容
        //显示计数器
        JLabel countLabel=new JLabel("步数："+countMove);
        countLabel.setBounds(50,10,100,50);
        this.getContentPane().add(countLabel);
        //判断是否胜利
        if(isWin()){
            //显示胜利图标
            JLabel winLabel = new JLabel(new ImageIcon("jigsawgame\\image\\win.png"));
            winLabel.setBounds(400, 5, winLabel.getPreferredSize().width, winLabel.getPreferredSize().height);
            this.getContentPane().add(winLabel);
            //关闭键盘监听
            this.removeKeyListener(this);
        }
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

        this.getContentPane().repaint();   //重写内容
    }


    private void initJMenuBar() {

        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单选项
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutJMenu = new JMenu("About");
        JMenu changeItem = new JMenu("ChangeImage"); //更换图片

        //组合菜单条目
        functionJMenu.add(changeItem);
        changeItem.add(animalItem);
        changeItem.add(girlItem);
        changeItem.add(sportItem);

        functionJMenu.add(rePlayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(exitItem);
        //添加动作监听
        rePlayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        exitItem.addActionListener(this);
        accountItem.addActionListener(this);
        animalItem.addActionListener(this);
        girlItem.addActionListener(this);
        sportItem.addActionListener(this);

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
                countMove++;
            }else{
                System.out.println("非法移动!");
            }
        }else if(e.getKeyCode()==38){
            if(indexZero>=12) {
                System.out.println("非法移动!");
            }else {
                arr[indexZero]=arr[indexZero+4];
                arr[indexZero+4]=0;
                countMove++;
            }
        }else if(e.getKeyCode()==39){
            if(indexZero%4==0) {
                System.out.println("非法移动!");
            }else {
                arr[indexZero]=arr[indexZero-1];
                arr[indexZero-1]=0;
                countMove++;
            }
        }else if(e.getKeyCode()==37){
            if(indexZero%4==3) {
                System.out.println("非法移动!");
            }else{
                arr[indexZero]=arr[indexZero+1];
                arr[indexZero+1]=0;
                countMove++;
            }
        }else if(e.getKeyChar()=='w'){
            //w键一键作弊，直接胜利.
            Random rand = new Random();
            countMove=rand.nextInt(countMove,countMove+20);
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
        showImage();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==rePlayItem){
            countMove=0;
            initArr();
            showImage();
        }else if(source==reLoginItem){
            //重新登录
            this.setVisible(false);
            new LoginJFrame();
        }else if(source==exitItem){
            System.exit(0);
        }else if(source==accountItem){
            showMyQR();
        }else if(source==girlItem)
        {
            initImage(1);
            showImage();
        }else if(source==sportItem){
            initImage(2);
            showImage();
        }else if(source==animalItem){
            initImage(0);
            showImage();
        }
    }
    //展示我的二维码

    //ps:创建图像对象后，往往要记得设置大小后还要添加进上一级的容器中
    private void showMyQR() {
        JDialog qrDialog = new JDialog();
        qrDialog.setTitle("QRCode");
        qrDialog.setSize(350,350);
        qrDialog.setLocationRelativeTo(null); //居中
        qrDialog.setAlwaysOnTop(true);  //置顶显示在上面
        JLabel qrLabel = new JLabel(new ImageIcon("jigsawgame//image//myqr.jpg"));
        qrLabel.setSize(250, 340);
        qrDialog.getContentPane().add(qrLabel);
        qrDialog.setModal(true);  //此页面未关闭时不能操作其他页面
        qrDialog.setVisible(true);
    }
}
