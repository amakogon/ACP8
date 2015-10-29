package homework8.company;

/**
 * Created by Razer on 13.10.15.
 */
public class Employee {
    String name;
    int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "experience=" + experience +
                ", name='" + name + '\'' +
                '}';
    }
}
