import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HomePage extends JFrame {

    JPanel homePanel;
    JPanel fileChooserPanel;

    JPanel encryptPanel;
    JPanel enVigPanel;
    JPanel enElGamalPanel;
    JPanel enRsaPanel;

    JPanel deVigPanel;
    JPanel deElGamalPanel;
    JPanel deRsaPanel;

    /*
    private filechooser f;
    private String filePath;
    private byte[] resultVig;
    private byte[] decryptVig;
    */
    JLabel l;
    String filePath = null;

    byte[] resultArray;

    public static void main(String[] args)
    {
        HomePage homepage = new HomePage();
    }

    public HomePage() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout homeLayout = new GridLayout(1, 1);
        setLayout(homeLayout);
        setTitle("CSDS 344 Team 10 Encryption/ Decryption Algorithms");
        setSize(700, 700);

        //File Chooser First?
        fileChooserPanel = new JPanel();
        JButton openFile = new JButton("open");

        JButton submitButton = new JButton("submit");

        // add buttons to the panel
        fileChooserPanel.add(openFile);
        fileChooserPanel.add(submitButton);


        // set the label to its initial value
        l = new JLabel("no file selected");
        fileChooserPanel.add(l);


        add(fileChooserPanel);

        //Home Panel
        homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(3, 1));
        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        Button encryptButton = new Button("Encrypt");
        Button decryptButton = new Button("Decrypt");

        homePanel.add(logo);
        homePanel.add(encryptButton);
        homePanel.add(decryptButton);

        //Encrypt Panel
        encryptPanel = new JPanel();
        encryptPanel.setLayout(new GridLayout(2, 2));

        Button enVigButton = new Button("Vigenere Cipher");
        Button enRsaButton = new Button("RSA Cipher");
        Button enElGamalButton = new Button("El Gamal Cipher");
        Button eb4 = new Button("Encryption Algorithm 4");

        encryptPanel.add(enVigButton);
        encryptPanel.add(enRsaButton);
        encryptPanel.add(enElGamalButton);
        encryptPanel.add(eb4);


        //Vigenere Encrypt
        JPanel vigEncryptPanel = new JPanel(new GridBagLayout());
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
        vigEncryptPanel.add(cipherLabel, constr);
        constr.gridx=1;
        vigEncryptPanel.add(result, constr);
        constr.gridx=0; constr.gridy=2;
        vigEncryptPanel.add(keyLabel, constr);
        constr.gridx=1;
        vigEncryptPanel.add(keyInput, constr);
        constr.gridx=0; constr.gridy=3;
        vigEncryptPanel.add(processLabel, constr);
        constr.gridx=1;
        vigEncryptPanel.add(explanationLabel1, constr);
        constr.gridy=4;
        vigEncryptPanel.add(explanationLabel2, constr);
        constr.gridy=5;
        vigEncryptPanel.add(explanationLabel3, constr);
        constr.gridy=6;
        //constr.gridwidth = 1;
        constr.anchor = GridBagConstraints.CENTER;
        //encrypt button
        JButton vigEncryptButton = new JButton("Encrypt");
        vigEncryptPanel.add(vigEncryptButton, constr);


        // Encrypts byte array with key with Vigenere Cipher
        vigEncryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    resultArray = VigenereCipher.encryptByteArray(str2ByteArray(filePath), keyInput.getText());
                    //File f = new File("VigenereEncrypt.txt");
                    //Files.write(Path.of(f.getPath()), resultArr);
                    result.setText(resultArray.toString());
                    System.out.println(resultArray.toString());
                    System.out.println(resultArray.length + "len");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                keyInput.setText("");
            }
        });



        //opens the Vig Encrypt Page
        enVigButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== enVigButton)
                {
                    remove(encryptPanel);
                    add(vigEncryptPanel);
                }
            }
        });


        /* ----------DECRYPT------------  */

        //Decrypt Panel
        JPanel decryptPanel = new JPanel();
        decryptPanel.setLayout(new GridLayout(2, 2));

        Button deVigButton = new Button("Vigenere Cipher");
        Button deRsaButton = new Button("RSA Cipher");
        Button deElGamalButton = new Button("El Gamal Cipher");
        Button db4 = new Button("Decryption Algorithm 4");

        decryptPanel.add(deVigButton);
        decryptPanel.add(deRsaButton);
        decryptPanel.add(deElGamalButton);
        decryptPanel.add(db4);


        //Vigenere Decrypt
        JPanel vigDecryptPanel = new JPanel(new GridBagLayout());
        constr = new GridBagConstraints();
        //constr.insets = new Insets(5, 5, 5, 5);
        //constr.anchor = GridBagConstraints.WEST;

        constr.gridx=0; constr.gridy=0;
        keyLabel = new JLabel("Enter your key:");
        processLabel = new JLabel("");

        cipherLabel = new JLabel("Decipher result:");
        JLabel vigDecryptResult = new JLabel("");
        explanationLabel1 = new JLabel("The vigenere cipher uses an polyalphabetic  key, ");
        explanationLabel2 = new JLabel("it ciphers each character with the caesar cipher");
        explanationLabel3 = new JLabel("of the corresponding key character");

        JTextField vigDecryptKeyInput = new JTextField(20);
        //JTextArea inputArea = new JTextArea(5, 20);

        constr.gridx=0; constr.gridy=1;
        vigDecryptPanel.add(cipherLabel, constr);
        constr.gridx=1;
        vigDecryptPanel.add(vigDecryptResult, constr);
        constr.gridx=0; constr.gridy=2;
        vigDecryptPanel.add(keyLabel, constr);
        constr.gridx=1;
        vigDecryptPanel.add(vigDecryptKeyInput, constr);
        constr.gridx=0; constr.gridy=3;
        vigDecryptPanel.add(processLabel, constr);
        constr.gridx=1;
        vigDecryptPanel.add(explanationLabel1, constr);
        constr.gridy=4;
        vigDecryptPanel.add(explanationLabel2, constr);
        constr.gridy=5;
        vigDecryptPanel.add(explanationLabel3, constr);
        constr.gridy=6;
        //constr.gridwidth = 1;
        constr.anchor = GridBagConstraints.CENTER;
        //encrypt button
        JButton vigDecryptButton = new JButton("Decrypt");
        vigDecryptPanel.add(vigDecryptButton, constr);

        // Decrypts byte array with key with Vigenere Cipher
        vigDecryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    resultArray = VigenereCipher.encryptByteArray(str2ByteArray(filePath), vigDecryptKeyInput.getText());
                    //File f = new File("VigenereEncrypt.txt");
                    //Files.write(Path.of(f.getPath()), resultArr);
                    vigDecryptResult.setText(resultArray.toString());
                    System.out.println(resultArray.toString());
                    System.out.println(resultArray.length + "len");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                vigDecryptKeyInput.setText("");
            }
        });


        //opens the Vig Encrypt Page
        deVigButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== deVigButton)
                {
                    remove(decryptPanel);
                    add(vigDecryptPanel);
                }
            }
        });


        //file chooser buttons
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // create an object of JFileChooser class
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // invoke the showsOpenDialog function to show the save dialog
                int r = fileChooser.showOpenDialog(null);

                // if the user selects a file
                if(r ==JFileChooser.APPROVE_OPTION)
                {
                    // set the label to the path of the selected file
                    l.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    filePath = l.getText();
                    System.out.println(filePath);
                }
                // if the user cancelled the operation
                else
                    l.setText("the user cancelled the operation");
            }});

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("hello");
                remove(fileChooserPanel);
                add(homePanel);
            }
        });

        //home buttons
        encryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                remove(homePanel);
                add(encryptPanel);
            }
        });

        decryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                remove(homePanel);
                add(decryptPanel);
            }
        });

    }

    public byte[] str2ByteArray(String fPath) throws IOException
    {
        Path path = Paths.get(fPath);
        System.out.println(fPath);
        byte[] fileContent = Files.readAllBytes(path);
        System.out.println(fileContent.length);
        return fileContent;
    }

    public File fileRenderer(byte[] decrypted) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(decrypted);
        ObjectInputStream o = new ObjectInputStream(b);
        File renderedFile = (File) o.readObject();
        b.close();
        o.close();
        return renderedFile;
    }
}
