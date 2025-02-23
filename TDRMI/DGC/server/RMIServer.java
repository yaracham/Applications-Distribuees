package server;

import java.net.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 * server.RMIServer acts as a server for the remote "HelloService" service.
 *
 * server.RMIServer starts execution at the standard entry point "public static void main";
 * It creates an instance of itself and continues processing in the constructor.
 *
 */

public class RMIServer
{
   private static final int    PORT        = 2025;

//
// -> Change the name to your own computer name
//
   private static final String HOST_NAME   = "127.0.0.1";


   // Instance of ourselves
   private static RMIServer  rmi;

   public static void main ( String[] args )
   {
// We need to set the security manager to the RMISecurityManager
   //   System.setSecurityManager( new RMISecurityManager() );

      try
      {
         rmi = new RMIServer();
      }
      catch ( java.rmi.UnknownHostException uhe )
      {
         System.out.println( "The host computer name you have specified, " + HOST_NAME + " does not match your real computer name." );

      }
      catch ( RemoteException re )
      {
         System.out.println( "Error starting service" );
         System.out.println( "" + re );
      }
      catch ( MalformedURLException mURLe )
      {
         System.out.println( "Internal error" + mURLe );
      }
      catch ( NotBoundException nbe )
      {
         System.out.println( "Not Bound" );
         System.out.println( "" + nbe );
      }

   }  // main


   // Constructor
   public RMIServer() throws RemoteException, MalformedURLException, NotBoundException
   {
      LocateRegistry.createRegistry( PORT );

      System.out.println( "Registry created on host computer " + HOST_NAME + " on port " + Integer.toString( PORT) );

      Hello hello = new HelloImpl();

      System.out.println( "Remote HelloService implementation object created" );

      String urlString = "//" + HOST_NAME + ":" + Integer.toString( PORT ) + "/" + "server.Hello";

      Naming.rebind( urlString, hello );

      System.out.println( "Bindings Finished, waiting for client requests." );
   }

}  // class server.RMIServer


