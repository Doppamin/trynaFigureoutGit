//01/01/2020
package Progressing;

import java.util.*;

 
public class Snake {
    
    public static void main(String[] args) {
          ArrayList <char[][]> save= new ArrayList();
        
        Scanner s= new Scanner(System.in);
        char[][] board = {{'█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█','█'},
                          {'█', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},  //y (1-6)
                          {'█', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},  //(1-10)
                          {'█', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},
                          {'█', '■', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},
                          {'█', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},
                          {'█', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '█'},                          
                          {'█', '█', '█', '█', '█', '█', '█', '█', '█', '█','█', '█'}};


    char key;                             //keyboard input
    int [] konum={1,1};                         //location
    while(true){                         //infinit loop
 
    shwbrd(board);                      //shows board
    konum=cordinate(board);              //gives cordinate of head
    
    key=s.next().charAt(0);             //User input from keyboard
       if(key=='Z'){
         matchBoard(board,save.get(1));
         shwbrd(board); 
       
    }
    while (wallchk(board,konum,key)&&key!='Z'){   //if there is no wall loop will start
    move(board,konum,key,save);              //this gives movement of head 
    break;                              // this stand for get out of loops
             }  
  
         }
   
    }
    //______________________________________________________________________
    public static void shwbrd(char[][] board) {
            for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
            
    }
    //______________________________________________________________________
    public static char[][] move(char[][] board,int[]cordinate,char key,ArrayList <char[][]> save){
         int y=cordinate[0];
         int x=cordinate[1];
         board[y][x]='█';
         
         switch(key){
           case'A':x--;break;
           case'W':y--;break;
           case'S':y++;break;
           case'D':x++;break;
           default:System.out.println("AWSD");break;
        }
            board[y][x]='■';
            save.add(board);
        
         return board;
    }
    static char[][]matchBoard(char[][] board,char[][] save){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
           board[i][j]=save[i][j];     
        }        
    }
        return board;
    }
 /*   static void shiftArray(){
        char[][]temp=save.get(save.size()-2);
        save.remove(save.size()-2);
        save.add(0, temp);
        
    }*/
    
    //__________________________________________________________________________
    public static int[]cordinate(char[][] board){
        int[] cordinate=new int[2];
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==('■') ){
                    cordinate[0]=i;
                    cordinate[1]=j;
                    break;
                }                 
            }          
        }
        return cordinate;    
    }
   //___________________________________________________________________________
    public static boolean wallchk(char[][] board,int[]cordinate,char key){
        int y=cordinate[0];
         int x=cordinate[1];
         switch(key){
           case'A':x--;
               if(board[y][x]=='█'){
                   return false;
               }else{
                   return true;
               }           
           case'W':y--;
           if(board[y][x]=='█'){
                   return false;
               }else{
                   return true;
               }   
      
           case'S':y++;
           if(board[y][x]=='█'){
                   return false;
               }else{
                   return true;
               }   
        
           case'D':x++;
           if(board[y][x]=='█'){
                   return false;
               }else{
                   return true;
               }   
        
           default:System.out.println("AWSD");
        }
           
    return false;    
        
    }
//______________________________________________________________________________


//_____________________________________________________________________________

    
}
