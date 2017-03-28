package count;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountThread2 extends Thread{
	JLabel la_right;
	Font font;
	int cnt;
	public CountThread2() {
		font = new Font("serif", Font.BOLD, 150);
		la_right = new JLabel("0");
		la_right.setFont(font);
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			la_right.setText(Integer.toString(cnt));
		}
	}
}
