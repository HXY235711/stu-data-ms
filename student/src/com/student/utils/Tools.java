package com.student.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.List;

public class Tools {

    /**
     * 实现了将窗口居中
     *
     * @param jFrame
     * @param width
     * @param height
     */
    public static void setPos(JFrame jFrame, int width, int height) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int x = (int) screenSize.getWidth() / 2 - width / 2;
        int y = (int) screenSize.getHeight() / 2 - height / 2;

        jFrame.setBounds(x, y, width, height);

    }

    /**
     * 弹窗封装的方法
     *
     * @param message
     */
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "提示消息", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,message);
    }
    /**
     * 表格的控制权，List数据
     *
     * @param tableModle
     * @param list
     * @param <T>
     */
    public static <T> void addTableData(DefaultTableModel tableModle, List<T> list) throws IllegalAccessException {
        //遍历这个List
        tableModle.setRowCount(0);
        for(T t : list) {
            int len = t.getClass().getDeclaredFields().length;//获取这个类当中所有的私有变量
            String data[] = new String[len];// 存储数据组
            Field[] fieldes = t.getClass().getDeclaredFields();//得到所有字段的值
            for (int i = 0; i < len; i++) {
                fieldes[i].setAccessible(true);
                Object js = fieldes[i].get(t);
                if(js != null) {
                    data[i] = js.toString();
                }
            }


            tableModle.addRow(data);
        }



    }

    /**
     * 表格的控制权，List数据
     *
     * @param tableModle
     * @param t
     * @param <T>
     */
    public static <T> int addTableData(DefaultTableModel tableModle, T t) throws IllegalAccessException {
        //遍历这个List

        tableModle.setRowCount(0);
        int len = t.getClass().getDeclaredFields().length;//获取这个类当中所有的私有变量
        String data[] = new String[len];// 存储数据组
        Field[] fieldes = t.getClass().getDeclaredFields();//得到所有字段的值
        for (int i = 0; i < len; i++) {
            fieldes[i].setAccessible(true);

            Object js = fieldes[i].get(t);
            if(js != null) {
                data[i] = js.toString();
            }

        }

        tableModle.addRow(data);

        return len;
    }


}
