package Model;

import java.awt.*;

/**
 *  content : -1= mine,0...8 nombre de mine
 *  state : 0 = revealed, 1 = hidden, 2 = flagued
 */
public class Square {
    int content;
    int state;
    private Point position;


    public Square(int content,Point position) {
        this.content = content;
        this.state = 1;
        this.position = position;
    }


    public int getContent() {
        return content;
    }

    public void setContent(int content) {

        this.content = content;
    }

    public void reaveal() {
        state = 0;
    }

    public boolean isReavealed() {
        return state==0;
    }

    public boolean switchFlag() {
        if(state==1){
            state=2;

        }
        else if(state==2)
        {
            state = 1;

        }
        else
        {
            return false;
        }
        return true;
    }

    public Point getPosition() {
        return position;
    }
}


