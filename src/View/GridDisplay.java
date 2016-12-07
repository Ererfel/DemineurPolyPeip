package View;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by user on 02/12/16.
 */
public class GridDisplay extends JPanel{
    ArrayList<SquareDisplay> grid ;

    public GridDisplay(ArrayList<SquareDisplay> grid) {
        this.grid = grid;
    }
}
