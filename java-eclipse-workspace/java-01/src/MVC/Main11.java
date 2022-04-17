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
		 * 创建按钮和其他组件
		 */
		// 创建编号与编号输入框
		JLabel NumLable = new JLabel("编号：");
		JTextField NumTextField = new JTextField();
		NumLable.setBounds(30, 250, 40, 30);
		NumTextField.setBounds(72, 250, 65, 30);
 
		// 创建姓名与姓名输入框
		JLabel NameLable = new JLabel("姓名：");
		JTextField NameTextField = new JTextField();
		NameLable.setBounds(150, 250, 40, 30);
		NameTextField.setBounds(192, 250, 65, 30);
		
		//创建性别选择框
		JLabel SexLable = new JLabel("性别：");
		
		//创建组合框数据容器
		DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
		ComboBoxModel.addElement("男");
		ComboBoxModel.addElement("女");
		ComboBoxModel.addElement(" ");
		JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);   //下拉框组件，并且加入组合框数据容器
		
		SexLable.setBounds(260, 250, 40, 30);
		ComboBoxlist.setBounds(302, 250, 50, 30);
		
		// 创建年龄与年龄输入框
		JLabel AgeLable = new JLabel("年龄：");
		JTextField AgeTextField = new JTextField();
		AgeLable.setBounds(360, 250, 40, 30);
		AgeTextField.setBounds(402, 250, 65, 30);
		
		//创建增加按钮
		JButton AddBtn = new JButton("增加");
		AddBtn.setBounds(35, 300, 65, 30);
		
		//创建删除按钮 需要加入container 容器哦！！
		JButton DeleteBtn = new JButton("删除");
		DeleteBtn.setBounds(300, 300, 65, 30);
		/**
		 * 创建数据容器
		 */
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
		// 创建table滚动窗体
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 30, 440, 200);
		//创建添加的监听器
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
				//将数据放入数据容器中
				model.addRow(list);
				
				//增加后清空数据
				NumTextField.setText("");
				NameTextField.setText("");
				AgeTextField.setText("");
			}
		});
		//创建删除监听器和删除事件
		DeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int n = model.getRowCount();
				if(n>0) {
					  model.removeRow(n-1);
				}
			  	
			}
			
		});
		// 创建container
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
		// 设置布局管理器
		this.setLayout(null);
		/**
		 * 设置窗体属性
		 */
		this.setTitle("表格添加数据");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);// 设置居中显示
		// 设置Jframe窗体关闭时 程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}