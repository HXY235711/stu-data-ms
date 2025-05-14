package com.student.utils;

import javax.swing.*;
import java.awt.*;

public class Tools {

    /**
     * 实现了将窗口居中
     * @param jFrame
     * @param width
     * @param height
     */
    public static void setPos(JFrame jFrame,int width,int height) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int x = (int)screenSize.getWidth()/2 - width/2;
        int y = (int)screenSize.getHeight()/2 - height/2;

        jFrame.setBounds(x,y,width,height);

    }

    /**
     * 弹窗封装的方法
     * @param message
     */
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message,"提示消息",JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,message);
    }

    public static void addTableData(DefaultTableModel tableModel,T<T> t) {}
}
