import javax.swing.*;
import java.util.Random;


public class Matrix  extends JPanel {

    private  int[][] matrix;

    public Matrix(int size) {
        matrix =new int[size][size];
        fillMatrixRandom();
    }


    public int [] [] getMatrix () {
        return matrix;
    }

    //This function fill giving matrix in random values between 0-1
    public  void fillMatrixRandom () {
      Random rand = new Random();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                int random = rand.nextInt(2);
                matrix[i][j] = random;
            }
        }
    }

    //This function change the values of the giving matrix according to "Game of life"
    public  void changeMatrix() {
        int[][] tempMatrix = new int[matrix.length][matrix.length];
        int aliveNeighbors = 0;
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j< matrix.length; j++) {
                if(i != 0 && i != matrix.length-1 && j!=0 && j!= matrix.length-1) {
                    aliveNeighbors = matrix[i-1][j-1] + matrix[i][j-1] + matrix[i+1][j-1] + matrix[i-1][j] + matrix[i+1][j] + matrix[i-1][j+1] + matrix[i][j+1] + matrix[i+1][j+1];
                } else {
                    if(i == 0) {
                        if(j == 0) {
                            aliveNeighbors = matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+1][j];
                        } else if(j == matrix.length-1) {
                            aliveNeighbors = matrix[i][j-1] + matrix[i+1][j-1] + matrix[i+1][j];
                        } else {
                            aliveNeighbors = matrix[i][j-1] + matrix[i][j+1] + matrix[i+1][j-1]  + matrix[i+1][j] + matrix[i+1][j+1];
                        }
                    } else if(i == matrix.length-1) {
                        if(j == 0) {
                            aliveNeighbors = matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1];
                        }
                        else if(j == matrix.length-1)
                        {
                            aliveNeighbors = matrix[i-1][j] + matrix[i-1][j-1] + matrix[i][j-1];
                        }
                        else
                        {
                            aliveNeighbors = matrix[i][j-1] + matrix[i][j+1] + matrix[i-1][j-1]  + matrix[i-1][j] + matrix[i-1][j+1];
                        }
                    }
                    else
                    {
                        if(j == 0){
                            aliveNeighbors = matrix[i-1][j] + matrix[i+1][j] + matrix[i][j+1]  + matrix[i-1][j+1] + matrix[i+1][j+1];
                        } else if(j == matrix.length-1) { //middle of bottom row
                            aliveNeighbors = matrix[i-1][j] + matrix[i+1][j] + matrix[i-1][j-1]  + matrix[i][j-1] + matrix[i+1][j-1];
                        }
                    }
                }
                tempMatrix[i][j] = painted(aliveNeighbors, matrix[i][j]);
            }
        }
        matrix =tempMatrix;
    }

    public int painted(int aliveNeighbors, int currentTile){
        if (currentTile == 0){
             if(aliveNeighbors == 3)
                 return 1 ;
             else{
                 return 0;
             }

        }else {
            if (aliveNeighbors < 2 || aliveNeighbors > 3){
             return 0;
            }
            else return 1;
        }
    }
}


