package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1) port = Integer.parseInt(args[0]);
    
    try 
    {
      Addition skeletonAddition = (Addition)UnicastRemoteObject.exportObject(new AdditionImpl(), 0);
      Subtraction skeletonSubtraction = (Subtraction)UnicastRemoteObject.exportObject(new SubtractionImpl(), 0);
      Multiplication skeletonMultiplication = (Multiplication)UnicastRemoteObject.exportObject(new MultiplicationImpl(), 0);
      Division skeletonDivision = (Division)UnicastRemoteObject.exportObject(new DivisionImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      
      if(!Arrays.asList(registry.list()).contains("ComplexAdd"))
        registry.bind("ComplexAdd", skeletonAddition);
      else
        registry.rebind("ComplexAdd", skeletonAddition);
      
      if(!Arrays.asList(registry.list()).contains("ComplexSub"))
          registry.bind("ComplexSub", skeletonSubtraction);
      else
    	  registry.rebind("ComplexSub", skeletonSubtraction);
      
      if(!Arrays.asList(registry.list()).contains("ComplexMult"))
          registry.bind("ComplexMult", skeletonMultiplication);
      else
    	  registry.rebind("ComplexMult", skeletonMultiplication);
      
      if(!Arrays.asList(registry.list()).contains("ComplexDiv"))
          registry.bind("ComplexDiv", skeletonDivision);
      else
    	  registry.rebind("ComplexDiv", skeletonDivision);
      
      System.out.println("Services are activated");
    } 
    
    catch (Exception e) 
    {
      System.out.println(e);
    }
  }
}
