import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

public class VigenerePage {
    public static void main(String[] args){
    // Create frame with title
        JFrame frame= new JFrame();
        frame.setTitle("CipherBuddy");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Vigenere Cipher");
        headingPanel.add(headingLabel);
        JPanel panel = new JPanel(new GridBagLayout());
// Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;
// Setting initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;
        JLabel keyLabel = new JLabel("Enter your key:");
        JLabel inputLabel = new JLabel("Input:");

        JLabel encryptedLabel = new JLabel("");
        JLabel decryptedLabel = new JLabel("");
        JLabel resultLabel = new JLabel("");

        JTextField keyInput = new JTextField(20);
        JTextArea inputArea = new JTextArea(5, 20);


        constr.gridx=0; constr.gridy=1;
        panel.add(encryptedLabel, constr);
        panel.add(decryptedLabel, constr);
        constr.gridx=1;
        panel.add(resultLabel, constr);
        constr.gridx=0; constr.gridy=2;
        panel.add(keyLabel, constr);
        constr.gridx=1;
        panel.add(keyInput, constr);
        constr.gridx=0; constr.gridy=3;
        panel.add(inputLabel, constr);
        constr.gridx=1;
        panel.add(inputArea, constr);
        constr.gridx=0; constr.gridy=4;
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        //encrypt button
        JButton encryptButton = new JButton("Encrypt");

        encryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                encryptedLabel.setText("Encrypted input:");
                decryptedLabel.setText("");
                try {
                    resultLabel.setText(VigenereCipher.encryptByteArray(inputArea.getText().getBytes(), keyInput.getText()).toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                keyInput.setText("");
                inputArea.setText("");
            }
        });
        panel.add(encryptButton, constr);
        constr.gridx=2; constr.gridy=4;
        JButton decryptButton = new JButton("Decrypt");
        panel.add(decryptButton, constr);
        // add a listener to button
        decryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                encryptedLabel.setText("");
                decryptedLabel.setText("Decrypted input:");
                resultLabel.setText(VigenereCipher.decryptByteArray(inputArea.getText().getBytes(), keyInput.getText()).toString());


                keyInput.setText("");
                inputArea.setText("");
            }
        });
        panel.add(decryptButton, constr);
        mainPanel.add(headingPanel);
        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}