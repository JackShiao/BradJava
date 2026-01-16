package tw.brad.tutor;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.BasicStroke;

// 類比時鐘元件，繼承 JPanel
public class AI_AnalogClock extends JPanel {
    // 建議時鐘面板大小
    private static final int SIZE = 300;

    public AI_AnalogClock() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        // 每秒自動更新畫面
	    // 每秒觸發 repaint()，用 Lambda 寫法
//         Timer timer = new Timer(1000, e -> repaint());

        // 每秒觸發 repaint()，用匿名內部類別寫法
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // 開啟抗鋸齒，讓繪圖邊緣平滑
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        /*  取寬與高的較小值，確保時鐘不會超出面板範圍。
	    	除以 2 得到半徑（因為圓心在中間）。
	    	再減 10，預留邊界空間，避免時鐘貼到邊緣。 */
        int radius = Math.min(w, h) / 2 - 10;
        int centerX = w / 2;
        int centerY = h / 2;

        // 畫時鐘圓框
        // 設定顏色為白色，畫出時鐘底盤
        g2.setColor(Color.WHITE);
        // fillOval 的前兩個參數是圓形左上角座標，後兩個是寬與高（這裡寬高都等於直徑，畫出正圓）。
        g2.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // 設定顏色為黑色，畫出時鐘外框
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3)); //設定線條粗細為 3 像素。
        g2.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // 畫刻度
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30 - 90);
            int x1 = (int) (centerX + Math.cos(angle) * (radius - 10));
            int y1 = (int) (centerY + Math.sin(angle) * (radius - 10));
            int x2 = (int) (centerX + Math.cos(angle) * (radius - 2));
            int y2 = (int) (centerY + Math.sin(angle) * (radius - 2));
            g2.drawLine(x1, y1, x2, y2);
        }

        // 取得目前時間
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        // 畫時針
        double hourAngle = Math.toRadians((hour % 12 + minute / 60.0) * 30 - 90);
        int hourLen = (int) (radius * 0.5);
        int hx = (int) (centerX + Math.cos(hourAngle) * hourLen);
        int hy = (int) (centerY + Math.sin(hourAngle) * hourLen);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(centerX, centerY, hx, hy);

        // 畫分針
        double minAngle = Math.toRadians((minute + second / 60.0) * 6 - 90);
        int minLen = (int) (radius * 0.75);
        int mx = (int) (centerX + Math.cos(minAngle) * minLen);
        int my = (int) (centerY + Math.sin(minAngle) * minLen);
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(centerX, centerY, mx, my);

        // 畫秒針
        double secAngle = Math.toRadians(second * 6 - 90);
        int secLen = (int) (radius * 0.85);
        int sx = (int) (centerX + Math.cos(secAngle) * secLen);
        int sy = (int) (centerY + Math.sin(secAngle) * secLen);
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(centerX, centerY, sx, sy);

        // 畫中心圓點
        g2.setColor(Color.BLACK);
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
}
