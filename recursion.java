import java.lang.Math;
import java.util.ArrayList;
public class recursion{
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
      makeSums(n,1,0,0,x);
      return x;
    }
    public static ArrayList<Integer> makeSums(int n,int fakeN,int start,int end,ArrayList<Integer> all){
      if (fakeN>=n&&start==end){
        all.add(0,0);
        if (n==1){
          all.add(0,1);
        }
        return all;
      }
      if (end==0){
        all.add(fakeN);
        all.add(fakeN+1);
        return makeSums(n,fakeN+1,0,1,all);
      }
      if(start<end){
        all.add(fakeN+all.get(start));
        return makeSums(n,fakeN,start+1,end,all);
      }
        all.add(fakeN+1);
        return makeSums(n,fakeN+1,0,all.size()-1,all);
    }

    public static void output(ArrayList<Integer> all){
      System.out.print("[");
      for (int i=0;i<all.size();i++){
        if(i==all.size()-1){
          System.out.print(all.get(i)+"]");
        }
        else{
          System.out.print(all.get(i)+",");
        }
      }
    }
    public static void main(String[] args){
      output(makeAllSums(3));
    }
}
