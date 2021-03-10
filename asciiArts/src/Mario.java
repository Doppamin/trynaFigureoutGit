
public class Mario {
   static char[][]marioTemp={  { '░','░','░','░','░','░','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','░','░','░','░','░','░','░','░'},
                               { '░','░','░','░','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','░','░'},
                               { '░','░','░','░','█','█','█','█','█','█','▒','▒','▒','▒','█','█','▒','▒','░','░','░','░','░','░'},
                               { '░','░','█','█','▒','▒','█','█','▒','▒','▒','▒','▒','▒','█','█','▒','▒','▒','▒','▒','▒','░','░'},
                               { '░','░','█','█','▒','▒','█','█','█','█','▒','▒','▒','▒','▒','▒','█','█','▒','▒','▒','▒','▒','▒'},
                               { '░','░','█','█','█','█','▒','▒','▒','▒','▒','▒','▒','▒','█','█','█','█','█','█','█','█','░','░'},
                               { '░','░','░','░','░','░','▒','▒','▒','▒','▒','▒','▒','▒','▒','▒','▒','▒','▒','▒','░','░','░','░'},
                               { '░','░','░','░','█','█','█','█','▓','▓','█','█','█','█','█','█','░','░','░','░','░','░','░','░'},
                               { '░','░','█','█','█','█','█','█','▓','▓','█','█','█','█','▓','▓','█','█','█','█','█','█','░','░'},
                               { '█','█','█','█','█','█','█','█','▓','▓','▓','▓','▓','▓','▓','▓','█','█','█','█','█','█','█','█'},
                               { '▒','▒','▒','▒','█','█','▓','▓','▒','▒','▓','▓','▓','▓','▒','▒','▓','▓','█','█','▒','▒','▒','▒'},
                               { '▒','▒','▒','▒','▒','▒','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▒','▒','▒','▒','▒','▒'},
                               { '▒','▒','▒','▒','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▓','▒','▒','▒','▒'},
                               { '░','░','░','░','▓','▓','▓','▓','▓','▓','░','░','░','░','▓','▓','▓','▓','▓','▓','░','░','░','░'},
                               { '░','░','█','█','█','█','█','█','░','░','░','░','░','░','░','░','█','█','█','█','█','█','░','░'},
                               { '█','█','█','█','█','█','█','█','░','░','░','░','░','░','░','░','█','█','█','█','█','█','█','█'} };
   
   static String codedMario="000000222222222200000000\n" +
                            "000022222222222222222200\n" +
                            "000033333311113311000000\n" +
                            "003311331111113311111100\n" +
                            "003311333311111133111111\n" +
                            "003333111111113333333300\n" +
                            "000000111111111111110000\n" +
                            "000033332233333300000000\n" +
                            "003333332233332233333300\n" +
                            "333333332222222233333333\n" +
                            "111133221122221122331111\n" +
                            "111111222222222222111111\n" +
                            "111122222222222222221111\n" +
                            "000022222200002222220000\n" +
                            "003333330000000033333300\n" +
                            "333333330000000033333333" ;
   
   static char[][] marioBlank=new char[marioTemp.length][marioTemp[0].length]; //this creates same array with marioTemp
                      // '░',  '▒',  '▓',               
    public static void main(String[] args) {
        
        printMatrix();  //this printMarioTemp
        System.out.println("");
        printMario();  
        System.out.println("");
        printLuigi();
        System.out.print(codedMario);
    }
    static void fillMarioBlank(){
        for (int i = 0; i < marioTemp.length; i++) {
            for (int j = 0; j < marioTemp[i].length; j++) {
                marioBlank[i][j]=marioTemp[i][j];
            }
        }        
    }
    
    static void printMatrix(){
        for (int i = 0; i < marioTemp.length; i++) {
            for (int j = 0; j < marioTemp[i].length; j++) {
                System.out.print(marioTemp[i][j]);
            }
            System.out.println("");
        }
    }
    static void printMario(){
        fillMarioBlank(); //make clone of marioTemp to marioblank
         for (int i = 0; i < marioTemp.length; i++) {
            for (int j = 0; j < marioTemp[i].length; j++) {
                switch(marioBlank[i][j]){
                    //first this change charS to this █ to visiulize easily then prints colorful base on chars
                    case'░':marioBlank[i][j]=' ';System.out.print(marioBlank[i][j]);break; //white  "\033[0;37m"+
                    case'▒':marioBlank[i][j]='█';System.out.print("\033[0;33m"+marioBlank[i][j]);break; //yellow
                    case'▓':marioBlank[i][j]='█';System.out.print("\033[0;31m"+marioBlank[i][j]);break; //red
                    default:marioBlank[i][j]='█';System.out.print("\033[0m"+marioBlank[i][j]);       //default                    
                }
            }
            System.out.println("");
        }
        
    }
    static void printStringMario(){
        
    }
    
   static void printLuigi(){ 
       fillMarioBlank();
         for (int i = 0; i < marioTemp.length; i++) {
            for (int j = 0; j < marioTemp[i].length; j++) {
                switch(marioBlank[i][j]){
                    case'░':marioBlank[i][j]='█';System.out.print("\033[0;37m"+marioBlank[i][j]);break; //white
                    case'▒':marioBlank[i][j]='█';System.out.print("\033[0;33m"+marioBlank[i][j]);break; //yellow
                    case'▓':marioBlank[i][j]='█';System.out.print("\033[0;32m"+marioBlank[i][j]);break; //green
                    default:marioBlank[i][j]='█';System.out.print("\033[0m"+marioBlank[i][j]);       //default                    
                }
            }
            System.out.println("");
        }
       
   }
    
}
