import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.Semaphore;

// Descending Animation
class Descend implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int heightCount;
    private Timer timer;

    public Descend(SpiderStructure spidey, Semaphore display, Semaphore animation) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        heightCount = 0;
        System.out.println("Descend Starting");
        timer = new Timer(25, this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            heightCount += 1;
            if (heightCount > 65) {
                timer.stop();
            }
            // System.out.println(heightCount);
            spidey.setCenterHeadY(spidey.getCenterHeadY() + 4);

        }
        display.release();
    }

    public void run() {
        timer.start();

    }

}

// Waving Animation
class Wave implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int waveCount;
    private Timer timer;
    public int mult;

    public Wave(SpiderStructure spidey, Semaphore display, Semaphore animation) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        waveCount = 0;
        System.out.println("Wave Starting");
        timer = new Timer(10, this);
        mult = 1;

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            waveCount += 1;
            if (waveCount == 1) {
                spidey.changeFace(1);
                spidey.rightHand.setHandType(1);
            }
            if (waveCount == 40) {
                spidey.changeFace(11);
            }
            if (waveCount == 65) {
                spidey.changeFace(1);
            }
            if (waveCount == 105) {
                spidey.changeFace(0);
            }
            if (waveCount <= 20) {
                spidey.setRightDelt(spidey.getRightDelt() - Math.toRadians(1));
                spidey.setRightElbow(spidey.getRightElbow() - Math.toRadians(4));
                spidey.setRightWrist(spidey.getRightWrist() - Math.toRadians(6));
            } else if (waveCount > 20 && waveCount <= 40) {
                spidey.setRightDelt(spidey.getRightDelt() - Math.toRadians(2));
                spidey.setRightElbow(spidey.getRightElbow() - Math.toRadians(3));
                spidey.setRightWrist(spidey.getRightWrist() - Math.toRadians(5));
            } else if (waveCount > 40 && waveCount <= 65) {
            } else if (waveCount > 65 && waveCount <= 85) {
                spidey.setRightDelt(spidey.getRightDelt() + Math.toRadians(2));
                spidey.setRightElbow(spidey.getRightElbow() + Math.toRadians(3));
                spidey.setRightWrist(spidey.getRightWrist() + Math.toRadians(5));
            } else if (waveCount > 85 && waveCount <= 105) {
                spidey.setRightDelt(spidey.getRightDelt() + Math.toRadians(1));
                spidey.setRightElbow(spidey.getRightElbow() + Math.toRadians(4));
                spidey.setRightWrist(spidey.getRightWrist() + Math.toRadians(6));
            } else if (waveCount > 105) {
                timer.stop();
                spidey.rightHand.setHandType(0);
            }
            spidey.setArmValues();
            spidey.update();

        }
        display.release();
    }

    public void run() {
        timer.start();

    }

}

// Winking Animation
class WinkAnimation implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int winkCount;
    private Timer timer;

    public WinkAnimation(SpiderStructure spidey, Semaphore display, Semaphore animation) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        winkCount = 0;
        System.out.println("Wink Starting");
        timer = new Timer(25, this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            winkCount++;
            if (winkCount == 1) {
                spidey.changeFace(1);
            }
            if (winkCount == 20) {
                spidey.changeFace(12);
            }
            if (winkCount == 27) {
                spidey.changeFace(1);
            }
            if (winkCount == 37) {
                spidey.changeFace(0);
            }
        }
        display.release();
    }

    public void run() {
        timer.start();

    }

}

// Sleeping Animation
class SleepAnimation implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int sleepCount;
    private Timer timer;

    public SleepAnimation(SpiderStructure spidey, Semaphore display, Semaphore animation) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        sleepCount = 0;
        System.out.println("Sleep Starting");
        timer = new Timer(25, this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            sleepCount++;
            /*
             * Facial Changes
             */
            if (sleepCount == 1) {
                spidey.changeFace(4);
            }
            if (sleepCount == 15) {
                spidey.changeFace(9);
                spidey.leftHand.setHandType(1);
                spidey.rightHand.setHandType(1);
            }
            if (sleepCount == 25) {
                spidey.leftHand.setHandType(0);
                spidey.rightHand.setHandType(0);
            }
            if (sleepCount == 85) {
                spidey.changeFace(4);
            }
            if (sleepCount == 115) {
                spidey.changeFace(10);
            }
            if (sleepCount >= 120 && sleepCount % 20 == 0 && sleepCount < 250) {
                spidey.changeFace(10);
            }
            if (sleepCount >= 120 && sleepCount % 20 == 10 && sleepCount < 250) {
                spidey.changeFace(13);
            }
            if (sleepCount == 250) {
                spidey.changeFace(3);
            }
            if (sleepCount == 280) {
                spidey.changeFace(1);
            }
            if (sleepCount == 310) {
                spidey.changeFace(0);
                timer.stop();
            }

            /*
             * Body Changes
             */

             // Initial Yawn Arms Out
            if (sleepCount > 15 && sleepCount <= 65) { 
                spidey.setRightDelt(spidey.getRightDelt() - Math.toRadians(1));
                spidey.setRightElbow(spidey.getRightElbow() - Math.toRadians(3));
                spidey.setRightWrist(spidey.getRightWrist() - Math.toRadians(6));
                spidey.setLeftDelt(spidey.getLeftDelt() + Math.toRadians(1));
                spidey.setLeftElbow(spidey.getLeftElbow() + Math.toRadians(4));
                spidey.setLeftWrist(spidey.getLeftWrist() + Math.toRadians(6));

            }
            // Initial Yawn Arms Back
            if (sleepCount > 65 && sleepCount <= 115) {
                spidey.setRightDelt(spidey.getRightDelt() + Math.toRadians(1));
                spidey.setRightElbow(spidey.getRightElbow() + Math.toRadians(3));
                spidey.setRightWrist(spidey.getRightWrist() + Math.toRadians(6));
                spidey.setLeftDelt(spidey.getLeftDelt() - Math.toRadians(1));
                spidey.setLeftElbow(spidey.getLeftElbow() - Math.toRadians(4));
                spidey.setLeftWrist(spidey.getLeftWrist() - Math.toRadians(6));
            }
            // Sleeping Right Arm Fall
            if (sleepCount > 135 && sleepCount <= 250) { // 115
                spidey.setRightDelt(spidey.getRightDelt() - Math.toRadians(1));
                if (sleepCount > 205) {
                    spidey.setRightElbow(spidey.getRightElbow() - Math.toRadians(4));
                    spidey.setRightWrist(spidey.getRightWrist() - Math.toRadians(5));
                }

            }
            // Sleeping Left Arm Fall
            if (sleepCount > 150 && sleepCount <= 250) { // 100
                if (sleepCount == 210) {
                    spidey.leftHand.setHandType(1);
                    spidey.rightHand.setHandType(1);
                }
                spidey.setLeftDelt(spidey.getLeftDelt() + Math.toRadians(1));
                if (sleepCount > 220) {
                    spidey.setLeftElbow(spidey.getLeftElbow() + Math.toRadians(5));
                    spidey.setLeftWrist(spidey.getLeftWrist() + Math.toRadians(6));
                }

            }
            // Sleeping Right Leg Fall
            if (sleepCount > 230 && sleepCount <= 250) {
                spidey.setRightHip(spidey.getRightHip() - Math.toRadians(1));
                if (sleepCount > 240) {
                    spidey.setRightKnee(spidey.getRightKnee() - Math.toRadians(2));
                    spidey.setRightAnkle(spidey.getRightAnkle() - Math.toRadians(1));
                }
            }
            // Startled Return of Limbs
            if (sleepCount > 250 && sleepCount <= 260) {
                spidey.setRightDelt(spidey.getRightDelt() + Math.toRadians(11));
                spidey.setRightElbow(spidey.getRightElbow() + Math.toRadians(18));
                spidey.setRightWrist(spidey.getRightWrist() + Math.toRadians(22));
                spidey.setLeftDelt(spidey.getLeftDelt() - Math.toRadians(10));
                spidey.setLeftElbow(spidey.getLeftElbow() - Math.toRadians(15));
                spidey.setLeftWrist(spidey.getLeftWrist() - Math.toRadians(18));
                spidey.setRightHip(spidey.getRightHip() + Math.toRadians(2));
                if (sleepCount == 255) {
                    spidey.rightHand.setHandType(0);
                    spidey.leftHand.setHandType(0);
                }
                if (sleepCount > 255) {
                    spidey.setRightKnee(spidey.getRightKnee() + Math.toRadians(4));
                    spidey.setRightAnkle(spidey.getRightAnkle() + Math.toRadians(2));
                }

            }
            if (sleepCount == 261) {
                spidey.setRightDelt(spidey.getRightDelt() + Math.toRadians(5));
                spidey.setRightWrist(spidey.getRightWrist() + Math.toRadians(5));
            }

        }
        spidey.setArmValues();
        spidey.setLegValues();
        display.release();
        spidey.update();
    }

    public void run() {
        timer.start();

    }

}

// Conused Animation
class ConfusedAnimation implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int confusedCount;
    private Timer timer;

    public ConfusedAnimation(SpiderStructure spidey, Semaphore display, Semaphore animation) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        confusedCount = 0;
        System.out.println("Confusion Starting");
        timer = new Timer(25, this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            confusedCount++;
            if (confusedCount == 1) {
                spidey.changeFace(14);
            }
            if (confusedCount == 10) {
                spidey.changeFace(2);
            }
            if (confusedCount == 50) {
                spidey.changeFace(4);
            }
            if (confusedCount == 65) {
                spidey.changeFace(0);
                timer.stop();
            }

        }
        display.release();
    }

    public void run() {
        timer.start();

    }

}

class ExpressionChange implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int face;
    private Timer timer;

    public ExpressionChange(SpiderStructure spidey, Semaphore display, Semaphore animation, int faceIn) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        face = faceIn;
        timer = new Timer(10, this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            spidey.changeFace(face);
        }
        display.release();
        timer.stop();
    }

    public void run() {
        timer.start();

    }
}

class ChangeCharacter implements Runnable, ActionListener {
    private SpiderStructure spidey;
    private Semaphore display;
    private Semaphore descend;
    private int timeCount;
    public int character;
    private Timer timer;

    public ChangeCharacter(SpiderStructure spidey, Semaphore display, Semaphore animation, int character) {
        this.spidey = spidey;
        this.display = display;
        this.descend = animation;
        this.character = character;
        timer = new Timer(10, this);
        timeCount = 0;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            descend.acquire();
        } catch (InterruptedException ie) {

        }
        synchronized (this) {
            timeCount++;
            if (timeCount <= 70) {
                spidey.setCenterHeadY(spidey.getCenterHeadY() - 4);
            }
            if (timeCount == 71) {
                spidey.changeCharacter(character);
            }
            if (timeCount > 100 && timeCount <= 170) {
                spidey.setCenterHeadY(spidey.getCenterHeadY() + 4);
            }
            if (timeCount > 170) {
                timer.stop();
            }

        }
        display.release();

    }

    public void run() {
        timer.start();

    }
}
