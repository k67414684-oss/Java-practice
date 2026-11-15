package practice10;

interface Authenticatable { boolean verifySignature(String key); }
interface Auditable { String getAuditTrail(); }
interface BlockchainSmartContract extends Authenticatable, Auditable { boolean executeContract(double gasLimit); }

class EscrowSmartContract implements BlockchainSmartContract {
    @Override public boolean verifySignature(String key) { return key != null && key.startsWith("0x"); }
    @Override public String getAuditTrail() { return "AuditLog[TxVerified, Ready]"; }
    @Override public boolean executeContract(double gasLimit) { return gasLimit >= 21000; }
}

public class Ex14 {
    public static void main(String[] args) {
        BlockchainSmartContract sc = new EscrowSmartContract();
        System.out.println("Підпис: " + sc.verifySignature("0x71C89A"));
        System.out.println("Аудит: " + sc.getAuditTrail());
        System.out.println("Виконання: " + sc.executeContract(50000));
    }
}
