public class Division extends Operation {
    public Division(double left, double right) {
        super(left, right);
    }

    @Override
    public String execute() {
        if (b == 0)
            return "Делений на ноль тут не любят";
        result = a / b;
        return Double.toString(result);
    }
}
