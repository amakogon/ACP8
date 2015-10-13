package train;

import java.util.Objects;

public class Wagon {

    Wagon next;
    Wagon prev;
    Light light;

    public Wagon(Wagon next, Wagon prev, Light light) {
        this.next = next;
        this.prev = prev;
        this.light = light;
    }

    public static Wagon of(Light light) {
        return of(null, light);
    }

    public static Wagon of(Wagon next, Light light) {
        return of(next, null, light);
    }

    public static Wagon of(Wagon next, Wagon prev, Light light) {
        return new Wagon(next, prev, light);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wagon wagon = (Wagon) o;

        return light == wagon.light
                && Objects.deepEquals(next, wagon.next)
                && Objects.deepEquals(prev, wagon.prev);

    }

}
