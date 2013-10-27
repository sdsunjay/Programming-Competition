/*CPLUG PROGRAMMING COMPETITION
 * 10/26/13
 * Does not work
 */

import java.lang.StringBuilder;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;  
import java.util.Scanner;
public class SudokuCheck{
   public static void main(String[] args) {

      boolean flag =true;
      Scanner scan = new Scanner (System.in);
      String[] rows = new String[9];
      char[] list = new char[9];
      char c ='e'; 
      for(int j =0;j<9;j++)   
      {
	 Map<Character,Integer> map = new HashMap<Character,Integer>();
	 String temp=new String(scan.nextLine());
	 rows[j]=temp.replaceAll("\\s+","");
	 for(int i=0;i<rows[j].length();i++)
	 {

	    c=rows[j].charAt(i); 
	    if (map.containsKey(c)) {
	       flag=false;
	    } else {
	       map.put(c, 1);
	    }
	 }
      }

      StringBuilder[] cols = new StringBuilder[9];
      for(int j =0;j<9;j++)   
      {
	 cols[j] = new StringBuilder();
      }
      for(int j =0;j<9;j++)   
      {
	 cols[0].append(rows[j].charAt(0));
	 cols[1].append(rows[j].charAt(1));
	 cols[2].append(rows[j].charAt(2));
	 cols[3].append(rows[j].charAt(3));
	 cols[4].append(rows[j].charAt(4));
	 cols[5].append(rows[j].charAt(5));
	 cols[6].append(rows[j].charAt(6));
	 cols[7].append(rows[j].charAt(7));
	 cols[8].append(rows[j].charAt(8));
      }
      
      for(int j =0;j<9;j++)   
      {
	 Map<Character,Integer> map = new HashMap<Character,Integer>();
	 for(int i=0;i<cols[j].length();i++)
	 {

	    c=cols[j].charAt(i); 
	    if (map.containsKey(c)) {
	       flag=false;
	    } else {
	       map.put(c, 1);
	    }
	 }
      }
   
      String[] cols1 = new String[9];
      for(int j =0;j<9;j++)   
      {
      ///	 System.out.println("ROWS: "+rows[j].toString());
	cols1[j]=cols[j].toString();
      }
	 
      if(flag==false)
      {
	       System.out.println("N");
      }
      else
      {
	       flag=checkThree(rows,cols1);
	       if(flag==false)
	       {
		  System.out.println("N");
	       }
	       else
	       {
	       System.out.println("Y");
	       }
	 }
   }

   public static boolean checkThree(String[] rows,String[] cols)
   {
	 
      char c =' '; 
      for(int i=0;i<9;i+=3)
      {
	 Map<Character,Integer> map = new HashMap<Character,Integer>();
	 for(int j=0;j<3;j++)
	 {
	    c=rows[i].charAt(j);
	    if (map.containsKey(c)) {
	       return false;
	    } else {
	       map.put(c, 1);
	    }
	    c=rows[i+1].charAt(j);
	    if (map.containsKey(c)) {
	       return false;
	    } else {
	       map.put(c, 1);
	    }
	    c=rows[i+2].charAt(j);
	    if (map.containsKey(c)) {
	       return false;
	    } else {
	       map.put(c, 1);
	    }

	 }
      }
      return true;

   
   }
}
