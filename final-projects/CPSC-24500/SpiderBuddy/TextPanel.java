import java.util.concurrent.Semaphore;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TextPanel extends JPanel {
    private SpiderBuddyPanel spideyPanel;
    private SpiderBuddyTitle title;
    private ExpressionOptions expressions;
    private CharacterOptions characters;
    private ActionOptions actions;
    private Semaphore display;
    private Semaphore descend;
    public int panelType;

    public TextPanel(SpiderBuddyPanel spideyDisplay, Semaphore display, Semaphore descend) {
        super();
        setLayout(new BorderLayout());
        spideyPanel = spideyDisplay;
        this.display = display;
        this.descend = descend;
        title = new SpiderBuddyTitle();
        expressions = new ExpressionOptions(spideyPanel.spidey, display, descend);
        characters = new CharacterOptions(spideyPanel.spidey, display, descend);
        actions = new ActionOptions(spideyPanel.spidey, display, descend);
        panelType = 0;
        add(title, BorderLayout.CENTER);
    }

    public void titleSwitch() {
        removeAll();
        repaint();
        revalidate();
        add(title, BorderLayout.CENTER);
        repaint();
        revalidate();
        setVisible(true);
    }

    public void expressionSwitch() {
        removeAll();
        repaint();
        revalidate();
        add(expressions, BorderLayout.CENTER);
        repaint();
        revalidate();
        setVisible(true);
    }

    public void charactersSwitch() {
        removeAll();
        repaint();
        revalidate();
        add(characters, BorderLayout.CENTER);
        repaint();
        revalidate();
        setVisible(true);

    }

    public void actionsSwitch() {
        removeAll();
        repaint();
        revalidate();
        add(actions, BorderLayout.CENTER);
        repaint();
        revalidate();
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

class SpiderBuddyTitle extends JPanel {
    private SpiderColors colors;

    public SpiderBuddyTitle() {
        super();
        colors = new SpiderColors();
        setBackground(Color.RED);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colors.WHITE);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        g.drawString("SPIDER", (517 / 2) - (g.getFontMetrics().stringWidth("SPIDER") / 2), 407 / 2 - 20);
        g.drawString("BUDDY", (517 / 2) - (g.getFontMetrics().stringWidth("BUDDY") / 2), 407 / 2 + 20);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("BY", (517 / 2) - (g.getFontMetrics().stringWidth("BY") / 2), 407 / 2 + 50);
        g.drawString("JACOB PRINCE", (517 / 2) - (g.getFontMetrics().stringWidth("JACOB PRINCE") / 2),
                407 / 2 + 70);
    }
}

/*
 * 
 * 
 * 
 * Expression Options
 * 
 * 
 * 
 */
class ExpressionOptions extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public ExpressionOptions(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        setLayout(new GridLayout(4, 4));
        setBackground(Color.BLACK);
        add(new CoveredPanel(spidey, display, descend));
        add(new HappyPanel(spidey, display, descend));
        add(new ConfusedPanel(spidey, display, descend));
        add(new SurprisedPanel(spidey, display, descend));
        add(new NeutralPanel(spidey, display, descend));
        add(new SadPanel(spidey, display, descend));
        add(new AngryPanel(spidey, display, descend));
        add(new MadPanel(spidey, display, descend));
        add(new YellingPanel(spidey, display, descend));
        add(new ChattingPanel(spidey, display, descend));
        add(new SleepyPanel(spidey, display, descend));
        add(new LaughingPanel(spidey, display, descend));
        add(new WinkingPanel(spidey, display, descend));
        add(new SnoringPanel(spidey, display, descend));
        add(new NormalPanel(spidey, display, descend));
        add(new SuperLaughingPanel(spidey, display, descend));
        addMouseListener(this);

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Expression Detected");
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
    }
}

/*
 * Covered Face
 */
class CoveredPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public CoveredPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new CoveredFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 0));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Covered Face", (139 / 2) - (g.getFontMetrics().stringWidth("Covered Face") / 2),
                20);
    }
}

/*
 * Happy Face
 */
class HappyPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public HappyPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        head = new HappyFace(0, -50, 175, 175, 1);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 1));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Happy Face", (139 / 2) - (g.getFontMetrics().stringWidth("Happy Face") / 2),
                20);
    }
}

/*
 * Confused Face
 */
class ConfusedPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ConfusedPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        head = new ConfusedFace(0, -50, 175, 175, 1);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 2));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRoundRect(62 - (g.getFontMetrics().stringWidth("Confused Face") / 2),
                8, g.getFontMetrics().stringWidth("Confused Face") + 14, 14, 2, 2);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Confused Face", (139 / 2) - (g.getFontMetrics().stringWidth("Confused Face") / 2),
                20);
    }
}

/*
 * Surprised Face
 */
class SurprisedPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SurprisedPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new SurprisedFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 3));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRoundRect(64 - (g.getFontMetrics().stringWidth("Surprised Face") / 2),
                8, g.getFontMetrics().stringWidth("Surprised Face") + 8, 14, 2, 2);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Surprised Face", (139 / 2) - (g.getFontMetrics().stringWidth("Surprised Face") / 2),
                20);
    }
}

/*
 * Neutral Face
 */
class NeutralPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public NeutralPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new NeutralFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 4));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Neutral Face", (139 / 2) - (g.getFontMetrics().stringWidth("Neutral Face") / 2),
                20);
    }
}

/*
 * Sad Face
 */
class SadPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SadPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new SadFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 5));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Sad Face", (139 / 2) - (g.getFontMetrics().stringWidth("Sad Face") / 2),
                20);
    }
}

/*
 * Angry Face
 */
class AngryPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public AngryPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new AngryFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 6));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Angry Face", (139 / 2) - (g.getFontMetrics().stringWidth("Angry Face") / 2),
                20);
    }
}

/*
 * Mad Face
 */
class MadPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public MadPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new MadFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 7));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Mad Face", (139 / 2) - (g.getFontMetrics().stringWidth("Mad Face") / 2),
                20);
    }
}

/*
 * Yelling Face
 */
class YellingPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public YellingPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new YellingFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 8));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Yelling Face", (139 / 2) - (g.getFontMetrics().stringWidth("Yelling Face") / 2),
                20);
    }
}

/*
 * Chatting Face
 */
class ChattingPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ChattingPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new ChattingFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 9));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Chatting Face", (139 / 2) - (g.getFontMetrics().stringWidth("Chatting Face") / 2),
                20);
    }
}

/*
 * Sleepy Face
 */
class SleepyPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SleepyPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new SleepyFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 10));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Sleepy Face", (139 / 2) - (g.getFontMetrics().stringWidth("Sleepy Face") / 2),
                20);
    }
}

/*
 * Laughing Face
 */
class LaughingPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public LaughingPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new LaughingFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 11));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Laughing Face", (139 / 2) - (g.getFontMetrics().stringWidth("Laughing Face") / 2),
                20);
    }
}

/*
 * Winking Face
 */
class WinkingPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public WinkingPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new WinkingFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 12));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Winking Face", (139 / 2) - (g.getFontMetrics().stringWidth("Winking Face") / 2),
                20);
    }
}

/*
 * Snoring Face
 */
class SnoringPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SnoringPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new SnoringFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 13));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Snoring Face", (139 / 2) - (g.getFontMetrics().stringWidth("Snoring Face") / 2),
                20);
    }
}

/*
 * Normal Face
 */
class NormalPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public NormalPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new NormalFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 14));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Normal Face", (139 / 2) - (g.getFontMetrics().stringWidth("Normal Face") / 2),
                20);
    }
}

/*
 * SuperLaughing Face
 */
class SuperLaughingPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SuperLaughingPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new UltraLaughingFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ExpressionChange(spideyPanel, display, descend, 15));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Hard Laughing Face", (139 / 2) - (g.getFontMetrics().stringWidth("Hard Laughing Face") / 2),
                20);
    }
}

/*
 * 
 * 
 * 
 * Character Options
 * 
 * 
 * 
 */
class CharacterOptions extends JPanel {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public CharacterOptions(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        setLayout(new GridLayout(4, 4));
        setBackground(Color.BLUE);
        add(new PeterPanel(spidey, display, descend));
        add(new MilesPanel(spidey, display, descend));
        add(new GwenPanel(spidey, display, descend));
        add(new BenPanel(spidey, display, descend));
        add(new KainePanel(spidey, display, descend));
        add(new OttoPanel(spidey, display, descend));
        add(new MiguelPanel(spidey, display, descend));
        add(new SymbiotePanel(spidey, display, descend));
        add(new SecretPanel(spidey, display, descend));
        add(new IronPanel(spidey, display, descend));
        add(new StealthPanel(spidey, display, descend));
        add(new ArmorIPanel(spidey, display, descend));
        add(new ArmorIIPanel(spidey, display, descend));
        add(new ArmorIIIPanel(spidey, display, descend));
        add(new ArmorIVPanel(spidey, display, descend));
        add(new FuturePanel(spidey, display, descend));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

/*
 * Peter Parker
 */
class PeterPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public PeterPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 1);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 1));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Peter Parker", (139 / 2) - (g.getFontMetrics().stringWidth("Peter Parker") / 2),
                20);
    }
}

/*
 * Miles Morales
 */
class MilesPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public MilesPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 2);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 2));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Miles Morales", (139 / 2) - (g.getFontMetrics().stringWidth("Miles Morales") / 2),
                20);
    }
}

/*
 * Spider-Gwen
 */
class GwenPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public GwenPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 3);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 3));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Spider-Gwen", (139 / 2) - (g.getFontMetrics().stringWidth("Spider-Gwen") / 2),
                20);
    }
}

/*
 * Ben Reilly
 */
class BenPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public BenPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 4);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 4));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Ben Reilly", (139 / 2) - (g.getFontMetrics().stringWidth("Ben Reilly") / 2),
                20);
    }
}

/*
 * Kaine Parker
 */
class KainePanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public KainePanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 5);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 5));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Kaine Parker", (139 / 2) - (g.getFontMetrics().stringWidth("Kaine Parker") / 2),
                20);
    }
}

/*
 * Otto Octavius
 */
class OttoPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public OttoPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 6);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 6));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Otto Octavius", (139 / 2) - (g.getFontMetrics().stringWidth("Otto Octavius") / 2),
                20);
    }
}

/*
 * Miguel O'Hara
 */
class MiguelPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public MiguelPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 7);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 7));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Miguel O'Hara", (139 / 2) - (g.getFontMetrics().stringWidth("Miguel O'Hara") / 2),
                20);
    }
}

/*
 * Symbiote Suit
 */
class SymbiotePanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SymbiotePanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 8);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 8));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Symbiote Suit", (139 / 2) - (g.getFontMetrics().stringWidth("Symbiote Suit") / 2),
                20);
    }
}

/*
 * Secret Wars
 */
class SecretPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public SecretPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 9);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 9));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Secret Wars", (139 / 2) - (g.getFontMetrics().stringWidth("Secret Wars") / 2),
                20);
    }
}

/*
 * Iron Spider
 */
class IronPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public IronPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 10);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 10));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Iron Spider", (139 / 2) - (g.getFontMetrics().stringWidth("Iron Spider") / 2),
                20);
    }
}

/*
 * Big Time Stealth Suit
 */
class StealthPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public StealthPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 11);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 11));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Big Time Stealth", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Big Time Stealth") / 2),
                20);
    }
}

/*
 * Spider Armor Mk I
 */
class ArmorIPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ArmorIPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 12);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 12));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Spider Armor Mk 1", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Spider Armor Mk 1") / 2),
                20);
    }
}

/*
 * Spider Armor Mk II
 */
class ArmorIIPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ArmorIIPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 13);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 13));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Spider Armor Mk 2", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Spider Armor Mk 2") / 2),
                20);
    }
}

/*
 * Spider Armor Mk III
 */
class ArmorIIIPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ArmorIIIPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 14);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 4));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Spider Armor Mk 3", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Spider Armor Mk 3") / 2),
                20);
    }
}

/*
 * Spider Armor Mk IV
 */
class ArmorIVPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public ArmorIVPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 15);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 15));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Spider Armor Mk 4", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Spider Armor Mk 4") / 2),
                20);
    }
}

/*
 * Future Foundation
 */
class FuturePanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Heads head;
    private Semaphore display;
    private Semaphore descend;

    public FuturePanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        setBackground(Color.BLACK);
        spideyPanel = spidey;
        head = new HappyFace(0, -50, 175, 175, 16);
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread ani = new Thread(new ChangeCharacter(spideyPanel, display, descend, 16));
        ani.start();
        try {
            ani.join();
        } catch (InterruptedException ie) {

        }
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
        head.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Future Foundation", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Future Foundation") / 2),
                20);
    }
}

/*
 * 
 * 
 * 
 * Action Options
 * 
 * 
 * 
 */
class ActionOptions extends JPanel {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public ActionOptions(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        setLayout(new GridLayout(2, 2));
        setBackground(Color.WHITE);
        add(new WavePanel(spideyPanel, display, descend));
        add(new WinkPanel(spidey, display, descend));
        add(new SleepPanel(spideyPanel, display, descend));
        add(new ConfusionPanel(spidey, display, descend));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

/*
 * Waving Animation
 */
class WavePanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public WavePanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
        setBackground(Color.BLACK);
    }

    public void mouseClicked(MouseEvent e) {
        Thread wave = new Thread(new Wave(spideyPanel, display, descend));
        wave.start();
        try {
            wave.join();
        } catch (InterruptedException ie) {

        }
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
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Wave", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Wave") / 2),
                getHeight() / 2 - 7);
    }
}

/*
 * Sleeping Animation
 */
class SleepPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public SleepPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
        setBackground(Color.BLACK);
    }

    public void mouseClicked(MouseEvent e) {
        Thread sleep = new Thread(new SleepAnimation(spideyPanel, display, descend));
        sleep.start();
        try {
            sleep.join();
        } catch (InterruptedException ie) {

        }
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
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Sleep", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Wink") / 2),
                getHeight() / 2 - 7);
    }
}

/*
 * Winking Animation
 */
class WinkPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public WinkPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        setBackground(Color.BLACK);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Thread wink = new Thread(new WinkAnimation(spideyPanel, display, descend));
        wink.start();
        try {
            wink.join();
        } catch (InterruptedException ie) {

        }
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
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Wink", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Wink") / 2),
                getHeight() / 2 - 7);

    }
}

/*
 * Confused Animation
 */
class ConfusionPanel extends JPanel implements MouseListener {
    private SpiderStructure spideyPanel;
    private Semaphore display;
    private Semaphore descend;

    public ConfusionPanel(SpiderStructure spidey, Semaphore display, Semaphore descend) {
        spideyPanel = spidey;
        this.display = display;
        this.descend = descend;
        addMouseListener(this);
        setBackground(Color.BLACK);
    }

    public void mouseClicked(MouseEvent e) {
        Thread confused = new Thread(new ConfusedAnimation(spideyPanel, display, descend));
        confused.start();
        try {
            confused.join();
        } catch (InterruptedException ie) {

        }
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
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 14));
        g.drawString("Confusion", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Confusion") / 2),
                getHeight() / 2 - 7);
    }
}