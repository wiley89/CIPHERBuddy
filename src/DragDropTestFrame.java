
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetListener;

public class DragDropTestFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        // Create our frame
        new DragDropTestFrame();

    }

    public DragDropTestFrame() {

        // Set the frame title
        super("Drag and drop test");

        // Set the size
        this.setSize(250, 150);

        // Create the label
        JLabel myLabel = new JLabel("Drag something here!", SwingConstants.CENTER);

        // Create the drag and drop listener
        MyDragDropListener myDragDropListener = new MyDragDropListener();

        // Connect the label with a drag and drop listener
        new DropTarget(myLabel, myDragDropListener);

        // Add the label to the content
        this.getContentPane().add(BorderLayout.CENTER, myLabel);

        // Show the frame
        this.setVisible(true);

    }

}