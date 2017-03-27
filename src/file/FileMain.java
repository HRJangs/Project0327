package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileMain extends JFrame{
	
	MyIcon icon_on,icon_off;
	
	public FileMain() {
		//�̹��� �������� ����ȭ�� ,���ҽ� ������ ����
		//uniformed resource locator:	
		icon_on =new MyIcon(this.getClass().getResource("/folder-on.png"), 50, 50);
		icon_off = new MyIcon(this.getClass().getResource("/folder-off.png"), 50, 50);
		
		
		ArrayList<String> list = getDirList();
		for(int i=0;i<list.size();i++){
			String dirName =list.get(i);
			FileWindow fw =new FileWindow(dirName, icon_off);
			add(fw);
		}
	
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//���ϴ� ����� ���� ���丮 �� ���� ���ϱ�
	public ArrayList<String> getDirList(){
		File file = new File("C:/");
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		//���丮�� �����
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				dirList.add(fileList[i].getName());	
			}
		}
		return dirList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileMain();
	}
}
