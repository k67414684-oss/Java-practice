package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task21 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task21: DataCenterCluster ---");
        DataCenterCluster cluster = new DataCenterCluster("Київ-1", 4);
        cluster.addNode(new ServerNode("10.0.0.1", 64, 60, true));
        cluster.addNode(new ServerNode("10.0.0.2", 128, 0, false));
        cluster.addNode(new ServerNode("10.0.0.3", 32, 8, true));
        System.out.println(cluster);
        System.out.println("Контейнер 16 ГБ: " + cluster.deployContainer(16));
        System.out.println("Контейнер 16 ГБ: " + cluster.deployContainer(16));
        System.out.println("Контейнер 16 ГБ: " + cluster.deployContainer(16));
        System.out.println(cluster);
    }

    static class ServerNode {
        private final String ipAddress;
        private final int totalRamGb;
        private int usedRamGb;
        private boolean online;

        public ServerNode(String ipAddress, int totalRamGb, int usedRamGb, boolean online) {
            this.ipAddress = ipAddress;
            this.totalRamGb = Math.max(1, totalRamGb);
            this.usedRamGb = Math.max(0, Math.min(this.totalRamGb, usedRamGb));
            this.online = online;
        }

        public int getFreeRamGb() {
            return totalRamGb - usedRamGb;
        }

        public boolean isOnline() {
            return online;
        }

        public boolean allocate(int ramGb) {
            if (!online || ramGb <= 0 || ramGb > getFreeRamGb()) {
                return false;
            }
            usedRamGb += ramGb;
            return true;
        }

        @Override
        public String toString() {
            return ipAddress + " [" + (online ? "online" : "OFFLINE") + ", RAM " + usedRamGb + "/" + totalRamGb + " ГБ]";
        }
    }

    static class DataCenterCluster {
        private final String clusterLocation;
        private final ServerNode[] nodes;
        private int nodeCount;

        public DataCenterCluster(String clusterLocation, int capacity) {
            this.clusterLocation = clusterLocation;
            this.nodes = new ServerNode[Math.max(1, capacity)];
        }

        public boolean addNode(ServerNode node) {
            if (node == null || nodeCount >= nodes.length) {
                return false;
            }
            nodes[nodeCount++] = node;
            return true;
        }

        public boolean deployContainer(int requiredRamGb) {
            for (int i = 0; i < nodeCount; i++) {
                if (nodes[i].isOnline() && nodes[i].getFreeRamGb() >= requiredRamGb) {
                    return nodes[i].allocate(requiredRamGb);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Кластер '" + clusterLocation + "':");
            for (int i = 0; i < nodeCount; i++) {
                sb.append("\n  ").append(nodes[i]);
            }
            return sb.toString();
        }
    }
}
