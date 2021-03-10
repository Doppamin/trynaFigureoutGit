import java.util.Scanner;
public class betterTKM {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char hmn =s.next().charAt(0);//human
        int count=0;//secret
        while(hmn!='R'&&hmn!='P'&&hmn!='S'){//if player didn't choose RPS if will goes infinite
            System.out.println("pls just type R,P or S");
            hmn =s.next().charAt(0);
            count++;
            if(count>3){
                System.out.println("F@@k you ");
                int[]f={0};
                f[1]=0;
            }            
        }    
        
        char com[]={'R','P','S'};//computer
        int c = (int)(Math.random()*3);//random computer number for array
        
        for (int i = 0; i < 2; i++) {//for visualize
            char a=' ';//input for switch case
            if(i==0)//first turn human will shown
                a=hmn;
            else//second turn computer
                a=com[c];
            
            switch(a){ 
                case 'R':  rock(); break;
                case 'P': paper(); break;
                case 'S': sciss(); 
            }
            System.out.println();
          
             if(i==0){          
                 vs();//just vs visulize
             
             System.out.println();
             }
        }
                       
        if(hmn==com[c]){
            System.out.println("It's a tie");
        }else if((hmn=='R'&&c==2)||(hmn=='P'&&c==0)||(hmn=='S'&&c==1)){//com[]={'R','P','S'}
            System.out.println("You won");
            won();
            
        }else{
            System.out.println("You lost");
            lost();
        }
        //furthermore just pictures
        

    }public static void  rock(){
        
        System.out.println("    _______     ");
        System.out.println("---'   ____)    ");
        System.out.println("      (_____)   ");
        System.out.println("      (_____)   ");
        System.out.println("      (____)    ");
        System.out.println("---.__(___)     ");

    
    }public static void paper(){
        System.out.println("    _______           ");
        System.out.println("---'   ____)____      ");
        System.out.println("          ______)     ");
        System.out.println("         _______)     ");
        System.out.println("        _______)      ");
        System.out.println("---.__________)       ");
   
    }public static void sciss(){
        System.out.println("    _______             ");
        System.out.println("---'   ____)____        ");
        System.out.println("          ______)       ");
        System.out.println("       __________)      ");
        System.out.println("     (____)             ");
        System.out.println("---.__(___)             ");
    
    }public static void   won(){//progessing
        
    }public static void  lost(){//progressing
        
    }public static void vs(){
      System.out.println(" __     ______      ");
      System.out.println(" \\ \\   / / ___|   ");
      System.out.println("  \\ \\ / /\\___ \\ ");
      System.out.println("   \\ V /  ___) |   ");
      System.out.println("    \\_/  |____/    ");
    }
   
    
}
