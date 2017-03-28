package thread;
//움직임 로직을 담게 될 쓰레드

public class MoveThread extends Thread{
	AniMain aniMain;
	//개발자는 독립실행할 코드를 run에 기재한다.
	//jvm이 run을 알아서 호출해준다.
	public MoveThread(AniMain aniMain) {
		this.aniMain = aniMain;
	}
	
	public void run() {
		while(true){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
			aniMain.move();
		}
	}
}
