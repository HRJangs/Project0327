package count;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	Font font;
	JLabel bord;
	public CountApp() {
		bord =new JLabel("|");
		font = new Font("serif", Font.BOLD, 150);
		CountThread1 ct = new CountThread1();
		CountThread2 ct2 = new CountThread2();
		bord.setFont(font);
		ct.start();
		ct2.start();
		add(ct.la_left);
		add(bord);
		add(ct2.la_right);
		setLayout(new FlowLayout());
		setBounds(700,250,500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CountApp();
	}
	
	
}
