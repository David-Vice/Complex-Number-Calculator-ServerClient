package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Addition extends Remote {
	public ComplexNumber Add(ComplexNumber cn1, ComplexNumber cn2) throws RemoteException;
}
