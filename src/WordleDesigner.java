import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordleDesigner extends JFrame {
    private JButton ENTERButton;
    private JPanel panel;
    private JButton cButton;
    private JButton xButton;
    private JButton zButton;
    private JButton bButton;
    private JButton nButton;
    private JButton DELETEButton;
    private JButton mButton;
    private JButton hButton;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton aButton;
    private JButton fButton;
    private JButton dButton;
    private JButton sButton;
    private JButton yButton;
    private JButton oButton;
    private JButton pButton;
    private JButton iButton;
    private JButton uButton;
    private JButton rButton;
    private JButton eButton;
    private JButton wButton;
    private JButton qButton;
    private JTextField tfRow4;
    private JTextField tfRow6;
    private JTextField tfRow5;
    private JTextField tfRow3;
    private JTextField tfRow2;
    private JTextField tfRow1;
    private JLabel titleLabel;
    private JButton tButton;
    private JButton gButton;
    private JButton vButton;

    public WordleDesigner() {
        super();
        Wordle word = new Wordle();

        this.setTitle("Type a word");
        this.setContentPane(panel);
        this.setMinimumSize(new Dimension(1000, 1000));
        //setModal(true);
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfRow1.setText(tfRow1.getText());
                //JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
        tfRow1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tfRow1.setText(tfRow1.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow1.getText())) {

                        tfRow1.setEditable(false);
                    }
                }
                super.keyPressed(e);

            }

        });
        tfRow1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow1.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        tfRow2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tfRow2.setText(tfRow2.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow2.getText().toLowerCase().trim())) {

                        tfRow2.setEditable(false);
                    }
                }
                super.keyPressed(e);
            }
        });
        tfRow2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow2.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        tfRow3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tfRow3.setText(tfRow3.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow3.getText().toLowerCase().trim())) {

                        tfRow3.setEditable(false);
                    }
                }
                super.keyPressed(e);
            }
        });
        tfRow3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow3.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        tfRow4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tfRow4.setText(tfRow4.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow4.getText().toLowerCase().trim())) {

                        tfRow4.setEditable(false);
                    }
                }
                super.keyPressed(e);
            }
        });
        tfRow4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow4.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        tfRow5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                tfRow5.setText(tfRow5.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow5.getText().toLowerCase().trim())) {

                        tfRow5.setEditable(false);
                    }
                }
                super.keyPressed(e);
            }
        });
        tfRow5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow5.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        tfRow6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tfRow6.setText(tfRow6.getText().toLowerCase().trim());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (word.checkArray(tfRow6.getText().toLowerCase().trim())) {
                        tfRow6.setBackground(Color.CYAN);
                        tfRow6.setEditable(false);
                    }
                }
                super.keyPressed(e);

            }
        });
        tfRow6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();

                if (tfRow6.getText().length() > 4) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        
        qButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tfRow1.setText(tfRow1.getText() + "q");
                tfRow1.addKeyListener(new KeyAdapter() {
                });
            }
        });


        tfRow6.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println(e);
                super.componentAdded(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("WordleDesigner");
        frame.setContentPane(new WordleDesigner().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        //frame.pack();
        frame.setVisible(true);
    }



}
