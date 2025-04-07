package MyLab1;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
//import com.example.grpc.HelloRequest;
//import com.example.grpc.HelloResponse;
//import com.example.grpc.HelloServiceGrpc;

/**
 * `HelloClient` class starts a gRPC client that calls the gRPC server for the
 HelloService.
 *
 * This client sends a HelloRequest to the server and receives a HelloResponse in return.
 */
public class HelloClient {

    // The host and port of the gRPC server.
    private static final String HOST = "localhost";
    private static final int PORT = 50051;

/**
 * Starts the gRPC client and makes a request to the gRPC server.
 *
 * @param greeting The greeting message to send to the server.
 * @return Returns the reply message received from the server.
 */
public String sayHello(String greeting) {
    // Create a channel to connect to the gRPC server.
    ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, PORT)
            .usePlaintext()
            .build();

    // Create a stub for the HelloService using the channel.
    HelloServiceGrpc.HelloServiceBlockingStub stub =
            HelloServiceGrpc.newBlockingStub(channel);

    // Create a HelloRequest with the greeting message.
    HelloRequest request = HelloRequest.newBuilder()
            .setGreeting(greeting)
            .build();

    // Call the SayHello RPC method on the server and get the response.
    HelloResponse response = stub.sayHello(request);

    // Close the channel.
    channel.shutdown();

    // Return the reply message from the server.
    return response.getReply();
}

    /**
     * Main method to start the gRPC client and make a request to the gRPC server.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the HelloClient.
        HelloClient client = new HelloClient();

        // Make a request to the gRPC server.
        String greeting = "Hello gRPC Server!";
        String reply = client.sayHello(greeting);

        // Print the reply message received from the server.
        System.out.println("Server replied: " + reply);
    }
}