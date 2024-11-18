import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public double calculate(double operand1, double operand2, String operator) throws RemoteException;
}

