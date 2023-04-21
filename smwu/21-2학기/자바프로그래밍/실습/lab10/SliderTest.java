// ������ (2016133)
// 2021-11-19
// Lab10 - �ǽ� 3. �����̴� �׽�Ʈ
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame{
	JTextArea ta = new JTextArea(5,30);
	JSlider sl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0); //���򽽶��̴�, �ʱⰪ 0
	
	public SliderTest() {
		setTitle("TextArea Practice Frame"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		sl.setMajorTickSpacing(20); //ū ����
		sl.setMinorTickSpacing(5); //���� ����
		sl.setPaintTicks(true); //tick ���̱�
		sl.setPaintTrack(true); //track ���̱�
		sl.setPaintLabels(true); //label ���̱�
		sl.addChangeListener(new MyChangeListener()); //������ �ޱ�
		
		ta.addKeyListener(new KeyAdapter() { //�͸� ����� ���̱�
			public void keyTyped(KeyEvent e) {
				sl.setValue(ta.getText().length()); //���ڼ���ŭ �����̵�
				
				if(ta.getText().length()>=100) //100�� �̻� �Է��� ���
					ta.setText(ta.getText().substring(0,99)); //�޺κ��� �ڸ���		 
			}
		});
		
		c.add(ta, BorderLayout.NORTH); //�����̳ʿ� ���̱�
		c.add(sl, BorderLayout.SOUTH);
		
		setSize(350, 200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			if (ta.getText().length() >= sl.getValue()) //�����̵带 ���̸� �ؽ�Ʈ�� �߸�
				ta.setText(ta.getText().substring(0, sl.getValue()));
			else
				sl.setValue(ta.getText().length()); //�����̵�� ���ڼ����� Ŭ �� ����
		}
	}
	public static void main(String[] args) {
		new SliderTest();
	}

}
