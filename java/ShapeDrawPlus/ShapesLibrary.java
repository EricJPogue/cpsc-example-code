//
// ShapesLibrary
abstract class Shape {
    // The positionX and positionY values are intended to be the left most and 
    // bottom most drawing locations.
    public final void setPositionX(int positionXIn) { positionX = positionXIn; }
    public final int getPositionX() { return positionX; }
    private int positionX;

    public final int getPositionY() { return positionY;}
    public final void setPositionY(int positionYIn) { positionY = positionYIn; }
    private int positionY;

    public final void setWidth(int widthIn) { width = OneOrGreater(widthIn); };
    public final int getWidth() { return width; }
    private int width;

    public final void setHeight(int heightIn) { height = OneOrGreater(heightIn); }
    public final int getHeight() { return height; }
    private int height;

    public Shape() {
        this(0,0,0,0);
    }

    public Shape(int positionXIn, int positionYIn) {
        this(positionXIn,positionYIn,0,0);
    }

    public Shape(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        setPositionX(positionXIn);
        setPositionY(positionYIn);
        setWidth(widthIn);
        setHeight(heightIn); 
    }

    protected static int OneOrGreater(int valueIn) {
        assert valueIn>=1:"Shape parameter is unexeptedly less than 1.";
        int returnValue = valueIn;
        if (valueIn < 1) {
            returnValue = 1;
        }
        return returnValue;
    }

    public String toString() {
        return String.format("positionX=%d, positionY=%d", positionX, positionY);
    }

    abstract public double CalcArea();
    abstract public double CalcPerimeter();
}

class Rectangle extends Shape {
    public Rectangle() {
        this(0,0);
    }

    public Rectangle(int widthIn, int heightIn) {
        setWidth(widthIn);
        setHeight(heightIn);
    }

    public Rectangle(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
    }

    public String toString() {
        String superClassString = super.toString();
        return String.format("%s width=%d, height=%d", superClassString, getWidth(), getHeight());
    }

    public double CalcArea() {
        return getWidth() * getHeight();
    }

    public double CalcPerimeter() {
        return getWidth() + getWidth() + getHeight() + getHeight();
    }
}

class Circle extends Shape {
    public final void setRadius(int radiusIn) { 
        setWidth(radiusIn*2);
        setHeight(radiusIn*2);
    }
    public final int getRadius() { return (getWidth() / 2); }

    Circle() {
      this(0);
    }

    Circle(int radiusIn ) {
        setRadius(radiusIn);
    }

    Circle(int positionXIn, int positionYIn, int radiusIn) {
       super(positionXIn, positionYIn);
       setRadius(radiusIn);
    }

    public String toString() {
        String superClassString = super.toString();
        return String.format("%s radius=%d", superClassString, getRadius());
    }

    public double CalcArea() {
        return Math.PI * getRadius() * getRadius();
    }

    public double CalcPerimeter() {
        return 2 * Math.PI * getRadius();
    }
}

class Oval extends Circle {
    Oval() {
        super(0);
    }

    Oval(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        setPositionX(positionXIn);
        setPositionY(positionYIn);
        setWidth(widthIn);
        setHeight(heightIn);
    }
}
