package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by user on 03/01/17.
 */
public class MenuButtonListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        Screen.mainScreen.toMenu();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
