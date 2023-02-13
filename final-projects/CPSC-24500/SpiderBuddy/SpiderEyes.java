import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

abstract class SpiderEyes {
    public SpiderColors colorscheme;

    public SpiderEyes(int positionX, int positionY, int width, int height, int character) {
        setEyePositionX(positionX);
        setEyePositionY(positionY);
        setEyeWidth(width);
        setEyeHeight(height);
        colorscheme = new SpiderColors(character);
        setLeftFocalPointX();
        setLeftFocalPointY();
        setRightFocalPointX();
        setRightFocalPointY();

    }

    private int eyePositionX;

    public void setEyePositionX(int centerPositionX) {
        eyePositionX = centerPositionX;
    }

    public int getEyePositionX() {
        return eyePositionX;
    }

    private int eyePositionY;

    public void setEyePositionY(int centerPositionY) {
        eyePositionY = centerPositionY;
    }

    public int getEyePositionY() {
        return eyePositionY;
    }

    private int eyeWidth;

    public void setEyeWidth(int headWidth) {
        eyeWidth = headWidth * 4 / 11;
    }

    public int getEyeWidth() {
        return eyeWidth;
    }

    private int eyeHeight;

    public void setEyeHeight(int headHeight) {
        eyeHeight = headHeight / 3;
    }

    public int getEyeHeight() {
        return eyeHeight;
    }

    private int leftFocalPointX;

    public void setLeftFocalPointX() {
        leftFocalPointX = getEyePositionX() - (getEyeWidth() / 2);
    }

    public int getLeftFocalPointX() {
        return leftFocalPointX;
    }

    private int leftFocalPointY;

    public void setLeftFocalPointY() {
        leftFocalPointY = getEyePositionY() - (getEyeHeight() * 2 / 5);
    }

    public int getLeftFocalPointY() {
        return leftFocalPointY;
    }

    private int rightFocalPointX;

    public void setRightFocalPointX() {
        rightFocalPointX = getEyePositionX() + (getEyeWidth() / 2);
    }

    public int getRightFocalPointX() {
        return rightFocalPointX;
    }

    private int rightFocalPointY;

    public void setRightFocalPointY() {
        rightFocalPointY = getEyePositionY() - (getEyeHeight() * 2 / 5);
    }

    public int getRightFocalPointY() {
        return rightFocalPointY;
    }
}

class WideEyes extends SpiderEyes {
    public WideEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillOval(getLeftFocalPointX() - (getEyeWidth() * 75 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 15 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillOval(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 5 / 100),
                getEyeWidth() * 25 / 30, getEyeHeight() * 31 / 30);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillOval(getEyePositionX() + (getEyeWidth() * 25 / 100),
                getRightFocalPointY() - (getEyeHeight() * 15 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillOval(getEyePositionX() + getEyeWidth() * 32 / 100,
                getLeftFocalPointY() - (getEyeHeight() * 5 / 100),
                getEyeWidth() * 25 / 30, getEyeHeight() * 31 / 30);

    }

}

class NormalEyes extends SpiderEyes {
    public NormalEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, -20, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 53 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, -20, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + (getEyeWidth() * 17 / 100), getRightFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, 200, 180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 25 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, 200, 180);
    }
}

class SquintEyes extends SpiderEyes {
    public SquintEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 40 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 45 / 100),
                getEyeWidth() * 70 / 100, getEyeHeight() * 60 / 100, -20, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 20 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 65 / 100),
                getEyeWidth() * 35 / 100, getEyeHeight() * 35 / 100, -15, -180);

        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + (getEyeWidth() * 22 / 100), getRightFocalPointY() + (getEyeHeight() * 45 / 100),
                getEyeWidth() * 70 / 100, getEyeHeight() * 60 / 100, 200, 180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 38 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 65 / 100),
                getEyeWidth() * 35 / 100, getEyeHeight() * 35 / 100, 195, 180);
    }
}

class ConfusedEyes extends SpiderEyes {
    public ConfusedEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, -20, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 53 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, -20, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillOval(getEyePositionX() + (getEyeWidth() * 25 / 100),
                getRightFocalPointY() - (getEyeHeight() * 15 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillOval(getEyePositionX() + getEyeWidth() * 32 / 100,
                getLeftFocalPointY() - (getEyeHeight() * 5 / 100),
                getEyeWidth() * 25 / 30, getEyeHeight() * 31 / 30);
    }

}

class ClosedEyes extends SpiderEyes {
    public ClosedEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 60 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 45 / 100),
                getEyeWidth() * 70 / 100, getEyeHeight() * 60 / 100, 5, -180);
        g2d.setColor(colorscheme.getMaskColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 55 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 484 / 1000),
                getEyeWidth() * 60 / 100, getEyeHeight() * 514 / 1000, 5, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 41 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 45 / 100),
                getEyeWidth() * 70 / 100, getEyeHeight() * 60 / 100, 175, 180);
        g2d.setColor(colorscheme.getMaskColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 458 / 1000,
                getLeftFocalPointY() + (getEyeHeight() * 484 / 1000),
                getEyeWidth() * 60 / 100, getEyeHeight() * 514 / 1000, 175, 180);
    }

}

class WinkEyes extends SpiderEyes {
    public WinkEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, -20, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 53 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, -20, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 41 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 45 / 100),
                getEyeWidth() * 70 / 100, getEyeHeight() * 60 / 100, 175, 180);
        g2d.setColor(colorscheme.getMaskColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 458 / 1000,
                getLeftFocalPointY() + (getEyeHeight() * 484 / 1000),
                getEyeWidth() * 60 / 100, getEyeHeight() * 514 / 1000, 175, 180);

    }

}

class SadEyes extends SpiderEyes {
    public SadEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, 5, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 53 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, 5, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + (getEyeWidth() * 17 / 100), getRightFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, 175, 180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 25 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, 175, 180);
    }
}

class WiderEyes extends SpiderEyes {
    public WiderEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 55 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 15 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, -45, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 45 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 6 / 100),
                getEyeWidth() * 24 / 30, getEyeHeight() * 29 / 30, -45, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + (getEyeWidth() * 5 / 100), getRightFocalPointY() - (getEyeHeight() * 15 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, 225, 180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 17 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 6 / 100),
                getEyeWidth() * 24 / 30, getEyeHeight() * 29 / 30, 225, 180);

    }
}

class EvenEyes extends SpiderEyes {
    public EvenEyes(int positionX, int positionY, int width, int height, int character) {
        super(positionX, positionY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        // Left Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 65 / 100),
                getLeftFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, -3, -180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getLeftFocalPointX() - (getEyeWidth() * 53 / 100),
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, -3, -180);
        // Right Eye
        g2d.setColor(colorscheme.getEyeOutlineColor());
        g2d.fillArc(getEyePositionX() + (getEyeWidth() * 17 / 100), getRightFocalPointY() - (getEyeHeight() * 10 / 100),
                getEyeWidth(), getEyeHeight() * 6 / 5, 183, 180);
        g2d.setColor(colorscheme.getEyeCenterColor());
        g2d.fillArc(getEyePositionX() + getEyeWidth() * 25 / 100,
                getLeftFocalPointY() + (getEyeHeight() * 17 / 100),
                getEyeWidth() * 9 / 11, getEyeHeight() * 48 / 55, 183, 180);
    }
}
