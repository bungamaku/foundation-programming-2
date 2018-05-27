/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package view;

import java.util.List;
import java.util.Collections;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.Card;
import view.CardView;
import view.GameView;

/**
 * Class of GameView to build the GUI for the game
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class GameView {

    private final String NAME;
    private final int CARDS_AMOUNT;
    private CardView cardView;
    private JFrame gameFrame;
	private JPanel cardBoard, control;
    private JButton cardButton, restartButton, exitButton, hintButton;
    private JLabel triesLabel;
	private List<Card> cardList;
	private Timer timer;
	private Card thisCard, nextCard;
    private int tries;
    private int deletedCards = 0;

    /**
     * Constructor of the GameView class
     * @param name the name of the game
     * @param cardsAmount the amount of the cards that the game use
     */

	public GameView(String name, int cardsAmount) {
        this.NAME = name;
        this.CARDS_AMOUNT = cardsAmount;
    }

    /**
     * Accessor to get the number of tries
     * @return the number of tries
     */

    public int getTries() {
        return this.tries;
    }

    /**
     * Mutator to set the number of tries
     * @param tries the number that will be assign to tries 
     */

    public void setTries(int tries) {
        this.tries = tries;
        triesLabel.setText("Number of tries: " + tries);
    }
    
    /**
     * Method to add all the components to the main frame
     */
    
    private void addComponentsToFrame() {
        gameFrame = new JFrame(NAME);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setResizable(false);
        
        cardBoard = new JPanel();
        cardBoard.setLayout(new GridLayout(6,6));

        control = new JPanel();
        control.setLayout(new GridLayout(1,4));
        
        createCardBoardComponents();
        createControlComponents();

        gameFrame.add(cardBoard, BorderLayout.CENTER);
        gameFrame.add(control, BorderLayout.SOUTH);
    }

    /**
     * Method to create the cards components
     */

    private void createCardBoardComponents() {
        cardView = new CardView(CARDS_AMOUNT);
        cardView.createCardView();
        cardList = cardView.getCardList();
        Collections.shuffle(cardList);

        for (Card card : cardList) {
            cardButton = card.getButton();
            cardButton.setBorder(BorderFactory.createEmptyBorder());
            cardButton.setContentAreaFilled(false);
            cardButton.addActionListener(event -> changeState(card));
            cardBoard.add(cardButton);
        }
    }

    /**
     * Method to create the controls components
     */

    private void createControlComponents() {
        hintButton = new JButton("See Hints");
        hintButton.addActionListener(event -> seeHints());

        restartButton = new JButton("Restart Game");
        restartButton.addActionListener(event -> restart());

        exitButton = new JButton("Exit");
        exitButton.addActionListener(event -> System.exit(0));

        triesLabel = new JLabel("Number of tries: " + getTries(), SwingConstants.CENTER);

        control.add(restartButton);
        control.add(exitButton);
        control.add(hintButton);
        control.add(triesLabel);
    }

    /**
     * Method to restart the game
     */

    private void restart() {
        cardBoard.removeAll();
        createCardBoardComponents();
        gameFrame.add(cardBoard, BorderLayout.CENTER);
        gameFrame.revalidate();
        gameFrame.repaint();
        setTries(0);
        deletedCards = 0;
    }

    /**
     * Method to show the hints
     */

    private void seeHints() {
        changeStateAll(cardList, Card.State.OPENED);
        timer = new Timer(500, event -> changeStateAll(cardList, Card.State.CLOSED));
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Method to change all the cards state
     * @param cardList list of the cards
     * @param state state that will be assign to the cards
     */

    private void changeStateAll(List<Card> cardList, Card.State state) {
        for (Card card : cardList) {
            card.setState(state);
        }
    }

    /**
     * Method to change the latest 2 two cards state that have been clicked
     * @param tempCard temporary card
     */

    private void changeState(Card tempCard) {

    	if (thisCard == null && nextCard == null) {
    		thisCard = tempCard;
    		thisCard.setState(Card.State.OPENED);
    	}

    	if (thisCard != null && thisCard != tempCard && nextCard == null) {
    		nextCard = tempCard;
    		nextCard.setState(Card.State.OPENED);
    		timer = new Timer(500, event -> checkCards());
            timer.setRepeats(false);
    		timer.start();
    	}
    }

    /**
     * Method to check the latest 2 cards state if they matched
     */

    private void checkCards() {

    	if (thisCard.getId() == nextCard.getId()) {
    		thisCard.setState(Card.State.DELETED);
    		nextCard.setState(Card.State.DELETED);
            deletedCards++;

    		if (gameFinished()) {
    			JLabel messageLabel = new JLabel("Yeay, you finish the game!");
                messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                Object[] options = {"Play Again", "Exit"};
                int option = JOptionPane.showOptionDialog(null, messageLabel,
                        NAME, JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if (option == 0) {
                    restart();
                } else {
                    System.exit(0);
                }
    		}

    	} else {
    		thisCard.setState(Card.State.CLOSED);
    		nextCard.setState(Card.State.CLOSED);
            setTries(getTries() + 1);
    	}

    	thisCard = null;
    	nextCard = null;
    }

    /**
     * Method to check if the game finished
     * @return true if all of the cards deleted, false otherwise
     */

    private boolean gameFinished() {
    	return deletedCards == CARDS_AMOUNT;
    }

    /**
     * Method to create and show the game view GUI
     */

    public void createAndShowGUI() {
        addComponentsToFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

}