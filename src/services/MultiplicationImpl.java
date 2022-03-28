
import java.io.Serializable;

public class MultiplicationImpl implements Multiplication {
   public ComplexNumber Multiply(ComplexNumber cn1, ComplexNumber cn2) 
   {
      ComplexNumber cnResult = new ComplexNumber();
      
      cnResult.setReal(cn1.getReal()*cn2.getReal()-cn1.getImaginary()*cn2.getImaginary());
      cnResult.setImaginary(cn1.getImaginary()*cn2.getReal() + cn1.getReal()*cn2.getImaginary());
      
      return cnResult;
   }
}
