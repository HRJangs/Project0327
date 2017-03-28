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
//개발자가 쓰레드를 상속하여 개발 할 수 있으나
//이미 다른클래스의 자식일경우, 상속은 불가하다.
//이럴때 사용할 수 있는 객체가 바로 Runnable 인터페이스 이다.
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas canvas;
	Image image;
	int x,y;
	Thread thread;
	
	public AniMain() {
		//Runnable인 객체를 인수로 넘긴다
		//그러면, run 메서드의 호출은 runnable을 재정의한 객체의 메서드
		thread = new Thread(this);
		
		bt = new JButton("물체이동");
		canvas = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
			
		};
		//버튼과 리스너 연결
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
