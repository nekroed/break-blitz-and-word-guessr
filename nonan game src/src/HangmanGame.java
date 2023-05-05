/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nekro
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanGame extends JFrame implements ActionListener {

    private JLabel lblWord, lblGuessesLeft, lblGuesses;
    private JTextField txtGuess;
    private JButton btnGuess;
    private String[] words = {"java", "python", "programming", "computer", "code"};
    private String word, asterisks;
    private int guessesLeft = 6;
    private String guesses = "";

    public HangmanGame() {
        super("Hangman Game");
        setLayout(new GridLayout(3, 1));

        JPanel wordPanel = new JPanel(new FlowLayout());
        lblWord = new JLabel();
        wordPanel.add(lblWord);

        JPanel guessesLeftPanel = new JPanel(new FlowLayout());
        lblGuessesLeft = new JLabel();
        guessesLeftPanel.add(lblGuessesLeft);

        JPanel guessesPanel = new JPanel(new FlowLayout());
        lblGuesses = new JLabel();
        guessesPanel.add(lblGuesses);
        txtGuess = new JTextField(3); // set preferred size to 3 columns
        txtGuess.setPreferredSize(new Dimension(300, 24)); // set preferred width to 60 pixels and height to 24 pixels
        guessesPanel.add(txtGuess);
        btnGuess = new JButton("Guess");
        btnGuess.addActionListener(this);
        guessesPanel.add(btnGuess);

        add(wordPanel);
        add(guessesLeftPanel);
        add(guessesPanel);

        newGame();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuess) {
            String guess = txtGuess.getText().toLowerCase();
            txtGuess.setText("");
            if (guess.length() == 1 && word.indexOf(guess) >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess.charAt(0)) {
                        asterisks = asterisks.substring(0, i) + guess.charAt(0) + asterisks.substring(i + 1);
                    }
                }
                lblWord.setText(asterisks);
                if (asterisks.indexOf('*') < 0) {
                    JOptionPane.showMessageDialog(this, "Congratulations, you won!");
                    newGame();
                }
            } else {
                guessesLeft--;
                lblGuessesLeft.setText("Guesses left: " + guessesLeft);
                guesses += guess + " ";
                lblGuesses.setText("Guesses: " + guesses);
                if (guessesLeft == 0) {
                    JOptionPane.showMessageDialog(this, "Sorry, you lost. The word was: " + word);
                    newGame();
                }
            }
        }
    }

    private void newGame() {
        word = words[(int) (Math.random() * words.length)];
        asterisks = new String(new char[word.length()]).replace('\0', '*');
        lblWord.setText(asterisks);
        guessesLeft = 6;
        lblGuessesLeft.setText("Guesses left: " + guessesLeft);
        guesses = "";
        lblGuesses.setText("Guesses: " + guesses);
    }

        
}
