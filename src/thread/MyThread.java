package thread;
/*
 * ���� �����ϰ� ���� �ڵ�� �����ڰ� �����ؾ� �ϱ⶧����
 * �����带 ������ �ؾ��Ѵ�.
 * 
 * */
public class MyThread extends Thread{
	/*
	 * �����ڴ� ���������� �����ϰ� ���� �ڵ带
	 * thread�� run�޼��� �ȿ� �ڵ��ϸ� �ȴ�.
	 * */
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��");
		}
	}
}
