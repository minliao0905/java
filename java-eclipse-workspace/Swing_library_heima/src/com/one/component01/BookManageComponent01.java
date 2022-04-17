package com.one.component01;


/**
 * 步骤1创建数据库引入数据库资料
 * 步骤2创建引入数据库的相关方法类，获取数据，存入容器并且输出确认
 * 步骤3完成添加，查询，删除 ，更新 等事件 需要另建component组件，在引入数据库的基础上；
 * 步骤4完成登录，注册账户的相关事件；
 ** */
import com.itheima.jdbc.Logindao;
import com.one.component.AddBookDialog;
import com.one.component.UpdateBookDialog;
import com.one.domain.ResultInfo;
import com.one.listener.ActionDoneListener;
import com.one.net.FailListener;
import com.one.net.GetUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.ResultInfoData2Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;


@SuppressWarnings("unused")
public class BookManageComponent01 extends Box {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int WIDTH=850;
    final int HEIGHT=600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector<String>> tableData;
    private DefaultTableModel tableModel;

    public BookManageComponent01(JFrame jf){
        //垂直布局
        super(BoxLayout.Y_AXIS);
        //组装视图
        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出一个对话框，让用户输入图书的信息
                new AddBookDialog01(jf, "添加图书", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        try {
							requestData();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                }).setVisible(true);
                
                //更新数据
                try {
					requestData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前表格选中的id
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1

                if (selectedRow==-1){
                    JOptionPane.showMessageDialog(jf,"请选择要修改的条目！");
                    return;
                }

                String id = tableModel.getValueAt(selectedRow, 0).toString();

                //弹出一个对话框，让用户修改
                new UpdateBookDialog01(jf, "修改图书", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        try {
							requestData();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                },id).setVisible(true);  
                
                try {
				requestData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
          
            
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取选中的条目
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1

                if (selectedRow==-1){
                    JOptionPane.showMessageDialog(jf,"请选择要删除的条目！");
                    return;
                }

                //防止误操作
                int result = JOptionPane.showConfirmDialog(jf, "确认要删除选中的条目吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                if (result != JOptionPane.YES_OPTION){
                    return;
                }

                String id = tableModel.getValueAt(selectedRow, 0).toString();
                BookSystem_Sqllogin booklogin = new BookSystem_Sqllogin();
                try {
					booklogin.DeleteBook(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                JOptionPane.showMessageDialog(jf,"删除成功!");
                //更新数据
                try {
					requestData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        this.add(btnPanel);

        //组装表格
        String[] ts = {"编号","书名","作者","价格","库存","简介"};
        titles = new Vector<>();
        for (String title : ts) {
            titles.add(title);
        }

      tableData = new Vector<>();
 
        tableModel = new DefaultTableModel(tableData,titles);
        
        table = new JTable(tableModel){
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
////        设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        
     try {
			requestData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
       
    }

    //请求数据，获得数据并且展示,      为新创数据库 书籍相关的数据的库
  
    public void requestData() throws SQLException{
     
       BookSystem_Sqllogin bookData = new BookSystem_Sqllogin();
       tableData.clear();
	Vector<Vector> vectors = bookData.getBookData();
      for(Vector vector :vectors) {
    	  tableData.add(vector);
      }
       tableModel.fireTableDataChanged();
    }
  
}

