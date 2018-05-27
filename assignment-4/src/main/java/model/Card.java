package model;

import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Class of Card to define the card model
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class Card {
	private final JButton BUTTON;
	private final int ID;
    private final ImageIcon INSIDE_IMAGE;
    private final ImageIcon OUTSIDE_IMAGE;
    private State state;

    /**
     * Constructor of the card class
     * @param id identification number of the card
     * @param insideImage image for the inside of the card
     * @param outsideImage image for the outside of the card
     */

    public Card(int id, ImageIcon insideImage, ImageIcon outsideImage) {
    	this.ID = id;
        this.INSIDE_IMAGE = insideImage;
        this.OUTSIDE_IMAGE = outsideImage;
    	this.BUTTON = new JButton(outsideImage);
        state = state.CLOSED;
    }

    /**
     * Accessor to get the identification number of the card
     * @return id identification number of the card
     */

    public int getId() {
        return this.ID;
    }

    /**
     * Mutator to set the state and the side of the card
     * @param state state that will be assign to the card
     */

    public void setState(State state) {
        this.state = state;
        if (state == State.OPENED) {
            BUTTON.setIcon(INSIDE_IMAGE);
        } else if (state == State.CLOSED) {
            BUTTON.setIcon(OUTSIDE_IMAGE);
        } else if (state == State.DELETED) {
            BUTTON.setVisible(false);
        }
    }

    /**
     * Accessor to get the state that the card have now
     * @return state state that the card have now
     */

    public State getState() {
        return this.state;
    }

    /**
     * Accessor to get the button that the card have
     * @return button
     */

    public JButton getButton() {
        return this.BUTTON;
    }

    /**
     * Method to create the enum data type of the state
     */

    public enum State {
        CLOSED, OPENED, DELETED;
    }
}