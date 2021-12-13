import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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
        homePanel.setLayout(new GridLayout(2, 1));
        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        Button encryptButton = new Button("Encrypt");

        homePanel.add(logo);
        homePanel.add(encryptButton);

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
        constr.gridy=7;
        JButton vigDecryptButton = new JButton("Decrypt and render file");
        vigEncryptPanel.add(vigDecryptButton, constr);


        // Encrypts byte array with key with Vigenere Cipher
        vigEncryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    resultArray = VigenereCipher.encryptByteArray(str2ByteArray(filePath), keyInput.getText());
                    result.setText("Encrypted byte array printed to console");
                    System.out.println("Encrypted byte array");
                    System.out.println(Arrays.toString(resultArray));

                    try {
                        fileRenderer(VigenereCipher.decryptByteArray(resultArray, keyInput.getText()));
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        vigDecryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    fileRenderer(VigenereCipher.decryptByteArray(resultArray, keyInput.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
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

    }

    public byte[] str2ByteArray(String fPath) throws IOException
    {
        Path path = Paths.get(fPath);
        System.out.println(fPath);
        byte[] fileContent = Files.readAllBytes(path);
        System.out.println(fileContent[0]);
        System.out.println(fileContent.length);
        return fileContent;
    }

    public void fileRenderer(byte[] decrypted) throws IOException, ClassNotFoundException {
        File file =  new File("file");
        //file.createNewFile();
        try {

            // Initialize a pointer
            // in file using OutputStream
            OutputStream
                    os
                    = new FileOutputStream(file);

            // Starts writing the bytes in it
            os.write(decrypted);
            System.out.println("Successfully"
                    + " byte inserted");

            // Close the file
            os.close();
        }

        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
