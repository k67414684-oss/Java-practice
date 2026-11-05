package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task15 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task15: Publication -> PrintedBook, AudioBook ---");
        PrintedBook printed = new PrintedBook("Java. Посібник для початківців", "Г. Шилдт", 2022, 720, "тверда");
        AudioBook audio = new AudioBook("Кобзар", "Т. Шевченко", 1840, 395, "А. Хостікоєв");
        System.out.println(printed);
        System.out.println(audio);
    }

    static class Publication {
        private String title;
        private String author;
        private int releaseYear;

        public Publication(String title, String author, int releaseYear) {
            this.title = title;
            this.author = author;
            this.releaseYear = releaseYear;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        @Override
        public String toString() {
            return "'" + title + "' - " + author + ", " + releaseYear;
        }
    }

    static class PrintedBook extends Publication {
        private int pageCount;
        private String coverType;

        public PrintedBook(String title, String author, int releaseYear, int pageCount, String coverType) {
            super(title, author, releaseYear);
            this.pageCount = Math.max(1, pageCount);
            this.coverType = coverType;
        }

        public int getPageCount() {
            return pageCount;
        }

        public String getCoverType() {
            return coverType;
        }

        @Override
        public String toString() {
            return "PrintedBook{" + super.toString() + ", " + pageCount + " стор., обкладинка: " + coverType + "}";
        }
    }

    static class AudioBook extends Publication {
        private int durationMinutes;
        private String narrator;

        public AudioBook(String title, String author, int releaseYear, int durationMinutes, String narrator) {
            super(title, author, releaseYear);
            this.durationMinutes = Math.max(0, durationMinutes);
            this.narrator = narrator;
        }

        public int getDurationMinutes() {
            return durationMinutes;
        }

        public String getNarrator() {
            return narrator;
        }

        public String formatDuration() {
            int hours = durationMinutes / 60;
            int minutes = durationMinutes % 60;
            return hours + " год " + minutes + " хв";
        }

        @Override
        public String toString() {
            return "AudioBook{" + super.toString() + ", тривалість: " + formatDuration()
                    + ", читає: " + narrator + "}";
        }
    }
}
