import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldGUI {
	public static void main (String[] args) {
		JFrame frame = new JFrame("Hello JFrame");
		JLabel label = new JLabel("Hello JLabel Centered", JLabel.CENTER);

		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
