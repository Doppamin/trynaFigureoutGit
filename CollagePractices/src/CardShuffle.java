
public class CardShuffle {

    public static void main(String[] args) {
        String[] deck = new String[52];
        String[] types = {"♥", "♦", "♣", "♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[(j - 1) + (i * 13)] = types[i] + j;
            }
        }
        for (int i = 0; i < 500; i++) {
                    int shuf1 = (int)(Math.random()*52);
                    int shuf2 = (int)(Math.random()*52);

          String a =deck[shuf1] ;
        deck[shuf1]  =deck[shuf2];
          deck[shuf2]=a;
        }
        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
            
            
        }

    }

}
