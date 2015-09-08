package week3.reflection;

import java.util.Collection;

public interface ISaver<T> {

    void save(T t);

    void save(Collection<T> collection);
}
