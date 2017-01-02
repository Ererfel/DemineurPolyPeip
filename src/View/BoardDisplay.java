package View;

import Model.Board;
import Model.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
// TODO: 24/12/16 relier les boutons au fonction traitant les clicks
/**
 * Created by user on 02/12/16.
 */
public class BoardDisplay extends JPanel implements ComponentListener{
    ArrayList<SquareDisplay> displaysGrid;
    Board board;
    GridBagLayout layout;
    private Screen screen;
    private static int GRIDDIMENTION = 10;
    private int lastHeight;
    private int lastWidth;
    // size of the space between the squares
    private int interSquareSpace;
    Insets gridInsets;
    private boolean needSizeUpdate = false;

    BoardDisplay(Board board) {
        this.board = board;
        layout = new GridBagLayout();
        setLayout(layout);
        this.setBackground(Color.gray);
        setUpGrid(board.getGrid());
        addComponentListener(this);
    }
    private void setUpGrid(Square[][] grid){
        displaysGrid = new ArrayList<>();
        GridBagConstraints constraints;
        System.out.println("BoardDisplay.setUpGrid");
        int j = 0;
        gridInsets = new Insets(5,5,5,5);
        for(Square[] line: grid){
            int i =0;
            for(Square square : line){
                SquareDisplay squareDisplay = new SquareDisplay(square);
                constraints = new GridBagConstraints();
                constraints.weighty = 1.0;
                constraints.weightx = 1.0;
                // margins of the tiles within the grid
                constraints.insets = gridInsets;
                //debug

                if(square!=null) {
                    Point position = square.getPosition();
                    constraints.gridy = position.y;
                    constraints.gridx = position.x;
                }
                else{
                    constraints.gridx = i;
                    constraints.gridy = j;
                }

                String text = String.valueOf(constraints.gridx);
                text +=":";
                text += String.valueOf(constraints.gridy);
                squareDisplay.setText(text);

                layout.addLayoutComponent(squareDisplay, constraints);
                displaysGrid.add(squareDisplay);
                squareDisplay.addMouseListener(new SquareClickListener(this));
                add(squareDisplay);

                i++;
            }
            j++;
        }
    }
     void updateGridSizes(){

         System.out.println("BoardDisplay.updateGridSizes");
        int horizontalBorder = (int) (getWidth()*0.05);
        int verticalBorder = (int) (getHeight()*0.05);
        setBorder(BorderFactory.createEmptyBorder(0,0,verticalBorder,horizontalBorder));
        setBorder(BorderFactory.createEmptyBorder(verticalBorder,horizontalBorder,verticalBorder,horizontalBorder));

        Dimension dim;
        int adjustedWidth;
        int adjustedHeight;
        int width = getWidth()-horizontalBorder*2;
        int height = getHeight() -verticalBorder*2;

        if(board!=null) {
            System.out.println("adjusting size from board");
            adjustedWidth = (width-(board.getAmountOfColumn()+1)*interSquareSpace) / board.getAmountOfColumn();
            adjustedHeight = (height-(board.getAmountOfLine()+1)*interSquareSpace)/ board.getAmountOfLine();
        }
        else {
            adjustedWidth = (width-(GRIDDIMENTION+1)*5)/ (GRIDDIMENTION);
            adjustedHeight = (height-(GRIDDIMENTION+1)*5)/ (GRIDDIMENTION);
        }

        for(SquareDisplay display:displaysGrid){
            //gridInsets.set(adjustedHeight/10,adjustedHeight/10,adjustedHeight/10,adjustedHeight/10);
            dim = new Dimension(adjustedWidth, adjustedHeight);

            display.setSize(dim);

        }

    }
    /**
     * this method is needed to plan for a size change,
     * it stores the actual size of the window for th component paint method to know when the actual size has changed and
     * component resized has not been called
     *
     */
    public void updateSizeNeeded() {
        lastHeight = getHeight();
        lastWidth = getWidth();
        needSizeUpdate = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(needSizeUpdate)
        {
            if(lastHeight != getHeight() || lastWidth != getWidth())
            {
                updateGridSizes();
            }
            lastWidth = getWidth();
            lastHeight = getHeight();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
    @Override
    public void updateUI() {
        super.updateUI();
        System.out.println("debug marker");
    }
    @Override
    public void componentResized(ComponentEvent e) {
        updateGridSizes();

    }
    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("component moved");
    }
    @Override
    public void componentShown(ComponentEvent e)
    {
        System.out.println("BoardDisplay.componentShown");
    }
    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("BoardDisplay.componentHidden");
    }

    public void buttonClicked(SquareDisplay source) {

    }

    /*

*/
}
