import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SystemInfo extends Remote {
    double getCPUUsage() throws RemoteException;
    double getDiskSpace() throws RemoteException;
}

