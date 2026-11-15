package practice10;

import java.util.Arrays;

class FinalCalibrationTable {
    public static final double GRAVITY_G = 9.80665;
    private final String sensorSerial;
    private final double[] coefficients;

    public FinalCalibrationTable(String sensorSerial, double[] coefficients) {
        this.sensorSerial = sensorSerial;
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }
    public String getSensorSerial() { return sensorSerial; }
    public double[] getCoefficientsCopy() { return Arrays.copyOf(coefficients, coefficients.length); }
}

public class Ex33 {
    public static void main(String[] args) {
        double[] externalArray = { 1.0, 2.5, 3.8 };
        FinalCalibrationTable table = new FinalCalibrationTable("SENS-2026-X", externalArray);
        externalArray[0] = 999.0; // Спроба зламати інкапсуляцію ззовні
        System.out.println("Датчик: " + table.getSensorSerial() + " | g = " + FinalCalibrationTable.GRAVITY_G);
        System.out.println("Захищені коефіцієнти всередині: " + Arrays.toString(table.getCoefficientsCopy()));
    }
}
