//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// reference git-hub repository: https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/vendingmachine
public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product coke = new Product("1", "Coke", 40.0);
        Product fanta = new Product("2", "Fanta", 35.0);

        vendingMachine.inventory.addProduct(coke, 20);
        vendingMachine.inventory.addProduct(fanta, 10);

        vendingMachine.selectProduct(coke);

        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertNote(Note.TEN);
        vendingMachine.insertNote(Note.FIFTY);

        vendingMachine.dispenseProduct();

        vendingMachine.returnChange();
    }
}