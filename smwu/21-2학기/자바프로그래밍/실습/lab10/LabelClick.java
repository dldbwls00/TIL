// ������ (2016133)
// 2021-11-19
// Lab10 - �ǽ� 5. ���̺� Ŭ�� ���� �ǽ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelClick extends JFrame{
	JLabel [] lb = new JLabel[10];
	int idx = 0;
	
	public LabelClick() {
		setTitle("Ten ���̺� Ŭ��"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null); //���̾ƿ� ����
		MyMouseAdapter m = new MyMouseAdapter(0); //������
		
		for (int i=0; i<lb.length; i++) {
			int x = (int)(Math.random()*250)+20; //���������� ��ġ ��ǥ ����
			int y = (int)(Math.random()*250)+20;
			
			lb[i] = new JLabel(Integer.toString(i));
			lb[i].setForeground(Color.MAGENTA); //�۾� ����
			lb[i].setLocation(x, y); //��ġ
			lb[i].setSize(25, 25); //ũ��
			lb[i].addMouseListener(m);
			c.add(lb[i]); //�����̳ʿ� ���̱�
		}
		setSize(300, 300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyMouseAdapter extends MouseAdapter{
		int idx;
		public MyMouseAdapter(int idx) { //�����ڷ� �ʱ�ȭ
			this.idx = idx;
		}
		public void mouseClicked(MouseEvent e) {
	    	JLabel temp = (JLabel)e.getSource();
	        if(Integer.parseInt(temp.getText()) == this.idx){
	            temp.setVisible(false);
	            this.idx++;
	        }
	        if(this.idx == lb.length){
	            this.idx = 0;
	            new LabelClick();
	        }
		}
	}
	public static void main(String[] args) {
		new LabelClick();
	}
}
