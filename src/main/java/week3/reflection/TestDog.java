package week3.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestDog {
    public static void main(String[] args) {
        Dog dog = new Dog("Friend", "Unknown");
        Class<? extends Dog> clazz = dog.getClass();

        System.out.println(clazz.getName());
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
        try {
//            clazz.getField("name");
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(dog, "Baron");
            System.out.println(field.get(dog));

            Method method = clazz.getMethod("voice", String.class);
            System.out.println("Annotation present - " + method.isAnnotationPresent(MyAnnotation.class));

            method.invoke(dog, "Reflection rules");
            Dog dog1 = clazz.getConstructor(String.class, String.class).newInstance("Vasia", "pitbull");
            System.out.println(dog1);

            System.out.println(Arrays.toString(clazz.getDeclaredAnnotations()));


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
