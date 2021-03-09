//30/01/2021


import java.util.*;

public class SnakeDemo {

    public static void main(String[] args) {
        ArrayList<Integer> xCor = new ArrayList();
        ArrayList<Integer> yCor = new ArrayList();
        Scanner s = new Scanner(System.in);
        xCor.add(1);
        xCor.add(1);
        xCor.add(1);
        yCor.add(4);
        yCor.add(5);
        yCor.add(6);

        char[][] board = {{'█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█'},
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '•', '█'}, //y (1-6)
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'}, //(1-10)
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█'}};
        char key;
        int score=0;

        for (;;) {
            //if snake eat food which mean food would diseapper and trigger the chckFood method wich it return true
            if (chkFood(board)) {   //if there is food on board return false else return true
                //Snake's body grow and this add 1 more coordinate for new body part 
                xCor.add(xCor.get(xCor.size()-1));
                yCor.add(yCor.get(yCor.size()-1));
                score +=10;
            }
              //if there is no food this will create new food .Only 1 food can be spawned whole game
            while (chkFood(board)) {            
                randFood(board);
            }
            shwbrd(board);
            key = s.next().charAt(0);
            move(board, key, xCor, yCor);
            //if snake hit wall or it's body loop would ended
            if(chkWall(xCor,yCor)||chkBody(xCor,yCor)){
                break;
            }

        }
        
        System.out.println("Game Over");
        System.out.println("Skor: "+score);

    }

//_____________________MOVE_____________________________________________________
    public static char[][] move(char[][] board, char key, ArrayList<Integer> x, ArrayList<Integer> y) {

        switch (key) {
            case 'W': xCorUp   (x);yCorUp   (y); break;
            case 'S': xCorDown (x);yCorDown (y); break;
            case 'D': xCorRight(x);yCorRight(y); break;
            case 'A': xCorLeft (x); yCorLeft(y); break;
            default:
        }
        clearBoard(board);
        attachBoard(board, x, y);
        return board;
    }
//____________________________UP________________________________________________
    public static ArrayList<Integer> xCorUp(ArrayList<Integer> x) {
        for (int i = x.size() - 1; i > 0; i--) {
            x.set(i, x.get(i - 1));
        }
        return x;
    }

    public static ArrayList<Integer> yCorUp(ArrayList<Integer> y) {
        for (int i = y.size() - 1; i > 0; i--) {
            y.set(i, y.get(i - 1));
        }
        y.set(0, y.get(0) - 1);
        return y;
    }
//__________________________DOWN________________________________________________
    public static ArrayList<Integer> xCorDown(ArrayList<Integer> x) {
        for (int i = x.size() - 1; i > 0; i--) {
            x.set(i, x.get(i - 1));
        }
        return x;
    }

    public static ArrayList<Integer> yCorDown(ArrayList<Integer> y) {
        for (int i = y.size() - 1; i > 0; i--) {
            y.set(i, y.get(i - 1));
        }
        y.set(0, y.get(0) + 1);

        return y;

    }
//_________________________RIGHT________________________________________________
    public static ArrayList<Integer> xCorRight(ArrayList<Integer> x) {
        for (int i = x.size() - 1; i > 0; i--) {
            x.set(i, x.get(i - 1));
        }
        x.set(0, x.get(0) + 1);

        return x;

    }

    public static ArrayList<Integer> yCorRight(ArrayList<Integer> y) {
        for (int i = y.size() - 1; i > 0; i--) {
            y.set(i, y.get(i - 1));
        }

        return y;

    }
//__________________________LEFT________________________________________________
    public static ArrayList<Integer> xCorLeft(ArrayList<Integer> x) {
        for (int i = x.size() - 1; i > 0; i--) {
            x.set(i, x.get(i - 1));
        }
        x.set(0, x.get(0) - 1);

        return x;

    }

    public static ArrayList<Integer> yCorLeft(ArrayList<Integer> y) {
        for (int i = y.size() - 1; i > 0; i--) {
            y.set(i, y.get(i - 1));
        }

        return y;

    }
//______________________________________________________________________________
    public static char[][] attachBoard(char[][] board, ArrayList<Integer> x, ArrayList<Integer> y) {
        //this attach all cordinates with snake's body
        for (int i = 0; i < x.size(); i++) {
            board[y.get(i)][x.get(i)] = 'O';
        }

        return board;
    }

    public static char[][] clearBoard(char[][] board) {
        char[][] cleanBoard = {{'█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█'},
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'}, 
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'}, 
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '█'},
        {'█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█', '█'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] =='•')continue;//don't clean the food
                board[i][j] = cleanBoard[i][j];

            }
        }

        return board;
    }
//_________FOOD_________________________________________________________________

    public static char[][] randFood(char[][] board) {      //this creates random food
        int x = 0;
        int y = 0;
        while (board[y][x] != '.') {        //if there is snake in food location 
            x = (int) (1 + Math.random() * 10); //this will creat new location nonSnake place
            y = (int) (1 + Math.random() * 6);

        }
        board[y][x] = '•';
        return board;
    }

    public static boolean chkFood(char[][] board) {   //only 1 food per turn can be spawned.this for check 
        boolean chk = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '•') {
                    chk = false;

                }

            }

        }
        return chk;
    }
//______________ENDGAME_________________________________________________________
    
    public static boolean chkWall(ArrayList<Integer> x, ArrayList<Integer> y){
        
        if(x.get(0)==0||x.get(0)==11||y.get(0)==0||y.get(0)==7){
            return true;
        }else{
            return false;
        }

    }
    public static boolean chkBody(ArrayList<Integer> x, ArrayList<Integer> y){
        boolean rtn=false;       //rtn = short of return 
        for (int i = 1; i < x.size(); i++) {
            if(x.get(0)==x.get(i)&&y.get(0)==y.get(i)){
                rtn =true;
            
        }
     
    } 
        return rtn;
        
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

}
//SNAKE CAN TURN BACK
//SNAKE CAN'T EAT IT'S BODY
//SKOR