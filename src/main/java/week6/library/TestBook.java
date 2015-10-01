package week6.library;

import week6.library.dao.BookDAO;
import week6.library.dao.impl.BookDAOImpl;
import week6.library.model.Book;
import week6.library.model.Storage;

import java.util.Arrays;
import java.util.List;

public class TestBook {
  public static void main(String[] args) {
    //create test data
    Book book1 = new Book("title1", "A1");
    Book book2 = new Book("title2", "A2");
    Book book3 = new Book("title3", "A3");
    List<Book> books = Arrays.asList(book1, book2, book3);

    //add to storage
    BookDAO bookDAO = new BookDAOImpl();
    bookDAO.addAll(books);

    //retrieve from storage
    System.out.println(bookDAO.getAll());
  }
}
