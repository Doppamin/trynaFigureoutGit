package failedAttemp;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class myPacDemo {
   

    public static void main(String[] args) {
       // String[] board = {"▄", "▄", "▄", ".", ".", ".", ".", "c", ".", ".", "█", ".", ".", ".", ".", ".", ".", "█", ".", ".", ".", ".", "█", ".", ".", ".", ".", ".", "."};
           String[] board = board();
           board[101] = "c";
            board[38] ="☻";   
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
             
            ghost(board);
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
            if(i<21||i>118){
                board[i] = "▄";
            }
            else if(i==39||i==40||i==59||i==60||i==79||i==80||i==99||i==100){
                board[i] = "█";
            }
            else{
                 board[i] = "•";
            }
           
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
        int[] m = new int[12];
        for (int i = 0; i < 12; i++) {
            m[i] = -1;
        }
        for (int i = 0; i < 12; i++) {
            n = (int) (21+Math.random() * 98);

            for (int j = 0; j < 12; j++) {
                if (m[j] == n) {
                    n = (int) (21+Math.random() * 98);
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
        public static int findGhost(int here, String[] board) {
        for (int i = 0; i < 140; i++) {
            if (board[i].equals("☻") ){
                here = i;
            }
        }
        return here;
    }
       public static String[] ghost(String[] board){
           int goGhost=findGhost(1,board);
           int min=200;     //minimum value
           int turn=0;      //this for show which array is minimum
           int[]distant=new int[4];
           int[]sirali={0,1,2,3};       //beynim yandı o yüzden bundan sonraki kısımları  türkçe yazıyorum sonra inglizceye çeviririm.
         
               if(findHead(1,board)-findGhost(1,board)>0){
                   distant[0]=findHead(1,board)-(findGhost(1,board)-1);//left  //7
                   distant[1]=findHead(1,board)-(findGhost(1,board)+1);//right //4
                   distant[2]=findHead(1,board)-(findGhost(1,board)-20);//up   //2
                   distant[3]=findHead(1,board)-(findGhost(1,board)+20);//down //9
            }
                 int[]clondist=new int[distant.length];
        for (int i = 0; i < distant.length; i++) {
            clondist[i]=distant[i];
        }
                 rankNums (clondist);           // clondist sıralanıyor distant sabit
                 int [] sira =new int[distant.length];//sıra diye yeni dizi oluştu
        for (int i = 0; i < distant.length; i++) {
            for (int j = 0; j < distant.length; j++) {
                if (clondist[i] == distant[j]) {//sıralanmış halinin orjinal indisteki yerini tespi et
                    sira[i] = j;                //ve sıra dizisine aktarır
                }

            }
            
        }
                if(wallChkGA(board)==true){     //duvar yoksa normal değeri değişmiyor
                    sirali[0]=0;
                }
                else if(wallChkGA(board)==false){   //duvar 0123den farklı herhangi bir sayı atanıyor
                       sirali[0]=5;
                }
                else if(wallChkGD(board)==true){
                       sirali[1]=1;
                }
                else if(wallChkGD(board)==false){
                       sirali[1]=5;
                }                        
                else if(wallChkGW(board)==true){
                       sirali[2]=2;
                }
                else if(wallChkGW(board)==false){
                       sirali[2]=5;
                }
                else if(wallChkGS(board)==true){
                                           sirali[3]=3;

                }
                else if(wallChkGS(board)==false){
                                           sirali[3]=5;

                }
                int go=-1;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                         if (sira[i]==sirali[j]){   //eğer en kısa mesafe olmasına rağmen engel varsa diğer mesafelere bakılıyor
                   go=sira[i];      //hareket edeceği değeri yazalıyor
                   break;
                    }                        
               }
                     if(go==sira[i]) 
                         break;
           }
               
                switch(go){ // hareket edilecek değer alınıp metotlara işleniyor
         case 0:moveGhost('A',board); break;
         case 1:moveGhost('D',board); break;    
         case 2:moveGhost('W',board); break;
         case 3:moveGhost('S',board); break;
         default:moveGhost('a',board); break;
       }
            //value of least distant= distant[turn];
            
            
                            return board;
  

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
    public static String[] moveGhost(char move, String[] board) {
        int go = findGhost(1, board);

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
     public static boolean wallChkGA(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
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
    public static boolean wallChkGD(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
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
    public static boolean wallChkGW(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
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
    public static boolean wallChkGS(String[] board) {
        boolean chk = true;
        int go = findGhost(1, board);
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

}

    

