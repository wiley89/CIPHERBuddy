import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

public class VigenereDecrypt 
{
    /**
     * NEED to update method to take a byte array input in the method header
     * @param bytes
     */
    public void vig(byte[] bytes)
    {
        // Create frame with title
        JFrame frame= new JFrame();
        frame.setTitle("CipherBuddy");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
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

        JLabel cipherLabel = new JLabel("Decrypt result:");
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
        JButton decryptButton = new JButton("Decrypt");

        decryptButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    /*
                    try {
                        result = VigenereCipher.decryptByteArray(bytes, keyInput.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }*/

                    keyInput.setText("");
                }
            });
        panel.add(decryptButton, constr);

        mainPanel.add(headerPanel);
        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}