import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import java.util.Arrays;
import javax.swing.*;
//import javax.swing.border.*;
import javax.swing.event.*;



/*
 * Created by JFormDesigner on Wed Nov 02 09:37:18 CDT 2022
 */



/**
 * @author Zakharias Joseph
 */
public class nullDesign {


    private ArrayList<JTextField> textList;
    private JTextField[] textArray;
    private JTextField[][] text2dArray;
    private JTextField cursor ;

    public nullDesign() {
        initComponents();
        cursor = tf11;
        textList = new ArrayList<JTextField>();
        textList.add(tf11);
        textList.add(tf12);
        textList.add(tf13);
        textList.add(tf14);
        textList.add(tf15);
        textArray = new JTextField[30];
        textArray[0] = tf11;
        //text2dArray = new JTextField[6][5];
        text2dArray = new JTextField[][]{{tf11, tf12, tf13, tf14, tf15},{tf21,tf22,tf23,tf24,tf25},{tf31,tf32,tf33,tf34,tf35},
                {tf41,tf42,tf43,tf44,tf45},{tf51,tf52,tf53,tf54,tf55},{tf61,tf62,tf63,tf64,tf65}};
        //System.out.println(Arrays.toString(textList));
        /*
        if(tf11.getText().equals(textList.get(0).getText())){
            System.out.println("same");
        }else{
            System.out.println("diff");
        }
         */
        //text2dArray.

        tf11.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("d");
                //System.out.println(e.getDocument());
                //System.out.println(e.toString());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }
    private void tf11KeyTyped(KeyEvent e) {
        cursor = tf11;
        boolean max = tf11.getText().length() > 0;
        System.out.println(Character.toString(e.getKeyChar()).matches("[a-zA-Z]"));
        /*if(!Character.toString(e.getKeyChar()).matches("[a-zA-Z]")){
            System.out.println("12");
            e.consume();

        }

         */
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }
        System.out.println("sd"+max+tf11.getText().length());
        if (max&&(Character.isLetter(e.getKeyChar()))) {
            e.consume();
            tf12.setText(Character.toString(e.getKeyChar()));
            cursor = tf12;
            tf12.requestFocusInWindow();
        }

        //System.out.println(cursor);
    }

    private void tf12KeyTyped(KeyEvent e) {
        cursor = tf12;
        boolean max = tf12.getText().length() > 0;

       /* if(!Character.toString(e.getKeyChar()).matches("[a-zA-Z]")){
            System.out.println("12");
            e.consume();

        }

        */
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }

        if ( max ){
            e.consume();
            cursor = tf12;
        }
        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
        {
            System.out.println("tr");
            cursor = tf11;
            tf11.requestFocusInWindow();
        }else if(Character.isLetter(e.getKeyChar())) {
            tf13.setText(Character.toString(e.getKeyChar()));
            cursor = tf13;
            tf13.requestFocusInWindow();
        }

        System.out.println("13"+findPrevFocus().getName());

    }
    
    private void tf13KeyTyped(KeyEvent e) {
        cursor = tf13;
        boolean max = tf13.getText().length() > 0;
        /*if(!Character.toString(e.getKeyChar()).matches("[a-zA-Z]")){
            System.out.println("12");
            e.consume();

        }

         */
        if ( max ){
            e.consume();
            cursor = tf13;
        }
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }

        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
        {
            cursor = tf12;
            tf12.requestFocusInWindow();
        }else if(Character.isLetter(e.getKeyChar())) {
            tf14.setText(Character.toString(e.getKeyChar()));
            cursor = tf14;
            tf14.requestFocusInWindow();
        }

        System.out.println(findPrevFocus().getName());

    }
    private void tf14KeyTyped(KeyEvent e) {
        cursor = tf14;
        /*if(!Character.toString(e.getKeyChar()).matches("[a-zA-Z]")){
            System.out.println("12");
            e.consume();

        }

         */
        boolean max = tf14.getText().length() > 0;
        if ( max ){
            e.consume();
        }
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }
        
        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
        {
            cursor = tf13;
            tf13.requestFocusInWindow();
        }else if(Character.isLetter(e.getKeyChar())){
            tf15.setText(Character.toString(e.getKeyChar()));
            cursor = tf15;
            tf15.requestFocusInWindow();
        }
    }
    private void tf15KeyTyped(KeyEvent e) {
        cursor = tf15;
        boolean max = tf15.getText().length() > 0;
        if ( max ){
            e.consume();
        }
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }

        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
        {
            cursor = tf14;
            tf14.requestFocusInWindow();
        }
    }

    private void q(ActionEvent e) {

            cursor.setText("q");

        //cursor.setn;
        if (cursor != tf15 && cursor != tf25) {
            //buttonQ.dispatchEvent(tf11KeyTyped(KeyEvent.VK_Q););
            cursor = textList.get(textList.indexOf(cursor) + 1);
        }
        cursor.requestFocusInWindow();
        //(Component)e.getSource().transfer.setText("Q");
    }

    private void dELETE(ActionEvent e) {
        //System.out.println(findPrevFocus().getX());
        cursor.setText("");
        //cursor.transferFocus();
        if (cursor != tf11 && cursor != tf21) {
            cursor = textList.get(textList.indexOf(cursor) - 1);
        }
        cursor.requestFocusInWindow();
    }
    public static Component findPrevFocus() {
        Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        Container root = c.getFocusCycleRootAncestor();

        FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
        Component prevFocus = policy.getComponentBefore(root, c);
        if (prevFocus == null) {
            prevFocus = policy.getDefaultComponent(root);
        }
        System.out.println(root);
        return prevFocus;
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Zakharias Joseph
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
        label1 = new JLabel();

        //======== frameMain ========
        {
            frameMain.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,frameMain. getBorder( )) ); frameMain. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            frameMain.setLayout(null);

            //---- buttonV ----
            buttonV.setText("V");
            buttonV.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonV);
            buttonV.setBounds(475, 625, 45, 60);

            //---- buttonC ----
            buttonC.setText("C");
            buttonC.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonC);
            buttonC.setBounds(425, 625, 45, 60);

            //---- buttonX ----
            buttonX.setText("X");
            buttonX.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonX);
            buttonX.setBounds(375, 625, 45, 60);

            //---- buttonB ----
            buttonB.setText("B");
            buttonB.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonB);
            buttonB.setBounds(525, 625, 45, 60);

            //---- buttonN ----
            buttonN.setText("N");
            buttonN.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonN);
            buttonN.setBounds(575, 625, 45, 60);

            //---- buttonM ----
            buttonM.setText("M");
            buttonM.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonM);
            buttonM.setBounds(625, 625, 45, 60);

            //---- buttonZ ----
            buttonZ.setText("Z");
            buttonZ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonZ);
            buttonZ.setBounds(325, 625, 45, 60);

            //---- buttonENTER ----
            buttonENTER.setText("ENTER");
            buttonENTER.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonENTER);
            buttonENTER.setBounds(255, 625, 65, 60);

            //---- buttonDELETE ----
            buttonDELETE.setText("DEL");
            buttonDELETE.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonDELETE.addActionListener(e -> dELETE(e));
            frameMain.add(buttonDELETE);
            buttonDELETE.setBounds(675, 625, 70, 60);

            //---- buttonG ----
            buttonG.setText("G");
            buttonG.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonG);
            buttonG.setBounds(475, 560, 45, 60);

            //---- buttonF ----
            buttonF.setText("F");
            buttonF.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonF);
            buttonF.setBounds(425, 560, 45, 60);

            //---- buttonH ----
            buttonH.setText("H");
            buttonH.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonH);
            buttonH.setBounds(525, 560, 45, 60);

            //---- buttonD ----
            buttonD.setText("D");
            buttonD.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonD);
            buttonD.setBounds(375, 560, 45, 60);

            //---- buttonJ ----
            buttonJ.setText("J");
            buttonJ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonJ);
            buttonJ.setBounds(575, 560, 45, 60);

            //---- buttonK ----
            buttonK.setText("K");
            buttonK.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonK);
            buttonK.setBounds(625, 560, 45, 60);

            //---- buttonL ----
            buttonL.setText("L");
            buttonL.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonL);
            buttonL.setBounds(675, 560, 45, 60);

            //---- buttonS ----
            buttonS.setText("S");
            buttonS.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonS);
            buttonS.setBounds(325, 560, 45, 60);

            //---- buttonA ----
            buttonA.setText("A");
            buttonA.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonA);
            buttonA.setBounds(275, 560, 45, 60);

            //---- buttonT ----
            buttonT.setText("T");
            buttonT.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonT);
            buttonT.setBounds(450, 495, 45, 60);

            //---- buttonY ----
            buttonY.setText("Y");
            buttonY.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonY);
            buttonY.setBounds(500, 495, 45, 60);

            //---- buttonU ----
            buttonU.setText("U");
            buttonU.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonU);
            buttonU.setBounds(550, 495, 45, 60);

            //---- buttonI ----
            buttonI.setText("I");
            buttonI.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonI);
            buttonI.setBounds(600, 495, 45, 60);

            //---- buttonO ----
            buttonO.setText("O");
            buttonO.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonO);
            buttonO.setBounds(650, 495, 45, 60);

            //---- buttonP ----
            buttonP.setText("P");
            buttonP.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonP);
            buttonP.setBounds(700, 495, 45, 60);

            //---- buttonR ----
            buttonR.setText("R");
            buttonR.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonR);
            buttonR.setBounds(400, 495, 45, 60);

            //---- buttonE ----
            buttonE.setText("E");
            buttonE.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonE);
            buttonE.setBounds(350, 495, 45, 60);

            //---- buttonQ ----
            buttonQ.setText("Q");
            buttonQ.setFont(new Font("Segoe UI", Font.BOLD, 11));
            buttonQ.addActionListener(e -> q(e));
            frameMain.add(buttonQ);
            buttonQ.setBounds(250, 495, 45, 60);

            //---- buttonW ----
            buttonW.setText("W");
            buttonW.setFont(new Font("Segoe UI", Font.BOLD, 11));
            frameMain.add(buttonW);
            buttonW.setBounds(300, 495, 45, 60);

            //---- tf61 ----
            tf61.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf61);
            tf61.setBounds(325, 395, 60, 60);

            //---- tf51 ----
            tf51.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf51);
            tf51.setBounds(325, 330, 60, 60);

            //---- tf41 ----
            tf41.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf41);
            tf41.setBounds(325, 265, 60, 60);

            //---- tf31 ----
            tf31.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf31);
            tf31.setBounds(325, 200, 60, 60);

            //---- tf21 ----
            tf21.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf21);
            tf21.setBounds(325, 135, 60, 60);

            //---- tf11 ----
            tf11.setHorizontalAlignment(SwingConstants.CENTER);
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
            frameMain.add(tf62);
            tf62.setBounds(395, 395, 60, 60);

            //---- tf52 ----
            tf52.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf52);
            tf52.setBounds(395, 330, 60, 60);

            //---- tf42 ----
            tf42.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf42);
            tf42.setBounds(395, 265, 60, 60);

            //---- tf32 ----
            tf32.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf32);
            tf32.setBounds(395, 200, 60, 60);

            //---- tf22 ----
            tf22.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf22);
            tf22.setBounds(395, 135, 60, 60);

            //---- tf12 ----
            tf12.setHorizontalAlignment(SwingConstants.CENTER);
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
            frameMain.add(tf63);
            tf63.setBounds(465, 395, 60, 60);

            //---- tf53 ----
            tf53.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf53);
            tf53.setBounds(465, 330, 60, 60);

            //---- tf43 ----
            tf43.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf43);
            tf43.setBounds(465, 265, 60, 60);

            //---- tf33 ----
            tf33.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf33);
            tf33.setBounds(465, 200, 60, 60);

            //---- tf23 ----
            tf23.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf23);
            tf23.setBounds(465, 135, 60, 60);

            //---- tf13 ----
            tf13.setHorizontalAlignment(SwingConstants.CENTER);
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
            frameMain.add(tf64);
            tf64.setBounds(535, 395, 60, 60);

            //---- tf54 ----
            tf54.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf54);
            tf54.setBounds(535, 330, 60, 60);

            //---- tf44 ----
            tf44.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf44);
            tf44.setBounds(535, 265, 60, 60);

            //---- tf65 ----
            tf65.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf65);
            tf65.setBounds(605, 395, 60, 60);

            //---- tf55 ----
            tf55.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf55);
            tf55.setBounds(605, 330, 60, 60);

            //---- tf34 ----
            tf34.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf34);
            tf34.setBounds(535, 200, 60, 60);

            //---- tf45 ----
            tf45.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf45);
            tf45.setBounds(605, 265, 60, 60);

            //---- tf35 ----
            tf35.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf35);
            tf35.setBounds(605, 200, 60, 60);

            //---- tf24 ----
            tf24.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf24);
            tf24.setBounds(535, 135, 60, 60);

            //---- tf25 ----
            tf25.setHorizontalAlignment(SwingConstants.CENTER);
            frameMain.add(tf25);
            tf25.setBounds(605, 135, 60, 60);

            //---- tf14 ----
            tf14.setHorizontalAlignment(SwingConstants.CENTER);
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
            tf15.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    tf15KeyTyped(e);
                }
            });
            frameMain.add(tf15);
            tf15.setBounds(605, 70, 60, 60);

            //---- label1 ----
            label1.setText("Wordle");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
            frameMain.add(label1);
            label1.setBounds(445, 20, 105, 25);

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
    public static void main(String[] args) {
        JFrame frame = new JFrame("Design");
        frame.setContentPane(new nullDesign().frameMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        //frame.pack();
        frame.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Zakharias Joseph
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
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
