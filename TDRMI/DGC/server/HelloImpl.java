package server;

import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject 
implements Hello, Unreferenced
{

   public HelloImpl() throws RemoteException
   {
      super();
   }

   public String sayHello() throws RemoteException
   {
     return "server.Hello!";

   }

   public MessageObjectSer getMessageObject() throws RemoteException
   {
      MessageObjectSer mo = new MessageObjectImplSer();

      return mo;
   }

   public void unreferenced()
   {
      System.out.println( "server.HelloImpl: Unreferenced" );
   }

   public void finalize() throws Throwable
   {
      super.finalize();

      System.out.println( "server.HelloImpl: Finalize called" );
   }
}
