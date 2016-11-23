import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Board b = new Board(10,10,5);
        System.out.print(Arrays.deepToString(b.board));
    }
}