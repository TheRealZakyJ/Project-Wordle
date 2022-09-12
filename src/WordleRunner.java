import java.util.*;


public class WordleRunner {
    public static void main(String[] args) {
        //System.out.println("wef1");

        Wordle wrd = new Wordle();
       System.out.println(wrd);
        //System.out.println(wrd.getWord());

      //  System.out.println("dsflkn");
       //System.out.println(wrd);


        System.out.println(wrd.getWordArray());

        Scanner scan = new Scanner(System.in);

        for(int i= 0; i<5;i++){
            String wordGuess = scan.nextLine().toLowerCase();
            System.out.println(wordGuess);
            if(wordGuess.length()!=5 || !wrd.checkArray(wordGuess)){
                i=i-1;
                System.out.println("Please type a real 5 letter word.");
            } else {
              //  System.out.println(wrd.checkArray(wordGuess));
                System.out.println(wrd.checkWord(wordGuess));
              //  System.out.println("32");
              //  System.out.println(wrd.colorCheck(wordGuess));
            }
        }

        //String wordInput = scan.nextLine();
        //System.out.println(wordInput);
       // System.out.println("wef2");
    }
}
