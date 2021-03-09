


import java.util.Scanner;

public class Pacman {

    public static void main(String[] args) {
        String[] board = {"_", "_", "_", "•", "•", "•", "•", "c", "•", "•", "|", "•", "•", "•", "•", "•", "•", "|", "•", "•", "•", "•", "|", "•", "•", "•", "•", "•", "•"};
        //  String[] board = board();
        // board[120] = "c";
        // Obstackles(board);//burada oyun ekranını büyütmüştüm deneme olarak o yüzden buradalar
        Scanner s = new Scanner(System.in);
        startScreen();

        String pass = s.next();

        gameBoard(board);//Hudayi's PacDemo yazdırıyor ascii art ile ekrana

        int frame = 0;//bu pacmanin ağzı açık mı kapalı mı ayarlamak kolay olsun diye ekledim o ,c,
        char key;//klavyedeki tuş 

        while (true) {
            key = s.next().charAt(0);//klavyeden tuş giriliyot

            if (frame % 2 == 0) {
                move(key, board);// o ağzı kapalı
            } else {
                move2(key, board);//c ağzı açık 
            }

            gameBoard(board);//oyun ekranını gösterir
            frame++;
            if (chkWin(board)) {//her tur oyunun bitip bitmediğini kontrol eder
                break;
            }

        }
        System.out.println("Oyun bitti tüm yemler yendi");//oyun bitince döngüden çıkılır
        gameOver();//game over yazar ekrana

    }

  // public static String[] board(/*int width ,int height*/) {//hayal kurdum .yükseklik ve genişlik verileri ile bişey yaparım belki ilerde
     //   String[] board = new String[140];
      //  for (int i = 0; i < 140; i++) {
       //     board[i] = "•";
     //  1 }
   //     return board;
 //   } //burası oyun ekranı büyütme denemesinden kalmış  önemli değil 

    public static void gameBoard(String board[]) {//bizim board dizisini kare şekilde yazan metod
        System.out.println();  
        for (int i = 0; i < 28; i++) {
            System.out.print(board[i]);
            if (i == 6 || i == 13 || i == 20 /*|| i == 22 || i == 99 || i == 119 || i == 139*/) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

 /*   public static String[] Obstackles(String[] board) {//rastgele duvar oluşturan method ama bunu büyük ekranda kullandım önemli değil şuan
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
                board[n] = "|";
            } else {
                board[n] = "_";
            }
        }
        return board;
    } */

    public static boolean chkWin(String[] board) {//oyunda hiç • (yemek) kalmazsa true döndürüp main void if içindeki breaki aktif edip oyunu bitiriyor.
        boolean win = true;
        for (int i = 0; i < 28; i++) {
            if (board[i].equals("•")) {
                win = false;
            }

        }

        return win;
    }

    public static int findHead(int here, String[] board) {//oyunda pacmanin dizideki yerini buluyor 
        for (int i = 0; i < 28; i++) {
            if (board[i].equals("c") || board[i].equals("o") || board[i].equals("ↄ")) {
                here = i;
            }
        }
        return here;
    }

    public static String[] move(char move, String[] board) {//tüm pacman hareketlerinı bu method yapıyor
        int go = findHead(1, board);//dizideki pacmanin konumunu int olarak go'ya atıyor

        if (move == 'A') {
            if (wallChkA(board)) {
                board[go - 1] = "o";//bir sola gidiyor
                board[go] = " ";//bi önceki konumundaki •(yemek)'i siliyor.Yani yenmiş oluyor.
            }
        } else if (move == 'D') {
            if (wallChkD(board)) {
                board[go + 1] = "o";
                board[go] = " ";
            }
        } else if (move == 'W') {
            if (wallChkW(board)) {
                board[go - 7] = "o";
                board[go] = " ";
            }
        } else if (move == 'S') {
            if (wallChkS(board)) {
                board[go + 7] = "o";
                board[go] = " ";
            }
        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");//eğer WASD yerine a bile yazılsa pacman hareket etmiyor

        }
        return board;

    }

    public static String[] move2(char move, String[] board) {//ağzı aç kapa animasyonunu 2farklı method yazarak yapmayı becerebildim
        int go = findHead(1, board);
                                                                //mutlaka daha kolay yöntemi vardır ama
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
                board[go - 7] = "c";
                board[go] = " ";
            }
        } else if (move == 'S') {
            if (wallChkS(board)) {
                board[go + 7] = "c";
                board[go] = " ";
            }
        } else {
            System.out.println("lütfen sadece büyük WASD tuşları kullanın");

        }
        return board;

    }

    public static boolean wallChkA(String[] board) {//A'ya basarsa duvar var mı varsa hareket etmesini engellemeye yarayan metod
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go - 1].equals("|") || board[go - 1].equals("_")) {
            chk = false;
        }

        return chk;

    }

    public static boolean wallChkD(String[] board) {//her bir karakter için ayrı method yazdım
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go + 1].equals("|") || board[go + 1].equals("_")) {//eğer nir adımsağda duvar varsa false döndür ve hareket etmesin pacman
            chk = false;
        }

        return chk;

    }

    public static boolean wallChkW(String[] board) {//duvarı kontrol ediyor her tuş için
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go - 7].equals("|") || board[go - 7].equals("_")) {
            chk = false;
        }

        return chk;

    }

    public static boolean wallChkS(String[] board) {
        boolean chk = true;
        int go = findHead(1, board);
        if (board[go + 7].equals("|") || board[go + 7].equals("_")) {
            chk = false;
        }

        return chk;

    }

    public static void startScreen() {//ascii arts
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
}
