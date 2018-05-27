package xoxo;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * This class handles most of the GUI construction.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */
public class XoxoView {
    
    /**
     * A field that used to be the input of the
     * message that wants to be encrypted/decrypted.
     */
    private JTextField messageField;

    /**
     * A field that used to be the input of the key string.
     * It is a Kiss Key if it is used as the encryption.
     * It is a Hug Key if it is used as the decryption.
     */
    private JTextField keyField;

    
    /**
     * A field to be the input of the seed.
     */
    private JTextField seedField;

    /**
     * A field that used to display any log information such
     * as you click the button, an output file succesfully
     * created, etc.
     */
    private JTextArea logField; 

    /**
     * A button that when it is clicked, it encrypts the message.
     */
    private JButton encryptButton;

    /**
     * A button that when it is clicked, it decrpyts the message.
     */
    private JButton decryptButton;

    /**
     * Class constructor that initiates the GUI.
     */
    public XoxoView() {
        this.initGui();
    }

    /**
     * Constructs the GUI.
     */
    private void initGui() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        inputPanel.setPreferredSize(new Dimension(400, 100));

        messageField = new JTextField(1000);
        createInput("Message", messageField, inputPanel);
        keyField = new JTextField(1000);
        createInput("Key", keyField, inputPanel);
        seedField = new JTextField(1000);
        createInput("Seed", seedField, inputPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setPreferredSize(new Dimension(100, 100));

        encryptButton = new JButton("Encrypt");
        buttonPanel.add(encryptButton);
        decryptButton = new JButton("Decrypt");
        buttonPanel.add(decryptButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        logField = new JTextArea("Log Activity: \n");
        mainPanel.add(logField, BorderLayout.CENTER);

        JFrame mainFrame = new JFrame("Ama's Lab 10");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
    }

    /**
     * Method to create a panel for input data
     * @param panelName The name of the panel
     * @param tempField The text field that the panel use
     * @param mainPanel The main panel to put the input panel
     */
    
    private void createInput(String panelName, JTextField tempField, JPanel mainPanel) {
        JPanel tempPanel = new JPanel(new GridLayout(1,2));
        JLabel tempLabel = new JLabel(panelName + ": ", SwingConstants.CENTER);
        tempPanel.add(tempLabel);
        tempPanel.add(tempField);
        mainPanel.add(tempPanel);
    }


    /**
     * Gets the message from the message field.
     * 
     * @return The input message string.
     */
    public String getMessageText() {
        return messageField.getText();
    }

    /**
     * Gets the key text from the key field.
     * 
     * @return The input key string.
     */
    public String getKeyText() {
        return keyField.getText();
    }

    /**
     * Gets the seed text from the key field.
     * 
     * @return The input key string.
     */
    public String getSeedText() {
        return seedField.getText();
    }

    /**
     * Appends a log message to the log field.
     *
     * @param log The log message that wants to be
     *            appended to the log field.
     */
    public void appendLog(String log) {
        logField.append(log + '\n');
    }

    /**
     * Sets an ActionListener object that contains
     * the logic to encrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to encrypt a message.
     */
    public void setEncryptFunction(ActionListener listener) {
        encryptButton.addActionListener(listener);
    }
    
    /**
     * Sets an ActionListener object that contains
     * the logic to decrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to decrypt a message.
     */
    public void setDecryptFunction(ActionListener listener) {
        decryptButton.addActionListener(listener);
    }
}