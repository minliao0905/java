package MVC;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class kcb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame();
        
		// 创建表格内容的容器
		Vector<Vector<Object>> contextList = new Vector<>();
		
		Vector<Object> vector1 = new Vector<>();
		vector1.add("1");
		vector1.add("张三");
		vector1.add("男");
		vector1.add("18");
		contextList.add(vector1);
		// 创建表头的数据容器
		Vector<Object> titleList = new Vector<>();
		titleList.add("编号");
		titleList.add("姓名");
		titleList.add("性别");
		titleList.add("年龄");
		// 创建DefaultTableMode模型 管理数据容器
		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
		// 创建表格
		JTable table = new JTable(model);
        
        
//        JTable table = new JTable(new kcbData());  //表格
      
		
		
		JScrollPane panel= new JScrollPane(table);  //滚卷
        frame.add(panel);
        frame.pack();
        frame.setSize(500,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
	}

}
