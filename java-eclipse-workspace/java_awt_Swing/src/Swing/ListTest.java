package Swing;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

public class ListTest {
    JFrame mainWin = new JFrame("�б�����");
    String[] books = {"java��ѧ����","������javaEE��ҵӦ��ʵս","Android�����̳�","jQueryʵս�̳�","SpringBoot��ҵ������"};

    //��һ���ַ�������������һ��JList����
    JList<String> bookList = new JList<>(books);
    JComboBox<String> bookSelector;

    //���� ����ѡ��ť ���ڵ����
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();

    //���� ѡ��ģʽ��ť �������
    JPanel selectModePanel = new JPanel();
    ButtonGroup selectModeGroup = new ButtonGroup();

    JTextArea favorite = new JTextArea(4,40);

    public void init(){
        //����JList�Ŀ��Ӹ߶ȿ���ͬʱչʾ3���б���
        bookList.setVisibleRowCount(3);

        //����JlistĬ��ѡ�е����������
        bookList.setSelectionInterval(2,4);
        addLayoutButton("�������",JList.VERTICAL);
        addLayoutButton("������",JList.VERTICAL_WRAP);
        addLayoutButton("������",JList.HORIZONTAL_WRAP);

        addSelectModeButton("������", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModeButton("��ѡ", ListSelectionModel.SINGLE_SELECTION);
        addSelectModeButton("����Χ", ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        Box listBox = Box.createVerticalBox();
        //��JList������õ�JScrollPane�У�����JScrollPane���õ�box��
        listBox.add(new JScrollPane(bookList));
        listBox.add(layoutPanel);
        listBox.add(selectModePanel);

        //ΪJList����¼�������
        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<String> selectedValuesList = bookList.getSelectedValuesList();
                favorite.setText("");
                for (String s : selectedValuesList) {
                    favorite.append(s+"\n");
                }
            }
        });


        //����һ��Vector����
        Vector<String> bookCollection = new Vector<>();
        List<String> books = List.of("java��ѧ����","������javaEE��ҵӦ��ʵս","Android�����̳�","jQueryʵս�̳�","SpringBoot��ҵ������");
        bookCollection.addAll(books);

        //����JComboBox����
        bookSelector = new JComboBox<>(bookCollection);

        //ΪJComboBox����¼�������
        bookSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = bookSelector.getSelectedItem();
                favorite.setText(selectedItem.toString());
            }
        });

        //����JComboBox���б���ɱ༭
        bookSelector.setEditable(true);

        //���������б�Ŀ��Ӹ߶������ʾ4���б���
        bookSelector.setMaximumRowCount(4);

        JPanel panel = new JPanel();
        panel.add(bookSelector);
        Box box = Box.createHorizontalBox();
        box.add(listBox);
        box.add(panel);

        JPanel favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favorite));
        favoritePanel.add(new JLabel("����ϲ����ͼ�飺"),BorderLayout.NORTH);

        mainWin.add(box);
        mainWin.add(favoritePanel,BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }



    public void addLayoutButton(String label,int orientation){
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(),"ȷ��ѡ���"));

        JRadioButton button = new JRadioButton(label);

        layoutPanel.add(button);
        //Ĭ��ѡ�е�һ����ť
        if (layoutGroup.getButtonCount()==0){
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(e->{
            //�ı��б�����б���Ĳ��ַ���
            bookList.setLayoutOrientation(orientation);
        });

    }

    public void addSelectModeButton(String label,int selectMode){
        selectModePanel.setBorder(new TitledBorder(new EtchedBorder(),"ȷ��ѡ��ģʽ"));
        JRadioButton button = new JRadioButton(label);
        selectModePanel.add(button);
        if (selectModeGroup.getButtonCount()==0){
            button.setSelected(true);
        }
        selectModeGroup.add(button);
        button.addActionListener(e->{
            bookList.setSelectionMode(selectMode);
        });


    }

    public static void main(String[] args) {
        new ListTest().init();
    }
}