import javax.swing.*;  
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 


public class SignOutBooksWindow implements ActionListener{
  
  JFrame frame = new JFrame("Sign Out Window");
  JPanel panel = new JPanel();
  //Adding a panel and a frame
  
  JButton button1, button2, button3, button4, button5, button6;
  JButton checkout = new JButton("Checkout");
  //Buttons
  
  JTextField book, user;
  //Textfields
  JPasswordField password;
  //Password Field
  JLabel label1, label2, label3, label4, label5, label6, passLabel;
  //Create labels
  Font myFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 18); 
  //Font that some of my labels use.
  public SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
  //This is the format that we are going to have the time set it.
  String string, otherString;
  String msg, othermsg;
  int num1, num2;
  //Numbers for value of time
  JLabel status, belowStatus;
  int print; 
  //Print for time elapsed
  HashMap<String, String> loginInfo = new HashMap<String, String>();
  //HashMap for login
  
  //Above are all the info we need to start the frame 
  
  public SignOutBooksWindow(){
    
    
    
    book = new JTextField("Enter Book Name Here", 20);
    book.setBounds(25, 15, 225, 25);
    frame.add(book);
    //Adding the textfield that takes in the book input
    user = new JTextField("Enter Your Username Here", 20);
    user.setBounds(25, 100, 225, 25);
    frame.add(user);
    //Adding the textfield that takes in the username
    password = new JPasswordField("Enter Your Password Here", 20);
    password.setBounds(25, 200, 225, 25);
    frame.add(password);
    //Adding the textfield that takes in the password
    
    
    checkout.setBounds(25, 400, 225, 25);
    checkout.addActionListener(this);
    frame.add(checkout);
    //Adding the checkout button
    
    label1 = new JLabel(" ");
    label1.setBounds(300, 355, 100, 25);
    label1.setFont(myFont);
    frame.add(label1);
    
    label2 = new JLabel(" ");
    label2.setFont(myFont);
    label2.setBounds(300, 105, 100, 25);
    frame.add(label2);
    
    label3 = new JLabel(" ");
    label3.setFont(myFont);
    label3.setBounds(300, 605, 100, 25);
    frame.add(label3);
    
    label4 = new JLabel(" ");
    label4.setFont(myFont);
    label4.setBounds(500, 355, 100, 25);
    frame.add(label4);
    
    label5 = new JLabel(" ");
    label5.setFont(myFont);
    label5.setBounds(500, 110, 100, 25);
    frame.add(label5);
    
    label6 = new JLabel(" ");
    label6.setFont(myFont);
    label6.setBounds(500, 600, 100, 25);
    frame.add(label6);
    //Above are all the different labels for the books. Each of the labels contains the name of the book that you entered in the add books window. 
    
    passLabel = new JLabel("Enter Password");
    passLabel.setBounds(25, 250, 225, 25);
    frame.add(passLabel);
    
    Font myNewFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 12);
    status = new JLabel(" ");
    status.setFont(myNewFont);
    status.setBounds(0, 450, 300, 200);
    frame.add(status);
    
    belowStatus = new JLabel(" ");
    belowStatus.setFont(myNewFont);
    belowStatus.setBounds(0, 475, 300, 200);
    frame.add(belowStatus);
    
    //Status and belowStatus are going to change depending on whether you submit the book on time or not. 
    
    frame.setLocation(700, 0);
    frame.setSize(700, 700);
    frame.getContentPane().setBackground(Color.RED);
    frame.setLayout(null);
    frame.setVisible(true);
    //Setting some of the information that the frame needs to work.
  }  
  public void openFile(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l) throws IOException{
    //ALL BLOCKS OF CODE HERE ARE SIMILAR SO I WILL ADD ONE LARGE COMMENT AT THE END OF THEM ALL TO EXPLAIN ALL OF THEM
    BufferedImage buttonIcon1 = ImageIO.read(new File(a));
    Image dimg1 = buttonIcon1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button1 = new JButton();
    button1.setIcon(new ImageIcon(dimg1));
    button1.setBounds(300, 250, 100, 100);
    button1.addActionListener(this);
    frame.add(button1);
    
    label1.setText(g);
    frame.add(label1);
    
    BufferedImage buttonIcon2 = ImageIO.read(new File(b));
    Image dimg2 = buttonIcon2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button2 = new JButton();
    button2.setIcon(new ImageIcon(dimg2));
    button2.setBounds(300, 5, 100, 100);
    button2.addActionListener(this);
    frame.add(button2);
    
    label2.setText(h);
    frame.add(label2);
    
    BufferedImage buttonIcon3 = ImageIO.read(new File(c));
    Image dimg3 = buttonIcon3.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button3 = new JButton();
    button3.setIcon(new ImageIcon(dimg3));
    button3.setBounds(300, 500, 100, 100);
    button3.addActionListener(this);
    frame.add(button3);
    
    label3.setText(i);
    frame.add(label3);
    
    BufferedImage buttonIcon4 = ImageIO.read(new File(d));
    Image dimg4 = buttonIcon4.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button4 = new JButton();
    button4.setIcon(new ImageIcon(dimg4));
    button4.setBounds(500, 250, 100, 100);
    button4.addActionListener(this);
    frame.add(button4);
    
    label4.setText(j);
    frame.add(label4);
    
    BufferedImage buttonIcon5 = ImageIO.read(new File(e));
    Image dimg5 = buttonIcon5.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button5 = new JButton();
    button5.setIcon(new ImageIcon(dimg5));
    button5.setBounds(500, 5, 100, 100);
    button5.addActionListener(this);
    frame.add(button5);
    
    label5.setText(k);
    frame.add(label5);
    
    BufferedImage buttonIcon6 = ImageIO.read(new File(f));
    Image dimg6 = buttonIcon6.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    button6 = new JButton();
    button6.setIcon(new ImageIcon(dimg6));
    button6.setBounds(500, 500, 100, 100);
    button6.addActionListener(this);
    frame.add(button6);
    
    label6.setText(l);
    frame.add(label6);
    /*What the above is doing is taking the file that we get from the Add Books Window, opening it, resizing it, and then we are going to add the labels, which are from
     * The last window that you had opened, and we're going to take the title of the book and put it directly under the icon right where you saw it. Repeat x6 for each button.
     * Every single block of code is the same thing, with different variables names so there is no need to comment under all of them.
     */
  }
  @Override
  public void actionPerformed(ActionEvent e){
    //A LOT OF THESE IF STATEMENTS ARE VERY SIMILAR, SO I'M GOING TO DESCRIBE ALL OF THEM AT ONCE AT THE VERY LAST BUTTON ACTIONLISTENER
    //I REPEAT, THE COMMENTS FOR ALL OF THESE BUTTONS ARE THE SAME, SO THEY'RE ALL AT THE LAST BUTTON ACTIONLISTENER
    if(e.getSource() == button1){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      System.out.println(print);
      if(print <= 60){
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming!");
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page and send an email"); 
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
      }
    }
    
    if(e.getSource() == button2){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      System.out.println(print);
      if(print <= 60){
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page and send an email"); 
        belowStatus.setText("Be more responsible!");
      }
    }
    if(e.getSource() == button3){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      System.out.println(print);
      if(print <= 60){
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page and send an email"); 
        belowStatus.setText("Be more responsible!");
      }
    }
    if(e.getSource() == button4){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      System.out.println(print);
      if(print <= 60){
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page and send an email"); 
        belowStatus.setText("Be more responsible!");
      }
    }
    if(e.getSource() == button5){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      System.out.println(print);
      if(print <= 60){
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page and send an email"); 
        belowStatus.setText("Be more responsible!");
      }
    }
    
    if(e.getSource() == button6){
      String bookname = book.getText();
      
      String nameA = user.getText();
      
      Date otherDate = new Date();  
      otherString = (formatter.format(otherDate));  
      System.out.println(otherString);
      othermsg = otherString.substring(3,5)+otherString.substring(6);
      System.out.println(othermsg);
      num2 = Integer.parseInt(othermsg);
      print = num2-num1;
      
      //Scroll down and you can find how num1 was derived, here I will talk about num2. 
      //We are taking the values of the time(line 304), and then making them a int( line 306). Therefore, if we can subtract time returned by time checked out
      //We can get the total time the book was signed out, in an int, where 1 = 1 second.
      System.out.println(print);
      //I am printing out the print value so you can see how long the book was signed out for. 
      if(print <= 60){
        //As the comment above explains, 1 print val = 1 second. This means that if the user takes less than 60 seconds, the book is on time. So the user has 60s with the book.
        status.setText(bookname + " was returned on time by " + nameA);
        belowStatus.setText("Thank's for coming! Book was signed out for " + print +"s");
        
        //Thank user for coming if they submit the book on time.
      }
      else{
        status.setText(bookname + " was returned late by " + nameA + " go into 'Send Notif' page"); 
        belowStatus.setText("Be more responsible!");
        //We use the else statement to determine that if time signed out is more than the 60 seconds allowed
        //If the book is late tell admin to use notification page
      }
    }
    if(e.getSource() == checkout){
      
      Date date = new Date();  
      String string = (formatter.format(date));  
      System.out.println(string);
      String msg = string.substring(3,5)+string.substring(6);
      System.out.println(msg);
      num1 = Integer.parseInt(msg);
      System.out.println(num1); 
      //The first number is going to be the time when the button is pressed. For example, if the button is pressed at 01:14
      //Then the number is 0114(or 114)
      
      //ATTENTION, ATTENTION, ATTENTION
      //I DECIDED TO PRINT OUT THE NUMBERS ON THE CONSOLE TO SHOW YOU HOW THE TIMER SYSTEM WORKED.
      //IT IS NOT NECCESSARY TO HAVE THEM DISPLAYED ON THE CONSOLE FOR OUR PROJECT
      
      loginInfo.put("Affan", "Amir");
      loginInfo.put("Diba", "Alam");
      loginInfo.put("Isaac", "Barclay");
      loginInfo.put("Lathushan", "Kanthasamy");
      loginInfo.put("Maryam", "Khan");
      loginInfo.put("AJ", "Kleiman");
      loginInfo.put("Leonardo", "Lai");
      loginInfo.put("James", "Liang");
      loginInfo.put("Apinash", "Sivaganesan");
      loginInfo.put("Hilary", "Sze");
      loginInfo.put("Thomas", "Wong");
      loginInfo.put("Jason", "Ye"); 
      //We're gonna put these into the hasmap as the username and passwords.
      
      String userID = user.getText();
      String userPassword = password.getText();
      // Get user and password
      if(loginInfo.containsKey(userID)) {
        if(loginInfo.get(userID).equals(userPassword)) {
        }
        else {
          JOptionPane.showMessageDialog(null, "Incorrect password", "Warning", JOptionPane.ERROR_MESSAGE);
          //Display incorrect password if the password isn't found to match up with any of the values from the HashMap
        }
        
      }
      else {
        JOptionPane.showMessageDialog(null, "Incorrect username", "Warning", JOptionPane.ERROR_MESSAGE);
        //Displays incorrect username if the username isn't found to match up with any of the keys from the HashMap
      }
    }
  } 
}

