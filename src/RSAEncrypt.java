import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

public class RSAEncrypt 
{
    public void rsa()
    {
        // Create frame with title
        JFrame frame= new JFrame();
        frame.setTitle("CipherBuddy");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("RSA Encryption");
        headerPanel.add(headerLabel);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        //constr.insets = new Insets(5, 5, 5, 5);
        //constr.anchor = GridBagConstraints.WEST;

        constr.gridx=0; constr.gridy=0;
        JLabel keyLabel = new JLabel("Enter your key:");
        JLabel processLabel = new JLabel("");

        JLabel cipherLabel = new JLabel("RSA Encryption:");
        JLabel explanationLabel1 = new JLabel("Two prime numbers(p and q) which are selected with a primality test");
        JLabel explanationLabel2 = new JLabel("The modulus(n) is found using the following formula: n = p x q ");
        JLabel explanationLabel3 = new JLabel("The cipher(c) is derived from the public key(e) and the input byte array in interger form(m) using the following formula: c = m^e mod n");
        JTextField keyInput = new JTextField(20);
        //JTextArea inputArea = new JTextArea(5, 20);

        constr.gridx=0; constr.gridy=1;
        panel.add(cipherLabel, constr);
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
                    //encryptedLabel.setText("Encrypted input:");
                    //decryptedLabel.setText("");
                    /*
                    try {
                    //resultLabel.setText(VigenereCipher.encryptByteArray(inputArea.getText().getBytes(), keyInput.getText()).toString());
                    } catch (IOException ioException) {
                    ioException.printStackTrace();
                    }*/

                    keyInput.setText("");
                }
            });
        panel.add(encryptButton, constr);

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