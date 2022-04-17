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



public class Manager3 extends Box{


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		final int WIDTH=850;
	    final int HEIGHT=600;

	    JFrame jf = null;
	    private JTable table; 
	    private Vector<String> titles;
	    private Vector<Vector> tableData;
	    private DefaultTableModel tableModel;
	    private Vector<Vector> Manager3Data;
	 
        Manager_SQl managersql = new Manager_SQl();
	    public Manager3(JFrame jf){
	       
	        super(BoxLayout.Y_AXIS); //垂直布局
	        //组装视图
	        this.jf = jf;
	        JPanel btnPanel = new JPanel();
	       
	        Color color = new Color(203,220,217);
	        btnPanel.setBackground(color);
	        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
	        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));       //默认布局间隔为5

	        JButton addBtn = new JButton("添加");
	        JButton updateBtn = new JButton("修改");
	        JButton deleteBtn = new JButton("删除");
	        btnPanel.add(addBtn);
	        btnPanel.add(updateBtn);
	        btnPanel.add(deleteBtn);
	        
	        
	        
	        JPanel textPanel1 = new JPanel();	       
	        textPanel1.setBackground(color);
	        textPanel1.setMaximumSize(new Dimension(WIDTH,80));            //设置最大高宽；
	        textPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));       //流布局默认布局间隔为5
	        JPanel textPanel2 = new JPanel();	       
	        textPanel2.setBackground(color);
	        textPanel2.setMaximumSize(new Dimension(WIDTH,80));            
	        textPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));       
	        
         JLabel jlid = new JLabel("记录号：");
         JTextField idtext = new JTextField(10);
         JLabel jlsnumber = new JLabel("学号：");
         JTextField snumbertext = new JTextField(10);
         JLabel jlname = new JLabel("姓名：");
         JTextField nametext = new JTextField(10);
         //变更选择框
         JLabel jlchange = new JLabel("级别：");
         JComboBox<String> changejcb = new JComboBox<String>();
         changejcb.addItem("警告1");
         changejcb.addItem("严重警告2");
         changejcb.addItem("记过3");
         changejcb.addItem("记大过4");
         changejcb.addItem("开除5");            //学生表中删除该学生信息
      
         JLabel jlok = new JLabel("是否生效:");
         JTextField oktext = new JTextField(10);
         JLabel jltime = new JLabel("记录时间：");
         JTextField timetext = new JTextField(10);
         JLabel jlother = new JLabel("详细描述：");
         JTextField othertext = new JTextField(10);
         
         textPanel1.add(jlid);
         textPanel1.add(idtext);
         textPanel1.add(jlsnumber);
         textPanel1.add(snumbertext);
         textPanel1.add(jlname);
         textPanel1.add(nametext);
         textPanel1.add(jlchange);
         textPanel1.add(changejcb);
         textPanel2.add(jlok);
         textPanel2.add(oktext);
         textPanel2.add(jltime);
         textPanel2.add(timetext);
         textPanel2.add(jlother);
         textPanel2.add(othertext);
          
	   //学生惩罚表
	        String[] ts = {"记录号","级别","姓名","学号","记录时间","详细描述","是否生效"}; 
	        titles = new Vector<>();
	        for (String title : ts) {
	            titles.add(title);
	        }
	        Manager3Data = new Vector<>();
	        tableModel = new DefaultTableModel(Manager3Data,titles);   
	        table = new JTable(tableModel){
	            /**
				 * 
				 */
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
	       

	        //滚动轴
	        //添加按钮事件
		       addBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				    String id = idtext.getText().trim();
	                String  number= snumbertext.getText().trim();
	                String  name  = nametext.getText().trim();
	                String  change =(String) changejcb.getSelectedItem();
	                change = change.substring(change.length()-1,change.length());
	                String   time = timetext.getText().trim();
	                String  other = othertext.getText().trim();
	                String ok = oktext.getText().trim();

	                Map<String,String> params = new LinkedHashMap<>();
	                params.put("id", id);  
	                params.put("change",change);
	                params.put("name",name);
	                params.put("number",number);        
	                params.put("time",time);
	                params.put("other",other);
	                params.put("oktext",ok);
	                boolean check = false;
	            	check =	checktext(params);   //检查数据和id
				  	if(check==true) {
				  		 try {
								managersql.InsertIntopunishment(params);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			                try {
			    				requestData();
			    			} catch (SQLException el) {				
			    				el.printStackTrace();
			    			} 
			                JOptionPane.showMessageDialog(jf,"添加成功！");
				  	}else {
				  		return ;
				  	}
				  	//填入文本置为空
				    idtext.setText("");
				    snumbertext.setText("");
	                nametext.setText("");
	                timetext.setText("");
	                othertext.setText("");
	                oktext.setText("");
				}
		    	   
		       });
		   
		       //修改信息
		       updateBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						 int selectedRow = table.getSelectedRow();
						 //如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1
			             if (selectedRow==-1){
			                    JOptionPane.showMessageDialog(jf,"请选择要修改的条目！");
			                    return;
			             }
			            String id = tableModel.getValueAt(selectedRow, 0).toString();
		                String  number= snumbertext.getText().trim();
		                String  name  = nametext.getText().trim();
		                String  change =(String) changejcb.getSelectedItem();
		                change = change.substring(change.length()-1,change.length());
		                String   time = timetext.getText().trim();
		                String  other = othertext.getText().trim();
		                String ok = oktext.getText().trim();

		                Map<String,String> params = new LinkedHashMap<>();
		                params.put("id", id);  
		                params.put("change",change);
		                params.put("name",name);
		                params.put("number",number);        
		                params.put("time",time);
		                params.put("other",other);
		                params.put("oktext",ok);
		              
		                boolean check = false;
		            	check =	checktext(params);   //检查数据和id
					  	if(check==true) {
					  		 try {
									managersql.updateIntopunishment(params,id);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				                try {
				    				requestData();
				    			} catch (SQLException el) {				
				    				el.printStackTrace();
				    			} 
				                JOptionPane.showMessageDialog(jf,"修改成功！");
					  	}else {
					  		return ;
					  	}
					  	//填入文本置为空
					    idtext.setText("");
					    snumbertext.setText("");
		                nametext.setText("");
		                timetext.setText("");
		                othertext.setText("");
		                oktext.setText("");
		               
					}		    	   
			       });
		      //删除当前记录
		       deleteBtn.addActionListener(new ActionListener() {

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
										managersql.Deletepunishment(id);  
										 JOptionPane.showMessageDialog(jf,"删除当前记录成功！");
									} catch (SQLException e1) {
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
		       
		       try {
					requestData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}              //加载数据 并且更新数据
  
		      
	    }
	    //检查数据是否为空，和id重复；
        public  boolean checktext(Map<String,String> params) {
        	boolean check = false;
        	//1。检查数据是否为空
        	 Set<String> keySet = params.keySet();        	 
 	         String studentnumber = new String();
 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
 	        {   
 	            String key = it.next();
 	            // 有了键可以通过map集合的get方法获取获取其对应的值。
 	            String value = params.get(key); 
 	           
 	           if(value.equals("")) {
 	        	   JOptionPane.showMessageDialog(jf,"输入内容不能为空,请重新输入!"); 
 	        	   return false;	 	        	
 	           }
 	           if(key.equals("number")) {
 	        		 studentnumber = params.get(key);
 	           }
 	        }
 	      //2.检查学号是否存在
 	     try {
			check =  managersql.checkAllstudentsId(studentnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	    if(check==false) {
        	   JOptionPane.showMessageDialog(jf,"输入的学号不存在！请重新输入！"); 
        	   return false;	 	        	
           }
 	        return check;
 	     
        }

		
			

			public void requestData() throws SQLException{
				
			       Manager3Data.clear();
				Vector<Vector> vectors = managersql.getManager3Data();
			      for(Vector vector :vectors) {
			    	  Manager3Data.add(vector);
			      }
			       tableModel.fireTableDataChanged();      //更新表格数据
			    }


}
