import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class filechooserActionListener implements ActionListener {
    private filechooser fc;

    @Override
    public void actionPerformed(ActionEvent e) {
            fc.fileChooser();
    }

    public String getFP()
    {
        return fc.getPath();
    }
}
