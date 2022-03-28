package services;

import java.io.Serializable;

public class SubtractionImpl implements Subtraction {
   public ComplexNumber Subtract(ComplexNumber cn1, ComplexNumber cn2) 
   {
      ComplexNumber cnResult = new ComplexNumber();
      cnResult.setReal(cn1.getReal() - cn2.getReal());
      cnResult.setImaginary(cn1.getImaginary() - cn2.getImaginary());
      return cnResult;
   }
}
