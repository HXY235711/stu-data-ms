package com.student.view;

import com.student.utils.Tools;

import javax.swing.*;
import java.awt.*;

import static java.awt.SystemColor.text;

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


        //设置两个标签 2个输入框 1标签 1按钮
        JLabel  title=new JLabel ("学生信息管理系统");
        title.setBounds(0, 0, WIDTH, 100);
        title.setFont(new Font("宋体",Font.BOLD,28));
        title.setForeground(new Color(112,128,239));

        title.setHorizontalAlignment(SwingConstants.CENTER);

        jpanel.add(title);


        //绘制一个标签 账号 和密码
        JPanel jpanel2 = new JPanel();
        jpanel2.setBounds(0, 100, WIDTH, 30);
        jpanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel.add(jpanel2);
        jpanel2.setOpaque(false);

        JLabel jLabel=new JLabel("账号");
        jpanel2.add(jLabel);
        jLabel.setFont(new Font("华文bai行楷",Font.BOLD,18));
        jLabel.setForeground(new Color(112,128,239));

        JTextField jTextField=new JTextField(20);
        jpanel2.add(jTextField);
        jTextField.setFont(new Font("宋体",Font.PLAIN,18));
        jTextField.setForeground(new Color(224,57,151));





        //绘制一个标签 账号 和密码
        JPanel jpanel22 = new JPanel();
        jpanel22.setBounds(0, 130, WIDTH, 30);
        jpanel22.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel.add(jpanel22);
        jpanel22.setOpaque(false);

        JLabel jLabel2=new JLabel("密码");
        jpanel22.add(jLabel2);
        jLabel2.setFont(new Font("华文bai行楷",Font.BOLD,18));
        jLabel2.setForeground(new Color(112,128,239));


        JPasswordField jPasswordField=new JPasswordField(20);
        jpanel22.add(jPasswordField);
        jPasswordField.setFont(new Font("宋体",Font.PLAIN,18));
        jPasswordField.setForeground(new Color(224,57,151));




        //绘制一个标签 账号 和密码
        JPanel jpanel222 = new JPanel();
        jpanel222.setBounds(0, 160, WIDTH, 40);
        jpanel222.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel.add(jpanel222);
        jpanel222.setOpaque(false);

        JButton ok=new JButton("安全登录");
        jpanel222.add(ok);
        ok.setPreferredSize(new Dimension(254,35));
        ok.setFont(new Font("宋体",Font.BOLD,18));
        ok.setForeground(new Color(8,189,252));
        ok.setForeground(new Color(255,215,0));



        JLabel register=new JLabel("注册账户");
        jpanel.add(register);
        register.setBounds(10,210,100,40);
        register.setFont(new Font("宋体",Font.PLAIN,11 ));
        register.setForeground(new Color(54,5,79));


        //只能有一个账号进行登录，额外登录会挤掉下一个账号





        jpanel.add(label);
    }


}
