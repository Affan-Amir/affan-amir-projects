import javax.swing.*;
import java.awt.*;
import javax.swing.JTable;
import java.lang.reflect.Field;


public class ViewUsers{
  JFrame frame = new JFrame("View Users Window");
  JLabel name, book, remaining;
  JLabel affanBook, dibaBook, isaacBook, apinashBook, lathushanBook, maryamBook, ajBook, leonardoBook, jamesBook, hilaryBook, thomasBook, jasonBook;
  JLabel affanTime, dibaTime, isaacTime, apinashTime, lathushanTime, maryamTime, ajTime, leonardoTime, jamesTime, hilaryTime, thomasTime, jasonTime ;
  JLabel Affan, Diba, Isaac, Apinash, Lathushan, Maryam, AJ, Leonardo, James, Hilary, Thomas, Jason;
  ViewUsers(){
    Font myFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 12);
    name = new JLabel("Name of user");
    name.setBounds(0, 0, 100, 25);
    frame.add(name);
    name.setFont(myFont);
    name.setForeground(Color.WHITE);
    
    book = new JLabel("Book signed out");
    book.setBounds(0, 200, 100, 25);
    frame.add(book);
    book.setFont(myFont);
    book.setForeground(Color.WHITE);
    
    remaining = new JLabel("Time alloted with book");
    remaining.setBounds(0, 400, 200, 25); 
    frame.add(remaining);
    remaining.setFont(myFont);
    remaining.setForeground(Color.WHITE);
    
    affanBook = new JLabel(" ");
    frame.add(affanBook);
    
    dibaBook = new JLabel(" ");
    frame.add(dibaBook);
    
    isaacBook = new JLabel(" ");
    frame.add(isaacBook);
    
    apinashBook = new JLabel(" ");
    frame.add(apinashBook);
    
    lathushanBook = new JLabel(" ");
    frame.add(lathushanBook);
    
    maryamBook = new JLabel(" ");
    frame.add(maryamBook);
    
    ajBook = new JLabel(" ");
    frame.add(ajBook);
    
    leonardoBook = new JLabel(" ");
    frame.add(leonardoBook);
    
    jamesBook= new JLabel(" ");
    frame.add(jamesBook);
    
    hilaryBook = new JLabel(" ");
    frame.add(hilaryBook);
    
    thomasBook = new JLabel(" ");
    frame.add(thomasBook);
    
    jasonBook = new JLabel(" ");
    frame.add(jasonBook);
    
    affanTime= new JLabel(" ");
    frame.add(affanTime);
    
    dibaTime= new JLabel(" ");
    frame.add(dibaTime);
    
    isaacTime = new JLabel(" ");
    frame.add(isaacTime);
    
    apinashTime= new JLabel(" ");
    frame.add(apinashTime);
    
    lathushanTime = new JLabel(" ");
    frame.add(lathushanTime);
    
    maryamTime = new JLabel(" ");
    frame.add(maryamTime);
    
    ajTime = new JLabel(" ");
    frame.add(ajTime);
    
    leonardoTime = new JLabel(" ");
    frame.add(leonardoTime);
    
    jamesTime = new JLabel(" ");
    frame.add(jamesTime);
    
    hilaryTime = new JLabel(" ");
    frame.add(hilaryTime);
    
    thomasTime = new JLabel(" ");
    frame.add(thomasTime);
    
    jasonTime = new JLabel(" ");
    frame.add(jasonTime);
    
    Affan = new JLabel("Affan");
    frame.add(Affan);
    
    Diba = new JLabel("Diba");
    frame.add(Diba);
    
    Isaac = new JLabel("Isaac");
    frame.add(Isaac);
    
    Apinash = new JLabel("Apinash");
    frame.add(Apinash);
    
    Lathushan = new JLabel("Lathushan");
    frame.add(Lathushan);
    
    Maryam = new JLabel("Maryam");
    frame.add(Maryam);
    
    AJ = new JLabel("AJ");
    frame.add(AJ);
    
    Leonardo = new JLabel("Leonardo");
    frame.add(Leonardo);
    
    James = new JLabel("James");
    frame.add(James);
    
    Hilary = new JLabel("Hilary");
    frame.add(Hilary);
    
    Thomas = new JLabel("Thomas");
    frame.add(Thomas);
    
    Jason = new JLabel("Jason");
    frame.add(Jason);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setSize(600, 500);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}