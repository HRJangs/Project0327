package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//�����ڰ� �����带 ����Ͽ� ���� �� �� ������
//�̹� �ٸ�Ŭ������ �ڽ��ϰ��, ����� �Ұ��ϴ�.
//�̷��� ����� �� �ִ� ��ü�� �ٷ� Runnable �������̽� �̴�.
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas canvas;
	Image image;
	int x,y;
	Thread thread;
	
	public AniMain() {
		//Runnable�� ��ü�� �μ��� �ѱ��
		//�׷���, run �޼����� ȣ���� runnable�� �������� ��ü�� �޼���
		thread = new Thread(this);
		
		bt = new JButton("��ü�̵�");
		canvas = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
			
		};
		//��ư�� ������ ����
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		canvas.setBackground(Color.yellow);
		add(bt,BorderLayout.NORTH);
		add(canvas);
		
		setBounds(600,150,700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void move(){
		x+=5;
		y+=5;
		canvas.repaint();
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			move();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AniMain();
	}
	

}
