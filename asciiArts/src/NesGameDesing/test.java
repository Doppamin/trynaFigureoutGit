/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NesGameDesing;


public class test {
    private static String codedMario="000000222222222200000000\n" +
                            "000022222222222222222200\n" +
                            "000033333311113311000000\n" +
                            "003311331111113311111100\n" +
                            "003311333311111133111111\n" +
                            "003333111111113333333300\n" +
                            "000000111111111111110000\n" +
                            "000033332233333300000000\n" +
                            "003333332233332233333300\n" +
                            "333333332222222233333333\n" +
                            "111133221122221122331111\n" +
                            "111111222222222222111111\n" +
                            "111122222222222222221111\n" +
                            "000022222200002222220000\n" +
                            "003333330000000033333300\n" +
                            "333333330000000033333333" ;
                                   //  white ,     yellow         red         black
   private  static String[] colors={"\033[0;37m","\033[0;33m","\033[0;31m","\033[0;30m"};
    private char c=' ';
    public static void main(String[] args) {
        printMario();

    }
    static void printMario(){
        for (int i = 0; i < codedMario.length(); i++) {
            if(codedMario.charAt(i)==0){
                codedMario.charAt(i)=c;
            }
        }
        
    }
    
}
