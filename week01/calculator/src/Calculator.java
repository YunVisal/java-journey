import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Operator: ");
        String operator = scanner.nextLine();

        System.out.print("Second number: ");
        double b = Double.parseDouble(scanner.nextLine());

        double answer = 0;
        switch (operator){
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
            case "/":
                if(b == 0) {
                    System.out.println("Cannot divide by 0");
                    return;
                }
                answer = a / b;
                break;
            case "%":
                if(b == 0) {
                    System.out.println("Cannot modulo by 0");
                    return;
                }
                answer = a % b;
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }
        System.out.printf("Answer: %.2f%n", answer);
    }
}
