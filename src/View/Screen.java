package View;

import Controler.Game;
import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

/**
 * windows of the game
 */
public class Screen extends JFrame implements WindowStateListener{
    private GridBagLayout layout;
    private Game game;
    private JPanel sideContainer;
    private JPanel mainContainer;
    private JPanel currentSide;
    private BoardDisplay grid ;
    private JPanel currentMain;

    public Screen(Game game){
        //variable setup
        this.game = game;

        //JFrame setUp opperations
        setTitle("DeminIt");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        layout = new GridBagLayout();
        setLayout(layout);

        //debug
        getContentPane().setBackground(Color.green);
        //debug
        // constraints
        GridBagConstraints constraints;
        //main container is the central display, it contains the central piece, it is of use for layout purposes
        mainContainer = new JPanel();
        // side container is the side display, it contains the side panels, menus and such
        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.fill= GridBagConstraints.BOTH;
        layout.addLayoutComponent(mainContainer,constraints);
        add(mainContainer);

        sideContainer = new JPanel();
        // side container set up
        constraints = new GridBagConstraints();
        sideContainer.setLayout(new BorderLayout());
        constraints.weightx = 0.25;
        constraints.weighty = 1;
        constraints.gridx= 0;
        constraints.fill= GridBagConstraints.BOTH;
        layout.addLayoutComponent(sideContainer,constraints);
        add(sideContainer);

        // initial menu setup
        toMenu();
        //initial Board Creation
        setUpBoard();

        setSize(400,400);
        addWindowStateListener(this);
    }

    private void setUpBoard() {

            System.out.println("debug marker");
            grid = new BoardDisplay(game.getState().getBoard());

        GridBagLayout layout = new GridBagLayout();
        mainContainer.setLayout(layout);
        mainContainer.removeAll();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(grid,constraints);

        mainContainer.add(grid);

    }

    private boolean toMenu() {
        currentSide = new menuDisplay().getMain();

        sideContainer.add(currentSide,BorderLayout.CENTER);

        //debug
        sideContainer.setBackground(Color.blue);
        currentSide.setBackground(Color.black);
        //debug!
        ajustSide();

        return false;
    }

    private void ajustSide() {
        int width = sideContainer.getParent().getWidth();
        sideContainer.setSize(width/4,sideContainer.getParent().getHeight());
        mainContainer.setSize(width,mainContainer.getHeight());
    }

    public void showEndGame() {
        // TODO: 24/11/16 Show End Controler.Game Method
    }

    public void updateSquares(ArrayList<Point> squares) {
        // TODO: 01/12/16 update Squares Method
    }

    public void updateSquare(Point position) {
        // TODO: 01/12/16 update square method
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        if(grid != null)
        {
            grid.updateSizeNeeded();
        }

    }

    // TODO: 24/11/16 Faire la class

}
