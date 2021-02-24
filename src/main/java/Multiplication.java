public class Multiplication extends Operation {
    public Multiplication(double left, double right) {
        super(left, right);
    }

    @Override
    public String execute() {
        result = a * b;
        return Double.toString(result);
    }
}
