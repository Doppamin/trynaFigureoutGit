package failedAttemp;
/*
type this sentence fastest as  possible then press enter. And then your compailer will tell how long it took .Also your wrog type
Hızlı yazı testi sonunda netbdans programın kaç sani sürdüpğünü söylüyor.Yazılımsal değil donanımsal gibi çünkü süre eklemeyi bilmiyorum hala
aslında googlellayabilirdim ama müfredat dışı olunca anlamı kalmaz
*/

import java.util.Scanner;

public class typingTest {
    public static void main(String[] args) {
        String first="hizliyazitestibirikion";
        Scanner s =new Scanner(System.in);
        String firstchck=s.next();
        int count=0;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)==firstchck.charAt(i)){
                System.out.print(first.charAt(i));
            }else{
                System.out.print("-");
                count++;
            }                   
        }
                System.out.println();

        System.out.println(count+" harf yanlış yazdın");
      
            
        
    }}
