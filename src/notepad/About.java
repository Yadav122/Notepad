package notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About  extends JFrame  implements  ActionListener{
    JButton b1 ;
    About(){
          setBounds(600,200,700,600);
          setLayout(null);
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/window.png.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150,40,400,80);
        add(label);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/harsh.jpg"));
        Image i5 = i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel jLabel = new JLabel(i6);
        jLabel.setBounds(50,180,70,70);
        add(jLabel);


        JLabel l3 = new JLabel("<html>Code--> Harsh kumar <br>Code--> version 1.2.2022 <br> All Rigths Reserved <br><br> Notepad is a word processing program <br>which allows changing of text in computer files ,<br>Notepad is simple text editor for editing program <br>which enable computer used to create documents</html> ");
        l3.setBounds(150,130,500,300);
        l3.setFont(new Font("San_Serif" ,Font.PLAIN , 18));
        add(l3);

        b1 = new JButton("Ok");
        b1.setBounds(580,500,80,25);
        add(b1);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
