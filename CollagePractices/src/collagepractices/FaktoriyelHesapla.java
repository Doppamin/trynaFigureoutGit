package collagepractices;


import java.util.Scanner;
public class FaktoriyelHesapla {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in) ;
        
        int sayi =1 ;
        
       while (sayi !=-1){
           
        System.out.println("Bir sayi giriniz");
        sayi=sc.nextInt();
               if(sayi==-1){
                   System.out.println("fuck you");
               break;
               }
        int sonuc =faktoriyel(sayi);
        System.out.println("girilen sayinin faktporiyeli="+sonuc);
       }        
    }
    public static int faktoriyel (int n1){
    int faktoriyel =1 ;
        for (int i = 1; i <= n1; i++) {
            faktoriyel*=i;
        }
        return faktoriyel;
    }
            
            
}
