package homework;
/*
 * ���δٸ� �׷���,�ӵ�,��Ÿ���� ���� ��ü�� �����̰� ����
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
		bt= new JButton("���� �����̱�");
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
