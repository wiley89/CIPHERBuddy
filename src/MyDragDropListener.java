import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DnDConstants;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.awt.List;
import java.util.*;

class MyDragDropListener implements DropTargetListener {
    @Override
    public synchronized void drop(DropTargetDropEvent event) {
        // Accept copy drops

        // Get the transfer which can provide the dropped item data
        //Transferable transferable = ;

        // Get the data formats of the dropped item
        //DataFlavor[] flavors = transferable.getTransferDataFlavors();

        // Loop through the flavors
        try {
            event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
            ArrayList<File> file = (ArrayList<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            System.out.println("File path is '" + file.get(0).getPath() + "'.");
        }
        catch (Exception e) {
            // Print out the error stack
            e.printStackTrace();
        }

        // Inform that the drop is complete
        event.dropComplete(true);
    }

    @Override
    public void dragEnter(DropTargetDragEvent event)
    {
    }

    @Override
    public void dragExit(DropTargetEvent event) 
    {
    }

    @Override
    public void dragOver(DropTargetDragEvent event) 
    {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent event) {
    }

}