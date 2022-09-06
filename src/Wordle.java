import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.*;




public class Wordle {
private String word;
private ArrayList<String> wordList;


    public Wordle(){

        wordList = new ArrayList<>();

        try {
            File myObj = new File("Five Letter Words.txt");
            System.out.println(myObj.length());
            Scanner myReader = new Scanner(myObj);
           // int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
              //  count++;
                wordList.add(data);
                //   System.out.println(data);
            }
           // System.out.println(count);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        word = this.wordGen();
        System.out.println(wordList.size());
        //System.out.println(myObj.length());
    }


    public String wordGen(){
        //for(int i =0; i<=wordList.size();)
        return wordList.get((int)(Math.random()*wordList.size()));
    }

    public String getWord(){

        return word;
    }

    public boolean checkWord(String wordGuess){
        if(wordGuess.length()!=5){
            return false;
        }
        if(wordGuess.equals(word)){

            return true;
        }
        if(wordGuess.substring(0,1).equals(word.substring(0,1))){

            if(wordGuess.substring(1,2).equals(word.substring(1,2))){

                if(wordGuess.substring(2,3).equals(word.substring(2,3))){

                    if(wordGuess.substring(3,4).equals(word.substring(3,4))){

                        if(wordGuess.substring(4,5).equals(word.substring(4,5))){

                            return wordGuess.substring(5).equals(word.substring(5));
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString(){
        return "Try to guess the word!";
    }

    public static void main(String[] args) {
       //File words = new File("Five Letter Words.txt");
      // System.out.println(words.length());
      /*  Scanner myReader = new Scanner(words);
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
     */      //     wordList.add(z);
              //  System.out.print((char) z);

        }
        //    System.out.println(wordList.get(5));
    }
