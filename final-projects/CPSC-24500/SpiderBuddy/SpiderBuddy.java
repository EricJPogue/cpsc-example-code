import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

class SpiderBuddy {
    public static void main(String[] args) {
        Boolean helpRequested = false;
        try {
            if (args[0].equalsIgnoreCase("-Help")) {
                Help.help();
                helpRequested = true;
            }
        } catch (ArrayIndexOutOfBoundsException aioobe) {
        }
        if (!helpRequested) {
            SpiderBuddyWindow window = new SpiderBuddyWindow();
            window.setVisible(true);
        }

    }
}

class SpiderBuddyWindow extends JFrame {

    private Semaphore controlDisplayQueue;
    private Semaphore controlUpdateQueue;

    public SpiderBuddyWindow() {
        setTitle("Spider Buddy");
        setBounds(0, 0, 1300, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container windowPlane = getContentPane();
        windowPlane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        Semaphore displayQueue = new Semaphore(0);
        Semaphore descendQueue = new Semaphore(0);

        // Display Panel
        SpiderBuddyPanel displayPanel = new SpiderBuddyPanel(displayQueue, descendQueue);
        Thread displayRefresh = new Thread(displayPanel);
        displayRefresh.start();
        displayQueue.release();

        // Command Panel
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new GridBagLayout());
        TextPanel textPanel = new TextPanel(displayPanel, displayQueue, descendQueue);
        ControlPanel buttonPanel = new ControlPanel(textPanel);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.5;
        constraints.fill = GridBagConstraints.BOTH;
        commandPanel.add(buttonPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.5;
        constraints.fill = GridBagConstraints.BOTH;
        commandPanel.add(textPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.6;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        windowPlane.add(displayPanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.4;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        windowPlane.add(commandPanel, constraints);
    }

    // Refresh Thread
    public void run() {
        while (true) {
            try {
                controlDisplayQueue.acquire();
            } catch (InterruptedException ie) {

            }
            setResizable(true);
            repaint();
            setBounds(0, 0, 1300, 850);
            setResizable(false);
            controlUpdateQueue.release();
        }

    }
}

class SpiderBuddyPanel extends JPanel implements ComponentListener, Runnable {
    public NormalFace head;
    public BackGround background;
    public SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    public Boolean descendStart;

    public SpiderBuddyPanel(Semaphore display, Semaphore descend) {
        background = new PeterApartment();
        head = new NormalFace(297, 560, 1);
        spidey = new SpiderStructure(375, -100);
        addComponentListener(this);
        this.display = display;
        this.descend = descend;
        descendStart = true;

    }

    // Initial Descent at Startup
    public void componentResized(ComponentEvent e) {
        if (descendStart) {
            Thread initialDecent = new Thread(new Descend(spidey, display, descend));
            initialDecent.start();
            try {
                initialDecent.join();
            } catch (InterruptedException ie) {

            }
            descendStart = false;
        }

    }

    public void componentHidden(ComponentEvent e) {
        System.out.println("Hidden");
    }

    public void componentMoved(ComponentEvent e) {
        System.out.println("Moved");
    }

    public void componentShown(ComponentEvent e) {
        System.out.println("Shown");
    }

    public void paintComponent(Graphics g) {
        background.paintComponent(g);
        spidey.paintComponent(g);

    }

    public void run() {
        while (true) {
            try {
                display.acquire();
            } catch (InterruptedException ie) {

            }
            repaint();
            setVisible(true);
            // System.out.println("Print");
            descend.release();

        }

    }
}