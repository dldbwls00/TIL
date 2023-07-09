public class BouncingBall extends JFrame implements ActionListener {
	static final int WIDTH = 600;
	static final int HEIGHT = 200;
	private static final int PERIOD = 10;

	class MyPanel extends JPanel {
		int x=0, y=0, xInc=3, yInc=3, diameter=60;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
				if (x < 0 || x > (BouncingBall.WIDTH - diameter))
					xInc = -xInc;
				if (y < 0 || y > (BouncingBall.HEIGHT - diameter))
					yInc = -yInc;

				x += xInc;
				y += yInc;
				g.setColor(Color.RED);
				g.fillOval(x, y, diameter, diameter);
		}
	}

    public BouncingBall() {
		MyPanel panel = new MyPanel();

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(panel);
		pack();
		setTitle("Bouncing Ball");
		Timer timer = new Timer(PERIOD, this);
		timer.start();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		repaint();
	}
	public static void main(String[] args) {
		BouncingBall f = new BouncingBall();
	}

}
