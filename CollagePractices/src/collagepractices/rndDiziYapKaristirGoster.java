package collagepractices;


public class rndDiziYapKaristirGoster {
       public static void main(String[]args){           
           int[] seri ={1,2,3,4,5};
           int c=0;           
           for (int i = 0; i < 10; i++) {
               int a =(int)(Math.random()*5);
               int b =(int)(Math.random()*5);               
              c= seri[a];
               seri[a]=seri[b];
               seri[b]=c;
                  }
           for (int i = 0; i < 5; i++) {
               System.out.println(seri[i]);              
           }         
                      
       }           
   
        
    
}
