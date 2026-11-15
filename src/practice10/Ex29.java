package practice10;

abstract class MediaItem {
    String title; double sizeMb;
    public MediaItem(String title, double sizeMb) { this.title = title; this.sizeMb = sizeMb; }
}
class VideoFile extends MediaItem {
    int resolutionHeight;
    public VideoFile(String title, double sizeMb, int h) { super(title, sizeMb); this.resolutionHeight = h; }
    public boolean is4K() { return resolutionHeight >= 2160; }
}
class AudioFile extends MediaItem {
    int bitrateKbps;
    public AudioFile(String title, double sizeMb, int br) { super(title, sizeMb); this.bitrateKbps = br; }
    public boolean isLossless() { return bitrateKbps >= 1000; }
}
class EBookFile extends MediaItem {
    int pageCount;
    public EBookFile(String title, double sizeMb, int pages) { super(title, sizeMb); this.pageCount = pages; }
}

public class Ex29 {
    public static void main(String[] args) {
        MediaItem[] library = {
                new VideoFile("Nature_4K.mp4", 12500.0, 2160),
                new VideoFile("Lecture_HD.mp4", 800.0, 1080),
                new AudioFile("Symphony.flac", 65.5, 1411),
                new EBookFile("CleanCode.pdf", 15.0, 464)
        };
        double totalHighResMb = 0;
        for (MediaItem item : library) {
            if (item instanceof VideoFile v && v.is4K()) totalHighResMb += v.sizeMb;
            if (item instanceof AudioFile a && a.isLossless()) totalHighResMb += a.sizeMb;
        }
        System.out.printf("Сумарний обсяг 4K-відео та Lossless-аудіо: %.2f МБ%n", totalHighResMb);
    }
}
