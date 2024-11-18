import java.io.*;
import java.net.*;

public class SysInfoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                double cpuUsage = getCPUUsage();
                double memoryUsage = getMemoryUsage();

                out.println("CPU Usage: " + cpuUsage + "%");
                out.println("Memory Usage: " + memoryUsage + "%");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getCPUUsage() {
        try {
            Process process = Runtime.getRuntime().exec("top -bn1 | grep 'Cpu(s)' | awk '{print $2}'");
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            return s.hasNextDouble() ? s.nextDouble() : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static double getMemoryUsage() {
        try {
            Process process = Runtime.getRuntime().exec("free | grep Mem | awk '{print ($3/$2)*100}'");
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            return s.hasNextDouble() ? s.nextDouble() : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

