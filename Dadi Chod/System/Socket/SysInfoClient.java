import java.io.*;
import java.net.*;

public class SysInfoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";

        try (Socket socket = new Socket(serverAddress, 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server. Retrieving system information...");
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

