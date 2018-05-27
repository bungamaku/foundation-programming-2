package view;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import model.Card;

/**
 * Class of CardView to build the GUI for the card
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class CardView {

	private final int CARDS_AMOUNT;
	private final String DEFAULT_PATH = "C:\\Users\\Fia\\ddp2\\tp\\assignment-4\\img";
	private BufferedImage inside, outside;
	private List<Card> cards = new ArrayList<Card>();

	/**
	 * Constructor of the CardView
	 * @param cardsAmount the amount of cards that the game use
	 */

	public CardView(int cardsAmount) {
		this.CARDS_AMOUNT = cardsAmount;
	}

	/**
	 * Accessor to get the list of cards
	 * @return list of cards
	 */

	public List<Card> getCardList() {
		return cards;
	}

	/**
	 * Method to create all the card view in cards list
	 */

	public void createCardView() {
		try {
			outside = pathToImage(DEFAULT_PATH, "outside.png");

			for (int i = 0; i < CARDS_AMOUNT; i++) {
	            inside = pathToImage(DEFAULT_PATH, i + ".png");

	            for (int j = 0; j < 2; j++) {
	            	Card tempCard = new Card(i, new ImageIcon(inside), new ImageIcon(outside));
	            	cards.add(tempCard);
	            }
			}

		} catch (IOException e) {
        	JOptionPane.showMessageDialog(new JFrame(), "Invalid image source path!");
        	System.exit(0);
        }
	}

	/**
	 * Method to create image from the path
	 * @param  defPath  default path
	 * @param  addPath  additional path to specify the image path
	 * @return          image from the path
	 */

	private BufferedImage pathToImage(String defPath, String addPath) throws IOException {
		Path tempPath = Paths.get(defPath).resolve(addPath);
		File tempFile = tempPath.toFile();
		return ImageIO.read(tempFile);
	}
}