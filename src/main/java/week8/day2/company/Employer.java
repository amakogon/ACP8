package week8.day2.company;

/**
 * Created by Home on 13.10.2015.
 */
public class Employer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        String info = "\nEmployee name - " + name;
        return info;
    }
}
