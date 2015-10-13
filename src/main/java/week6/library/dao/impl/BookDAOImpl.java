package week6.library.dao.impl;

import com.google.common.collect.Lists;
import week6.library.dao.BookDAO;
import week6.library.model.Book;
import week6.library.model.Storage;

import java.util.List;

public class BookDAOImpl implements BookDAO {
  private Storage<Book> bookStorage = new Storage<>();

  @Override
  public void add(Book book) {
    bookStorage.add(book);
  }

  @Override
  public void addAll(Iterable iterable) {
    bookStorage.addAll(Lists.newArrayList(iterable));
  }

  @Override
  public List<Book> getAll() {
    return bookStorage.getContent();
  }
}
