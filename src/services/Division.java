
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Division extends Remote {
	public ComplexNumber Divide(ComplexNumber cn1, ComplexNumber cn2) throws RemoteException;
}
