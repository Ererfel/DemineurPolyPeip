package Model;
import java.io.*;
import java.util.Arrays;


public class Save {
    int[][] scoreList;
    String level;
    int result;
    Player player;
    public Save(String lvl, int results, Player player){
        this.scoreList = getLastScore();
        this.level = lvl;
        this.result = results;
        this.player = player;
        bestScore(this.level, this.result);
    }

    public int[][] getLastScore(){
        String fichier = "fichiertexte.txt";
        int[][] list = new int[4][5];

        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            int score;
            br.readLine();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++){
                ligne = br.readLine();
                score = Integer.parseInt(ligne);
                System.out.print(score + "--");
                list[i][j] = score;
            }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    public void bestScore(String level, int score){
        switch (level) {
            case "default":
                insertScore(0,score);
                break;
            case "medium":
                insertScore(1,score);
                break;
            case "hard":
                insertScore(2,score);
                break;
            case "personalised":
                insertScore(3,score);
                break;
        }
    }

    public void insertScore(int l, int sco){
        if(this.scoreList[l][0]<sco){
            this.scoreList[l][0]=sco;
            Arrays.sort(this.scoreList[l]);
        }
    }

    public void debogScoreList(){
        System.out.println("");
        for(int i = 0; i<4 ;i++){
            for(int j = 0; j<5 ;j++){
                System.out.print(this.scoreList[i][j]+"--");
            }
        }
    }

}