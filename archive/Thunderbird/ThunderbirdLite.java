/******************************************************************************
 * Copyright (C) 2019 Eric Pogue.
 * 
 * This file and the ThunderbirdLite application is licensed under the 
 * BSD-3-Clause.
 * 
 * You may use any part of the file as long as you give credit in your 
 * source code.
 * 
 * This application utilizes the HttpRequest.java library developed by 
 * Eric Pogue
 * 
 * Version: 1.3
 *****************************************************************************/
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

class ContactTile extends JPanel {
    private int red, green, blue;
    private ThunderbirdContact contactInSeat = null;

    private Boolean isAnAisle = false;
    public void setAisle() { isAnAisle = true; }

    ContactTile() {
        super();

        // Todo: Remove everything to do with random colors.
        // Todo: Implement visually appealing colors for aisles and seats.
        SetRandomValues();
    }

    ContactTile(ThunderbirdContact contactInSeatIn) {
        super();
        SetRandomValues();
        contactInSeat = contactInSeatIn;
    }

    final public void SetRandomValues() {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);
    }

    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (isAnAisle) {
            g.setColor(new Color(0,0,0));
        } else {
            g.setColor(new Color(red,green,blue));
        }
        
        g.fillRect (10, 10, panelWidth-20, panelHeight-20);

        g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));

        final int fontSize=18;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2)-60;
        int stringY = (panelHeight/2)+30;
        if (contactInSeat != null) {

            // ToDo: Display preferred name instead of first and last name. 
            String firstAndLastName = contactInSeat.getFirstName()+" "+contactInSeat.getLastName();
            g.drawString(firstAndLastName,stringX,stringY);
        }
    }

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn+128)%256);
    }
}

class ThunderbirdLiteFrame extends JFrame implements ActionListener {
    private ArrayList<ContactTile> tileList;

    public ThunderbirdLiteFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton reverseView = new JButton("Reverse View");
        buttonPanel.add(reverseView);
        reverseView.addActionListener(this);

        JPanel contactGridPanel = new JPanel();
        contentPane.add(contactGridPanel, BorderLayout.CENTER);

        contactGridPanel.setLayout(new GridLayout(11,9));

        ThunderbirdModel tbM = new ThunderbirdModel();
        tbM.LoadIndex();
        tbM.LoadContacts();

        // Todo: Review ThunderbirdModel in detail and implement a multithreaded version of loading contacts. 
        // Hint: Review LoadContact() and LoadContactsThreaded() in detail.

        System.out.println("Printing Model:");
        System.out.println(tbM);
        tbM.ValidateContacts();   


        tileList = new ArrayList<ContactTile>();
        
        for(int i=0; i<99; i++) {
            ThunderbirdContact contactInSeat = tbM.findContactInSeat(i);
            if (contactInSeat != null) {
                System.out.println(contactInSeat);
            }

            ContactTile tile = new ContactTile(contactInSeat);

            // Todo: Place all the aisle seats in a array or an ArrayList instead of hard coding them. 
            if ((i==4)||(i==12)||(i==31)) {
                tile.setAisle();
            }

            tileList.add(tile);
            contactGridPanel.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(ContactTile tile : tileList) {
            // Todo: Remove randomization functionality and implement a visually appealing view of seats and aisles.
            tile.SetRandomValues();

            // Todo: Implement reverse view where it looks like you are looking at the room from the back instead of the front 
            //     of the room. 
        }

        repaint();
    }
}

// Todo: Rename the following class to Thunderbird.
// Hint: This will also require you to rename the Java file.
public class ThunderbirdLite {
    public static void main(String[] args) {

        // Todo: Update the following line so that it reflects the name change to Thunderbird.
        System.out.println("ThunderbirdPrime Starting...");

        ThunderbirdLiteFrame myThunderbirdLiteFrame = new ThunderbirdLiteFrame();
        myThunderbirdLiteFrame.setVisible(true);
    }
}