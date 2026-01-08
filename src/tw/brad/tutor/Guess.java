package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Guess extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private final int times = 10; // 宣告時給值
	private int counter;
	
	
    public Guess() {
    	super("猜數字遊戲");
    	
    	guess = new JButton("猜");
    	input = new JTextField();
    	log = new JTextArea();
    	
    	input.setFont(new Font(null, Font.BOLD | Font.ITALIC , 24));
    	input.setForeground(Color.BLUE);
    	
    	setLayout(new BorderLayout());
    	add(log, BorderLayout.CENTER);
    	
    	JPanel top = new JPanel(new BorderLayout());
    	add(top, BorderLayout.NORTH);
    	top.add(guess, BorderLayout.EAST);
    	top.add(input, BorderLayout.CENTER);
    	
    	
    	setSize(640, 480);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
//    	times = 10; //建構式給值
    	
    	initGame();
    	guess.addActionListener(this);
//    	guess.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("OK2");
//			}
//		});    	
    }
    
    private void initGame() {
    	log.append("開始新一輪遊戲\n");
    	this.counter = 0;
    	answer = createAnswer(3);
    	System.out.println(answer);
    }
    
    private String createAnswer(int d) {
		final int num = 10;
		int[] poker = new int[num];
		for (int i = 0; i < num; i++) poker[i] = i;
			
		for(int i = num - 1; i > 0; i--) {
			int r = (int)(Math.random()*(i+1));
			// poker[i] <=> poker[r]
			int temp = poker[i];
			poker[i] = poker[r];
			poker[r] = temp;
		}
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<d; i++) sb.append(poker[i]);
		
	    return sb.toString();
    }
    
	
	public static void main(String[] args) {
		new Guess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String g = input.getText();
		// 檢查機制
		if (g.matches("[0-9]*")) {
			if (g.length() == answer.length()) {
				boolean isDup = false;
				for (int i = 0; i < g.length(); i++) {
				    for (int j = 0; j < g.length(); j++) {
				        if (i != j && g.charAt(i) == g.charAt(j)) {
				            isDup = true;
							JOptionPane.showMessageDialog(null, " 數字 '" + g.charAt(i) + "' 重複了，猜的數字不能重複！");							
				            break; // 找到重複就可以跳出內層迴圈
				        }
				    }
				    if (isDup) break; // 若已找到重複則跳出外層迴圈
				}
				if (!isDup) {
				    counter++;
				    input.setText("");
				    
				    String result = checkAB(g);
				    log.append(String.format("%d. %s => %s\n", counter, g, result));
				    
				    if (result.equals("3A0B")) {
				    	JOptionPane.showMessageDialog(null, "恭喜答對了！猜的次數為：" + counter + " 次");							
				    	initGame();
				    }else if (counter == times){
				    	JOptionPane.showMessageDialog(null, "Answer is " + answer);			
				    	initGame();
				    }
				}

			}else {
				JOptionPane.showMessageDialog(null, "輸入字數為" + answer.length());							
			}
		}else {
			JOptionPane.showMessageDialog(null, "輸入錯誤！");			
		}
		
	}

	private String checkAB(String g) {
		int A, B; A = B = 0;
		
		for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				A++;
			}else if (answer.indexOf(g.charAt(i)) != -1){
				B++;
			}
		}
		
		return String.format("%dA%dB", A, B);
	}
	
	
}
