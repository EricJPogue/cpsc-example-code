import java.util.Random;

class Utils {
	// Generates a random number between min and max (inclusive). 
    public static int GetNumberBetweenInclusive(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   
}