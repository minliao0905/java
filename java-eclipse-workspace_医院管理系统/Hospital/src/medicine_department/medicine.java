package medicine_department;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class medicine {

	public static JPanel init() {
		
		JPanel jp = new JPanel();	  	
	     jp.setLayout(new BorderLayout());      //设置布局管理
		  JSplitPane sp = new JSplitPane();    //分割面板
	        sp.setContinuousLayout(true);
	        sp.setDividerLocation(150);    ///左边宽度
	        sp.setDividerSize(7);          //宽度为七个像素  中间有个分割间距
	        
//	        JLabel jl = new JLabel("住院部");
//	     	jp.add(jl);
	        
	        //设置左侧内容    //tree里的树节点，
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("药品与仪器"); //根节点
	        
	       
	    
	        DefaultMutableTreeNode MedicineManagement = new DefaultMutableTreeNode("药品");
	       
	        DefaultMutableTreeNode productManagement = new DefaultMutableTreeNode("仪器");
             root.add(MedicineManagement);
             root.add(productManagement);
	         
	        Color color = new Color(203,220,217);
	       //创建根节点后，创建树对象;
	        JTree tree = new JTree(root);
	        
	        

	        tree.setBackground(color);
	        //设置当前tree默认选中图书管理
	        tree.setSelectionRow(0);
	        tree.addTreeSelectionListener(new TreeSelectionListener() {
	            //当条目选中变化后，这个方法会执行
	            @Override
	            public void valueChanged(TreeSelectionEvent e) {
	                //得到当前选中的结点对象
	                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

	                if (MedicineManagement.equals(lastPathComponent)){
	                    sp.setRightComponent(new MedicineManagement());
	                    sp.setDividerLocation(150);
	                }else if (productManagement.equals(lastPathComponent)){
	                    sp.setRightComponent(new productManagement());
	                    sp.setDividerLocation(150);
	                } 
	            }
	        });


//	        sp.setRightComponent(new BookManageComponent01(jf));
	        sp.setLeftComponent(tree);
	        jp.add(sp);
	        jp.setVisible(true);
	       

	        
		jp.setBackground(new Color(255,255,255));
	    
		return jp;
		
	}
	public static void main(String[] agrs) {
		
	   JFrame jf = new JFrame("住院部");

		JPanel  jp = medicine.init();
	   jf.add(jp);
	   jf.setVisible(true);
	   jf.setSize(1000,500);
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	}
	

}
