class Eric {
    public String toString() {
        return "This is Eric!";
    }
}

public class OverrideToString {
    public static void main(String[] args) {
        System.out.println("Starting OverrideToString...");

        Eric myEric = new Eric();
        System.out.println(myEric);
    }
}