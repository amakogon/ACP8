package week8.di;

public class Person {
  private String name;
  private Person friend;

  public String getName() {
    return name;
  }
//
  public void setName(String name) {
    this.name = name;
  }

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public Person getFriend() {
    return friend;
  }

  public void setFriend(Person friend) {
    this.friend = friend;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", friend=" + friend +
      '}';
  }
}
