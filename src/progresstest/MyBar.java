package progresstest;

import javax.swing.JProgressBar;

public class MyBar extends Thread{
	JProgressBar bar;
	int cnt;
	public MyBar(JProgressBar bar) {
		this.bar =bar;
		start();
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				cnt+=2;
				bar.setValue(cnt);
		}
	}
}
