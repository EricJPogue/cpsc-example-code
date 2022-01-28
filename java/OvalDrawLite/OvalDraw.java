// Author:         Eric Pogue
// Description:    This application draws an oval in red.
// License:        All rights reserved.
//
// Topics:
//     - Reuse 
//     - Classes and objects
//     - Constructors and default constructors
//     - Getters and setters
//     - Encapsulation
//     - Properties (member variables)
//     - Ownership
//     - Methods (member functions)
//     - Inheritance
//     - Java graphical programming
//     - Containers

// Reuse
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;

// Classes and inheritance 
class Oval extends JPanel {
	// Ownership and Encapsulation 
    private Color ovalColor;

	// Getters and setters
	public Color getColor() {
        return ovalColor;
    }
    public void setColor(int red, int green, int blue) {
        ovalColor = new Color(red, green, blue);
    }

	// Default constructor
    Oval() {
        setColor(255, 0, 0);
    }

	// Non-default constructor
    Oval(int red, int green, int blue) {
        setColor(red, green, blue);       
    }

	// Java graphics programming
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

		// Methods and member functions
        int panelWidth = getWidth();
        int panelHeight = getHeight();

		// Association
        g.setColor(ovalColor);
        g.fillOval(0, 0, panelWidth, panelHeight);
    }
}

class OvalFrame extends JFrame {
    OvalFrame() {
        setTitle("OvalDraw");
        setBounds(200, 200, 300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oval myOval = new Oval();

		// Ownership
        Container contentPane = getContentPane();

		// Containers
        contentPane.add(myOval);     
    }
}

public class OvalDraw {
    public static void main(String[] args) {
        System.out.println("OvalDraw Starting...");
		OvalFrame myFrame = new OvalFrame();
		myFrame.setVisible(true);
    }
}