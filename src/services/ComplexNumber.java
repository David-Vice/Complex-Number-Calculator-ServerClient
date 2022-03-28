
import java.io.Serializable;

public class ComplexNumber implements Serializable {
   private float real;
   private float imaginary;
   
   public ComplexNumber(float real, float imaginary) {
      this.real = real;
      this.imaginary = imaginary;
   }
   
   public ComplexNumber() {
   }
   
   public void Show()
   {
	   System.out.println("("+real+")+("+imaginary+"i)");
   }

   public float getReal() {
      return this.real;
   }
   public float getImaginary() {
      return this.imaginary;
   }
   public void setReal(float real) {
	   this.real = real;
   }
   public void setImaginary(float imaginary) {
	   this.imaginary = imaginary;
   }
}
