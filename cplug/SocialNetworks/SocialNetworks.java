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
public class SocialNetworks{
   public static void main(String[] args) {

      Scanner scan = new Scanner (System.in);
      String lines=scan.nextLine();
      Scanner s = new Scanner(lines);
      int first = s.nextInt();
      if(first < 1 || first > 20)
      {
	 System.out.println("N");
	 System.exit(0);
      }
      Integer[] mat3 = new Integer[first];
      Integer[] mat4 = new Integer[first];
      Integer[] mat5 = new Integer[first];
      Integer[] mat6 = new Integer[first];
      int total1=0;
      for(int j =0;j<first;j++)   
      {
	 String line=scan.nextLine();
	 int len = line.length();
	 /*if(len!=first)
	   {
	   System.out.println("N");
	   System.exit(0);
	   }*/
	 //	 System.out.println(line);
	 int counter =0;
	 int otherCounter =0;
	 for(int i=0;i<len;i++)
	 {
	    //System.out.print(line.charAt(i));
	    if(line.charAt(i)=='1')
	    {
	       counter++;
	    }
	    else if(line.charAt(i)=='0')
	    {
	       otherCounter++;
	    }
	 }
	 mat3[j]=new Integer(counter);
	 mat5[j]=new Integer(otherCounter);
      }
      int total2=0;
      for(int j =0;j<first;j++)   
      {
	 String line=scan.nextLine();
	 //	 System.out.println(line);
	 int counter =0;
	 int otherCounter =0;
	 int len = line.length();
	 /*if(len!=first)
	   {
	   System.out.println("N");
	   System.exit(0);
	   }*/
	 for(int i=0;i<len;i++)
	 {
	    if(line.charAt(i)=='1')
	    {
	       counter++;
	    }
	    else if(line.charAt(i)=='0')
	    {
	       otherCounter++;
	    }
	 }
	 mat4[j]=new Integer(counter);
	 mat6[j]=new Integer(otherCounter);
      }
      boolean flag =false;;

      Arrays.sort(mat4);
      Arrays.sort(mat3);

      Arrays.sort(mat5);
      Arrays.sort(mat6);
      boolean tflag =false;
      for(int j =0;j<first;j++)   
      {
	 if(mat3[j]>0)
	 {
	    tflag=true;
	    break;
	 }
	 if(mat4[j]>0)
	 {
	    tflag=true;
	 }  break;

	 //	System.out.println("ARRAY1: "+mat3[j].toString());
	 //   System.out.println("ARRAY2: "+mat4[j].toString());
      }
      flag=tflag;
      //System.out.println("FLAG: "+flag); 
      if(flag==true)
      {
	 // System.out.println("FLAG: "+flag); 
	 flag=Arrays.equals(mat4, mat3);
	 if(flag==true)
	    //System.out.println("FLAG: "+flag); 
	    flag=Arrays.equals(mat5,mat6);
      }
      if(flag)
      {
	 System.out.println("Y");
      }
      else
      {
	 System.out.println("N");
      }
   }
}
