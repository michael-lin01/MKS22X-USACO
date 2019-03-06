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

    return 1;
  }

  public static void main(String args[]){
    
  }
}
