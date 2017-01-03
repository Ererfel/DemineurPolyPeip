package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 03/01/17.
 */
public class ScoreDisplay {

    private JLabel Scores;
    private JPanel main;
    private JPanel easyScoreGrid;
    private JPanel normalScoreGrid;
    private JPanel hardScoreGrid;
    private JPanel customScoreGrid;
    private JLabel[] easyScoreList;
    private JLabel[] normalScoreList;
    private JLabel[] hardScoreList;
    private JLabel[] customScoreList;
    public ScoreDisplay(int[][] scores){
        easyScoreList = new JLabel[10];
        normalScoreList = new JLabel[10];
        hardScoreList= new JLabel[10];
        customScoreList= new JLabel[10];
        initiateLists();
        updateLists(scores);
    }
    void initiateLists()
    {
        initList(easyScoreList,easyScoreGrid);
        initList(normalScoreList,normalScoreGrid);
        initList(hardScoreList,hardScoreGrid);
        initList(customScoreList,customScoreGrid);
    }
    private void initList(JLabel[] list,JPanel grid){
        int i = 0 ;
        GridBagConstraints constraints;
        GridBagLayout layout = (GridBagLayout) grid.getLayout();
        while(i<10) {
            constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = i;
            constraints.fill = GridBagConstraints.BOTH;
            list[i] = new JLabel();
            list[i].setForeground(Color.WHITE);
            layout.addLayoutComponent(list[i], constraints);
            grid.add(list[i]);

            constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = i;
            constraints.fill = GridBagConstraints.BOTH;
            JLabel num = new JLabel(String.valueOf(i+1));
            num.setForeground(Color.white);
            num.setBackground(Color.BLACK);
            layout.addLayoutComponent(num,constraints);
            grid.add(num);
            i++;
        }
    }


    private void updateLists(int[][]scores){
        if(scores.length == 4){
            updateList(scores[0],easyScoreList);
            updateList(scores[1],normalScoreList);
            updateList(scores[2],hardScoreList);
            updateList(scores[3],customScoreList);
        }
    }
    private void updateList(int[] scores,JLabel[] list)
    {
        if(scores.length == 10)
        {
            int i = 0 ;
            while(i<10){
                list[i].setText(String.valueOf(scores[9-i]));
                i++;
            }
        }
    }
    public JPanel getMain() {

        return main;

    }

}
