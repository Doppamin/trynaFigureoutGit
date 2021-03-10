package failedAttemp;


public class Sudoku {

    //  i tried to print sudoku table and it goes well unless it didng highlighted the rows
   //only collumns are thick but i need to make row aswell to complate 3x3 square in sudoku 
    public static void main(String[] args) {
        // TODO code application logic here
        board();

    }

    
    public static void board() {
        String[][] girdi={{"2"," "," ","4"," "," "," "," ","3"}, 
                           {" "," "," "," ","6"," ","7"," "," "}, 
                         {" "," "," "," "," "," "," "," "," "}, 
                          {" ","4"," ","5"," "," "," "," "," "}, 
                          {" "," ","3"," "," "," "," "," "," "}, 
                          { " "," "," "," "," ","7"," "," "," ",}, 
                           {" "," "," "," "," "," "," "," "," ",}, 
                         {" "," "," "," "," "," "," "," "," "}, 
                          {" "," "," "," ","6"," "," "," ","1",}, 
                        
    };
        String n="1";            
        String board[][] = {{"┌", "───", "┐"},
                            {"|", " "+n+" ","|"},
                            {"└", "───", "┘"}};
     
        for (int l = 0; l < 9; l++) {         
        
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 9; k++) {
                  if(k==0)
                System.out.print("█");
                n=girdi[l][k];
                for (int j = 0; j < 3; j++) {
                    
                    System.out.print(board[i][j]);
                     board[1][1]=" "+n+" ";                
                }
                
                if(k==2||k==5||k==8)
                    System.out.print("█");                   
            }
            
            System.out.println();
        }

        }
    }
}/*
    public static String[][][][] temple() {

        String board2[][] = {{"┌", "───", "┐"},
        {"|", " 5 ", "|"},
        {"└", "───", "┘"}};
        String board3[][][][] = new String[9][9][3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        board3[i][j][k][l] = board2[k][l];
                    }
                }

            }

        }
        return board3;
    }
*/

