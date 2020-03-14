import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class client  {
    public static void main(String[] args) throws RemoteException {
        client c = new client();
        c.connectRemote();}
        private void connectRemote() throws RemoteException {
            try {
                Scanner sc = new Scanner(System.in);
                Registry reg = LocateRegistry.getRegistry("localhost", 2732);
                adder ad = (adder) reg.lookup("hi,server");
                System.out.println("Enter something:");
                String a = sc.nextLine();
                System.out.println("Conclusion is:" + ad.add(a));
            } catch (NotBoundException | RemoteException e) {
                System.out.println("Exception" + e);
            }
        }
    }