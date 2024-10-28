import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * Created by JFormDesigner on Wed Nov 02 09:37:18 CDT 2022
 */



/**
 * @author Zakharias Joseph
 */
public class nullDesign {


    private final ArrayList<JTextField> textList;
    private final JTextField[][] text2dArray;
    private final ArrayList<JTextField> lastOfRowList;
    private final ArrayList<JTextField> firstOfRowList;
    private JTextField cursor;
    private String guessedWord;
    private final String wordle;
    private final Wordle wrd;
    private final ArrayList<JButton> buttonList;

    public nullDesign() {
        initComponents();
        guessedWord="";
        cursor = tf11;
        buttonList = new ArrayList<>(Arrays.asList(buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonG,buttonH,buttonI,buttonJ,buttonK,buttonL,
        buttonM,buttonN,buttonO,buttonP,buttonQ,buttonR,buttonS,buttonT,buttonU,buttonV,buttonW,buttonX,buttonY,buttonZ));

        textList = new ArrayList<>(Arrays.asList(tf11,tf12,tf13,tf14,tf15,tf21,tf22,tf23,tf24,tf25,tf31,tf32,tf33,tf34,tf35,
    tf41,tf42,tf43,tf44,tf45,tf51,tf52,tf53,tf54,tf55,tf61,tf62,tf63,tf64,tf65));

        lastOfRowList = new ArrayList<>(Arrays.asList(tf15,tf25,tf35,tf45,tf55,tf65));

        firstOfRowList = new ArrayList<>(Arrays.asList(tf11,tf21,tf31,tf41,tf51,tf61));

        text2dArray = new JTextField[][]{{tf11, tf12, tf13, tf14, tf15},{tf21,tf22,tf23,tf24,tf25},{tf31,tf32,tf33,tf34,tf35},
                {tf41,tf42,tf43,tf44,tf45},{tf51,tf52,tf53,tf54,tf55},{tf61,tf62,tf63,tf64,tf65}};
        wrd = new Wordle();

        wordle = wrd.getWord();
        for(int i = 1; i<text2dArray.length;i++){
            for(int j = 0;j<text2dArray[i].length;j++){
                text2dArray[i][j].setEnabled(false);
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Design");
        frame.setContentPane(new nullDesign().frameMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setVisible(true);

    }
    private void tf11KeyTyped(KeyEvent e) {

        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf11;
            boolean max = tf11.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf12.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf12;
                tf12.requestFocusInWindow();
            }
        }
    }

    private void tf12KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf12;
            boolean max = tf12.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf11;
                tf11.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf13.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf13;
                tf13.requestFocusInWindow();
            }
        }
    }

    private void tf13KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf13;
            boolean max = tf13.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf12;
                tf12.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf14.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf14;
                tf14.requestFocusInWindow();
            }
        }
    }
    private void tf14KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf14;

            boolean max = tf14.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf13;
                tf13.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf15.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf15;
                tf15.requestFocusInWindow();
            }
        }
    }

    private void tf15KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf15;
            boolean max = tf15.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }
            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf14;
                tf14.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(tf15);
                    cursor = tf21;
                    cursor.requestFocusInWindow();
                }
            }
        }
    }
    private void tf21KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf21;
            boolean max = tf21.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf22.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf22;
                tf22.requestFocusInWindow();
            }
        }
    }

    private void tf22KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf22;
            boolean max = tf22.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf21;
                tf21.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf23.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf23;
                tf23.requestFocusInWindow();
            }
        }
    }

    private void tf23KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf23;
            boolean max = tf23.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf22;
                tf22.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf24.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf24;
                tf24.requestFocusInWindow();
            }
        }
    }

    private void tf24KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf24;

            boolean max = tf24.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf23;
                tf23.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf25.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf25;
                tf25.requestFocusInWindow();
            }
        }
    }

    private void tf25KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf25;
            boolean max = tf25.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf24;
                tf24.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(cursor);
                    cursor = tf31;
                    cursor.requestFocusInWindow();
                }
            }
        }
    }
    private void tf31KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf31;
            boolean max = tf31.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf32.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf32;
                tf32.requestFocusInWindow();
            }
        }
    }

    private void tf32KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf32;
            boolean max = tf32.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf31;
                tf31.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf33.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf33;
                tf33.requestFocusInWindow();
            }
        }
    }

    private void tf33KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf33;
            boolean max = tf33.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf32;
                tf32.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf34.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf34;
                tf34.requestFocusInWindow();
            }
        }
    }

    private void tf34KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf34;

            boolean max = tf34.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf33;
                tf33.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf35.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf35;
                tf35.requestFocusInWindow();
            }
        }
    }

    private void tf35KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf35;
            boolean max = tf35.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf34;
                tf34.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(cursor);
                    cursor = tf41;
                    cursor.requestFocusInWindow();
                }
            }
        }
    }
    private void tf41KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf41;
            boolean max = tf41.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf42.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf42;
                tf42.requestFocusInWindow();
            }
        }
    }

    private void tf42KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf42;
            boolean max = tf42.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf41;
                tf41.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf43.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf43;
                tf43.requestFocusInWindow();
            }
        }
    }

    private void tf43KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf43;
            boolean max = tf43.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf42;
                tf42.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf44.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf44;
                tf44.requestFocusInWindow();
            }
        }
    }

    private void tf44KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf44;

            boolean max = tf44.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf43;
                tf43.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf45.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf45;
                tf45.requestFocusInWindow();
            }
        }
    }

    private void tf45KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf45;
            boolean max = tf45.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf44;
                tf44.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(cursor);
                    cursor = tf51;
                    cursor.requestFocusInWindow();
                }
            }
        }
    }

    private void tf51KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf51;
            boolean max = tf51.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf52.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf52;
                tf52.requestFocusInWindow();
            }
        }
    }

    private void tf52KeyTyped(KeyEvent e) {
        if (!cursor.isEditable() || !cursor.isEnabled()) {
            e.consume();
        } else {
            cursor = tf52;
            boolean max = tf52.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf51;
                tf51.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf53.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf53;
                tf53.requestFocusInWindow();
            }
        }
    }

    private void tf53KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf53;
            boolean max = tf53.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf52;
                tf52.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf54.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf54;
                tf54.requestFocusInWindow();
            }
        }
    }

    private void tf54KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf54;

            boolean max = tf54.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf53;
                tf53.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf55.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf55;
                tf55.requestFocusInWindow();
            }
        }
    }

    private void tf55KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf55;
            boolean max = tf55.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf54;
                tf54.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(cursor);
                    cursor = tf61;
                    cursor.requestFocusInWindow();
                }
            }
        }
    }

    private void tf61KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf61;
            boolean max = tf61.getText().length() > 0;

            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (max && (Character.isLetter(e.getKeyChar()))) {
                e.consume();
                tf62.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf62;
                tf62.requestFocusInWindow();
            }
        }
    }

    private void tf62KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf62;
            boolean max = tf62.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf61;
                tf61.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf63.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf63;
                tf63.requestFocusInWindow();
            }
        }
    }

    private void tf63KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf63;
            boolean max = tf63.getText().length() > 0;

            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();

            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf62;
                tf62.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf64.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf64;
                tf64.requestFocusInWindow();
            }
        }
    }

    private void tf64KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf64;

            boolean max = tf64.getText().length() > 0;
            if (max || !(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf63;
                tf63.requestFocusInWindow();
            } else if (max && Character.isLetter(e.getKeyChar())) {
                tf65.setText(Character.toString(e.getKeyChar()).toUpperCase());
                cursor = tf65;
                tf65.requestFocusInWindow();
            }
        }
    }

    private void tf65KeyTyped(KeyEvent e) {
        if(!cursor.isEditable()||!cursor.isEnabled()){
            e.consume();
        }else {
            cursor = tf65;
            boolean max = tf65.getText().length() > 0;
            if (max) {
                e.consume();
            }
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            } else {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }

            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                cursor = tf64;
                tf64.requestFocusInWindow();
            } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                setGuessedWord(cursor);
                if (wrd.checkArray(guessedWord.toLowerCase())) {
                    findWord(cursor);
                }
            }
        }
    }
    private void q(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("Q");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("Q");
            }
        }
            cursor.requestFocusInWindow();
    }
    private void w(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("W");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("W");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void e(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("E");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("E");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void r(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("R");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("R");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void t(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("T");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("T");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void y(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("Y");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("Y");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void u(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("U");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("U");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void i(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("I");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("I");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void o(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("O");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("O");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void p(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("P");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("P");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void a(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("A");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("A");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void s(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("S");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("S");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void d(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("D");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("D");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void f(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("F");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("F");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void g(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("G");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("G");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void h(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("H");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("H");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void j(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("J");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("J");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void k(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("K");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("K");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void l(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("L");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("L");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void z(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("Z");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("Z");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void x(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("X");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("X");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void c(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("C");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("C");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void v(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("V");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("V");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void b(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("B");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("B");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void n(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("N");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("N");
            }
        }
        cursor.requestFocusInWindow();
    }

    private void m(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            if ((cursor.getText().length() > 0) && (!(lastOfRowList.contains(cursor)))) {
                int index = textList.indexOf(cursor);
                cursor = textList.get(index + 1);
                cursor.setText("M");
            } else if (cursor.getText().length() == 0) {
                cursor.setText("M");
            }
        }
        cursor.requestFocusInWindow();
    }
    private void dELETE(ActionEvent e) {
        if(cursor.isEnabled()&&cursor.isEditable()) {
            cursor.setText("");
            if (!(firstOfRowList.contains(cursor))) {
                cursor = textList.get(textList.indexOf(cursor) - 1);
            }
        }
        cursor.requestFocusInWindow();
    }

    private void eNTER(ActionEvent e) {
        setGuessedWord(cursor);
        int cursorposition =textList.indexOf(cursor);
        boolean realWord = wrd.checkArray(guessedWord.toLowerCase());

        if((lastOfRowList.contains(cursor))&&cursor!=tf65&&realWord&& cursor.isEditable()){

            findWord(cursor);
            cursor = textList.get( cursorposition  + 1);
        } else if ((cursor == tf65)&&realWord&& cursor.isEditable()) {
            findWord(cursor);
        }
        cursor.requestFocusInWindow();
    }
    public void setGuessedWord(JTextField position){

        guessedWord="";
        int rowNum = getRow(position);
        for(int col = 0;col<text2dArray[rowNum].length;col++){
            guessedWord +=text2dArray[rowNum][col].getText();
        }
    }
    public int getRow(JTextField position){
        int rowNum = 0;

        for(int row = 0; row<text2dArray.length;row++){
            for(int col = 0;col<text2dArray[row].length;col++){
                if(position==text2dArray[row][col]){
                    rowNum = row;
                    break;
                }
            }
        }
        return rowNum;
    }
    public void findWord(JTextField position){
        int rowNum = getRow(position);

        String colorCheck =  wrd.colorCheck(guessedWord.toLowerCase());

        ArrayList<String> letterColor = wrd.getColor(guessedWord,colorCheck);

        
        char[] wordleListChar = guessedWord.toCharArray();
        if(wrd.checkWord(guessedWord.toLowerCase())){
            greenTFields(rowNum);
            for(int i =0;i<5;i++){
                JButton currentButton =findButton(wordleListChar, i);
                currentButton.setForeground(Color.white);
                currentButton.setBackground(Color.GREEN);
            }
        }else {
            for (int i = 0; i < text2dArray[rowNum].length; i++) {
                int letNum = ((int) (wordleListChar[i])) - 65;
                String letColor = letterColor.get(i);
                JButton letterButton = buttonList.get(letNum);

                text2dArray[rowNum][i].setForeground(Color.white);
                switch (letColor) {
                    case "green":
                        text2dArray[rowNum][i].setBackground(Color.GREEN);
                        break;
                    case "yellow":
                        text2dArray[rowNum][i].setBackground(Color.ORANGE);
                        break;
                    case "grey":
                        text2dArray[rowNum][i].setBackground(Color.gray);
                        break;
                }

                text2dArray[rowNum][i].setEditable(false);
                if (rowNum != 5) {
                    text2dArray[rowNum + 1][i].setEnabled(true);
                }
                changeButtonColor(letColor, letterButton);
            }
        }
        if(wrd.checkWord(guessedWord.toLowerCase())||rowNum==5){
            titleLabel.setText(wordle.toUpperCase());
        }
    }
    public JButton findButton(char[] wordleListChar, int i){
        int letNum = ((int) (wordleListChar[i])) - 65;
        return buttonList.get(letNum);
    }
        public void changeButtonColor(String letterColor,JButton currentButton){
            currentButton.setForeground(Color.white);
            if(currentButton.getBackground()==Color.white) {
                switch (letterColor) {
                    case "green":
                        currentButton.setBackground(Color.GREEN);
                        break;
                    case "yellow":
                        currentButton.setBackground(Color.ORANGE);
                        break;
                    case "grey":
                        currentButton.setBackground(Color.gray);
                        break;
                }
            }else if ((letterColor.equals("green"))&&currentButton.getBackground()==Color.ORANGE) {
                currentButton.setBackground(Color.GREEN);
            }
        }
        public void greenTFields(int rowNum){
        for(int i =0;i<guessedWord.length();i++) {
            text2dArray[rowNum][i].setForeground(Color.white);
            text2dArray[rowNum][i].setBackground(Color.GREEN);
            text2dArray[rowNum][i].setEditable(false);

        }
        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        frameMain = new JPanel();
        buttonV = new JButton();
        buttonC = new JButton();
        buttonX = new JButton();
        buttonB = new JButton();
        buttonN = new JButton();
        buttonM = new JButton();
        buttonZ = new JButton();
        buttonENTER = new JButton();
        buttonDELETE = new JButton();
        buttonG = new JButton();
        buttonF = new JButton();
        buttonH = new JButton();
        buttonD = new JButton();
        buttonJ = new JButton();
        buttonK = new JButton();
        buttonL = new JButton();
        buttonS = new JButton();
        buttonA = new JButton();
        buttonT = new JButton();
        buttonY = new JButton();
        buttonU = new JButton();
        buttonI = new JButton();
        buttonO = new JButton();
        buttonP = new JButton();
        buttonR = new JButton();
        buttonE = new JButton();
        buttonQ = new JButton();
        buttonW = new JButton();
        tf61 = new JTextField();
        tf51 = new JTextField();
        tf41 = new JTextField();
        tf31 = new JTextField();
        tf21 = new JTextField();
        tf11 = new JTextField();
        tf62 = new JTextField();
        tf52 = new JTextField();
        tf42 = new JTextField();
        tf32 = new JTextField();
        tf22 = new JTextField();
        tf12 = new JTextField();
        tf63 = new JTextField();
        tf53 = new JTextField();
        tf43 = new JTextField();
        tf33 = new JTextField();
        tf23 = new JTextField();
        tf13 = new JTextField();
        tf64 = new JTextField();
        tf54 = new JTextField();
        tf44 = new JTextField();
        tf65 = new JTextField();
        tf55 = new JTextField();
        tf34 = new JTextField();
        tf45 = new JTextField();
        tf35 = new JTextField();
        tf24 = new JTextField();
        tf25 = new JTextField();
        tf14 = new JTextField();
        tf15 = new JTextField();
        titleLabel = new JLabel();

        //======== frameMain ========
        {
            frameMain.setLayout(null);

            //---- buttonV ----
            buttonV.setText("V");
            buttonV.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonV.setBackground(Color.white);
            buttonV.addActionListener(e -> v(e));
            frameMain.add(buttonV);
            buttonV.setBounds(475, 625, 45, 60);

            //---- buttonC ----
            buttonC.setText("C");
            buttonC.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonC.setBackground(Color.white);
            buttonC.addActionListener(e -> c(e));
            frameMain.add(buttonC);
            buttonC.setBounds(425, 625, 45, 60);

            //---- buttonX ----
            buttonX.setText("X");
            buttonX.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonX.setBackground(Color.white);
            buttonX.addActionListener(e -> x(e));
            frameMain.add(buttonX);
            buttonX.setBounds(375, 625, 45, 60);

            //---- buttonB ----
            buttonB.setText("B");
            buttonB.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonB.setBackground(Color.white);
            buttonB.addActionListener(e -> b(e));
            frameMain.add(buttonB);
            buttonB.setBounds(525, 625, 45, 60);

            //---- buttonN ----
            buttonN.setText("N");
            buttonN.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonN.setBackground(Color.white);
            buttonN.addActionListener(e -> n(e));
            frameMain.add(buttonN);
            buttonN.setBounds(575, 625, 45, 60);

            //---- buttonM ----
            buttonM.setText("M");
            buttonM.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonM.setBackground(Color.white);
            buttonM.addActionListener(e -> m(e));
            frameMain.add(buttonM);
            buttonM.setBounds(625, 625, 45, 60);

            //---- buttonZ ----
            buttonZ.setText("Z");
            buttonZ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonZ.setBackground(Color.white);
            buttonZ.addActionListener(e -> z(e));
            frameMain.add(buttonZ);
            buttonZ.setBounds(325, 625, 45, 60);

            //---- buttonENTER ----
            buttonENTER.setText("ENTER");
            buttonENTER.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonENTER.setBackground(Color.white);
            buttonENTER.addActionListener(e -> eNTER(e));
            frameMain.add(buttonENTER);
            buttonENTER.setBounds(250, 625, 70, 60);

            //---- buttonDELETE ----
            buttonDELETE.setText("DEL");
            buttonDELETE.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonDELETE.setBackground(Color.white);
            buttonDELETE.addActionListener(e -> dELETE(e));
            frameMain.add(buttonDELETE);
            buttonDELETE.setBounds(675, 625, 70, 60);

            //---- buttonG ----
            buttonG.setText("G");
            buttonG.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonG.setBackground(Color.white);
            buttonG.addActionListener(e -> g(e));
            frameMain.add(buttonG);
            buttonG.setBounds(475, 560, 45, 60);

            //---- buttonF ----
            buttonF.setText("F");
            buttonF.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonF.setBackground(Color.white);
            buttonF.addActionListener(e -> f(e));
            frameMain.add(buttonF);
            buttonF.setBounds(425, 560, 45, 60);

            //---- buttonH ----
            buttonH.setText("H");
            buttonH.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonH.setBackground(Color.white);
            buttonH.addActionListener(e -> h(e));
            frameMain.add(buttonH);
            buttonH.setBounds(525, 560, 45, 60);

            //---- buttonD ----
            buttonD.setText("D");
            buttonD.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonD.setBackground(Color.white);
            buttonD.addActionListener(e -> d(e));
            frameMain.add(buttonD);
            buttonD.setBounds(375, 560, 45, 60);

            //---- buttonJ ----
            buttonJ.setText("J");
            buttonJ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonJ.setBackground(Color.white);
            buttonJ.addActionListener(e -> j(e));
            frameMain.add(buttonJ);
            buttonJ.setBounds(575, 560, 45, 60);

            //---- buttonK ----
            buttonK.setText("K");
            buttonK.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonK.setBackground(Color.white);
            buttonK.addActionListener(e -> k(e));
            frameMain.add(buttonK);
            buttonK.setBounds(625, 560, 45, 60);

            //---- buttonL ----
            buttonL.setText("L");
            buttonL.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonL.setBackground(Color.white);
            buttonL.addActionListener(e -> l(e));
            frameMain.add(buttonL);
            buttonL.setBounds(675, 560, 45, 60);

            //---- buttonS ----
            buttonS.setText("S");
            buttonS.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonS.setBackground(Color.white);
            buttonS.addActionListener(e -> s(e));
            frameMain.add(buttonS);
            buttonS.setBounds(325, 560, 45, 60);

            //---- buttonA ----
            buttonA.setText("A");
            buttonA.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonA.setBackground(Color.white);
            buttonA.addActionListener(e -> a(e));
            frameMain.add(buttonA);
            buttonA.setBounds(275, 560, 45, 60);

            //---- buttonT ----
            buttonT.setText("T");
            buttonT.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonT.setBackground(Color.white);
            buttonT.addActionListener(e -> t(e));
            frameMain.add(buttonT);
            buttonT.setBounds(450, 495, 45, 60);

            //---- buttonY ----
            buttonY.setText("Y");
            buttonY.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonY.setBackground(Color.white);
            buttonY.addActionListener(e -> y(e));
            frameMain.add(buttonY);
            buttonY.setBounds(500, 495, 45, 60);

            //---- buttonU ----
            buttonU.setText("U");
            buttonU.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonU.setBackground(Color.white);
            buttonU.addActionListener(e -> u(e));
            frameMain.add(buttonU);
            buttonU.setBounds(550, 495, 45, 60);

            //---- buttonI ----
            buttonI.setText("I");
            buttonI.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonI.setBackground(Color.white);
            buttonI.addActionListener(e -> i(e));
            frameMain.add(buttonI);
            buttonI.setBounds(600, 495, 45, 60);

            //---- buttonO ----
            buttonO.setText("O");
            buttonO.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonO.setBackground(Color.white);
            buttonO.addActionListener(e -> o(e));
            frameMain.add(buttonO);
            buttonO.setBounds(650, 495, 45, 60);

            //---- buttonP ----
            buttonP.setText("P");
            buttonP.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonP.setBackground(Color.white);
            buttonP.addActionListener(e -> p(e));
            frameMain.add(buttonP);
            buttonP.setBounds(700, 495, 45, 60);

            //---- buttonR ----
            buttonR.setText("R");
            buttonR.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonR.setBackground(Color.white);
            buttonR.addActionListener(e -> r(e));
            frameMain.add(buttonR);
            buttonR.setBounds(400, 495, 45, 60);

            //---- buttonE ----
            buttonE.setText("E");
            buttonE.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonE.setBackground(Color.white);
            buttonE.addActionListener(e -> e(e));
            frameMain.add(buttonE);
            buttonE.setBounds(350, 495, 45, 60);

            //---- buttonQ ----
            buttonQ.setText("Q");
            buttonQ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonQ.setBackground(Color.white);
            buttonQ.addActionListener(e -> q(e));
            frameMain.add(buttonQ);
            buttonQ.setBounds(250, 495, 45, 60);

            //---- buttonW ----
            buttonW.setText("W");
            buttonW.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonW.setBackground(Color.white);
            buttonW.addActionListener(e -> w(e));
            frameMain.add(buttonW);
            buttonW.setBounds(300, 495, 45, 60);

            //---- tf61 ----
            tf61.setHorizontalAlignment(SwingConstants.CENTER);
            tf61.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf61.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf61KeyTyped(e);
                }
            });
            frameMain.add(tf61);
            tf61.setBounds(325, 395, 60, 60);

            //---- tf51 ----
            tf51.setHorizontalAlignment(SwingConstants.CENTER);
            tf51.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf51.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf51KeyTyped(e);
                }
            });
            frameMain.add(tf51);
            tf51.setBounds(325, 330, 60, 60);

            //---- tf41 ----
            tf41.setHorizontalAlignment(SwingConstants.CENTER);
            tf41.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf41.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf41KeyTyped(e);
                }
            });
            frameMain.add(tf41);
            tf41.setBounds(325, 265, 60, 60);

            //---- tf31 ----
            tf31.setHorizontalAlignment(SwingConstants.CENTER);
            tf31.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf31.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf31KeyTyped(e);
                }
            });
            frameMain.add(tf31);
            tf31.setBounds(325, 200, 60, 60);

            //---- tf21 ----
            tf21.setHorizontalAlignment(SwingConstants.CENTER);
            tf21.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf21.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf21KeyTyped(e);
                }
            });
            frameMain.add(tf21);
            tf21.setBounds(325, 135, 60, 60);

            //---- tf11 ----
            tf11.setHorizontalAlignment(SwingConstants.CENTER);
            tf11.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf11.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf11KeyTyped(e);
                }
            });
            frameMain.add(tf11);
            tf11.setBounds(325, 70, 60, 60);

            //---- tf62 ----
            tf62.setHorizontalAlignment(SwingConstants.CENTER);
            tf62.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf62.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf62KeyTyped(e);
                }
            });
            frameMain.add(tf62);
            tf62.setBounds(395, 395, 60, 60);

            //---- tf52 ----
            tf52.setHorizontalAlignment(SwingConstants.CENTER);
            tf52.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf52.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf52KeyTyped(e);
                }
            });
            frameMain.add(tf52);
            tf52.setBounds(395, 330, 60, 60);

            //---- tf42 ----
            tf42.setHorizontalAlignment(SwingConstants.CENTER);
            tf42.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf42.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf42KeyTyped(e);
                }
            });
            frameMain.add(tf42);
            tf42.setBounds(395, 265, 60, 60);

            //---- tf32 ----
            tf32.setHorizontalAlignment(SwingConstants.CENTER);
            tf32.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf32.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf32KeyTyped(e);
                }
            });
            frameMain.add(tf32);
            tf32.setBounds(395, 200, 60, 60);

            //---- tf22 ----
            tf22.setHorizontalAlignment(SwingConstants.CENTER);
            tf22.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf22.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf22KeyTyped(e);
                }
            });
            frameMain.add(tf22);
            tf22.setBounds(395, 135, 60, 60);

            //---- tf12 ----
            tf12.setHorizontalAlignment(SwingConstants.CENTER);
            tf12.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf12.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf12KeyTyped(e);
                }
            });
            frameMain.add(tf12);
            tf12.setBounds(395, 70, 60, 60);

            //---- tf63 ----
            tf63.setHorizontalAlignment(SwingConstants.CENTER);
            tf63.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf63.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf63KeyTyped(e);
                }
            });
            frameMain.add(tf63);
            tf63.setBounds(465, 395, 60, 60);

            //---- tf53 ----
            tf53.setHorizontalAlignment(SwingConstants.CENTER);
            tf53.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf53.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf53KeyTyped(e);
                }
            });
            frameMain.add(tf53);
            tf53.setBounds(465, 330, 60, 60);

            //---- tf43 ----
            tf43.setHorizontalAlignment(SwingConstants.CENTER);
            tf43.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf43.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf43KeyTyped(e);
                }
            });
            frameMain.add(tf43);
            tf43.setBounds(465, 265, 60, 60);

            //---- tf33 ----
            tf33.setHorizontalAlignment(SwingConstants.CENTER);
            tf33.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf33.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf33KeyTyped(e);
                }
            });
            frameMain.add(tf33);
            tf33.setBounds(465, 200, 60, 60);

            //---- tf23 ----
            tf23.setHorizontalAlignment(SwingConstants.CENTER);
            tf23.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf23.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf23KeyTyped(e);
                }
            });
            frameMain.add(tf23);
            tf23.setBounds(465, 135, 60, 60);

            //---- tf13 ----
            tf13.setHorizontalAlignment(SwingConstants.CENTER);
            tf13.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf13.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf13KeyTyped(e);
                }
            });
            frameMain.add(tf13);
            tf13.setBounds(465, 70, 60, 60);

            //---- tf64 ----
            tf64.setHorizontalAlignment(SwingConstants.CENTER);
            tf64.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf64.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf64KeyTyped(e);
                }
            });
            frameMain.add(tf64);
            tf64.setBounds(535, 395, 60, 60);

            //---- tf54 ----
            tf54.setHorizontalAlignment(SwingConstants.CENTER);
            tf54.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf54.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf54KeyTyped(e);
                }
            });
            frameMain.add(tf54);
            tf54.setBounds(535, 330, 60, 60);

            //---- tf44 ----
            tf44.setHorizontalAlignment(SwingConstants.CENTER);
            tf44.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf44.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf44KeyTyped(e);
                }
            });
            frameMain.add(tf44);
            tf44.setBounds(535, 265, 60, 60);

            //---- tf65 ----
            tf65.setHorizontalAlignment(SwingConstants.CENTER);
            tf65.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf65.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf65KeyTyped(e);
                }
            });
            frameMain.add(tf65);
            tf65.setBounds(605, 395, 60, 60);

            //---- tf55 ----
            tf55.setHorizontalAlignment(SwingConstants.CENTER);
            tf55.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf55.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf55KeyTyped(e);
                }
            });
            frameMain.add(tf55);
            tf55.setBounds(605, 330, 60, 60);

            //---- tf34 ----
            tf34.setHorizontalAlignment(SwingConstants.CENTER);
            tf34.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf34.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf34KeyTyped(e);
                }
            });
            frameMain.add(tf34);
            tf34.setBounds(535, 200, 60, 60);

            //---- tf45 ----
            tf45.setHorizontalAlignment(SwingConstants.CENTER);
            tf45.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf45.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf45KeyTyped(e);
                }
            });
            frameMain.add(tf45);
            tf45.setBounds(605, 265, 60, 60);

            //---- tf35 ----
            tf35.setHorizontalAlignment(SwingConstants.CENTER);
            tf35.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf35.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf35KeyTyped(e);
                }
            });
            frameMain.add(tf35);
            tf35.setBounds(605, 200, 60, 60);

            //---- tf24 ----
            tf24.setHorizontalAlignment(SwingConstants.CENTER);
            tf24.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf24.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf24KeyTyped(e);
                }
            });
            frameMain.add(tf24);
            tf24.setBounds(535, 135, 60, 60);

            //---- tf25 ----
            tf25.setHorizontalAlignment(SwingConstants.CENTER);
            tf25.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf25.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf25KeyTyped(e);
                }
            });
            frameMain.add(tf25);
            tf25.setBounds(605, 135, 60, 60);

            //---- tf14 ----
            tf14.setHorizontalAlignment(SwingConstants.CENTER);
            tf14.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf14.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf14KeyTyped(e);
                }
            });
            frameMain.add(tf14);
            tf14.setBounds(535, 70, 60, 60);

            //---- tf15 ----
            tf15.setHorizontalAlignment(SwingConstants.CENTER);
            tf15.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tf15.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf15KeyTyped(e);
                }
            });
            frameMain.add(tf15);
            tf15.setBounds(605, 70, 60, 60);

            //---- titleLabel ----
            titleLabel.setText("Wordle");
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
            frameMain.add(titleLabel);
            titleLabel.setBounds(445, 20, 105, 25);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frameMain.getComponentCount(); i++) {
                    Rectangle bounds = frameMain.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = frameMain.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frameMain.setMinimumSize(preferredSize);
                frameMain.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel frameMain;
    private JButton buttonV;
    private JButton buttonC;
    private JButton buttonX;
    private JButton buttonB;
    private JButton buttonN;
    private JButton buttonM;
    private JButton buttonZ;
    private JButton buttonENTER;
    private JButton buttonDELETE;
    private JButton buttonG;
    private JButton buttonF;
    private JButton buttonH;
    private JButton buttonD;
    private JButton buttonJ;
    private JButton buttonK;
    private JButton buttonL;
    private JButton buttonS;
    private JButton buttonA;
    private JButton buttonT;
    private JButton buttonY;
    private JButton buttonU;
    private JButton buttonI;
    private JButton buttonO;
    private JButton buttonP;
    private JButton buttonR;
    private JButton buttonE;
    private JButton buttonQ;
    private JButton buttonW;
    private JTextField tf61;
    private JTextField tf51;
    private JTextField tf41;
    private JTextField tf31;
    private JTextField tf21;
    private JTextField tf11;
    private JTextField tf62;
    private JTextField tf52;
    private JTextField tf42;
    private JTextField tf32;
    private JTextField tf22;
    private JTextField tf12;
    private JTextField tf63;
    private JTextField tf53;
    private JTextField tf43;
    private JTextField tf33;
    private JTextField tf23;
    private JTextField tf13;
    private JTextField tf64;
    private JTextField tf54;
    private JTextField tf44;
    private JTextField tf65;
    private JTextField tf55;
    private JTextField tf34;
    private JTextField tf45;
    private JTextField tf35;
    private JTextField tf24;
    private JTextField tf25;
    private JTextField tf14;
    private JTextField tf15;
    private JLabel titleLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
