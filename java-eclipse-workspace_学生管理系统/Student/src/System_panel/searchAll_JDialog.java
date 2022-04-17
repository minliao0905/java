package System_panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import System_Component.ScreenUtils;
import System_SQL.student_SQL;


//������ѯ��ѧ�����еļ�¼
public class searchAll_JDialog extends JDialog {

	private static final long serialVersionUID = 1L;
//  
	final int WIDTH = 850;
    final int HEIGHT = 400;
    private JTable table1; 
    private Vector<String> titles1;
    @SuppressWarnings("rawtypes")
	private Vector<Vector> studentData1;
    private DefaultTableModel tableModel1;
    private JTable table2; 
    private Vector<String> titles2;
    @SuppressWarnings("rawtypes")
	private Vector<Vector> studentData2;
    private DefaultTableModel tableModel2;
    student_SQL studentsql = new student_SQL();  //�������ݿ����
 
    public searchAll_JDialog(JFrame jf, String title, boolean isModel,Vector<String> studentid){
 
        super(jf,title,isModel);   
        //��װ��ͼ
        this.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
//        JPanel mpanel1 = new JPanel();
//        JPanel mpanel2 = new JPanel();
        Box vbox = Box.createVerticalBox();
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createVerticalBox();
        JLabel jl1 = new JLabel("������Ϣ");
        JLabel jl2 = new JLabel("������Ϣ");
        
          studentData1 = new Vector<>();
          studentData2 = new Vector<>();
       
      
     //��һ  
        String[] ts1 = {"ѧ��","����","�Ա�","����","�༶","רҵ","����"}; 
        titles1 = new Vector<>();
        for (String title1 : ts1) {
            titles1.add(title1);
        }
      
        tableModel1 = new DefaultTableModel(studentData1,titles1);   
        table1 = new JTable(tableModel1){
              	@Override
            public boolean isCellEditable(int row, int column) {
                return false;                  //���ɱ༭
            }
        };
        JScrollPane scrollPane1 = new JScrollPane(table1);
       box1.add(jl1);       
       box1.add(scrollPane1);
        //���
        String[] ts2 = {"ѧ�����","���ʱ��","��ý���","���ʱ��","�ܹ�����","����ʱ��"}; 
        titles2 = new Vector<>();
        for (String title2: ts2) {
            titles2.add(title2);
        }
      
        tableModel2 = new DefaultTableModel(studentData2,titles2);  
       
        table2 = new JTable(tableModel2){
              	@Override
            public boolean isCellEditable(int row, int column) {
                return false;                  //���ɱ༭
            }
        };  
        JScrollPane scrollPane2 = new JScrollPane(table2);
        box2.add(jl2);       
        box2.add(scrollPane2);
        vbox.add(box1);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(box2);
        try {
       	  getMessage(studentid);
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
        JLabel m1jl = new JLabel("���޼�¼"); 
   	   JLabel m2jl = new JLabel("���޼�¼");
        if(studentData1.isEmpty()) {       	
       	 box1.add(m1jl);
          }
        else {
        	box1.remove(m1jl);
        }
        if(studentData2.isEmpty()) {          	
          	 box2.add(m2jl);
          }else {
        	  box2.remove(m2jl);
        }
        //���
        this.add(vbox);
    }
  public void getMessage(Vector<String> studentids)throws SQLException{
	  studentData1.clear();
	  studentData2.clear();
	  for(String studentid: studentids) {
		   Vector<Vector> vectors1 = studentsql.getstudentData_byid(studentid);	  
	  for(Vector vector :vectors1) {
    	  System.out.println("��һ���ݣ�"+vector);        //�Ƿ���Բ���������studentData?
    	  studentData1.add(vector);
     
	  }
    
     Vector<Vector> vectors2 = studentsql.getstudentCRP_byid(studentid);
     for(Vector vector :vectors2) {
    	  System.out.println("������ݣ�"+vector);
	  studentData2.add(vector);
     }
     
	  }
	   tableModel1.fireTableDataChanged();      //���±������
       tableModel2.fireTableDataChanged();      //���±������
  }

}
