package Main;
import javax.swing.*;

public class GamePanel extends JPanel{
        final int originaltilesize = 16;
        final int scale = 3;

        final int tilesize = scale * originaltilesize;
        final int maxScreenCol = 16;
        final int maxScreenRow = 12;
        final int screenWidth = maxScreenCol * tilesize;
        final int screenHeight  = maxScreenRow * tilesize;


        public GamePanel(){

        }
}
