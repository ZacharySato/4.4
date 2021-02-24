public class Sum extends Operation {
    public Sum(double left, double right) {
        super(left, right);
    }

    @Override
    public String execute() {
        result = a + b;
        return  Double.toString(result);
    }
}
