
import java.util.Scanner;

public class snake {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //String[] board={"┌","─","─","─","┐","|",".",".",".","|","|",".",".",".","|","|","☺",".",".","|","■","■","■","■","■"};
        String[] testBoard = {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "☺", ".", ".", ".", ".", ".", "."};
        int warn = 0;
        int foot = 0;  //adım sayısı
        int food = 0;//yediklerinin sayısı
        randomFood(testBoard);
        gameBoard(testBoard);

        while (true) {
  warn++;
            if (warn % 5 == 0) {
                System.out.print("!");
            }
             gameBoard(testBoard);
            char keyboard = s.next().charAt(0);
            move(keyboard, testBoard);
          
            // String stop=s.next();
            if (checkFood(testBoard)) {
                randomFood(testBoard);
                food++;
            }
          
            foot++;
            if (foot % 5 == 0) {
                randomObstacle(testBoard);
            }
            if (checkObstacle(foot, testBoard)) {
                break;
            }
             
            gameBoard(testBoard);

        }
        System.out.println("Oyun bitti");
        System.out.println(food + " tane yemek yedin");
        System.out.println(foot + " tane adım attın");

    }

    public static boolean checkFood(String[] board) {
        boolean check = false;
        for (int i = 0; i < 25; i++) {
            if (board[i].equals("□")) {
                check = false;
                break;
            } else {
                check = true;
            }

        }
        return check;
    }

    public static boolean checkObstacle(int foot, String[] board) {
        boolean check = false;
        int numObstacle = 0;
        for (int i = 0; i < 25; i++) {
            if (board[i].equals("■")) {
                numObstacle++;
            }

        }
        if (foot / 5 != numObstacle) {
            check = true;
        }
        return check;
    }

    public static String[] randomFood(String[] board) {
        int foodLoc = (int) (Math.random() * 25);
        while (board[foodLoc].equals("■") || board[foodLoc].equals("☺")) {
            foodLoc = (int) (Math.random() * 25);
        }
        board[foodLoc] = "□";
        return board;
    }

    public static String[] randomObstacle(String[] board) {
        int obstLoc = (int) (Math.random() * 25);
        while (!board[obstLoc].equals("."))/*||board[foodLoc+1].equals("☺")||board[foodLoc-1].equals("☺")*/ {
            
          obstLoc = (int) (Math.random() * 25);
        }
        board[obstLoc] = "■";
        return board;
        }

    public static int findHead(int here, String[] board) {
        for (int i = 0; i < 25; i++) {
            if (board[i].equals("☺")) {
                here = i;
            }
        }
        return here;
    }

    public static String[] move(char move, String[] board) {
        int go = findHead(1, board);
        int i = 0;
        if (move == 'A') {
            while (board[go - 1].equals("■") && i == 0) {
                board[go + 1] = "☺";
                i++;
            }

            board[go - 1] = "☺";
            board[go] = ".";

        } else if (move == 'D') {

            while (board[go + 1].equals("■") && i == 0) {
                board[go - 1] = "☺";
                i++;
            }
            board[go + 1] = "☺";
            board[go] = ".";

        } else if (move == 'W') {
            while (board[go - 5].equals("■") && i == 0) {
                board[go + 5] = "☺";
                i++;
            }
            board[go - 5] = "☺";
            board[go] = ".";

        } else if (move == 'S') {
            while (board[go + 5].equals("■") && i == 0) {
                board[go - 5] = "☺";
                i++;
            }
            board[go + 5] = "☺";
            board[go] = ".";

        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");

        }
        return board;

    }

    public static void gameBoard(String board[]) {
      
 
        System.out.println();

        for (int i = 0; i < 25; i++) {
            System.out.print(board[i]);
            if (i == 4 || i == 9 || i == 14 || i == 19) {
                System.out.println("");
            }
        }
                System.out.println();

    }

}
