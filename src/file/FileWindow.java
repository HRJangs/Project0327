package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//패널이 라벨과 버튼을 가지고있다.
//jpanel has a label&
public class FileWindow extends JPanel{
	JLabel la;
	JButton bt;
	
	public FileWindow(String str,Icon icon) {
		// TODO Auto-generated constructor stub
		la=new JLabel(str);
		bt =new JButton(icon);
		
		bt.setBorderPainted(false); //경계선 없애기
		bt.setContentAreaFilled(false);//색 채우기 없애기
		bt.setFocusPainted(false);//포커스에 의한 선 없애기
		bt.setOpaque(false);//투명도 주기
		
		setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
	}
}
