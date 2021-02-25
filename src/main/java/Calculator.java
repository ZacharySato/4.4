import java.util.Scanner;

public class Calculator {

    private static final String esc = "Выкл";
    private static final String escM = "Для завершения работы введите \"" + esc + "\"";
    String operator;
    double operandA;
    double operandB;
    boolean off = false;
    boolean valid;

    public void run() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Для рассчета введите выражение в формате ОПЕРАНД ОПЕРАТОР ОПЕРАНД, например \"2 + 6\" \n" + escM);
        while (!off) {
            Scanner stream = new Scanner(System.in);
            String input;
            input = stream.nextLine();
            input = input.replaceAll(" ", "");
            checkInput(input);
            if (valid) {
                splitInput(input);
                switch (operator) {
                    case ("+"):
                        Operation sum = new Sum(operandA, operandB);
                        System.out.println(sum.execute());
                        break;
                    case ("-"):
                        Operation sub = new Subtraction(operandA, operandB);
                        System.out.println(sub.execute());
                        break;
                    case ("*"):
                        Operation multi = new Multiplication(operandA, operandB);
                        System.out.println(multi.execute());
                        break;
                    case ("/"):
                        Operation div = new Division(operandA, operandB);
                        System.out.println(div.execute());
                        break;
                    default:
                        break;
                }
            }
        }

    }

    private void checkInput(String input) {
        if (input.equals(esc)) {
            System.out.println("Завершение работы");
            off = true;
            valid = false; //костыль
        } else {
            valid = input.matches("^[\\-]?[0-9]+(?:[.][0-9]*)?[\\-\\+\\*\\/][\\-]?[0-9]+(?:[.][0-9]*)?$");
            if (!valid)
                System.out.println("Некорректный ввод, формат должен соответствовать ОПЕРАНД ОПЕРАТОР ОПЕРАНД, например \"8 * 16.5\" \n" + escM);
        }
    }

    private void splitInput(String input) {
        String operandBInput = input.replaceAll("^[\\-]?[0-9]+(?:[.][0-9]*)?[\\-\\+\\*\\/]", "");
        input = input.replaceAll(operandBInput + "$", "");
        this.operator = input.replaceAll("^[\\-]?[0-9]+(?:[.][0-9]*)?", "");
        String operandAInput = input.substring(0, input.length() - 1);
        this.operandA = Double.parseDouble(operandAInput);
        this.operandB = Double.parseDouble(operandBInput);
    }

    public static void main(String[] args) {
        Calculator test = new Calculator();
        test.run();
    }
}
