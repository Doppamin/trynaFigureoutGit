package collagepractices;


import java.util.Scanner;

public class TersYaz {
    public static void main(String[] args) {
 String kelime ;
 Scanner s =new Scanner(System.in);
 kelime=s.next();
 reverse(kelime);
    }
    
    public static void reverse(String kelime){
        
        for (int i = kelime.length(); i >0; i--) {
            System.out.print(kelime.charAt(i-1));
            
        }
        
    }
    
}
