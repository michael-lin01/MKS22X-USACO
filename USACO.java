import java.io.*;
import java.util.*;
public class USACO{
  public static int bronze(String filename)throws FileNotFoundException{
    File f = new File(filename);
    Scanner in = new Scanner(f);
    String line = in.nextLine();
    String[] args = line.split(" ");
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    int elevation = Integer.parseInt(args[2]);
    int numStomps = Integer.parseInt(args[3]);

    int[][] map = new int[rows][cols];
    for(int r = 0; r < rows; r++){
      line = in.nextLine();
      String[] elevs = line.split(" ");
      for(int c = 0; c < elevs.length; c++){
        map[r][c]=Integer.parseInt(elevs[c]);
      }
    }

    /*
    String ans = "";
    for(int r = 0; r < rows; r++){
      for(int c = 0; c < cols;c++){
        if(map[r][c]<10) ans += " "+map[r][c]+" ";
        else ans+= map[r][c]+" ";
      }
      ans+="\n";
    }
    System.out.println(ans);
    */

    for(int i = 0; i < numStomps; i++){
      line=in.nextLine();
      String[] stomps = line.split(" ");
      stomp(Integer.parseInt(stomps[0])-1,Integer.parseInt(stomps[1])-1,Integer.parseInt(stomps[2]),map);
    }
    int sum = 0;
    for(int[] r: map){
      for(int c:r){
        if(elevation-c>0) sum+=elevation-c;
      }
    }
    return sum*72*72;
  }

  public static void stomp(int row, int col, int down, int[][] map){
    int max = -1;
    for(int r = row; r <= row+2; r++){
      for(int c = col; c <= col+2; c++){
        if(map[r][c]>max) max = map[r][c];
      }
    }
    int elev = max-down;
    for(int r = row; r <= row+2; r++){
      for(int c = col; c <= col+2; c++){
        if(map[r][c]>elev) map[r][c]=elev;
      }
    }
  }


  public static int silver(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    String line = in.nextLine();
    String[] args = line.split(" ");

    int rows = Integer.parseInt(args[0]);
    int secs = Integer.parseInt(args[1]);
    int cols = Integer.parseInt(args[2]);
    /*
    System.out.println(rows);
    System.out.println(cols);
    System.out.println(secs);
    */

    boolean[][] field = new boolean[rows][cols];


    for(int r = 0; r < rows; r++){
      line = in.nextLine();
      System.out.println(line);
      for(int c = 0; c < line.length(); c++){
        field[r][c]= line.charAt(c)!='*';
      }
    }

    int startR = Integer.parseInt(in.next())-1;
    int startC = Integer.parseInt(in.next())-1;
    int endR = Integer.parseInt(in.next())-1;
    int endC = Integer.parseInt(in.next())-1;

    int[][] nums1 = new int[rows][cols];
    int[][] nums2 = new int[rows][cols];
    nums1[startR][startC] = 1; //so surrounding tiles will get value of 1 when sec = 1

    for(int sec = 0; sec < secs; sec++){
      for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols; c++){
          if(field[r][c]){ //check surrounding tiles if tile is not a tree - add the value of all surrounding tile
            if(r>0) nums2[r][c]+=nums1[r-1][c];
            if(c>0) nums2[r][c]+=nums1[r][c-1];
            if(r<rows-1) nums2[r][c]+=nums1[r+1][c];
            if(c<cols-1) nums2[r][c]+=nums1[r][c+1];
          }
        }
      }
      for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols; c++){
          nums1[r][c]=0; //reset the old board
        }
      }
      //swap boards
      int[][]temp = nums1;
      nums1 = nums2;
      nums2=temp;
      /*
      String ans = "";
      for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols;c++){
          if(nums1[r][c]<10) ans += " "+nums1[r][c]+" ";
          else ans+= nums1[r][c]+" ";
        }
        ans+="\n";
      }
      System.out.println(ans);
      */
    }
    return nums1[endR][endC];
  }

  public static void main(String args[]){
    try{
      //System.out.println(bronze("./testCases/makelake.5.in"));
      System.out.println(silver("./testCases/ctravelMOD.1.in"));
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }

  }
}
