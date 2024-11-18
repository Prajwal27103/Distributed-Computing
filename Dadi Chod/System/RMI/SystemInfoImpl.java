import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SystemInfoImpl extends UnicastRemoteObject implements SystemInfo {
    protected SystemInfoImpl() throws RemoteException {
        super();
    }

    @Override
    public double getCPUUsage() throws RemoteException {
        try {
            Process process = Runtime.getRuntime().exec("top -bn1 | grep 'Cpu(s)' | awk '{print $2}'");
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            return s.hasNextDouble() ? s.nextDouble() : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public double getDiskSpace() throws RemoteException {
        return new java.io.File("/").getFreeSpace() / (1024.0 * 1024.0 * 1024.0);  // GB
    }

    public static void main(String[] args) {
        try {
            SystemInfo obj = new SystemInfoImpl();
            Naming.rebind("rmi://localhost/SystemInfo", obj);
            System.out.println("SystemInfo Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

