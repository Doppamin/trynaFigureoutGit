/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools │ Templates
 * and open the template in the editor.
 */
package Progressing;

/**
 *
 * @author user
 */
public class ttt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                    //0   1   2   3   4   5   6   7   8   9   10  11  12
     char[][]board={{'┌','─','─','─','┬','─','─','─','┬','─','─','─','┐'}, //0
                    {'│',' ','1',' ','│',' ','2',' ','│',' ','3',' ','│'}, //1
                    {'├','─','─','─','┼','─','─','─','┼','─','─','─','┤'}, //2
                    {'│',' ','4',' ','│',' ','5',' ','│',' ','6',' ','│'}, //3
                    {'├','─','─','─','┼','─','─','─','┼','─','─','─','┤'}, //4
                    {'│',' ','7',' ','│',' ','8',' ','│',' ','9',' ','│'}, //5
                    {'└','─','─','─','┴','─','─','─','┴','─','─','─','┘'}};//6                                                                              

        System.out.print(board[1][2]+" " );//1
        System.out.print(board[1][6]+" " );//2
        System.out.print(board[1][10]+" ");//3
        System.out.print(board[3][2]+" " );//4
        System.out.print(board[3][6]+" " );//5
        System.out.print(board[3][10]+" ");//6
        System.out.print(board[5][2]+" " );//7
        System.out.print(board[5][6]+" " );//8
        System.out.println(board[5][10]  );//9
    
        show(board);        
    }
    
    public static void show(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);                
            }
                  System.out.println("");           
        }        
    }
    
}
