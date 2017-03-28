package count;

import java.awt.Font;

import javax.swing.JLabel;

public class CountThread1 extends Thread{
	JLabel la_left;
	Font font;
	int cnt;
	public CountThread1() {
		font = new Font("serif", Font.BOLD, 150);
		la_left = new JLabel("0");
		la_left.setFont(font);
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			la_left.setText(Integer.toString(cnt));
		}
	}
}
