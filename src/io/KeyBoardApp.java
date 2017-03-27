package io;
/*
	FileInputStream ���� �����ڰ� ���ϴ� ������ 
	��Ʈ���� �����Ҽ� ������, Ű����� ���� ǥ�� �Է��ϵ������ ��쿣
	�ڹٰ� ��Ʈ���� �������� ���ϰ� OS�� �����ϹǷ�, �ڹ� �����ڴ�
	OS�κ��� ǥ���Է� ��Ʈ���� ���;� �Ѵ�.

	System Ŭ������ static ��������� 
	�� has a����� ������ inputStream�� in��ü�� �ٷ� ǥ���Է� ��Ʈ���� �޾Ƴ���
	��ü�̴�.���� ���� System.in �̶�� ����.

	���ڱ�� ��Ʈ�� Ŭ������ �̸���Ģ
	�Է�: ~~Reader
	���: ~~Writer
	
*/
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is = System.in;
		
		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ°��� �ƴ϶�
		//�̹�, ����Ʈ ��� ��Ʈ���� ������ �Ѵ�
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�
		InputStreamReader reader = null;
		reader = new InputStreamReader(is);

		
		int data;
		try{
			while(true){
				//data = is.read(); //1byte �о����	
				data = reader.read(); //2byte �о����	
				System.out.print((char)data);
			}
		}
		catch (IOException e){

		}
		
	}
}
