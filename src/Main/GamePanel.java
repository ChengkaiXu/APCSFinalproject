package Main;
import Objects.Goal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;

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

        int golfX = 7 * tilesize;
        int golfY = 14 * tilesize;
        int velocityX;
        int framecount = 0;
        int velocityY;
        int decrease = 1;
        boolean moving = false;
        boolean line = false;
        public boolean win = false;
        public Goal goal = new Goal();
        public int changeX;
        public int changeY;

        public GamePanel(){
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(new Color(44, 158, 73));
                this.setDoubleBuffered(true);
                this.addMouseListener(mouse1);
                this.addMouseMotionListener(mouse1);
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

                        framecount++;
                        if (framecount % 120 == 0) {
                                takeoutV();
                        }

                        try {
                                Thread.sleep(16);
                        }
                        catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                }
        }

        public void update(){
                if (mouse1.aimed && !moving){
                        move();
                        mouse1.aimed = false;
                }
                if (velocityX != 0 && velocityY != 0) {
                        checkBounce();
                        golfX += velocityX;
                        golfY += velocityY;
                }
                else if (velocityY != 0 && line){
                        checkBounce();
                        golfY += velocityY;
                }
                else if (velocityX != 0 && line){
                        checkBounce();
                        golfX += velocityX;
                }
                else if (velocityX == 0 && velocityY == 0){
                        moving = false;
                        line = false;
                }
        }
        public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.white);
                checkwin();
                if (!win) {
                        if (mouse1.aiming) {
                                determine();
                                g2.drawLine(golfX + originaltilesize / 2, golfY + originaltilesize / 2,
                                        golfX + originaltilesize / 2 + changeX,
                                        golfY + (originaltilesize / 2) + changeY);
                        }
                        g2.fillOval(golfX, golfY, originaltilesize, originaltilesize);
                }
                g2.setColor(Color.black);
                g2.fillOval(goal.getXcoordinate(), goal.getYcoordinate(), originaltilesize * 2, originaltilesize *2);
                g2.dispose();
        }
        public void move(){
                System.out.println(mouse1.ReleasedX);
                System.out.println(mouse1.ReleasedY);
                velocityX = (golfX - mouse1.ReleasedX) / 50;
                velocityY = (golfY - mouse1.ReleasedY) / 50;
                if (velocityY > 8){
                        velocityY = 8;
                }
                else if (velocityY < -8){
                        velocityY = -8;
                }
                if (velocityX > 8){
                        velocityX = 8;
                }
                else if (velocityX < -8){
                        velocityX = -8;
                }
                if (velocityY == 0 || velocityX == 0){
                        line = true;
                }
                System.out.println("Vx" + velocityX + "Vy:" + velocityY);
                moving = true;
        }
        public void checkBounce(){
                if (golfY <= 0){
                        velocityY = -velocityY;
                        takeoutV();
                }
                if (golfY + originaltilesize >= screenHeight){
                        velocityY = -velocityY;
                        takeoutV();
                }
                if (golfX <= 0){
                        velocityX = -velocityX;
                        takeoutV();
                }
                if (golfX + originaltilesize / 2>= screenWidth){
                        velocityX = -velocityX;
                        takeoutV();
                }
        }
        public void takeoutV(){
                if (velocityX > 0){
                        velocityX--;
                } else if (velocityX < 0) {
                        velocityX++;
                }
                if (velocityY > 0){
                        velocityY--;
                } else if (velocityY < 0) {
                        velocityY++;
                }
        }
        public void checkwin(){
                if (golfX + originaltilesize / 2 < goal.getXcoordinate() + originaltilesize * 2 && golfX + originaltilesize / 2 > goal.getXcoordinate()
                && golfY + originaltilesize / 2 < goal.getYcoordinate() + originaltilesize && golfY + originaltilesize / 2 > goal.getYcoordinate()){
                        win = true;
                }
        }
        public void determine(){
                changeX = (golfX - mouse1.AimingX) / 10;
                changeY = (golfY - mouse1.AimingY) / 10;
                if (changeY > 50){
                        changeY = 50;
                }
                else if (changeY < -50){
                        changeY = -50;
                }
                if (changeX > 50){
                        changeX = 50;
                }
                else if (changeX < -50){
                        changeX = -50;
                }
//                System.out.println("Change" + changeX);
//                System.out.println(changeY);
        }
}
