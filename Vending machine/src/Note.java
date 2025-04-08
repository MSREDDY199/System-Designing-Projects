public enum Note {
    TEN(10.0),
    TWENTY(20.0),
    FIFTY(50.0),
    HUNDRED(100.0);

    public final double value;

    Note(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
