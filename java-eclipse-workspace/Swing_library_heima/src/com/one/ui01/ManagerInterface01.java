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
    JFrame jf = new JFrame("����ͼ��ݣ�С���������ݿ�棩��Xxx����ӭ��");

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //��װ��ͼ
    public void init() throws Exception {
        //��������������
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //���ò˵���
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("����");
        JMenuItem m1 = new JMenuItem("�л��˺�");
        JMenuItem m2 = new JMenuItem("�˳�����");
        
        //�˵����İ�ť
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
        //��ť���ý���
        
        //���÷ָ����
        JSplitPane sp = new JSplitPane();

        //֧����������
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);    ///�ָ����ĳ�ʼλ��
        sp.setDividerSize(7);          //���Ϊ�߸�����  �м��и��ָ���

        //�����������    //tree������ڵ㣬
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("ϵͳ����"); //���ڵ�
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("�û�����");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("ͼ�����");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("���Ĺ���");
        DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("ͳ�Ʒ���");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsManage);

        Color color = new Color(203,220,217);
       //�������ڵ�󣬴���������;
        JTree tree = new JTree(root);
        
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));
        tree.setCellRenderer(myRenderer);

        tree.setBackground(color);
        //���õ�ǰtreeĬ��ѡ��ͼ�����
        tree.setSelectionRow(2);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //����Ŀѡ�б仯�����������ִ��
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //�õ���ǰѡ�еĽ�����
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if (userManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("��������û�����..."));
                    sp.setDividerLocation(150);
                }else if (bookManage.equals(lastPathComponent)){
                    sp.setRightComponent(new BookManageComponent01(jf));
                    sp.setDividerLocation(150);
                } if (borrowManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("������н��Ĺ���..."));
                    sp.setDividerLocation(150);
                } if (statisticsManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("�������ͳ�Ʒ���..."));
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

    //�Զ����������
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
