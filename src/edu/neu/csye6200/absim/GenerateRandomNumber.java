package edu.neu.csye6200.absim;

/*
 * 
 * Name: Shilian Hou
 * NUID: 001061840
 * 
 */

import java.util.Random;

public class GenerateRandomNumber {
    private static Random random = new Random();

    public static Integer RandomPosition(int oceanSize) {
        return random.nextInt(oceanSize);
    }

    /**
     * 1 means go up/North
     * 2 means go down/South
     * 3 means go left/West
     * 4 means go right/East
     * @return
     */
    public static Integer RandomDirection() {
        return random.nextInt(4) + 1;
    }

    public static Integer RandomHoriOrVerti() {
        return random.nextInt(2);
    }
}
