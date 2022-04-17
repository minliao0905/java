package System_UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import System_Component.PathUtils;
import System_Component.ScreenUtils;
import System_panel.*;



public class MainInterface  {
  JFrame jf = new JFrame("ѧ������ϵͳ");
   final int   WIDTH = 1000;
   final int   HEIGHT = 600;
   JPanel Mainpanel = new JPanel();
	public void init() throws Exception{
		//�˵���
	     //��������������
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("����.png"))));

        //���ò˵���
        JMenuBar jmb = new JMenuBar();
        JMenu MenuAct = new JMenu("�˺�");
        JMenuItem mAct1 = new JMenuItem("�л��˺�");
        JMenuItem mAct2 = new JMenuItem("�˳�����");
        MenuAct.add(mAct1);
        MenuAct.add(mAct2);
    
        jmb.add(MenuAct);
        //�˺Ű�ť
        mAct1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new student_login().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //ע��
        mAct2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //�ָ����
        JSplitPane sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);   //�ָ��������λ��
        sp.setDividerSize(7);       //�ָ��ߵĿ��
        //�������ڵ�����   //�������ڵ�
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("ѧ������");
        DefaultMutableTreeNode newstudents = new DefaultMutableTreeNode("������Ϣ����");
        DefaultMutableTreeNode Manager = new DefaultMutableTreeNode("���������Ϣ����");
        DefaultMutableTreeNode personal =  new DefaultMutableTreeNode("ѧ��������Ϣ����");
        DefaultMutableTreeNode Manager1 =  new DefaultMutableTreeNode("ѧ������");
        DefaultMutableTreeNode  Manager2 =  new DefaultMutableTreeNode("��ѧ������");
        DefaultMutableTreeNode  Manager3 =  new DefaultMutableTreeNode("������¼");
        Manager.add(Manager1);
        Manager.add(Manager2);
        Manager.add(Manager3);
        
        root.add(newstudents);
        root.add(personal);
        root.add(Manager);
        JTree tree = new JTree(root);
        Color color = new Color(203,220,217);
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
        tree.setCellRenderer(myRenderer);
              
        tree.setBackground(color);      
        tree.setSelectionRow(2);  //���õ�ǰtreeĬ��ѡ��ͼ�����
       tree.addTreeSelectionListener(new TreeSelectionListener() {
    	    @Override
            public void valueChanged(TreeSelectionEvent e) {
                //�õ���ǰѡ�еĽ����� 
    	    	  //����ѡ��·���ĵ�һ��Ԫ��  //��Ϊ��ѡ��Manage ���رսڵ��ѡ�������ڵ�ͻᱨ�� e.getNewLeadSelectionPath().getLastPathComponent() =null
    	        Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
    	    	   
    	       //�����������������
    	        if(Manager1.equals(lastPathComponent)) {
                  	 sp.setRightComponent(new System_panel.Manager1(jf));
                     sp.setDividerLocation(150);
                   }else if(Manager2.equals(lastPathComponent)) {
               	     sp.setRightComponent(new System_panel.Manager2(jf));
                     sp.setDividerLocation(150);
                   }else if(Manager3.equals(lastPathComponent)) {
              	     sp.setRightComponent(new System_panel.Manager3(jf));
                     sp.setDividerLocation(150);
                   } 
    	     if(Manager.equals(lastPathComponent)) {   	    	 
    	    	    sp.setRightComponent(new JLabel("�������..."));
    	            sp.setDividerLocation(150);
    	      }else  if (newstudents.equals(lastPathComponent)){                
                    sp.setRightComponent(new newstudents(jf));
                    sp.setDividerLocation(150);
              }else if (personal.equals(lastPathComponent)){
                    sp.setRightComponent(new studentManage(jf));           //ѧ��������Ϣ����
                    sp.setDividerLocation(150);
              } 
          
            }
    	   
       });
        sp.setRightComponent(new studentManage (jf));
        sp.setLeftComponent(tree);
       
        jf.add(sp);
        jf.setJMenuBar(jmb);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		try {
			new MainInterface().init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    //�Զ����������
    @SuppressWarnings("serial")
	private class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon newstudentsIcon = null;
        private ImageIcon  personalIcon= null; 
        private ImageIcon manegerIcon = null;
        private ImageIcon Maneger1Icon = null;
        private ImageIcon Maneger2Icon = null;
        private ImageIcon Maneger3Icon = null;

        public MyRenderer() { 
        	        
            rootIcon = new ImageIcon(PathUtils.getImagePath("userManage.png"));
            newstudentsIcon = new ImageIcon(PathUtils.getImagePath("bookManage.png"));
            personalIcon = new ImageIcon(PathUtils.getImagePath("borrowManage.png"));
            manegerIcon = new ImageIcon(PathUtils.getImagePath("statisticsManage.png"));
            Maneger1Icon = new ImageIcon(PathUtils.getImagePath("statisticsManage.png"));
            Maneger2Icon = new ImageIcon(PathUtils.getImagePath("statisticsManage.png"));
            Maneger3Icon = new ImageIcon(PathUtils.getImagePath("statisticsManage.png"));

        }

        //����������ÿ�����ʱ����������������
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //ʹ��Ĭ�ϻ���
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            ImageIcon image = null;
            switch (row) {
                case 0:
                    image = rootIcon;
                    break;
                case 1:
                    image = newstudentsIcon;
                    break;
                case 2:
                    image = personalIcon;
                    break;
                case 3:
                    image = manegerIcon;
                    break;
                case 4:
                    image = Maneger1Icon;
                    break;
                case 5:
                    image = Maneger2Icon;
                    break;
                case 6:
                    image = Maneger3Icon;
                    break;
            }

            this.setIcon(image);
            return this;
        }
    }

	

}
