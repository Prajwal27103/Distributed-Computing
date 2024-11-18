import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double calculate(double operand1, double operand2, String operator) throws RemoteException {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand2 != 0 ? operand1 / operand2 : Double.NaN;
            default:
                return 0.0;
        }
    }
}

