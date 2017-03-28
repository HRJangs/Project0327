package progressbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{

	JProgressBar bar1,bar2,bar3;
	JButton bt;
	int cnt;
	
	public ProgressBarTest() {
		
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bt = new JButton("¿€µø");
		bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MyProgressBar(20, bar1);
				new MyProgressBar(80, bar2);
				new MyProgressBar(50, bar3);
			}
		});
		setLayout(new FlowLayout());
		bar1.setPreferredSize(new Dimension(450, 40));
		bar2.setPreferredSize(new Dimension(450, 40));
		bar3.setPreferredSize(new Dimension(450, 40));
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		setBounds(500,300,500,230);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new ProgressBarTest();
	}
}
