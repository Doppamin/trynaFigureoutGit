
import java.util.Scanner;

public class netBeans {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean oku = true;
        String syntax = s.next();
        char[] compile = {'o', 'k', 'u', '(', '"'};//oku("a")
        
        for (int i = 0; i < 5; i++) {
            
            if (syntax.charAt(i) != compile[i]) {
                oku = false;
            }

        }if (syntax.charAt(syntax.length() - 1) != ')' || syntax.charAt(syntax.length() - 2) != '"') {
            oku = false;
        } if (oku) {
            
            for (int i = 5; i < syntax.length() - 2; i++) {
                System.out.print(syntax.charAt(i));
            }

        } /*else {
            System.out.println("eror");
        }*/
        //-----------------------------------
        boolean top=true;
        char[] topla={'t','o','p','('};//top(5,5)
         for (int i = 0; i < 4; i++) {
            
            if (syntax.charAt(i) != topla[i]) {
                top = false;
            }           

    }
         if(syntax.charAt(syntax.length() - 1) != ')'||syntax.charAt(syntax.length() - 3) != ','){
             top=false;
         }
         
         if(top){
             int a=(int)syntax.charAt(4);
             int b=(int)syntax.charAt(6);
             
            
                              System.out.println((a+b)-96);

                 
             
             
            }
         
         //-----------------------------------,
          boolean cik=true;
        char[] cikar={'c','i','k','('};//top(5,5)
         for (int i = 0; i < 4; i++) {
            
            if (syntax.charAt(i) != cikar[i]) {
                cik = false;
            }           

    }
         if(syntax.charAt(syntax.length() - 1) != ')'||syntax.charAt(syntax.length() - 3) != ','){
             cik=false;
         }
         
         if(cik){
             int a=(int)syntax.charAt(4);
             int b=(int)syntax.charAt(6);
             
            
                              System.out.println(a-b);

         
             
         }
    }
    }

