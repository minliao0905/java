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
        
		// ����������ݵ�����
		Vector<Vector<Object>> contextList = new Vector<>();
		
		Vector<Object> vector1 = new Vector<>();
		vector1.add("1");
		vector1.add("����");
		vector1.add("��");
		vector1.add("18");
		contextList.add(vector1);
		// ������ͷ����������
		Vector<Object> titleList = new Vector<>();
		titleList.add("���");
		titleList.add("����");
		titleList.add("�Ա�");
		titleList.add("����");
		// ����DefaultTableModeģ�� ������������
		DefaultTableModel model = new DefaultTableModel(contextList, titleList);
		// �������
		JTable table = new JTable(model);
        
        
//        JTable table = new JTable(new kcbData());  //���
      
		
		
		JScrollPane panel= new JScrollPane(table);  //����
        frame.add(panel);
        frame.pack();
        frame.setSize(500,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
	}

}
