package Controler;

import Model.GameState;
import View.Screen;

import java.awt.*;
import java.util.ArrayList;

/**
 * Controler.Game Controller for the mvc
 */
public class Game {
    GameState state;
    Screen screen ;

    /**
     * Central Controler.Game
     */
    public Game(){
        initGame();
        screen = new Screen(this);
    }

    public void initGame() {
        // TODO: 01/12/16 overloaded methods for the start game with default parameters
        initGame(10,10,10);
    }

    public void initGame(int nbLine, int nbColonne, int nbMines)
    {
        this.state = new GameState(nbLine,nbColonne,nbMines);
    }
    public void startGame(){
        state.setState(GameState.STARTEDSTATE);
        // TODO: 28/12/16 complete startGame With necesarry methods
    }
    //interface methods
    /**
     * Called by the case buttons
     * @param position position of the case
     * @param clickType button of the mouse
     */
    public void BoardClicked(Point position,int clickType)
    {
        if(clickType ==1) {
            ArrayList<Point> squares = state.revealSquare(position);
            screen.updateSquares(squares);
        }
        else if(clickType == 2)
        {
            state.flagSquare(position);
            screen.updateSquare(position);
        }
    }
    public void GameOver()
    {
        screen.showEndGame();
        state.gameOver();
    }

    public GameState getState() {
        return state;
    }

}
