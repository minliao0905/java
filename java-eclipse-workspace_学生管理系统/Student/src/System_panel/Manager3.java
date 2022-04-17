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
	       
	        super(BoxLayout.Y_AXIS); //��ֱ����
	        //��װ��ͼ
	        this.jf = jf;
	        JPanel btnPanel = new JPanel();
	       
	        Color color = new Color(203,220,217);
	        btnPanel.setBackground(color);
	        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
	        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));       //Ĭ�ϲ��ּ��Ϊ5

	        JButton addBtn = new JButton("���");
	        JButton updateBtn = new JButton("�޸�");
	        JButton deleteBtn = new JButton("ɾ��");
	        btnPanel.add(addBtn);
	        btnPanel.add(updateBtn);
	        btnPanel.add(deleteBtn);
	        
	        
	        
	        JPanel textPanel1 = new JPanel();	       
	        textPanel1.setBackground(color);
	        textPanel1.setMaximumSize(new Dimension(WIDTH,80));            //�������߿�
	        textPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));       //������Ĭ�ϲ��ּ��Ϊ5
	        JPanel textPanel2 = new JPanel();	       
	        textPanel2.setBackground(color);
	        textPanel2.setMaximumSize(new Dimension(WIDTH,80));            
	        textPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));       
	        
         JLabel jlid = new JLabel("��¼�ţ�");
         JTextField idtext = new JTextField(10);
         JLabel jlsnumber = new JLabel("ѧ�ţ�");
         JTextField snumbertext = new JTextField(10);
         JLabel jlname = new JLabel("������");
         JTextField nametext = new JTextField(10);
         //���ѡ���
         JLabel jlchange = new JLabel("����");
         JComboBox<String> changejcb = new JComboBox<String>();
         changejcb.addItem("����1");
         changejcb.addItem("���ؾ���2");
         changejcb.addItem("�ǹ�3");
         changejcb.addItem("�Ǵ��4");
         changejcb.addItem("����5");            //ѧ������ɾ����ѧ����Ϣ
      
         JLabel jlok = new JLabel("�Ƿ���Ч:");
         JTextField oktext = new JTextField(10);
         JLabel jltime = new JLabel("��¼ʱ�䣺");
         JTextField timetext = new JTextField(10);
         JLabel jlother = new JLabel("��ϸ������");
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
          
	   //ѧ���ͷ���
	        String[] ts = {"��¼��","����","����","ѧ��","��¼ʱ��","��ϸ����","�Ƿ���Ч"}; 
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
	    
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //����ֻ��ѡ��һ��

	        JScrollPane scrollPane = new JScrollPane(table);
	        this.add(scrollPane);
	        this.add(textPanel1);
	        this.add(textPanel2);
	        this.add(btnPanel);
	       

	        //������
	        //��Ӱ�ť�¼�
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
	            	check =	checktext(params);   //������ݺ�id
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
			                JOptionPane.showMessageDialog(jf,"��ӳɹ���");
				  	}else {
				  		return ;
				  	}
				  	//�����ı���Ϊ��
				    idtext.setText("");
				    snumbertext.setText("");
	                nametext.setText("");
	                timetext.setText("");
	                othertext.setText("");
	                oktext.setText("");
				}
		    	   
		       });
		   
		       //�޸���Ϣ
		       updateBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						 int selectedRow = table.getSelectedRow();
						 //�����ѡ�е���Ŀ���򷵻���Ŀ���кţ����û��ѡ�У���ô����-1
			             if (selectedRow==-1){
			                    JOptionPane.showMessageDialog(jf,"��ѡ��Ҫ�޸ĵ���Ŀ��");
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
		            	check =	checktext(params);   //������ݺ�id
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
				                JOptionPane.showMessageDialog(jf,"�޸ĳɹ���");
					  	}else {
					  		return ;
					  	}
					  	//�����ı���Ϊ��
					    idtext.setText("");
					    snumbertext.setText("");
		                nametext.setText("");
		                timetext.setText("");
		                othertext.setText("");
		                oktext.setText("");
		               
					}		    	   
			       });
		      //ɾ����ǰ��¼
		       deleteBtn.addActionListener(new ActionListener() {

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
										managersql.Deletepunishment(id);  
										 JOptionPane.showMessageDialog(jf,"ɾ����ǰ��¼�ɹ���");
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
				}              //�������� ���Ҹ�������
  
		      
	    }
	    //��������Ƿ�Ϊ�գ���id�ظ���
        public  boolean checktext(Map<String,String> params) {
        	boolean check = false;
        	//1����������Ƿ�Ϊ��
        	 Set<String> keySet = params.keySet();        	 
 	         String studentnumber = new String();
 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
 	        {   
 	            String key = it.next();
 	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
 	            String value = params.get(key); 
 	           
 	           if(value.equals("")) {
 	        	   JOptionPane.showMessageDialog(jf,"�������ݲ���Ϊ��,����������!"); 
 	        	   return false;	 	        	
 	           }
 	           if(key.equals("number")) {
 	        		 studentnumber = params.get(key);
 	           }
 	        }
 	      //2.���ѧ���Ƿ����
 	     try {
			check =  managersql.checkAllstudentsId(studentnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	    if(check==false) {
        	   JOptionPane.showMessageDialog(jf,"�����ѧ�Ų����ڣ����������룡"); 
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
			       tableModel.fireTableDataChanged();      //���±������
			    }


}
