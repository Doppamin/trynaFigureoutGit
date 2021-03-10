package collagepractices;

public class asalSayiMatris {

    public static void main(String[] args) {
        int[][]dizi={{10,2,3},
                     {4,5,6},
                     {7,8,9}
    };
    
        System.out.println("asal sayı sayısı= " +asalSayisi(dizi));

    }
    
    public static int asalSayisi(int[][] matris){
        int say=0;
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                if(asalMi(matris[i][j])){
                    say++;
                }
                
            }
        }
        return say;
        
    }
    public static boolean asalMi(int sayi){
       boolean asalMi=true;
        for (int i = 2; i < sayi; i++) {
            if (sayi%i==0){
              asalMi=  false;
              break;
            }
        }
        return asalMi ;
        
    }
    
}
