/*******************************************************************************
 * Copyright (C) 2018 Eric Pogue. All rights reserved. 
 * 
 * This file is part of the ShapeDraw project.
 * 
 * This file can not be copied and/or distributed without 
 * the express permission of Eric Pogue
 * 
 * This application uses the open source component ShapesLibrary.java
 ******************************************************************************/

import java.awt.BorderLayout;
import java.awt.Container; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

class OvalDraw extends Oval {
    OvalDraw() {
        super();
    }

    OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
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
        int y = GetNumberBetween(yMin, yMax);

        setPositionX(x);
        setPositionY(y);
        setWidth(width);
        setHeight(height);
    }

    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min);
    }

    public void paintComponent(Graphics g) {
        g.drawOval(getPositionX(),getPositionY(),getWidth(),getHeight());
        System.out.println("Attributes: "+this);
        System.out.format("Area=%.2f\n", CalcArea());
        System.out.format("Perimiter=%.2f\n", CalcPerimeter());
    }        
}

class ShapeDrawPanel extends JPanel {
    public void setOvalDrawList(ArrayList<OvalDraw> OvalDrawListIn) { OvalDrawList = OvalDrawListIn; }
    private ArrayList<OvalDraw> OvalDrawList;
    
    ShapeDrawPanel() {
        super();
        assert false:"Unexpected call to ShapeDrawPanel default constructor.";
        OvalDrawList = null;
    }

    ShapeDrawPanel(ArrayList<OvalDraw> OvalDrawListIn) {
        setOvalDrawList(OvalDrawListIn);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for (OvalDraw oD : OvalDrawList) {
            oD.paintComponent(g); 
        }
    }

    public void addRandomOval() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        OvalDrawList.add(new OvalDraw(panelWidth, panelHeight));
        repaint();
    }
}

class ShapeDrawFrame extends JFrame implements ActionListener {
    private ShapeDrawPanel myShapeDrawPanel;

    public ShapeDrawFrame() {
         assert false:"Unexpected call to ShapeDrawFrame default constructor.";       
    }

    public ShapeDrawFrame(ArrayList<OvalDraw> OvalDrawListIn) {
        setBounds(100,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new FlowLayout());

        JButton newOvalButton = new JButton("Add Random Oval");
        newOvalButton.addActionListener(this);
        myButtonPanel.add(newOvalButton);

        contentPane.add(myButtonPanel, BorderLayout.SOUTH);

        myShapeDrawPanel = new ShapeDrawPanel(OvalDrawListIn);
        contentPane.add(myShapeDrawPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        myShapeDrawPanel.addRandomOval();
    }
}

public class ShapeDraw {
    public static void main(String[] args) {
        System.out.println("ShapeDraw Starting!");

        ArrayList<OvalDraw> myOvalDrawList = new ArrayList<OvalDraw>();
        ShapeDrawFrame myShapeDrawFrame = new ShapeDrawFrame(myOvalDrawList);
        myShapeDrawFrame.setVisible(true);
    }
}