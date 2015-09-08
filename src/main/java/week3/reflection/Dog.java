package week3.reflection;

@MyAnnotation
public class Dog {

    private final String name;
    private String poroda;
    public int age;


    public Dog(String name, String poroda) {
        this.name = name;
        this.poroda = poroda;
    }

    @MyAnnotation
    public void voice(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", poroda='" + poroda + '\'' +
                ", age=" + age +
                '}';
    }
}
