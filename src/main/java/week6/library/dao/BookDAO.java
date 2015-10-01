package week6.library.dao;

import week6.library.model.Book;

import java.util.List;

public interface BookDAO {

  void add(Book book);

  void addAll(Iterable iterable);

  List<Book> getAll();
}
