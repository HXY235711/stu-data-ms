package com.student.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//实现表格显示内容
public class Tablle {

    JTable table=null;//定义表格
    JScrollPane scrollPane=null;//定义滚动条
    DefaultTableModel tableModel=null;//设置默认模式，出现滚动条的方式
   //初始化一个表格
    public Tablle(Object columns[]){//存入行的数据
            if(table==null){
                table=new JTable();//初始化一个表格
                tableModel=new DefaultTableModel(){//创建一个匿名类
                    //这个表格是否
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }

                };
                tableModel.setColumnIdentifiers(columns);//设置一下表头
                table.setModel(tableModel);
                table.getTableHeader().setReorderingAllowed(false);//禁止表头排序
                table.getTableHeader().setResizingAllowed(false);//禁止拖拉表格


                scrollPane=new JScrollPane(table);//创建一个滚动条
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            }
    }
//返回滚动条
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
//返回控制器
    public DefaultTableModel getTableModel() {
        return tableModel;

    }

}
