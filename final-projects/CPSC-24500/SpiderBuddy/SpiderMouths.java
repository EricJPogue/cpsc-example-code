import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

abstract class SpiderMouths {

    public SpiderColors colorscheme;

    public SpiderMouths(int mouthX, int mouthY, int width, int height, int character) {
        setMouthsPositionX(mouthX);
        setMouthsPositionY(mouthY);
        setMouthsWidth(width);
        setMouthsHeight(height);
        colorscheme = new SpiderColors(character);
    }

    private int mouthsPositionX;

    public void setMouthsPositionX(int mouthX) {
        mouthsPositionX = mouthX;
    }

    public int getMouthsPositionX() {
        return mouthsPositionX;
    }

    private int mouthsPositionY;

    public void setMouthsPositionY(int mouthY) {
        mouthsPositionY = mouthY;
    }

    public int getMouthsPositionY() {
        return mouthsPositionY;
    }

    private int mouthsWidth;

    public void setMouthsWidth(int width) {
        mouthsWidth = width;
    }

    public int getMouthsWidth() {
        return mouthsWidth;
    }

    private int mouthsHeight;

    public void setMouthsHeight(int height) {
        mouthsHeight = height;
    }

    public int getMouthsHeight() {
        return mouthsHeight;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.setColor(colorscheme.getFaceColor());
        g2d.fillOval(getMouthsPositionX(), getMouthsPositionY(), getMouthsWidth(), getMouthsHeight());
        g2d.setColor(colorscheme.getWebbingOutlineColor());
        g2d.drawOval(getMouthsPositionX(), getMouthsPositionY(), getMouthsWidth(), getMouthsHeight());
    }
}

class Smiles extends SpiderMouths {

    public Smiles(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() - getMouthsHeight() * 2 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, -20, -135);
        g2d.setColor(colorscheme.getFaceColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() - getMouthsHeight() * 3 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, -20, -135);

    }
}

class Frowns extends SpiderMouths {
    public Frowns(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() + getMouthsHeight() * 4 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, 20, 135);
        g2d.setColor(colorscheme.getFaceColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() + getMouthsHeight() * 5 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, 20, 135);

    }
}

class NeutralMouth extends SpiderMouths {
    public NeutralMouth(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillRect(getMouthsPositionX() + (getMouthsWidth() / 4), getMouthsPositionY() + (getMouthsHeight() / 3),
                getMouthsWidth() / 2, getMouthsHeight() * 5 / 100);

    }
}

class NeutralMouthSmall extends SpiderMouths {
    public NeutralMouthSmall(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillRect(getMouthsPositionX() + (getMouthsWidth() * 3 / 8), getMouthsPositionY() + (getMouthsHeight() / 3),
                getMouthsWidth() / 4, getMouthsHeight() * 5 / 100);

    }
}

class SideSmile extends SpiderMouths {
    public SideSmile(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() - getMouthsHeight() * 2 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, -90, 70);
        g2d.setColor(colorscheme.getFaceColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() - getMouthsHeight() * 3 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, -90, 70);

    }
}

class SideFrown extends SpiderMouths {
    public SideFrown(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() + getMouthsHeight() * 4 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, 90, 70);
        g2d.setColor(colorscheme.getFaceColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() + getMouthsHeight() * 5 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8, 90, 70);

    }
}

class Laugh extends SpiderMouths {
    public Laugh(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillArc(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() - getMouthsHeight() * 7 / 32,
                getMouthsWidth() * 4 / 8, getMouthsHeight(), 0, -180);
        g2d.setColor(colorscheme.getTeethColor());
        g2d.fillRect(getMouthsPositionX() + (getMouthsWidth() * 5 / 16), getMouthsPositionY() + (getMouthsHeight() / 3),
                getMouthsWidth() * 3 / 8, getMouthsHeight() * 5 / 100);
    }
}

class OpenMouth extends SpiderMouths {
    public OpenMouth(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillOval(getMouthsPositionX() + getMouthsWidth() * 2 / 8, getMouthsPositionY() + getMouthsHeight() * 3 / 16,
                getMouthsWidth() * 4 / 8, getMouthsHeight() * 5 / 8);
    }
}

class OpenMouthSmall extends SpiderMouths {
    public OpenMouthSmall(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillOval(getMouthsPositionX() + getMouthsWidth() * 6 / 16,
                getMouthsPositionY() + getMouthsHeight() * 3 / 16,
                getMouthsWidth() * 2 / 8, getMouthsHeight() * 3 / 8);
    }
}

class SideOpenMouthSmall extends SpiderMouths {
    public SideOpenMouthSmall(int mouthX, int mouthY, int width, int height, int character) {
        super(mouthX, mouthY, width, height, character);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        super.paintComponent(g);
        g2d.setColor(colorscheme.getMouthColor());
        g2d.fillOval(getMouthsPositionX() + getMouthsWidth() * 3 / 16,
                getMouthsPositionY() + getMouthsHeight() * 3 / 16,
                getMouthsWidth() * 2 / 8, getMouthsHeight() * 3 / 8);
    }
}
