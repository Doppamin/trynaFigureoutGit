import java.util.Scanner;
public class CikarmaOyunu {
    public static void main(String[] args) {
        int sayi1 = (int) (Math.random() * 10);
        int sayi2 = (int) (Math.random() * 10);
        if (sayi2 <= sayi1) {
            System.out.println(sayi1 + "-" + sayi2 + "=?");
            Scanner sc = new Scanner(System.in);
            int sonuc = sc.nextInt();
            if (sonuc == sayi1 - sayi2) {
                System.out.println("tebrikler sonucunuz doğru");
            } else {
                int a = sayi1 - sayi2;
                System.out.println("Hatalı sonuç buldunuz,doğru cevap=" + a);
            }
        } 
        else {
            System.out.println(sayi2 + "-" + sayi1 + "=?");
            Scanner sc = new Scanner(System.in);
            int sonuc = sc.nextInt();
            if (sonuc == sayi2 - sayi1) {
                System.out.println("tebrikler sonucunuz doğru");
            } else {
                int a = sayi2 - sayi1;

                System.out.println("Hatalı sonuç buldunuz,doğru cevap=" + a);
            }
        }
    }
}
