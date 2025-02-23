import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer {

    public static void main(String args[]) {
        byte pattern = (byte) 0xAC;
        try {
            // Create remote object
            HelloImpl obj = new HelloImpl();

            // Create custom socket factories
            RMIClientSocketFactory csf = new XorClientSocketFactory(pattern);
            RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern);

            // Export the remote object with custom socket factories
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0, csf, ssf);

            // Create a registry and bind the stub in the registry
            LocateRegistry.createRegistry(2002);
            Registry registry = LocateRegistry.getRegistry(2002);
            registry.rebind("Hello", stub);

            System.out.println("HelloServer is running and bound in registry");

        } catch (Exception e) {
            System.out.println("HelloServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}