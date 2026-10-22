package practice6;

public class task3 {
    public static class Book {
        public String title;
        public String author;
        public int pages;
        public boolean isRead;


    }

  public static void main(String[] args) {
        Book emptyBook = new Book();

        System.out.println("title: " + emptyBook.title);
        System.out.println("author: " + emptyBook.author);
        System.out.println("pages: " + emptyBook.pages);
        System.out.println("isRead: " + emptyBook.isRead);
    }

}
