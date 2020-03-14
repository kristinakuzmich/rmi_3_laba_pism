import java.rmi.*;

public interface adder extends Remote {
    public String add(String n1) throws RemoteException;
}