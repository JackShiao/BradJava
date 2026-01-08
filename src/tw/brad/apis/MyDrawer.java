package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

//Brad
//public class MyDrawer extends JPanel{
//	private List<Line> lines;
//	
//	
//    public MyDrawer() {
//    	setBackground(Color.YELLOW);
//    	
//    	lines = new ArrayList<>();
//    	
//    	MyListener listener = new MyListener();
//    	addMouseListener(listener);
//    	addMouseMotionListener(listener);
//    }
//    
//    @Override
//    protected void paintComponent(Graphics g) {
//    	super.paintComponent(g);
//    	
//    	Graphics2D g2d = (Graphics2D)g;
//    	
//    	g2d.setStroke(new BasicStroke(3));
//    	g2d.setColor(Color.BLUE);
//    	
//    	for (Line line : lines) {
//    		for (int i = 1; i < line.getSize(); i++) {
//    			g2d.drawLine(
//    					line.getPointX(i-1), line.getPointY(i-1),
//    					line.getPointX(i), line.getPointY(i));
//    		}
//		}
//    	
//    }
//    
//    private class MyListener extends MouseAdapter {
//    	@Override
//    	public void mousePressed(MouseEvent e) {
//    		Line line = new Line();
//    		line.addPoint(e.getX(), e.getY());
//    		lines.add(line);
//    	}
//    	
//    	@Override
//    	public void mouseDragged(MouseEvent e) {
//    		lines.getLast().addPoint(e.getX(), e.getY());
//    		repaint();
//    	}
//    }
//    
//    public void clear() {
//    	lines.clear();
//    	repaint();
//    }
//    
//}






// 0108 LAB
public class MyDrawer extends JPanel{
	private List<Line> lines;
	private Color currentColor = Color.BLACK;
	private Stack<Line> undoStack = new Stack<>();
	
	
    public MyDrawer() {
    	setBackground(Color.YELLOW);
    	
    	lines = new ArrayList<>();
    	
    	MyListener listener = new MyListener();
    	addMouseListener(listener);
    	addMouseMotionListener(listener);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	Graphics2D g2d = (Graphics2D)g;
    	
    	g2d.setStroke(new BasicStroke(5));
    	g2d.setColor(Color.BLUE);
    	
    	for (Line line : lines) {
    		g2d.setColor(line.getColor());
    		for (int i = 1; i < line.getSize(); i++) {
    			g2d.drawLine(
    					line.getPointX(i-1), line.getPointY(i-1),
    					line.getPointX(i), line.getPointY(i));
    		}
		}
    	
    }
    
    private class MyListener extends MouseAdapter {
    	@Override
    	public void mousePressed(MouseEvent e) {
    		Line line = new Line(currentColor);
    		line.addPoint(e.getX(), e.getY());
    		lines.add(line);
    		undoStack.clear();
    	}
    	
    	@Override
    	public void mouseDragged(MouseEvent e) {
    		lines.getLast().addPoint(e.getX(), e.getY());
    		repaint();
    	}
    }
    
    public void clear() {
    	lines.clear();
    	repaint();
    }
    
    public void setCurrentColor(Color c) {
    	this.currentColor = c;
    }
    
    public Color getCurrentColor() {
    	return currentColor;
    }
    
    public void undo() {
    	if (!lines.isEmpty()) {
    		undoStack.push(lines.remove(lines.size()-1));
    		repaint();
    	}
    }
    public void redo() {
    	if (!undoStack.isEmpty()) {
    		lines.add(undoStack.pop());
    		repaint();
    	}
    }
}






