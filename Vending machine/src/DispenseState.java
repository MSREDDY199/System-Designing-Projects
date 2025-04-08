public class DispenseState implements MachineState {
    public final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected, please take your product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Amount already inserted, please take your product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Amount already inserted, please take your product");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Please take your "+product.getName());
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("No Change to return");
    }
}
