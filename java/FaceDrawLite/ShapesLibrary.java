/******************************************************************************
 * Copyright (C) 2018 Eric Pogue.
 * 
 * This file is a stand-alone library liscensed under the BSD-3-Clause
 * 
 * You are free to reuse the unmodified version of this file in your projects
 * as long as you give credit to the library in your source code.  
 * 
 *****************************************************************************/

abstract class Shape {
    // The positionX and positionY values are intended to be the left most and 
    // bottom most locations.
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
        return String.format("positionX=%d, positionY=%d, width=%d, height=%d", positionX, positionY, getWidth(), getHeight());
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

    public double CalcArea() {
        return getWidth() * getHeight();
    }

    public double CalcPerimeter() {
        return getWidth() + getWidth() + getHeight() + getHeight();
    }
}


class Oval extends Shape {
    Oval () {
        super();
    }

    Oval(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
    }

    public double CalcArea() {
        return Math.PI * (getWidth()/2) * (getHeight()/2);
    }

    public double CalcPerimeter() {
        // The formula for calculating the perimeter of an oval can be found  at:
        //     https://www.mathsisfun.com/geometry/ellipse-perimeter.html
        double a = getWidth() / 2.0;
        double b = getHeight() / 2.0;
        double perimeter =2*Math.PI*Math.sqrt((Math.pow(a,2)+Math.pow(b,2))/2);
        return perimeter;
    }
}

class Circle extends Oval {
    Circle() {
        super();
    }

    Circle(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);

        // A circle's width and height should be the same.
        assert widthIn!=heightIn:"Width and Height must be equal in a circle.";
    }    

    public double CalcPerimeter() {
        // Width and height must be equal in a circle.
        double r = getWidth()/2;
        double p = 2*Math.PI*r;
        return p;
    }
}
