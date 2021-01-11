import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

class OvalDraw {
    private Rectangle r = null;
    private Color c = Color.BLUE;

    OvalDraw(Rectangle rIn) {
        r = new Rectangle(rIn); 
    }

    OvalDraw(int panelWidthIn, int panelHeightIn) {
        // Create random and appropriate dimensions given the inputs of panel width and height.
        final int widthMin = 10;
        int width = GetNumberBetween(widthMin, panelWidthIn);

        final int heightMin = 10;
        int height = GetNumberBetween(heightMin, panelHeightIn);

        final int xMin = 0;
        int xMax = panelWidthIn - width;
        int x = GetNumberBetween(xMin, xMax);

        final int yMin = 0;
        int yMax = panelHeightIn - height;
        int y = GetNumberBetween(yMin,yMax);

        // Why would the following line be WRONG!
        //     Rectangle r = new Rectangle(x, y, width, height);
        r = new Rectangle(x, y, width, height);

        SetRandomColor();
    }

    final public void SetRandomColor() {
        int colorIndex = GetNumberBetween(1,5);
        c = Color.BLUE;
        if (colorIndex == 2) {
            c = Color.BLACK;
        }
        else if (colorIndex == 3) {
            c = Color.RED;
        }
        else if (colorIndex == 4) {
            c = Color.GREEN;
        }
    }

    final private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max - min);
    }
    
    public void Draw(Graphics g) {
        g.setColor(c);  
        g.drawOval((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
    }
}