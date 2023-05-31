package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private JButton playAgainButton;
    private JLabel resultLabel;
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Mini golf game");
        window.setResizable(false);

        JButton playAgainButton = new JButton("Play Again");

        GamePanel gamePanel1 = new GamePanel();

        window.add(gamePanel1);

        window.add(playAgainButton, BorderLayout.NORTH);

        window.pack();

        window.setVisible(true);

        gamePanel1.StartGameThread();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgainButton) {
            // Reset the game or start a new game
            resultLabel.setText("New Game Started");
        }
    }
}