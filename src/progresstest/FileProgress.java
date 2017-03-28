package progresstest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileProgress extends JFrame implements ActionListener{
	
	JProgressBar bar;
	JButton bt_open,bt_dest,bt_save;
	JTextField txt_open,txt_save;
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	String str;
	long size;
	
	public FileProgress() {
		str="C:/java_workspace2/Project0327/res";
		bar = new JProgressBar();
		bt_open = new JButton("파일 열기");
		bt_dest = new JButton("경로 지정");
		bt_save = new JButton("저장");
		txt_open =new JTextField(28);
		txt_save =new JTextField(28);
		chooser = new JFileChooser(str);
		txt_open.setText(str);	
		bar.setPreferredSize(new Dimension(400, 40));
		
		setLayout(new FlowLayout());
		add(bar);
		add(bt_open);
		bt_open.addActionListener(this);
		add(txt_open);
		add(bt_dest);
		bt_dest.addActionListener(this);
		add(txt_save);
		add(bt_save,BorderLayout.SOUTH);
		bt_save.addActionListener(this);
		
		setBounds(700,250,450,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt_open){
			open();
		}else if(obj==bt_dest){
			path();
		}if(obj==bt_save){
			save();
		}
	}
	public void open(){
		int state =chooser.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
			//파일클래스가 보유한 절대경로 메세드
			//를 이용하여 경로 반환
			File file = chooser.getSelectedFile();
			size =file.length();
			System.out.println(size);
			txt_open.setText(file.getPath());
		}
	}
	public void path(){
		int state =chooser.showSaveDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
			//파일클래스가 보유한 절대경로 메세드
			//를 이용하여 경로 반환
			File file = chooser.getSelectedFile();
			txt_save.setText(file.getPath());
		}
	}
	public void save(){
		
		try {
			String oriPath =  txt_open.getText();
			String destPath= txt_save.getText();
			fis =new FileInputStream(oriPath);
			fos =new FileOutputStream(destPath); 
			int data;
			int sum=0;
			
			while(true){
				data = fis.read();
				if(data==-1)break;
				fos.write(data);
				sum++;
				bar.setValue(sum);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				JOptionPane.showMessageDialog(this, "복사가 완료되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		new FileProgress();
	}


}
