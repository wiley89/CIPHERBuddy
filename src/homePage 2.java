
/**
 * Write a description of class homepage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.Scanner;

import java.awt.dnd.DropTarget;

public class homePage extends JFrame
{
    public static void main(String[] args)
    {
        homePage homepage = new homePage();
    }

    public homePage()
    {
        // home page
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout homelayout = new GridLayout(2, 1);
        setLayout(homelayout);
        setTitle("CSDS 344 Team 10 Encryption/ Decryption Algorithms");
        setSize(200, 200);

        Button b1 = new Button("Encrypt");
        Button b2 = new Button("Decrypt");

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
                        remove(b1);
                        remove(b2);

                        GridLayout filelayout = new GridLayout(2, 1);
                        setLayout(filelayout);
                        setSize(200, 200);

                        Button file = new Button("Drag and Drop a File to Encrypt!");
                        Button submit = new Button("Click here once you have uploaded your file.");

                        add(file);
                        add(submit);

                        MyDragDropListener inputFile = new MyDragDropListener();
                        new DropTarget(file, inputFile); 
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
                                        setSize(200, 200);

                                        Button eb1 = new Button("Encryption Algorithm 1");
                                        Button eb2 = new Button("Encryption Algorithm 2");
                                        Button eb3 = new Button("Encryption Algorithm 3");
                                        Button eb4 = new Button("Encryption Algorithm 4");

                                        add(eb1);
                                        add(eb2);
                                        add(eb3);
                                        add(eb4);
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
                        remove(b1);
                        remove(b2);

                        GridLayout filelayout = new GridLayout(2, 1);
                        setLayout(filelayout);
                        setSize(200, 200);

                        Button file = new Button("Drag and Drop a File to Decrypt!");
                        Button submit = new Button("Click here once you have uploaded your file.");

                        add(file);
                        add(submit);

                        MyDragDropListener inputFile = new MyDragDropListener();
                        new DropTarget(file, inputFile); 
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
                                        setSize(200, 200);

                                        Button db1 = new Button("Decryption Algorithm 1");
                                        Button db2 = new Button("Decryption Algorithm 2");
                                        Button db3 = new Button("Decryption Algorithm 3");
                                        Button db4 = new Button("Decryption Algorithm 4");

                                        add(db1);
                                        add(db2);
                                        add(db3);
                                        add(db4);
                                    }
                                }
                            });
                    }
                }
            });
    }
}
