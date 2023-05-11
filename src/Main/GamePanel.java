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
                double drawInterval = 1000000000 / FPS;
                double nextDraw = System.nanoTime() + drawInterval;
                while(gameThread != null){
                        update();

                        repaint();

                        try {
                                double remainingTime = nextDraw - System.nanoTime();
                                remainingTime = remainingTime / 1000000;

                                if (remainingTime < 0){
                                        remainingTime = 0;
                                }
                                Thread.sleep((long) drawInterval);
                                nextDraw += drawInterval;
                        }
                        catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }

        public void update(){
                golfX += 1;
                golfY -= 1;
                System.out.println("working");
        }
        public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillOval(golfX, golfY, tilesize, tilesize);
                g2.dispose();
                System.out.println("work");
        }
}
