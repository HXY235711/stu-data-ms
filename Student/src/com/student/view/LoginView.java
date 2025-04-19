package com.student.view;

import com.student.utils.Tools;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    private JFrame frame;
    private final int WIDTH = 500;
    private final int HEIGHT = 280;
    /**
     * 构造方法
     */
    public LoginView() {
        frame = new JFrame();
        initView();

        frame.setTitle("学生信息管理系统");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        Tools.setPos(frame,WIDTH,HEIGHT);
        frame.validate();


    }

    /**
     * 初始化窗口
     */
    private void initView(){
        //创建一个盘子
        JPanel jpanel = new JPanel();
        jpanel.setBounds(0, 0, WIDTH, HEIGHT);
        jpanel.setLayout(null);
        frame.add(jpanel);

        //创建一个标签，使用标签来存储图片
        ImageIcon icon = new ImageIcon("image/1.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, WIDTH, HEIGHT);
        jpanel.add(label);

        //设置两个标签 2个输入框 1标签 1按钮


        jpanel.setBackground(Color.BLUE);
    }


}
