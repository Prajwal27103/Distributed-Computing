import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            CalculatorImpl calc = new CalculatorImpl();
            LocateRegistry.createRegistry(1098); // Start RMI registry on port 1099
            Naming.rebind("rmi://localhost:1098/CalculatorService", calc);
            System.out.println("Calculator Service is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

