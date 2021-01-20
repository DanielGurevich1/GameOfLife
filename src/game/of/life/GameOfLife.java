
package game.of.life;

public class GameOfLife {

    public static void main(String[] args) {
        System.out.println("GOL");
char[][] field = new char[5][5];


// random iteration
                for (int i = 0; i < field.length; i++){
                    for (int j = 0; j < field[i].length; j++){
                        if (Math.random() < 0.25){
                            field[i][j] = 'X';
                        } else {
                            field[i][j] = '.';
                        }
                        System.out.print(field[i][j]);
                    }
                    System.out.println();
                }
        System.out.println("**********");
        // logic of a solution
        // sukuriame naujas korteles ir ju istorija
        char[][][]history = new char[field.length][field.length][field[0].length];
        // korteliu, pakartojimu kiekis
        for (int c = 0; c < 50; c++) {
            history[c] = field;
            char[][]newField = new char [field.length][field[0].length];
            for (int i = 0; i < newField.length; i++) {
                for (int j = 0; j < newField[i].length; j++) {
                    int n = 0;
                    if (i > 0) {
                        n +=(i > 0 && 
                                j > 0 && 
                                field[i-1][j-1] == 'X') ? 1 : 0;
                        n +=(i > 0 && 
                                field[i-1][j] == 'X') ? 1 : 0;
                        n +=(i > 0 && j < field[i].length - 1 &&
                                field[i-1][j+1] == 'X') ? 1 : 0;
                    }
                        n += (j > 0 && field[i][j-1] == 'X') ? 1 : 0;
                        n += (j < field[i].length - 1 && field[i][j+1] == 'X') ? 1:0;
                    if (i < field.length - 1) {
                        n +=(j > 0 && j > 0 && field[i+1][j-1] == 'X') ? 1 : 0;
                                
                        n +=(j > 0 && field[i+1][j] == 'X') ? 1 : 0;
                                
                        n +=(j > 0 && j < field[i].length - 1 && field[i+1][j+1] == 'X') ? 1 : 0;
                                
                    }
                    if (field[i][j] == 'X') {
                        if (n ==2 || n == 3) {
                            newField[i][j] = 'X';
                        } else {
                            newField[i][j] = '.';
                        } 
                    } else {
                        if (n == 3) {
                            newField[i][j] = 'X';
                        } else {
                            newField[i][j] = '.';
                        }
                    }
                }
            }
            int h;
            for (h=c; h>=0; h--) {
                char[][]f = history[h];
                boolean match = true;
                for (int i = 0; match && i < f.length; i++) {
                    for (int j = 0; match && j < f[i].length; j++) {
                        if(f[i][j] != newField[i][j]) {
                            match = false;
                        }
                    }
                }
                if (match) {
                    break;
                }
            }
            field = newField;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++){
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            System.out.println((c+1) + "---------");
        }
           
    
        }
}
        
