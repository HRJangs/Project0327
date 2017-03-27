package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//�г��� �󺧰� ��ư�� �������ִ�.
//jpanel has a label&
public class FileWindow extends JPanel{
	JLabel la;
	JButton bt;
	
	public FileWindow(String str,Icon icon) {
		// TODO Auto-generated constructor stub
		la=new JLabel(str);
		bt =new JButton(icon);
		
		bt.setBorderPainted(false); //��輱 ���ֱ�
		bt.setContentAreaFilled(false);//�� ä��� ���ֱ�
		bt.setFocusPainted(false);//��Ŀ���� ���� �� ���ֱ�
		bt.setOpaque(false);//���� �ֱ�
		
		setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
	}
}
