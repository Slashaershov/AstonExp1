public class Book {

  String title;
  int year;
  private final int pagesCount;

  public Book(String name, int releaseDate, int pagesCount) {
    this.title = name;
    this.year = releaseDate;
    this.pagesCount = pagesCount;
  }

  public int getYear() {
    return year;
  }

  public int getPages() {
    return pagesCount;
  }

  @Override
  public String toString() {
    return title + " " + year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return year == book.year && pagesCount == book.pagesCount && title.equals(book.title);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title, year);
  }
}

