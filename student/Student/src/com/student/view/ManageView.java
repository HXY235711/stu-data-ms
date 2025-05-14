package com.student.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ManageView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageView window = new ManageView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("学生信息管理系统");
		frame.setBounds(100, 100, 800, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("查看在线账号");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I1.gif"));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("查看所有账号");
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I1.gif"));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("更改员工信息");
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I1.gif"));
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("更改当前账号用户密码");
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I4.gif"));
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("账号");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("注销");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I1_2.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\I1_1.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\佐檀俊湘\\Desktop\\XH-5java学生管理系统\\3.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 100);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u57FA\u7840\u4FE1\u606F\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 109, 784, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 23, 35, 27);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(44, 26, 72, 21);
		panel.add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(122, 25, 51, 23);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(175, 25, 51, 23);
		panel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("全部");
		rdbtnNewRadioButton_2.setBounds(228, 25, 51, 23);
		panel.add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel_2 = new JLabel("年级");
		lblNewLabel_2.setBounds(340, 29, 54, 15);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(372, 26, 76, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("班级");
		lblNewLabel_3.setBounds(458, 29, 54, 15);
		panel.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(493, 26, 77, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("学号");
		lblNewLabel_4.setBounds(580, 29, 54, 15);
		panel.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(613, 26, 76, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("搜索【学号】");
		lblNewLabel_5.setBounds(10, 60, 100, 15);
		panel.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(122, 57, 94, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("添加学生");
		btnNewButton.setBounds(228, 56, 93, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("删除学生");
		btnNewButton_1.setBounds(331, 57, 93, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("更改学生");
		btnNewButton_2.setBounds(434, 57, 93, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("查找学生");
		btnNewButton_3.setBounds(537, 57, 93, 23);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("重置");
		btnNewButton_4.setBounds(640, 56, 93, 23);
		panel.add(btnNewButton_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5B66\u751F\u4FE1\u606F\u6570\u636E\u663E\u793A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 214, 784, 224);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 20, 764, 194);
		panel_1.add(panel_2);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8D26\u53F7\u4FE1\u606F\u663E\u793A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 439, 784, 224);
		frame.getContentPane().add(panel_1_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 20, 764, 194);
		panel_1_1.add(panel_2_1);
	}
}
