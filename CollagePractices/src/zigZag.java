

import java.util.Scanner;

public class zigZag {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = 1;
        int c = 0;
        while (a == 1) {

            for (int i = 15; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    //if (j == i - c) 
                     //   System.out.print("*");
                   
                  System.out.print(" ");

                }
                System.out.print("*");

               // char b = s.next().charAt(0);

                System.out.println("");
                //c++;
            }

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");

                }

                System.out.print("*");
             //   char b = s.next().charAt(0);

                System.out.println("");

            }
        }

    }

}
