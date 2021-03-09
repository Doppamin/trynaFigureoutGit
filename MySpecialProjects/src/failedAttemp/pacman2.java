package failedAttemp;

import java.util.Scanner;
public class pacman2 {
    public static void main(String[] args) {
       // String[] board = {"▄", "▄", "▄", ".", ".", ".", ".", "c", ".", ".", "█", ".", ".", ".", ".", ".", ".", "█", ".", ".", ".", ".", "█", ".", ".", ".", ".", ".", "."};
           String[] board = board();
           board[120] = "c";
       //board[19] ="☻";   
           Obstackles(board);
        Scanner s = new Scanner(System.in);
        startScreen();
        String pass = s.next();
        gameBoard(board);
        int frame = 0;
        char key;
        while (true) {
            key = s.next().charAt(0);
            if (frame % 2 == 0) 
                move(key, board);
             else 
                move2(key, board);       

            gameBoard(board);
            frame++;
            if (chkWin(board)) 
                break;            
        }
        System.out.println("Oyun bitti tüm yemler yendi");
        gameOver();
    }
    

    public static String[] board(/*int width ,int height*/) {//hayal kurdum .yükseklik ve genişlik verileri ile bişey yaparım belki ilerde
        String[] board = new String[140];
        for (int i = 0; i < 140; i++) {
            board[i] = "•";
        }
        return board;
    }

    public static void gameBoard(String board[]) {
        System.out.println();
        for (int i = 0; i < 140; i++) {
            System.out.print(board[i]);
            if (i == 19 || i == 39 || i == 59 || i == 79 || i == 99 || i == 119 || i == 139) {
                System.out.println("");
            }
        }
    }

    public static String[] Obstackles(String[] board) {
        int n = 0;
        int[] m = new int[20];
        for (int i = 0; i < 20; i++) {
            m[i] = -1;
        }
        for (int i = 0; i < 20; i++) {
            n = (int) (Math.random() * 140);

            for (int j = 0; j < 20; j++) {
                if (m[j] == n) {
                    n = (int) (Math.random() * 140);
                    j = 0;
                }

            }

            m[i] = n;

            if (i % 2 == 0) {
                board[n] = "█";
            } else {
                board[n] = "▄";
            }
        }
        return board;
    }

    public static boolean chkWin(String[] board) {
        boolean win = true;
        for (int i = 0; i < 140; i++) {
            if (board[i].equals("•")) {
                win = false;
            }

        }

        return win;
    }

    public static int findHead(int here, String[] board) {
        for (int i = 0; i < 140; i++) {
            if (board[i].equals("c") || board[i].equals("o") || board[i].equals("ↄ")) {
                here = i;
            }
        }
        return here;
    }
       
      
           //public static int chkFood(String[] board){
           
       
     
           
       
    

    public static String[] move(char move, String[] board) {
        int go = findHead(1, board);

        if (move == 'A') {
            if (wallChkA(board)) {
                board[go - 1] = "o";
                board[go] = " ";
            }
        } else if (move == 'D') {
            if (wallChkD(board)) {
                board[go + 1] = "o";
                board[go] = " ";
            }
        } else if (move == 'W') {
            if (wallChkW(board)) {
                board[go - 20] = "o";
                board[go] = " ";
            }
        } else if (move == 'S') {
            if (wallChkS(board)) {
                board[go + 20] = "o";
                board[go] = " ";
            }
        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");

        }
        return board;

    }
   

   

    public static String[] move2(char move, String[] board) {
        int go = findHead(1, board);

        if (move == 'A') {
            if (wallChkA(board)) {
                board[go - 1] = "ↄ";
                board[go] = " ";
            }

        } else if (move == 'D') {
            if (wallChkD(board)) {
                board[go + 1] = "c";
                board[go] = " ";
            }
        } else if (move == 'W') {
            if (wallChkW(board)) {
                board[go - 20] = "c";
                board[go] = " ";
            }
        } else if (move == 'S') {
            if (wallChkS(board)) {
                board[go + 20] = "c";
                board[go] = " ";
            }
        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");

        }
        return board;

    }

    public static boolean wallChkA(String[] board) {
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go - 1].equals("█") || board[go - 1].equals("▄")) {
            chk = false;
        }

        return chk;

    }
     

    public static boolean wallChkD(String[] board) {
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go + 1].equals("█") || board[go + 1].equals("▄")) {
            chk = false;
        }

        return chk;

    }
   
    public static boolean wallChkW(String[] board) {
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go - 20].equals("█") || board[go - 20].equals("▄")) {
            chk = false;
        }

        return chk;

    }
   

    public static boolean wallChkS(String[] board) {
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go + 20].equals("█") || board[go + 20].equals("▄")) {
            chk = false;
        }

        return chk;

    }
    
    public static void startScreen() {
        System.out.println(" _  _         _           _ _         ");
        System.out.println("| || |_  _ __| |__ _ _  _(_| )___     ");
        System.out.println("| __ | || / _` / _` | || | |/(_-<     ");
        System.out.println("|_||_|\\_,_\\__,_\\__,_|\\_, |_| /__/ ");
        System.out.println(" ___         ___     |__/             ");
        System.out.println("| _ \\__ _ __|   \\ ___ _ __  ___     ");
        System.out.println("|  _/ _` / _| |) / -_) '  \\/ _ \\    ");
        System.out.println("|_| \\__,_\\__|___/\\___|_|_|_\\___/  ");

    }

    public static void gameOver() {
        Scanner s = new Scanner(System.in);

        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀");
        System.out.println("██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼");
        System.out.println("██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀");
        System.out.println("██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼");
        System.out.println("███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼");
        System.out.println("██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼");
        System.out.println("██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼");
        System.out.println("██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼");
        System.out.println("███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄");
        String n = s.next();
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼");
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
    }
    //Burdan sonrası ghost nesnesini yani Karakterime sürekli yaklaşan yemekleri yemeyen ve
    // duvarlardan geçemeyen bir nesnede ama baya zordlandım.Bu yüzden başka yerde devam ediyorum onu yazmaya
/*     public static int findGhost(int here, String[] board) {
        for (int i = 0; i < 140; i++) {
            if (board[i].equals("☻") ){
                here = i;
            }
        }
        return here;
    }
      public static String[] ghost(String[] board){
           int goGhost=findGhost(1,board);
           int min=200;//minimum value
           int turn=0;//this for show which array is minimum
           int[]distant=new int[4];
         
               if(findHead(1,board)-findGhost(1,board)>0){
                   distant[0]=findHead(1,board)-(findGhost(1,board)-1);//left  //7
                   distant[1]=findHead(1,board)-(findGhost(1,board)+1);//right //4
                   distant[2]=findHead(1,board)-(findGhost(1,board)-20);//up   //2
                   distant[3]=findHead(1,board)-(findGhost(1,board)+20);//down //9
            }
                 int[]clondist=distant;
                 rankNums (clondist);
            //value of least distant= distant[turn];
            
            
                            return board;
  

           }
       public static String[] moveGhost(char move, String[] board) {
        int go = findHead(1, board);

        if (move == 'A') {
            if (wallChkA(board)) {
                board[go - 1] = "☻";
                board[go] = " ";
            }

        } else if (move == 'D') {
            if (wallChkD(board)) {
                board[go + 1] = "☻";
                board[go] = " ";
            }
        } else if (move == 'W') {
            if (wallChkW(board)) {
                board[go - 20] = "☻";
                board[go] = " ";
            }
        } else if (move == 'S') {
            if (wallChkS(board)) {
                board[go + 20] = "☻";
                board[go] = " ";
            }
        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");

        }
        return board;

    }
       public static boolean wallChkGA(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
        if (board[go - 1].equals("█") || board[go - 1].equals("▄")) {
            chk = false;
        }

        return chk;

    }
        public static boolean wallChkGD(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
        if (board[go + 1].equals("█") || board[go + 1].equals("▄")) {
            chk = false;
        }

        return chk;

    }
         public static boolean wallChkGW(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
        if (board[go - 20].equals("█") || board[go - 20].equals("▄")) {
            chk = false;
        }

        return chk;

    }

     public static int [] rankNums (int [] array){
        int temp;
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
     public static boolean wallChkGS(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
        if (board[go + 20].equals("█") || board[go + 20].equals("▄")) {
            chk = false;
        }

        return chk;

    }

*/
}
