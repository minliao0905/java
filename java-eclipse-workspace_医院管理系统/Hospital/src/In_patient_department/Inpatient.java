package In_patient_department;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class Inpatient {

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
	        DefaultMutableTreeNode SickBed = new DefaultMutableTreeNode("病房"); //根节点
	        
	       
	        DefaultMutableTreeNode Allbed = new DefaultMutableTreeNode("所有床位"); 
	        DefaultMutableTreeNode Allpatient= new DefaultMutableTreeNode("所有病人");
	        DefaultMutableTreeNode BedManagement = new DefaultMutableTreeNode("床位管理");
	       
	        DefaultMutableTreeNode patientManagement = new DefaultMutableTreeNode("病人管理");
             
	        SickBed.add(Allpatient);
	        SickBed.add(Allbed);
	        SickBed.add(BedManagement);
            SickBed.add(patientManagement);

	        Color color = new Color(203,220,217);
	       //创建根节点后，创建树对象;
	        JTree tree = new JTree(SickBed);
	        
	        

	        tree.setBackground(color);
	        //设置当前tree默认选中图书管理
	        tree.setSelectionRow(0);
	        tree.addTreeSelectionListener(new TreeSelectionListener() {
	            //当条目选中变化后，这个方法会执行
	            @Override
	            public void valueChanged(TreeSelectionEvent e) {
	                //得到当前选中的结点对象
	                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

	                if (Allpatient.equals(lastPathComponent)){
	                    sp.setRightComponent(new JLabel("所有病人.........."));
	                    sp.setDividerLocation(150);
	                }else if (Allbed.equals(lastPathComponent)){
	                    sp.setRightComponent(new JLabel("所有床位..."));
	                    sp.setDividerLocation(150);
	                } if (BedManagement.equals(lastPathComponent)){
	                    sp.setRightComponent(new BedManagement());
	                    sp.setDividerLocation(150);
	                } if (patientManagement.equals(lastPathComponent)){
	                    sp.setRightComponent(new patientManagement());
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

		JPanel  jp = Inpatient.init();
	   jf.add(jp);
	   jf.setVisible(true);
	   jf.setSize(1000,500);
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	}
	

}
