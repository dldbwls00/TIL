// ������ (2016133)
// 2021-11-19
// Lab10 - �ǽ� 4. �̹��� ������ �����
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.swing.*;

public class ImageGallery extends JFrame{
	JRadioButton left, right;
	int next = -1; //��� �����ִ� ����, left�� �ʱ�ȭ �����̹Ƿ� -1
	int now = 0;
	
	public ImageGallery() {
		setTitle("Image Gallery Practice Frame"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		ButtonGroup g = new ButtonGroup(); //������ư�׷�
		left = new JRadioButton("left", true); //������ư, ���õ� ���·� �ʱ�ȭ
		right = new JRadioButton("right"); 
		g.add(left); g.add(right); //������ư�׷����� ����
		north.add(left); north.add(right); //north�ǳڿ� ���̱�
		left.addItemListener(new MyItemListener()); //������ �ޱ�
	    right.addItemListener(new MyItemListener());

		File f = new File("images");
		File files[] = f.listFiles(); //���ϸ���Ʈ ���
		Vector<ImageIcon> imgicon = new Vector<ImageIcon>();
		for (int i=0; i<files.length; i++) {
			ImageIcon img = new ImageIcon(files[i].getPath()); //�ε�
			imgicon.add(img); //�����÷��ǿ� ����
		}
		
		JPanel center = new JPanel();
		JLabel lb = new JLabel();
		lb.setIcon(imgicon.get(0)); //�ʱ�ȭ�� ����
		center.add(lb); //center�ǳڿ� ���̱�
		lb.addMouseListener(new MouseAdapter() { //�͸� ����� �ޱ� -> Ŭ��
			public void mouseClicked(MouseEvent e) {
				now += next; //�����ε����� �ѱ��
				if (now >= 0)
					lb.setIcon(imgicon.get(now % imgicon.size())); //���������� �̿�
				else {
					now = imgicon.size()-1; //ȸ���ϵ��� �ʱ�ȭ
					lb.setIcon(imgicon.get(now));
				}
			}
		});
		
		c.add(north, BorderLayout.NORTH); //�����̳ʿ� ����
		c.add(center, BorderLayout.CENTER);
		
		setSize(500, 470); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			 if(e.getStateChange() == ItemEvent.DESELECTED)	return; //���� ������ ���
			 if (left.isSelected())	next = -1; //left�� ���õ��� ���
			 else	next = 1; //right�� ���õ��� ���
		}
	}
	public static void main(String[] args) {
		new ImageGallery();
	}

}
