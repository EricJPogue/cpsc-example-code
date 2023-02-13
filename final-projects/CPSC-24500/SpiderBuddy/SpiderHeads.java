import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

abstract class Heads extends JPanel {
        public SpiderColors colorscheme;

        public Heads(int centerPositionX, int centerPositionY, int character) {
                setHeadPositionX(centerPositionX - 100);
                setHeadPositionY(centerPositionY - 100);
                setHeadWidth(200);
                setHeadHeight(200);
                colorscheme = new SpiderColors(character);
        }

        public Heads(int positionX, int positionY, int width, int height, int character) {
                setHeadPositionX(positionX);
                setHeadPositionY(positionY);
                setHeadWidth(width);
                setHeadHeight(height);
                colorscheme = new SpiderColors(character);
        }

        public void setColor(int character) {
                colorscheme = new SpiderColors(character);
        }

        private int headPositionX;

        public void setHeadPositionX(int positionX) {
                headPositionX = positionX;
        }

        public int getHeadPositionX() {
                return headPositionX;
        }

        private int headPositionY;

        public void setHeadPositionY(int positionY) {
                headPositionY = positionY;
        }

        public int getHeadPositionY() {
                return headPositionY;
        }

        private int headWidth;

        public void setHeadWidth(int width) {
                headWidth = width;
        }

        public int getHeadWidth() {
                return headWidth;
        }

        private int headHeight;

        public void setHeadHeight(int height) {
                headHeight = height;
        }

        public int getHeadHeight() {
                return headHeight;
        }

        // headCenterX = getHeadPositionX() + (getHeadWidth() / 2);
        // headCenterY = getHeadPositionY() + (getHeadWidth() / 2);
        // Inner Ring CenterX
        // Inner Ring

        public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                AffineTransform base = g2d.getTransform();
                // Base Head
                g2d.setColor(colorscheme.getMaskColor());
                g2d.fillOval(getHeadPositionX(), getHeadPositionY(), getHeadWidth(), getHeadHeight());
                g2d.setColor(colorscheme.getWebbingOutlineColor());
                g2d.drawOval(getHeadPositionX(), getHeadPositionY(), getHeadWidth(), getHeadHeight());

                // Initial Support Webs
                g2d.setColor(colorscheme.getWebbingColor());
                g2d.drawLine(getHeadPositionX() + getHeadWidth() / 2, getHeadPositionY() + getHeadHeight() * 60 / 100,
                                getHeadPositionX() + getHeadWidth() / 2, getHeadPositionY());
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 - getHeadWidth() * 595 / 10000,
                                getHeadPositionY() - getHeadHeight() * 15 / 1000,
                                getHeadWidth() * 80 / 50, getHeadHeight() * 260 / 100, 150, -31);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 - getHeadWidth() * 1540 / 1000,
                                getHeadPositionY() - getHeadHeight() * 15 / 1000,
                                getHeadWidth() * 80 / 50, getHeadHeight() * 260 / 100, 30, 31);
                g2d.drawLine(getHeadPositionX() + getHeadWidth() * 55 / 100,
                                getHeadPositionY() + getHeadHeight() * 635 / 1000,
                                getHeadPositionX() + getHeadWidth() * 99 / 100,
                                getHeadPositionY() + getHeadHeight() * 40 / 100);
                g2d.drawLine(getHeadPositionX() + getHeadWidth() * 45 / 100,
                                getHeadPositionY() + getHeadHeight() * 635 / 1000,
                                getHeadPositionX() + getHeadWidth() * 1 / 100,
                                getHeadPositionY() + getHeadHeight() * 40 / 100);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 120 / 100,
                                getHeadPositionY() + getHeadHeight() * 635 / 1000,
                                getHeadWidth() * 350 / 100, getHeadHeight() * 360 / 50, 90, -13);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 130 / 100,
                                getHeadPositionY() + getHeadHeight() * 635 / 1000,
                                getHeadWidth() * 350 / 100, getHeadHeight() * 360 / 50, 90, 13);
                g2d.drawLine(getHeadPositionX() + getHeadWidth() * 53 / 100,
                                getHeadPositionY() + getHeadHeight() * 671 / 1000,
                                getHeadPositionX() + getHeadWidth() * 715 / 1000,
                                getHeadPositionY() + getHeadHeight() * 95 / 100);
                g2d.drawLine(getHeadPositionX() + getHeadWidth() * 47 / 100,
                                getHeadPositionY() + getHeadHeight() * 671 / 1000,
                                getHeadPositionX() + getHeadWidth() * 285 / 1000,
                                getHeadPositionY() + getHeadHeight() * 95 / 100);

                // Inner Ring
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 403 / 1000,
                                getHeadPositionY() + getHeadHeight() * 60 / 100 - getHeadHeight() / 10 * 654 / 1000,
                                getHeadWidth() / 10, getHeadHeight() / 10, -90, 72);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 - getHeadWidth() / 10 * 1290 / 1000,
                                getHeadPositionY() + getHeadHeight() * 60 / 100 + getHeadHeight() / 10 * 310 / 1000,
                                getHeadWidth() / 10, getHeadHeight() / 17, -18, 72);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 - getHeadWidth() / 10 * 530 / 1000,
                                getHeadPositionY() + getHeadHeight() * 60 / 100 + getHeadHeight() / 10 * 615 / 1000,
                                getHeadWidth() / 10, getHeadHeight() / 10, 54, 72);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 + getHeadWidth() / 10 * 280 / 1000,
                                getHeadPositionY() + getHeadHeight() * 60 / 100 + getHeadHeight() / 10 * 310 / 1000,
                                getHeadWidth() / 10, getHeadHeight() / 17, 126, 72);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() / 2 - getHeadWidth() / 10 * 20 / 1000,
                                getHeadPositionY() + getHeadHeight() * 60 / 100 - getHeadHeight() / 10 * 654 / 1000,
                                getHeadWidth() / 10, getHeadHeight() / 10, 198, 72);
                // Middle Ring
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 155 / 1000,
                                getHeadPositionY() + getHeadHeight() * 10 / 100,
                                getHeadWidth() * 42 / 100, getHeadHeight() / 3, -90, 40);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 62 / 1000,
                                getHeadPositionY() + getHeadHeight() * 205 / 1000,
                                getHeadWidth() * 43 / 100, getHeadHeight() * 39 / 100, -50, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 16 / 100,
                                getHeadPositionY() + getHeadHeight() * 48 / 100,
                                getHeadWidth() / 7, getHeadHeight() * 29 / 100, -10, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 3 / 100,
                                getHeadPositionY() + getHeadHeight() * 632 / 1000,
                                getHeadWidth() * 40 / 100, getHeadHeight() * 57 / 100, 30, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 215 / 1000,
                                getHeadPositionY() + getHeadHeight() * 765 / 1000,
                                getHeadWidth() * 57 / 100, getHeadHeight() / 3, 70, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 57 / 100,
                                getHeadPositionY() + getHeadHeight() * 632 / 1000,
                                getHeadWidth() * 40 / 100, getHeadHeight() * 57 / 100, 110, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 703 / 1000,
                                getHeadPositionY() + getHeadHeight() * 474 / 1000,
                                getHeadWidth() / 7, getHeadHeight() * 30 / 100, 150, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 635 / 1000,
                                getHeadPositionY() + getHeadHeight() * 205 / 1000,
                                getHeadWidth() * 43 / 100, getHeadHeight() * 39 / 100, 190, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 425 / 1000,
                                getHeadPositionY() + getHeadHeight() * 10 / 100,
                                getHeadWidth() * 42 / 100, getHeadHeight() / 3, 230, 40);

                // Outer Ring
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 9 / 100,
                                getHeadPositionY() - getHeadHeight() * 305 / 1000,
                                getHeadWidth() * 72 / 100, getHeadHeight() * 59 / 100, -90, 40);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 325 / 1000,
                                getHeadPositionY() - getHeadHeight() * 107 / 1000,
                                getHeadWidth() * 60 / 100, getHeadHeight() * 67 / 100, -50, 40);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 19 / 1000,
                                getHeadPositionY() + getHeadHeight() * 345 / 1000,
                                getHeadWidth() * 20 / 100, getHeadHeight() * 57 / 100, -10, 40);
                g2d.drawArc(getHeadPositionX() - getHeadWidth() * 255 / 1000,
                                getHeadPositionY() + getHeadHeight() * 658 / 1000,
                                getHeadWidth() * 65 / 100, getHeadHeight() * 765 / 1000, 30, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 65 / 1000,
                                getHeadPositionY() + getHeadHeight() * 84 / 100,
                                getHeadWidth() * 87 / 100, getHeadHeight() / 3, 70, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 605 / 1000,
                                getHeadPositionY() + getHeadHeight() * 658 / 1000,
                                getHeadWidth() * 65 / 100, getHeadHeight() * 765 / 1000, 110, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 818 / 1000,
                                getHeadPositionY() + getHeadHeight() * 345 / 1000,
                                getHeadWidth() * 20 / 100, getHeadHeight() * 57 / 100, 150, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 725 / 1000,
                                getHeadPositionY() - getHeadHeight() * 107 / 1000,
                                getHeadWidth() * 60 / 100, getHeadHeight() * 67 / 100, 190, 40);
                g2d.drawArc(getHeadPositionX() + getHeadWidth() * 37 / 100,
                                getHeadPositionY() - getHeadHeight() * 305 / 1000,
                                getHeadWidth() * 72 / 100, getHeadHeight() * 59 / 100, 230, 40);

        }
}

// SquintEyes
// NormalEyes
// ConfusedEyes
// ClosedEyes
// WideEyes
// WinkEyes
// SadEyes
// WiderEyes
// EvenEyes

// Smiles
// SideSmile
// Frowns
// SideFrown
// NeutralMouth
// NeutralMouthSmall
// OpenMouth
// OpenMouthSmall
// SideOpenMouthSmall
// Laugh

class CoveredFace extends Heads {
        public NormalEyes eyes;

        public CoveredFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
        }

        public CoveredFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
        }
}

class HappyFace extends Heads {
        public NormalEyes eyes;
        public Smiles mouth;

        public HappyFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Smiles(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public HappyFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Smiles(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class ConfusedFace extends Heads {
        public ConfusedEyes eyes;
        public SideFrown mouth;

        public ConfusedFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new ConfusedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideFrown(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public ConfusedFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new ConfusedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideFrown(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class SurprisedFace extends Heads {
        public WideEyes eyes;
        public OpenMouthSmall mouth;

        public SurprisedFace() {
                this(100, 100, 0, 0, 1);
        }

        public SurprisedFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new WideEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new OpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public SurprisedFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new WideEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new OpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class NeutralFace extends Heads {
        public EvenEyes eyes;
        public NeutralMouthSmall mouth;

        public NeutralFace() {
                this(100, 100, 0, 0, 1);
        }

        public NeutralFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new EvenEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public NeutralFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new EvenEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class SadFace extends Heads {
        public SadEyes eyes;
        public Frowns mouth;

        public SadFace() {
                this(100, 100, 0, 0, 1);
        }

        public SadFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new SadEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Frowns(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public SadFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new SadEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Frowns(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class AngryFace extends Heads {
        public NormalEyes eyes;
        public Frowns mouth;

        public AngryFace() {
                this(100, 100, 0, 0, 1);
        }

        public AngryFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Frowns(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public AngryFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Frowns(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class MadFace extends Heads {
        public SquintEyes eyes;
        public NeutralMouthSmall mouth;

        public MadFace() {
                this(100, 100, 0, 0, 1);
        }

        public MadFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new SquintEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public MadFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new SquintEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class YellingFace extends Heads {
        public WiderEyes eyes;
        public OpenMouth mouth;

        public YellingFace() {
                this(100, 100, 0, 0, 1);
        }

        public YellingFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new WiderEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new OpenMouth(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public YellingFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new WiderEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new OpenMouth(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class ChattingFace extends Heads {
        public EvenEyes eyes;
        public SideOpenMouthSmall mouth;

        public ChattingFace() {
                this(100, 100, 0, 0, 1);
        }

        public ChattingFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new EvenEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideOpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public ChattingFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new EvenEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideOpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class SleepyFace extends Heads {
        public ClosedEyes eyes;
        public SideFrown mouth;

        public SleepyFace() {
                this(100, 100, 0, 0, 1);
        }

        public SleepyFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideFrown(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public SleepyFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideFrown(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class LaughingFace extends Heads {
        public NormalEyes eyes;
        public Laugh mouth;

        public LaughingFace() {
                this(100, 100, 0, 0, 1);
        }

        public LaughingFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Laugh(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public LaughingFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Laugh(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class WinkingFace extends Heads {
        public WinkEyes eyes;
        public SideSmile mouth;

        public WinkingFace() {
                this(100, 100, 0, 0, 1);
        }

        public WinkingFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new WinkEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideSmile(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public WinkingFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new WinkEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideSmile(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class SnoringFace extends Heads {
        public ClosedEyes eyes;
        public SideOpenMouthSmall mouth;

        public SnoringFace() {
                this(100, 100, 0, 0, 1);
        }

        public SnoringFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideOpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public SnoringFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new SideOpenMouthSmall(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class NormalFace extends Heads {
        public NormalEyes eyes;
        public NeutralMouth mouth;

        public NormalFace() {
                this(100, 100, 0, 0, 1);
        }

        public NormalFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouth(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public NormalFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new NormalEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new NeutralMouth(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}

class UltraLaughingFace extends Heads {
        public ClosedEyes eyes;
        public Laugh mouth;

        public UltraLaughingFace() {
                this(100, 100, 0, 0, 1);
        }

        public UltraLaughingFace(int positionX, int positionY, int character) {
                super(positionX, positionY, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Laugh(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public UltraLaughingFace(int positionX, int positionY, int width, int height, int character) {
                super(positionX, positionY, width, height, character);
                eyes = new ClosedEyes(getHeadPositionX() + (getHeadWidth() / 2),
                                getHeadPositionY() + (getHeadHeight() / 2),
                                getHeadWidth(), getHeadHeight(), character);
                mouth = new Laugh(getHeadPositionX() + (getHeadWidth() * 20 / 100),
                                getHeadPositionY() + (getHeadHeight() * 73 / 100),
                                getHeadWidth() * 60 / 100, getHeadHeight() * 27 / 100, character);
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                eyes.paintComponent(g);
                mouth.paintComponent(g);
        }
}