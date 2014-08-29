//The question is to generate sample math problems(additions) for a
//  8th grade student and the results should be stored in such a way
// that they can be printed when required. 
// Sample problem is 7+8=_____
// The constraints are:-
//1) The numbers that are to be added should be <=9
//2) The result should be <=17

//An interview question asked by Amazon SLO on 1/22/14
import java.util.Hashtable;

public class MathProblems
{

   static  Hashtable tab = new Hashtable();
   public static void  generateProblems(int num)
   {
      for(int i=0;i<num;i++)
      {
	 Numberss s = new Numberss(); 
	 s.first = (int) (Math.random()*10);
	 s.second = (int) (Math.random()*10);
	 s.answer = s.first + s.second;
	 while(s.first+s.second > 17)
	 {
	    s.first = (int) (Math.random()*10);
	    s.second = (int) (Math.random()*10);
	    s.answer = s.first + s.second;
	 }
	 tab.put(new Integer(i),s);
      }
   }
   private static class Numberss{
      public int first;
      public int second;
      public int answer;
      public Numberss()
      {
      }
      public String toString()
      {
	 return first + "+" + second;
      }
   }
   public static void main(String args[])
   {

      //generate and store 10 problems.
      generateProblems(10);
      for(int i=0;i<10;i++)
      {
	 System.out.println(tab.get(new Integer(i)));
      }
      //   System.out.println(tab.toString());

   }
}
