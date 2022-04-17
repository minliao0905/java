package MVC;
 
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
 
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
public class Main11 extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
 
		Main11 main11 = new Main11();
		main11.run();
	}
 
	public void run() {
		/**
		 * ������ť���������
		 */
		// ����������������
		JLabel NumLable = new JLabel("��ţ�");
		JTextField NumTextField = new JTextField();
		NumLable.setBounds(30, 250, 40, 30);
		NumTextField.setBounds(72, 250, 65, 30);
 
		// �������������������
		JLabel NameLable = new JLabel("������");
		JTextField NameTextField = new JTextField();
		NameLable.setBounds(150, 250, 40, 30);
		NameTextField.setBounds(192, 250, 65, 30);
		
		//�����Ա�ѡ���
		JLabel SexLable = new JLabel("�Ա�");
		
		//������Ͽ���������
		DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
		ComboBoxModel.addElement("��");
		ComboBoxModel.addElement("Ů");
		ComboBoxModel.addElement(" ");
		JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);   //��������������Ҽ�����Ͽ���������
		
		SexLable.setBounds(260, 250, 40, 30);
		ComboBoxlist.setBounds(302, 250, 50, 30);
		
		// �������������������
		JLabel AgeLable = new JLabel("���䣺");
		JTextField AgeTextField = new JTextField();
		AgeLable.setBounds(360, 250, 40, 30);
		AgeTextField.setBounds(402, 250, 65, 30);
		
		//�������Ӱ�ť
		JButton AddBtn = new JButton("����");
		AddBtn.setBounds(35, 300, 65, 30);
		
		//����ɾ����ť ��Ҫ����container ����Ŷ����
		JButton DeleteBtn = new JButton("ɾ��");
		DeleteBtn.setBounds(300, 300, 65, 30);
		/**
		 * ������������
		 */
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
		// ����table��������
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 30, 440, 200);
		//������ӵļ�����
		AddBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Num = NumTextField.getText();
				String Name = NameTextField.getText();
				String sex = ComboBoxlist.getSelectedItem().toString();
				String Age = AgeTextField.getText();
				
				Vector<Object> list = new Vector<>();
				list.addElement(Num);
				list.addElement(Name);
				list.addElement(sex);
				list.addElement(Age);
				//�����ݷ�������������
				model.addRow(list);
				
				//���Ӻ��������
				NumTextField.setText("");
				NameTextField.setText("");
				AgeTextField.setText("");
			}
		});
		//����ɾ����������ɾ���¼�
		DeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int n = model.getRowCount();
				if(n>0) {
					  model.removeRow(n-1);
				}
			  	
			}
			
		});
		// ����container
		Container container = this.getContentPane();
		container.add(scrollPane);
		container.add(NumLable);
		container.add(NumTextField);
		container.add(NameLable);
		container.add(NameTextField);
		container.add(SexLable);
		container.add(ComboBoxlist);
		container.add(AgeLable);
		container.add(AgeTextField);
		container.add(AddBtn);
		container.add(DeleteBtn);
		// ���ò��ֹ�����
		this.setLayout(null);
		/**
		 * ���ô�������
		 */
		this.setTitle("����������");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);// ���þ�����ʾ
		// ����Jframe����ر�ʱ �������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}