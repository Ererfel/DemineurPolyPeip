package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controler.Game Model centraliser
 */
public class GameState {
    private Board board;
    private Player player;
    private Long time;
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
        player = new Player("default");
        time = 0L;
        this.state =INITIALSTATE;

    }

    public void gameOver() {
        if (state != LOSTSTATE) {
            savePlayerScore();
        }
    }

    private void savePlayerScore() {
        int score = time.intValue()/1000;
        if (board.getDifficultyLevel()!="personalised"){
        Save r = new Save(board.getDifficultyLevel(), score, player);}
        else {
            score = score*board.getAmountOfColumn()*board.getAmountOfLine()*board.getAmountOfMine()/1000;
            Save r = new Save(board.getDifficultyLevel(),score, player);
        }
    }




    public ArrayList<Square> revealSquare(Point position) {
        Square square = board.getSquare(position);
        ArrayList<Square> reavealed = new ArrayList<>();

        square.reaveal();
        board.setAmountOfReavealedSquare(board.getAmountOfReavealedSquare()+1);
        if(board.getAmountOfReavealedSquare()==(board.getAmountOfLine()*board.getAmountOfColumn())-board.getAmountOfMine())
        {
          win();

        }
        if(square.getContent()== -1)
        {
            return null;
        }
        else {
            reavealed.add(square);
            if (square.getContent() == 0) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        Point target = new Point(((int) position.getX()) + x, ((int) position.getY()) + y);
                        if(board.getSquare(target)!=null){
                        if (!(y == 0 && x == 0) && !board.getSquare(target).isReavealed()
                                && (board.getSquare(target).getContent() != -1))
                        {
                            ArrayList<Square> otherRevealed = revealSquare(target);
                            reavealed.addAll(otherRevealed);
                        }
                        }
                    }
                }
            }
            return reavealed;
        }
    }

    private void win() {
        state = WONSTATE;

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

    public void startGame(){
        state = STARTEDSTATE;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
                System.out.println(time);
            }
        },1000,1000);

    }
    public void lose() {
        this.state = LOSTSTATE;
    }

    public Long getTime() {
        return time;
    }

    public boolean isStarted() {
        return state == STARTEDSTATE;
    }

    public int getState() {
        return state;
    }

    public boolean isWon() {
        return state == WONSTATE;
    }

    public int[][] getScores() {
        Save save = new Save();

        return save.getLastScore();
    }
}
