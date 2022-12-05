package AirPortSystem;
import java.awt.event.*;
import javax.swing.*;

class driver{
    public static void main(String[] args){
       JFrame frame=new JFrame("plane system");
       frame.setSize(200,400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel jp=new JPanel();
       JButton startActionButton=new JButton("start the plane system");
        startActionlistener s=new driver().new startActionlistener();
        startActionButton.addActionListener(s);
        jp.add(startActionButton);
        frame.add(jp);
        frame.setVisible(true);
    }
    private class startActionlistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            landingAndTakeOff.run();
        }
    }
}