package thread2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame{
	JButton bt;
	Canvas canvas;
	Image image;
	int x,y;
	Thread thread;//내부익명 스타일로 가자 개발
	
	public AniMain() {
		thread = new Thread(){
			
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
		};
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AniMain();
	}

}
