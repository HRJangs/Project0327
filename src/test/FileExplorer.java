package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FileExplorer extends JFrame{
	
	File file; 
	File[] f;
	ArrayList<JButton> arr;
	Icon icon,icon_off;

	
	public FileExplorer() {
		file = new File("C:/java_workspace2/Project0327");
		f = file.listFiles();
		arr = new ArrayList<JButton>();
		icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder-on.png");
		icon_off =new  ImageIcon("C:/java_workspace2/Project0327/res/folder-off.png");
		
		createButton();
		setAction();
	
		setLayout(new FlowLayout());
		setVisible(true);
		setBounds(400,100,700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void createButton(){
		for(int i=0;i<f.length;i++){
			if(f[i].isDirectory()){
				//System.out.println(f[i].getName());
				JButton a = new JButton(icon);
				JLabel la =new JLabel(f[i].getName());
				JPanel p = new JPanel();
				 
				a.setBorderPainted(false);
				a.setContentAreaFilled(false);
				a.setFocusPainted(false);
				a.setOpaque(false);
				
				 p.setLayout(new BorderLayout());
				 p.add(la,BorderLayout.NORTH);
				 p.add(a,BorderLayout.CENTER);
				 
				 add(p);
				 arr.add(a);
			}
		 }
	}
	public void setAction(){
		for(int i=0;i<arr.size();i++){
			int j=i;
			arr.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						for(int k=0;k<arr.size();k++){
							arr.get(k).setIcon(icon);
						}
						arr.get(j).setIcon(icon_off);
				}
			});
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileExplorer();
	}

}
