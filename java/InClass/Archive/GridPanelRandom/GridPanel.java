import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.util.ArrayList;

class GridFrame extends JFrame implements ActionListener {
    private ArrayList<OvalDrawPanel> panelList;

    public GridFrame() {
        setBounds(100,100,900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,4));

        panelList = new ArrayList<OvalDrawPanel>();
        for (int i=0; i<11; i++) {
            OvalDrawPanel panel = new OvalDrawPanel(); 
            contentPane.add(panel);
            panelList.add(panel);
        }

        JButton randomize = new JButton("Randomize Colors");
        randomize.addActionListener(this);
        contentPane.add(randomize);
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println("actionPerformed...");
        for(OvalDrawPanel panel : panelList) {
            panel.setRandomColors();
        }
        repaint();
    }
}    

public class GridPanel {
    public static void main(String[] args) {
        GridFrame myFrame = new GridFrame();
        myFrame.setVisible(true);
    }
}