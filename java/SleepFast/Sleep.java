class OneSecondSleeper {
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
}

public class Sleep {
    public static void main(String[] args) {
        System.out.println("Starting Sleep...");

        OneSecondSleeper sleeper0 = new OneSecondSleeper(0);
        OneSecondSleeper sleeper1 = new OneSecondSleeper(1);

        System.out.println("\nSleep");
        long start = System.currentTimeMillis();
        sleeper0.sleep();
        sleeper1.sleep();
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");
    }
}