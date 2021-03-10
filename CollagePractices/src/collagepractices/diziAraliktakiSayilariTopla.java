package collagepractices;

import java.util.Scanner;
public class diziAraliktakiSayilariTopla {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        System.out.println("Sayılrı girin");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int toplam = 0;
        int[] list = {5, 6, 1, 8, 3, 1, 8, 6, 5, 8};
        for (int i = 0; i < 10; i++) {
            if (i >= n1 && i <= n2) {
                toplam += list[i];
                System.out.print(list[i]);
                
            if(i==n2)
                 continue;
            
                System.out.print(" + ");

            }

        }
        System.out.print(" = ");
        System.out.print(toplam);
    }

}
