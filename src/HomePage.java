import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
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
    byte[] result;

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

        //encrypt Vigenere panel
        /*
        enVigPanel = new JPanel();
        enVigPanel.setLayout(new GridLayout(2, 1));

        JPanel enVigHeaderPanel = new JPanel();
        JLabel headerLabel = new JLabel("Vigenere Cipher");
        enVigHeaderPanel.add(headerLabel);

        enVigPanel.add(enVigHeaderPanel);

        JPanel enVigMainPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;


        JLabel explanationLabel1 = new JLabel("The vigenere cipher uses an polyalphabetic  key, ");
        JLabel explanationLabel2 = new JLabel("it ciphers each character with the caesar cipher");
        JLabel explanationLabel3 = new JLabel("of the corresponding key character");


        //JTextArea inputArea = new JTextArea(5, 20);

        JLabel cipherLabel = new JLabel("Encipher result:");
        constr.gridx=0; constr.gridy=1;
        enVigMainPanel.add(cipherLabel, constr);

        JLabel result = new JLabel("");
        constr.gridx=1;
        enVigMainPanel.add(result, constr);

        JLabel keyLabel = new JLabel("Enter your key:");
        constr.gridx=0; constr.gridy=2;
        enVigMainPanel.add(keyLabel, constr);

        JTextField keyInput = new JTextField(20);
        constr.gridx=1;
        enVigMainPanel.add(keyInput, constr);

        JLabel processLabel = new JLabel("");
        constr.gridx=0; constr.gridy=3;
        enVigMainPanel.add(processLabel, constr);

        constr.gridx=1;
        enVigMainPanel.add(explanationLabel1, constr);

        constr.gridy=4;
        enVigMainPanel.add(explanationLabel2, constr);

        constr.gridy=5;
        enVigMainPanel.add(explanationLabel3, constr);


        //encrypt button
        JButton encryptVigButton = new JButton("Encrypt");
        constr.gridy=6;
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        enVigMainPanel.add(encryptVigButton, constr);
         */

        //encrypt RSA panel

        //encrypt El Gamal panel

        //encrypt vigenere panel

        //Decrypt Panel


        // add action listener to all the buttons
        //encrypt buttons
        /*
        enVigButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                remove(encryptPanel);
                add(enVigPanel);
            }
        });*/

        enVigButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== enVigButton)
                {
                    VigenereEncrypt vig = new VigenereEncrypt();
                    System.out.println(filePath);
                    try {
                        vig.vig(str2ByteArray(filePath));
                        result = vig.getResultArray();
                        System.out.println(result.length + "AAAAAAAAAAAAAAAA");

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    if (result != null) {
                        try(FileOutputStream fos = new FileOutputStream("vigEncrypt.txt")) {
                            fos.write(result);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
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
            }
        });

        decryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                remove(homePanel);
            }
        });

    }

    public byte[] str2ByteArray(String fPath) throws IOException {
        Path path = Paths.get(fPath);
        System.out.println(fPath);
        byte[] fileContent = Files.readAllBytes(path);
        System.out.println(fileContent.length);
        return fileContent;
    }
}
