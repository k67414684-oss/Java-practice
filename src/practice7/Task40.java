package practice7;

public class Task40 {

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog(5);
        catalog.addBook(new BookItem("111", "Кобзар", "Тарас Шевченко"));
        catalog.addBook(new BookItem("222", "Лісова пісня", "Леся Українка"));
        catalog.addBook(new BookItem("333", "Тіні забутих предків", "Михайло Коцюбинський"));

        catalog.printCatalog();

        catalog.borrowBook("Кобзар");
        catalog.printCatalog();

        catalog.borrowBook("Кобзар");
        catalog.borrowBook("Енеїда");
    }
}

class BookItem {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public BookItem(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void printBook() {
        String status;
        if (isAvailable) {
            status = "в наявності";
        } else {
            status = "видана";
        }
        System.out.println(title + " (" + author + "), ISBN: " + isbn + " - " + status);
    }
}

class LibraryCatalog {
    private BookItem[] books;
    private int size;

    public LibraryCatalog(int capacity) {
        this.books = new BookItem[capacity];
        this.size = 0;
    }

    public void addBook(BookItem book) {
        if (size < books.length) {
            books[size] = book;
            size++;
        } else {
            System.out.println("Каталог заповнений, книгу не додано");
        }
    }

    public BookItem findBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String title) {
        BookItem book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Книгу \"" + title + "\" не знайдено");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Книга \"" + title + "\" уже видана");
            return false;
        }
        book.borrowBook();
        System.out.println("Книгу \"" + title + "\" видано");
        return true;
    }

    public void printCatalog() {
        for (int i = 0; i < size; i++) {
            books[i].printBook();
        }
    }
}
