import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите арифметическое выражение (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            int operand1 = Integer.parseInt(tokens[0]);
            int operand2 = Integer.parseInt(tokens[2]);

            if (operand1 < 1 || operand1 > 10|| operand2 < 1|| operand2 > 10){
                break;
            }

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String result = calc(input);
            if (result.startsWith("Ошибка")) {
                   System.out.println(result);
                break;
            }
            System.out.println("Результат: " + result);
        }
    }

    static String calc(String input) {
        try {
            String[] tokens = input.split(" ");
            int operand1 = Integer.parseInt(tokens[0]);
            int operand2 = Integer.parseInt(tokens[2]);
            String operator = tokens[1];

            double result = 0.0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                default:
                    return "Ошибка: неверный оператор!";


            }

            return String.valueOf(result);
        } catch (Exception e) {
            return "Ошибка: неверный формат ввода!";
        }
    }
}