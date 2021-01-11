import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

class OvalDraw extends Oval {
    private int R,G,B;
    public void setColor(int rIn, int gIn, int bIn) {
        R = rIn;
        G = gIn;
        B = bIn;
    }

    OvalDraw() {
        super();
        setColor(0,0,0);
    }

    OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
        setColor(0,0,0);
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

    protected static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min);
    }

    public void paintComponent(Graphics g) {
        Color myColor = new Color(R,G,B);
        g.setColor(myColor); 

        g.drawOval(getPositionX(),getPositionY(),getWidth(),getHeight());
        System.out.format("OvalDraw::pC(x=%d,y=%d,w=%d,h=%d\n", 
            getPositionX(), getPositionY(), getWidth(), getHeight());
    }        
}

class FaceDraw extends OvalDraw {
    private OvalDraw leftEye;
    private OvalDraw rightEye;
    private int mouth; 
    private final int SMILE=1, FROWN=2, NEUTRAL=3;

    FaceDraw() {
        assert false:"Unexpected call to default constructor.";
    }

    FaceDraw(int panelWidthIn, int panelHeightIn) {
        super(panelWidthIn, panelHeightIn);
        leftEye = new OvalDraw();
        rightEye = new OvalDraw();
        setEyes();
        setMouth();
    }

    public void setEyes() {
        MakeEyeSizeAndHeight(leftEye);
        leftEye.setPositionX(getPositionX() + (int)((getWidth()*0.5) - (leftEye.getWidth()/2) + (leftEye.getWidth()*1.1))); 

        MakeEyeSizeAndHeight(rightEye);
        rightEye.setPositionX(getPositionX() + (int)((getWidth()*0.5) - (rightEye.getWidth()/2) - (rightEye.getWidth()*1.1))); 
    }

    private void MakeEyeSizeAndHeight(OvalDraw eye) {
        eye.setPositionY(getPositionY() + (getHeight()/4));
        eye.setWidth(getWidth()/4);
        eye.setHeight(getHeight()/5);         
    }

    private void setMouth() {
        mouth = SMILE; // Shouldn't we always default to a SMILE.
        int random = GetNumberBetween(1,4);
        if (random == FROWN) {
            mouth = FROWN;
        } else if (random == NEUTRAL) {
            mouth = NEUTRAL;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftEye.paintComponent(g);
        rightEye.paintComponent(g);
        paintMouth(g);
    }

    private void paintMouth(Graphics g) {
        if (mouth==SMILE) {
            g.drawArc(getPositionX()+(int)(getWidth()*0.2), getPositionY()+(int)(getHeight()*0.4), getWidth()-(int)(getWidth()*0.4), 
                (int)(getHeight()*0.5), 180, 180);
        }
        else if (mouth == FROWN) {
            g.drawArc(getPositionX()+(int)(getWidth()*0.2), getPositionY()+(int)(getHeight()*0.6), getWidth()-(int)(getWidth()*0.4), 
                (int)(getHeight()/2), 0, 180);
        }
        else if (mouth == NEUTRAL) {
            g.drawArc(getPositionX()+(int)(getWidth()*0.2), getPositionY()+(int)(getHeight()*0.7), getWidth()-(int)(getWidth()*0.4), 
                (int)(getHeight()*0.0), 180, 180);
        }
    }
}

class ShapeDrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    public void setOvalDrawList(ArrayList<OvalDraw> OvalDrawListIn) { OvalDrawList = OvalDrawListIn; }
    private ArrayList<OvalDraw> OvalDrawList;

    private boolean mouseDragging;
    private int startMouseDragX;
    private int startMouseDragY;
    
    ShapeDrawPanel() {
        assert false:"Unexpected call to ShapeDrawPanel default constructor.";
    }

    ShapeDrawPanel(ArrayList<OvalDraw> OvalDrawListIn) {
        setOvalDrawList(OvalDrawListIn);
        addMouseListener(this);
        addMouseMotionListener(this);

        mouseDragging = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for (OvalDraw oD : OvalDrawList) {
            oD.paintComponent(g); 
        }
    }

    public void addRandomOval() {
        addRandomOval(0,0,0);
    }

    public void addRandomOval(int rIn, int gIn, int bIn) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();   
        OvalDraw myOvalDraw = new OvalDraw(panelWidth, panelHeight);
        myOvalDraw.setColor(rIn, gIn, bIn);
        OvalDrawList.add(myOvalDraw);
        repaint(); 
    }

    public void clearOvals() {
        OvalDrawList.clear();
    }

    public void mouseClicked(MouseEvent e) {
        FaceDraw newFaceDraw = new FaceDraw(getWidth(), getHeight());
        newFaceDraw.setPositionX(e.getX() - (int)(newFaceDraw.getWidth()*0.5));
        newFaceDraw.setPositionY(e.getY() - (int)(newFaceDraw.getHeight()*0.5));
        newFaceDraw.setEyes();     

        OvalDrawList.add(newFaceDraw);
        repaint();
    }          

    public void mouseReleased(MouseEvent e) {
        if (mouseDragging) {
            addRedCircleAfterDragging(startMouseDragX, startMouseDragY, e.getX(), e.getY());
            mouseDragging = false;
        }
    }    
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged(MouseEvent e)");
        if (!mouseDragging) {
            startMouseDragX = e.getX();
            startMouseDragY = e.getY();
            mouseDragging = true;
        }
    }
    public void mouseMoved(MouseEvent e) {}

    private void addRedCircleAfterDragging(int startDragX, int startDragY, int endDragX, int endDragY) {
        int distance = (int)Math.sqrt((startDragX-endDragX)*(startDragX-endDragX) + (startDragY-endDragY)*(startDragY-endDragY));
        int circleWidth = distance*2;
        int circleHeight = circleWidth;

        int circlePositionX = startDragX - (int)(circleWidth*0.5);
        int circlePositionY = startDragY - (int)(circleHeight*0.5);        
        
        OvalDraw newRedCircle = new OvalDraw(circlePositionX,circlePositionY,circleWidth,circleHeight);
        newRedCircle.setColor(255,0,0);
        OvalDrawList.add(newRedCircle);
        repaint();
    }
}

class ShapeDrawFrame extends JFrame implements ActionListener, KeyListener {
    private ShapeDrawPanel myShapeDrawPanel;
    private JTextField colorRTextField;
    private JTextField colorGTextField;
    private JTextField colorBTextField;
   
    public ShapeDrawFrame() {
         assert false:"Unexpected call to ShapeDrawFrame default constructor.";       
    }

    public ShapeDrawFrame(ArrayList<OvalDraw> OvalDrawListIn) {
        setBounds(100,100,600*2,400*2);
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

        // Create menu bar and menus. 
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);
        
        JMenuItem clearMenuItem = new JMenuItem("Clear", KeyEvent.VK_C);
        clearMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myShapeDrawPanel.clearOvals();
                repaint();
            }
        });        
        editMenu.add(clearMenuItem);
        add(menuBar, BorderLayout.NORTH);

        // Add lebel and text fields.
        JLabel colorRLabel = new JLabel("Color R:");
        myButtonPanel.add(colorRLabel);

        colorRTextField = new JTextField(3);
        colorRTextField.addKeyListener(this);
        myButtonPanel.add(colorRTextField);

        JLabel colorGLabel = new JLabel("G:");
        myButtonPanel.add(colorGLabel);

        colorGTextField = new JTextField(3);
        colorGTextField.addKeyListener(this);
        myButtonPanel.add(colorGTextField);

        JLabel colorBLabel = new JLabel("B:");
        myButtonPanel.add(colorBLabel);

        colorBTextField = new JTextField(3);
        colorBTextField.addKeyListener(this);
        myButtonPanel.add(colorBTextField);
    }

    public void actionPerformed(ActionEvent e) {
        addRandomOvalToDrawPanel();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            addRandomOvalToDrawPanel();
        }
    }

    private void addRandomOvalToDrawPanel() {
        String R = colorRTextField.getText();
        String G = colorGTextField.getText();
        String B = colorBTextField.getText();
        myShapeDrawPanel.addRandomOval(TextToRGB(R),TextToRGB(G),TextToRGB(B));
    }

    private static int TextToRGB(String valueRGB) {
        int returnValue = 0;
        try {
            returnValue = Integer.parseInt(valueRGB);
            if (returnValue < 0) {
                returnValue = 0;
            } else if (returnValue > 255) {
                returnValue = 255;
            }
        }
        catch(Exception e) {
            returnValue = 0;
        }
        return returnValue;
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}

public class ShapeDraw {
    public static void main(String[] args) {
        System.out.println("ShapeDraw Starting!");

        ArrayList<OvalDraw> myOvalDrawList = new ArrayList<OvalDraw>();
        ShapeDrawFrame myShapeDrawFrame = new ShapeDrawFrame(myOvalDrawList);
        myShapeDrawFrame.setVisible(true);
    }
}