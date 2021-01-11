import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;

class GridFrame extends JFrame {
    public GridFrame() {
        setBounds(100,100,900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,4));

        for (int i=0; i<12; i++) {
            contentPane.add(new OvalDrawPanel());
        }
    }
}    

public class GridPanel {
    public static void main(String[] args) {
        GridFrame myFrame = new GridFrame();
        myFrame.setVisible(true);
    }
}