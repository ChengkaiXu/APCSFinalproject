package Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    public boolean aimed = false;
    public int ReleasedX;
    public int ReleasedY;
    public int AimingX;
    public int AimingY;
    public boolean aiming = false;
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

//        System.out.println("X" + AimingX);
//        System.out.println(AimingY);
        aiming = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ReleasedX = e.getX();
        ReleasedY = e.getY();
        aimed = true;
        aiming = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        AimingX = e.getX();
        AimingY = e.getY();
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
