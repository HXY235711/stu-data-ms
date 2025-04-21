package com.student.view;

import com.student.dao.AdminDao;
import com.student.utils.Tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JPasswordField textField_3;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public RegisterView() {initialize();
	}


	private final  int WIDTH = 410;
	private final  int HEIGHT = 345;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("注册界面");
		Tools.setPos(frame,WIDTH,HEIGHT);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);


		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/2.jpg"));
		lblNewLabel.setBounds(0, 0, 394, 306);
		
		
		JLabel lblNewLabel_1 = new JLabel("学生信息管理系统注册");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 28));
		lblNewLabel_1.setBounds(10, 10, 374, 82);
		lblNewLabel_1.setForeground(Color.gray);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 72, 394, 234);
		frame.getContentPane().add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("姓       名");
		lblNewLabel_2.setBounds(23, 16, 101, 25);
		lblNewLabel_2.setForeground(new Color(102,102,102));
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(134, 16, 217, 21);
		panel.add(textField);
		textField.setColumns(10);
		textField.setForeground(new Color(18,120,192));
		textField.setPreferredSize(new Dimension(15, 28));
		
		JLabel lblNewLabel_3 = new JLabel("账       号");
		lblNewLabel_3.setBounds(23, 51, 101, 25);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(102,102,102));


		textField_1 = new JTextField();
		textField_1.setBounds(134, 53, 217, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setForeground(new Color(18,120,192));
		textField_1.setPreferredSize(new Dimension(15, 28));


		JLabel lblNewLabel_4 = new JLabel("密       码");
		lblNewLabel_4.setBounds(23, 86, 101, 25);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(102,102,102));



		textField_2 = new JPasswordField();
		textField_2.setBounds(134, 88, 217, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setForeground(new Color(18,120,192));
		textField_2.setPreferredSize(new Dimension(15, 28));




		JLabel lblNewLabel_5 = new JLabel("确认密码：");
		lblNewLabel_5.setBounds(23, 121, 101, 25);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(102,102,102));



		textField_3 = new JPasswordField();
		textField_3.setBounds(134, 123, 217, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setForeground(new Color(18,120,192));
		textField_3.setPreferredSize(new Dimension(15, 28));

		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setBounds(23, 166, 328, 41);
		panel.add(btnNewButton);
		
		frame.getContentPane().add(lblNewLabel);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//注册点击事件

				String xm = textField.getText();
				String account = textField_1.getText();

				String pwd = new String(textField_2.getPassword());
				String qpwd = new String(textField_3.getPassword());

				if(xm.equals("")){
					Tools.showMessage("请输入姓名");
				}
				else if(account.equals("")){
					Tools.showMessage("请输入账号");
				}
				else if(pwd.equals("")){
					Tools.showMessage("请输入密码");
				}
				else if(qpwd.equals("")){
					Tools.showMessage("请确认密码");
				}
				else if(!pwd.equals(qpwd)){
					Tools.showMessage("两次密码不一致");
				}
				else{

					int a = AdminDao.register(account,pwd,xm,"0","0");
					if(a == 0){
						Tools.showMessage("账号冲突,注册失败");
					}
					else if(a == 1){
						Tools.showMessage("注册成功");
					}
					else{
						Tools.showMessage("报错");
					}

				}

			}
		});
	}
}
