package View;

import Controler.Game;
import Model.Square;

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
    public  static Screen mainScreen;
    public Screen(Game game){
        //variable setup
        this.game = game;
        mainScreen = this;

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
        setUpBoard();
        toMenu();
        //initial Board Creation

        setSize(500,500);
        addWindowStateListener(this);
    }

    public void setUpBoard()
    {

        grid = new BoardDisplay(game.getState().getBoard(), this);
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

    void toMenu() {
        sideContainer.removeAll();
        currentSide = new menuDisplay(this).getMain();

        sideContainer.add(currentSide,BorderLayout.CENTER);

        //debug

        currentSide.setBackground(Color.black);
        //debug!
        revalidate();
    }

    public void gameMenu(){
        if(!game.getState().isStarted()){
            game.startGame();
        }
        sideContainer.removeAll();
        GameMenu menu = new GameMenu(this);
        currentSide = menu.getMain();
        sideContainer.add(currentSide, BorderLayout.CENTER);
        revalidate();
    }
    public void showEndGame() {


        sideContainer.removeAll();
        if(game.getState().isWon())
        {
            // TODO: 03/01/17 win menu
        }
        else{
            currentSide = new LostMenu(this);
        }

        sideContainer.add(currentSide);

    }

    public void updateSquares(ArrayList<Square> squares) {
        for (Square square :  squares){
            updateSquare(square);
        }
    }

    public void updateSquare(Square square) {
        grid.updateSquare(square);
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        if(grid != null)
        {
            grid.updateSizeNeeded();
        }

    }

    public Game getGame() {
        return game;
    }

    public String getTime() {
        return game.getReadableTime();
    }


    public void toSettings() {
        currentMain = new MenuSettings().getMain();
        mainContainer.removeAll();
        mainContainer.add(currentMain);
        mainContainer.revalidate();
    }

    public void toScores() {
        currentMain = new ScoreDisplay(game.getState().getScores()).getMain();
        mainContainer.removeAll();
        mainContainer.add(currentMain);
        mainContainer.revalidate();
    }
}
