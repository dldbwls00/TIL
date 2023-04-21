// ������ (2016133)
// 2021-12-03
// Lab12 - �ǽ� 6. �׷��� �׸���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawGraphic extends JFrame{
	private mypanel panel = new mypanel();
	private Container c;
	public DrawGraphic() {
		setTitle("�׷��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		createToolbar();
		setSize(400,300);
		setVisible(true);
	}
	private void createToolbar() {
		JToolBar toolbar = new JToolBar("draw");
		toolbar.add(new JLabel("����"));
		toolbar.add(new JButton("/"));
		toolbar.add(new JButton("��"));
		toolbar.add(new JButton("��"));
		toolbar.add(new JButton("��"));
		toolbar.addSeparator();//���м�
		toolbar.add(new JLabel("�� ����"));
		JButton color = new JButton("��");
		toolbar.add(color);
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color selected = JColorChooser.showDialog(null, "Color", Color.RED);
				if (selected != null) {
					
				}	
			}
		});
		c.add(toolbar, BorderLayout.NORTH);
	}
	class mypanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(getBackground());
		}
	}
	public static void main(String[] args) {
		new DrawGraphic();
	}
	
}
