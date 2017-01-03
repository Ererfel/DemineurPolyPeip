package Model;
import java.io.*;
import java.util.Arrays;


public class Save {
    int[][] scoreList;
    String level;
    int result;
    Player player;
    public Save(){

    }
    public Save(String lvl, int results, Player player){
        this.scoreList = getLastScore();
        this.level = lvl;
        this.result = results;
        this.player = player;
        bestScore(this.level, this.result);
        writeScore();
    }

    public int[][] getLastScore(){
        String fichier = "save.txt";
        int[][] list = new int[4][10];

        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            int score;
            br.readLine();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++){
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
            for(int j = 0; j<10 ;j++){
                System.out.print(this.scoreList[i][j]+"--");
            }
        }
    }
    public void writeScore(){
        String fichier = "fichiertexte.txt";
        try {
            FileWriter fw = new FileWriter (fichier);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter fichierSortie = new PrintWriter (bw);
            fichierSortie.println ("Tableau des scores.");
            for(int i = 0; i<4;i++){
                for(int j = 0; j<10;j++) {
                    fichierSortie.println(scoreList[i][j]);
                }
                }
            fichierSortie.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    }
