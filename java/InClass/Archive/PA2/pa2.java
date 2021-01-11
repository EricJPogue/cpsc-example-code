import javax.swing.JFrame;
import java.awt.Container;

class PA2Frame extends JFrame {
    public PA2Frame() {
        setBounds(100,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        OvalDrawPanel myPanel = new OvalDrawPanel();
        contentPane.add(myPanel);
    }
}    

public class pa2 {
    public static void main(String[] args) {
        PA2Frame myFrame = new PA2Frame();
        myFrame.setVisible(true);
    }
}