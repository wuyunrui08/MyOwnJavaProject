package TextEditors;

import javax.swing.*;
import java.io.File;

public class OptionAction {
    public static void OpenFile(TextEditorDisplay t,String filePath){
        JFileChooser jFile=new JFileChooser();
        jFile.setCurrentDirectory(new File("."));
        int result = jFile.showOpenDialog(new JButton("Open"));
        t.filePath = jFile.getSelectedFile().getPath();
        if (result == 0) {
            new FileWrite(t).readFile(t.filePath);
        }
    }
    public static void SaveFile(TextEditorDisplay t,String filePath){
        t.flag=false;
        if (t.filePath != null)
            new FileWrite(t).writeFile(t.filePath);
        else
            JOptionPane.showMessageDialog(null,
                    "File save error",
                    "File error",
                    JOptionPane.ERROR_MESSAGE
            );
    }
    public static void SaveFileAs(TextEditorDisplay t,String filePath){
        JFileChooser jFile = new JFileChooser();
        jFile.setCurrentDirectory(new File("."));
        t.flag=false;
        int result = jFile.showSaveDialog(new JButton("Save"));
        t.filePath = jFile.getSelectedFile().getPath();
        if (result == 0) {
            new FileWrite(t).writeFile(t.filePath);
        }
    }
    public static void ExitProgram(TextEditorDisplay t,String filePath){
        int choice;
        if(t.flag) {
            JOptionPane.showMessageDialog(null,
                    "You must save the file!!",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE
                    );
            choice=JOptionPane.showConfirmDialog(null,
                    "Save file?",
                    "Save",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if(choice==0){
                OptionAction.SaveFileAs(t,filePath);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Program will exit.....",
                        "Exit",
                        JOptionPane.WARNING_MESSAGE
                );
                System.exit(0);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Program will exit....."
            );
            System.exit(0);
        }
    }
}
