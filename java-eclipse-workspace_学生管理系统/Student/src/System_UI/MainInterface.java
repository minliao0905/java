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
  JFrame jf = new JFrame("学生管理系统");
   final int   WIDTH = 1000;
   final int   HEIGHT = 600;
   JPanel Mainpanel = new JPanel();
	public void init() throws Exception{
		//菜单栏
	     //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("管理.png"))));

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu MenuAct = new JMenu("账号");
        JMenuItem mAct1 = new JMenuItem("切换账号");
        JMenuItem mAct2 = new JMenuItem("退出程序");
        MenuAct.add(mAct1);
        MenuAct.add(mAct2);
    
        jmb.add(MenuAct);
        //账号按钮
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
        //注册
        mAct2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //分割面板
        JSplitPane sp = new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);   //分割条的最初位置
        sp.setDividerSize(7);       //分割线的宽度
        //设置左侧节点内容   //建立树节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("学生管理");
        DefaultMutableTreeNode newstudents = new DefaultMutableTreeNode("新生信息输入");
        DefaultMutableTreeNode Manager = new DefaultMutableTreeNode("教务管理信息输入");
        DefaultMutableTreeNode personal =  new DefaultMutableTreeNode("学生个人信息管理");
        DefaultMutableTreeNode Manager1 =  new DefaultMutableTreeNode("学籍管理");
        DefaultMutableTreeNode  Manager2 =  new DefaultMutableTreeNode("奖学金评定");
        DefaultMutableTreeNode  Manager3 =  new DefaultMutableTreeNode("处罚记录");
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
        tree.setSelectionRow(2);  //设置当前tree默认选中图书管理
       tree.addTreeSelectionListener(new TreeSelectionListener() {
    	    @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象 
    	    	  //返回选择路径的第一个元素  //因为若选择Manage 不关闭节点而选择其他节点就会报错， e.getNewLeadSelectionPath().getLastPathComponent() =null
    	        Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
    	    	   
    	       //教务管理处的三个界面
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
    	    	    sp.setRightComponent(new JLabel("教务管理..."));
    	            sp.setDividerLocation(150);
    	      }else  if (newstudents.equals(lastPathComponent)){                
                    sp.setRightComponent(new newstudents(jf));
                    sp.setDividerLocation(150);
              }else if (personal.equals(lastPathComponent)){
                    sp.setRightComponent(new studentManage(jf));           //学生个人信息管理
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
	
    //自定义结点绘制器
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

        //当绘制树的每个结点时，都会调用这个方法
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //使用默认绘制
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
