import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Lookup the remote Calculator service
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost:1098/CalculatorService");
            
            // Create a Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt user for the first operand
            System.out.print("Enter first operand: ");
            double operand1 = scanner.nextDouble();

            // Prompt user for the second operand
            System.out.print("Enter second operand: ");
            double operand2 = scanner.nextDouble();

            // Prompt user for the operator
            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.next();

            // Call the remote method
            double result = calc.calculate(operand1, operand2, operator);

            // Print the result
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

