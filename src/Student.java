import java.util.ArrayList;
import java.util.List;

public class Student {

  private final String name;
  private final List<Book> books = new ArrayList<>();

  public Student(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  @Override
  public String toString() {
    return "Студент: " + name;
  }

  public String info() {
    return name + " взял книги: " + books;
  }
}
