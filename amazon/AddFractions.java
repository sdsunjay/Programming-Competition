import java.util.*;
import java.lang.*;
import java.io.*;
public class AddFractions
{


public static void main(String[] args) {
      Scanner oscan;
      Scanner scan = new Scanner (System.in);
      Scanner scanline;
      String s;
      String x;
      String x1;
      ArrayList<Fraction> farray = new ArrayList<Fraction>();
      Fraction f=null;
      Fraction f1=null;
      while(scan.hasNextLine())
      {
	 s= scan.nextLine();
	 oscan = new Scanner(s);
	 if(oscan.hasNext())
	       {
	 x=oscan.next();
	 x1=oscan.next();
	 oscan.useDelimiter(" ");
	 scanline = new Scanner(x);	 
	 scanline.useDelimiter("/");
	 if(scanline.hasNextInt())
	 {
	    Integer top = scanline.nextInt();
	    Integer bottom = scanline.nextInt();
	    f = new Fraction (top, bottom);
	    
	    // Integer top =scanline.nextInt();
	    //Integer bottom =scanline.nextInt();
	    //intArray.add(reduce(top,bottom)); 
	 }
	 scanline = new Scanner(x1);	 
	 scanline.useDelimiter("/");
	 if(scanline.hasNextInt())
	 {
	    Integer top = scanline.nextInt();
	    Integer bottom = scanline.nextInt();
	    f1 = new Fraction (top, bottom);
	       
	   // Integer top =scanline.nextInt();
	    //Integer bottom =scanline.nextInt();
	    //intArray.add(reduce(top,bottom)); 
	 }
	 int n=f1.numerator*f.denominator;
	 int n1=f.numerator*f1.denominator;
	 Fraction res= new Fraction(n+n1, f1.denominator*f.denominator);
	 farray.add(reduce(res.numerator,res.denominator));

	 //System.out.println(add(f,f1).toString());

	       }
	 else
	 {
	    break;
	 }
      }
 for(int i=0;i<farray.size();i++)
      {
	 System.out.println(farray.get(i).numerator+"/"+farray.get(i).denominator);
      }
}
public static class Fraction{
   public Integer numerator;
   public Integer denominator;
   public Fraction(Integer top, Integer bottom)
   {
      this.numerator=top;
      this.denominator=bottom;
   }

   public String toString(Fraction f)
   {
      return numerator.toString()+"/"+denominator.toString();
   }

}

public static Fraction reduce(Integer top, Integer bottom)
{
   boolean x = false;
   boolean y = false;
   int numerator = Math.abs(top);
   int denominator = Math.abs(bottom);

   if(numerator>denominator)
   {   
      x=true;
   }   
   if(numerator<=denominator)
   {   
      y=true;
   }   
   if((denominator==1) || (numerator==1))
   {	 
      return new Fraction(numerator,denominator);
   }
   else if (numerator==0)
   {
      return new Fraction(numerator,denominator);
      //denominator=1;
   }
   else if(x)
   {
      for(int i=denominator;i>=2;i--){
	 if(0==denominator%i){
	    if(0==numerator%i){
	       //return i;
	       numerator=numerator/i;
	       denominator=denominator/i;
	       return new Fraction(numerator,denominator);
	    }

	 }
      }

      return new Fraction(numerator,denominator);
   }
   else if(y)
   {
      for(int ii=numerator;ii>=2;ii--){
	 if(0==numerator%ii){
	    if(0==denominator%ii){
	       //return ii;
	       numerator=numerator/ii;
	       denominator=denominator/ii;
	       return new Fraction(numerator,denominator);
	    }
	 }

      }
      return new Fraction(numerator,denominator);
   }
   /* if (f*g<0)
      {
      numerator=-numerator;
      }*/
   return new Fraction(numerator,denominator);
}


}

