package Main;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
        final int originaltilesize = 16;
        final int scale = 3;

        final int tilesize = scale * originaltilesize; // 3 * 16 = 48
        final int maxScreenCol = 14;
        final int maxScreenRow = 17;
        final int screenWidth = maxScreenCol * tilesize; // 3 * 16 * 12 = 576
        final int screenHeight  = maxScreenRow * tilesize; // 3 * 16 * 16 = 768

        MouseHandler mouse1 = new MouseHandler();

        Thread gameThread;

        int FPS = 60;

        int golfX = 7 * tilesize;
        int golfY = 14 * tilesize ;
        int speed;
        int maxspeed = 10;
        int decrease = 1;

        public GamePanel(){
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(Color.GRAY);
                this.setDoubleBuffered(true);
                this.addMouseListener(mouse1);
        }

        public void StartGameThread(){
                gameThread = new Thread(this);
                gameThread.start();
        }

        @Override
        public void run() {

                while(true){
                        update();

                        repaint();

                        try {
                                Thread.sleep(10);
                        }
                        catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                }
        }

        public void update(){
                if (mouse1.aimed){

                }
        }
        public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillOval(golfX, golfY, tilesize, tilesize);
                g2.dispose();
        }
}
