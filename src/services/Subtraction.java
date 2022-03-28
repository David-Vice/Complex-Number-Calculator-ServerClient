package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subtraction extends Remote {
	public ComplexNumber Subtract(ComplexNumber cn1, ComplexNumber cn2) throws RemoteException;
}
