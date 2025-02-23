package client;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
   public String        sayHello()         throws RemoteException;

   public MessageObjectSer getMessageObject() throws RemoteException;

}
