package Main;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
        final int originaltilesize = 16;
        final int scale = 3;

        final int tilesize = scale * originaltilesize;
        final int maxScreenCol = 12;
        final int maxScreenRow = 16;
        final int screenWidth = maxScreenCol * tilesize;
        final int screenHeight  = maxScreenRow * tilesize;

        Thread gameThread;

        public GamePanel(){
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(Color.WHITE);
                this.setDoubleBuffered(true);
        }

        public void StartGameThread(){
                gameThread = new Thread(this);
                gameThread.start();
        }

        @Override
        public void run() {

                while(gameThread != null){
                        update();

                        repaint();
                }
        }

        public void update(){

        }
        public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
        }
}
