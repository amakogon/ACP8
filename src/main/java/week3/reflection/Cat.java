package week3.reflection;

import com.google.common.base.MoreObjects;

public class Cat {
    @Data(info = "Klikuha")
    private String name;
    @Data(info = "gender")
    private Sex sex;
    private int age;
    @Data(info = "color")
    private String color;
    private String favoriteToy;


    public Cat(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("sex", sex)
                .add("age", age)
                .add("color", color)
                .add("favorite toy", favoriteToy)
                .toString();
    }
}
