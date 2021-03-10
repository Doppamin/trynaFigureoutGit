public class PlayingCard {
    public static void main(String[] args) {
        turnCard2("");
        turnCard ("");
        turnCard4("");
        turnCard3("");
        turnCard5("");
        String[] type = {"♥", "♦", "♣", "♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                if (j < 10) 
                    showCard(type[i], j);
                else 
                    showKing(type[i], j);                
            }
            System.out.println("-------------");
        }
    }

    public static void showCard(String card, int a) {
        System.out.println("┌────────┐ ");
        System.out.println("│ " + a + "      │");
        System.out.println("│        │");
        System.out.println("│   " + card + "    │");
        System.out.println("│        │");
        System.out.println("│      " + a + " │");
        System.out.println("└────────┘");
    }

    public static void showKing(String card, int a) {
        System.out.println("┌────────┐ ");
        System.out.println("│ " + a + "     │");
        System.out.println("│        │");
        System.out.println("│   " + card + "    │");
        System.out.println("│        │");
        System.out.println("│     " + a + " │");
        System.out.println("└────────┘");
    }

    public static void turnCard(String card) {

        System.out.println("┌────────┐");
        System.out.println("│▒▒▒▒▒▒▒▒│");
        System.out.println("│▒▒▒▒▒▒▒▒│");
        System.out.println("│▒▒▒▒▒▒▒▒│");
        System.out.println("│▒▒▒▒▒▒▒▒│");
        System.out.println("│▒▒▒▒▒▒▒▒│");
        System.out.println("└────────┘");
    }

    public static void turnCard2(String card) {

        System.out.println("┌────────┐");
        System.out.println("│░░░░░░░░│");
        System.out.println("│░░░░░░░░│");
        System.out.println("│░░░░░░░░│");
        System.out.println("│░░░░░░░░│");
        System.out.println("│░░░░░░░░│");
        System.out.println("└────────┘");
    }

    public static void turnCard3(String card) {

        System.out.println("┌────────┐");
        System.out.println("│▒░▒░▒░▒░│");
        System.out.println("│░▒░▒░▒░▒│");
        System.out.println("│▒░▒░▒░▒░│");
        System.out.println("│░▒░▒░▒░▒│");
        System.out.println("│▒░▒░▒░▒░│");
        System.out.println("└────────┘");
    }

    public static void turnCard4(String card) {

        System.out.println("┌────────┐");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("└────────┘");
    }

    public static void turnCard5(String card) {

        System.out.println("┌────────┐");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("│▓▓O▓▓O▓▓│");
        System.out.println("│▓▓____▓▓│");
        System.out.println("│▓(____)▓│");
        System.out.println("│▓▓▓▓▓▓▓▓│");
        System.out.println("└────────┘");
    }
}
