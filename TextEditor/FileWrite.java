package TextEditors;
import javax.swing.*;
import java.io.*;

public class FileWrite {
    private TextEditorDisplay _TED;
    public FileWrite(TextEditorDisplay t){
        _TED=t;
    }
    public void writeFile(String filePath) {
        try {
            var outfile=new File(filePath);
            outfile.createNewFile();
            var writer=new FileWriter(outfile);
            var out=new BufferedWriter(writer);

            out.write(_TED.jTextArea.getText());//写文件
            out.flush();//缓冲区内容压入文件中

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File write error",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void readFile(String filePath) {
        _TED.jTextArea.removeAll();
        try (FileReader reader=new FileReader(filePath);
        BufferedReader br=new BufferedReader(reader)){

            String line;
            _TED.jTextArea.setText("");
            //读一行，设置到文本区中
            while((line=br.readLine())!=null)
                _TED.jTextArea.setText(_TED.jTextArea.getText()+line+'\n');


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File read error",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
