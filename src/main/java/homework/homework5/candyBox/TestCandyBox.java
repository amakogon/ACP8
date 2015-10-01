package homework.homework5.candyBox;

/**
 * Created by Home on 01.10.2015.
 */
public class TestCandyBox {
    public static void main(String[] args) {
        CandyBox candyBox = new CandyBox();
        Producer roshen = new Producer("roshen", candyBox);
        Consumer consumer1 = new Consumer("Vasy", candyBox);
        Consumer consumer2 = new Consumer("Marina", candyBox);
        roshen.putCandy();
        consumer1.getCandy();
        consumer2.getCandy();
    }
}
