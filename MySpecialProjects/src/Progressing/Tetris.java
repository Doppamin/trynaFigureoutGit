package Progressing;
import java.util.*;
public class Tetris {
    public static void main(String[] args) {
        Control ctrl = new Control();
        Blocks b = new Blocks();
        Textures tex = new Textures();
        ctrl.showBlock();
    }
}
class Textures{
    char[][] blockL= {{'▓','▓',' ',' ',' ',' ',' ',' '},
                      {'▓','▓',' ',' ',' ',' ',' ',' '},
                      {'▓','▓','▓','▓',' ',' ',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '}};
    char[][] blockL2={{' ',' ',' ',' ','▓','▓',' ',' '},
                      {'▓','▓','▓','▓','▓','▓',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '}};
    char[][] blockL3={{'▓','▓','▓','▓',' ',' ',' ',' '},
                      {' ',' ','▓','▓',' ',' ',' ',' '},
                      {' ',' ','▓','▓',' ',' ',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '}};
    char[][] blockL4={{'▓','▓','▓','▓','▓','▓',' ',' '},
                      {'▓','▓',' ',' ',' ',' ',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '},
                      {' ',' ',' ',' ',' ',' ',' ',' '}};
}
class Blocks extends Textures{
   ArrayList<char[][]> BlockL=new ArrayList<char[][]>(Arrays.asList(blockL,blockL2,blockL3,blockL4));
}
class Locations{    //fuck me
}
class Control extends Blocks{
    void showBlock(){
        int r =0;
        for (int i = 0; i < blockL.length; i++) {
            for (int j = 0; j < blockL[i].length; j++) {
                r=(int)(Math.random()*5);
                switch(r){
                    case 0:System.out.print("\u001b[31m"+BlockL.get(1)[i][j]);break;
                    case 1:System.out.print("\u001b[32m"+BlockL.get(1)[i][j]);break;
                    case 2:System.out.print("\u001b[33m"+BlockL.get(1)[i][j]);break;
                    case 3:System.out.print("\u001b[34m"+BlockL.get(1)[i][j]); break;
                    case 4:System.out.print("\u001b[35m"+BlockL.get(1)[i][j]);break;
                }
            }
            System.out.println();
        }
    }
}
class Checking{
}