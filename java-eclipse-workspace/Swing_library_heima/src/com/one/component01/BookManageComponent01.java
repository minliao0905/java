package com.one.component01;


/**
 * ����1�������ݿ��������ݿ�����
 * ����2�����������ݿ����ط����࣬��ȡ���ݣ����������������ȷ��
 * ����3�����ӣ���ѯ��ɾ�� ������ ���¼� ��Ҫ��component��������������ݿ�Ļ����ϣ�
 * ����4��ɵ�¼��ע���˻�������¼���
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
        //��ֱ����
        super(BoxLayout.Y_AXIS);
        //��װ��ͼ
        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("���");
        JButton updateBtn = new JButton("�޸�");
        JButton deleteBtn = new JButton("ɾ��");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //����һ���Ի������û�����ͼ�����Ϣ
                new AddBookDialog01(jf, "���ͼ��", true, new ActionDoneListener() {
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
                
                //��������
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
                //��ȡ��ǰ���ѡ�е�id
                int selectedRow = table.getSelectedRow();//�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1

                if (selectedRow==-1){
                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫ�޸ĵ���Ŀ��");
                    return;
                }

                String id = tableModel.getValueAt(selectedRow, 0).toString();

                //����һ���Ի������û��޸�
                new UpdateBookDialog01(jf, "�޸�ͼ��", true, new ActionDoneListener() {
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
                //��ȡѡ�е���Ŀ
                int selectedRow = table.getSelectedRow();//�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1

                if (selectedRow==-1){
                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫɾ������Ŀ��");
                    return;
                }

                //��ֹ�����
                int result = JOptionPane.showConfirmDialog(jf, "ȷ��Ҫɾ��ѡ�е���Ŀ��", "ȷ��ɾ��", JOptionPane.YES_NO_OPTION);
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
                JOptionPane.showMessageDialog(jf,"ɾ���ɹ�!");
                //��������
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

        //��װ���
        String[] ts = {"���","����","����","�۸�","���","���"};
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
////        ����ֻ��ѡ��һ��
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

    //�������ݣ�������ݲ���չʾ,      Ϊ�´����ݿ� �鼮��ص����ݵĿ�
  
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

