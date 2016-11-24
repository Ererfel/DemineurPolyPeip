import java.awt.*;

/**
 * Game Controller for the mvc
 */
public class Game {
    GameState state;
    Screen screen ;

    /**
     * Central Game
     */
    public Game(){
        screen = new Screen();
    }

    /**
     * Called by the case buttons
     * @param position position of the case
     * @param clickType button of the mouse
     */
    public void BoardClicked(Point position,int clickType)
    {

    }
    public void GameOver()
    {
        screen.showEndGame();
        state.gameOver();
    }

}
