package com.one.component;

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
import java.util.Vector;


@SuppressWarnings("unused")
public class BookManageComponent extends Box {
    final int WIDTH=850;
    final int HEIGHT=600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private DefaultTableModel tableModel;

    public BookManageComponent(JFrame jf){
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
                new AddBookDialog(jf, "���ͼ��", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestData();
                    }
                }).setVisible(true);
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
                new UpdateBookDialog(jf, "�޸�ͼ��", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestData();
                    }
                },id).setVisible(true);
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

                GetUtils.get("http://localhost:8080/book/deleteBookById?id=" + id, new SuccessListener() {
                    @Override
                    public void success(String result) {
                        ResultInfo info = JsonUtils.parseResult(result);
                        if (info.isFlag()){
                            //ɾ���ɹ�
                            JOptionPane.showMessageDialog(jf,"ɾ���ɹ�");
                            requestData();
                        }else{
                            //ɾ��ʧ��
                            JOptionPane.showMessageDialog(jf,info.getMessage());
                        }

                    }
                }, new FailListener() {
                    @Override
                    public void fail() {
                        JOptionPane.showMessageDialog(jf,"�����쳣�����Ժ�����");
                    }
                });

            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        this.add(btnPanel);

        //��װ���
        String[] ts = {"���","����","���","����","�۸�","���"};
        titles = new Vector<>();
        for (String title : ts) {
            titles.add(title);
        }

        tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData,titles);
        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //����ֻ��ѡ��һ��
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        requestData();
    }

    //�������ݣ�������ݲ���չʾ
    public void requestData(){
        GetUtils.get("http://localhost:8080/book/findAllBook", new SuccessListener() {
            @Override
            public void success(String result) {
                ResultInfo info = JsonUtils.parseResult(result);
                Vector<Vector> vectors = ResultInfoData2Vector.convertResultInfoData2Vector(info);

                //���tableData������
                tableData.clear();
                for (Vector vector : vectors) {
//                	System.out.println("BookManegeComponent"+vector);
                    tableData.add(vector);
                }

                //ˢ�±��
                tableModel.fireTableDataChanged();
            }
        }, new FailListener() {
            @Override
            public void fail() {

            }
        });
    }

}
