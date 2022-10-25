import java.awt.desktop.SystemEventListener;
import java.util.*;


public class WordleRunner {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String[] args) {
        //System.out.println("wef1");

        Wordle wrd = new Wordle();
        System.out.println(wrd);
        System.out.println(wrd.getWord());

        //  System.out.println("dsflkn");
        //System.out.println(wrd);


        System.out.println(wrd.getWordArray());

        Scanner scan = new Scanner(System.in);

        String colorCheck = "";

        for (int i = 0; i < 6; i++) {
            String wordGuess = scan.nextLine().toLowerCase();

            if (!wrd.checkArray(wordGuess)) {
                i--;
                System.out.println("Please type a real 5 letter word.");
            } else {
                colorCheck = wrd.colorCheck(wordGuess);

                System.out.println(wrd.addColor(wordGuess, colorCheck));

                int attempts = 6 - i - 1;
                if (wrd.checkWord(wordGuess)) {
                    System.out.println("CONGRATS!!!");
                    i = 6;
                } else if (!wrd.checkWord(wordGuess) && i == 4) {
                    System.out.println("Last attempt.");
                } else if (i == 5) {
                    System.out.println("Try again for the next Wordle.");
                } else {
                    System.out.println("Attempts left: " + attempts);
                }

            }
        }


    }
}
