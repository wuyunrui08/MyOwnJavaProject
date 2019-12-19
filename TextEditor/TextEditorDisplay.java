package TextEditors;
import javax.swing.*;
import java.awt.*;
public class TextEditorDisplay extends JFrame{

    JMenuItem item1,item2,item3,item4,itemHelp;
    JTextArea jTextArea;

    private JMenuBar menuBar;
    private JMenu menuFiles,menuHelp;
    private JScrollPane jScrollPane;
    boolean flag=false;
    String filePath;

    static final int WIDE=640;
    static final int HEIGHT =500;

    TextEditorDisplay(){

        super("MyEditor");
        filePath=null;
        menuBar=new JMenuBar();
        jScrollPane=new JScrollPane();
        jTextArea=new JTextArea();

        menuFiles=new JMenu("Files");
        menuHelp = new JMenu("Help");

        //menu list init

        item1=new JMenuItem("Open");
        item2=new JMenuItem("Save");
        item3=new JMenuItem("Save as ...");
        item4=new JMenuItem("Exit");
        itemHelp=new JMenuItem("Version");

        //actionEventAdd
        item1.addActionListener(new TextEditorsAction(this));
        item2.addActionListener(new TextEditorsAction(this));
        item3.addActionListener(new TextEditorsAction(this));
        item4.addActionListener(new TextEditorsAction(this));
        itemHelp.addActionListener(new TextEditorsAction(this));
        jTextArea.getDocument().addDocumentListener(new IfSaveAction(this));
        addWindowListener(new CloseAction(this));

        menuFiles.add(item1);
        menuFiles.add(item2);
        menuFiles.add(item3);
        menuFiles.add(new JSeparator());
        menuFiles.add(item4);
        menuHelp.add(itemHelp);

        jScrollPane.setViewportView(jTextArea);

        //framework add
        menuBar.add(menuFiles);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);
        add(menuBar,BorderLayout.NORTH);
        add(jScrollPane,BorderLayout.CENTER);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocation(200,150);
        jTextArea.setFont(new Font("宋体",Font.PLAIN,20));//设置字体大小
        setSize(WIDE, HEIGHT);
        setVisible(true);
    }

}
