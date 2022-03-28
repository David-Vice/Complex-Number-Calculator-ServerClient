
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    ComplexNumber num1;
    ComplexNumber num2;
    
    Scanner sc= new Scanner(System.in);
    
    int port = 1099;
    if (args.length ==0)
	{
    	num1 = new ComplexNumber(3, 4);
    	num2 = new ComplexNumber(5, 7);
	}
    else 
	{
    	num1 = new ComplexNumber(Float.parseFloat(args[args.length-4]), Float.parseFloat(args[args.length-3]));
    	num2 = new ComplexNumber(Float.parseFloat(args[args.length-2]), Float.parseFloat(args[args.length-1]));
	}
    
    try 
    {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      
      int choice = -1;
      while(true)
      {
    	  System.out.print("Make your choice (1-add / 2-sub / 3-mult / 4-div): ");
    	  choice = sc.nextInt();
    	  if(choice == 0) break;
    	  else if(choice == 1)
    	  {
    		  Addition obj = (Addition)registry.lookup("ComplexAdd");
    	      (obj.Add(num1,num2)).Show();
    	  }
    	  else if(choice == 2)
    	  {
    		  Subtraction obj = (Subtraction)registry.lookup("ComplexSub");
    	      (obj.Subtract(num1,num2)).Show();  
    	  }
    	  else if(choice == 3)
    	  {
    		  Multiplication obj = (Multiplication)registry.lookup("ComplexMult");
    	      (obj.Multiply(num1,num2)).Show();
    	  }
    	  else if(choice == 4)
    	  {
    		  Division obj = (Division)registry.lookup("ComplexDiv");
    	      (obj.Divide(num1,num2)).Show();  
    	  }
      }
    } 
    
    catch (Exception e) 
    {
       System.out.println("Client exception: " +e);
    }
  }
}
