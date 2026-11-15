package practice10;

interface AcousticSignal { default String emitAlert() { return "🔊 Звукова сирена 110 дБ"; } }
interface OpticalSignal { default String emitAlert() { return "🚨 Стробоскопічний маячок"; } }

class EmergencyBeacon implements AcousticSignal, OpticalSignal {
    @Override
    public String emitAlert() {
        return AcousticSignal.super.emitAlert() + " + " + OpticalSignal.super.emitAlert();
    }
}

public class Ex13 {
    public static void main(String[] args) {
        EmergencyBeacon beacon = new EmergencyBeacon();
        System.out.println("Вирішення Diamond Problem: " + beacon.emitAlert());
    }
}
