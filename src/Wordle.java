import java.io.*;
import java.util.*;


public class Wordle {
private final String chosenWord;
private final ArrayList<String> allWordList;
private final ArrayList<String> chosenWordArray;

    public Wordle(){

        allWordList = new ArrayList<>();
        chosenWordArray = new ArrayList<>();

        try {
            File myObj = new File("Five Letter Words.txt");
            System.out.println(myObj.length());
            Scanner myReader = new Scanner(myObj);
           // int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
              //  count++;
                allWordList.add(data);
                //   System.out.println(data);
            }
           // System.out.println(count);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        chosenWord = this.wordGen();
        System.out.println(allWordList.size());
        for(int i = 0;i<5;i++){

            chosenWordArray.add(chosenWord.substring(i,i+1));
        }
       // wordArray.add(word.substring(4,5));
        //System.out.println(myObj.length());
    }

    public ArrayList<String> getWordArray(){

        return chosenWordArray;
    }

    public boolean checkArray(String gWord){

        for (String s : allWordList) {
            if (s.equals(gWord)) {
                return true;
            }
        }
        return false;
    }


    public String wordGen(){
        //for(int i =0; i<=wordList.size();)
        return allWordList.get((int)(Math.random()*allWordList.size()));
    }

    public String getWord(){

        return chosenWord;
    }

    public boolean checkWord(String wordGuess){
      /*  if(wordGuess.length()!=5){
            return false;
        }

       */
        return wordGuess.equals(chosenWord);
        /*
        if(wordGuess.toLowerCase(Locale.ROOT).substring(0,1).equals(word.substring(0,1))){

            if(wordGuess.toLowerCase(Locale.ROOT).substring(1,2).equals(word.substring(1,2))){

                if(wordGuess.toLowerCase(Locale.ROOT).substring(2,3).equals(word.substring(2,3))){

                    if(wordGuess.toLowerCase(Locale.ROOT).substring(3,4).equals(word.substring(3,4))){

                        return wordGuess.toLowerCase(Locale.ROOT).substring(4,5).equals(word.substring(4,5));

                    }
                }
            }
        }

         */
    }

    public String colorCheck(String gWord){
        //compare each letter:
        //green if letter is in the right spot
        // yellow if existing letter is in the wrong spot
        //grey if letter does not exist in the word
        if(gWord.length()!=5){
            return "false";
        }
        ArrayList<String> gWordArray = new ArrayList<>();
        for (int x =0;x<5;x++){
            gWordArray.add(gWord.substring(x,x+1));
        }
        String greenReport = "";
        String greyReport = "";
        String yellowReport = "";
      /*  for (int i = 0; i<chosenWordArray.size();i++){
            for (int j = 0; i<gWordArray.size();j++){

             //   if(){}
            }
        }

       */
        return "";
    }

    public String toString(){
        return "";
    }
/*
    public static void main(String[] args) {
       //File words = new File("Five Letter Words.txt");
      // System.out.println(words.length());
        Scanner myReader = new Scanner(words);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }

ArrayList<String> wordList = new ArrayList<>();

        try {
            File myObj = new File("Five Letter Words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordList.add(data);
             //   System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

            FileReader frdr = new FileReader("Five Letter Words.txt");
            int z;
            while ((z = frdr.read()) != -1) {
           //     wordList.add(z);
              //  System.out.print((char) z);

        }
     */
    }
