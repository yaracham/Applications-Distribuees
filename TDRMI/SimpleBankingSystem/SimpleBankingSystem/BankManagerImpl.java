import java.util.Hashtable;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class BankManagerImpl implements BankManager {
  private Hashtable accounts;
  private Hashtable clients;

  // public No-argument constructor
  public BankManagerImpl()
      throws java.rmi.RemoteException {
    initialize();
  }

  public Account getAccount(String accountNumber) 
      throws RemoteException {
    AccountImpl account = (AccountImpl)accounts.get(accountNumber);
    return account;
  }

  public Client getClient(String clientName) 
      throws RemoteException {
    ClientImpl client = (ClientImpl)clients.get(clientName);
    return client;
  }

  public void initialize()
      throws java.rmi.RemoteException {
    // Create the hashtables
    accounts = new Hashtable(20);
    clients  = new Hashtable(10);
    // Create clients and put them in the hashtable
    Client clientCharlie = new ClientImpl(this, "Yara");
    UnicastRemoteObject.exportObject(clientCharlie,0);
    Client clientShannon = new ClientImpl(this, "Shannon");
    UnicastRemoteObject.exportObject(clientShannon,0);
    clients.put("Yara", clientCharlie);
    clients.put("Shannon", clientShannon);

    // Create accounts:
    //     * put them into the hashtable
    //     * associate them with clients
    Account account;
    account = new AccountImpl(this, clientCharlie, "4434");
    ((AccountImpl)account).deposit(500);
    UnicastRemoteObject.exportObject(account,0);
    accounts.put("4434", account);
    account = new AccountImpl(this, clientCharlie, "4461");
    ((AccountImpl)account).deposit(600);
    UnicastRemoteObject.exportObject(account,0);
    accounts.put("4461", account);
    account = new AccountImpl(this, clientShannon, "6678");
    ((AccountImpl)account).deposit(700);
    UnicastRemoteObject.exportObject(account,0);
    accounts.put("6678", account);
  }
}
