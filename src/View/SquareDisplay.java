package View;

import Model.Square;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

/**
 * Created by user on 07/12/16.
 */
public class SquareDisplay extends JButton{
    private Square square;
    public SquareDisplay(Square square) {
        this.square = square;
        this.setBackground(Color.BLACK);
    }


    public Square getSquare() {
        return square;
    }

    public void update() {
        if(square.isReavealed())
        {
            setBackground(Color.LIGHT_GRAY);

            if(square.getContent()==-1)
            {setText("M");
                setBackground(Color.red);
            }
            else if(square.getContent()!=0){
                setText(String.valueOf(square.getContent()));
            }
        }
    }
}
