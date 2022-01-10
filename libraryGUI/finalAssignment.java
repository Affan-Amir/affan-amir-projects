import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

/*This file is just a login page
 * That leads to all other pages
 */

public class finalAssignment extends JFrame implements ActionListener{  
  
  //Java swing components to use
  JLabel userLabel;
  JTextField userText;
  JLabel passwordLabel;
  JPasswordField passwordText;
  JButton button;
  JLabel hint;
  JPanel panel = new JPanel();
  JFrame frame = new JFrame("Admin Login");
  JButton myButton = new JButton("Login");
  JLabel adminPic;
  JLabel info;
  JLabel background;
  
  finalAssignment() throws IOException{
    //Set the frame details
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.getContentPane().add(panel);
    panel.setLayout(null);
    
    //Add the label to ask for username
    userLabel = new JLabel("Username");
    Font myFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 18);
    userLabel.setBounds(10, 20, 80, 25);
    userLabel.setFont(myFont);
    userLabel.setForeground(Color.WHITE);
    panel.add(userLabel);
    
    //Username textfield
    userText = new JTextField(20);
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);
    
    //Label to ask for password
    passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(10, 50, 80, 25);
    passwordLabel.setFont(myFont);
    passwordLabel.setForeground(Color.WHITE);
    panel.add(passwordLabel);
    
    //Password textfield
    passwordText = new JPasswordField();
    passwordText.setBounds(100, 50, 165, 25);
    panel.add(passwordText);
    
    //Login buton
    myButton.setBounds(10, 80, 80, 25);
    myButton.addActionListener(this);
    panel.add(myButton);
    
    //Hint 
    hint = new JLabel("");
    hint.setBounds(100, 400, 300, 25);
    hint.setFont(myFont);
    hint.setForeground(Color.WHITE);
    panel.add(hint);
    
    //Admin pic
    BufferedImage pic = ImageIO.read(new File("AdminPic.jpeg"));
    JLabel adminPic = new JLabel(new ImageIcon(pic));
    adminPic.setBounds(0, 0, 200, 500);
    panel.add(adminPic);
    
    //Info
    info = new JLabel("Enter ADMIN Login Info");
    Font infoFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 22);
    info.setFont(infoFont);
    info.setForeground(Color.WHITE);
    info.setBounds(200, 200, 500, 100);
    panel.add(info);
    
    //The background
    ImageIcon img = new ImageIcon("Library.jpg");
    background = new JLabel("", img, JLabel.CENTER);
    background.setBounds(0, 0, 600, 600);
    panel.add(background);
    frame.setVisible(true);
    //Background and making the frame visible
  }  
  
  //If the user presses login, if the credentials match then log them in, if not tell them wrong username or password
  @Override
  public void actionPerformed(ActionEvent e){
    String user = userText.getText();
    String password = passwordText.getText();
    if (user.equals("Hello") && password.equals("world")){
      if(e.getSource()== myButton){
        AdminWindow adminWindow = new AdminWindow();
        frame.dispose();
        //This is going to check: Does the User ID and the Password Match up? If so, let's open up the new file and dispose of this file that we currently have open
      }
    }
    else{
        if(e.getSource()== myButton){
          JOptionPane.showMessageDialog(null, "Incorrect username or password", "Warning", JOptionPane.ERROR_MESSAGE);
          hint.setText("Wrong username or password");
          //This is doing 2 seperate things, first of all, the MessageDialog is showing that there was incorrect username or password
          //We are also at the same time going to alter the hint to show wrong username or password, on the JFRAME itself. 
      }
    }
  }
}  