package xoxo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import xoxo.crypto.XoxoDecryption;
import xoxo.crypto.XoxoEncryption;
import xoxo.exceptions.InvalidCharacterException;
import xoxo.exceptions.KeyTooLongException;
import xoxo.exceptions.RangeExceededException;
import xoxo.exceptions.SizeTooBigException;
import xoxo.key.HugKey;
import xoxo.util.XoxoMessage;

/**
 * This class controls all the business
 * process and logic behind the program.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */
public class XoxoController {

    /**
     * The GUI object that can be used to get
     * and show the data from and to users.
     */
    private XoxoView gui;

    private String messageInput, keyInput, seedInput;
    private int seed, logCounter, encryptCounter, decryptCounter;

    /**
     * Class constructor given the GUI object.
     */
    public XoxoController(XoxoView gui) {
        this.gui = gui;
    }

    /**
     * Main method that runs all the business process.
     */

    public void run() {
        gui.setEncryptFunction(event -> encryptMessage());
        gui.setDecryptFunction(event -> decryptMessage());
    }

    /**
     * Method to encrypt the message
     */

    private void encryptMessage() {
        getInput();

        try {
            XoxoEncryption encryption = new XoxoEncryption(keyInput);
            XoxoMessage encryptMessage = encryption.encrypt(messageInput, seed);
            Path path = Paths.get("./EncryptedMessage_" + ++encryptCounter + ".enc");
            
            writeOutput(path, encryptMessage.getEncryptedMessage().getBytes());

            gui.appendLog(++logCounter + ". encrypted message in " + path.toString());
        } catch (InvalidCharacterException eChar) {
            gui.appendLog(++logCounter + ". Invalid character: " + eChar.getMessage());
        } catch (KeyTooLongException eKey) {
            gui.appendLog(++logCounter + ". Key is too long: " + eKey.getMessage());
        } catch (RangeExceededException eRange) {
            gui.appendLog(++logCounter + ". Range seed exceeded: " + eRange.getMessage());
        } catch (SizeTooBigException eSize) {
            gui.appendLog(++logCounter + ". Message size is too big: " + eSize.getMessage());
        } 
    }

    /**
     * Method to decrypt the message
     */

    private void decryptMessage() {
        getInput();

        XoxoDecryption decryption = new XoxoDecryption(keyInput);
        String decryptMessage = decryption.decrypt(messageInput, seed);
        Path path = Paths.get("./DecryptedMessage_" + ++decryptCounter + ".txt");
        
        writeOutput(path, decryptMessage.getBytes());

        gui.appendLog(++logCounter + ". decrypted message in " + path.toString());
    }

    /**
     * Method to get all the input
     */

    private void getInput() {
        messageInput = gui.getMessageText();
        keyInput = gui.getKeyText();
        seedInput = gui.getSeedText();
        seed = HugKey.DEFAULT_SEED;

        if (!seedInput.equals("")) {
            try {
                seed = Integer.parseInt(seedInput);
            } catch (NumberFormatException eNumber) {
                gui.appendLog(++logCounter + ". Seed input error: " + eNumber.getMessage());
            }
        }
    }

    /**
     * Method to write the output
     * @param path    path to put the file
     * @param message message to write in file
     */

    private void writeOutput(Path path, byte[] message) {
        try {
            OutputStream outputFile = new BufferedOutputStream(
                Files.newOutputStream(path, CREATE, APPEND));
            outputFile.write(message, 0, message.length);
            outputFile.flush();
            outputFile.close();
        } catch (IOException eOutput) {
            gui.appendLog(++logCounter + ". Output error: " + eOutput.getMessage());
        }
    }
}