package collagepractices;


import static java.util.Arrays.sort;

public class diziCalismalari {

    public static void main(String[] args) {

        int[] dizi = {7, 6, 10, 9, 21, 3, 2, 5};
        //diziSirala(dizi);
        //sort(dizi);
       // diziTersSirala(dizi);
       selectionSiralama(dizi);
        a(dizi);
    }

    
    
    public static int[] dizileriTopla(int[] d1, int[] d2) {
        int[] toplamDizi = new int[d1.length];
        for (int i = 0; i < d1.length; i++) {
            toplamDizi[i] = d1[i] + d2[i];
        }
        return toplamDizi;
    }

    public static int[] diziSirala(int[] dizi) {
        int temp = 0;
        int yer  = 0;
        for (int i = 0; i < dizi.length - 1; i++) {
            int max = 0;
            for (int j = i; j < dizi.length; j++) {
                if (max < dizi[j]) {
                    max = dizi[j];
                    yer = j;
                }
            }
            temp = dizi[i];
            dizi[i] = max;
            dizi[yer] = temp;
        }
        return dizi;
    }

    public static int[] diziTersSirala(int[] dizi) {
        for (int i = 0; i < dizi.length - 1; i++) {
            int temp = 0;
            int yer = 0;
            int min = 200;
            for (int j = i; j < dizi.length; j++) {
                if (min > dizi[j]) {
                    min = dizi[j];
                    yer = j;
                }
            }
            temp = dizi[i];
            dizi[i] = min;
            dizi[yer] = temp;
        }
        return dizi;
    }

    public static void a(int[] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            System.out.println(dizi[i]);
        }
    }
     public static int [] selectionSiralama (int [] dizi){//hocaının küçükten büyüğe
        int temp;
        for(int i=0;i<dizi.length-1;i++){
            for(int j=i+1;j<dizi.length;j++){
                if(dizi[i]>dizi[j]){
                    temp=dizi[i];
                    dizi[i]=dizi[j];
                    dizi[j]=temp;
                }
            }
        }
        return dizi;
    }
}
