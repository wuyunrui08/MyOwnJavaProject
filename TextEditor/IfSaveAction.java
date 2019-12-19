package TextEditors;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class IfSaveAction implements DocumentListener {
    TextEditorDisplay _TED;

    IfSaveAction(TextEditorDisplay t) {
        _TED = t;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        _TED.flag = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        _TED.flag = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        _TED.flag = true;
    }
}
