

public class Tenis {
public static void main(String[] args) {
        int hasarA =0;
        int hasarB =0;
        int a =0 ;
        int b= 0 ;
        int tur =0;
        while(a<11&&b<11){
                        
        hasarA=(int)(Math.random()*10);        
        hasarB=(int)(Math.random()*10);
        if (hasarA<hasarB){
            a++ ;
        }
        else if(hasarA>hasarB){
            b++ ;
        }
        else{
            b++;
            a++;
        }
        System.out.println("skor A:"+a+" - B:"+b);
        if (a+b==20)
        if (a==11||b==11){
            if(a>b)
            System.out.println("A kazandı");        
                if(b>a)
                System.out.println("B kazandı");
                    
        }
        }
            
}    
}
