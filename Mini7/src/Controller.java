//Ryszard Kubinski 260731196
//Controls information passing between Model and View
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private GameModel gm;
    private GamePanel gp;

    //instantiates the controller together with its view and model
    //updates duplicated fields of the view
    public Controller(GameModel model, GamePanel panel) {
        gm = model;
        gp = panel;
        gp.update(gm.myWin,gm.myLose,gm.getMyTiles(),gm.myScore);
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
        //updates fields of the view by grabbing fields from the model
        gp.update(gm.myWin,gm.myLose, gm.getMyTiles(),gm.myScore);

    }






}
