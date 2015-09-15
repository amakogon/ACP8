package week4.xml;

import com.google.common.base.MoreObjects;

public class Student {
  private int id;
  private int age;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("id", id)
      .add("name", name)
      .add("age", age)
      .toString();
  }
}
