import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

class MyDragDropListener implements DropTargetListener {
    @Override
    public synchronized void drop(DropTargetDropEvent event) {
//        // Accept copy drops
//
//        // Get the transfer which can provide the dropped item data
//        //Transferable transferable = ;
//
//        // Get the data formats of the dropped item
//        //DataFlavor[] flavors = transferable.getTransferDataFlavors();
//
//        // Loop through the flavors
//        try {
//            event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
//            File a = (File) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
//            Path c = Path.of(a.getPath());
//            System.out.println(c.toString());
//        }
//        catch (Exception e) {
//            // Print out the error stack
//            e.printStackTrace();
//        }
//
//        // Inform that the drop is complete
//        event.dropComplete(true);
        // Accept copy drops
        event.acceptDrop(DnDConstants.ACTION_COPY);

        // Get the transfer which can provide the dropped item data
        Transferable transferable = event.getTransferable();

        // Get the data formats of the dropped item
        DataFlavor[] flavors = transferable.getTransferDataFlavors();

        // Loop through the flavors
        for (DataFlavor flavor : flavors) {

            try {

                // If the drop items are files
                if (flavor.isFlavorJavaFileListType()) {

                    // Get all of the dropped files
                    List files = (List) transferable.getTransferData(flavor);
                    System.out.println(files);
                    // Loop them through
                    // Print out the file path
                    //for (File file : files) System.out.println("File path is '" + file.getPath() + "'.");

                }

            } catch (Exception e) {

                // Print out the error stack
                e.printStackTrace();

            }
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