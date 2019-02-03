import java.lang.Math;
import java.util.ArrayList;
public class Recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      return squarert(n,0,tolerance);
    }
    public static double squarert(double n,double guess,double tolerance){
      if (n==0){
        return 0;
      }
      if(Math.abs(Math.pow(guess,2)-n)/(n)*100<tolerance){
        return guess;
      }
      return squarert(n,(n/guess + guess)/2,tolerance);
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return fibonacci(n,1,0);
    }
    public static int fibonacci(int n, int previous,int holder){
      if (n==0){
        return holder;
      }
      return fibonacci(n-1,holder,previous+holder);
    }

    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> x=new ArrayList<Integer>();
      makeSums(n,1,x,0);
      return x;
    }
    public static boolean makeSums(int n,int start,ArrayList<Integer> all,int sum){
        if (start==1){
          all.add(0);
          //always add the 0 first
        }
        if (start>n){
          return true;
          //when the looper is greater than the input, put true
        }
        return makeSums(n,start+1,adding(all,sum+start),sum+start)&&makeSums(n,start+1,all,sum);
        //this will always return true and both cases of adding and no adding have to be true(meaning reach end)
        //first call adds everytime something new is inputed
        //second one does the not chosen one but does not have to add because first call added already
    }

    public static ArrayList<Integer> adding(ArrayList<Integer> ary,int x){
      ary.add(x);
      return ary;
      //add the new element and then return the updated array
    }
}
