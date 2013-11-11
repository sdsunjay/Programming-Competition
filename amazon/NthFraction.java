import java.util.*;
import java.lang.*;
import java.io.*;
public class NthFraction
{


 public static void main(String[] args) {
      ArrayList<Fraction> outarray = new ArrayList<Fraction>();
      Scanner scan = new Scanner (System.in);
      Scanner scanline;
      String s;
      ArrayList<Fraction> farray = new ArrayList<Fraction>();
      ArrayList<Fraction> infarray = new ArrayList<Fraction>();
      Fraction f=null;
      Fraction f1=null;
      Integer times=null;
      Integer bottom=null;
      while(scan.hasNextLine())
      {
	 s= scan.nextLine();
	 scanline = new Scanner(s);
	 if(scanline.hasNextInt())
	 {
	    times =scanline.nextInt();
	    bottom =scanline.nextInt();
	    infarray.add(new Fraction(1,bottom));
	 }
	 else
	 {
	    break;
	 }
      } 

      for(int g=0;g<infarray.size();g++)
      {
	    int n=infarray.get(g).numerator*infarray.get(g).denominator;
	    int n1=infarray.get(g).numerator*infarray.get(g).denominator;
	    Fraction ouch=new Fraction(n+n1, infarray.get(g).denominator*infarray.get(g).denominator);

	 outarray.add(0,ouch);
	 for(int i=1;i<times-1;i++)
	 {
	    int n5=infarray.get(g).numerator*outarray.get(i-1).denominator;
	    int n6=outarray.get(i-1).numerator*infarray.get(g).denominator;
	    Fraction ouch1=new Fraction(n5+n6, infarray.get(g).denominator.out);
	    outarray.add(ouch1);
	    System.out.println(outarray.toString());	 
	    //farray.add(reduce(res.numerator,res.denominator));
	 }
	    farray.add(reduce(outarray.get(outarray.size()-1).numerator,outarray.get(outarray.size()-1).denominator));
	    outarray.clear();
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

