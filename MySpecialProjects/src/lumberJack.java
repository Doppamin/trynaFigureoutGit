//20.12.2020 
//Programı yazan Hüdayi Aşık
import java.util.Scanner;

public class lumberJack {

    public static void main(String[] args) {
        //çok belli kısımları açıklamadım
        Scanner s = new Scanner(System.in);
        char head;
        System.out.println("Karakterini seç 1:☺  2:☻ ");
              int sec=s.nextInt();
              switch(sec){
                  case 1  :head='☺';break;
                  case 2  :head='☻';break;
                  case 53 :head='♥';break;
                  case 375:head='♠';break;
                  case 508:head='↑';break;
                  
                  default:head='☺';
              }
              
                                  //(i)
                  //(j) 0   1   2 
      char[][] tree={ {' ','|',' '},//0
                      {' ','|',' '},//1
                      {' ','|',' '},//2
                      {' ','|',' '},// 3           
                      {' ','|',' '},//4
                      {' ','|',' '},//5
                      {' ','|',' '},//6
                      {' ','|',' '},//7
                      {head,'|',' '}};//8
              int skor=-40;
                            
              while(findHead(tree,head)!=-1){//oyun biter eğer 
                     branch(tree);//dalı oluşturuyor 
                  skor+=10;                  
                  shwGame(tree);
                  char key=s.next().charAt(0);
                  move(tree,key,head);              
                  fallBranch(tree);// dalı düşürür    
              }
              
              System.out.println("oyun bitti");
              System.err.println("skor: "+skor);
              if(skor>=100&&skor<200){
                  System.err.println("yeni karakter açıldı ♥. Karakter kodu 53 ");
              }else if(skor>=200&&skor<300){
                  System.err.println("yeni karakter açıldı ♠. Karakter kodu 375 ");
              }else if(skor>=400){
                  System.err.println("yeni karakter açıldı ↑. Karakter kodu 508 ");
              }
              
    }
    
    public static void shwGame(char[][]tree){// oyunu yazdırıyor
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                System.out.print(tree[i][j]);
                
            }
            System.out.println();
        }
    }
    public static char[][]move(char[][]tree,char key,char yuz){//sağ sol kafa hareket eder
        int head=findHead(tree,yuz);//head kafanın konumu
        tree[8][head]=' ';
            switch(key){
            case 'A':tree[8][0]=yuz;break;
            case 'D':tree[8][2]=yuz;break;
            default :tree[8][head]=yuz;System.out.println("Yanlış Tuş");
        }
        
        return tree;
    }
    
    public static int findHead (char[][]tree,char yuz){
        if(tree[8][0]==yuz){//kafa solda ise 0
            return 0;
        }else if(tree[8][2]==yuz){//şağda ise 2 döndürür
            return 2;
        }else{
            return -1;//eğer dal kafaya düşüp ezerse kafa yok olacağından -1 döndürür oyun biter.
        }
    }
    
    public static char[][] branch(char[][]tree){// ağacın dalını oluştur hareket ettir
     int r=(int)(Math.random()*2);//r random sayı dalın çıkacağı yeri bulmak için
     int a=0; int b=2;  //dalın oluşacağı 2 yer
     int firstBrc;      //ilk dal
     if(r==0){
         firstBrc=a;    //dal en sağda
     }else{
        firstBrc=b;     //dal en sonda
     }  
     tree[0][firstBrc]='_';
     return tree;
    }
    public static char[][] fallBranch(char[][]tree){//dallaraşağı düşecek
        for (int i = 8; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                if(tree[i][j]=='_'){
                if(i==8){//sona gelince silinecek
                    tree[i][j]=' ';
                }else{
                     tree[i][j]=' ' ;
                     tree[i+2][j]='_';
                }
                
                } else{

                }
            }
        }
        return tree;
    }
 
}
 //   |
        //   |_
        //   |
        //   |_
        //   |
        //   |
        //  ☻| 