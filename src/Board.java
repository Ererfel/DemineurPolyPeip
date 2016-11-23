import java.util.ArrayList;

public class Board {
    int amountOfMine;
    int amountOfSquare;
    int amountOfLine;
    int amountOfColumn;
    int amountOfReavealedSquare;
    int amountOfSafeUnreavealedSquare;
    Square[][] board;

    public void Board(int line, int column, int xMine){
        this.amountOfLine = line;
        this.amountOfColumn = column;
        this.amountOfSquare = calculateAmountOfSquare(this.amountOfLine, this.amountOfColumn);
        this.amountOfMine = xMine;
        this.board = new Square[amountOfLine][amountOfColumn];
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
    }

    public int calculateAmountOfSquare(int line, int column){
        int result = line*column;
        return result;
    }
    public int CalculateAmountMinesAround(Square[][] board, int i, int j) {
        int n=0;
        if(this.board[i][j].getContent()==-1) {return -1;}
//Si la case est une mine
        if(this.board[i][j].getContent()!=-1) {
            if (i == 0) {//##########################  Vérification bord haut
                if (j == 0) { //########################  Vérification bord gauche --> Coin haut gauche
                    if (this.board[i][j + 1].getContent() == -1) {
                        n++;
                    }
                    if (this.board[i + 1][j].getContent() == -1) {
                        n++;
                    }
                    if (this.board[i + 1][j + 1].getContent() == -1) {
                        n++;
                    }
                } else {
                    if (j == 10) {  //#####################  Vérification bord droit --> Coin haut droit
                        if (this.board[i][j - 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j - 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j].getContent() == -1) {
                            n++;
                        }
                    } else { //########################  Vérification de tout le bord haut
                        if (this.board[i][j - 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i][j + 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j - 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j + 1].getContent() == -1) {
                            n++;
                        }
                    }
                }
            } else {
                if (i == 10) {    //########################  Vérification bord bas
                    if (j == 0) {  //###########################  Vérification bord gauche --> Coin bas gauche
                        if (this.board[i - 1][j].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i - 1][j + 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i][j + 1].getContent() == -1) {
                            n++;
                        }
                    } else {
                        if (j == 10) {  //###########################  Vérification bord droit --> Coin bas droit
                            if (this.board[i - 1][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j - 1].getContent() == -1) {
                                n++;
                            }
                        } else {  // ###########################################"  Vérification de tout le bord bas
                            if (this.board[i - 1][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j + 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j + 1].getContent() == -1) {
                                n++;
                            }
                        }
                    }
                } else {
                    if (j == 0) {  // ##########################################  Vérification de tout le coté gauche
                        if (this.board[i - 1][j + 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i][j + 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j + 1].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i - 1][j].getContent() == -1) {
                            n++;
                        }
                        if (this.board[i + 1][j].getContent() == -1) {
                            n++;
                        }
                    } else {
                        if (j == 10) {  // ##########################################  Vérification de tout le coté droit
                            if (this.board[i - 1][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i + 1][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i + 1][j].getContent() == -1) {
                                n++;
                            }
                        } else {   //  #################################################### Vérification au centre
                            if (this.board[i - 1][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i - 1][j + 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j - 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i][j + 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i + 1][j].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i + 1][j + 1].getContent() == -1) {
                                n++;
                            }
                            if (this.board[i + 1][j - 1].getContent() == -1) {
                                n++;
                            }
                        }
                    }
                }
            }
        }
        return n;}
    }


