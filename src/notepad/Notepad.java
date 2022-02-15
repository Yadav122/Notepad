package notepad;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.io.*;


public class Notepad extends JFrame implements ActionListener {
    JTextArea area ;
    JScrollPane pane ;
    String text;
    Container c;
    Notepad(){
        setBounds(0,0,1200,700);

        JMenuBar jMenuBar = new JMenuBar();


        JMenu file = new JMenu("Flie");
        file.setForeground(Color.blue);

        JMenuItem newDoc = new JMenuItem("New");
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        newDoc.addActionListener(this);
        newDoc.setForeground(Color.red);


        JMenuItem open = new JMenuItem("Open");
         open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
         open.addActionListener(this);
         open.setForeground(Color.red);

        JMenuItem save  = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        save.setForeground(Color.red);

        JMenuItem print  = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        print.setForeground(Color.red);

        JMenuItem exit   = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE , 0));
        exit.addActionListener(this);
        exit.setForeground(Color.red);

        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        // create edit j menu
        JMenu edit  = new JMenu("Edit");
        edit.setForeground(Color.blue);

        // create j menu items
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        copy.setForeground(Color.red);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        paste.setForeground(Color.red);

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        cut.setForeground(Color.red);

        JMenuItem setectAll= new JMenuItem("Select All");
        setectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        setectAll.addActionListener(this);
        setectAll.setForeground(Color.red);

        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.add(setectAll);





        JMenu help  = new JMenu("Help");
        help.setForeground(Color.blue);
        JMenuItem about = new JMenuItem("About the Notepad");
        about.addActionListener(this);
        help.add(about);
        about.setForeground(Color.red);
        JMenuItem color = new JMenuItem("Color");
       help.add(color);
       color.setForeground(Color.red);
       color.addActionListener(this);

        jMenuBar.add(file);
        jMenuBar.add(edit);
        jMenuBar.add(help);



        setJMenuBar(jMenuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        area = new JTextArea();
        area.setFont(new Font( "SAN_SERIF", Font.PLAIN, 20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane, BorderLayout.CENTER);

      area.setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

       if (e.getActionCommand().equals("New"))
       {
           area.setText("");
       }
       else if (e.getActionCommand().equals("Save"))
       {
           JFileChooser saveas= new JFileChooser();

           saveas.setApproveButtonText("Save");//----> check karega  ki  JFileChooser mae cancel click kiya hai ya fer Save

           int action = saveas.showOpenDialog(this);

           if (action!=JFileChooser.APPROVE_OPTION){
               return;
           }
           File fileName = new File(saveas.getSelectedFile() +".text");
           BufferedWriter outfile = null;

           try{
               outfile=new BufferedWriter(new FileWriter(fileName));
               area.write(outfile);
           }

           catch (Exception ea){
               ea.printStackTrace();
           }

       }
       else if (e.getActionCommand().equals("Open"))
       {
           JFileChooser chooser = new JFileChooser();
           chooser.setAcceptAllFileFilterUsed(false);

           FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .text files" ,"text");
           chooser.addChoosableFileFilter(restrict);

           int action = chooser.showOpenDialog(this);

           if (action!=JFileChooser.APPROVE_OPTION){
               return;
           }
           File file = chooser.getSelectedFile();

           try{
               BufferedReader reader = new BufferedReader(new FileReader(file));
               area.read(reader,null);
           }
           catch (Exception a)
           {
             a.printStackTrace();
           }
       }
       else  if (e.getActionCommand().equals("Print"))
       {

           try{
               area.print();
           }
           catch (Exception a1)
           {
               a1.printStackTrace();
           }
       }
       else if (e.getActionCommand().equals("Exit")){

           try {
               System.exit(0);
           }
           catch (Exception a2){
               a2.printStackTrace();
           }
       }
       else if (e.getActionCommand().equals("Copy")){

          text = area.getSelectedText();
       }
       else if (e.getActionCommand().equals("Paste")){

           area.insert(text, area.getCaretPosition());
       }
       else if (e.getActionCommand().equals("Cut")){

           text= area.getSelectedText();

           area.replaceRange("" , area.getSelectionStart() , area.getSelectionEnd());
       }
       else if (e.getActionCommand().equals("Select All"))
       {

           area.selectAll();
       }
       else if (e.getActionCommand().equals("About the Notepad")){
             new About().setVisible(true);
       }else if (e.getActionCommand().equals("Color")){
           Color c=JColorChooser.showDialog(this,"Choose",Color.CYAN);
           area.setBackground(c);
       }

    }

    public static void main(String[] args) {


        new Notepad().setVisible(true);
        
    }
}
