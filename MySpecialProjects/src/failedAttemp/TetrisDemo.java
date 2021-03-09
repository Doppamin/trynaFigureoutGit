package failedAttemp;


class Texture{
    char[][] blockL ={{' ',' ',' ',' '},
                     {'#',' ',' ',' '},
                     {'#',' ',' ',' '},
                     {'#','#',' ',' '}};
                 
    char[][] blockLR ={{'▓','▓','▓','▓','▓','▓','▓','▓'},
                     {'a','b','c','d','e','f','g','h'},
                     {'i','j','k','l','m','n','o','p'},
                     {'q','r','s','t','y','v','w','x'},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '} };
    char[][] block={{'1','2','3'},
                    {'4','5','6'},
                    {'7','8','9'}};
    
}




public class TetrisDemo {
char[][] blockMatris;
char[][] boardMatris;
    public static void main(String[] args) {
        TetrisDemo td = new TetrisDemo();
        Texture t = new Texture();
        td.blockMatris=t.blockL;
        td.showMatris();
     
        td.rotate90left();
        td.showMatris();
      //  td.rotate90left();
       // td.showMatris();

    }
    void showMatris (){
        for (int i = 0; i < blockMatris.length; i++) {
            for (int j = 0; j < blockMatris[0].length; j++) {
                System.out.print(blockMatris[i][j]);
            }
            System.out.println("");
        }
        
    }
    void rotate90left(){
        char[][]tempMatris={{' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '} };
        int c=0;
        for (int i = blockMatris.length-1; i >=0; i--) {
            for (int j = 0; j < blockMatris[0].length; j++) {
                tempMatris[c][j]=blockMatris[j][i];  
            }
            c++;
        }
           for (int i = 0; i <blockMatris.length; i++) {
            for (int j = 0; j < blockMatris[0].length; j++) {
                blockMatris[i][j]=tempMatris[i][j];
            }
        }
    }
    
    
}
/*
    char[][] blcokL ={{'1','2','3','4','5','6','7','8'},
                     {'▓','▓',' ',' ',' ',' ',' ',' '},
                     {'▓','▓',' ',' ',' ',' ',' ',' '},
                     {'▓','▓',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' ',' '} };      
    
}
*/