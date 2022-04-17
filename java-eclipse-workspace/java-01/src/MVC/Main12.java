package MVC;
 

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
public class Main12 extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
 
		Main12 main12 = new Main12();
		main12.run();
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
		JComboBox<Object> ComboBoxlist = new JComboBox<>(ComboBoxModel);
		
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
		
		/**
		 * 创建数据容器
		 */
		// 创建表格内容的容器
		Object[][] context = new Object[][]{
			{"1","张三","男","18"}
		};
		// 创建表头的数据容器
		Object[] title = new Object[]{"编号","姓名","性别","年龄"};
		// 创建DefaultTableMode模型 管理数据容器
		DefaultTableModel model = new DefaultTableModel(context, title);
		// 创建表格
		JTable table = new JTable(model);
		// 创建table滚动窗体
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 30, 440, 200);
		//创建监听器
		AddBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Num = NumTextField.getText();
				String Name = NameTextField.getText();
				String sex = ComboBoxlist.getSelectedItem().toString();
				String Age = AgeTextField.getText();
				
				Object[] data = new Object[]{Num,Name,sex,Age};
				//将数据放入数据容器中
				model.addRow(data);
				
				//增加后清空数据
				NumTextField.setText("");
				NameTextField.setText("");
				AgeTextField.setText("");
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