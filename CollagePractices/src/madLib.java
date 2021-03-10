/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.Scanner;

public class madLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        oku("bir isim yazın");
        String isim1= s.next();
        oku("bir eşya ya da cihaz yazın");
        String cihaz1=s.next();
        oku("bir aile-akraba üyesi yazın");
        String aile=s.next();      
        oku("bir zarf");
        String zarf=s.next();
        oku("gelecek zaman 1.kişiden fiil-...eceğim/acağım");
        String fiil1=s.next();
        oku("2 tane eşya");
        String esya1=s.next();
        String esya2=s.next();
       
        // TODO code application logic here
        
        System.out.println(isim1+" çok seven Veysel ,eline bir "+cihaz1+" alır.\n" +
                            "Veyseli gören "+aile+" Elindeki Aletle ne yapapacaksın diye sorar\".\n" +
                            "Veysel sessizce "+fiil1+" dedi."+aile+ "si gülümseyerek\n" +
                            "Nasıl yapacağını merak ettim dedi.\n" +
                            "Veysel de "+esya1+" ve "+esya2+"i bozup tamir ederek dedi.");
    }
    
    
    
    public static void oku(String args) {
        System.out.println(args);
        
    }
    
}
