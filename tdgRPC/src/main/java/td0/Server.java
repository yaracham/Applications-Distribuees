package td0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    MyUser user = MyUser.newBuilder()
                            .setEmail("john.doe@example.com")
                            .setYearOfBirth(1980)
                            .build();

                    OutputStream outputStream = socket.getOutputStream();
                    user.writeTo(outputStream);
                    outputStream.flush();
                    user.writeTo(new FileOutputStream("td1.ser"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}