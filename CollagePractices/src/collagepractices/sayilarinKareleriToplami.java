package collagepractices;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

public class sayilarinKareleriToplami {

  
    public static void main(String[] args) {
        System.out.println("lütfen sayı giriniz");
          Scanner sc=new Scanner(System.in);
          int yeni=sc.nextInt() ;
                    int son = 0;           
        for (int i = 1; i <=yeni; i++) {
                        int ban = i*i;
                        son=ban+son;  
                        
                        
                                }
        System.out.println("Girdiğiniz sayıya kadar olan sayının kareleri toplamı");
  System.out.println(son);
      }
    
}
