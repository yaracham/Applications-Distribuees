package MyLab1;

import java.io.FileOutputStream;
import java.io.IOException;


public class SerializeRequest {
    public static void main (String [] args)
    {
        // Create a HelloRequest with the greeting message.
        HelloRequest request = HelloRequest.newBuilder()
                .setGreeting("youhou")
                .build();
        try {
            request.writeTo(new FileOutputStream("td1.ser"));
        }
        catch(IOException e) {}

    }
}