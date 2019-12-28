package MyDigitalHuarongRoad;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

//事件响应
public class DisplayAction implements ActionListener {
    Display _D;
    DisplayAction(Display d){
        _D=d;
    }
    //重要：移动之前怎样知道要移动的下一个没有按钮
    public void actionPerformed(ActionEvent a) {
        if(a.getSource()==_D.versionButton)
            JOptionPane.showMessageDialog(null,
                    "wuyunrui make",
                    "Version",
                    JOptionPane.INFORMATION_MESSAGE
                    );
        else if (a.getSource() == _D.exitButton)
            System.exit(0);
        else if (a.getSource() == _D.startButton) {
            _D.ifStart=true;
            ArrayList<Integer> ans= new ArrayList<>();
            Random r1=new Random();
            do {
                int num = r1.nextInt(15) + 1;
                if (!ans.contains(num)) {
                    ans.add(num);
                }
            } while (ans.size() < 15);
            for(int i=0;i<_D.inSideButton.length-1;i++){
                _D.inSideButton[i].setText(String.valueOf(ans.get(i)));
            }
            _D.inSideButton[15].setText("");
            _D.whiteID=15;
            ans.clear();
        } else {
            if (_D.ifStart) {
                for (int i = 0; i < 16; i++) {
                    if (a.getSource() == _D.inSideButton[i]) {
                        if (ifCanMove(_D.inSideButton[i], _D.inSideButton[_D.whiteID])) {
                            MoveButton(_D.inSideButton[i], _D.inSideButton[_D.whiteID]);
                            _D.whiteID = i;
                        }
                    }
                }
            }
            if (ifWin()) {
                JOptionPane.showMessageDialog(null,
                        "You Win!!",
                        "You are a winner",
                        JOptionPane.INFORMATION_MESSAGE
                );
                _D.ifStart=false;
            }

        }
        if(!_D.ifStart){
            JOptionPane.showMessageDialog(null,
                    "请开始游戏",
                    "开始游戏",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    boolean ifCanMove(JButton b,JButton white) {
        if ((b.getX() - _D.sideX == white.getX() || b.getX() + _D.sideX == white.getX()) &&b.getY()==white.getY()) {
            return true;
        }
        else
            return (b.getY() - _D.sideY == white.getY() || b.getY() + _D.sideY == white.getY()) && b.getX() == white.getX();
    }
    void MoveButton(JButton b,JButton white){
        String str=b.getText();
        white.setText(str);
        b.setText("");
    }
    boolean ifWin(){
        for(int i=1;i<=15;i++){
            if(!_D.inSideButton[i - 1].getText().equals(String.valueOf(i))){
                return false;
            }
        }
        return true;
    }

}
