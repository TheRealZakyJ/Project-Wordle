import java.util.*;


public class WordleRunner {
    public static void main(String[] args) {
        //System.out.println("wef1");

        Wordle wrd = new Wordle();
      // System.out.println(wrd);
      //  System.out.println("dsflkn");
       //System.out.println(wrd);
        System.out.println(wrd.getWord());

        Scanner scan = new Scanner(System.in);

        for(int i= 0; i<5;i++){
            String wordGuess = scan.nextLine();

            System.out.println(wrd.checkWord(wordGuess));

        }

        //String wordInput = scan.nextLine();
        //System.out.println(wordInput);
       // System.out.println("wef2");
    }
}
