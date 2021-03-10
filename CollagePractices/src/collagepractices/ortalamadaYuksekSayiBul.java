package collagepractices;


import java.util.Scanner;

public class ortalamadaYuksekSayiBul {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=4 ;
        int toplam = 0 ;
              
        int[] liste= new int[n];
        for (int i = 0; i < n; i++) {
            liste[i]=s.nextInt();
             toplam+=liste[i];
        }
int ortalama =toplam/n;
int count =0;
        for (int i = 0; i < n; i++) {
            if(liste[i]>ortalama)
                count ++;
        }
            
        
        System.out.println("girdiğiniz sayıların ortalaması "+ortalama);
                 System.out.println("ortalamadan yüksek "+count+" tane sayı var");

    }
    
}
