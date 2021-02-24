public class Operation {
    double a;
    double b;
    double result;

    public Operation(double left, double right) {
        this.a = left;
        this.b = right;
    }

    public String execute() {
        return "Операция не поддерживается, попробуйте +, *, - или  даже /";
    }
}