import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// This class implements the Controller component of the MVC pattern. It handles
// user key press events and instructs the Model to update accordingly. It also
// updates the View with the new state.
public class Controller extends KeyAdapter {

    private GameModel game;
    private GamePanel gamePanel;

    // The Controller takes a GameModel and a Game viewer reference.
    public Controller(GameModel g, GamePanel gp) {
        game = g;
        gamePanel = gp;
    }

    // Converted code to use the encapsulated View component.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.resetGame();
        }
        if (!game.canMove()) {
            game.setMyLose(true);
        }

        if (!game.getMyWin() && !game.getMyLose()) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                game.left();
                break;
            case KeyEvent.VK_RIGHT:
                game.right();
                break;
            case KeyEvent.VK_DOWN:
                game.down();
                break;
            case KeyEvent.VK_UP:
                game.up();
                break;
            }
        }

        if (!game.getMyWin() && !game.canMove()) {
            game.setMyLose(true);
        }

        // Update the view with the new state of the model
        gamePanel.drawState(game.getTiles(), game.getMyWin(), game.getMyLose(),
                         game.getMyScore());
    }
}
