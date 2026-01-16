package tw.brad.tutor;

import javax.swing.JFrame;
import java.awt.BorderLayout;

// 單獨顯示類比時鐘的主程式
public class AI_AnalogClockMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("類比時鐘");
        frame.setLayout(new BorderLayout());
        frame.add(new AI_AnalogClock(), BorderLayout.CENTER);
        frame.setSize(400, 420); // 建議視窗大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
