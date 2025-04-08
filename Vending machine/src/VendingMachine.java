public class VendingMachine {
    public static VendingMachine instance;
    Inventory inventory;
    public final MachineState idleState;
    public final MachineState readyState;
    public final MachineState dispenseState;
    public final MachineState returnChangeState;
    public MachineState currentState;
    public Product selectedProduct;
    public double totalPayment;

    public VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setCurrentState(MachineState state) {
        currentState = state;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void addCoin (Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote (Note note) {
        totalPayment += note.getValue();
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public MachineState getReturnChangeState() {
        return returnChangeState;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public MachineState getReadyState() {
        return readyState;
    }

    public void resetPayment() {
        totalPayment = 0.0;
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public double getTotalPayment() {
        return totalPayment;
    }
}
