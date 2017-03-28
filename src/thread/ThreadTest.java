package thread;

/*
  OS가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(멀티 태스킹)
  하나의 자바 프로그램내에서 세부적 실행단위를 만들어 동시에 수행시킬수 있다.
  이러한 세부적 실행단위를 스레드라한다. 
  
  자바는 개잘가아 정의하지않아도 기본적으로 제공되는 스레드가있으며
  이러한 스레드를 가리켜 메인쓰레기드한다.
  결국 자바는 스레드기반이다
*/

public class ThreadTest {
	//a메인스레드말고 개발자가 원하는 사용자 정의 쓰레드하나 만들어서
	//원하는 동시 작업을 시켜보자.
	MyThread thread;
	
	public ThreadTest() {
		//메인쓰레드와는 독립적으로 실행될수있는
		//세부실행단위를 생성함
		//스레드가 어떤일을할지는 개발자가 결정해야하기때문에....
		thread = new MyThread();
		thread.start();
		//run함수를 여기서 실행하면 메인스레드가 run 함수를실행하기때문에 스레드쓰는 의미가 없어진다
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");
		}
	}
	public static void main(String[] args) {
		new ThreadTest();
	}
}



