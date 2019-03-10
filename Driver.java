import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String args[]) throws FileNotFoundException{
    USACO u = new USACO();
    for(int i = 1; i < 6; i++){
      String s = "./testCases/makelake."+i+".in";
      File f = new File(s.substring(0,s.length()-4)+i+".out");
      Scanner in = new Scanner(f);
      int ans = Integer.parseInt(in.next());
      int n = USACO.bronze(s);
      System.out.println("My ans: "+ n);
      System.out.println("Correct ans: "+ ans);
      if(n==ans) System.out.println("Correct");
      else System.out.println("Wrong");
      System.out.println();
    }
    System.out.println();
    for(int i = 1; i < 6; i++){
      String s = "./testCases/ctravel."+i+".in";
      File f = new File(s.substring(0,s.length()-4)+i+".out");
      Scanner in = new Scanner(f);
      int ans = Integer.parseInt(in.next());
      int n = USACO.silver(s);
      System.out.println("My ans: "+ n);
      System.out.println("Correct ans: "+ ans);
      if(n==ans) System.out.println("Correct");
      else System.out.println("Wrong");
      System.out.println();
    }
  }
}
