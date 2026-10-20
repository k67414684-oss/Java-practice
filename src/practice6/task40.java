package practice6;

public class task40 {
    public static void main(String[] args) {
        double[][][] weather = {
                {
                        {22.5, 14.0}, {23.0, 15.0}, {21.5, 13.5}, {24.0, 16.0}, {22.0, 14.5}, {25.0, 17.0}, {23.5, 15.5}
                },
                {
                        {20.0, 11.0}, {21.0, 12.0}, {19.5, 10.5}, {22.0, 13.0}, {20.5, 11.5}, {23.0, 14.0}, {21.5, 12.5}
                },
                {
                        {25.0, 18.0}, {26.0, 19.0}, {24.5, 17.5}, {27.0, 20.0}, {25.5, 18.5}, {28.0, 21.0}, {26.5, 19.5}
                }
        };
        String[] cities = {"Київ", "Львів", "Одеса"};
        for (int i = 0; i < weather.length; i++) {
            double sumDay = 0;
            for (int j = 0; j < weather[i].length; j++) {
                sumDay += weather[i][j][0];
            }
            double avgDay = sumDay / weather[i].length;
            System.out.println("Середня денна температура у місті " + cities[i] + ": " + avgDay);
        }
        double coldestNight = weather[0][0][1];
        for (int i = 0; i < weather.length; i++) {
            for (int j = 0; j < weather[i].length; j++) {
                if (weather[i][j][1] < coldestNight) {
                    coldestNight = weather[i][j][1];
                }
            }
        }
        System.out.println("Найхолодніша ніч: " + coldestNight);
    }
}
