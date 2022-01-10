/*
 * 2D array game (Connect 4) assignment 
 * Date: October 5th, 2021
 * Affan Amir
 * Teacher: Mr. Ho
 */
import java.util.*;

public class AmirAffanConnect4{
  public static void main(String[] args){ //Run main method
    int choose = 0; //This variable will decide what game mode the user is going to play.
    int drop = 0; //Declaring variable for the place where the piece will be dropped
    String playAgain = ""; //This variable will be the one that is going to decide if the user gets to play again or not.
    char[][] board = new char[6][7]; //Declaring the 2d Array that I will use as the places that the pieces can be dropped into. 
    
    
    do{ //Using a do while loop over the entire game, so that we have the option to play again
      System.out.println();
      int move = 0; //Declaring variable that will keep track of the turn of the game
      boolean gameOver = false; //Declare the boolean that is going to be used in the while statement to keep the game going
      char player = 'X'; //Declare and define the player variable to be equal to 'X', though it will be changed later
      char com = 'O'; //Computer will take in the piece of O
      
      for(int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          board[row][col] = ' ';
        }
      }
      //Using a nested for loop to go through each array in the 2d array, and set the value of every element in those arrays to be a blank space for now.
      
      System.out.println("Welcome to Affan's Connect 4 Assignment!\nWould you like to play PvP[press 1] or PvC[press 2]"); //Welcome statement
      choose = gameModeChooser(choose); //Running the method, which is just going to run the part of code that allows the user to choose the mode they are going to play.
      
      if (choose == 1) {
        System.out.println("You have selected PvP"); 
        //Welcome statement
        
        while(gameOver == false && move < 42) { 
          //The while loops is going to keep on going until a) a winner is found or b) 42 moves are taken (board is 6x7 = 42 pieces to place)
          do {
            //This is a do-while loop because we NEED to have the board printed, and player choose at least once, but we also need to consider the fact that the user may enter
            //an invalid move, in this case we need to repeat the loop again and again until we can successfully exit (user enters valid) 
            printboard(board);
            drop = chooseDrop(player, drop);
            //The two methods above are going to allow the user to see the board, and then allow them to pick a move. 
          } while(validMove(board, drop) == false); //Condition of the do-while loop
          
          //Here, we know that we've gotten past the do-while loop, so we can now change the value of the board and start adding pieces
          for(int row = board.length-1; row >= 0; row--) {
            if(board[row][drop - 1] == ' ') {
              board[row][drop - 1] = player; 
              break;
              //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
              //Although the user will see the columns starting from 1, Java starts counting it's 2d and 1d arrays from the 0th element, meaning we need to subtract 1 from 
              //whatever the user inputs, to match the columns. 
            }
          }
          gameOver = connect(board, player);
          //Check after the move has successfully been placed, if the game is over or not. 
          if (player == 'X') player = 'O';
          //Switch players here. 
          else if (player == 'O') player = 'X';
          //Switch players
          move++;
          //Keep track of the number of moves that have been made, because we know it can't be more than 6x7 (42)
        }
        printboard(board);
        //At this point, we've exited the while loop, which means that either someone won, or the board is completely filled.
        if (gameOver || move >= 42) {
          if (player == 'X') System.out.println("Player O is the winner");
          else if (player == 'O') System.out.println("Player X is the winner!");
          //If there WAS a winner, name them. (Remember that the current player is the loser, because we still swapped the player even after the gameOver was found
          //so all we know is that whatever the current player is equal too, then the other player wins.
          else System.out.println("It's a tie!");
          //A case in which there are no winners, and the board is just completely filled.
          
          playAgain = playOneMoreTime(playAgain);
          //Run the method that asks if the user wants to play again
        }
      }
      else if (choose == 2) {
        System.out.println("You have selected PvC");
        //If the user decides to play PvC
        while(gameOver == false && move < 42) { 
          //The while loops is going to keep on going until a) a winner is found or b) 42 moves are taken (board is 6x7 = 42 pieces to place)
          do {
            //This is a do-while loop because we NEED to have the board printed, and player choose at least once, but we also need to consider the fact that the user may enter
            //an invalid move, in this case we need to repeat the loop again and again until we can successfully exit (user enters valid) 
            printboard(board);
            drop = chooseDrop(player, drop);
            //The two methods above are going to allow the user to see the board, and then allow them to pick a move. 
          } while(validMove(board, drop) == false); //Condition of the do-while loop
          
          //Here, we know that we've gotten past the do-while loop, so we can now change the value of the board and start adding pieces
          for(int row = board.length-1; row >= 0; row--) {
            if(board[row][drop - 1] == ' ') {
              board[row][drop - 1] = player; 
              break;
              //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
            }
            //Although the user will see the columns starting from 1, Java starts counting it's 2d and 1d arrays from the 0th element, meaning we need to subtract 1 from 
            //whatever the user inputs, to match the columns. 
          }
          move++;
          gameOver = connect(board, player);
          //Check after the move has successfully been placed, if the game is over or not. 
          if(connect3(board, com) && gameOver == false) {
            drop = winTheGame(board, com);
            
            for(int row = board.length-1; row >= 0; row--) {
              // System.out.println(i);
              if(board[row][drop] == ' ') {
                board[row][drop] = com;
                break;
                //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
              }
            }
          }
          
          else if(connect3(board, player) && gameOver == false) {
            drop = computerMove(board, player);
            for(int row = board.length-1; row >= 0; row--) {
              // System.out.println(i);
              if(board[row][drop] == ' ') {
                board[row][drop] = com;
                System.out.println(drop);
                break;
                //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
              }
            }
          }
          else if (connect3(board, com) == false && gameOver == false){
            drop = computerMove(board, com);
            System.out.println(drop);
            for(int row = board.length-1; row >= 0; row--) {
              if(board[row][drop] == ' ') {
                board[row][drop] = com; 
                break;
                //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
              }
            }
          }
          if (gameOver == false) gameOver = connect(board, com);
          //If the gameOver method is true, then we don't want to change it, however if it is FALSE we should change it to the current gameOver
          // because this is after the AI moves, and we need to know if it is game Over after that happens.
          move++;
          //Keep track of the number of moves that have been made, because we know it can't be more than 6x7
        }
        printboard(board);
        //At this point, we've exited the while loop, which means that either someone won, or the board is completely filled.
        if (connect(board, player)) System.out.println("Player X is the winner");
        else if (connect(board, com)) System.out.println("COM is the winner!");
        //If there WAS a winner, name them. (Remember that the current player is the loser, so all we know is that if the player IS equal to this, then the other player wins.
        else System.out.println("It's a tie!");
        //A case in which there are no winners, and the board is just completely filled.
        
        playAgain = playOneMoreTime(playAgain); //Run the method that let's the user choose if they want to play again
      }     
    }while (playAgain.equals("Y") || playAgain.equals("y")); //Condition for the do-while loop that runs the game-code
    System.out.println("I hope you had fun playing Affan's Connect4! \nGoodbye!"); //Goodbye statement
  }
  
  /** 
   * In this method, the user is allowed to choose what game mode they would like to choose.
   * The method then welcomes them into their game mode, and if an invalid input is inputed, the user gets to try again.
   * @param choice, choice is the parameter that is passed into the method, it is used as an int, and the user will decide which game mode to select
   * @return, in this method we have to return the value of choice, and so we can simply return it's value, so that we can set our variable choice in main method to this.
   */
  @SuppressWarnings("resource")
//SupressWarnings is going to tell the compiler to ignore the warning (which is a resource leak for the scanner) and to continue as normal
    public static int gameModeChooser(int choice) throws InputMismatchException{
    try {
      choice = new Scanner(System.in).nextInt(); //I create the object of the scanner class, and use it for the direct purpose of getting an int value for "choose"
      if (choice == 1) return 1; //If user inputs 1, they have selected PvP
      
      else if (choice == 2) return 2; //If user inputs 2, they have selected PvC
      else {
        System.out.println("Invalid response, try again \nWould you like to play PvP[press 1] or PvC[press 2]"); //If the user inputs an option that is not available, 
        //the method restarts itself and the user has to pick again until an option is picked.
        gameModeChooser(choice);
      }
    }
    catch(InputMismatchException ex) {
      System.out.println(ex + "\nDon't input a word! Try Again\nWould you like to play PvP[press 1] or PvC[press 2]");
      gameModeChooser(choice);
      //Should an InputMismatchException be found, then the code will tell you to go again
    }
    return 1;
    //We need to return a value outside of the if statements that we created, but we don't need to worry about this return statement since this method will repeat until our
    //Desired result is achieved (which is user picking a valid game mode) 
  }
  
  /**
   * This method is going to ask the user if they would like to play again, and if yes, the code begins again, if not the program ends
   * @param playingAgain, we are going to check if this is equal to yes or no, and then return it, so that the playAgain variable in main takes on the value of playingAgain
   * @return playingAgain, so that the value the user inputs for playingAgain gets transferred straight into the playAgain method in main. 
   */
  @SuppressWarnings("resource")
//SupressWarnings is going to tell the compiler to ignore the warning (which is a resource leak for the scanner) and to continue as normal
    public static String playOneMoreTime(String playingAgain){ 
    System.out.println("Would you like to play again? Enter Y for yes or N for no");
    playingAgain = new Scanner(System.in).nextLine();
    //Making playingAgain equal to the next line
    if(!playingAgain.equals("y") && !playingAgain.equals("Y") && !playingAgain.equals("n") && !playingAgain.equals("N")) {
      System.out.println("That isn't a valid answer! Try again");
      playOneMoreTime(playingAgain);
      //Making the method run again if we don't get a desired result
    }
    return playingAgain; //Returning playingAgain
  }
  
  /**
   * This method is going to simply print the board and the row of numbers that display the number of each column
   * @param arr is the 2d array that is going to get passed into the method. We need to use this parameter so that the board can actually be printed
   */
  
  public static void printboard(char[][] arr) {
    System.out.println();
    System.out.println("     1 \t     2 \t     3 \t     4 \t     5 \t     6 \t     7");
    //Printing the row of numbers to show the user column number
    
    for(int row = 0; row < arr.length; row++) {
      System.out.print("|\t");
      //Print a "|" for each row
      for(int col = 0; col < arr[0].length; col++) {
        System.out.print(arr[row][col]);
        System.out.print("|\t");
        //Print the value of the pieces on the board and then "|" for each column
      }
      System.out.println();
      System.out.println("----------------------------------------------------------");
      //Create an empty line and then a dashed line covers the entire width of the board
    }
    System.out.println("     1 \t     2 \t     3 \t     4 \t     5 \t     6 \t     7");
    System.out.println();
    //Show the user the column numbers again, and then provide an empty line
    
  }
  
  /**
   * This method is going to allow tell the user who's turn it is, and allow them to choose the location of the drop 
   * @param x this parameter is for the "player" variable
   * @param dropping this parameter is for the user to pick where they'd like to drop. 
   * @return, I will return the parameter dropping here, and then set it equal to drop in my main method
   */
  @SuppressWarnings("resource")
  //SupressWarnings is going to tell the compiler to ignore the warning (which is a resource leak for the scanner) and to continue as normal
    public static int chooseDrop(char x, int dropping) throws InputMismatchException{
    try {
      System.out.println("Player " + x + "'s turn. Please select a column");
      dropping = new Scanner(System.in).nextInt(); 
      //Let's user pick location for drop
    }
    catch(Exception ex) {
      System.out.println("Don't enter a String! Enter an int: Try again");
      chooseDrop(x, dropping);
    }
    return dropping;
  }
  
  /**
   * This method is checking whether the move that the user inputs is truly a valid move. As you can see, when an invalid move is found, the method returns FALSE.
   * which tells the program that the method to allow the user to drop (chooseDrop) needs to run again.
   * @param arr is the board, and we need to check if the users input is within the boundary of the board
   * @param y is the variable that is going to check if the column is completely filled up
   * @return we can always return true, UNLESS, one of the if statements is satisfied, in which case we need to return false
   */
  public static boolean validMove(char[][] arr, int dropping) throws InputMismatchException {
    try {
      if (dropping - 1 < 0 || dropping - 1 > arr[0].length) {
        System.out.println("Not a valid column.");
        return false;
      }
      //If the user enters a column that is either less than 0, or greater than the length of the array, return false
      if(arr[0][dropping - 1] != ' ') {
        System.out.println("Column has been completely filled already.");
        return false;
      }
      //If the user enters a move into a column that is completely taken, return false.
      
      return true;
      //In any other case, return true.
    }
    catch(Exception ex) {
      System.out.println(ex + " Don't enter a string, enter an int!");
      return false;
      
    }
    //Creating a try catch allows for exceptions to be handled nicely. 
  }
  
  
  /**
   * This method is going to check the board to see if there are any pieces creating a connect 4.
   * @param arr this the board. We need to pass the board as we need to check the CONTENTS of the board. 
   * @param play this variable is the variable to pass in the player (Either X or O's). It would check one at a time, depending on what parameter we pass when the method runs
   * @return we are going to return a boolean of either true or false for the connect method, depending on whether a connect is found or not
   */
  public static boolean connect(char[][] arr, char play) {
    //Below check for any horizontal pieces that create a connect4, anywhere in the board
    for(int row  = 0; row <arr.length; row++){
      for (int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == play   && 
            arr[row][col + 1] == play &&
            arr[row][col + 2] == play &&
            arr[row][col + 3] == play){
          return true;  //Return true, because a winner has been found
        }
      }
    }
    //Below Check for any vertical pieces that create a connect4, anywhere in the board.
    for(int row = 0; row < arr.length - 3; row++){
      for(int col = 0; col < arr[0].length; col++){
        if (arr[row][col] == play   && 
            arr[row + 1][col] == play &&
            arr[row + 2][col] == play &&
            arr[row + 3][col] == play){
          return true; //Return true, because a winner was found
        }
      }
    }
    
    //Below checks for any upward diagonal pieces that create a connect4, anywhere in the board.
    for(int row = 3; row < arr.length; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == play   && 
            arr[row - 1][col + 1] == play &&
            arr[row - 2][col + 2] == play &&
            arr[row - 3][col + 3] == play){
          return true; //Return true, because a winner was found
        }
      }
    }
    //Below is checking for downward diagonals anywhere in the board
    for(int row = 0; row < arr.length - 3; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == play   && 
            arr[row + 1][col + 1] == play &&
            arr[row + 2][col + 2] == play &&
            arr[row + 3][col + 3] == play){
          return true; //Returning true because a winner was found
          
        }
      }
    }
    return false;
    //If none of these for loops can return true, we know that there is no current winner, and the method returns false, so that game knows to continue. 
  }
  
  /**
   * This method is going to check if the user has 3-in a row, and returns true if yes, false if no. 
   * The reason why it does so is that if the method returns true, COM can block it.
   * @param arr is the board that we need to pass in so we can check the contents of the 2d array
   * @param play is the user "piece"/"stone" that we are checking to see if there is 3-in-a-row of.
   * @return true if we can find a connect3, false if we cannot find one. Return statement will make the method equal to true or false. 
   */
  public static boolean connect3(char[][] arr, char player) {
    //Check for any horizontal pieces that create a connect3, anywhere in the board
    for(int row  = 0; row <arr.length; row++){
      for (int col = 0; col < arr[0].length - 4; col++){
        if (arr[row][col] == player   && 
            arr[row][col + 1] == player &&
            arr[row][col + 2] == player &&
            arr[row][col + 3] == ' '){
          return true;
        }
        //As you can see, in the method above we are checking for 4 different pieces that are consecutive to each other,
        //which is why the row remains the same until a full iteration of the loop is completed.
        //Return true if this connect3 is found.
      }
    }
    //Check for any vertical pieces that create a connect3, anywhere in the board.
    for(int row = arr.length-1; row >= 3; row--){
      for(int col = 0; col < arr[0].length; col++){
        if (arr[row][col] == player   && 
            arr[row - 1][col] == player &&
            arr[row - 2][col] == player &&
            arr[row - 3][col] == ' '){
          return true;
        }
        //In the block above, we are checking the consecutive values of the vertical pieces, hence why the column never changes while checking for 4 consecutive pieces.
        //Return true if this connect3 is found.
      }
    }
    //Checking for any upward diagonal pieces that create a connect4, anywhere in the board.
    for(int row = 3; row < arr.length; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == player   && 
            arr[row - 1][col + 1] == player &&
            arr[row - 2][col + 2] == player &&
            arr[row - 2][col + 3] != ' ' &&
            arr[row - 3][col + 3] == ' '){
          //If we are checking the diagonal, we need to change both the row and the column at the same time, and the slope must remain the same.
          //The reason why we check if row - 3, col + 3 is NOT free is because, if there is no piece currently there then there is no threat of a connect 4, but if there is a piece
          //Directly under the row and column that can create a connect4, the computer needs to block this
          return true; //Return true if this connect3 is found
        }
        
      }
    }
    //Check for downward diagonals anywhere in the board
    for(int row = 0; row < arr.length - 4; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == player   && 
            arr[row + 1][col + 1] == player &&
            arr[row + 2][col + 2] == player &&
            arr[row + 4][col + 3] != ' ' &&
            arr[row + 3][col + 3] == ' '){
          //The reason why we check if row + 4 is NOT free, is because we only are going to have to concern ourself with the downward diagonal if the player has the ability to
          //Place a piece there, so we check if the row below, and the column are taken so that the player can place
          return true; //Return true if this connect 3 is found
        }
      }
    }
    return false;
    //If none of these are found, we can just say that there are no places in the board where there is a 3-in a row and return false
  }
  
  /**
   * This method is going to allow the computer to make a game winning move, if the opportunity provides
   * @param arr, passing in the game board and checking its contents
   * @param com a variable for the AI piece, so that the AI can place something
   * @return the value of where we are going to attempt to drop in this piece, we will return the value and set drop equal to this.
   */
  public static int winTheGame(char[][] arr, char com){
    //Let the computer make the game-winning play above all else
    //Game winning move for a horizontal connect4
    for(int row  = 0; row <arr.length; row++){
      for (int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == com   && 
            arr[row][col + 1] == com &&
            arr[row][col + 2] == com &&
            arr[row][col + 3] == ' '){
          return col + 3;
          //Return the value for the computer to place a piece to win in a horizontal manner
        }
      }
    }
    //Game winning move for a vertical connect4
    for(int row = arr.length-1; row >= 3; row--){
      for(int col = 0; col < arr[0].length; col++){
        if (arr[row][col] == com   && 
            arr[row - 1][col] == com &&
            arr[row - 2][col] == com &&
            arr[row - 3][col] == ' ') {
          return col;
          //Return the value for the computer to place a piece to win in a vertical manner
        }
      }
    }
    //Game winning move for an upward diagonal connect4
    for(int row = arr.length - 1; row < arr.length-3; row--){
      for(int col = 0; col  < arr[0].length - 3; col++){
        if (arr[row][col] == com   && 
            arr[row - 1][col + 1] == com &&
            arr[row - 2][col + 2] == com &&
            arr[row - 2][col + 3] != ' '){
          return col + 3;
          //Return this value for the computer to place a piece to win in a upward-diagonal manner
        }
      }
    }
    //Game winning move for a downward diagonal connect4
    for(int row = 0; row < arr.length - 3; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == com   && 
            arr[row + 1][col + 1] == com &&
            arr[row + 2][col + 2] == com &&
            arr[row + 3][col + 3] != ' '){
          return col + 3;
          //Return this value for the computer to place a piece to win in a downward-diagonal manner
        }
      }
    }
    return 0; 
    //The method needs to actually return an int OUTSIDE of the nested loops, so we have the return 0 statement here
    //We don't need to worry about this doing anything though, because the method is only going to be called BECAUSE the computer can win the game, meaning one of the nested
    //loops must be true (meaning one of the returns in the nested loops is going to be returned)
  }
  
  /**
   * This method is going to make the computer make a move that can successfully block the the user player from winning.
   * @param arr is the board, which needs to be passed into the method because we need to check the contents of the 2d array.
   * @param player is the user, which we are going to pass in because we need to check which type of - connect3 the computer needs to block
   * @return an int value for drop to be set to so the game knows where the AI wants to drop it's piece
   */
  public static int computerMove(char[][] arr, char player) {
    
    //Check for any Horizontal pieces that create a connect4, anywhere in the board.
    for(int row = arr.length - 1; row >= 3; row--){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == player   && 
            arr[row][col + 1] == player &&
            arr[row][col + 2] == player &&
            arr[row][col + 3] == ' '){
          return col + 3;
          //Return the value for the computer to place a piece to win in a horizontal manner
        }
      }
    }
    
    //Checking for any vertical pieces that create a connect4 anywhere in the board
    for(int row = arr.length - 1; row >= 3; row--){
      for(int col = 0; col < arr[0].length; col++){
        if (arr[row][col] == player   && 
            arr[row - 1][col] == player &&
            arr[row - 2][col] == player &&
            arr[row - 3][col] == ' '){
          return col;
        }
        //In the method above, we are checking the consecutive values of the vertical pieces, hence why the column never changes while checking for 4 consecutive pieces.
        //Return the value for the AI to win in a vertical manner
      }
    }
    //Checking for any upward diagonal pieces that create a connect4, anywhere in the board.
    for(int row = arr.length - 1; row > 2; row--){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == player   && 
            arr[row - 1][col + 1] == player &&
            arr[row - 2][col + 2] == player &&
            arr[row - 2][col + 3] != ' '){
          return col + 3;
        }
        //If we are checking the diagonal, we need to change both the row and the column at the same time, and the slope must remain the same.
        //Return the value for the AI to win in a upward-diagonal manner
      }
    }
    //Check for downward diagonals anywhere in the board
    for(int row = 0; row < arr.length - 4; row++){
      for(int col = 0; col < arr[0].length - 3; col++){
        if (arr[row][col] == player && 
            arr[row + 1][col + 1] == player &&
            arr[row + 2][col + 2] == player &&
            arr[row + 4][col + 3] != ' '){
          return col + 3;
        }
        //Similar to the upward diagonal, we need to change both the row and the column at the same time, and the slope must remain the same
        //In upwards, we were DECREASING the value of i (AKA moving the row higher), we are now INCREASING the value of i (AKA moving down)
        //Return the value the AI needs to win the game in a downward-diagonal manner 
      }
    }
    
    //If there is no move that the AI needs to block, we can allow it to make a random choice.
    Random rand = new Random();
    int num = rand.nextInt((6 - 0) + 1) + 0;
    //Generates a random number for the AI to drop a piece into
    for(int i = arr.length - 1; i > 0; i--) {
      if(arr[i][num] != ' ') {
        num = rand.nextInt((6 - 0) - 1) + 1;
        //If the column that the AI is attempting to drop a piece into, then make random a new random integer
      }
    }
    return num;
    //Assuming that there is no action that the AI needs to take (blocking a user) then, the code will fall down here where it will retrun 'num', which is the random number
  }
}