package System_panel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import System_SQL.Manager_SQl;
import System_SQL.student_SQL;
import System_UI.student_Register;



public class newstudents extends Box{


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		final int WIDTH=850;
	    final int HEIGHT=600;

	    JFrame jf = null;
	    private JTable table; 
	    private Vector<String> titles;

	    private DefaultTableModel tableModel;
	    private  Vector<Vector<String>> studentData;
	    student_SQL studentsql = new student_SQL();

	    public newstudents(JFrame jf){
	       
	        super(BoxLayout.Y_AXIS); //��ֱ����
	        //��װ��ͼ
	        this.jf = jf;
	        JPanel btnPanel = new JPanel();
	       
	        Color color = new Color(203,220,217);
	        btnPanel.setBackground(color);
	        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
	        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));       //Ĭ�ϲ��ּ��Ϊ5
	        
            JButton addTotable = new JButton("��������");
	        JButton addToBtn = new JButton("�����ѧ����");	
	        JButton updateselect = new JButton("�޸�");
	        JButton clearselect = new JButton("ɾ����ǰ��");
	        JButton clearAll = new JButton("��ձ����������");
	        btnPanel.add(addTotable);
	        btnPanel.add(addToBtn);
	        btnPanel.add(clearselect);
	        btnPanel.add(updateselect);
	        btnPanel.add(clearAll);
	        
	        
	        
	        JPanel textPanel1 = new JPanel();	       
	        textPanel1.setBackground(color);
	        textPanel1.setMaximumSize(new Dimension(WIDTH,80));            //�������߿�
	        textPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));       //������Ĭ�ϲ��ּ��Ϊ5
	        JPanel textPanel2 = new JPanel();	       
	        textPanel2.setBackground(color);
	        textPanel2.setMaximumSize(new Dimension(WIDTH,80));            
	        textPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));       
	        
        
         JLabel jlsnumber = new JLabel("ѧ�ţ�");
         JTextField snumbertext = new JTextField(10);
         JLabel jlname = new JLabel("������");
         JTextField nametext = new JTextField(10);
         JLabel jlsex = new JLabel("�Ա�");
	     JComboBox<String> sexjcb = new JComboBox<String>();
	     sexjcb.addItem("��");
	     sexjcb.addItem("Ů");
	     JLabel jlage = new JLabel("���䣺");
	     JTextField agetext = new JTextField(10);
	     JLabel jlclass = new JLabel("�༶��ţ�");
	     JTextField classtext = new JTextField(10);
	     JLabel jldepart = new JLabel("רҵ��ţ�");
	     JTextField departtext = new JTextField(10);	    
	     JLabel jladdress = new JLabel("���᣺");
	     JTextField  addresstext = new JTextField(10);         
	           
         textPanel1.add(jlsnumber);
         textPanel1.add(snumbertext);
         textPanel1.add(jlname);
         textPanel1.add(nametext);
         textPanel1.add(jlsex);
         textPanel1.add(sexjcb);
         textPanel2.add(jlage);
         textPanel2.add(agetext);
         textPanel2.add(jlclass);
         textPanel2.add(classtext);
         textPanel2.add(jldepart);
         textPanel2.add(departtext);
         textPanel2.add(jladdress);
         textPanel2.add(addresstext);
          
         String[] ts = {"ѧ��","����","�Ա�","����","�༶","רҵ","����"}; 
	        titles = new Vector<>();
	        for (String title : ts) {
	            titles.add(title);
	        }
	        studentData = new Vector<>();
	        tableModel = new DefaultTableModel(studentData,titles);   
	        table = new JTable(tableModel){
				private static final long serialVersionUID = 1L;

				@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	    
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //����ֻ��ѡ��һ��

	        JScrollPane scrollPane = new JScrollPane(table);
	        this.add(scrollPane);
	        this.add(textPanel1);
	        this.add(textPanel2);
	        this.add(btnPanel);
	        
	        student_SQL studentsql =new student_SQL();
	    //��������    
	        addTotable.addActionListener(new ActionListener() {
	    				@Override
	    				public void actionPerformed(ActionEvent e) {
	    					    String snumber = snumbertext.getText().trim();
	    		                String  name= nametext.getText().trim();
	    		                String  gender =(String) sexjcb.getSelectedItem();
	    		                String age = agetext.getText().trim();
	    		                String studentclass = classtext.getText().trim();
	    		                String  department = departtext.getText().trim();
	    		                String nativepalce = addresstext.getText().trim();

	    		                Map<String,String> params = new LinkedHashMap<>();
	    		                params.put("studentid", snumber);
	    		                params.put("name",name); 
	    		                params.put("gender",gender);
	    		                params.put("age",age);
	    		                params.put("class",studentclass);
	    		                params.put("department",department);
	    		                params.put("nativepalce", nativepalce);
	    		                boolean check = false;
	    		            	check =	checktext(params);   //������ݺ�id
	    					  	if(check==true) {
	    					  		//���ѧ�Ų���
	    					 	       try {
	    							 check = studentsql.checkAllstudentsId(snumber);
	    							} catch (SQLException e1) {
	    								e1.printStackTrace();
	    						  	}
	    					 	       for(Vector vector:studentData) {
	    					 	    	   String number = (String) vector.get(0);
	    					 	    	   System.out.println("checkkkkkk"+number);
	    					 	    	   if(snumber.equals(number)) {
	    					 	    		   check=false;
	    					 	    	   }
	    					 	       }
	    					 	      if(check == false) {
	    					 	    	    JOptionPane.showMessageDialog(jf,"�������ѧ���Ѿ����ڣ�����������ѧ�ţ�");
	    					 	    	  return ;
	    					 	    	  
	    					 	      }else {
	    					 	    	 Set<String> keySet = params.keySet();        	 
	    					 	         Vector<String> vector = new Vector<>();
	    					 	        
	    					 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	    					 	        {   
	    					 	            String key = it.next();
	    					 	            String value = params.get(key);
	 					 	                vector.add(value);       
	    					 	        }
	    					 	        studentData.add(vector);
	    					 	       tableModel.fireTableDataChanged();      //���±������
	    					 	      }			  				               
	    					  	}
	    					  	else {
	    					  		return ;
	    					  	}
	    					  	//�����ı���Ϊ��	    					 
	    					  	 snumbertext.setText("");
	    			             nametext.setText("");	       
	    			             agetext.setText("");
	    			             classtext.setText("");
	    			             departtext.setText("");
	    			             addresstext.setText("");
	    				}  
	    		       });
	    //�����ѧ������
	        addToBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				for(Vector<String> vector:studentData) {
					try {
						studentsql.Insertnewstudent(vector);
					} catch (SQLException e1) {
//						System.out.println("���ݴ���1");
						e1.printStackTrace();
					}
					
				}
					JOptionPane.showMessageDialog(jf,"����������Ϣ�ѳɹ������ѧ����");
				}
	        	
	        });
	   	//�޸�����
	        updateselect.addActionListener(new ActionListener() {
	        	@Override
				public void actionPerformed(ActionEvent e) {
					 int selectedRow = table.getSelectedRow(); //�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1					
		             if (selectedRow==-1){
		                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫ�޸ĵ���Ŀ��");
		                    return;
		             }		             
		            String id = tableModel.getValueAt(selectedRow, 0).toString();
		            String snumber = snumbertext.getText().trim();
	                String  name= nametext.getText().trim();
	                String  gender =(String) sexjcb.getSelectedItem();
	                String age = agetext.getText().trim();
	                String studentclass = classtext.getText().trim();
	                String  department = departtext.getText().trim();
	                String nativepalce = addresstext.getText().trim();

	                Map<String,String> params = new LinkedHashMap<>();
	                params.put("studentid", snumber);
	                params.put("name",name); 
	                params.put("gender",gender);
	                params.put("age",age);
	                params.put("class",studentclass);
	                params.put("department",department);
	                params.put("nativepalce", nativepalce);
	                boolean check = false;
            
	                check =	checktext(params);   //��������Ƿ�Ϊ��
	            	if(check==true) {
	            		if(!id.equals(snumber)) {            //������ѧ�Ų���ȣ������ѧ���Ƿ��ظ�
	            			 try {
	        					 check = studentsql.checkAllstudentsId(snumber); 
	        					} catch (SQLException e1) {
	        						e1.printStackTrace();
	        					}
	            			 if(check==false) {
	            				  JOptionPane.showMessageDialog(jf,"�������ѧ����������ظ�������������ѧ�ţ�");
	            	 	    	    return ;       //����
	            			 }	            			 
	            		}
	            		//����Map����
	            		 Set<String> keySet = params.keySet();  
	            		 int i=0;
			 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
			 	        {   
			 	            String key = it.next();
			 	            String value = params.get(key);
			 	          tableModel.setValueAt(value, selectedRow,i ) ;     //�޸ı��
			 	          i++;
			 	        }	
			 	       tableModel.fireTableDataChanged();      //���±������
	 	     			  				              		
				  	}
				  	else {
				  		return ;
				  	}	               			
				}	        	
	        });
	    //��ձ������
	     clearAll.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {      
		             int res = JOptionPane.showConfirmDialog(jf,  "�Ƿ�ɾ���������������?","�Ƿ����?", JOptionPane.YES_NO_OPTION); 
						if(res==JOptionPane.YES_OPTION) {
							  studentData.clear();
							  tableModel.fireTableDataChanged();      //���±������
						}
	               
				}		    	   
		       });					
	  
	    //ɾ����ǰ��
	       clearselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
				 //�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1
	             if (selectedRow==-1){
	                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫɾ������Ŀ��");
	                    return;
	             }
	             String id = tableModel.getValueAt(selectedRow, 0).toString();
	            
	             int res = JOptionPane.showConfirmDialog(jf,  "�Ƿ����?","�Ƿ�ȷ��ɾ����ǰ����?", JOptionPane.YES_NO_OPTION); 
					if(res==JOptionPane.YES_OPTION) {
						  tableModel.removeRow(selectedRow);
					}
					  tableModel.fireTableDataChanged();      //���±������
		
			}
	    	   
	       }); 
	       
	    }
	    
  
	    //��麯��                   
	    public  boolean checktext(Map<String,String> params) {

        	boolean check = false;
        	//��������Ƿ�Ϊ��
        	 Set<String> keySet = params.keySet();        	 
 	         String id= new String();
 	        String classid= new String();
 	       String departmentid= new String();
 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
 	        {   
 	            String key = it.next();
 	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
 	            String value = params.get(key);
 	           if(value.equals("")) {
 	        	   JOptionPane.showMessageDialog(jf,"�������ݲ���Ϊ��,����������!"); 
 	        	   return false;
 	           }
 	          if(key.equals("class")) {
	        	   classid = value;             //��ȡid��
	           }
 	         if(key.equals("department")) {
	        	   departmentid = value;             //��ȡid��
	           }	       
 	        }

 	       try {
			check = studentsql.checkAllclass_departmentId(departmentid, classid);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
 	       if(check ==false) {
	    	    JOptionPane.showMessageDialog(jf,"������İ༶��ź�רҵ����������������룡");
	    	    return false;
	      }
        	return true;
        }
       
			

}
