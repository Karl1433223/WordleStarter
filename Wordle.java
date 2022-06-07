/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 */

import java.sql.SQLOutput;

public class Wordle {
    String word;
    int number;

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
        number = (int) (Math.random() * (WordleDictionary.FIVE_LETTER_WORDS.length));
        word = WordleDictionary.FIVE_LETTER_WORDS[number].toUpperCase();


    }




    /*
     * Called when the user hits the RETURN key or clicks the ENTER button,
     *
     * passing in the string of characters on the current row.
     */

    public void enterAction(String s) {
        gw.showMessage("You have to implement this method.");
        int l = 0;
        boolean found = false;
        System.out.println(s);
        for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
            if (s.equals(WordleDictionary.FIVE_LETTER_WORDS[i].toUpperCase())) {
                found = true;
            }


        }
        if (found) {
            gw.showMessage("It is a valid word");

            for (int i = 0; i < word.length(); i++) {
                if (s.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);

                }
            }
            for (int j = 0; j < word.length(); j++) {
                if (!gw.getSquareColor(gw.getCurrentRow(), j).equals(WordleGWindow.CORRECT_COLOR) && word.contains(s.substring(j, j + 1))) {
                  gw.setSquareColor(gw.getCurrentRow(), j, WordleGWindow.PRESENT_COLOR);
                } else if (!word.contains(s.substring(j,j+1))){
                    gw.setSquareColor(gw.getCurrentRow(), j, WordleGWindow.MISSING_COLOR);
                }
           for(int n=0; n<word.length();n++) {
               if(s.substring(n,n+1).equals(word.substring(n,n+1))) {
                   gw.setKeyColor(s.substring(n, n + 1), WordleGWindow.CORRECT_COLOR);
               }
                   if (word.contains(s.substring(n,n+1))&& (!gw.getKeyColor(s.substring(n,n+1)).equals(WordleGWindow.CORRECT_COLOR))) {
                       gw.setKeyColor(s.substring(n, n + 1), WordleGWindow.PRESENT_COLOR);
                   }
                   else if (!word.contains(s.substring(n,n+1))) {
                       gw.setKeyColor(s.substring(n,n+1),WordleGWindow.MISSING_COLOR);

                   }



           }

            }
            if (word.equals(s)){
                gw.showMessage("You got the word");
            }if (gw.getCurrentRow() ==5&&!word.equals(s)){
                gw.showMessage("This is the "+ word);
                if(!word.equals(s)){
                    gw.showMessage("You lost, this is correct word "+s);
                }
            }


            gw.setCurrentRow(gw.getCurrentRow() + 1);
            } else{
                gw.showMessage("This is not a valid word");
            }





    }





    /* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

    /* Private instance variables */

    private WordleGWindow gw;

}
