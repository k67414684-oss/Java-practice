package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task20 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task20: Playlist ---");
        Playlist playlist = new Playlist("Ранкова", 5);
        playlist.addTrack(new AudioTrack("Shape of You", "Ed Sheeran", 234));
        playlist.addTrack(new AudioTrack("Believer", "Imagine Dragons", 204));
        playlist.addTrack(new AudioTrack("Obiymy", "Okean Elzy", 258));
        System.out.println(playlist);
    }

    static class AudioTrack {
        private final String title;
        private final String artist;
        private final int durationSeconds;

        public AudioTrack(String title, String artist, int durationSeconds) {
            this.title = title;
            this.artist = artist;
            this.durationSeconds = Math.max(1, durationSeconds);
        }

        public int getDurationSeconds() {
            return durationSeconds;
        }

        public String formatDuration() {
            return String.format("%02d:%02d", durationSeconds / 60, durationSeconds % 60);
        }

        @Override
        public String toString() {
            return artist + " - " + title + " [" + formatDuration() + "]";
        }
    }

    static class Playlist {
        private String name;
        private final AudioTrack[] tracks;
        private int trackCount;

        public Playlist(String name, int capacity) {
            this.name = name;
            this.tracks = new AudioTrack[Math.max(1, capacity)];
        }

        public boolean addTrack(AudioTrack track) {
            if (track == null || trackCount >= tracks.length) {
                return false;
            }
            tracks[trackCount++] = track;
            return true;
        }

        public int getTotalDurationSeconds() {
            int total = 0;
            for (int i = 0; i < trackCount; i++) {
                total += tracks[i].getDurationSeconds();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Плейлист '" + name + "':\n");
            for (int i = 0; i < trackCount; i++) {
                sb.append("  ").append(i + 1).append(". ").append(tracks[i]).append("\n");
            }
            int total = getTotalDurationSeconds();
            sb.append("Загальна тривалість: ").append(total / 60).append(" хв ").append(total % 60).append(" сек");
            return sb.toString();
        }
    }
}
