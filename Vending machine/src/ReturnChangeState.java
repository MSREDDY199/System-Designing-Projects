public class ReturnChangeState implements MachineState {
    public final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already dispensed");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Product already dispensed");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Product already dispensed");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();

        if (change > 0) {
            System.out.println("Change returned: ₹ " + change);
            vendingMachine.resetPayment();
        } else {
            System.out.println("No change to return");
        }

        vendingMachine.resetSelectedProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
