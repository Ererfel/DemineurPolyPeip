import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int t=0;
        int tab[][] = new int[10][10];
        for (int i = 0; i <10 ; i++){
            for (int j = 0; j<10 ; j++){
                tab[i][j]=t;
                t++;
            }
        }
        System.out.print(Arrays.deepToString(tab));
    }
}