import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.util.*;

/* This is a pretty self explanatory frame
 * Add books and then transfre them to the sign out books window
 */
public class AddBooksWindow implements ActionListener{
  public String hello = "This is a private string";
  JFrame frame = new JFrame("Add Books Window");
  JButton cover1 = new JButton("Add Cover for book 1");
  JButton cover2 = new JButton("Add Cover for book 2");
  JButton cover3 = new JButton("Add Cover for book 3");
  JButton cover4 = new JButton("Add Cover for book 4");
  JButton cover5 = new JButton("Add Cover for book 5");
  JButton cover6 = new JButton("Add Cover for book 6");
  //These buttons will allow you to choose covers for each of the 6 books you are allowed to sign out
  JButton confirm1 = new JButton("Confirm 1");
  JButton confirm2 = new JButton("Confirm 2");
  JButton confirm3 = new JButton("Confirm 3");
  JButton confirm4 = new JButton("Confirm 4");
  JButton confirm5 = new JButton("Confirm 5");
  JButton confirm6 = new JButton("Confirm 6");
  JButton onToNextPage = new JButton("Transfer");
  //Buttons that can confirm
  
  String book1, book2, book3, book4, book5, book6;
  String path1, path2, path3, path4, path5, path6;
  String fileName1, fileName2, fileName3, fileName4, fileName5, fileName6;
  JTextField bookName1, bookName2, bookName3, bookName4, bookName5, bookName6;
  //We're 
  File file1, file2, file3, file4, file5, file6;
  // Scanner fileIn;
  int response;
  
  SignOutBooksWindow sobw = new SignOutBooksWindow();

  AddBooksWindow(){
    
 
    
    
    bookName1 = new JTextField("Enter Book Name 1 here", 20);
    bookName1.setBounds(5, 5, 165, 25);
    frame.add(bookName1);
    //Textfield for entering the name of the first book
    
    bookName2 = new JTextField("Enter Book Name 2 here", 20);
    bookName2.setBounds(5, 75, 165, 25);
    frame.add(bookName2);
    //Textfield for entering the name of the first book
    
    bookName3 = new JTextField("Enter Book Name 3 here", 20);
    bookName3.setBounds(5, 145, 165, 25);
    frame.add(bookName3);
    //Textfield for entering the name of the first book
    
    bookName4 = new JTextField("Enter Book Name 4 here", 20);
    bookName4.setBounds(5, 215, 165, 25);
    frame.add(bookName4);
    //Textfield for entering the name of the first book
    
    bookName5 = new JTextField("Enter Book Name 5 here", 20);
    bookName5.setBounds(5, 285, 165, 25);
    frame.add(bookName5);
    //Textfield for entering the name of the first book
    
    bookName6 = new JTextField("Enter Book Name 6 here", 20);
    bookName6.setBounds(5, 355, 165, 25);
    frame.add(bookName6);
    //Textfield for entering the name of the first book
    
    cover1.setBounds(175, 5, 180, 25);
    cover1.addActionListener(this);
    frame.add(cover1);
    
    cover2.setBounds(175, 75, 180, 25);
    cover2.addActionListener(this);
    frame.add(cover2);
    
    cover3.setBounds(175, 145, 180, 25);
    cover3.addActionListener(this);
    frame.add(cover3);
    
    cover4.setBounds(175, 215, 180, 25);
    cover4.addActionListener(this);
    frame.add(cover4);
    
    cover5.setBounds(175, 285, 180, 25);
    cover5.addActionListener(this);
    frame.add(cover5);
    
    cover6.setBounds(175, 355, 180, 25);
    cover6.addActionListener(this);
    frame.add(cover6);
    
    //Abocve are all the buttons that allow you to choose the cover for the books that you would like to insert into the program. 
    
    confirm1.setBounds(400, 5, 150, 25);
    confirm1.addActionListener(this);
    frame.add(confirm1);
    
    confirm2.setBounds(400, 75, 150, 25);
    confirm2.addActionListener(this);
    frame.add(confirm2);
    
    confirm3.setBounds(400, 145, 150, 25);
    confirm3.addActionListener(this);
    frame.add(confirm3);
    
    confirm4.setBounds(400, 215, 150, 25);
    confirm4.addActionListener(this);
    frame.add(confirm4);
    
    confirm5.setBounds(400, 285, 150, 25);
    confirm5.addActionListener(this);
    frame.add(confirm5);
    
    confirm6.setBounds(400, 355, 150, 25);
    confirm6.addActionListener(this);
    frame.add(confirm6);
    
    //Above are all the confirm buttons. When you click those buttons the pgroram is going to fetch the text you have written in the textfield, and use those as titles
    
    onToNextPage.setBounds(575, 210, 100, 25); 
    onToNextPage.addActionListener(this);
    frame.add(onToNextPage);
    
    //The onToNextPage button is going to transfer all the information that you just entered into the window in which you can sign out books. The frame will dispose.
    
    frame.setLocation(0, 0);
    frame.getContentPane().setBackground(Color.GREEN);
    frame.setSize(700, 420);
    frame.setLayout(null);
    frame.setVisible(true);
    //Some frame info
  }  
  @Override
  public void actionPerformed(ActionEvent e){
    //ALL BLOCKS OF CODE HERE ARE PRETTY SIMILAR, SO I ADDED ONE COMMENTED VERSION WHICH IS THE LAST ONE
    if(e.getSource()== cover1){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path1 = chooser.getSelectedFile().getAbsolutePath();
      fileName1 = chooser.getSelectedFile().getName();
      
    }
    if(e.getSource()== cover2){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path2 = chooser.getSelectedFile().getAbsolutePath();
      fileName2 = chooser.getSelectedFile().getName();
    }
    if(e.getSource()== cover3){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path3 = chooser.getSelectedFile().getAbsolutePath();
      fileName3 = chooser.getSelectedFile().getName();
    }
    if(e.getSource()== cover4){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path4 = chooser.getSelectedFile().getAbsolutePath();
      fileName4 = chooser.getSelectedFile().getName();
    }
    if(e.getSource()== cover5){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path5 = chooser.getSelectedFile().getAbsolutePath();
      fileName5 = chooser.getSelectedFile().getName();
    }
    if(e.getSource()== cover6){
      JFileChooser chooser = new JFileChooser(".");
      
      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      response = chooser.showOpenDialog(null);
      
      path6 = chooser.getSelectedFile().getAbsolutePath();
      fileName6 = chooser.getSelectedFile().getName();
    }
    //Every single if statement from that beginning to now are all doing the same thing, allowing user to pick a file, then fetching the exact name of the file so that
    //We can then send that information to be opened later in the new frame.
    
    if(e.getSource ()== confirm1){
      book1 = bookName1.getText();
      //Get the text on confirm
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 1 has been added as '" + book1 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== confirm2){
      book2 = bookName2.getText();
      //Getting title of book2
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 2 has been added as '" + book2 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== confirm3){
      book3 = bookName3.getText();
      //Getting title of book3
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 3 has been added as '" + book3 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== confirm4){
      book4 = bookName4.getText();
      //Getting title of book4
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 4 has been added as '" + book4 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== confirm5){
      book5 = bookName5.getText();
      //Getting title of book 5
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 5 has been added as '" + book5 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== confirm6){
      book6 = bookName6.getText();
      //Getting title of book 6.
      
      //LINES BELOW ARE SO FOR THE WINDOWS NOTIFICATION YOU RECIEVE AFTER PRESSING CONFIRM BUTTON
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
        
        trayIcon.displayMessage("Book added", ("Book 6 has been added as '" + book6 + "'"), MessageType.INFO);
        //Display this info
      }
      catch(Exception ex){
        System.err.print(ex); 
      }
    }
    if(e.getSource ()== onToNextPage){
      try{
        
        sobw.openFile(fileName1, fileName2, fileName3, fileName4, fileName5, fileName6, book1, book2, book3, book4, book5, book6); 
      }
      //Essentially, what we're doing is here is since that the frame is already open, we can just now update it with the information we use as paraemeters.
      
      catch(IOException ex){
        System.out.println("Invalid"); 
      }
      frame.dispose();
    }
  }
}
