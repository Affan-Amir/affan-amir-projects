import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

/* After a successful login you'll end up here
 * Which will provide you with 3 diff options
 */
public class AdminWindow implements ActionListener{
  
  JFrame frame = new JFrame("Admin Window");
  JLabel background1;
  JLabel label = new JLabel("Welcome Mr. Chu!!!");
  JButton addBooks = new JButton("Add books");
  JButton sendNotif = new JButton("Send Notif");
  JButton logOut = new JButton("Log out");
  //All the components we need
  AdminWindow(){
    
    label.setBounds(25, 0, 150, 50);
    label.setFont(new Font("Times new Roman", Font.BOLD, 15));
    
    addBooks.setBounds(25, 50, 150, 50);
    addBooks.setBackground(Color.BLACK);
    addBooks.setForeground(Color.WHITE);
    addBooks.addActionListener(this);
    
    sendNotif.setBounds(25, 175, 150, 50);
    sendNotif.setBackground(Color.BLACK);
    sendNotif.setForeground(Color.WHITE);
    sendNotif.addActionListener(this);
    
    logOut.setBounds(25, 300, 150, 50);
    logOut.setBackground(Color.BLACK);
    logOut.setForeground(Color.WHITE);
    logOut.addActionListener(this);
    
    frame.add(addBooks);
    frame.add(sendNotif);
    frame.add(logOut);
    frame.add(label);
    
    //All blocks of code did the same thing, create the component and then add it where it needs to be added
    
    frame.setLocation(0, 375);
    frame.getContentPane().setBackground(Color.CYAN);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 395);
    frame.setLayout(null);
    frame.setVisible(true);    
    //Frame info
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource()== addBooks){
      AddBooksWindow addBooksWindow = new AddBooksWindow();
    }
    if(e.getSource()== sendNotif){
      try{
      SendNotif sendNotif = new SendNotif(); 
      }
      catch(IOException ex){
       System.out.print("Error"); 
      }
    }
    if(e.getSource()== logOut){
      try{
        frame.dispose();
        finalAssignment finalAssignment = new finalAssignment();
      }
      catch(IOException ex){
        System.out.println("Invalid"); 
      }
    }
  }
  //What this chunk of code is doing is taking you to the page that you click on (ie, sendNotif button takes you to sendNotif file)
}