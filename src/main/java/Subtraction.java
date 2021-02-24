public class Subtraction extends Operation {
    public Subtraction(double left, double right) {
        super(left, right);
    }

    @Override
    public String execute() {
        result = a - b;
        return Double.toString(result);
    }
}
