package com.one.ui01;


import com.one.component01.BookManageComponent01;
import com.one.domain.ResultInfo;
import com.one.net.FailListener;
import com.one.net.GetUtils;
import com.one.net.SuccessListener;
import com.one.ui.MainInterface;
import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ManagerInterface01 {
    JFrame jf = new JFrame("黑马图书馆（小郭连接数据库版）：Xxx，欢迎您");

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //组装视图
    public void init() throws Exception {
        //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem m1 = new JMenuItem("切换账号");
        JMenuItem m2 = new JMenuItem("退出程序");
        
        //菜单栏的按钮
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterface01().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);
     
        jf.setJMenuBar(jmb);
        //按钮设置结束
        
        //设置分割面板
        JSplitPane sp = new JSplitPane();

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);    ///分割条的初始位置
        sp.setDividerSize(7);          //宽度为七个像素  中间有个分割间距

        //设置左侧内容    //tree里的树节点，
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理"); //根节点
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("统计分析");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsManage);

        Color color = new Color(203,220,217);
       //创建根节点后，创建树对象;
        JTree tree = new JTree(root);
        
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
        tree.setCellRenderer(myRenderer);

        tree.setBackground(color);
        //设置当前tree默认选中图书管理
        tree.setSelectionRow(2);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (userManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行用户管理..."));
                    sp.setDividerLocation(150);
                }else if (bookManage.equals(lastPathComponent)){
                    sp.setRightComponent(new BookManageComponent01(jf));
                    sp.setDividerLocation(150);
                } if (borrowManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行借阅管理..."));
                    sp.setDividerLocation(150);
                } if (statisticsManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行统计分析..."));
                    sp.setDividerLocation(150);
                }

            }
        });


        sp.setRightComponent(new BookManageComponent01(jf));
        sp.setLeftComponent(tree);
        jf.add(sp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        try {
            new ManagerInterface01().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //自定义结点绘制器
    @SuppressWarnings("serial")
	private class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon userManageIcon = null;
        private ImageIcon bookManageIcon = null;
        private ImageIcon borrowManageIcon = null;
        private ImageIcon statisticsManageIcon = null;

        public MyRenderer() { 
        	
            rootIcon = new ImageIcon(PathUtils.getRealPath("systemManage.png"));
            userManageIcon = new ImageIcon(PathUtils.getRealPath("userManage.png"));
            bookManageIcon = new ImageIcon(PathUtils.getRealPath("bookManage.png"));
            borrowManageIcon = new ImageIcon(PathUtils.getRealPath("borrowManage.png"));
            statisticsManageIcon = new ImageIcon(PathUtils.getRealPath("statisticsManage.png"));

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
                    image = userManageIcon;
                    break;
                case 2:
                    image = bookManageIcon;
                    break;
                case 3:
                    image = borrowManageIcon;
                    break;
                case 4:
                    image = statisticsManageIcon;
                    break;
            }

            this.setIcon(image);
            return this;
        }
    }
}
