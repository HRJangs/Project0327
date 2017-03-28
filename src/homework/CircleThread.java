package homework;

import java.awt.Color;
import java.awt.Graphics;

//원을 표현한 객체 및 그 움직임
public class CircleThread extends ShapeThread{
	
	public CircleThread(int x, int y, int width, int height,int interval,Graphics g){
		super(x, y, width, height, interval, g);
	}
	public void render(){
		//지우고
		//노란색 페인틀 윈도우에적용하고
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.black);
		x+=5;
		//그리자
		g.drawOval(x, y, width, height);	
	}
}
