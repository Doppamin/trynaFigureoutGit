/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * this is the office refrences don't get this wrong
 */
public class Password {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Kullanıcı Adı: ");
        String kullanıcı = scn.next();
        System.out.print("Şifre: ");
        String sifre = scn.next();
        if (kullanıcı.equals("Hudayi") && sifre.equals("bigboobz69")) {
            System.out.println("Başarıyla sisteme giriş yaptınız");
        } else if (!kullanıcı.equals("Hudayi") && sifre.equals("bigboobz")) {
            System.out.println("Yanlış kullanıcı adı ");
        } else if (kullanıcı.equals("Hudayi") && !sifre.equals("bigboobz")) {
            System.out.println("Hatalı şifre");
        } else {
            System.out.println("hatalı giriş");
        }

    }

}
