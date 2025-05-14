package com.student.view;
import java.util.Timer;
import java.util.TimerTask;
import com.mysql.cj.xdevapi.*;
import com.student.bean.Admin;
import com.student.bean.Student;
import com.student.dao.AdminDao;
import com.student.dao.StudentDao;
import com.student.utils.DBUntil;
import com.student.utils.Tablle;
import com.student.utils.Tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import static com.student.utils.Tools.addTableData;

public class ManageView {

	 JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JTextArea jTextArea;//文本域


	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBUntil dbUntil = new DBUntil("root","lyx235611","db_student");
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
	mntmNewMenuItem_2.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//查看在线账号

				if(LoginView.pow.equals("1")){
					List<Admin> admins = AdminDao.showAccount();
					jTextArea.setText("账号\t姓名\t状态\t\n");
					for (Admin admin : admins) {
						String str=admin.getAccount()+"\t";
						str=str+admin.getXm()+"\t";
						if(admin.getSta().equals("0")){
							str=str+"不在线\t";
						}else{
							str=str+"在线\t";
						}
						jTextArea.append(str+"\n");
					}
				}else{
					Tools.showMessage("您没有管理员权限");
				}


			}
		});

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("查看所有账号");
		mntmNewMenuItem_3.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//查看在线账号

				if(LoginView.pow.equals("1")){
					List<Admin> admins = AdminDao.showAllAccount();
					jTextArea.setText("账号\t姓名\t状态\t\n");
					for (Admin admin : admins) {
						String str=admin.getAccount()+"\t";
						str=str+admin.getXm()+"\t";
						if(admin.getSta().equals("0")){
							str=str+"不在线\t";
						}else{
							str=str+"在线\t";
						}
						jTextArea.append(str+"\n");
					}
				}else{
					Tools.showMessage("您没有管理员权限");
				}


			}
		});

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("更改员工信息");
		mntmNewMenuItem_4.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("更改当前账号用户密码");
		mntmNewMenuItem_5.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("账号");
		menuBar.add(mnNewMenu_1);


		JMenuItem mntmNewMenuItem_1 = new JMenuItem("注销");
		mntmNewMenuItem_1.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginView loginView = new LoginView();//打开登录窗口
				new AdminDao().updateByUuid(LoginView.uuid,"0");//更改账号状态
			}
		});


		JMenuItem mntmNewMenuItem = new JMenuItem("退出");
		mntmNewMenuItem_1.setIcon(new ImageIcon("image/1.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		frame.getContentPane().setLayout(null);

		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();//打开登录窗口
				new AdminDao().updateByUuid(LoginView.uuid,"0");//更改账号状态
				System.exit(0);
			}
		});

        //监听窗口状态
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				new AdminDao().updateByUuid(LoginView.uuid,"0");//更改账号状态
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {


			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

		});




		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/2.jpg"));
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

		ButtonGroup group = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(122, 25, 51, 23);
		panel.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(175, 25, 51, 23);
		panel.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("全部");
		rdbtnNewRadioButton_2.setBounds(228, 25, 51, 23);
		panel.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);

		//设置默认值
		rdbtnNewRadioButton_2.setSelected(true);//全部

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

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String xm = textField.getText();
				String age = textField_1.getText();
				String bj= textField_2.getText();
				String xh= textField_3.getText();

				String whereSh= textField_4.getText();
				String sex=null;
				if(rdbtnNewRadioButton.isSelected()){
					sex="男";
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					sex="女";
				}

				if(xm.equals("")){
					Tools.showMessage("请输入姓名");
				}else if(sex==null){
					Tools.showMessage("请输入性别");
				}else if(age.equals("")){
					Tools.showMessage("请输入年级");
				}else if(bj.equals("")){
					Tools.showMessage("请输入班级");
				}else if(xh.equals("")){
					Tools.showMessage("请输入学号");
				}else if(whereSh.equals("")){
					Tools.showMessage("请输入要更改的学号");
				}else {


					//所有内容已添加
					Student student = new Student(xh, xm, sex, age, bj);
                    int a=new StudentDao().updateStudent(student,whereSh);
					if(a==1){
						Tools.showMessage("更改成功");
					}else{
						Tools.showMessage("更改失败");
					}
				}
			}
		});

//添加学生
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String xm = textField.getText();
				String age = textField_1.getText();
				String bj= textField_2.getText();
				String xh= textField_3.getText();

				String sex=null;
				if(rdbtnNewRadioButton.isSelected()){
					sex="男";
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					sex="女";
				}

				if(xm.equals("")){
					Tools.showMessage("请输入姓名");
				}else if(sex==null){
					Tools.showMessage("请输入性别");
				}else if(age.equals("")){
					Tools.showMessage("请输入年级");
				}else if(bj.equals("")){
					Tools.showMessage("请输入班级");
				}else if(xh.equals("")){
					Tools.showMessage("请输入学号");
				}else{
					//所有内容已添加
					Student student = new Student(xh,xm,sex,age,bj);
					int res=new StudentDao().addStudent(student);
					if(res==1){
						Tools.showMessage("添加成功");
					}else {
						Tools.showMessage("学号冲突，请修改学号");
					}
				}
			}
		});






		JButton btnNewButton_1 = new JButton("删除学生");
		btnNewButton_1.setBounds(331, 57, 93, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//删除
				String tj = textField_4.getText();
				if(tj.equals("")){
					Tools.showMessage("请输入要删除的学号");
				}else{
					int res=new StudentDao().delStudent(tj);
					if(res==1){
						Tools.showMessage("删除成功");
					}else{
						Tools.showMessage("删除失败，请检查学号");
					}

				}
			}
		});

		JButton btnNewButton_2 = new JButton("更改学生");
		btnNewButton_2.setBounds(434, 57, 93, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String xm = textField.getText();
				String age = textField_1.getText();
				String bj= textField_2.getText();
				String xh= textField_3.getText();

				String sex=null;
				if(rdbtnNewRadioButton.isSelected()){
					sex="男";
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					sex="女";
				}

				if(xm.equals("")){
					Tools.showMessage("请输入姓名");
				}else if(sex==null){
					Tools.showMessage("请输入性别");
				}else if(age.equals("")){
					Tools.showMessage("请输入年级");
				}else if(bj.equals("")){
					Tools.showMessage("请输入班级");
				}else if(xh.equals("")){
					Tools.showMessage("请输入学号");
				}else{
					//所有内容已添加
					Student student = new Student(xh,xm,sex,age,bj);
					int res=new StudentDao().addStudent(student);
					if(res==1){
						Tools.showMessage("添加成功");
					}else {
						Tools.showMessage("学号冲突，请修改学号");
					}
				}
			}
		});

		JButton btnNewButton_3 = new JButton("查找学生");
		btnNewButton_3.setBounds(537, 57, 93, 23);
		//查找学生的监听
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//条件模糊查找，根据学号查找，查找全部内容
				String tjxh=textField_4.getText();//条件学号
				if(tjxh.equals("")){
					//查询全部
					String xm = textField.getText();
					String age = textField_1.getText();
					String bj= textField_2.getText();
					String xh= textField_3.getText();

					String sex=null;
					if(rdbtnNewRadioButton.isSelected()){
						sex="男";
					}
					if(rdbtnNewRadioButton_1.isSelected()){
						sex="女";
					}
					if(rdbtnNewRadioButton_2.isSelected()){
						sex="";
					}

					if(xm.equals("")&&age.equals("")&&bj.equals("")&&xh.equals("")&&sex.equals("")){
						//查询全部
						//单独查询
						List<Student> stu= new StudentDao().getStudentAll();//得到一个学生实体
						try{
							Tools.addTableData(model,stu);
						} catch (IllegalAccessException ex){
							throw new RuntimeException(ex);
						}
					}else{
						//条件查询
						Student student = new Student(xh,xm,sex,age,bj);
                        try {
                            List<Student> stu = new StudentDao().getStudentWhere(student);
							Tools.addTableData(model,stu);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
					}


				}else{
					//单独查询
					Student stu = new StudentDao().getStudentByNumber(tjxh);//得到一个学生实体
					//将这个数据回显到内容
					if(stu!=null){
						textField.setText(stu.getXm());
						textField_1.setText(stu.getAge());
						textField_2.setText(stu.getGrade());
						textField_3.setText(stu.getNumber());

						if(stu.getSex()!=null&&stu.getSex().equals("男")){
							rdbtnNewRadioButton.setSelected(true);
						}
						if(stu.getSex()!=null&&stu.getSex().equals("女")){
							rdbtnNewRadioButton_1.setSelected(false);
						}


					}


                    try{
						Tools.addTableData(model,stu);
					} catch (IllegalAccessException ex){
						throw new RuntimeException(ex);
					}
				}
			}
		});

		JButton btnNewButton_4 = new JButton("重置");
		btnNewButton_4.setBounds(640, 56, 93, 23);
		panel.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//实现重置功能
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				rdbtnNewRadioButton_2.setSelected(true);

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "学生数据信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 214, 784, 224);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);








		Object col[]={"学号","姓名","性别","年龄","班级"};
		Tablle table = new Tablle(col);//创建了一个表格
		model = table.getTableModel();
		JScrollPane scroll = table.getScrollPane();
		//scroll.setBorder(new TitledBorder(null, "\u5B66\u751F\u4FE1\u606F\u6570\u636E\u663E\u793A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scroll.setBounds(10, 22, 784, 186);
		panel_1.add(scroll);



		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "账号信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 439, 784, 224);
		frame.getContentPane().add(panel_1_1);



		jTextArea = new JTextArea();
		JScrollPane scroll_1 = new JScrollPane(jTextArea);
		scroll_1.setBounds(10, 20, 764, 194);

		//jTextArea.setBorder(new TitledBorder(null, "账号信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_1_1.add(scroll_1);


		//当运行管理界面的时候，会监听循环监听，数据变化如果变化则关闭当前程序
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				Admin admin = AdminDao.showAccount(LoginView.uuid);
				if(admin== null) {//在线
					LoginView loginView = new LoginView();//打开登录窗口
					frame.dispose();
					Tools.showMessage("你的账号已经异地登录，被迫下线，请重新登录。");
				}
			}
		};
		Timer timer=new Timer();
		//设定任务调度，延迟1秒开始，之后每隔1秒执行一次
		timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);//每隔1秒执行一次

	}
}
