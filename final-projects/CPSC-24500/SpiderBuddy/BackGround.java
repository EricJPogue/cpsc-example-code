import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public abstract class BackGround extends JPanel {
    public Color darkerBrown, offBrown, neonGreen, greylimestone, darklimestone, glassBuilding, eggWhite, grey,
            limestone, brick,
            black,
            skyBlue, silverGrey, white, offWhite, red, blue, brown, woodBrown, darkBrown, lightGrey, glass;

    public BackGround() {
        super();
        grey = new Color(145, 145, 145);
        brick = new Color(125, 50, 50);
        black = new Color(0, 0, 0);
        white = new Color(255, 255, 255);
        offWhite = new Color(235, 235, 235);
        red = new Color(210, 0, 0);
        blue = new Color(0, 20, 210);
        brown = new Color(80, 55, 0);
        offBrown = new Color(78, 50, 0);
        woodBrown = new Color(135, 115, 80);
        darkBrown = new Color(70, 50, 25);
        darkerBrown = new Color(60, 25, 10);
        lightGrey = new Color(190, 190, 190);
        silverGrey = new Color(210, 210, 210);
        glass = new Color(195, 252, 255);
        skyBlue = new Color(196, 246, 252);
        limestone = new Color(220, 215, 180);
        greylimestone = new Color(210, 210, 195);
        darklimestone = new Color(190, 185, 155);
        eggWhite = new Color(255, 250, 230);
        glassBuilding = new Color(0, 125, 255);
        neonGreen = new Color(0, 255, 0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

class PeterApartment extends BackGround {
    public PeterApartment() {
        super();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        // PanelWidth = 770
        // PanelHeight = 815

        // Wall and Floor
        g2d.setColor(offWhite);
        g2d.fillRect(0, 0, 770, 500);
        g2d.setColor(eggWhite);
        g2d.fillRect(0, 0, 770, 10);
        g2d.setColor(darkBrown);
        g2d.fillRect(0, 460, 770, 15);
        g2d.setColor(black);
        g2d.drawRect(0, 460, 770, 15);
        g2d.setColor(woodBrown);
        g2d.fillRect(0, 475, 770, 340);
        g2d.setColor(darkBrown);
        g2d.drawLine(0, 480, 770, 480);

        g2d.drawLine(0, 490, 770, 490);

        g2d.drawLine(0, 500, 770, 500);

        g2d.drawLine(0, 510, 770, 510);

        g2d.drawLine(0, 525, 770, 525);

        g2d.drawLine(0, 540, 770, 540);

        g2d.drawLine(0, 555, 770, 555);

        g2d.drawLine(0, 575, 770, 575);

        g2d.drawLine(0, 595, 770, 595);

        g2d.drawLine(0, 615, 770, 615);
        g2d.drawLine(0, 640, 770, 640);
        g2d.drawLine(0, 665, 770, 665);
        g2d.drawLine(0, 690, 770, 690);
        g2d.drawLine(0, 720, 770, 720);
        g2d.drawLine(0, 750, 770, 750);
        g2d.drawLine(0, 780, 770, 780);

        // Left Window
        g2d.setColor(lightGrey);
        g2d.fillRect(40, 70, 320, 220);
        g2d.setColor(grey);
        g2d.drawRect(40, 70, 320, 220);
        g2d.setColor(skyBlue);
        g2d.fillRect(50, 80, 300, 200);
        g2d.setColor(lightGrey);
        g2d.fillRect(200, 130, 20, 150);
        g2d.setColor(darklimestone);
        g2d.fillRect(70, 150, 60, 40);
        g2d.setColor(glassBuilding);
        g2d.fillRect(50, 90, 50, 190);
        g2d.fillRect(227, 135, 15, 15);
        g2d.setColor(grey);
        g2d.fillRect(218, 150, 40, 40);

        g2d.setColor(black);// Oscorp
        g2d.fillPolygon(new int[] { 120, 130, 220, 220, 200, 190, 200, 220, 180, 175, 130, 120, 117 },
                new int[] { 130, 230, 230, 220, 170, 130, 120, 110, 110, 85, 85, 105, 120 }, 13);
        g2d.setColor(neonGreen);
        g2d.drawPolygon(new int[] { 120, 130, 220, 220, 200, 190, 200, 220, 180, 175, 130, 120, 117 },
                new int[] { 130, 230, 230, 220, 170, 130, 120, 110, 110, 85, 85, 105, 120 }, 13);
        g2d.fillPolygon(new int[] { 135, 140, 143, 138, 148, 145 }, new int[] { 125, 90, 90, 125, 222, 222 }, 6);

        g2d.setFont(new Font("Bauhaus 93", Font.PLAIN, 13));
        g2d.rotate(Math.toRadians(-94), 136, 155);
        g2d.drawString("OSCORP", 136, 155);
        g2d.setTransform(base);

        g2d.setColor(greylimestone);
        g2d.fillRect(250, 115, 100, 165);
        g2d.setColor(limestone);
        g2d.fillRect(50, 180, 210, 100);
        g2d.setColor(brick);
        g2d.fillRect(285, 200, 65, 80);
        g2d.setColor(grey);
        g2d.drawRect(50, 80, 300, 200);
        g2d.setColor(lightGrey);
        g2d.fillRect(50, 170, 300, 10);
        g2d.setColor(grey);
        g2d.drawRect(50, 170, 300, 10);

        // Right Window
        g2d.setColor(lightGrey);
        g2d.fillRect(400, 70, 320, 220);
        g2d.setColor(grey);
        g2d.drawRect(400, 70, 320, 220);
        g2d.setColor(skyBlue);
        g2d.fillRect(410, 80, 300, 200);
        g2d.setColor(glassBuilding);
        g2d.fillRect(410, 140, 18, 60);
        g2d.setColor(black);
        g2d.fillRect(538, 178, 8, 20);
        g2d.setColor(brick);
        g2d.fillRect(528, 190, 30, 60);
        g2d.setColor(grey);
        g2d.fillRect(650, 159, 20, 60);
        g2d.setColor(white);
        g2d.fillRect(685, 140, 18, 60);
        g2d.setColor(limestone); // Empire State
        g2d.fillRect(550, 145, 70, 135);
        g2d.fillRect(555, 125, 60, 20);
        g2d.setColor(greylimestone);
        g2d.fillRect(560, 112, 50, 13);
        g2d.fillRect(573, 145, 24, 135);
        g2d.fillRect(569, 125, 32, 20);
        g2d.setColor(grey);
        g2d.fillRect(565, 108, 40, 4);
        g2d.fillRect(572, 105, 26, 3);
        g2d.fillRect(578, 102, 14, 3);
        g2d.fillRect(580, 96, 10, 6);
        g2d.fillRect(581, 80, 8, 16);
        g2d.setColor(lightGrey);
        g2d.fillRect(450, 200, 150, 80);
        g2d.setColor(silverGrey);
        g2d.fillRect(610, 175, 100, 105);
        g2d.setColor(white);
        g2d.fillRect(430, 120, 98, 160);
        g2d.fillPolygon(new int[] { 430, 528, 500, 490, 440 }, new int[] { 120, 120, 110, 100, 100 }, 5);
        g2d.setColor(silverGrey);
        g2d.drawPolygon(new int[] { 430, 430, 528, 528, 500, 490, 440 },
                new int[] { 120, 280, 280, 120, 110, 100, 100 },
                7);
        g2d.setColor(brick);
        g2d.fillRect(410, 200, 65, 80);
        g2d.setColor(limestone);
        g2d.fillRect(445, 240, 265, 40);
        g2d.setColor(grey);
        g2d.drawRect(410, 80, 300, 200);
        g2d.setColor(lightGrey);
        g2d.fillRect(410, 170, 300, 10);
        g2d.setColor(grey);
        g2d.drawRect(410, 170, 300, 10);

        // Desk
        g2d.setColor(brown);
        g2d.fillPolygon(new int[] { 250, 250, 248, 248 }, new int[] { 346, 475, 482, 344 }, 4);
        g2d.setColor(offBrown);
        g2d.fillPolygon(new int[] { 248, 248, 238, 238 }, new int[] { 344, 482, 482, 344 }, 4);
        g2d.setColor(darkerBrown);
        g2d.drawPolygon(new int[] { 250, 250, 248, 248 }, new int[] { 346, 475, 482, 344 }, 4);
        g2d.drawPolygon(new int[] { 248, 248, 238, 238 }, new int[] { 344, 482, 482, 344 }, 4);

        g2d.setColor(brown);
        g2d.fillPolygon(new int[] { 240, 240, 244, 244 }, new int[] { 366, 508, 497, 363 }, 4);
        g2d.setColor(offBrown);
        g2d.fillPolygon(new int[] { 240, 240, 228, 228 }, new int[] { 366, 508, 508, 366 }, 4);
        g2d.setColor(darkerBrown);
        g2d.drawPolygon(new int[] { 240, 240, 244, 244 }, new int[] { 366, 508, 497, 363 }, 4);
        g2d.drawPolygon(new int[] { 240, 240, 228, 228 }, new int[] { 366, 508, 508, 366 }, 4);

        g2d.setColor(woodBrown);
        g2d.fillPolygon(new int[] { 0, 0, 240, 250 }, new int[] { 340, 346, 346, 340 }, 4);
        g2d.setColor(brown);
        g2d.fillPolygon(new int[] { 250, 250, 240, 240 }, new int[] { 340, 360, 366, 346 }, 4);
        g2d.setColor(offBrown);
        g2d.fillPolygon(new int[] { 0, 0, 240, 240 }, new int[] { 346, 366, 366, 346 }, 4);
        g2d.setColor(darkerBrown);
        g2d.drawPolygon(new int[] { 0, 0, 240, 250 }, new int[] { 340, 346, 346, 340 }, 4);
        g2d.drawPolygon(new int[] { 250, 250, 240, 240 }, new int[] { 340, 360, 366, 346 }, 4);
        g2d.drawPolygon(new int[] { 0, 0, 240, 240 }, new int[] { 346, 366, 366, 346 }, 4);

        // Bed
        g2d.setColor(blue);
        g2d.fillRoundRect(450, 370, 400, 70, 30, 5);
        g2d.setColor(black);
        g2d.drawRoundRect(450, 370, 400, 70, 30, 5);
        g2d.setColor(blue);
        g2d.fillPolygon(new int[] { 450, 450, 528, 528 }, new int[] { 372, 438, 506, 418 }, 4);
        g2d.fillRoundRect(528, 416, 400, 94, 30, 5);
        g2d.setColor(black);
        g2d.drawPolygon(new int[] { 450, 450, 528, 528 }, new int[] { 372, 438, 506, 418 }, 4);
        g2d.drawRoundRect(528, 416, 400, 94, 30, 5);

    }
}