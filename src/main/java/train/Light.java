package train;

public enum Light {
    ON, OFF;

    public static Light random() {
        return Math.random() > 0.5 ? ON : OFF;
    }
}
