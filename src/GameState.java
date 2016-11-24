/**
 * Game Model centraliser
 */
public class GameState {
    private Board board;
    private Player player;
    private Long timer;
    public GameState(int nbLine,int nbColumn, int nbMines){
        board = new Board(nbLine,nbColumn,nbMines);
        player = new Player();
        timer = 0L;

    }

    public void gameOver() {
        savePlayerScore();
    }

    private void savePlayerScore() {
        //// TODO: 24/11/16 Save Player Score Method
    }
}
