//Write a function that given an array of N length of numbers, 
//find and print all possible subsets of K length
public class Driver
{
   public static void main(String[] args)
   {
      int[] numbers = {1,2,3,4,5};
      int n = 5;
      int k =3;
      if(findSubsets(numbers,n,k))
      {
	 System.out.println("Success");
      }
   }
   public static boolean findSubsets(int[] numbers, int n, int k)
   {
      int[] subset = new int[k];
      if(numbers.length == 0)
      {
	 return false;
      }
      //for the empty set which is a subset of all sets
      printSubset(subset,0);
      //loop through all the numbers in the array 
      for(int i =0;i<=n-k;i++)
      {
	 for(int j =0;j<k;j++)
	 {
	    subset[j] = numbers[i+j];

	 }
	 printSubset(subset,k);
      }
      return true;
   }
   public static void printSubset(int[] subset,int k)
   {
      //print subset here

      for(int i =0;i<k;i++)
      {
	 System.out.print(subset[i]+" ");
      }
      System.out.println();
   }
}
