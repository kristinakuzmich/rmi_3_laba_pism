import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements adder {
public server() throws RemoteException{
}

    @Override
    public String add(String n1) throws RemoteException {
        String n2 = "";
        n2 = n2 + n1.substring(0, 1).toUpperCase(); //первый символ делаем заглавным
        for (int i = 1; i < n1.length(); i++) {
            // смотрим, был ли слева пробел:
            if (" ".equals(n1.substring(i-1, i)))
                n2 = n2 + n1.substring(i, i+1).toUpperCase();
            else
                n2 = n2 + n1.substring(i, i+1);}
        return n2;
    }


        public static void main(String[] args) throws RemoteException {
    try {
        final Registry reg = LocateRegistry.createRegistry(2732);
        reg.rebind("hi,server", new server());
        System.out.println("Server is ready");
    }catch (RemoteException e)
    {
        System.out.println("Exception"+e);
    }
    }
}