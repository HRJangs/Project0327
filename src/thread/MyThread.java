package thread;
/*
 * 동시 수행하고 싶은 코드는 개발자가 결정해야 하기때문에
 * 스레드를 재정의 해야한다.
 * 
 * */
public class MyThread extends Thread{
	/*
	 * 개발자는 독립적으로 수행하고 싶은 코드를
	 * thread에 run메서드 안에 코딩하면 된다.
	 * */
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("★");
		}
	}
}
