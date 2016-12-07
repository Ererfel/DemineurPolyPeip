package Model;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    int amountOfMine;
    int amountOfSquare;
    int amountOfLine;
    int amountOfColumn;
    int amountOfReavealedSquare;
    int amountOfSafeUnreavealedSquare;
    Square[][] board;   //Notre tableau contenant les Squares (cases )

    public Board(int line, int column, int xMine){
        this.amountOfLine = line;
        this.amountOfColumn = column;
        this.amountOfSquare = calculateAmountOfSquare(this.amountOfLine, this.amountOfColumn);
        this.amountOfMine = xMine;
        this.board = new Square[this.amountOfLine][this.amountOfColumn];
        generateSquare();
    }

    public int getAmountOfLine() {
        return amountOfLine;
    }

    public int getAmountOfColumn() {
        return amountOfColumn;
    }



/* ##################################################################################################
#                                                                                                   #
#                                   Génération de la grille                                         #
#                                                                                                   #
##################################################################################################### */

//                  Calcul du nombre de total de square.
    public int calculateAmountOfSquare(int line, int column){
        int result = line*column;
        return result;
    }

//       Générateur de liste d'entiers (qui seront le numéro des cases où il y aura une mine) :
    public ArrayList generateXNumbers(int xMine, int xSquare){ //Pour générer une liste de X nombres correspondants
        ArrayList listNumber = new ArrayList(); // au numéro de case où il y aura une mine.
        for(int i = 1; i <= xMine; i++){
            int nombreAleatoire = (int)(Math.random() * (xSquare));
            while (listNumber.contains(nombreAleatoire)){
                nombreAleatoire = (int)(Math.random() * (xSquare));
            }
            listNumber.add(nombreAleatoire);

        }
        return listNumber;
    }

//                 Calcul du nombre de mine autour d'une case :
    public int CalculateAmountMinesAround(Square[][] board, int i, int j) {
        int n = 0;
        if(this.board[i][j].getContent()==-1) {return -1;} // content de Model.Square = -1 siginifie que le square contient une mine
        else {
            try{ if (this.board[i - 1][j - 1].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i - 1][j].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i - 1][j+1].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i][j-1].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i][j+11].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i+1][j-1].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i+1][j].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
            try{ if (this.board[i+1][j+1].getContent() == -1) {n++;}}
            catch(ArrayIndexOutOfBoundsException e){}
        }
        return n;
    }
//#############                 Le "gros" générateur :              ###############

    public void generateSquare(){
        generateBlankBoard();
        ArrayList listMinedSquare = generateXNumbers(this.amountOfMine, this.amountOfSquare);
        System.out.println(listMinedSquare);

        int t=0;// Le t sert à faire la conversion numéro de la case minée --> position dans la grille.
        for (int i = 0; i < this.amountOfLine; i ++){
            for (int j = 0; j < this.amountOfColumn; j ++){
                if (listMinedSquare.contains(t)){
                    placeMineHere(i,j);
                }
                t++;
            }
        }


    }

    private void placeMineHere(int i, int j) {
        try{this.board[i][j].setContent(-1);}
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(i + "  " + j);
        }
        for(int y = -1; y<2; y++){
            for(int x = -1; x<2; x++){
                try{
                    Square square = board[i+y][j+x];

                    if(square.getContent()!=-1){

                        square.setContent(square.getContent()+1);
                    }
                }catch (ArrayIndexOutOfBoundsException e){

                }
            }

        }
    }

    private void generateBlankBoard() {

        for (int i = 0; i < this.amountOfLine; i ++){
            for (int j = 0; j < this.amountOfColumn; j ++) {
                board[i][j] = new Square(0);
            }
        }

    }

/* ##################################################################################################
#                                                                                                   #
#                             Outils de débogage, visualisation                                     #
#                                                                                                   #
##################################################################################################### */


    public int[][] afficheTableau(){  //Sert à afficher une grille contenant le content de chaque square.
        int[][] table = new int[this.amountOfLine][this.amountOfColumn];
        for (int i = 0; i < this.amountOfLine; i ++) {
            for (int j = 0; j < this.amountOfColumn; j++) {
                table[i][j] = this.board[i][j].getContent();
            }
        }
        return table;
    }

    public Square getSquare(Point position) {

        try {
            return board[(int) position.getY()][(int) position.getX()];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Index out of bound");
        }
        return null;
    }
}


