package count;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp2 extends JFrame{

	JLabel la1,la2;
	
	public CountApp2() {
		la1 = new JLabel("0");
		la1.setPreferredSize(new Dimension(300, 380));
		la1.setFont(new Font("Dotum", Font.BOLD, 75));
		
		la2 = new JLabel("0");
		la2.setPreferredSize(new Dimension(300, 380));
		la2.setFont(new Font("Dotum", Font.BOLD, 75));
		
		setLayout(new FlowLayout());
		
		new CountAppThread(la1, 1000);
		new CountAppThread(la2, 400);
		
		add(la1);
		add(la2);
		
		setBounds(600,300,700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CountApp2();

	}

}
