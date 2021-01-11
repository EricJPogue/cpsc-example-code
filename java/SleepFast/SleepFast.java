import java.util.ArrayList;

class OneSecondSleeper extends Thread {
    private int sleepNumber;
    OneSecondSleeper(int sleepNumberIn) {
        sleepNumber = sleepNumberIn;
    }

    public void sleep() {
        System.out.println(sleepNumber + " - Going to sleep");
        try {
            Thread.sleep(1000); // Sleep for one second. 
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("... " + sleepNumber + " - Done sleeping");
    }

    public void run() {
        sleep();
    }
}

public class SleepFast {
    public static void main(String[] args) {
        System.out.println("Starting Sleep...");

        OneSecondSleeper sleeper0 = new OneSecondSleeper(0);
        OneSecondSleeper sleeper1 = new OneSecondSleeper(1);

        System.out.println("\nNon-threaded Sleep");
        long start = System.currentTimeMillis();
        sleeper0.sleep();
        sleeper1.sleep();
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");

        System.out.println("\nThreaded Sleep");
        start = System.currentTimeMillis();
        sleeper0.start();
        sleeper1.start();

        try {
            sleeper0.join();
            sleeper1.join();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");

        // Sleeping ArrayList
        ArrayList<OneSecondSleeper> sleeperList = new ArrayList<OneSecondSleeper>();
        for (int i=2; i<12; i++) {
            sleeperList.add(new OneSecondSleeper(i));
        }

        System.out.println("\nNon-threaded ArrayList sleep:");
        start = System.currentTimeMillis();
        for (OneSecondSleeper s: sleeperList) {
            s.sleep();
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        System.out.println("\nThreaded ArrayList sleep:");
        start = System.currentTimeMillis();
        for (OneSecondSleeper s: sleeperList) {
            s.start();
        }

        try {
            for (OneSecondSleeper s: sleeperList) {
                s.join();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Elapsed time = "+(System.currentTimeMillis()-start));
    }
}