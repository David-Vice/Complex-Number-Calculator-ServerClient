public class AdditionImpl implements Addition {
   public ComplexNumber Add(ComplexNumber cn1, ComplexNumber cn2) 
   {
      ComplexNumber cnResult = new ComplexNumber();
      cnResult.setReal(cn1.getReal() + cn2.getReal());
      cnResult.setImaginary(cn1.getImaginary() + cn2.getImaginary());
      return cnResult;
   }
}
