package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawer;

//brad
//public class MySign extends JFrame{
//	private MyDrawer myDrawer;
//	private JButton clear;
//	
//    public MySign() {
//    	super("MySign");
//    	
//    	myDrawer = new MyDrawer();
//    	setLayout(new BorderLayout());
//    	add(myDrawer, BorderLayout.CENTER);
//    	
//    	JPanel top = new JPanel(new FlowLayout());
//    	clear = new JButton("Clear");
//    	top.add(clear);
//    	add(top, BorderLayout.NORTH);
//    	
//    	setSize(800,480);
//    	setVisible(true);
//    	setDefaultCloseOperation(EXIT_ON_CLOSE);
//    	
//    	initEvent();
//    }
//    
//    private void initEvent() {
//    	clear.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myDrawer.clear();
//			}
//		});
//    }
//    
//	public static void main(String[] args) {
//        new MySign();
//	}
//
//}





// 0108 LAB
public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear;
	private JButton colorBtn;
	private JButton undoBtn,redoBtn;
	
    public MySign() {
    	super("MySign");
    	
    	myDrawer = new MyDrawer();
    	setLayout(new BorderLayout());
    	add(myDrawer, BorderLayout.CENTER);
    	
    	JPanel top = new JPanel(new FlowLayout());
    	clear = new JButton("清空畫面");
    	top.add(clear);
    	add(top, BorderLayout.NORTH);
    	colorBtn = new JButton("選擇線條顏色");
    	top.add(colorBtn);
    	undoBtn = new JButton("復原");
    	redoBtn = new JButton("重做");
    	top.add(undoBtn);
    	top.add(redoBtn);
    	
    	
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
    	colorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(MySign.this, "選擇線條顏色", myDrawer.getCurrentColor());
				if (c != null) myDrawer.setCurrentColor(c);
			}
		});
    	undoBtn.addActionListener(e -> myDrawer.undo());
    	redoBtn.addActionListener(e -> myDrawer.redo());
    }
    
	public static void main(String[] args) {
        new MySign();
	}

}

