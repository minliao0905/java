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
	       
	        super(BoxLayout.Y_AXIS); //垂直布局
	        //组装视图
	        this.jf = jf;
	        JPanel btnPanel = new JPanel();
	       
	        Color color = new Color(203,220,217);
	        btnPanel.setBackground(color);
	        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
	        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));       //默认布局间隔为5
	        
            JButton addTotable = new JButton("添加至表格");
	        JButton addToBtn = new JButton("添加至学生表");	
	        JButton updateselect = new JButton("修改");
	        JButton clearselect = new JButton("删除当前行");
	        JButton clearAll = new JButton("清空表格所有内容");
	        btnPanel.add(addTotable);
	        btnPanel.add(addToBtn);
	        btnPanel.add(clearselect);
	        btnPanel.add(updateselect);
	        btnPanel.add(clearAll);
	        
	        
	        
	        JPanel textPanel1 = new JPanel();	       
	        textPanel1.setBackground(color);
	        textPanel1.setMaximumSize(new Dimension(WIDTH,80));            //设置最大高宽；
	        textPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));       //流布局默认布局间隔为5
	        JPanel textPanel2 = new JPanel();	       
	        textPanel2.setBackground(color);
	        textPanel2.setMaximumSize(new Dimension(WIDTH,80));            
	        textPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));       
	        
        
         JLabel jlsnumber = new JLabel("学号：");
         JTextField snumbertext = new JTextField(10);
         JLabel jlname = new JLabel("姓名：");
         JTextField nametext = new JTextField(10);
         JLabel jlsex = new JLabel("性别：");
	     JComboBox<String> sexjcb = new JComboBox<String>();
	     sexjcb.addItem("男");
	     sexjcb.addItem("女");
	     JLabel jlage = new JLabel("年龄：");
	     JTextField agetext = new JTextField(10);
	     JLabel jlclass = new JLabel("班级编号：");
	     JTextField classtext = new JTextField(10);
	     JLabel jldepart = new JLabel("专业编号：");
	     JTextField departtext = new JTextField(10);	    
	     JLabel jladdress = new JLabel("籍贯：");
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
          
         String[] ts = {"学号","姓名","性别","年龄","班级","专业","籍贯"}; 
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
	    
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //设置只能选中一行

	        JScrollPane scrollPane = new JScrollPane(table);
	        this.add(scrollPane);
	        this.add(textPanel1);
	        this.add(textPanel2);
	        this.add(btnPanel);
	        
	        student_SQL studentsql =new student_SQL();
	    //添加至表格    
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
	    		            	check =	checktext(params);   //检查数据和id
	    					  	if(check==true) {
	    					  		//检查学号部分
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
	    					 	    	    JOptionPane.showMessageDialog(jf,"您输入的学号已经存在，请重新输入学号！");
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
	    					 	       tableModel.fireTableDataChanged();      //更新表格数据
	    					 	      }			  				               
	    					  	}
	    					  	else {
	    					  		return ;
	    					  	}
	    					  	//填入文本置为空	    					 
	    					  	 snumbertext.setText("");
	    			             nametext.setText("");	       
	    			             agetext.setText("");
	    			             classtext.setText("");
	    			             departtext.setText("");
	    			             addresstext.setText("");
	    				}  
	    		       });
	    //添加至学生表中
	        addToBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				for(Vector<String> vector:studentData) {
					try {
						studentsql.Insertnewstudent(vector);
					} catch (SQLException e1) {
//						System.out.println("数据错误1");
						e1.printStackTrace();
					}
					
				}
					JOptionPane.showMessageDialog(jf,"所有新生信息已成功添加至学生表！");
				}
	        	
	        });
	   	//修改内容
	        updateselect.addActionListener(new ActionListener() {
	        	@Override
				public void actionPerformed(ActionEvent e) {
					 int selectedRow = table.getSelectedRow(); //如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1					
		             if (selectedRow==-1){
		                    JOptionPane.showMessageDialog(jf,"请选择要修改的条目！");
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
            
	                check =	checktext(params);   //检查数据是否为空
	            	if(check==true) {
	            		if(!id.equals(snumber)) {            //若输入学号不相等，则检验学号是否重复
	            			 try {
	        					 check = studentsql.checkAllstudentsId(snumber); 
	        					} catch (SQLException e1) {
	        						e1.printStackTrace();
	        					}
	            			 if(check==false) {
	            				  JOptionPane.showMessageDialog(jf,"您输入的学号与表内有重复，请重新输入学号！");
	            	 	    	    return ;       //结束
	            			 }	            			 
	            		}
	            		//遍历Map数组
	            		 Set<String> keySet = params.keySet();  
	            		 int i=0;
			 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
			 	        {   
			 	            String key = it.next();
			 	            String value = params.get(key);
			 	          tableModel.setValueAt(value, selectedRow,i ) ;     //修改表格：
			 	          i++;
			 	        }	
			 	       tableModel.fireTableDataChanged();      //更新表格数据
	 	     			  				              		
				  	}
				  	else {
				  		return ;
				  	}	               			
				}	        	
	        });
	    //清空表格内容
	     clearAll.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {      
		             int res = JOptionPane.showConfirmDialog(jf,  "是否删除表格内所有数据?","是否继续?", JOptionPane.YES_NO_OPTION); 
						if(res==JOptionPane.YES_OPTION) {
							  studentData.clear();
							  tableModel.fireTableDataChanged();      //更新表格数据
						}
	               
				}		    	   
		       });					
	  
	    //删除当前行
	       clearselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
				 //如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1
	             if (selectedRow==-1){
	                    JOptionPane.showMessageDialog(jf,"请选择要删除的条目！");
	                    return;
	             }
	             String id = tableModel.getValueAt(selectedRow, 0).toString();
	            
	             int res = JOptionPane.showConfirmDialog(jf,  "是否继续?","是否确定删除当前数据?", JOptionPane.YES_NO_OPTION); 
					if(res==JOptionPane.YES_OPTION) {
						  tableModel.removeRow(selectedRow);
					}
					  tableModel.fireTableDataChanged();      //更新表格数据
		
			}
	    	   
	       }); 
	       
	    }
	    
  
	    //检查函数                   
	    public  boolean checktext(Map<String,String> params) {

        	boolean check = false;
        	//检查数据是否为空
        	 Set<String> keySet = params.keySet();        	 
 	         String id= new String();
 	        String classid= new String();
 	       String departmentid= new String();
 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
 	        {   
 	            String key = it.next();
 	            // 有了键可以通过map集合的get方法获取获取其对应的值。
 	            String value = params.get(key);
 	           if(value.equals("")) {
 	        	   JOptionPane.showMessageDialog(jf,"输入内容不能为空,请重新输入!"); 
 	        	   return false;
 	           }
 	          if(key.equals("class")) {
	        	   classid = value;             //获取id；
	           }
 	         if(key.equals("department")) {
	        	   departmentid = value;             //获取id；
	           }	       
 	        }

 	       try {
			check = studentsql.checkAllclass_departmentId(departmentid, classid);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
 	       if(check ==false) {
	    	    JOptionPane.showMessageDialog(jf,"您输入的班级编号和专业编号有误，请重新输入！");
	    	    return false;
	      }
        	return true;
        }
       
			

}
