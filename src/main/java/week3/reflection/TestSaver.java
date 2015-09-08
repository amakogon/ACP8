package week3.reflection;

public class TestSaver {
    public static void main(String[] args) {
        Cat kote = new Cat("Vasia");
        kote.setColor("white");
        kote.setSex(Sex.MALE);

        ISaver<Cat> saver = new DefaultSaver<>();
        saver.save(kote);
    }
}
