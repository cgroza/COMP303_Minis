import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private GameModel gm;
    private GamePanel gp;


    public Controller(GameModel model, GamePanel panel) {
        gm = model;
        gp = panel;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gm.resetGame();
        }
        if (!gm.canMove()) {
            gm.myLose = true;
        }

        if (!gm.myWin && !gm.myLose) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gm.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    gm.right();
                    break;
                case KeyEvent.VK_DOWN:
                    gm.down();
                    break;
                case KeyEvent.VK_UP:
                    gm.up();
                    break;
            }
        }

        if (!gm.myWin && !gm.canMove()) {
            gm.myLose = true;
        }

        gp.repaint();
    }






}
