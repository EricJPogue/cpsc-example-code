import java.awt.Rectangle;

public class OvalModel {
    public int x,y,width,height;

    public void loadData() {
        // We would normally be loading the data from a database or file.
        x = 50;
        y = 75;
        width = 100;
        height = 200;
    }

    public Rectangle getData() {
        return new Rectangle(x, y,width, height);
    }
}