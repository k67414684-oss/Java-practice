package practice7;

public class Task33 {

    public static void main(String[] args) {
        LineSegment segment1 = new LineSegment(new Point(0, 0), new Point(6, 8));
        LineSegment segment2 = new LineSegment(1, 2, 5, 10);

        segment1.printSegment();
        System.out.println("Довжина: " + segment1.getLength());
        Point mid1 = segment1.getMidPoint();
        System.out.println("Середина: (" + mid1.getX() + "; " + mid1.getY() + ")");

        segment2.printSegment();
        System.out.println("Довжина: " + segment2.getLength());
        Point mid2 = segment2.getMidPoint();
        System.out.println("Середина: (" + mid2.getX() + "; " + mid2.getY() + ")");
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class LineSegment {
    private Point start;
    private Point end;

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public double getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point getMidPoint() {
        double midX = (start.getX() + end.getX()) / 2;
        double midY = (start.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }

    public void printSegment() {
        System.out.println("Відрізок: (" + start.getX() + "; " + start.getY() + ") - (" + end.getX() + "; " + end.getY() + ")");
    }
}
