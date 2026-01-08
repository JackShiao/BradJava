package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear;
	
    public MySign() {
    	super("MySign");
    	
    	myDrawer = new MyDrawer();
    	setLayout(new BorderLayout());
    	add(myDrawer, BorderLayout.CENTER);
    	
    	JPanel top = new JPanel(new FlowLayout());
    	clear = new JButton("Clear");
    	top.add(clear);
    	add(top, BorderLayout.NORTH);
    	
    	setSize(800,480);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	initEvent();
    }
    
    private void initEvent() {
    	clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
    }
    
	public static void main(String[] args) {
        new MySign();
	}

}
