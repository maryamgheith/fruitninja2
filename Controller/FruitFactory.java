package Controller;

import Model.*;
import java.util.Random;

public class FruitFactory {
    public GameObject getFruits() {
        Random random = new Random();
        int x = random.nextInt(6)+1;
        if (x == 1)
            return new Banana();
        else if (x == 2)
            return new Grapes();
        else if (x == 3)
            return new Pineapple();
        else if (x == 4)
            return new Strawberry();
        else
            return new Watermelon(); }
}