package week6.library.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Storage<T> {
  private List<T> content = new ArrayList<>();

  public Storage(List<T> content) {
    Objects.requireNonNull(content);
    this.content = content;
  }

  public Storage() {

  }

  public void addAll(Collection<T> collection) {
    content.addAll(collection);
  }

  public List<T> getContent() {
    return content;
  }

  public void add(T t) {
    content.add(t);
  }
}
