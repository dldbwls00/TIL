// ������ (2016133)
// 2021-11-19
// Lab10 - �ǽ� 2. ����Ʈ �߰� �� ����
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
	JTextField input = new JTextField(34);
	JTextField selected;
	Vector<String> v = new Vector<String>(); //����
	JList<String> list = new JList<String>(v); //����Ʈ
	JButton btn1, btn2;
	
	public ListTest() {
		setTitle("����Ʈ �׽�Ʈ"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.add(input);
		input.addActionListener(new ActionListener() {//�͸� ������ �ޱ�
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText()); //�߰��ϱ�
				t.setText(""); //�ʱ�ȭ
				list.setListData(v); //������ -> ������� �ݿ�
			}}); 
		
		JPanel center = new JPanel();
		list.setFixedCellHeight(20); //���̰���
		list.setFixedCellWidth(365); //�ʺ����
		center.add(new JScrollPane(list)); //��ũ�� ����
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener()); //�����ʴޱ�
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 3));
		selected = new JTextField("");
		btn1 = new JButton("����");
		btn2 = new JButton("����");
		south.add(selected); south.add(btn1); south.add(btn2);
		btn1.addActionListener(new listener()); //������ �ޱ�
		btn2.addActionListener(new listener());
		
		c.add(north, BorderLayout.NORTH); // �����̳ʿ� ����
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(400,300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class ListListener implements ListSelectionListener{ //����Ʈ �׸� Ŭ�� ������
		public void valueChanged(ListSelectionEvent e) {
			String name = (String)list.getSelectedValue(); //���õ� ��
			
			int index = list.getSelectedIndex(); //���õ� �ε���
			if (index != -1) //����Ʈ�� ������ ���
				selected.setText(name); //�Ʒ� �ؽ�Ʈ�ʵ忡 �ش� �� ǥ��
			else//����Ʈ ���õ��� ���� ��� ��������
				selected.setText("");
		}
	}
	private class listener implements ActionListener{ //��ư ������
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("����")) //"����"�� ������ ���õ� �׸� ����
				v.set(list.getSelectedIndex(), selected.getText());
			else //"����"�� ������ ����
				v.remove(list.getSelectedIndex());
			list.setListData(v); //������		
		}
	}
	public static void main(String[] args) {
		new ListTest();
	}

}
