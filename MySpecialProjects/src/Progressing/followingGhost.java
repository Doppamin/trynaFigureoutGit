//25/12/2020
package Progressing;
import java.util.Scanner;
/** I did pacman game other project but that ghost didn't follow me . I created this project to findout what is my problem.
Interestingly that gosth following me in 1D dimension**/
public class followingGhost {


    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    char[] board={'.','☺','.','.','.','.','☻','.','.','.','.','.','.','.','.','.','.','.','.','.'};//char[20]
    char key;
    while(true){
        show(board);
        int a= head(board);
        int b=locGhost(board);
        key=s.next().charAt(0);
        move(board,a,key);
        ghost(board,b);
        
        }
    }
//------------------------------------------------------------------------------
     public static void show(char[]world){
         
         for (int i = 0; i < world.length; i++) {
            
                System.out.print(world[i]);            
            
        }   
         System.out.println("");
    }
//------------------------------------------------------------------------------
    public static int head(char[] world){
        int cordinate=0;
         for (int i = 0; i < world.length; i++) {
                if(world[i]==('☺') ){
                    cordinate=i;               
                    break;
                }                 
                    
        }
        return cordinate;    
    }
//------------------------------------------------------------------------------
 public static int locGhost(char[] world){                  //location of ghost
        int cordinate=0;
         for (int i = 0; i < world.length; i++) {
                if(world[i]==('☻') ){
                    cordinate=i;               
                    break;
                }                 
                    
        }
        return cordinate;    
    }
//------------------------------------------------------------------------------
    public static char[] move(char[] world,int cordinate,char key){
         int x=cordinate;
         world[x]='.';
         switch(key){
           case'A':x--;break;
           case'W':x=5;break;
           case'S':x=10;break;
           case'D':x++;break;
           default:System.out.println("AWSD");break;
        }
         world[x]='☺';
         return world;
    }
//------------------------------------------------------------------------------
    public static char[]ghost(char[]world,int loc){    //idk what to type here
        int a=locGhost(world)-head(world);
        int x = loc;
        world[x]='.';
        if(a>0){
            x--;
        }else{
            x++;
        }
        world[x]='☻';
        
        return world;
    }

    
}
