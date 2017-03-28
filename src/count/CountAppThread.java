package count;

import javax.swing.JLabel;

public class CountAppThread extends Thread{
	
	JLabel la;
	int interval;
	int cnt;
	public CountAppThread(JLabel la, int interval) {
		this.la = la;
		this.interval = interval;
		start();
	}
	
	public void run() {
		//특정 라벨의 값을 1씩 시키되, 지정한 속도대로 바꾼다.
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			la.setText(Integer.toString(cnt));
		}
	}
}
