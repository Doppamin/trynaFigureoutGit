
import java.util.*;

 class Visiual{
     
            int[][]blockJ ={{0,1,1,0},
                            {0,1,0,0},
                            {0,1,0,0},
                            {0,0,0,0}};
    
            int[][]blockL ={{1,1,0,0},
                            {0,1,0,0},
                            {0,1,0,0},
                            {0,0,0,0}};
    
            int[][]blockI ={{0,1,0,0},
                            {0,1,0,0},
                            {0,1,0,0},
                            {0,1,0,0}};
    
            int[][]blockO ={{0,0,0,0},
                            {0,1,1,0},
                            {0,1,1,0},
                            {0,0,0,0}};
            char[][]blocke={{' ',' ',' ',' '},
                            {' ','█','█',' '},
                            {' ','█','█',' '},
                            {' ',' ',' ',' '}
                                            };
            
            int[][]blockT ={{0,0,0,0},
                            {0,1,0,0},
                            {1,1,1,0},
                            {0,0,0,0}};
    
            int[][]blockS ={{0,0,0,0},
                            {0,0,1,1},
                            {0,1,1,0},
                            {0,0,0,0}};
    
            int[][]blockZ ={{0,0,0,0},
                            {1,1,0,0},
                            {0,1,1,0},
                            {0,0,0,0}};
            
              int[][]blockTemplate ={{0,1,1,0},
                            {0,1,0,0},
                            {0,1,0,0},
                            {0,0,0,0}};
    
            int[][]board = {{0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0}};
            
    
}
class location{
    int[]location={0,6};
    
    
    void clearLocation(){
        int[]location={0,6};
        this.location=location;
    }
}

public class FinalTetris {
    Visiual v = new Visiual();
    location loc = new location();
    
    private int[][]matrisBlock=v.blockTemplate;
    int[][]matrisBoard=v.board;
    int skore=0;

    public void setMatris(int[][] matrisBlock) {
        this.matrisBlock = matrisBlock;
    }

   
 /***************************MAIN***************************************/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Visiual v = new Visiual();
        FinalTetris ft = new FinalTetris();
        char choose;
        ft.spawn();
        ft.slideBLock();
        ft.attach();
        ft.showBoard();
        for(;;){
            choose=s.next().charAt(0);
            ft.control(choose);
            ft.showBoard();
            ft.chkLineClear();
            if(ft.chkMovingBlock()){
                ft.spawn();
                ft.slideBLock();
                ft.attach();
                ft.showBoard();
            }
            if(ft.matrisBoard[2][6]==2)break;
        }
        System.out.println("Game over  skore: "+ft.skore);
        
    }
    
   /**********************************************************************/
    
    public void showBoard(){ 
        for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[i].length; j++) {
               if(matrisBoard[i][j]==1)System.out.print("\u001b[36m"+matrisBoard[i][j]+"\033[0m");
               else if(matrisBoard[i][j]==2)System.out.print("\u001b[34m"+matrisBoard[i][j]+"\033[0m");
               else System.out.print("\u001b[37m"+matrisBoard[i][j]+"\033[0m");
                
            }
            System.out.println("");
        }
    }
     public void showBlock(){ 
        for (int i = 0; i < matrisBlock.length; i++) {
            for (int j = 0; j < matrisBlock[i].length; j++) {
               
                System.out.print(matrisBlock[i][j]);
            }
            System.out.println("");
        }
    }
  

    public void rotate90right(){

        int[][]m=new int[4][4];
        int k =0;
        int l;
        for (int i = 0; i < matrisBlock.length; i++) {
            l=0;
            for (int j = matrisBlock[i].length-1; j >=0 ; j--) {
                m[k][l]=matrisBlock[j][i];
                l++;
            }
            k++;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                matrisBlock[i][j]=m[i][j];
                
            }
        }
        slideBLock();
    }
 
    public void rotate180(){
        rotate90right();
        rotate90right();
    }
    public void rotate90left(){
        rotate180();
        rotate90right();
        
    }
 
    public void changeColor(){
        for (int[] matrisBoard1 : matrisBoard) {
            for (int j = 0; j < matrisBoard1.length; j++) {
                if (matrisBoard1[j] == 0) {
                    matrisBoard1[j] = 1;
                } else {
                    matrisBoard1[j] = 0;
                }
            }
        }
    }
     public void stopBlock(){
        for (int[] matrisBoard1 : matrisBoard) {
            for (int j = 0; j < matrisBoard1.length; j++) {
                if (matrisBoard1[j] == 1) {
                    matrisBoard1[j] = 2;
                }
            }
        }
        loc.clearLocation();
    }
    
    public void attach(){ //this attacking matris to block
        int x =loc.location[1]; //j 0;//
        int y =loc.location[0]; //i
        System.out.println(x+" "+y);
        for (int i = y; i < y+4; i++) {
            for (int j = x; j < x+4; j++) {
                if(matrisBoard[i][j]!=2)
           matrisBoard[i][j]=matrisBlock[i-y][j-x]; 
                
            }
        }
        
    }
        public void attach(int non){ //this attacking matris to block
        
        int x =loc.location[1]; //j 0;//
        int y =loc.location[0]; //i
        System.out.println(x+" "+y);
        cleanBoard();
        for (int i = y; i < y+4; i++) {
            for (int j = x; j < x+4; j++) {
                if(matrisBoard[i][j]!=2)
                matrisBoard[i][j]=matrisBlock[i-y][j-x];
            }
        }
        
    }
    public void attach(int[][]block){ //this attching to block to  matris 

        for (int i = 0; i < matrisBlock.length; i++) {
            for (int j = 0; j < matrisBlock[i].length; j++) {
                matrisBlock[i][j]=block[i][j];
            }
        }
        
    }
    //find first cordinate of Block;
  /*  public int[] findBlcok(){
        int go=0;
        int[] loc={0,0}; //location
        for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1){
                 loc[0]=i;
                 loc[1]=j;
                 go=5;
                 break;
                }
            }
            if(go==5)break;
        }
        return loc;
    }*/
//_______________________--MOVE--_______________________________________________
    public void fall(){
        chckFallStop();
          for (int i =  matrisBoard.length-1; i >=0; i--) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1 ){ 
                    matrisBoard[i][j]=0;
                    matrisBoard[i+1][j]=1;            
                }
            }
        }
          loc.location[0]++;
          }
    boolean chkLoopFall(){
        boolean b=false;
            for (int i =  matrisBoard.length-1; i >=0; i--) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1)
                    b=true;
            }
        }
     return b;
       
    }
       public void goRight(){
           if(goRightStop()){
               for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = matrisBoard[0].length-1; j >=0; j--) {
                if(matrisBoard[i][j]==1){
                    matrisBoard[i][j]=0;
                    matrisBoard[i][j+1]=1;
                }
            }
        }
        loc.location[1]++;
           }
    }
    boolean goRightStop(){
        boolean b = true ;
        for (int i = 0; i < matrisBoard.length; i++) {
            if(matrisBoard[i][9]==1)
            b=false;
        
        }
        for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length-1; j++) {
                if(matrisBoard[i][j]==1&&matrisBoard[i][j+1]==2)
                    b=false;
            }
        }
        return b;
    }
    public void goLeft(){
        if(goLeftStop()){
             for (int i = 0; i <matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1){
                    matrisBoard[i][j]=0;
                    matrisBoard[i][j-1]=1;
                }
            }
        }
         loc.location[1]--;
            
        }
        
        
    }
        boolean goLeftStop(){
        boolean b = true ;
        for (int i = 0; i < matrisBoard.length; i++) {
            if(matrisBoard[i][0]==1){
            b=false;
        }
        }
                for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 1; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1&&matrisBoard[i][j-1]==2)
                    b=false;
            }
        }
        return b;
    }
    public void control(char key){
        switch (key){
            case 'A':goLeft(); break;
            case 'D':goRight();break;
            case 'S':if(chckRow())fall();break;
            case 'L':rotate90right();slideBLock();attach(0);break;
            case 'K':rotate90left();slideBLock();attach(0);break;
            case 'F':while(chckRow()&&chkLoopFall())fall();break;
        }
    }
    
    
    
    //this check last row if piece end of the edge
          public boolean chckRow(){
              boolean b = true;
              int a=15;
              for (int i = 0; i <matrisBoard[0].length; i++) {
                  if(matrisBoard[a][i]==1){
                      b= false;
                      stopBlock();
                  }
              }
              return b;
          }
 //_______________________--MOVE--_______________________________________________
          public void spawn(){
              int blockType=(int)(Math.random()*6);
              switch(blockType){
                  case 0:attach(v.blockI);break;
                  case 1:attach(v.blockJ);break;
                  case 2:attach(v.blockL);break;
                  case 3:attach(v.blockO);break;
                  case 4:attach(v.blockS);break;
                  case 5:attach(v.blockT);break;
                  case 6:attach(v.blockZ);break;
              }
              
          }
          
//________________ReLocate_Block_in_its_own_square______________________________
    
    public void slideBLock(){
        while(chkRow()){
        for (int i = 0; i < matrisBlock.length; i++) {
            for (int j = 0; j < matrisBlock[0].length; j++) {
                if(matrisBlock[i][j]==1){
                    matrisBlock[i][j-1]=1;
                    matrisBlock[i][j]=0;
                }
            }
        }
        }
                  while(chkColl()){
        for (int i = 0; i < matrisBlock.length; i++) {
            for (int j = 0; j < matrisBlock[0].length; j++) {
                if(matrisBlock[i][j]==1){
                    matrisBlock[i-1][j]=1;
                    matrisBlock[i][j]=0;
                }
                
            }
        }
          }
    }
      
    public boolean chkRow(){
        System.out.println("chckRow");
        boolean a=true;
        for (int i = 0; i < 4; i++) {
            if(matrisBlock[i][0]==1){
                a=false;
            }
        }
        
        return a;
    }
    public boolean chkColl(){ 
         boolean a=true;
             for (int i = 0; i < 4; i++) {
            if(matrisBlock[0][i]==1){
                a=false;
            }
        }
        
        return a;
    }
    void cleanBoard(){

        for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1) matrisBoard[i][j]=0;
            }
        }
    }
   boolean chkMovingBlock(){
       boolean chk=true;
          for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==1){
                   chk=false;
                }
                
            }
        }
          return chk;
   }
   //________________<<ReLocate_Block_in_its_own_square>>________________________
   //__________________
   
   void chckFallStop(){
       for (int i = 0; i < matrisBoard[0].length; i++) {
           for (int j = 0; j < matrisBoard.length-1; j++){ 
               if(matrisBoard[j][i]==1&&matrisBoard[j+1][i]==2){
                   stopBlock();
               }
       }
   }
   }
 
   //______________line clear____________________________________________________
   void chkLineClear(){
          int count2=0;
          for (int i = 0; i < matrisBoard.length; i++) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                if(matrisBoard[i][j]==2)count2++;
            }
            if(count2==10)lineClear(i);
            count2=0;
        }
   }
   void lineClear(int row){
       for (int i = row; i>0; i--) {
            for (int j = 0; j < matrisBoard[0].length; j++) {
                matrisBoard[i][j]=matrisBoard[i-1][j];
            }
       
   }
       skore+=100;
   }
 
}