//23/12/2020
import java.util.Scanner;

public class Takla {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       String n;
       while(true){
        
           f(" o");
           f("/|\\");
           f("/ \\");
           n=s.next();
           f("\\o/");
           f(" |");
           f("/ \\");
           n=s.next();
           f("_ o");
           f(" /\\");
           f("| \\");
           n=s.next();
           f("    ");
           f(" ___\\o");
           f("/)  |");
           n=s.next();
           f(" __|");   //__|
           f("   \\o");//   \o
           f("  ( \\");//   ( \
           n=s.next();
           f("  \\ /");
           f("   |");
           f("  /o\\");
           n=s.next();
           f("      |__   ");
           f("    o/    ");
           f("   / )    ");
           n=s.next();
           f("      ");
           f("     o/__");
           f("     |  (\\");
           n=s.next();
           f("       o _  ");
           f("       /\\    ");
           f("       / | ");
           n=s.next();
           f("       \\o/ ");
           f("        |      ");
           f("       / \\       ");
           n=s.next();
           f("        o   ");
           f("       /|\\ ");
           f("       / \\ ");
           n=s.next();
       }            
              
        
    }
    
    public static void f(String n){
        System.out.println(n);
        
    }
    
 /* o  \ o / _ o       __|   \ /    |__      o _ \ o /  o
   /|\   |    /\  ___\o  \o   |   o/   o/__  /\    |   /|\
   / \  / \  | \ /)  |   ( \ /o\ / )   |  (\ / |  / \  / \  */
    
}
