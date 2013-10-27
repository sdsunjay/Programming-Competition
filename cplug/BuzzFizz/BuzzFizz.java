/*CPLUG PROGRAMMING COMPETITION
 * 10/26/13
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;  
import java.util.Scanner;
public class BuzzFizz{
   public static void main(String[] args) {
      //Scanner oscan;
      Scanner scan = new Scanner (System.in);
      int first = scan.nextInt();
      int length = scan.nextInt();
      int[] numbers= new int[length];
      String[] words= new String[length];
      PairMe[] pairs = new PairMe[length]; 
      for(int i =0;i<length;i++)
      {
	 Integer d = new Integer(scan.nextInt());
	 pairs[i] = new PairMe();
	 pairs[i].setNum(d);
	 pairs[i].setStr(scan.next());
      }

      boolean flag = false;


   Arrays.sort(pairs, new Comparator<PairMe>(){

      @Override
      public int compare(PairMe arg0, PairMe arg1) {
      // TODO Auto-generated method stub
      return arg0.num.compareTo(arg1.num);
      }
   });



      for(int i=1;i<=first;i++)
      {
	 for(int ii=0;ii<length;ii++)
	 {
	    if(i==pairs[ii].num || i%pairs[ii].num==0)
	    {
	       flag=true;
	       System.out.print(pairs[ii].getStr());
	    }

	 }
	 if(flag)
	    System.out.print("\n");
	 if(flag==false)
	 {
	    System.out.println(i);

	 }
	 flag = false;
      }
   }
   private static class PairMe 
   {
      String s = new String();
      Integer num = new Integer(0);
      public void setNum(Integer n)
      {
	 num= new Integer(n);
      }
      public String getStr()
      {
	 return s;
      }
      public void setStr(String st)
      {
	 s=new String(st);

      }
   }
}
