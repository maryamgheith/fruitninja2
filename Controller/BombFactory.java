
package Controller;

import Model.DangerousBomb;
import Model.FatalBomb;

import java.util.Random;

public class BombFactory {
    public GameObject GetBombs() {
        Random random = new Random();
        int i;
        for (i = 0; i < random.nextInt(1) + 1; i++) {
            int y = random.nextInt(2) + 1;
            if (y == 1)
                return new DangerousBomb();
            else if (y == 2)
                return new FatalBomb();


        }
        return  null;
    }
}