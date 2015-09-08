package week3.reflection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

public class DefaultSaver<T> implements ISaver<T> {

    @Override
    public void save(T t) {
        String filePath = "/home/amakogon/myFile";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(prepareData(t));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String prepareData(T t) {
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder builder = new StringBuilder(clazz.getSimpleName());
        builder.append("[");

        for (Field field : fields) {
            if (field.isAnnotationPresent(Data.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(t);
                    String fieldInfo = field.getAnnotation(Data.class).info();
                    builder.append(String.format("%s=%s", fieldInfo, value));
                } catch (IllegalAccessException neverHappen) {
                }
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public void save(Collection<T> collection) {

    }
}
