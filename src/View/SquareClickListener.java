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
        System.out.println("SquareClickListener.mouseReleased");
        System.out.println(SwingUtilities.isLeftMouseButton(e));
        boardDisplay.buttonClicked(((SquareDisplay) e.getSource()));
        boardDisplay.gridInsets.set(100,100,100,100);
        System.out.println("inset reglé");
        System.out.println(((GridBagLayout)((SquareDisplay) e.getSource()).getParent().getLayout()).getConstraints(((SquareDisplay) e.getSource())).insets);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
