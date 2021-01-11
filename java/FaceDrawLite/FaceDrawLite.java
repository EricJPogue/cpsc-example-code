++++import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class OvalDraw extends Oval {
    private Boolean drawOvalFilledRed;
    public void setDrawOvalFilledRed() { drawOvalFilledRed = true; }

    public OvalDraw () {
        super(0,0,0,0);
        drawOvalFilledRed = false; 
    }

    public OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
        drawOvalFilledRed = false;
    }

    public void paintComponent(Graphics g) {
        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
        if (drawOvalFilledRed) {
            g.setColor(Color.red);
            g.fillOval(getPositionX()+1, getPositionY()+1, getWidth()-2, getHeight()-2);
            g.setColor(Color.black);
        }
        System.out.format("OvalDraw.paintComponent(x=%d, y=%d, w=%d, h=%d)\n", 
            getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}

class SadCyclopsFace extends OvalDraw {
    private OvalDraw eye;

    public SadCyclopsFace () {
        super(0,0,0,0);
        eye = new OvalDraw(0,0,0,0);
    }

    public SadCyclopsFace(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
    
        int eyeHeight = heightIn / 7;
        int eyeWidth = eyeHeight * 2;
        int eyePositionX = positionXIn + (widthIn / 2) - (eyeWidth / 2);
        int eyePoisitonY = positionYIn + (heightIn / 3) - (eyeHeight / 2);

        eye = new OvalDraw(eyePositionX, eyePoisitonY, eyeWidth, eyeHeight);
        eye.setDrawOvalFilledRed();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        eye.paintComponent(g);
        g.drawArc(getPositionX(), getPositionY()+(getHeight()/2), getWidth()-10, getHeight()-10, 45, 90);
    }
}

class SadCyclopsPanel extends JPanel {
    private SadCyclopsFace mySadCyclopsFace;
    private SadCyclopsFace mySadCyclopsFace2;
    
    public SadCyclopsPanel() {
        mySadCyclopsFace = new SadCyclopsFace(100,100,80,160);
        mySadCyclopsFace2 = new SadCyclopsFace(250,150,100,260);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mySadCyclopsFace.paintComponent(g);
        mySadCyclopsFace2.paintComponent(g);
    }
}

public class FaceDrawLite {
    public static void main(String[] args) {
        System.out.println("FaceDrawLite...");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame myFrame = new JFrame("Sad Cyclops FaceDraw");
        myFrame.setBounds(100,100,900,500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SadCyclopsPanel mySadCyclopsPanel = new SadCyclopsPanel();
        myFrame.add(mySadCyclopsPanel);
        myFrame.setVisible(true);
    }
}