package practice10;

interface PrintableDocument { String formatForPrinter(); }
final class FiscalReceipt implements PrintableDocument {
    private final String fiscalNumber;
    private final double totalAmount;
    private final double vatAmount;

    public FiscalReceipt(String fiscalNumber, double totalAmount) {
        this.fiscalNumber = fiscalNumber;
        this.totalAmount = totalAmount;
        this.vatAmount = totalAmount * 0.20;
    }
    @Override public String formatForPrinter() {
        return String.format("ФІСКАЛЬНИЙ ЧЕК #%s | Разом: %.2f грн (ПДВ 20%%: %.2f грн)", fiscalNumber, totalAmount, vatAmount);
    }
}
class WarehouseReport implements PrintableDocument {
    private final String title;
    public WarehouseReport(String title) { this.title = title; }
    @Override public String formatForPrinter() { return "СКЛАДСЬКИЙ ЗВІТ: " + title; }
}

public class Ex36 {
    public static void main(String[] args) {
        PrintableDocument[] queue = {
                new FiscalReceipt("FN-987654", 1500.0),
                new WarehouseReport("Інвентаризація №4")
        };
        for (PrintableDocument doc : queue) System.out.println(doc.formatForPrinter());
    }
}
