import javax.swing.*;
import java.awt.*;


public class SimplePieChart extends JFrame {

    public SimplePieChart(String title) {
        super(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Example data
        int[] values = {30, 50, 90}; // Percentages
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};

        drawPieChart(g, getWidth() / 2, getHeight() / 2, 100, values, colors);
    }

    private void drawPieChart(Graphics g, int x, int y, int radius, int[] values, Color[] colors) {
        int total = 0;

        for (int value : values) {
            total += value;
        }

        int startAngle = 0;

        for (int i = 0; i < values.length; i++) {
            int arcAngle = (int) Math.round(((double) values[i] / total) * 360);
            g.setColor(colors[i]);
            g.fillArc(x - radius, y - radius, 2 * radius, 2 * radius, startAngle, arcAngle);
            startAngle += arcAngle;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimplePieChart("Simple Pie Chart"));
    }
}
