//11/12/2020
import java.util.Scanner;

public class Sokoban {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] board = {{'▄', '▄', '▄', '▄', '▄', '▄', '▄', '▄', '▄', '▄'},
                          {'█', '▣', '.', '█', '.', '.', '.', '.', '.', '█'},
                          {'█', '.', '.', '.', '.', '▄', '▄', '.', '.', '█'},
                          {'█', '.', '.', '.', '□', '□', '.', '.', ' ', '█'},
                          {'█', '☺', '.', '.', '.', '.', '.', '█', '.', '█'},
                          {'█', '▄', '▄', '▄', '▄', '▄', '▄', '▄', '▄', '█'}};
        int[] box;
        char key;
        //int[] head;
        //int b=0;
        startScrn();
        System.out.println("Devam etmek için herhangi bir tuşa basın");
         key = s.next().charAt(0);
        while (true) {
            shwbrd(board);
            box =findBox(board);             
            key = s.next().charAt(0);
            move(key, board);
            // shwbrd(board);
            //head=findHead(board);
            if(board[box[0]][box[1]]=='□'){ //if(chckwin)
                break;
            }
            
            if(board[box[0]][box[1]]!='☺'){
            board[box[0]][box[1]]='▣';
                       // shwbrd(board);

            }
           
                               
        }shwbrd(board);

        System.out.println("Oyun bitti");
        endScrn();

    }
    

    public static void shwbrd(char[][] board) {
            for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
            
    }

    public static int[] findHead(char[][] board) {
        int[] location = new int[2];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == '☺') {
                    location[0] = i;
                    location[1] = j;
                }

            }
        }
        return location;

    }

    public static char[][] move(char key, char[][] board) {
        int[] del = findHead(board);
        int y = del[0];
        int x = del[1];
       // int i = 0;

        if (key == 'A' && board[y][x - 1] != '█' && board[y][x - 1] != '▄') {//AAAAAAAAAAAAAAAAAAAAAAAAAAAA
            if (board[y][x - 1] == '□'&&board[y][x -2] == '.') {
                board[y][x - 2] = '□';
                x--;
                board[y][x] = '☺';
                x++;
                board[y][x] = '.';
            } else if (board[y][x - 1] == '□' && board[y][x - 2] == '█') {
            } else if (board[y][x - 1] == '□' && board[y][x - 2] == '▄') {

            }  else if (board[y][x - 1] == '□' && board[y][x - 2] == '▣') {
                 board[y][x - 2] = '□';
                x--;
                board[y][x] = '☺';
                x++;
                board[y][x] = '.';
                       
            } else if (board[y][x - 1] == '□' && board[y][x - 2] == '□'&& board[y][x - 3] == '▣') {
                board[y][x-2]='□';
                board[y][x - 3]='□';
                 x--;
                board[y][x] = '☺';
                x++;
                board[y][x] = '.';
            }else if (board[y][x - 1] == '□' && board[y][x - 2] == '□'&& board[y][x - 3] == '.') {
                board[y][x-2]='□';
                board[y][x - 3]='□';
                 x--;
                board[y][x] = '☺';
                x++;
                board[y][x] = '.';
            }else if (board[y][x - 1] == '□' && board[y][x - 2] == '□'&& board[y][x - 3] == '█') {
            }else if (board[y][x - 1] == '□' && board[y][x - 2] == '□'&& board[y][x - 3] == '▄') {
                
            }else {
                x--;
                board[y][x] = '☺';
                x++;
                board[y][x] = '.';
            }

        } else if (key == 'D' && board[y][x + 1] != '█' && board[y][x + 1] != '▄') {//DDDDDDDDDDDDDDDDDDDDDDDD
            if (board[y][x + 1] == '□' && board[y][x + 2] == '.') {
                board[y][x + 2] = '□';
                x++;
                board[y][x] = '☺';

                x--;
                board[y][x] = '.';
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '█') {
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '▄') {
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '▣') {
                board[y][x + 2] = '□';
                x++;
                board[y][x] = '☺';

                x--;
                board[y][x] = '.';
            } else if (board[y][x + 1] == '□' && board[y][x + 2] == '□'&& board[y][x + 3] == '.') {
                board[y][x + 2] = '□';
                board[y][x + 3] = '□';
                x++;
                board[y][x] = '☺';

                x--;
                board[y][x] = '.';
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '□'&& board[y][x + 3] == '▣') {
                board[y][x + 2] = '□';
                board[y][x + 3] = '□';
                x++;
                board[y][x] = '☺';

                x--;
                board[y][x] = '.';
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '□'&& board[y][x + 3] == '█'){
            }else if (board[y][x + 1] == '□' && board[y][x + 2] == '□'&& board[y][x + 3] == '▄'){   
            } else {
                x++;
                board[y][x] = '☺';

                x--;
                board[y][x] = '.';
            }

        } else if (key == 'W' && board[y - 1][x] != '█' && board[y - 1][x] != '▄') {//WWWWWWWWWWWWWWWWWWWWWWWWWW
            if (board[y - 1][x] == '□'&& board[y-2][x] == '.') {
                board[y - 2][x] = '□';
                y--;

                board[y][x] = '☺';
                y++;
                board[y][x] = '.';

            } else if (board[y-1][x] == '□' && board[y-2][x] == '▄') { 
            } else if (board[y-1][x] == '□' && board[y-2][x] == '█') {
            } else if (board[y-1][x] == '□' && board[y-2][x] == '▣') { 
                    board[y - 2][x] = '□';
                y--;

                board[y][x] = '☺';
                y++;
                board[y][x] = '.';

            } else if (board[y-1][x] == '□' && board[y-2][x] == '□'&& board[y-3][x] == '.') {
                board[y - 3][x] = '□';
                 board[y - 2][x] = '□';
                  y--;
                board[y][x] = '☺';
                y++;
                board[y][x] = '.';

                
            } else if (board[y-1][x] == '□' && board[y-2][x] == '□'&& board[y-3][x] == '▣') {
                 board[y - 3][x] = '□';
                 board[y - 2][x] = '□';
                  y--;
                board[y][x] = '☺';
                y++;
                board[y][x] = '.';
  
            } else if (board[y-1][x] == '□' && board[y-2][x] == '□'&& board[y-3][x] == '▄') {
            } else if (board[y-1][x] == '□' && board[y-2][x] == '□'&& board[y-3][x] == '█') {   
            } else {
                y--;

                board[y][x] = '☺';
                y++;
                board[y][x] = '.';
            }

        } else if (key == 'S' && board[y + 1][x] != '█' && board[y + 1][x] != '▄') {//SSSSSSSSSSSSSS
            if (board[y + 1][x] == '□'&& board[y+2][x] == '.') {
                board[y + 2][x] = '□';
                y++;
                board[y][x] = '☺';
                y--;
                board[y][x] = '.';
            } else if (board[y+1][x] == '□' && board[y+2][x] == '▄') { 
            } else if (board[y+1][x] == '□' && board[y+2][x] == '█') { 
            } else if (board[y+1][x] == '□' && board[y+2][x] == '▣') {
                board[y + 2][x] = '□';
                y++;
                board[y][x] = '☺';
                y--;
                board[y][x] = '.';
            } else if (board[y+1][x] == '□' && board[y+2][x] == '□'&& board[y+3][x] == '.') {
                 board[y + 3][x] = '□';
                 board[y + 2][x] = '□';
                  y++;
                board[y][x] = '☺';
                y--;
                board[y][x] = '.';

                
            }else if (board[y+1][x] == '□' && board[y+2][x] == '□'&& board[y+3][x] == '▣') {
                 board[y + 3][x] = '□';
                 board[y + 2][x] = '□';
                  y++;
                board[y][x] = '☺';
                y--;
                board[y][x] = '.';

                
            }else if (board[y+1][x] == '□' && board[y+2][x] == '□'&& board[y+3][x] == '▄') {
            }else if (board[y+1][x] == '□' && board[y+2][x] == '□'&& board[y+3][x] == '█') {   
            }else {
                y++;
                board[y][x] = '☺';
                y--;
                board[y][x] = '.';
            }
        } else {
            System.out.println("Sadece büyük AWSD tuşlarına basmalısınız");
        }

        return board;
    }
    public static boolean chkwin(char[][] board){//kullanılmıyor
        boolean result=false;
        int a []=findBox(board);
       int x=a[0];
        if (x==-1){
            result=true;//if(chkwin){
        }               //break;
          
        return result;
    }
    public static int[] findBox(char[][]board){
         int[] location = new int[2];
         location[1]=1;
         location[0]=1;
                 
        for (int i = 0; i < 6; i++) {//çalışmıyor nedenini bilmiyorum
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == '▣') {
                    location[0] = i;
                    location[1] = j;
                }}}             
        
        return location;
        
    }
    public static void startScrn(){
System.out.println("                   _             _ _          "); 
System.out.println("   /\\  /\\_   _  __| | __ _ _   _(_| )__       "); 
System.out.println("  / /_/ / | | |/ _` |/ _` | | | | |/ __|      "); 
System.out.println(" / __  /| |_| | (_| | (_| | |_| | |\\__ \\      "); 
System.out.println(" \\/ /_/  \\__,_|\\__,_|\\__,_|\\__, |_||___/      "); 
System.out.println("                           |___/              "); 
System.out.println(" __       _           ___                     "); 
System.out.println("/ _\\ ___ | | _____   /   \\___ _ __ ___   ___  ");
System.out.println("\\ \\ / _ \\| |/ / _ \\ / /\\ / _ \\ '_ ` _ \\ / _ \\ ");
System.out.println("_\\ \\ (_) |   < (_) / /_//  __/ | | | | | (_) |");
System.out.println("\\__/\\___/|_|\\_\\___/___,' \\___|_| |_| |_|\\___/ ");
    }
   public static void endScrn(){
System.out.println(" __     __          __          __          ");        
System.out.println(" \\ \\   / /          \\ \\        / /          ");
System.out.println("  \\ \\_/ /__  _   _   \\ \\  /\\  / /__  _ __   ");
System.out.println("   \\   / _ \\| | | |   \\ \\/  \\/ / _ \\| '_ \\  ");
System.out.println("    | | (_) | |_| |    \\  /\\  / (_) | | | | ");
System.out.println("    |_|\\___/ \\__,_|     \\/  \\/ \\___/|_| |_| ");
                                           
                                           
   }

}
