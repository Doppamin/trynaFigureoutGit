package failedAttemp;

import java.util.Scanner;


public class TicTacToeAi {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] board = {'0','1','2','3','4','5','6','7','8'};
        print(board);
        
        
        
    }
    
    
    
    static void print(char[]board){
        for (int i = 0; i < 9; i++) {
            System.out.print(board[i]);
            if(i==2||i==5)System.out.println("");
        }
    }
    static char[] pick(char[]board,int a){
      
    }
}
