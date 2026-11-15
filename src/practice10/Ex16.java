package practice10;

interface DataExportable {
    String toJson();
    String toCsvRow();
}
class StudentGradeRecord implements DataExportable {
    private final String name; private final int group; private final double gpa;
    public StudentGradeRecord(String name, int group, double gpa) { this.name = name; this.group = group; this.gpa = gpa; }
    @Override public String toJson() { return String.format("{"name":"%s","group":%d,"gpa":%.2f}", name, group, gpa); }
    @Override public String toCsvRow() { return name + "," + group + "," + gpa; }
}
class WeatherObservation implements DataExportable {
    private final String city; private final double tempC; private final int humidity;
    public WeatherObservation(String city, double tempC, int humidity) { this.city = city; this.tempC = tempC; this.humidity = humidity; }
    @Override public String toJson() { return String.format("{"city":"%s","tempC":%.1f,"humidity":%d}", city, tempC, humidity); }
    @Override public String toCsvRow() { return city + "," + tempC + "," + humidity; }
}

public class Ex16 {
    public static void main(String[] args) {
        DataExportable[] records = {
                new StudentGradeRecord("Олександр", 102, 94.5),
                new WeatherObservation("Київ", 14.2, 60)
        };
        for (DataExportable r : records) {
            System.out.println("JSON: " + r.toJson());
            System.out.println("CSV:  " + r.toCsvRow());
        }
    }
}
