import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Map<String, Student> students = Reader.GetStudents("src/students.txt");
    DoSomething(students);
  }

  private static void DoSomething(Map<String, Student> studentMap) {
    System.out.println(
        studentMap.values().stream()
            .peek(System.out::println)
            .map(Student::getBooks)
            .flatMap(List::stream)
            .sorted(Comparator.comparingInt(
                Book::getPages))
            .distinct()
            .filter(
                book -> book.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .map(String::valueOf)
            .orElse("такая книга отсутствует")
    );
  }
}


