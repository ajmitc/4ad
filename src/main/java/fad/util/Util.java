package fad.util;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author aaron.mitchell
 */
public class Util {
    private static Random GEN = new Random(new Date().getTime());

    public static int nextInt(int min, int max){
        return min + GEN.nextInt(max - min);
    }

    public static int nextInt(int max){
        return nextInt(0, max);
    }

    public static int roll(){
        return nextInt(1, 6);
    }

    public static int roll(int numDice){
        return nextInt(numDice, 6 * numDice);
    }

    public static int roll2d6(){
        return roll(2);
    }

    public static int roll3d6(){
        return roll(3);
    }

    public static int roll4d6(){
        return roll(4);
    }

    public static int rolld66(){
        return (roll() * 10) + roll();
    }
}
