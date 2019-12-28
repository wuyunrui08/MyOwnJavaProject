package MyDigitalHuarongRoad;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class MenuBarAction implements ActionListener {
    Display _D;
    MenuBarAction(Display t){
        _D=t;
    }
    public void actionPerformed(ActionEvent a){
        if(a.getActionCommand().equals("Easy going")){
            JOptionPane.showMessageDialog(null,
                    "1.点击“Start”按钮开始\n" +
                            "2.点击“Exit”退出\n" +
                            "3.当你移动滑块成顺序（1,2,3...15）的时候，获胜",
                    "Easy going",
                    JOptionPane.INFORMATION_MESSAGE
                    );
        }
        else if(a.getActionCommand().equals("Version")){
            JOptionPane.showMessageDialog(null,
                    "WuYunrui Yes!!!",
                    "Version",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
