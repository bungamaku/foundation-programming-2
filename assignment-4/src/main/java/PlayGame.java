import javax.swing.SwingUtilities;
import view.GameView;

/**
 * Main class to run the game
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class PlayGame {

	public static void main(String[] args) {

        GameView play = new GameView("Ama's Matching Game", 18);
        
        javax.swing.SwingUtilities.invokeLater(play::createAndShowGUI);
    }
}