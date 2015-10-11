package week6.library.model;

public class Book {
  private static long bookCounter;
  private long bookId;
  private String title;
  private String author;

  public Book(String title, String author) {
   this.bookId = ++bookCounter;
    this.title = title;
    this.author = author;
  }

  public long getBookId() {
    return bookId;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Book{" +
      "bookId=" + bookId +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      '}';
  }
}
