import java.rmi.Naming;

public class SystemInfoClient {
    public static void main(String[] args) {
        try {
            SystemInfo sysInfo = (SystemInfo) Naming.lookup("rmi://localhost/SystemInfo");
            System.out.println("CPU Usage: " + sysInfo.getCPUUsage() + "%");
            System.out.println("Free Disk Space: " + sysInfo.getDiskSpace() + " GB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

