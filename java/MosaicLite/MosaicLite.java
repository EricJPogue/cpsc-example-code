// Imports: In order of appearance. 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

class XAndOTile extends JPanel {
    private int red, green, blue;
    private String letter;

    XAndOTile() {
        super();
        SetRandomValues();
    }

    final public void SetRandomValues() {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        letter = "X";
        if (GetNumberBetween(0,1) == 1) {
            letter = "O";
        }        
    }

    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(new Color(red,green,blue));
        g.fillRect (10, 10, panelWidth-20, panelHeight-20);

        g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));

        final int fontSize=100;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2)-30;
        int stringY = (panelHeight/2)+30;
        g.drawString(letter,stringX,stringY);
    }

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn+128)%256);
    }
}

class MosaicLiteFrame extends JFrame implements ActionListener {
    private ArrayList<XAndOTile> tileList;

    public MosaicLiteFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton randomize = new JButton("Randomize");
        buttonPanel.add(randomize);
        randomize.addActionListener(this);

        JPanel xAndOGridPanel = new JPanel();
        contentPane.add(xAndOGridPanel, BorderLayout.CENTER);
        xAndOGridPanel.setLayout(new GridLayout(3,3));

        tileList = new ArrayList<XAndOTile>();
        for(int i=1; i<10; i++) {
            XAndOTile tile = new XAndOTile();
            tileList.add(tile);
            xAndOGridPanel.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(XAndOTile tile : tileList) {
            tile.SetRandomValues();
        }
        repaint();
    }
}

public class MosaicLite {
    public static void main(String[] args) {
        System.out.println("MosaicLite Starting...");

        MosaicLiteFrame myMosaicLiteFrame = new MosaicLiteFrame();
        myMosaicLiteFrame.setVisible(true);
    }
}