package View;

import Model.Square;

import javax.swing.*;

/**
 * Created by user on 07/12/16.
 */
public class SquareDisplay extends JButton{
    private Square square;
    public SquareDisplay(Square square) {
        this.square = square;
    }
}
