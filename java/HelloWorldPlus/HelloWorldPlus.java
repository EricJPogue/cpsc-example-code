import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

class HelloFrame extends JFrame {
    public HelloFrame() {
        super("Hello World");
        setBounds(100,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     

        JLabel label = new JLabel("Hello World!!! - EJP", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 32));
        label.setForeground(Color.red);
        getContentPane().add(label);
    }
}

public class HelloWorldPlus {
    public static void main(String[] args) {
        HelloFrame myHelloFrame = new HelloFrame();
        myHelloFrame.setVisible(true);
    }
}