import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

  public static List<Student> getStudents(String address) {
    Map<String, Student> map = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(address))) {
      String line = reader.readLine();
      while (line != null) {
        String[] parts = line.split(",");

        String studentName = parts[0].trim();
        String bookTitle = parts[1].trim();
        int bookYear = Integer.parseInt(parts[2].trim());
        int pagesCount = Integer.parseInt(parts[3].trim());
        Book book = new Book(bookTitle, bookYear, pagesCount);

        map.computeIfAbsent(studentName, Student::new).addBook(book);
        line = reader.readLine();
      }

      map.values().forEach(s -> {
        if (s.getBooks().size() < 5) {
          throw new IllegalStateException("Мало книг у " + s);
        }
      });
    } catch (IndexOutOfBoundsException e) {
      System.out.println("неверный формат данных (Студент, книга, дата, страницы)");
    } catch (IOException e) {
      System.out.println(e.toString());
    }

    return new ArrayList<>(map.values());
  }
}