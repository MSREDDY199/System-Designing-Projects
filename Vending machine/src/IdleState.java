public class IdleState implements MachineState {

    public final VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.inventory.isProductAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + product.getName());
        } else {
            System.out.println("Product unavailable: " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select the product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select the product");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select the product");
    }

    @Override
    public void returnChange() {
        System.out.println("Select the product");
    }
}
