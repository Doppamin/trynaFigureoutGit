
import java.util.Scanner;



public class deal_or_noDeal {
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

int[] boxes={1,2,3,4,5,6,7,8,9,10};
int[] values={1,10,50,100,200,1000,10000,5000,25000,50000};
int[] chosenval={1,10,50,100,200,1000,10000,5000,25000,50000};
int[] acilmisKutu=new int[10];
int t=0;//tur sayısı
s("Kutunuzu seçin");
int choose=s.nextInt();
s(choose+"numaralı kutunuyu seçtiniz");
acilmisKutu[t]=choose;
t++;
s("şimdi Açacağınız kutuyu seçin");
mixbox(chosenval);
while(t<11){
shwbox(values);


choose=s.nextInt();
while(chkAcilanKutu(acilmisKutu,choose)){
    s("lütfen seçmediğiniz kutuyu seçin");
     choose=s.nextInt();
}
acilmisKutu[t]=choose;
System.out.println(chosenval[choose-1]);
paraSil(values,chosenval[choose-1]);
//chosenval[choose-1]=0;
t++;
kutuAc();
if(t%3==0){
    s("Hamdi Beyin Teklifi"+hamdiBey(values));
}
s("tekrar Açacağınız kutuyu seçin");
}
    }
     //show all boxes and value method
    public static void shwbox(int[]box){//dizileri gösteriyor
        int j=10;
        for (int i = 0 ; i < 5; i++) {
            if(box[i]==1){
            System.out.print("  ");
            }if(box[i]==10|| box[i]==50){
            System.out.print(" ");
            }
           
            System.out.print(box[i]+"      ");
            j--;
             System.out.print(box[j]);            
            System.out.println();      
    }
    }    
    
    //give random value to all boxes
    public static int[] mixbox(int[] box){//value dizisini karıştırıyor
        int temp=0;
        int mix=0;
        int mix2=0;
        for (int i = 0; i < 50; i++) {          
            mix=(int)(Math.random()*10);
            mix2=(int)(Math.random()*10);
            temp=box[mix];
            box[mix]=box[mix2];
            box[mix2]=temp;
                        
        }
        return box;
        

    }
    
    public static int[]paraSil(int[]kutu,int hangi){
        for (int i = 0; i < kutu.length; i++) {
            if(kutu[i]==hangi){
                kutu[i]=0;
            }            
        }
        return kutu;
    }
    //delete the chosen box and its value
    public static boolean chkAcilanKutu(int[]acilanKutu,int secim){
            for (int i = 0; i < acilanKutu.length; i++) {
            if(acilanKutu[i]==secim){
                return true;
            }
        }
        return false;
        
    }

public static void s(String s){//sadece string yazmak için kolaylık
    System.out.println(s);
}
//phone call method
public static int hamdiBey(int[]boxes){
    int sum=0;
    int countZero=0;
    for (int i = 0; i < boxes.length; i++) {
        sum+=boxes[i];
        if(boxes[i]==0)
            countZero++;
        
    }
    return sum/(boxes.length-countZero) ;
    
}

public static void kutular(int[]box,String[] kutu){
    int t=0;
    while(t<2){
    for (int i = 0; i < box.length; i++) {
        for (int j = 0; j < 5; j++) {
            
        }
        
        if(i==9){
            t++;
        }
    }
    }
}

public static void kapaliKutu(int num){
System.out.println("┌──────┐");
System.out.println("|¯¯────|");
System.out.println("|"+num+"     |");
System.out.println("└──────┘");
}

public static void acikKutu(){

System.out.println("┌──────┐");
System.out.println("|500000|");
System.out.println("|______|");
System.out.println("|──────|");
System.out.println("| 5    |");
System.out.println("└──────┘");
}

public static String[]kutular(int num){
     String[]kutu={"┌──────┐","|¯¯────|","|"+num+"     |","└──────┘"};
     return kutu;
}
public static void kutuAc(){
      int num=0;
        
                     for (int i = 0; i < 4; i++) {
                         num=0;
            for (int j = 0; j < 5; j++) {
                  num=j+1;
                 String[]kutu={"┌──────┐","|¯¯────|","| "+num+"    |","└──────┘"};
                 String[]kutu0={"┌──────┐","|¯¯────|","| "+num+"   |","└──────┘"};
                 String[]kutux={"┌──────┐","|  \\/  |","|  /\\  |","└──────┘"};
                 if(j!=3)
                 System.out.print(kutu[i]+"   ");
                 
                 else
                 System.out.print(kutux[i]+"   ");
   
              
                        }
                         System.out.println();
                         
        }
                                              System.out.println();
                                              

                      for (int i = 0; i < 4; i++) {
                         num=0;
            for (int j = 5; j < 10; j++) {
                  num=j+1;
                 String[]kutu={"┌──────┐","|¯¯────|","| "+num+"    |","└──────┘"};
                 String[]kutu0={"┌──────┐","|¯¯────|","| "+num+"   |","└──────┘"};
                 String[]kutuX={"┌──────┐","|  \\/  |","|  /\\   |","└──────┘"};
            if(j!=9){
                System.out.print(kutu[i]+"   ");
                }
                else{
                System.out.print(kutu0[i]+"   ");

                }         
                
              
                        }
                         System.out.println();
                         
        }
}
       
    //chose ,show and open box method
  /*  public static int choose(int[]box,int key){
        
        switch(key){
             case 1:box[1];break;
             case 2:
             case 3:
             case 4:
             case 5:
             case 6:
             case 7:
             case 8:
             case 9:
             case 10:

        }
    } */
    
    
    
    
    
   
    //end game method

    }   

