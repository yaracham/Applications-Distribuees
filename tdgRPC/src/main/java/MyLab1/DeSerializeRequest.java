package MyLab1;

import java.io.FileInputStream;
import java.io.IOException;

public class DeSerializeRequest {
    public static void main (String [] args)
    {
        try{
            FileInputStream f=new FileInputStream("td1.ser");

            HelloRequest h = HelloRequest.parseFrom(f);
            // Create a HelloRequest with the greeting message.
            System.out.println(h.getGreeting());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}