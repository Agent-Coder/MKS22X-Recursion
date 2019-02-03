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
    //public static ArrayList<Integer> makeAllSums(int n){

    //}
    public static ArrayList<Integer> makeSums(int n,int fakeN,int start,int end,ArrayList<Integer> all){
      if (fakeN>n){
        return all;
      }
      if (end==0){
        all.add(0);
        output(all);
        System.out.println("add zero"+"  n:"+n+"   fakeN:"+fakeN+"   start:"+start+"  end:"+end);
        return makeSums(n,fakeN+1,start,all.size(),all);
      }
      all.add(fakeN+all.get(start));
      if(start!=end){
        output(all);
        System.out.println("not equal"+"  n:"+n+"   fakeN:"+fakeN+"   start:"+start+"  end:"+end);
        return makeSums(n,fakeN,start+1,end,all);
      }
        output(all);
        System.out.println("equal"+"  n:"+n+"   fakeN:"+fakeN+"   start:"+start+"  end:"+end);
        return makeSums(n,fakeN+1,1,all.size()-1,all);
    }
    /*public static void noDuplicate(ArrayList<Integer> all){
      for (int i=0;i<all.size();i++){
        for (int j=0;j<all.size();j++){
          if(all.get(i)==all.get(j)&&i!=j){
            all.remove(j);
          }
      }
    }*/
    public static void output(ArrayList<Integer> all){
      System.out.print("[");
      for (int i=0;i<all.size();i++){
        System.out.print(all.get(i)+",");
      }
      System.out.print("]");
    }
    public static void main(String[] args){
      ArrayList<Integer> x=new ArrayList<Integer>();
      makeSums(6,0,0,0,x);
    }
}
