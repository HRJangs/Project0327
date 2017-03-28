package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreadTest2 extends JFrame{

	JButton bt;
	MyCanvas can,can2,can3;
	int x,x2,x3;
	MyThread2 thread;
	public ThreadTest2() {
		bt = new JButton("물체이동");
		can = new MyCanvas(x,x2,x3);
		thread = new MyThread2(this);
		can.setBackground(Color.yellow);
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		setBounds(300,150,700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void move(int x,int x2,int x3){
		can.x+=x;
		can.x2 += x2;
		can.x3 += x3;
		can.repaint();
	}
	public static void main(String[] args) {
		new ThreadTest2();
	}

}
