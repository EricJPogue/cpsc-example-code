// Author: Eric Pogue
// Note:   Drawing an oval in red.

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;

class Oval extends JPanel {
    private Color myColor;
    public void setColor(int red, int green, int blue) {
        myColor = new Color(red,green,blue);
    }
    public Color getColor() {
        return myColor;
    }

    Oval() {
        setColor(255,0,0);
    }

    Oval(int red, int green, int blue) {
        setColor(red,green,blue);       
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(myColor);
        g.fillOval(0,0,panelWidth,panelHeight);
    }
}

class OvalFrame extends JFrame {
    OvalFrame() {
        setTitle("OvalDraw");
        setBounds(200,200,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oval myOval = new Oval(0,255,255);
        Container contentPane = getContentPane();
        contentPane.add(myOval);     
    }
}

public class OvalDraw {
    public static void main(String[] args) {
        System.out.println("OvalDraw Starting...");
		OvalFrame myFrame = new OvalFrame();

		myFrame.setVisible(true);
		// Note that if setVisible is called from the constructor, the oval will
		// not draw initially on MacOS. 
    }
}