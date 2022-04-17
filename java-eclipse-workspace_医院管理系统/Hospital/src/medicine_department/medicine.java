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
	     jp.setLayout(new BorderLayout());      //���ò��ֹ���
		  JSplitPane sp = new JSplitPane();    //�ָ����
	        sp.setContinuousLayout(true);
	        sp.setDividerLocation(150);    ///��߿��
	        sp.setDividerSize(7);          //���Ϊ�߸�����  �м��и��ָ���
	        
//	        JLabel jl = new JLabel("סԺ��");
//	     	jp.add(jl);
	        
	        //�����������    //tree������ڵ㣬
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("ҩƷ������"); //���ڵ�
	        
	       
	    
	        DefaultMutableTreeNode MedicineManagement = new DefaultMutableTreeNode("ҩƷ");
	       
	        DefaultMutableTreeNode productManagement = new DefaultMutableTreeNode("����");
             root.add(MedicineManagement);
             root.add(productManagement);
	         
	        Color color = new Color(203,220,217);
	       //�������ڵ�󣬴���������;
	        JTree tree = new JTree(root);
	        
	        

	        tree.setBackground(color);
	        //���õ�ǰtreeĬ��ѡ��ͼ�����
	        tree.setSelectionRow(0);
	        tree.addTreeSelectionListener(new TreeSelectionListener() {
	            //����Ŀѡ�б仯�����������ִ��
	            @Override
	            public void valueChanged(TreeSelectionEvent e) {
	                //�õ���ǰѡ�еĽ�����
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
		
	   JFrame jf = new JFrame("סԺ��");

		JPanel  jp = medicine.init();
	   jf.add(jp);
	   jf.setVisible(true);
	   jf.setSize(1000,500);
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	}
	

}
