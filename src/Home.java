
/**
 * Write a description of class homepage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Home extends JFrame
{
    private filechooser f;
    private String filePath;

    public static void main(String[] args)
    {
        Home homepage = new Home();
    }

    public Home()
    {
        // home page
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout homelayout = new GridLayout(3, 1);
        setLayout(homelayout);
        setTitle("CSDS 344 Team 10 Encryption/ Decryption Algorithms");
        setSize(400, 400);

        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        Button b1 = new Button("Encrypt");
        Button b2 = new Button("Decrypt");

        add(logo);
        add(b1);
        add(b2);

        Scanner input = new Scanner(System.in);
        b1.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if (e.getSource() == b1)
                    {
                        System.out.println("pressed encrypt");
                        setVisible(true);
                        remove(logo);
                        remove(b1);
                        remove(b2);

                        GridLayout filelayout = new GridLayout(3, 1);
                        setLayout(filelayout);
                        setSize(400, 400);

                        Button file = new Button("Drag and Drop a File to Encrypt!");
                        Button submit = new Button("Click here once you have uploaded your file.");

                        add(file);
                        add(submit);

                        file.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent e) 
                                {
                                    if(e.getSource()== file)
                                    {
                                        f = new filechooser();
                                    }
                                }
                            });

                        submit.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent e) 
                                {
                                    if(e.getSource()== submit)
                                    {
                                        setVisible(true);
                                        remove(file);
                                        remove(submit);

                                        GridLayout encryptlayout = new GridLayout(2, 2);
                                        setLayout(encryptlayout);
                                        setSize(400, 400);

                                        Button eb1 = new Button("Vigenere Cipher");
                                        Button eb2 = new Button("RSA Cipher");
                                        Button eb3 = new Button("Encryption Algorithm 3");
                                        Button eb4 = new Button("Encryption Algorithm 4");

                                        add(eb1);
                                        add(eb2);
                                        add(eb3);
                                        add(eb4);

                                        eb1.addActionListener(new ActionListener() 
                                            {
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    if(e.getSource()== eb1)
                                                    {
                                                        VigenereEncrypt vig = new VigenereEncrypt();
                                                        System.out.println(f.getPath());
                                                        vig.vig("t".getBytes());
                                                    }
                                                }
                                            });

                                        eb2.addActionListener(new ActionListener() 
                                            {
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    if(e.getSource()== eb2)
                                                    {
                                                        RSAEncrypt rsa = new RSAEncrypt();
                                                        System.out.println(f.getPath());
                                                        rsa.rsa("t".getBytes());
                                                    }
                                                }
                                            });
                                    }
                                }
                            });
                    }
                }
            });

        b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == b2){
                        System.out.println("pressed decrypt");
                        setVisible(true);
                        remove(logo);
                        remove(b1);
                        remove(b2);

                        GridLayout filelayout = new GridLayout(2, 1);
                        setLayout(filelayout);
                        setSize(400, 400);

                        Button file = new Button("Drag and Drop a File to Decrypt!");
                        Button submit = new Button("Click here once you have uploaded your file.");

                        add(file);
                        add(submit);

                        file.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent e) 
                                {
                                    if(e.getSource()== file)
                                    {
                                        f = new filechooser();
                                    }
                                }
                            });
                            
                        submit.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent e) 
                                {
                                    if(e.getSource()==submit)
                                    {
                                        setVisible(true);
                                        remove(file);
                                        remove(submit);

                                        GridLayout encryptlayout = new GridLayout(2, 2);
                                        setLayout(encryptlayout);
                                        setSize(400, 400);

                                        Button db1 = new Button("Vigenere Cipher");
                                        Button db2 = new Button("RSA Cipher");
                                        Button db3 = new Button("Decryption Algorithm 3");
                                        Button db4 = new Button("Decryption Algorithm 4");

                                        add(db1);
                                        add(db2);
                                        add(db3);
                                        add(db4);

                                        db1.addActionListener(new ActionListener() 
                                            {
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    if(e.getSource()== db1)
                                                    {
                                                        VigenereDecrypt vig = new VigenereDecrypt();

                                                        vig.vig("v".getBytes());
                                                    }
                                                }
                                            });

                                        db2.addActionListener(new ActionListener() 
                                            {
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    if(e.getSource()== db2)
                                                    {
                                                        RSADecrypt rsa = new RSADecrypt();
                                                        rsa.rsa("v".getBytes());
                                                    }
                                                }
                                            });
                                    }
                                }
                            });
                    }
                }
            });
    }
    public byte[] str2ByteArray() throws IOException {
        Path path = Paths.get(filePath);
        byte[] fileContent = Files.readAllBytes(path);
        return fileContent;
    }
}
