
import java.awt.Color;
import java.util.Arrays;



public class ChessBoard {
    static char[][]chessBoard=new char[10][25];
    public static void main(String[] args) {
       for (char[] row: chessBoard)
         //   Arrays.fill(row,'█');
       fillMatrix();
       printMatrix();
        

    }
    static void printMatrix(){
        int count=0;
        
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if(i%2==0){
                    if(count<2){
                        System.out.print("\033[0;37m"+chessBoard[i][j]);
                        count++;
                        
                    }
                    else if(count>=2&&count<4){
                        System.out.print("\033[0m"+chessBoard[i][j]);
                        count++;
                    }
                    else{
                        count=0;
                    }
                }else{
                     if(count<2){
                     System.out.print("\033[0m"+chessBoard[i][j]);                      
                        count++;
                        
                    }
                    else if(count>=2&&count<4){
                        System.out.print("\033[0;37m"+chessBoard[i][j]);
                        count++;
                    }
                    else{
                        count=0;
                    }
                    
                }
                }
            System.out.println("");
        }
    }
    static void fillMatrix(){
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j]='█';
            }
        }
    }
}
