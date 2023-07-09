class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class MyPaintApp extends JFrame {
	int x, y;
	Vector<Point> list = new Vector<>();

	class MyPanel extends JPanel {
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent event) {
					x = event.getX();
					y = event.getY();
					list.add(new Point(x, y));
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Point p : list)
				g.fillOval(p.x, p.y, 4, 4);
		}
	}

	public MyPaintApp() {
		setSize(600, 150);
		setTitle("My Paint");
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyPaintApp f = new MyPaintApp();
	}
}
