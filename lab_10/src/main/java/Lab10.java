import xoxo.XoxoView;
import xoxo.XoxoController;

/**
 * Main class that runs the Xoxo Controller.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class Lab10 {

    /**
     * The main method.
     * 
     * @param args Argument strings.
     */
    public static void main(String[] args) {
        XoxoView view = new XoxoView();
        XoxoController controller = new XoxoController(view);
        controller.run();
    }
    
}
