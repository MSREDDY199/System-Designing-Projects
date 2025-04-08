public class ReadyState implements MachineState {

    public final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected: "+product.getName());
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: ₹ " + coin.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: ₹ " + note.getValue());
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make the payment");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make the payment");
    }

    public void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }
}
