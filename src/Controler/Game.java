package Controler;

import Model.GameState;
import Model.Square;
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
        initGame(8,8,10);
    }

    public void initGame(int nbLine, int nbColonne, int nbMines)
    {
        this.state = new GameState(nbLine,nbColonne,nbMines);
    }
    public void startGame(){

        state.startGame();

    }
    //interface methods
    /**
     * Called by the case buttons
     * @param position position of the case
     * @param clickType button of the mouse
     */
    public void BoardClicked(Point position,int clickType)
    {
        if(!state.isStarted()){
            startGame();
            screen.gameMenu();
        }
        if(clickType ==1) {
            ArrayList<Square> squares = state.revealSquare(position);
            if(squares != null) {
                screen.updateSquares(squares);
            }
            else{
                screen.updateSquare(state.getBoard().getSquare(position));
                state.lose();
                GameOver();
            }
        }
        else if(clickType == 2)
        {

            state.flagSquare(position);
            screen.updateSquare(state.getBoard().getSquare(position));
        }
        if(state.isWon()){
            GameOver();
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

    public Screen getScreen() {
        return screen;
    }

    public String getReadableTime() {
        long time =state.getTime();
        String readable = String.format("%d:%02d", time/60, time%60);

        return readable;
    }

    public void newSettings(int[] settings) {
        initGame(settings[1],settings[0],settings[2]);
        screen.setUpBoard();
    }
}
