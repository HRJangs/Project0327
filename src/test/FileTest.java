package test;

import java.io.File;

import javax.swing.JFrame;
/*
 	�ڹٿ����� ���丮�� �����ϱ� ���� Ŭ������ ������ �������� �ʴ´�
 	���丮������ ���Ϸ� �����Ѵ�.
 	���: java.io.file Ŭ������ ����+���丮���� ó���Ѵ�.
 	
 */
public class FileTest extends JFrame{

	public static void main(String[] args) {
		//C����̺��� ������ �����ϴ� ��� ���丮 �� ������ ����غ���
		File file=new File("c:/");
		//���� ���丮�� ������ �������
		File[] dir = file.listFiles();
		
		for(int i =0; i<dir.length;i++){
			if(dir[i].isDirectory())
				System.out.println(dir[i].getName());
		}
	}
}
