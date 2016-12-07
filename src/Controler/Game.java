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
        screen = new Screen(this);
    }

    public void startGame() {
        // TODO: 01/12/16 overloaded methods for the start game with default parameters
        startGame(10,10,10);
    }

    public void startGame(int nbLine, int nbColonne, int nbMines)
    {
        this.state = new GameState(nbLine,nbColonne,nbMines);
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
