package thread;

public class MyThread2 extends Thread{
	
	ThreadTest2 tt;
	public MyThread2(ThreadTest2 tt) {
		this.tt= tt;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tt.move(3,7,10);
		}
	}
}

