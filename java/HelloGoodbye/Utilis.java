/******************************************************************************
 * Copyright (C) 2023 Eric Pogue.
 * 
 * This file is a stand-alone library licensed under the BSD-3-Clause
 * 
 * You are free to reuse the unmodified version of this file in your projects
 * as long as you give credit to the library in your source code.  
 * 
 *****************************************************************************/

import java.util.Random;

class Utils {
	// Generates a random number between min and max (inclusive). 
    public static int GetNumberBetweenInclusive(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   
}