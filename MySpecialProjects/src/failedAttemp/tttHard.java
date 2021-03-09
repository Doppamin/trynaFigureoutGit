package failedAttemp;

import java.util.Scanner;
public class tttHard {
    public static void main(String[] args) {
       String[] tic = {",", ".", ",", ".", "O", ".", ",", ".", ","};
          gameBoard(tic);
        Scanner scn = new Scanner(System.in);
        int i = 1;
        while (i < 10) {
            int choose = scn.nextInt();
            tic[choose - 1] = "X";
            gameBoard(tic);
            if (winLose(tic)) {
                System.out.println("Tebrikler Sen Kazandın");
                break;
            }
            System.out.println("");
            Hardcomputer(tic,i);
                        gameBoard(tic);
            i++;
       
        
    }
    }
//print gameboard method
    public static void gameBoard(String tic[]) {
        for (int i = 0; i < 9; i++) {
            System.out.print(tic[i] + " ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
        }
    }
    //creat computer ai but random

    public static String[] Hardcomputer(String[] tic,int turn) {
        int compNum = 0;
        if(tic[7].equals("X")|| tic[3].equals("X")&&turn==1){
           compNum=6;            
        }
        else if   (tic[0].equals("X")|| tic[8].equals("X")||tic[1].equals("X")|| tic[5].equals("X")&&turn==1){
           compNum=2;            
        }
        else if(tic[6].equals("X")|| tic[2].equals("X")&&turn==1){
           compNum=0;            
        }
        else if(!tic[6].equals("X")&&turn==2){
           compNum=5;            
        }
        
        tic[compNum] = "O";
        return tic;

    }    //type all win conditions in switch

    public static boolean winLose(String[] tic) {
        boolean a = false;
        if (tic[0].equals(tic[1]) && tic[1].equals(tic[2])) {
            a = true;
        } else if (tic[3].equals(tic[4]) && tic[4].equals(tic[5])) {
            a = true;
        } else if (tic[6].equals(tic[7]) && tic[7].equals(tic[8])) {
            a = true;
        } else if (tic[0].equals(tic[3]) && tic[3].equals(tic[6])) {
            a = true;
        } else if (tic[1].equals(tic[4]) && tic[4].equals(tic[7])) {
            a = true;
        } else if (tic[2].equals(tic[5]) && tic[5].equals(tic[8])) {
            a = true;
        } else if (tic[0].equals(tic[4]) && tic[4].equals(tic[8])) {
            a = true;
        } else if (tic[2].equals(tic[4]) && tic[4].equals(tic[6])) {
            a = true;
        } else {
            a = false;
        }
        return a;
    
    }
    
}
