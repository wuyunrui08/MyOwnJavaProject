package TextEditors;

import javax.swing.*;
import java.awt.event.*;

public class TextEditorsAction implements ActionListener {
    private TextEditorDisplay _TED;

    TextEditorsAction(TextEditorDisplay t) {
        _TED = t;
    }

    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Open"://open file
                OptionAction.OpenFile(_TED,_TED.filePath);
                break;
            case "Save":
                OptionAction.SaveFile(_TED, _TED.filePath);
                break;
            case "Save as ...":
                OptionAction.SaveFileAs(_TED, _TED.filePath);
                break;
            case "Exit"://exit the edit
                OptionAction.ExitProgram(_TED, _TED.filePath);
                break;
            case "Version":
                JOptionPane.showMessageDialog(
                        null,
                        "wuyunrui make",
                        "version 1.0",
                        JOptionPane.INFORMATION_MESSAGE
                );
        }
    }

}
