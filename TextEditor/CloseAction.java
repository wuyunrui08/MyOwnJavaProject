package TextEditors;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseAction extends WindowAdapter {
    TextEditorDisplay _TED;
    CloseAction(TextEditorDisplay t){
        _TED=t;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        //super.windowClosing(e);
        if(_TED.flag) {
            OptionAction.ExitProgram(_TED,_TED.filePath);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Program will exit....."
            );
            System.exit(0);
        }
    }
}
