package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame  {

	JScrollPane scroll;
	JPanel p_north;
	JTextArea area;
	JButton bt_open, bt_save;
	FileInputStream fis;
	InputStreamReader reader; //문자기반 입력스트림
	BufferedReader buffr;//버퍼 처리된 문자기반 입력스트림
	ImageIcon icon_on,icon_off;
	
	FileOutputStream fos;
	OutputStreamWriter writer; //문자기반 출력스트림
	PrintWriter writer2;
	
	String ori = "C:/java_workspace2/Project0327/res/memo.txt"; //원본파일 경로
	String dest = "C:/java_workspace2/Project0327/res/memo_copy.txt"; //최종파일 경로

	
	public MemoEditor() {
		area =new JTextArea();
		scroll = new JScrollPane(area);
		p_north = new JPanel();
		icon_on = new ImageIcon("C:/java_workspace2/Project0327/res/folder-on.png");
		icon_off= new ImageIcon("C:/java_workspace2/Project0327/res/folder-off.png");
				
		bt_open = new JButton(icon_on);
		bt_save = new JButton(icon_off);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		bt_save.setBorderPainted(false);
		bt_save.setContentAreaFilled(false);
		bt_save.setFocusPainted(false);
		bt_save.setOpaque(false);
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//버튼에 이벤트 넣기
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		//버튼에 이벤트 넣기
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				save();
			}
		});
		setBounds(500,300,600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//열기
	public void open(){
			try {
				fis = new FileInputStream(ori);
				//문자기반 스트림에는 문자인코딩 속성을 지정할 수 있다.
				//버퍼스트림은 버퍼영역에 한줄을 다 보관해놨다가 줄바꿈  표시를 만나면 한번에 모아둔 버퍼를 출력한다.
				reader = new InputStreamReader(fis,"utf-8");
				buffr =new BufferedReader(reader); 
				//int data;
				String data2;
				int cnt=0;
				while(true){
					data2 = buffr.readLine();//1byte 읽음
					cnt++;
					if(data2==null)break;
					//area.append(Character.toString((char)data));
					area.append(data2+"\n");
				}
				System.out.println(cnt);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "파일을 찾을수 없습니다.");
			}
	}
	//저장하기
	public void save(){
		try {
			//FileOutputStream은 지정한 경로에 파일을 생성해버린다
			fos =new FileOutputStream(dest);
			writer2 = new PrintWriter(fos);	
			writer2.write( area.getText());
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(writer2 != null){
					writer2.close();
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new MemoEditor();
	}
}
