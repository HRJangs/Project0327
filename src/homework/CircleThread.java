package homework;

import java.awt.Color;
import java.awt.Graphics;

//���� ǥ���� ��ü �� �� ������
public class CircleThread extends ShapeThread{
	
	public CircleThread(int x, int y, int width, int height,int interval,Graphics g){
		super(x, y, width, height, interval, g);
	}
	public void render(){
		//�����
		//����� ����Ʋ �����쿡�����ϰ�
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.black);
		x+=5;
		//�׸���
		g.drawOval(x, y, width, height);	
	}
}
