package homework8;

/**
 * Created by Razer on 13.10.15.
 */

import java.util.Random;

public class BeanValueRandom {

    int rand = 0;
    Random r = new Random();

    public BeanValueRandom() {
        rand = r.nextInt(10);
    }

    public int getRand() {
        return rand;
    }
}
