
import java.util.*;
import java.lang.*;
import java.io.*;
public class GCD
{
   public static void main(String[] args) {
      Scanner scan = new Scanner (System.in);
      Scanner scanline;
      String s;
      ArrayList<Integer> intArray = new ArrayList<Integer>();
      while(scan.hasNextLine())
      {
	 s= scan.nextLine();
	 scanline = new Scanner(s);
	 if(scanline.hasNextInt())
	 {
	 Integer top =scanline.nextInt();
	 Integer bottom =scanline.nextInt();
	 intArray.add(reduce(top,bottom)); 
	 }
	 else
	 {
	    break;
	 }
      }
      for(int i=0;i<intArray.size();i++)
      {
	 System.out.println(intArray.get(i));
      }

   }

   public static Integer reduce(Integer top, Integer bottom)
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
	 return 1;
      }
      else if (numerator==0)
      {
	 return 1;
	 //denominator=1;
      }
      else if(x)
      {
	 for(int i=denominator;i>=2;i--){
	    if(0==denominator%i){
	       if(0==numerator%i){
		  return i;
		  //numerator=numerator/i;
		  //denominator=denominator/i;
	       }
	       
	    }
	 }

		  return 1;
      }
      else if(y)
      {
	 for(int ii=numerator;ii>=2;ii--){
	    if(0==numerator%ii){
	       if(0==denominator%ii){
		  return ii;
		  //numerator=numerator/ii;
		  //denominator=denominator/ii;
	       }
	    }

	 }
		  return 1;
      }
     /* if (f*g<0)
      {
	 numerator=-numerator;
      }*/
      return 1;
   }
}




