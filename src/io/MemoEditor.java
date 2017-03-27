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
	InputStreamReader reader; //���ڱ�� �Է½�Ʈ��
	BufferedReader buffr;//���� ó���� ���ڱ�� �Է½�Ʈ��
	ImageIcon icon_on,icon_off;
	
	FileOutputStream fos;
	OutputStreamWriter writer; //���ڱ�� ��½�Ʈ��
	PrintWriter writer2;
	
	String ori = "C:/java_workspace2/Project0327/res/memo.txt"; //�������� ���
	String dest = "C:/java_workspace2/Project0327/res/memo_copy.txt"; //�������� ���

	
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
		
		//��ư�� �̺�Ʈ �ֱ�
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		//��ư�� �̺�Ʈ �ֱ�
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				save();
			}
		});
		setBounds(500,300,600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//����
	public void open(){
			try {
				fis = new FileInputStream(ori);
				//���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�.
				//���۽�Ʈ���� ���ۿ����� ������ �� �����س��ٰ� �ٹٲ�  ǥ�ø� ������ �ѹ��� ��Ƶ� ���۸� ����Ѵ�.
				reader = new InputStreamReader(fis,"utf-8");
				buffr =new BufferedReader(reader); 
				//int data;
				String data2;
				int cnt=0;
				while(true){
					data2 = buffr.readLine();//1byte ����
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
					JOptionPane.showMessageDialog(this, "������ ã���� �����ϴ�.");
			}
	}
	//�����ϱ�
	public void save(){
		try {
			//FileOutputStream�� ������ ��ο� ������ �����ع�����
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
