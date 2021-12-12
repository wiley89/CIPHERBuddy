import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ElGamalEncrypt extends JPanel
{
    public byte[] resultArray;

    public byte[] getResultArray() {
        return resultArray;
    }

    /**
     * NEED to update method to take a byte array input in the method header
     * @param bytes
     */
    public void elGamal(byte[] bytes)
    {
        // Create frame with title
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Vigenere Cipher");
        headerPanel.add(headerLabel);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        //constr.insets = new Insets(5, 5, 5, 5);
        //constr.anchor = GridBagConstraints.WEST;

        constr.gridx=0; constr.gridy=0;
        JLabel keyLabel = new JLabel("Enter your key:");
        JLabel processLabel = new JLabel("");

        JLabel cipherLabel = new JLabel("Encipher result:");
        JLabel result = new JLabel("");
        JLabel explanationLabel1 = new JLabel("The vigenere cipher uses an polyalphabetic  key, ");
        JLabel explanationLabel2 = new JLabel("it ciphers each character with the caesar cipher");
        JLabel explanationLabel3 = new JLabel("of the corresponding key character");

        JTextField keyInput = new JTextField(20);
        //JTextArea inputArea = new JTextArea(5, 20);

        constr.gridx=0; constr.gridy=1;
        panel.add(cipherLabel, constr);
        constr.gridx=1;
        panel.add(result, constr);
        constr.gridx=0; constr.gridy=2;
        panel.add(keyLabel, constr);
        constr.gridx=1;
        panel.add(keyInput, constr);
        constr.gridx=0; constr.gridy=3;
        panel.add(processLabel, constr);
        constr.gridx=1;
        panel.add(explanationLabel1, constr);
        constr.gridy=4;
        panel.add(explanationLabel2, constr);
        constr.gridy=5;
        panel.add(explanationLabel3, constr);
        constr.gridy=6;
        //constr.gridwidth = 1;
        constr.anchor = GridBagConstraints.CENTER;
        //encrypt button
        JButton encryptButton = new JButton("Encrypt");

        encryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    byte[] resultArr = VigenereCipher.encryptByteArray(bytes, keyInput.getText());
                    //File f = new File("VigenereEncrypt.txt");
                    //Files.write(Path.of(f.getPath()), resultArr);
                    resultArray = resultArr;
                    result.setText(resultArr.toString());
                    System.out.println(resultArr.toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                keyInput.setText("");
            }
        });
        panel.add(encryptButton, constr);

        add(headerPanel);
        add(panel);
    }
}