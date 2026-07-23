import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Student> students = Reader.getStudents("src/students.txt");
    doSomething(students);
  }

  private static void doSomething(List<Student> studentsList) {
    System.out.println(
        studentsList.stream()
            .peek(System.out::println)
            .map(Student::getBooks)
            .flatMap(List::stream)
            .sorted(Comparator.comparingInt(Book::getPages))
            .distinct()
            .filter(book -> book.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .map(String::valueOf)
            .orElse("такая книга отсутствует")
    );
  }
}