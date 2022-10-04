package snakeandladder;

import java.util.Random;

public class Dice {


    private int numberOfDies;

    public Dice(int _numberOfDies) {
        this.numberOfDies = _numberOfDies;
    }

    public int rollDies() {
        return new Random().nextInt(6 * this.numberOfDies) + 1;
    }

    public int getNumberOfDies() {
        return numberOfDies;
    }
}
