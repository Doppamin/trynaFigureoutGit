
import java.util.Scanner;

public class TKMGame {
    public static void main(String[] args) {
   

        for (int i = 0; i < 10; i++) {
            
         int comp=(int)(Math.random()*9);//012,345,678
        Scanner sc =new Scanner(System.in);
        String human =sc.nextLine(); 
        if("T".equals(human)&&comp<=3)   {  
            System.out.println("Berabere ");
            System.out.println(comp);
        }   
        else if ("T".equals(human)&&3<comp&&comp<=6) {
             System.out.println("Kaybettin");
                            System.out.println(comp);

        }
          else if ("T".equals(human)&&6<comp&&comp<=9) {
             System.out.println("kazandın");
                         System.out.println(comp);

        }
        else if ("K".equals(human)&&1<comp&&comp<=3) {
             System.out.println("kazandın");
                         System.out.println(comp);

        }
        else if ("K".equals(human)&&3<comp&&comp<=6) {
             System.out.println("Berabere");
                         System.out.println(comp);

        }
         else if ("K".equals(human)&&6<comp&&comp<=9) {
             System.out.println("KaybettinK");
                         System.out.println(comp);

         }
         else if ("M".equals(human)&&1<comp&&comp<=3) {
             System.out.println("Kaybettin");
                         System.out.println(comp);

        }
         else if ("M".equals(human)&&3<comp&&comp<=6) {
             System.out.println("kazandın");
                         System.out.println(comp);

        }
          else if ("M".equals(human)&&6<comp&&comp<=9) {
             System.out.println("Beraber");
                         System.out.println(comp);

         }
          else{
        
             System.out.println("Lütfen T K yada M girin");
         }
     
        }
    }
    }
         
    
    
