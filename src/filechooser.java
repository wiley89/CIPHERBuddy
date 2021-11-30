// Java program to create open or
// save dialog using JFileChooser

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class filechooser extends JFrame implements ActionListener {

    // Jlabel to show the files user selects
    static JLabel l;
    private String path;

    // a default constructor

    public filechooser() {
        // frame to contains GUI elements
        JFrame f = new JFrame("file chooser");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog
        // button to open open dialog
        JButton button2 = new JButton("open");

        // make an object of the class filechooser

        // add action listener to the button to capture user
        // response on buttons
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if(r ==JFileChooser.APPROVE_OPTION)

            {
                // set the label to the path of the selected file
                l.setText(j.getSelectedFile().getAbsolutePath());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                path = l.getText();
                System.out.println(path);
            }
            // if the user cancelled the operation
            else
                    l.setText("the user cancelled the operation");
        }});

        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("hello");
                f.setVisible(false);
            }
        });
        // make a panel to add the buttons and labels
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button2);


        // set the label to its initial value
        l = new JLabel("no file selected");
        p.add(submitButton);

        // add panel to the frame
        p.add(l);
        f.add(p);


    }

    public void actionPerformed(ActionEvent evt) {
        // create an object of JFileChooser class
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected file
            l.setText(j.getSelectedFile().getAbsolutePath());
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            path = l.getText();
            System.out.println(path);
        }
        // if the user cancelled the operation
        else
            l.setText("the user cancelled the operation");
    }

    public String getPath() {
        return path;
    }
}
