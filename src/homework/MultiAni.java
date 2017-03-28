package homework;
/*
 * 서로다른 그래픽,속도,기타값을 갖는 물체를 움직이게 하자
 * */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;
	Graphics gp;
	
	public MultiAni() {
		bt= new JButton("각자 움직이기");
		can = new Canvas(){			
			public void paint(Graphics g) {
			}
		};
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gp = can.getGraphics();
					RectThread rt = new RectThread(0, 200, 60, 60, 100, gp);
					CircleThread ct = new CircleThread(0,0, 50, 50, 100, gp);
		
			}
		});
		can.setBackground(Color.yellow);
		add(bt,BorderLayout.NORTH);
		add(can);
		setBounds(600,150,700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MultiAni();
	}
}
