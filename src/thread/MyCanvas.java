package thread;

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	int x,x2,x3;
	
	public MyCanvas(int x, int x2,int x3) {
		this.x =x;
		this.x2 = x2;
		this.x3 = x3;
	}
	public void paint(Graphics g) {
		g.drawOval(x, 0, 50, 50);
		g.drawRect(x2, 100, 50, 50);
		g.drawOval(x3, 200, 30, 30);
	}
}
