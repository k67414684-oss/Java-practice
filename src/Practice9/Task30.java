package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task30 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task30: Solid3D ---");
        Solid3D steelBall = new Sphere3D("сталь", 7850, 0.1);
        Solid3D goldBall = new Sphere3D("золото", 19320, 0.1);
        Solid3D steelCylinder = new Cylinder3D("сталь", 7850, 0.05, 0.3);
        Solid3D goldCylinder = new Cylinder3D("золото", 19320, 0.05, 0.3);
        System.out.println(steelBall);
        System.out.println(goldBall);
        System.out.println(steelCylinder);
        System.out.println(goldCylinder);
    }

    static abstract class Solid3D {
        private final String materialName;
        private final double densityKgPerM3;

        public Solid3D(String materialName, double densityKgPerM3) {
            this.materialName = materialName;
            this.densityKgPerM3 = Math.max(0.0, densityKgPerM3);
        }

        public abstract double getVolume();

        public abstract double getSurfaceArea();

        public final double getMassKg() {
            return densityKgPerM3 * getVolume();
        }

        @Override
        public String toString() {
            return String.format("%s{%s, V=%.6f м3, S=%.4f м2, маса=%.3f кг}",
                    getClass().getSimpleName(), materialName, getVolume(), getSurfaceArea(), getMassKg());
        }
    }

    static class Sphere3D extends Solid3D {
        private final double radius;

        public Sphere3D(String materialName, double densityKgPerM3, double radius) {
            super(materialName, densityKgPerM3);
            this.radius = radius > 0 ? radius : 1.0;
        }

        @Override
        public double getVolume() {
            return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
        }

        @Override
        public double getSurfaceArea() {
            return 4 * Math.PI * radius * radius;
        }
    }

    static class Cylinder3D extends Solid3D {
        private final double radius;
        private final double height;

        public Cylinder3D(String materialName, double densityKgPerM3, double radius, double height) {
            super(materialName, densityKgPerM3);
            this.radius = radius > 0 ? radius : 1.0;
            this.height = height > 0 ? height : 1.0;
        }

        @Override
        public double getVolume() {
            return Math.PI * radius * radius * height;
        }

        @Override
        public double getSurfaceArea() {
            return 2 * Math.PI * radius * (radius + height);
        }
    }
}
