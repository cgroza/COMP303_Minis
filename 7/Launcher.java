import javax.swing.*;

// Launcher class to create initialize the components of the MVC pattern and
// launch the game.
public class Launcher {
    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("2048 Game");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(340, 400);
        gameFrame.setResizable(true);

        // Create the game Model.
        GameModel gameModel = new GameModel();
        // Create the game Viewer. Pass in reference to model so that viewer can
        // read the model and draw itself accordingly.
        GamePanel gamePanel = new GamePanel();
        gamePanel.drawState(gameModel.getTiles(), gameModel.getMyWin(), gameModel.getMyLose(),
                         gameModel.getMyScore());
        gameFrame.add(gamePanel);
        // Create the game Controller.
        gamePanel.addKeyListener(new Controller(gameModel, gamePanel));

        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}
