package test;

import java.io.File;

import javax.swing.JFrame;
/*
 	자바에서는 디렉토리를 제어하기 위한 클래스가 별도로 존재하지 않는다
 	디렉토리조차도 파일로 간주한다.
 	결론: java.io.file 클래스가 파일+디렉토리까지 처리한다.
 	
 */
public class FileTest extends JFrame{

	public static void main(String[] args) {
		//C드라이브의 하위에 존재하는 모든 디렉토리 및 파일을 출력해보자
		File file=new File("c:/");
		//하위 디렉토리및 파일의 목록추출
		File[] dir = file.listFiles();
		
		for(int i =0; i<dir.length;i++){
			if(dir[i].isDirectory())
				System.out.println(dir[i].getName());
		}
	}
}
