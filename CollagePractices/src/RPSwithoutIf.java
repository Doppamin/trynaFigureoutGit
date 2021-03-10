import java.util.Scanner;
public class RPSwithoutIf {
    public static void main(String[] args) {
        int count=0;
        Scanner s = new Scanner(System.in);        
                        // R     P     S
        String rps[][]={{"tie","won","lost"},//R
                        {"lost","tie","won"},//P
                        {"won","lost","tie"}};//S    
        String shwRps[]={"Rock","Paper","Scissor"};
        System.out.println("Choose number; rock:1 paper:2 scissor:3");
        int com=(int)(Math.random()*3);
        int hmn=s.nextInt();
        while(1>hmn||hmn>3){//this is not game mechanic this just chech if human type correct numbers.This doesn't count as if while.
            System.out.println("pls just type 1 2 or 3");
            hmn =s.nextInt();
            count++;
            if(count>4){
                System.out.println("F*#^ you "); // damm im so pissing off the people who type 3 or more than wrong just 1 2 3 its not rocket science
                int[]f={0};
                f[1]=0;
            }   
        }
        System.out.println();  
        System.out.println(shwRps[hmn-1]);
        System.out.println("vs");
        System.out.println(shwRps[com]);
        System.out.println();        
        System.out.println(rps[com][hmn-1]);            
    }
}
    

