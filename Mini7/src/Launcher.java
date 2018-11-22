import javax.swing.*;

public class Launcher {


    public static void main(String[] args) {

        JFrame gmFrame = new JFrame();
        gmFrame.setTitle("2048 Game");
        gmFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gmFrame.setSize(340, 400);
        gmFrame.setResizable(true);


        GameModel gm = new GameModel();
        GamePanel gp= new GamePanel(gm);
        gmFrame.add(gp);
        gm.resetGame();


        gp.addKeyListener(new Controller(gm,gp));
        gmFrame.setLocationRelativeTo(null);
        gmFrame.setVisible(true);

    }



}
