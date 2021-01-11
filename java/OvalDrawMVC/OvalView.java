import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Rectangle;

public class OvalView extends JFrame {
    private Rectangle r;

    public OvalView() {
        setBounds(100,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateView(Rectangle rIn) {
        r = rIn;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g); 
        g.drawOval((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
    }

}
