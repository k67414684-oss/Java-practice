package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task19 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task19: Bookshelf ---");
        Bookshelf shelf = new Bookshelf("Фантастика", 3);
        shelf.putBook(new BookItem("Дюна", "Ф. Герберт", 688));
        shelf.putBook(new BookItem("Кобзар", "Т. Шевченко", 320));
        shelf.putBook(new BookItem("Соляріс", "С. Лем", 224));
        System.out.println("Четверта книга: " + shelf.putBook(new BookItem("Зайва", "Автор", 100)));
        System.out.println("null: " + shelf.putBook(null));
        System.out.println("Найдовша: " + shelf.findLongestBook());
        System.out.println("Всього сторінок: " + shelf.getTotalPagesOnShelf());
    }

    static class BookItem {
        private final String title;
        private final String author;
        private final int pages;

        public BookItem(String title, String author, int pages) {
            this.title = title;
            this.author = author;
            this.pages = Math.max(1, pages);
        }

        public int getPages() {
            return pages;
        }

        @Override
        public String toString() {
            return "'" + title + "' - " + author + ", " + pages + " стор.";
        }
    }

    static class Bookshelf {
        private final String genre;
        private final BookItem[] books;
        private int bookCount;

        public Bookshelf(String genre, int capacity) {
            this.genre = genre;
            this.books = new BookItem[Math.max(1, capacity)];
        }

        public boolean putBook(BookItem book) {
            if (book == null || bookCount >= books.length) {
                return false;
            }
            books[bookCount++] = book;
            return true;
        }

        public BookItem findLongestBook() {
            BookItem longest = null;
            for (int i = 0; i < bookCount; i++) {
                if (longest == null || books[i].getPages() > longest.getPages()) {
                    longest = books[i];
                }
            }
            return longest;
        }

        public int getTotalPagesOnShelf() {
            int total = 0;
            for (int i = 0; i < bookCount; i++) {
                total += books[i].getPages();
            }
            return total;
        }
    }
}
