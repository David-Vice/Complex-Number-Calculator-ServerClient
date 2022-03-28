
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multiplication extends Remote {
	public ComplexNumber Multiply(ComplexNumber cn1, ComplexNumber cn2) throws RemoteException;
}
