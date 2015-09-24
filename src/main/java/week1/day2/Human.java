package week1.day2;

public class Human implements Comparable<Human> {
  private String name;
  private int age;

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null || !(obj instanceof Human)) {
      return false;
    }
    Human other = ((Human) obj);
    return age == other.age && name.equals(other.name);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result * age;
    result = 31 * result * name.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Human{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  @Override
  public int compareTo(Human o) {
    return 0;
  }
}
