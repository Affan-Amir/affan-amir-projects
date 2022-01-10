import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
/*This class is pretty self-explanatory
 * It just creates notifications to send
 */

public class SendNotif implements ActionListener{
 
  JFrame frame = new JFrame("Send Notication to User");
  JPanel panel = new JPanel();
  JButton send = new JButton("Send");
  JLabel notif = new JLabel("Pick the person that you want to send the notification to");
  JLabel status = new JLabel("Pick the status of the book for the person with the book"); 
  //Creating the stuff we're going to use in the frame
  String[] choices = {"Affan", "Apinash", "Diba", "Hilary", "Isaac", "James", "Thomas", "AJ", "Maryam", "Lathushan", "Leonardo"};
  JComboBox cb = new JComboBox(choices);
  //Creates the comboxbox and the choices to choose from it
  String[] otherChoices = {"Signed Out", "Due soon", "Late"};
  JComboBox otherCb = new JComboBox(otherChoices);
  //Creating the other combox box and the choices to choose from it
  String msg, otherMsg;
  
  SendNotif() throws IOException{
     
    Font newFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 22);
    notif.setBounds(25, 5, 600, 25);
    notif.setFont(newFont);
    
    status.setBounds(25, 250, 600, 25);
    status.setFont(newFont);
    //Set the lables
    cb.setSelectedIndex(0);
    cb.addActionListener(this);
    cb.setBounds(250, 75, 100, 25);
    
    otherCb.setSelectedIndex(0);
    otherCb.addActionListener(this);
    otherCb.setBounds(250, 350, 100, 25);
    //Set the comboboxes
    send.setBounds(200, 450, 200, 100);
    send.addActionListener(this);
    //Button for sending
    BufferedImage sendIcon = ImageIO.read(new File("CheckMark.png"));
    Image dimg1 = sendIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    send.setIcon(new ImageIcon(dimg1));
    //Making the checkmark icon
    frame.add(send);
    frame.add(otherCb);
    frame.add(cb);
    frame.add(notif);
    frame.add(status);
    //Adding all that to the frame
    panel.setBackground(Color.YELLOW);
    frame.add(panel);
    frame.setVisible(true);
    frame.setSize(600, 600);
    //Frame info + background colour of panel
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == cb){
      JComboBox comboBox = (JComboBox)e.getSource();
      msg = (String)comboBox.getSelectedItem(); 
      //It doesn't matter what the user picks, we just need to know the choice they do indeed pick
    }
    if (e.getSource() == otherCb){
      JComboBox otherComboBox = (JComboBox)e.getSource();
      otherMsg = (String)otherComboBox.getSelectedItem();
      //It doesn't matter what the user picks, we just need to know the choice they do indeed pick
    }
    if (e.getSource() == send){
      
      try{
        SystemTray tray = SystemTray.getSystemTray();
        //Creating the actual tray that shows in the notification section
        Image image = Toolkit.getDefaultToolkit().createImage("LibLaptop.jpg");
        //The small image that you see in your taskbar is pic chosen here
        TrayIcon trayIcon = new TrayIcon(image, "Affan & Apinash Notification");
        
        trayIcon.setImageAutoSize(true);
        //Rseizes the image if it is needed
        
        trayIcon.setToolTip("Affan and Apinash's Library Manager");
        //Tooltip for the small pic that appears on the taskbar (when you hover over the pic the line above appears)
        tray.add(trayIcon);
        //Add the icon to the tray
        
        //Lines above are constant. Whether the book is due soon, late, signed out whatever the case is, we want it to be constant
        //That's why we can simply leave the trycatch there like normal, but as you can tell the next lines are not like that
        
        if(otherMsg.equals("Due soon") || otherMsg.equals("Signed Out")){
          trayIcon.displayMessage("User", (msg + ", your book's status is: " + otherMsg), MessageType.INFO);
        } 
        //We simply want to send an information message if the book's status is either signed out or due soon, no emergency
        
        if(otherMsg.equals("Late")){
          trayIcon.displayMessage("User", (msg + ", your book's status is: " + otherMsg), MessageType.WARNING);
          //However, if the book is late, that is a problem. 
          //We are no longer simply relaying information at that point, it is an emergency and the notification type assserts that.
        }
      }
      catch(Exception ex){
        System.err.print(ex); 
      } 
    }
  }
}