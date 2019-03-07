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
    File f = new File(filename);
    Scanner in = new Scanner(f);

    return 1;//so that it compiles
  }

  public static void main(String args[]){
    try{
      System.out.println(bronze("./testCases/makelake.5.in"));
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }

  }
}
