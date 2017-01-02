package Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Controler.Game Model centraliser
 */
public class GameState {
    private Board board;
    private Player player;
    private Long timer;
    // State int value describe gameState
    // 0 - setted up
    // 1 - Started
    // 2 - Won
    // 3 - Lost
    private int state;
    public static int INITIALSTATE = 0;
    public static int STARTEDSTATE = 1;
    public static int WONSTATE = 2;
    public static int LOSTSTATE = 3;

    public GameState(int nbLine,int nbColumn, int nbMines){
        board = new Board(nbLine,nbColumn,nbMines);
        player = new Player();
        timer = 0L;
        this.state =INITIALSTATE;

    }

    public void gameOver() {
        savePlayerScore();
    }

    private void savePlayerScore() {
        //// TODO: 24/11/16 Save Model.Player Score Method
    }

    public ArrayList<Point> revealSquare(Point position) {
        Square square = board.getSquare(position);
        ArrayList<Point> reavealed = new ArrayList<Point>();
        if(square.getContent()== -1)
        {
            return null;
        }
        else {
            square.reaveal();
            if (square.getContent() == 0) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        Point target = new Point(((int) position.getX()) + x, ((int) position.getY()) + y);
                        if(board.getSquare(target)!=null){
                        if (!(y == 0 && x == 0) && !board.getSquare(target).isReavealed() && (board.getSquare(target).getContent() != -1))
                        {
                            ArrayList<Point> otherRevealed = revealSquare(target);
                            reavealed.addAll(otherRevealed);
                        }
                        }
                    }
                }
            }
            return reavealed;
        }
    }

    public void flagSquare(Point position) {
        board.getSquare(position).switchFlag();
    }

    public Board getBoard() {
        return board;
    }

    public void setState(int state) {
        this.state = state;
    }
}
