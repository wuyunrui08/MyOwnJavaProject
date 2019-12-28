package MyDigitalHuarongRoad;
import java.awt.*;
import java.sql.Time;
import javax.swing.*;
public class Display extends JFrame{

    int sideX,sideY;//x,y相隔的位置
    int maxX, maxY;
    int whiteID=15;

    boolean ifStart=false;
    JButton []inSideButton;//滑块
    JButton exitButton, startButton,versionButton;//按键

    final int WIDTHS =550;//宽度
    final int HEIGHTS =550;//长度

    Display(){

        //实体化变量
        JPanel centerPanel = new JPanel();
        //容器
        JPanel belowPanel = new JPanel();
        //边界管理器
        GridLayout gg = new GridLayout();

        //菜单
        versionButton=new JButton("Version");
        exitButton=new JButton("Exit");
        startButton =new JButton("Start");
        inSideButton=new JButton[16];

        for(int i=0;i<16;i++){
            inSideButton[i] = new JButton();//申请按键
            inSideButton[i].setFont(new Font("微软雅黑",Font.BOLD,20));
        }
        //应该随机化按钮的数字

        for(int i=0;i<15;i++) {
            inSideButton[i].setText("(^_^)");//设置标题
        }

        //添加到容器并且添加事件处理
        for(int i=0;i<16;i++){
            inSideButton[i].setBackground(Color.white);
            centerPanel.add(inSideButton[i]);
            inSideButton[i].addActionListener(new DisplayAction(this));
        }

        exitButton.addActionListener(new DisplayAction(this));
        startButton.addActionListener(new DisplayAction(this));

        //设计微小布局

        belowPanel.add(startButton);
        belowPanel.add(exitButton);
        //belowPanel.add(versionButton);
        gg.setColumns(4);
        gg.setRows(4);

        centerPanel.setLayout(gg);//中心容器的布局
        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Help");
        JMenuItem item1=new JMenuItem("Easy going");
        JMenuItem item2=new JMenuItem("Version");
        menu.add(item1);
        menu.add(item2);
        menuBar.add(menu);
        item1.addActionListener(new MenuBarAction(this));
        item2.addActionListener(new MenuBarAction(this));

        add(menuBar,BorderLayout.NORTH);
        //添加布局
        add(centerPanel,BorderLayout.CENTER);
        add(belowPanel,BorderLayout.SOUTH);


        //设计总体布局
        setBounds(200,100, WIDTHS, HEIGHTS);//设置界限大小
        setResizable(false);//设置不可更改窗口
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //计算两个按钮之间的距离
        sideX=inSideButton[0].getWidth();
        sideY=inSideButton[0].getHeight();

        maxX = centerPanel.getWidth();//容器的长度
        maxY = centerPanel.getHeight();//容器的高度




    }

}

/*
    做一个华容道游戏
    每点击一下可以移动
    数字华容道
    十五个数字

    底部有重新开始，退出游戏的操作

    网格布局，4*4，十五个按钮

    ▲ 每点击一下便可以进行移动，怎么样移动？？？

 */
