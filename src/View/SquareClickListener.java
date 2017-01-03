package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by user on 02/01/17.
 */
public class SquareClickListener implements MouseListener {
private BoardDisplay boardDisplay;

    public SquareClickListener(BoardDisplay boardDisplay) {
        this.boardDisplay = boardDisplay;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        boardDisplay.getScreen().getGame().BoardClicked((((SquareDisplay) e.getSource())).getSquare().getPosition(),clickType(e));

    }

    private int clickType(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            return 1;
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            return 2;
        }
        return 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
