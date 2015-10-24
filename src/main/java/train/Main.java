package train;

import java.util.Random;

public class Main {

    public static final Random RANDOM = new Random();
    private static int totalSteps = 0;

    public static void main(String[] args) {
//        int numberOfWagons = RANDOM.nextInt(50) + 2;
        int numberOfWagons = 3;
        Wagon start = createAndChaineAllWagons(numberOfWagons);
        System.out.println(numberOfWagons + 1);
        System.out.println(artemAlgorithm(start));
        System.out.println("Total steps: " + totalSteps);
    }

    private static int artemAlgorithm(Wagon start) {
        int counter = 1;
        Wagon currentWagon = start.next;
        totalSteps++;
        currentWagon.light = Light.ON;
        while (true) {

            for (int i = counter; i > -counter; i--) {
                currentWagon = currentWagon.prev;
                totalSteps++;
            }
            currentWagon.light = Light.OFF;

            for (int i = 0; i < 2 * counter; i++) {
                currentWagon = currentWagon.next;
                totalSteps++;
            }

            if (currentWagon.light == Light.OFF) {
                break;
            }
            counter++;
            currentWagon = currentWagon.next;
            currentWagon.light = Light.ON;
            totalSteps++;
        }
        return counter;
    }

    private static Wagon createAndChaineAllWagons(int numberOfWagons) {
        Wagon firstWagon = Wagon.of(Light.random());
        Wagon start = firstWagon;
        for (int i = 0; i < numberOfWagons; i++) {
            Wagon wagon = Wagon.of(Light.random());
            start.next = wagon;
            wagon.prev = start;
            start = start.next;
        }
        start.next = firstWagon;
        firstWagon.prev = start;
        return firstWagon;
    }
}
