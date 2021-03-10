
import java.util.*;
/*
Actually hard ai haven't finished yet.Only part that left i had to add last part of if else comAi()method which it does put x or o in every block to chck win or lose.
if no win or lose put random. But because of my tangled code i couldnt make it more.Aslında yapacağımı anladığımda anda kodlamayı bırakıyorum. BUnları yapmamın sebebi
Acaba yapabilir miyim sorusunu cevaplamak ve cevabımı aldım.Tek yapmam gereken dongü içinde boş olan indise x koyup chkwin()yapıp tekrar boşaltmak indisi.Aslında birnevi bu
kısmı team mate'e bırakıyorum bulursam
*/
public class XOXDemo {
    static char[] places={'1','2','3','4','5','6','7','8','9'};
    
                           //0   1   2   3   4   5   6   7   8   9   10  11  12
    static char[][]board={ {'┌','─','─','─','┬','─','─','─','┬','─','─','─','┐'}, //0
                           {'│',' ',' ',' ','│',' ',' ',' ','│',' ',' ',' ','│'}, //1
                           {'├','─','─','─','┼','─','─','─','┼','─','─','─','┤'}, //2
                           {'│',' ',' ',' ','│',' ',' ',' ','│',' ',' ',' ','│'}, //3
                           {'├','─','─','─','┼','─','─','─','┼','─','─','─','┤'}, //4
                           {'│',' ',' ',' ','│',' ',' ',' ','│',' ',' ',' ','│'}, //5
                           {'└','─','─','─','┴','─','─','─','┴','─','─','─','┘'}};//6 
    static char[] xo={'X','O'}; //0 X 1 O
    static char comp;
    static char human;
    
    static void temp(){
      board[1][2] =places[0];//1
      board[1][6] =places[1];//2
      board[1][10]=places[2];//3
      board[3][2] =places[3];//4
      board[3][6] =places[4];//5
      board[3][10]=places[5];//6
      board[5][2] =places[6];//7
      board[5][6] =places[7];//8
      board[5][10]=places[8];//9
        
    }
//++++++++++++++++++++++MAIN++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) {
        Ai ai = new Ai();
        ai.aiPlay();
        temp();
        shwbrd();
        if (headRTail())attachHuman();
        for(;;){
            attachcomp();
            temp();
            shwbrd();
            if(isWin()){
                System.out.println("computer win");
                break;
            }
             if(chkfull())break;

            attachHuman();
            temp();
            shwbrd();
            
            if(isWin()){
                System.out.println("You win");
                break;
            }
            
            if(chkfull())break;
        }
        if(!isWin())System.out.println("tie");

    }
 //++++++++++++++++++++++MAIN++++++++++++++++++++++++++++++++++++
    // who will start first computer or human x or o 
    static boolean headRTail(){
        boolean b=true;
        Scanner s = new Scanner(System.in);
        System.out.println("X or O");
        char choose=s.next().charAt(0);
        while (choose!='X'&&choose!='O') { 
            System.out.println("X or O");
            choose=s.next().charAt(0);
        }
        switch(choose){
            case 'X':human=xo[0];comp=xo[1]; break;
            case 'O':human=xo[1];comp=xo[0];b=false; break;
        }
        return b;
    }
    
    static boolean chkfull(){
        boolean b =true;
        for (int i = 0; i <places.length ; i++) {
            if (places[i]!='O'&&places[i]!='X'){
                b=false;
                break;
            } 
        }
        return b;
    }
    
    static void shwbrd(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if (board[i][j]=='X') System.out.print("\033[0;31m"+board[i][j]);
                else if (board[i][j]=='O')System.out.print("\033[0;34m"+board[i][j]);
                else System.out.print("\033[0m"+board[i][j]);
            }
            System.out.println("");
        }
    }
    
    static boolean isEmpty(int num){
        if(places[num-1]=='X'||places[num-1]=='O')return false;
        
        else return true;
    }
   static void attachHuman (){
       Scanner s = new Scanner(System.in);
       System.out.println("choose number");
       int num=s.nextInt();
       while(!isEmpty(num)){
          System.out.println("choose correct number");
          num=s.nextInt();
       }
       places[num-1]=human;
   }
   static void attachcomp (){
       int num=(int)(Math.random()*9);
       while(!isEmpty(num+1)){
           num=(int)(Math.random()*9);
       } //chek this row again
       
      places[num]=comp;
   }
    static boolean isWin() {
        boolean a = false;
              if (places[0]==(places[1]) && places[1]==(places[2])) a = true;
         else if (places[3]==(places[4]) && places[4]==(places[5])) a = true;
         else if (places[6]==(places[7]) && places[7]==(places[8])) a = true;
         else if (places[0]==(places[3]) && places[3]==(places[6])) a = true;
         else if (places[1]==(places[4]) && places[4]==(places[7])) a = true;
         else if (places[2]==(places[5]) && places[5]==(places[8])) a = true;
         else if (places[0]==(places[4]) && places[4]==(places[8])) a = true;
         else if (places[2]==(places[4]) && places[4]==(places[6])) a = true;
        return a;
    }    
}

class Ai{
  
    
    void aiPlay(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0:Easy 1:Hard");
        int choose = sc.nextInt();
        if(choose==1){
            XOXDemo.temp();
            XOXDemo.shwbrd();
            if(XOXDemo.headRTail()){
                XOXDemo.attachHuman();
                if(XOXDemo.places[4]=='X'){
                     XOXDemo.places[0]='O';
                      XOXDemo.temp();
                      XOXDemo.shwbrd();
                      XOXDemo.attachHuman();
                      XOXDemo.temp();
                      XOXDemo.shwbrd();
                      tieloop();
                      
                }else{
                    tieloop();
                }                   
            }
            else{
                 XOXDemo.places[4]='X';
                 XOXDemo.temp();
                 XOXDemo.shwbrd();
                 XOXDemo.attachHuman();
                 XOXDemo.temp();
                 XOXDemo.shwbrd();
                if(XOXDemo.places[1]=='O'||XOXDemo.places[5]=='O'){
                    XOXDemo.places[2]='X';
                    XOXDemo.temp();
                    XOXDemo.shwbrd();
                    XOXDemo.attachHuman();
                    XOXDemo.temp();
                    XOXDemo.shwbrd();
                    if (XOXDemo.places[6]=='O') {
                       if(XOXDemo.places[1]!='O') XOXDemo.places[1]='X';//++++chek here so important
                       else XOXDemo.places[5]='X';
                    XOXDemo.temp();
                    XOXDemo.shwbrd();
                    XOXDemo.attachHuman();
                    XOXDemo.temp();
                    XOXDemo.shwbrd();
                        
                    }
                    
                }
            }
          
            
            
        }
      
        
    }
      void tieloop(){
          for(;;){
                        com(board);
                        XOXDemo.temp();
                        XOXDemo.shwbrd();
                       
                        if(XOXDemo.isWin()){
                         System.out.println("computer win");
                         break;
                        }
                        if(XOXDemo.chkfull())break;
                        XOXDemo.attachHuman();
                        XOXDemo.temp();
                        XOXDemo.shwbrd();
                        if(XOXDemo.isWin()){
                         System.out.println("you win");
                         break;
                        }
                        if(XOXDemo.chkfull())break;
                    }
                     if(!XOXDemo.isWin())System.out.println("tie");
                    
                }
      void com(){
          
      }
        
    
    /*
   
      temp();
        shwbrd();
        if (headRTail())attachHuman();
        for(;;){
            attachcomp();
            temp();
            shwbrd();
            if(isWin()){
                System.out.println("computer win");
                break;
            }
             if(chkfull())break;

            attachHuman();
            temp();
            shwbrd();
            
            if(isWin()){
                System.out.println("You win");
                break;
            }
            
            if(chkfull())break;
        }
        if(!isWin())System.out.println("tie");
     */
    
     

}
