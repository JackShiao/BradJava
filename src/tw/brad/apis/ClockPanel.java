package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ClockPanel extends JPanel{
	
    public ClockPanel() {
    	setBackground(Color.BLACK);;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    }
}
