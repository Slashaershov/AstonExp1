import java.util.ArrayList;
import java.util.List;

public class Student {

  private String name;
  private List<Book> books = new ArrayList<>();

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

  public String Info() {
    return name + " взял книги: " + books;
  }
}
