package View;

import Controler.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * windows of the game
 */
public class Screen extends JFrame{
    private GridBagLayout layout;
    private Game game;
    private JPanel sideContainer;
    private JPanel mainContainer;
    private JPanel currentSide;
    private JPanel grid ;
    private JPanel currentMain;


    public Screen(Game game){
        setTitle("DeminIt");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        layout = new GridBagLayout();

        setLayout(layout);
        //debug
        getContentPane().setBackground(Color.green);
        //debug
        mainContainer = new JPanel();
        sideContainer = new JPanel();

        sideContainer.setLayout(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.25;
        constraints.weighty = 1;
        constraints.fill= GridBagConstraints.BOTH;
        layout.addLayoutComponent(sideContainer,constraints);
        add(sideContainer);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill= GridBagConstraints.BOTH;
        layout.addLayoutComponent(mainContainer,constraints);
        add(mainContainer);
        this.game = game;
        setUpBoard();
        toMenu();

        setSize(400,400);
    }

    private void setUpBoard() {

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
    // TODO: 24/11/16 Faire le classe
}
