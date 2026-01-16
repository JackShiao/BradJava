package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.ClockPanel;

public class Clock extends JFrame{
	private ClockPanel clockPanel;

	public Clock() {
		super("時鐘");
		
		setLayout(new BorderLayout());
		clockPanel = new ClockPanel();
		add(clockPanel, BorderLayout.CENTER);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new Clock();
	}

}
