package progressbar;

import java.awt.Color;

import javax.swing.JProgressBar;

public class MyProgressBar extends Thread{
	JProgressBar bar;
	int interval;
	int cnt;
	
	public MyProgressBar(int interval ,JProgressBar bar) {
		this.bar = bar;
		this.interval = interval;

		start();
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt+=2;
			bar.setValue(cnt);
		}
	}
}
