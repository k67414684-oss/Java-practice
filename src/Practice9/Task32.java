package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task32 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task32: AbstractCompressor ---");
        AbstractCompressor zip = new ZipCompressor();
        AbstractCompressor lzma = new UltraLzmaCompressor();
        int[] sizes = {50, 1000, 1000000};
        for (int size : sizes) {
            System.out.printf("Файл %d байт: %s -> %d (%.2f%%), %s -> %d (%.2f%%)%n", size,
                    zip.getAlgorithmName(), zip.estimateCompressedSize(size), zip.getCompressionRatio(size),
                    lzma.getAlgorithmName(), lzma.estimateCompressedSize(size), lzma.getCompressionRatio(size));
        }
    }

    static abstract class AbstractCompressor {
        private final String algorithmName;

        public AbstractCompressor(String algorithmName) {
            this.algorithmName = algorithmName;
        }

        public String getAlgorithmName() {
            return algorithmName;
        }

        public abstract int estimateCompressedSize(int originalSizeBytes);

        public double getCompressionRatio(int originalSizeBytes) {
            if (originalSizeBytes <= 0) {
                return 0.0;
            }
            int compressed = estimateCompressedSize(originalSizeBytes);
            return (1.0 - (double) compressed / originalSizeBytes) * 100.0;
        }
    }

    static class ZipCompressor extends AbstractCompressor {

        public ZipCompressor() {
            super("ZIP");
        }

        @Override
        public int estimateCompressedSize(int originalSizeBytes) {
            return (int) Math.round(originalSizeBytes * 0.55);
        }
    }

    static class UltraLzmaCompressor extends AbstractCompressor {

        public UltraLzmaCompressor() {
            super("LZMA");
        }

        @Override
        public int estimateCompressedSize(int originalSizeBytes) {
            return (int) Math.round(originalSizeBytes * 0.30) + 128;
        }
    }
}
