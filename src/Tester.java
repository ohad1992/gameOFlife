import javax.swing.*;

public class Tester {
    public static void main(String[] args) {
        final int frameSize =700;

        JFrame frame = new JFrame(" The game Of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSize, frameSize);

        Panel p = new Panel();
        frame.add(p);
        frame.setVisible(true);

        //running the game untill pres 'no'
        while (JOptionPane.showConfirmDialog(null, "you want to move to the next generation? \n") == 0) {
            p.run();
            p.repaint();
        }
    }
}
