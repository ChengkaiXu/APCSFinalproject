package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Mini golf game");
        window.setResizable(false);

        GamePanel gamePanel1 = new GamePanel();
        window.add(gamePanel1);

        window.pack();

        window.setVisible(true);

        gamePanel1.StartGameThread();
    }
}