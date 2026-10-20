package practice6;

public class Task2WarehouseInventory {
    public static void main(String[] args) {
        String[] items = {"Ноутбук", "Смартфон", "Бездротові навушники", "Механічна клавіатура", "Монітор"};
        int[] quantities = {8, 3, 25, 4, 12};
        double[] prices = {28500.0, 19200.0, 1850.0, 3100.0, 9400.0};

        double[] totalValues = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            totalValues[i] = quantities[i] * prices[i];
        }

        System.out.println("№ | Назва товару | Кількість | Ціна за шт. | Сумарна вартість");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " | " + items[i] + " | " + quantities[i] + " | " + prices[i] + " | " + totalValues[i]);
        }

        double totalAssets = 0;
        for (int i = 0; i < totalValues.length; i++) {
            totalAssets += totalValues[i];
        }
        System.out.println("Сумарна вартість усіх активів: " + totalAssets);

        int maxIndex = 0;
        for (int i = 1; i < totalValues.length; i++) {
            if (totalValues[i] > totalValues[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Найбільша грошова сума запасів у позиції: " + items[maxIndex]);

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] < 5) {
                System.out.println(items[i] + " - ⚠️ УВАГА: Терміново замовити постачальнику!");
            }
        }
    }
}
