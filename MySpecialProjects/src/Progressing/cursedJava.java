
package Progressing;

public class cursedJava {
    
    
    
    public static void main(String[] args) {
        
        

        HelloWorld("System.out.print");
        
            yaz(5);
            System.out.println(faktor(6)); 
        
        /*do(a<10){
        
        
        }while{
        
        }*/
                
      /*if(int i=0;i<10;i++){
        
                
         }
        
        5<0==true
        1>0==false
        */
                
       
        
   
    }
    
    
    
    
    
    public static int yaz(int n) {
        if(n==0){
            System.out.println(n);
            return 0 ;
            
        }else{           
            System.out.println(n);
             n--;
              yaz(n);
            return n;

        }
        
    }
    
    public static int faktor(int n) {
        if(n==0){
            return 1;
        }else{
            return n*faktor(--n);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void HelloWorld(String n){
        
        System.out.println(n);
       // HelloWorld(n);
        
    }
 
    


}
