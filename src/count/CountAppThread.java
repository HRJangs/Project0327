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
		//Ư�� ���� ���� 1�� ��Ű��, ������ �ӵ���� �ٲ۴�.
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
