import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
        private Matrix matrix;
        final private int rectangleSize = 30;
        final private  int matrixSize=10;

    public Panel() {
            matrix= new Matrix(matrixSize);
        }
// this function call to another function to change matrix
        public void run() {
            matrix.changeMatrix();
        }
        public void paintComponent(Graphics g) {
            int x=0,y=0;
            super.paintComponent(g);
            int [][] mat= matrix.getMatrix();
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (mat[i][j] == 1) {
                        g.fillRect(x, y, rectangleSize, rectangleSize);
                    } else {
                        g.drawRect(x, y, rectangleSize, rectangleSize);
                    }
                    x += rectangleSize;
                }
                y += rectangleSize;
                x = 0;
            }
        }// End of paintComponent
    } //End of Panel