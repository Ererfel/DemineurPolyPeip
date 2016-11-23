import java.util.ArrayList;

public class Board {
    int amountOfMine;
    int amountOfSquare;
    int amountOfLine;
    int amountOfColumn;
    int amountOfReavealedSquare;
    int amountOfSafeUnreavealedSquare;
    Square[][] board;

    public Board(int line, int column, int xMine){
        this.amountOfLine = line;
        this.amountOfColumn = column;
        this.amountOfSquare = calculateAmountOfSquare(this.amountOfLine, this.amountOfColumn);
        this.amountOfMine = xMine;
        this.board = new Square[amountOfLine][amountOfColumn];
        generateSquare();
    }

    public int getAmountOfLine() {
        return amountOfLine;
    }

    public int getAmountOfColumn() {
        return amountOfColumn;
    }

    public ArrayList generateXNumbers(int xMine, int xSquare){ //Pour générer une liste de X nombres correspondants au numéro de case où il y aura une mine.
        ArrayList listNumber = new ArrayList();
        for(int i = 1; i <= xMine; i++){
            int nombreAleatoire = (int)(Math.random() * (xSquare + 1)); // A reverifier : la range xSquare +1 ou pas
            while (listNumber.contains(nombreAleatoire)){
                nombreAleatoire = (int)(Math.random() * (xSquare + 1));
            }
            listNumber.add(nombreAleatoire);

        }
        return listNumber;
    }


    public void generateSquare(){
        ArrayList listMinedSquare = generateXNumbers(this.amountOfMine, this.amountOfSquare);
        int t=0;
        for (int i = 0; i < this.amountOfSquare/this.amountOfLine; i ++){
            for (int j = 0; j < this.amountOfSquare/this.amountOfColumn; j ++){
                if (listMinedSquare.contains(t)){
                    Square square = new Square(-1);
                    this.board[i][j]=square;}
                else {
                    Square square = new Square(0);
                    this.board[i][j]=square;}
            }
        }
        for (int i = 0; i < this.amountOfSquare/this.amountOfLine; i ++) {
            for (int j = 0; j < this.amountOfSquare / this.amountOfColumn; j++) {
                this.board[i - 1][j - 1].setContent(CalculateAmountMinesAround(this.board, i, j));
            }
        }

    }

    public int calculateAmountOfSquare(int line, int column){
        int result = line*column;
        return result;
    }


    public int CalculateAmountMinesAround(Square[][] board, int i, int j) {
        int n = 0;
        if(this.board[i][j].getContent()==-1) {return -1;}
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
}


