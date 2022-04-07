import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Client {
	float r1, i1, r2, i2;
	char sign;
	public Client(float _r1, float _i1, float _r2, float _i2, char _sign)
	{
		r1 = _r1;
		i1 = _i1;
		r2 = _r2;
		i2 = _i2;
		sign = _sign;
	}
  public String Calculate()
  {
	  ComplexNumber num1 = new ComplexNumber(r1, i1);
	  ComplexNumber num2 = new ComplexNumber(r2, i2);
	  String machine = "localhost";

	  int port = 1099;

	  try {
		  Registry registry = LocateRegistry.getRegistry(machine, port);

		  if (sign == '+') {
			  Addition obj = (Addition) registry.lookup("ComplexAdd");
			  return (obj.Add(num1, num2)).GetAnswer();
		  } else if (sign == '-') {
			  Subtraction obj = (Subtraction) registry.lookup("ComplexSub");
			  return (obj.Subtract(num1, num2)).GetAnswer();
		  } else if (sign == '*') {
			  Multiplication obj = (Multiplication) registry.lookup("ComplexMult");
			  return (obj.Multiply(num1, num2)).GetAnswer();
		  } else if (sign == '/') {
			  if(DivisionByZero(r2, i2))
			  {
				  Division obj = (Division) registry.lookup("ComplexDiv");
				  return (obj.Divide(num1, num2)).GetAnswer();
			  }
			  else
				  return "Division by zero!";
		  }
	  }
	  catch (Exception e) {
		  System.out.println("Client exception: " + e);
	  }
	  return "Empty";
  }
  public boolean DivisionByZero(float r2, float i2)
  {
	  return r2 != 0 || i2 != 0;
  }
}
