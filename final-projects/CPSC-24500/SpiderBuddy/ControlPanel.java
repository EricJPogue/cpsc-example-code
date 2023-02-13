import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ControlPanel extends JPanel {
    public TextPanel textPanel;
    public int count = 0;

    public ControlPanel(TextPanel textPanelIn) {
        super();
        textPanel = textPanelIn;
        setLayout(new GridLayout(2, 2));
        add(new ExpressionList(textPanelIn));
        add(new CharacterList(textPanelIn));
        add(new ActionList(textPanelIn));
        add(new TitleList(textPanelIn));

    }

}

class ExpressionList extends JPanel implements MouseListener {
    public TextPanel textPanel;
    public int count = 0;

    public ExpressionList(TextPanel textPanelIn) {
        super();
        textPanel = textPanelIn;
        addMouseListener(this);
        setBackground(Color.RED);
    }

    public void mouseClicked(MouseEvent e) {
        textPanel.expressionSwitch();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        g.drawString("Expressions", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Expressions") / 2),
                getHeight() / 2 - 10);

    }
}

class CharacterList extends JPanel implements MouseListener {
    public TextPanel textPanel;
    public int count = 0;

    public CharacterList(TextPanel textPanelIn) {
        super();
        textPanel = textPanelIn;
        addMouseListener(this);
        setBackground(Color.BLACK);
    }

    public void mouseClicked(MouseEvent e) {
        textPanel.charactersSwitch();

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        g.drawString("Characters", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Characters") / 2),
                getHeight() / 2 - 10);
    }
}

class ActionList extends JPanel implements MouseListener {
    public TextPanel textPanel;
    public int count = 0;

    public ActionList(TextPanel textPanelIn) {
        super();
        textPanel = textPanelIn;
        addMouseListener(this);
        setBackground(Color.BLUE);
    }

    public void mouseClicked(MouseEvent e) {
        textPanel.actionsSwitch();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        g.drawString("Actions", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Actions") / 2),
                getHeight() / 2 - 10);
    }
}

class TitleList extends JPanel implements MouseListener {
    public TextPanel textPanel;
    public int count = 0;

    public TitleList(TextPanel textPanelIn) {
        super();
        textPanel = textPanelIn;
        addMouseListener(this);
        setBackground(Color.WHITE);
    }

    public void mouseClicked(MouseEvent e) {
        textPanel.titleSwitch();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        g.drawString("Title", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Title") / 2),
                getHeight() / 2 - 10);
    }
}
