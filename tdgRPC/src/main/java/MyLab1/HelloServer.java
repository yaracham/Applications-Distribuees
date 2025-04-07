package MyLab1;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * `HelloServer` class starts a gRPC server for the HelloService.
 *
 * This server listens for incoming requests and responds with a greeting message.
 */
public class HelloServer {

    private final int port;
    private final Server server;

/**
 * Constructor to initialize the server port and create a new gRPC server.
 *
 * @param port The port number on which the server will listen for incoming requests.
 */
public HelloServer(int port) {
    this.port = port;
    this.server = ServerBuilder.forPort(port).addService(new
            HelloServiceImpl()).build();
}

    /**
     * Starts the gRPC server and waits for it to be terminated.
     *
     * @throws Exception if there is an error starting the server.
     */
    public void start() throws Exception {
        server.start();
        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }

    /**
     * Stops the gRPC server.
     */
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Main method to start the gRPC server on a specified port.
     *
     * @param args The command line arguments. The first argument should be the port
    number.
     * @throws Exception if there is an error starting the server.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            System.err.println("Usage: HelloServer <port>");
            System.exit(1);
        }

        int port = Integer.parseInt("50051");
        HelloServer server = new HelloServer(50051);
        server.start();
    }

    /**
     * `HelloServiceImpl` class implements the HelloService gRPC service.
     *
     * This class handles the SayHello RPC method and responds with a greeting message.
     */
    private static class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

/**
 * Handles the SayHello RPC method.
 *
 * This method takes a HelloRequest message as input and responds with a
 HelloResponse message.
 *
 * @param request The HelloRequest message containing the greeting.
 * @param responseObserver The response observer to send the HelloResponse
message.
 */
@Override
public void sayHello(HelloRequest request, StreamObserver<HelloResponse>
        responseObserver) {
    // Get the greeting from the request message
    String greeting = request.getGreeting();

    // Create the reply message with the greeting
    String reply = "Hello, " + greeting + "!";

    // Build the HelloResponse message
    HelloResponse response = HelloResponse.newBuilder().setReply(reply).build();

    // Send the response message to the client
    responseObserver.onNext(response);

    // Complete the RPC call
    responseObserver.onCompleted();
}
    }
}