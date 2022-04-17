package System_panel;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import System_Component.ScreenUtils;
import System_SQL.student_SQL;



public class studentManage extends Box{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		final int WIDTH=850;
	    final int HEIGHT=600;

	    JFrame jf = null;
	    private JTable table; 
	    private Vector<String> titles;
	    @SuppressWarnings("rawtypes")
		private Vector<Vector> studentData;
	    private DefaultTableModel tableModel;
	    student_SQL studentsql = new student_SQL();  //�������ݿ����
	 public studentManage(JFrame jf){
	       
	        super(BoxLayout.Y_AXIS); //��ֱ����
	        //��װ��ͼ
	        this.jf = jf;
	        
	    
//	        jp.setLayout(new BorderLayout());
	   //ѧ����
	        String[] ts = {"ѧ��","����","�Ա�","����","�༶","רҵ","����"}; 
	        titles = new Vector<>();
	        for (String title : ts) {
	            titles.add(title);
	        }
	        studentData = new Vector<>();
	        tableModel = new DefaultTableModel(studentData,titles);   
	        table = new JTable(tableModel){
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;                  //���ɱ༭
	            }
	        };
	    
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //����ֻ��ѡ��һ��

	        JScrollPane scrollPane = new JScrollPane(table);

	        this.add(scrollPane);
	        //������
	        
	       
	       	
	        Box boxs = Box.createVerticalBox();
	        //��ѯ   
	        Box sbox = Box.createHorizontalBox();
	        JLabel jls1 = new JLabel("��ѡ��Ҫ��ѯ���ֶΣ�");
	        JComboBox<String> jcbselect = new JComboBox<String>();	
	        jcbselect.addItem("ѧ��");     
	        jcbselect.addItem("����");
	     
	        JLabel jls2 = new JLabel("=");
	        JTextField sfield =new JTextField(10);
	        JButton sbtn = new JButton("��ѯ�ü�¼");
	        sbox.add(jls1);
	        sbox.add(jcbselect);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(jls2);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(sfield);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(sbtn);
	        sbox.add(Box.createHorizontalStrut(200));
	         //�����Ϣ
	        Box box1 = Box.createHorizontalBox();
	        JLabel jlnumber = new JLabel("ѧ�ţ�");
	        JTextField numbertext = new JTextField(10);
	        
	        JLabel jlname = new JLabel("������");
	        JTextField nametext = new JTextField(10);
	        
	        JLabel jlsex = new JLabel("�Ա�");
	        JComboBox<String> sexcb = new JComboBox<String>();
	        sexcb.addItem("��");
	        sexcb.addItem("Ů");
	        box1.add(jlnumber);
	        box1.add(numbertext);     
	        box1.add(Box.createHorizontalStrut(20));
	        box1.add(jlname);
	        box1.add(nametext);
	        box1.add(Box.createHorizontalStrut(20));
	        box1.add(jlsex);  
	        box1.add(sexcb);
	        box1.add(Box.createHorizontalStrut(200));
	        
	        Box box2 = Box.createHorizontalBox();
	        JLabel jlage = new JLabel("���䣺");
	        JTextField agetext = new JTextField(10);
	        
	        JLabel jlclass = new JLabel("�༶��ţ�");
	        JTextField classtext = new JTextField(10);
	        
	        JLabel jldepart = new JLabel("רҵ��ţ�");
	        JTextField departtext = new JTextField(10);
	        
	        JLabel jladress = new JLabel("���᣺");
	        JTextField  adresstext = new JTextField(10);
	        
	        box2.add(jlage);
	        box2.add(agetext);     
	        box2.add(Box.createHorizontalStrut(20));
	        box2.add(jlclass);
	        box2.add(classtext);
	        box2.add(Box.createHorizontalStrut(20));
	        box2.add(jldepart);
	        box2.add(departtext);
	        box2.add(Box.createHorizontalStrut(20));
	        box2.add(jladress); 
	        box2.add(adresstext);
	        box2.add(Box.createHorizontalStrut(20));
	       
	       
	        
	        //��ť����  
	        Box btnbox = Box.createHorizontalBox();
	        JButton insert = new JButton("����");
	        JButton update = new JButton("����");
	        JButton updatenew = new JButton("�޸�");
	        JButton deleteselected = new JButton("ɾ����ǰ��¼");
	        JButton deleteAll = new JButton("ɾ�����м�¼");
	        btnbox.add(insert);
	        btnbox.add(Box.createHorizontalStrut(20));
	        btnbox.add(update);
	        btnbox.add(Box.createHorizontalStrut(20));
	        btnbox.add(updatenew);
	        btnbox.add(Box.createHorizontalStrut(20));
	        btnbox.add(deleteselected);
	        btnbox.add(Box.createHorizontalStrut(20));
	        btnbox.add(deleteAll); 
	        btnbox.add(Box.createHorizontalStrut(300));
	        
	     
	        boxs.add(Box.createVerticalStrut(20)); 
	        boxs.add(sbox);
	        boxs.add(Box.createVerticalStrut(20));
	        boxs.add(box1);
	        boxs.add(Box.createVerticalStrut(20));
	        boxs.add(box2);
	        boxs.add(Box.createVerticalStrut(20));
	        boxs.add(btnbox);
	        boxs.add(Box.createVerticalStrut(20));
	      	       
	       JPanel boxpanel = new JPanel();
	       boxpanel.setBackground(new Color(203,220,217));
	       boxpanel.add(boxs);
	       this.add(boxpanel);
	       
	       //��ѯ����
	       sbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> studentIds = new Vector<>();
				String choose = (String) jcbselect.getSelectedItem();  //��ȡѡ��Ĳ�ѯ�ֶ�
//				Map<String,String> rst = new LinkedHashMap<String,String>();	
				///��ȡѧ��
				if(choose.equals("����")) {
					String studentname = sfield.getText().trim();
					 try {
						studentIds = studentsql.getid_byname(studentname);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();					}
					 
				}else if(choose.equals("ѧ��")) {
					 studentIds.add(sfield.getText().trim());
				}
				
				//��ȡ��Ϣ
				new searchAll_JDialog(jf, "��ѯ��ѧ����������Ϣ",true,studentIds).setVisible(true);    //isModel   Ϊ�Ƿ�Ϊģ�飬���ɱ�			
			}
	    	   
	       });
	       

	       
	       //��ѯ�������
	     
	       insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    String number = numbertext.getText().trim();
                String  name= nametext.getText().trim();
                String  gender =(String) sexcb.getSelectedItem();
                String age = agetext.getText().trim();
                String studentclass = classtext.getText().trim();
                String  department = departtext.getText().trim();
                String nativepalce = adresstext.getText().trim();

                Map<String,String> params = new LinkedHashMap<>();
                params.put("studentid", number);
                params.put("name",name); 
                params.put("gender",gender);
                params.put("age",age);
                params.put("class",studentclass);
                params.put("department",department);
                params.put("nativepalce", nativepalce);
                boolean check = false;
            	check =	checktext(params);   //������ݺ�id
			  	if(check==true) {

			 	       try {
					 check = studentsql.checkAllstudentsId(number);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 	      if(check == false) {
			 	    	    JOptionPane.showMessageDialog(jf,"�������ѧ����������ظ�������������ѧ�ţ�");
			 	    	    return ;
			 	    	  
			 	      }else {
			 	    	   try {
							studentsql.InsertIntostudent(params);
						} catch (SQLException e1) {							
							e1.printStackTrace();
						} 
			 	    	   try {
		    				requestData();
		    			} catch (SQLException el) {				
		    				el.printStackTrace();
		    			} 
		                JOptionPane.showMessageDialog(jf,"��ӳɹ���");
			 	      }			  				               
			  	}
			  	else {
			  		return ;
			  	}
			  	//�����ı���Ϊ��
			  	 numbertext.setText("");
	             nametext.setText("");	       
	             agetext.setText("");
	             classtext.setText("");
	             departtext.setText("");
	             adresstext.setText("");
			}
	    	   
	       });
	       //���°�ť
	       update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
						requestData();
					} catch (SQLException el) {				
						el.printStackTrace();
					}   				
			}
	    	   
	       });
	       //�޸���Ϣ
	       updatenew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 int selectedRow = table.getSelectedRow();
					 //�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1
		             if (selectedRow==-1){
		                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫ�޸ĵ���Ŀ��");
		                    return;
		             }
		            String id = tableModel.getValueAt(selectedRow, 0).toString();

				    String number = numbertext.getText().trim();
	                String  name= nametext.getText().trim();
	                String  gender =(String) sexcb.getSelectedItem();
	                String age = agetext.getText().trim();
	                String studentclass = classtext.getText().trim();
	                String  department = departtext.getText().trim();
	                String nativepalce = adresstext.getText().trim();
	             	
	                Map<String,String> params = new LinkedHashMap<>();
	                params.put("studentid", number);
	                params.put("name",name); 
	                params.put("gender",gender);
	                params.put("age",age);
	                params.put("class",studentclass);
	                params.put("department",department);
	                params.put("nativepalce", nativepalce);
	                boolean check = false;
	                
	                
	                check =	checktext(params);   //������ݺ�id
	            	if(check==true) {	            		
	            		if(!id.equals(number)) {            //������ѧ�Ų���ȣ������ѧ���Ƿ��ظ�
	            			 try {
	        					 check = studentsql.checkAllstudentsId(number);
	        					} catch (SQLException e1) {
	        						// TODO Auto-generated catch block
	        						e1.printStackTrace();
	        					}
	            			 if(check==false) {
	            				  JOptionPane.showMessageDialog(jf,"�������ѧ����������ظ�������������ѧ�ţ�");
	            	 	    	    return ;       //����
	            			 }
	            		}
	            			  try {
	  							studentsql.updatestudent(params,id);
	  						} catch (SQLException e1) {							
	  							e1.printStackTrace();
	  						} 
	  			 	    	   try {
	  		    				requestData();
	  		    			} catch (SQLException el) {				
	  		    				el.printStackTrace();
	  		    			} 
	  		              
	  		            //�����ı���Ϊ��
	  					  	 numbertext.setText("");
	  			             nametext.setText("");	       
	  			             agetext.setText("");
	  			             classtext.setText("");
	  			             departtext.setText("");
	  			             adresstext.setText("");
	            		 
	            		JOptionPane.showMessageDialog(jf,"�޸ĳɹ���");	
				     }
				  	else {
				  		return ;
				  	}	               
				}		    	   
		       });
	      //ɾ����ǰ��¼
	       deleteselected.addActionListener(new ActionListener() {

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
							 try {
									studentsql.Deletestudent(id);  
									 JOptionPane.showMessageDialog(jf,"ɾ����ǰ��¼�ɹ���");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
	               
	                try {
	    				requestData();
	    			} catch (SQLException el) {				
	    				el.printStackTrace();
	    			}    
				}		    	   
		       });
	       
	       
	       
	      //ɾ����������	       
	       deleteAll.addActionListener(new ActionListener() {
	    
			@Override
			public void actionPerformed(ActionEvent e) {	
				int res = JOptionPane.showConfirmDialog(jf,  "�Ƿ����?","�Ƿ�ȷ��ɾ����������?", JOptionPane.YES_NO_OPTION); 
				if(res==JOptionPane.YES_OPTION) {
					  try {
				studentsql.deleteAllstudents();
				JOptionPane.showMessageDialog(jf,"ɾ���������ݳɹ���");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				}
			
			}
		   
	     }); 
       
	       table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					 int selectedRow = table.getSelectedRow();
					 String id = tableModel.getValueAt(selectedRow, 0).toString();
					 String name =  tableModel.getValueAt(selectedRow, 1).toString();
					  String gender = tableModel.getValueAt(selectedRow, 2).toString();
					  String age = tableModel.getValueAt(selectedRow, 3).toString();
					  String classname = tableModel.getValueAt(selectedRow, 4).toString();
					  String department = tableModel.getValueAt(selectedRow, 5).toString();
					  String place = tableModel.getValueAt(selectedRow, 6).toString();
					  numbertext.setText(id);
		               nametext.setText(name);
		               int sex = gender=="��"?0:1;
		               sexcb.setSelectedItem(sex);
		               agetext.setText(age);
		               classtext.setText(classname);
		               departtext.setText(department);
		              adresstext.setText(place);
				}
	       }); 
	       //����ȡ����
	        try {
				requestData();
			} catch (SQLException e) {				
				e.printStackTrace();
			}                 //�������� ���Ҹ�������
   
     	}
	 
	 
	 
	   //��������Ƿ�Ϊ�գ���id�ظ���
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
// 	           if(key.equals("studentid")) {
// 	        	   id = value;             //��ȡid��
// 	        	   System.out.println(key+"check:"+id);
// 	           }
 	          if(key.equals("class")) {
	        	   classid = value;             //��ȡid��
//	        	   System.out.println(key+"check:"+id);
	           }
 	         if(key.equals("department")) {
	        	   departmentid = value;             //��ȡid��
//	        	   System.out.println(key+"check:"+id);
	           }
 	       
 	        }
 	        //���id�Ƿ��ظ�
 	        
// 	       try {
//		 check = studentsql.checkAllstudentsId(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 	      if(check ==false) {
// 	    	    JOptionPane.showMessageDialog(jf,"�������ѧ����������ظ�������������ѧ�ţ�");
// 	    	    return false;
// 	      }
 
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
      //��ȡ����
	    @SuppressWarnings("rawtypes")  //waring ���߱��������Ա�������
		public void requestData() throws SQLException{
			
		       studentData.clear();
			Vector<Vector> vectors = studentsql.getstudentData();
		      for(Vector vector :vectors) {
		    	  studentData.add(vector);
		      }
		       tableModel.fireTableDataChanged();      //���±������
		    }
	
}
