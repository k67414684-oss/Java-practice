package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task16 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task16: Gamer -> ProEsportsPlayer ---");
        Gamer gamer = new Gamer("NoobMaster", 120);
        ProEsportsPlayer pro = new ProEsportsPlayer("Zeus_UA", 9800, "Natus Vincere", 150000, 6);
        ProEsportsPlayer rookie = new ProEsportsPlayer("Rookie", 700, "No Team", 0, 0);
        System.out.println(gamer);
        System.out.println(pro);
        System.out.println(rookie);
    }

    static class Gamer {
        private String nickname;
        private int hoursPlayed;

        public Gamer(String nickname, int hoursPlayed) {
            this.nickname = nickname;
            this.hoursPlayed = Math.max(0, hoursPlayed);
        }

        public String getNickname() {
            return nickname;
        }

        public int getHoursPlayed() {
            return hoursPlayed;
        }

        @Override
        public String toString() {
            return "Gamer{nickname='" + nickname + "', hoursPlayed=" + hoursPlayed + "}";
        }
    }

    static class ProEsportsPlayer extends Gamer {
        private String teamName;
        private double prizeMoneyUSD;
        private int tournamentsWon;

        public ProEsportsPlayer(String nickname, int hoursPlayed, String teamName,
                                double prizeMoneyUSD, int tournamentsWon) {
            super(nickname, hoursPlayed);
            this.teamName = teamName;
            this.prizeMoneyUSD = Math.max(0.0, prizeMoneyUSD);
            this.tournamentsWon = Math.max(0, tournamentsWon);
        }

        public String getTeamName() {
            return teamName;
        }

        public double getPrizeMoneyUSD() {
            return prizeMoneyUSD;
        }

        public int getTournamentsWon() {
            return tournamentsWon;
        }

        public double getAveragePrizePerWin() {
            if (tournamentsWon == 0) {
                return 0.0;
            }
            return prizeMoneyUSD / tournamentsWon;
        }

        @Override
        public String toString() {
            return String.format("ProEsportsPlayer{%s, team='%s', prize=$%.2f, wins=%d, avgPerWin=$%.2f}",
                    super.toString(), teamName, prizeMoneyUSD, tournamentsWon, getAveragePrizePerWin());
        }
    }
}
