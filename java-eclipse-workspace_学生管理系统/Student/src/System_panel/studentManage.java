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
	    student_SQL studentsql = new student_SQL();  //创建数据库对象
	 public studentManage(JFrame jf){
	       
	        super(BoxLayout.Y_AXIS); //垂直布局
	        //组装视图
	        this.jf = jf;
	        
	    
//	        jp.setLayout(new BorderLayout());
	   //学生表
	        String[] ts = {"学号","姓名","性别","年龄","班级","专业","籍贯"}; 
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
	                return false;                  //不可编辑
	            }
	        };
	    
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //设置只能选中一行

	        JScrollPane scrollPane = new JScrollPane(table);

	        this.add(scrollPane);
	        //滚动轴
	        
	       
	       	
	        Box boxs = Box.createVerticalBox();
	        //查询   
	        Box sbox = Box.createHorizontalBox();
	        JLabel jls1 = new JLabel("请选择要查询的字段：");
	        JComboBox<String> jcbselect = new JComboBox<String>();	
	        jcbselect.addItem("学号");     
	        jcbselect.addItem("姓名");
	     
	        JLabel jls2 = new JLabel("=");
	        JTextField sfield =new JTextField(10);
	        JButton sbtn = new JButton("查询该记录");
	        sbox.add(jls1);
	        sbox.add(jcbselect);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(jls2);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(sfield);
	        sbox.add(Box.createHorizontalStrut(20));
	        sbox.add(sbtn);
	        sbox.add(Box.createHorizontalStrut(200));
	         //添加信息
	        Box box1 = Box.createHorizontalBox();
	        JLabel jlnumber = new JLabel("学号：");
	        JTextField numbertext = new JTextField(10);
	        
	        JLabel jlname = new JLabel("姓名：");
	        JTextField nametext = new JTextField(10);
	        
	        JLabel jlsex = new JLabel("性别：");
	        JComboBox<String> sexcb = new JComboBox<String>();
	        sexcb.addItem("男");
	        sexcb.addItem("女");
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
	        JLabel jlage = new JLabel("年龄：");
	        JTextField agetext = new JTextField(10);
	        
	        JLabel jlclass = new JLabel("班级编号：");
	        JTextField classtext = new JTextField(10);
	        
	        JLabel jldepart = new JLabel("专业编号：");
	        JTextField departtext = new JTextField(10);
	        
	        JLabel jladress = new JLabel("籍贯：");
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
	       
	       
	        
	        //按钮操作  
	        Box btnbox = Box.createHorizontalBox();
	        JButton insert = new JButton("插入");
	        JButton update = new JButton("更新");
	        JButton updatenew = new JButton("修改");
	        JButton deleteselected = new JButton("删除当前记录");
	        JButton deleteAll = new JButton("删除所有记录");
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
	       
	       //查询操作
	       sbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> studentIds = new Vector<>();
				String choose = (String) jcbselect.getSelectedItem();  //获取选择的查询字段
//				Map<String,String> rst = new LinkedHashMap<String,String>();	
				///获取学号
				if(choose.equals("姓名")) {
					String studentname = sfield.getText().trim();
					 try {
						studentIds = studentsql.getid_byname(studentname);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();					}
					 
				}else if(choose.equals("学号")) {
					 studentIds.add(sfield.getText().trim());
				}
				
				//获取信息
				new searchAll_JDialog(jf, "查询该学生的所有信息",true,studentIds).setVisible(true);    //isModel   为是否为模块，不可变			
			}
	    	   
	       });
	       

	       
	       //查询操作完毕
	     
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
            	check =	checktext(params);   //检查数据和id
			  	if(check==true) {

			 	       try {
					 check = studentsql.checkAllstudentsId(number);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 	      if(check == false) {
			 	    	    JOptionPane.showMessageDialog(jf,"您输入的学号与表内有重复，请重新输入学号！");
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
		                JOptionPane.showMessageDialog(jf,"添加成功！");
			 	      }			  				               
			  	}
			  	else {
			  		return ;
			  	}
			  	//填入文本置为空
			  	 numbertext.setText("");
	             nametext.setText("");	       
	             agetext.setText("");
	             classtext.setText("");
	             departtext.setText("");
	             adresstext.setText("");
			}
	    	   
	       });
	       //更新按钮
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
	       //修改信息
	       updatenew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 int selectedRow = table.getSelectedRow();
					 //如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1
		             if (selectedRow==-1){
		                    JOptionPane.showMessageDialog(jf,"请选择要修改的条目！");
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
	                
	                
	                check =	checktext(params);   //检查数据和id
	            	if(check==true) {	            		
	            		if(!id.equals(number)) {            //若输入学号不相等，则检验学号是否重复
	            			 try {
	        					 check = studentsql.checkAllstudentsId(number);
	        					} catch (SQLException e1) {
	        						// TODO Auto-generated catch block
	        						e1.printStackTrace();
	        					}
	            			 if(check==false) {
	            				  JOptionPane.showMessageDialog(jf,"您输入的学号与表内有重复，请重新输入学号！");
	            	 	    	    return ;       //结束
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
	  		              
	  		            //填入文本置为空
	  					  	 numbertext.setText("");
	  			             nametext.setText("");	       
	  			             agetext.setText("");
	  			             classtext.setText("");
	  			             departtext.setText("");
	  			             adresstext.setText("");
	            		 
	            		JOptionPane.showMessageDialog(jf,"修改成功！");	
				     }
				  	else {
				  		return ;
				  	}	               
				}		    	   
		       });
	      //删除当前记录
	       deleteselected.addActionListener(new ActionListener() {

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
							 try {
									studentsql.Deletestudent(id);  
									 JOptionPane.showMessageDialog(jf,"删除当前记录成功！");
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
	       
	       
	       
	      //删除所有数据	       
	       deleteAll.addActionListener(new ActionListener() {
	    
			@Override
			public void actionPerformed(ActionEvent e) {	
				int res = JOptionPane.showConfirmDialog(jf,  "是否继续?","是否确定删除所有数据?", JOptionPane.YES_NO_OPTION); 
				if(res==JOptionPane.YES_OPTION) {
					  try {
				studentsql.deleteAllstudents();
				JOptionPane.showMessageDialog(jf,"删除所有数据成功！");
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
		               int sex = gender=="男"?0:1;
		               sexcb.setSelectedItem(sex);
		               agetext.setText(age);
		               classtext.setText(classname);
		               departtext.setText(department);
		              adresstext.setText(place);
				}
	       }); 
	       //表格获取数据
	        try {
				requestData();
			} catch (SQLException e) {				
				e.printStackTrace();
			}                 //加载数据 并且更新数据
   
     	}
	 
	 
	 
	   //检查数据是否为空，和id重复；
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
// 	           if(key.equals("studentid")) {
// 	        	   id = value;             //获取id；
// 	        	   System.out.println(key+"check:"+id);
// 	           }
 	          if(key.equals("class")) {
	        	   classid = value;             //获取id；
//	        	   System.out.println(key+"check:"+id);
	           }
 	         if(key.equals("department")) {
	        	   departmentid = value;             //获取id；
//	        	   System.out.println(key+"check:"+id);
	           }
 	       
 	        }
 	        //检查id是否重复
 	        
// 	       try {
//		 check = studentsql.checkAllstudentsId(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 	      if(check ==false) {
// 	    	    JOptionPane.showMessageDialog(jf,"您输入的学号与表内有重复，请重新输入学号！");
// 	    	    return false;
// 	      }
 
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
      //获取数据
	    @SuppressWarnings("rawtypes")  //waring 告诉编译器忽略编译问题
		public void requestData() throws SQLException{
			
		       studentData.clear();
			Vector<Vector> vectors = studentsql.getstudentData();
		      for(Vector vector :vectors) {
		    	  studentData.add(vector);
		      }
		       tableModel.fireTableDataChanged();      //更新表格数据
		    }
	
}
