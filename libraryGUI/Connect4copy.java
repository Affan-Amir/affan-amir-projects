/*
 * 2D array game (Connect 4) assignment 
 * Date: September 23, 2021
 * Affan Amir
 * Teacher: Mr. Ho
 */

import java.util.*;
public class Connect4copy {
  
  public static int choose; //Public static int is necessary so that I can use my method to get it's value, and also be able to use it in the main method 
  public static int drop; //Declaring variable for the place where the piece will be dropped
  //public static Scanner scanner = new Scanner(System.in);
  public static int winner;
  public static boolean win = false;
  
  public static void main(String[] args){
    int move = 0; //Declaring variable that will keep track of the turn of the game
    boolean gameOver = false; //Declare the boolean that is going to be used in the while statement to keep the game going
    char player = 'X'; //Declare and define the player variable to be equal to 'X', though it will be changed later
    char com = 'O';
    char[][] board = new char[6][7]; //Declaring the 2d Array that I will use as the places that the pieces can be dropped into. 
    
    for(int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = ' ';
      }
    }
    //Using a nested for loop to go through each array in the 2d array, and set the value of every element in those arrays to be a blank space for now.
    
    System.out.println("Welcome to Affan's Connect 4 Assignment!\nWould you like to play PvP[press 1] or PvC[press 2]"); //Welcome statement
    gameModeChooser(); //Running the gameModeChoser method, which is just going to run the part of code that allows the user to choose the mode they are going to play.
    
    if (choose == 1) {
      while(gameOver == false && move <= 42) { 
        //The while loops is going to keep on going until a) a winner is found or b) 42 moves are taken (board is 6x7 = 42 pieces to place)
        do {
          //This is a do-while loop because we NEED to have the board printed, and player choose at least once, but we also need to consider the fact that the user may enter
          //an invalid move, in this case we need to repeat the loop again and again until we can successfully exit (user enters valid) 
          printboard(board);
          chooseDrop(player);
          //The two methods above are going to allow the user to see the board, and then allow them to pick a move. 
        } while(validMove(board, player) == false); //Condition of the do-while loop
        
        //Here, we know that we've gotten past the do-while loop, so we can now change the value of the board and start adding pieces
        for(int i = board.length-1; i >= 0; i--) {
          if(board[i][drop-1] == ' ') {
            board[i][drop-1] = player; 
            break;
            //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
          }
          //Although the user will see the columns starting from 1, Java starts counting it's 2d and 1d arrays from the 0th element, meaning we need to subtract 1 from 
          //whatever the user inputs, to match the columns. 
        }
        gameOver = connect(board, player, com);
        //Check after the move has successfully been placed, if the game is over or not. 
        if (player == 'X') player = 'O';
        //Switch players here. 
        else if (player == 'O') player = 'X';
        //Switch players
        move++;
        //Keep track of the number of moves that have been made, because we know it can't be more than 6x7
      }
      printboard(board);
      //At this point, we've exited the while loop, which means that either someone won, or the board is completely filled.
      if (gameOver) {
        if (player == 'X') System.out.println("Player X is the winner");
        else if (com == 'O') System.out.println("COM is the winner!");
        //If there WAS a winner, name them. (Remember that the current player is the loser, so all we know is that if the player IS equal to this, then the other player wins.
        else System.out.println("It's a tie!");
        //A case in which there are no winners, and the board is just completely filled.
      }
    }
    else if (choose == 2) {
      while(gameOver == false && move <= 42) { 
        //The while loops is going to keep on going until a) a winner is found or b) 42 moves are taken (board is 6x7 = 42 pieces to place)
        do {
          //This is a do-while loop because we NEED to have the board printed, and player choose at least once, but we also need to consider the fact that the user may enter
          //an invalid move, in this case we need to repeat the loop again and again until we can successfully exit (user enters valid) 
          printboard(board);
          chooseDrop(player);
          //The two methods above are going to allow the user to see the board, and then allow them to pick a move. 
        } while(validMove(board, player) == false); //Condition of the do-while loop
        
        //Here, we know that we've gotten past the do-while loop, so we can now change the value of the board and start adding pieces
        for(int i = board.length-1; i >= 0; i--) {
          if(board[i][drop-1] == ' ') {
            board[i][drop-1] = player; 
            break;
            //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
          }
          //Although the user will see the columns starting from 1, Java starts counting it's 2d and 1d arrays from the 0th element, meaning we need to subtract 1 from 
          //whatever the user inputs, to match the columns. 
        }
        gameOver = connect(board, player, com);
        //Check after the move has successfully been placed, if the game is over or not. 
        
        if(connect3(board, player)) {
          drop = computerMove(board, player, com);
          for(int i = board.length-1; i >= 0; i--) {
            if(board[i][drop] == ' ') {
              board[i][drop] = com; 
              break;
              //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
            }
          }
        }
        else {
          drop = randomComMove(board, com);
          for(int i = board.length-1; i >= 0; i--) {
            if(board[i][drop - 2] == ' ') {
              board[i][drop - 2] = com; 
              break;
              //If we don't break here, then the for loop is going to continue and continue, and it will fill up the entire column with the player's move.
            }
          }
        }
        gameOver = connect(board, player, com);
        move++;
        //Keep track of the number of moves that have been made, because we know it can't be more than 6x7
      }
      printboard(board);
      //At this point, we've exited the while loop, which means that either someone won, or the board is completely filled.
      if (gameOver) {
        if (winner == 1) System.out.println("Player X is the winner");
        else if (winner == 2) System.out.println("COM is the winner!");
        //If there WAS a winner, name them. (Remember that the current player is the loser, so all we know is that if the player IS equal to this, then the other player wins.
        else System.out.println("It's a tie!");
        //A case in which there are no winners, and the board is just completely filled.
      }
    }
  }
  
  /**
   * This method is going to simply print the board and the row of numbers that display the number of each column
   * @param arr is the 2d array that is going to get passed into the method. We need to use this parameter so that the board can actually be printed
   */
  
  public static void printboard(char[][] arr) {
    System.out.println();
    System.out.println("     1 \t     2 \t     3 \t     4 \t     5 \t     6 \t     7");
    //Printing the row of numbers to show the user column number
    
    for(int i = 0; i < arr.length; i++) {
      System.out.print("|\t");
      //Print a "|" for each row
      for(int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j]);
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
   * (No parameters involved in method) 
   * In this method, the user is allowed to choose what game mode they would like to choose.
   * The method then welcomes them into their game mode, and if an invalid input is inputed, the user gets to try again.
   */
  public static void gameModeChooser() throws InputMismatchException{
    try {
      choose = new Scanner(System.in).nextInt(); //I create the object of the scanner class, and use it for the direct purpose of getting an int value for "choose"
      if (choose == 1) System.out.println("You have selected PvP"); //If user inputs 1, they have selected PvP
      
      else if (choose == 2) System.out.println("You have selected PvC"); //If user inputs 2, they have selected PvC
      else {
        System.out.println("Invalid response, try again \nWould you like to play PvP[press 1] or PvC[press 2]"); //If the user inputs an option that is not available, 
        //the method restarts itself and the user has to pick again until an option is picked.
        gameModeChooser();
      }
    }
    catch(InputMismatchException ex) {
      System.out.println(ex + "\nDon't input a word! Try Again\nWould you like to play PvP[press 1] or PvC[press 2]");
      gameModeChooser();
      //Should an InputMismatchException be found, then the code will tell you to go again
    }
  }
  
  /**
   * This method is going to allow tell the user who's turn it is, and allow them to choose the location of the drop 
   * @param x this parameter is for the "player" variable
   * @param y this parameter is for the "drop" variable
   */
  public static void chooseDrop(char x) {
    System.out.println("Player " + x + "'s turn. Please select a column");
    drop = new Scanner(System.in).nextInt(); 
    //Let's user pick location for drop
  }
  
  /**
   * This method is checking whether the move that the user inputs is truly a valid move. As you can see, when an invalid move is found, the method returns FALSE.
   * which tells the program that the method to allow the user to drop (chooseDrop) needs to run again.
   * @param arr is the board, and we need to check if the users input is within the boundary of the board
   * @param y is the variable that is going to check if the column is completely filled up
   * @return we can always return true, UNLESS, one of the if statements is satisfied, in which case we need to return false
   */
  public static boolean validMove(char[][] arr, char y) throws InputMismatchException {
    try {
      if (drop - 1 < 0 || drop - 1 > arr[0].length) {
        System.out.println("Not a valid column.");
        return false;
      }
      //If the user enters a column that is either less than 0, or greater than the length of the array, return false
      if(arr[0][drop-1] != ' ') {
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
   * @param player this variable is the variable to pass in the player (Either X or O's). It would check one at a time, depending on what player equals at the time the method runs
   * @return
   */
  public static boolean connect(char[][] arr, char player, char com) {
    //Check for any horizontal pieces that create a connect4, anywhere in the board
    for(int i  = 0; i <arr.length; i++){
      for (int j = 0; j < arr[0].length - 3; j++){
        if ((arr[i][j] == player   && 
             arr[i][j + 1] == player &&
             arr[i][j + 2] == player &&
             arr[i][j + 3] == player)){
          winner = 1;
          return true;
        }
        else if(arr[i][j] == com && 
                arr[i][j + 1] == com &&
                arr[i][j + 2] == com &&
                arr[i][j + 3] == com) {
          winner = 2;
          return true;
        }
      }
    }
    //Check for any vertical pieces that create a connect4, anywhere in the board.
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j] == player &&
            arr[i + 2][j] == player &&
            arr[i + 3][j] == player){
          winner = 1;
          
          
          
        }
        else if(arr[i][j] == com && 
                arr[i + 1][j] == com &&
                arr[i + 2][j] == com &&
                arr[i + 3][j] == com) {
          winner = 2;
          return true;
          //In the method above, we are checking the consecutive values of the vertical pieces, hence why the column never changes while checking for 4 consecutive pieces.
          //Return true if this connect4 is found.
        }
      }
    }
    
    //Checking for any upward diagnol pieces that create a connect4, anywhere in the board.
    for(int i = 3; i < arr.length; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i - 1][j + 1] == player &&
            arr[i - 2][j + 2] == player &&
            arr[i - 3][j + 3] == player){
          winner = 1;
          return true;
        }
        
        else if(arr[i][j] == com   && 
                arr[i - 1][j + 1] == com &&
                arr[i - 2][j + 2] == com &&
                arr[i - 3][j + 3] == com) {
          winner = 2; 
          return true;
        }
        //If we are checking the diagnol, we need to change both the row and the column at the same time, and the slope must remain the same.
        //Return true if this connect4 is found
      }
    }
    //Check for downward diagnols anywhere in the board
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j + 1] == player &&
            arr[i + 2][j + 2] == player &&
            arr[i + 3][j + 3] == player){
          winner = 1;
          return true;
          
        }
        
        else if(arr[i][j] == player   && 
                arr[i + 1][j + 1] == player &&
                arr[i + 2][j + 2] == player &&
                arr[i + 3][j + 3] == player) {
          winner = 2; 
          return true;
        }
        //Similar to the upward diagnol, we need to change both the row and the column at the same time, and the slope must remain the same
        //In upwards, we were DECREASING the value of i (AKA moving the row higher), we are now INCREASING the value of i (AKA moving down)
        //Return true if this type of connect4 is found. 
      }
    }
    return false;
    //If neither of these for loops can return true, we know that there is no current winner, and the method returns false, so that game knows to continue. 
  }
  
  public static boolean connect3(char[][] arr, char player) {
    //Check for any horizontal pieces that create a connect4, anywhere in the board
    for(int i  = 0; i <arr.length; i++){
      for (int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i][j + 1] == player &&
            arr[i][j + 2] == player){
          return true;
        }
        //As you can see, in the method above we are checking for 4 different pieces that are consecutive to each other,
        //which is why the row remains the same until a full iteration of the loop is completed.
        //Return true if this connect4 is found.
      }   
    }
    //Check for any vertical pieces that create a connect4, anywhere in the board.
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j] == player &&
            arr[i + 2][j] == player){
          return true;
        }
        //In the method above, we are checking the consecutive values of the vertical pieces, hence why the column never changes while checking for 4 consecutive pieces.
        //Return true if this connect4 is found.
      }
    }
    //Checking for any upward diagnol pieces that create a connect4, anywhere in the board.
    for(int i = 3; i < arr.length; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i - 1][j + 1] == player &&
            arr[i - 2][j + 2] == player &&
            arr[i - 3][j + 2] == player){
          return true;
        }
        //If we are checking the diagnol, we need to change both the row and the column at the same time, and the slope must remain the same.
        //Return true if this connect4 is found
      }
    }
    //Check for downward diagnols anywhere in the board
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j + 1] == player &&
            arr[i + 2][j + 2] == player &&
            arr[i + 3][j + 2] == player){
          return true;
        }
        //Similar to the upward diagnol, we need to change both the row and the column at the same time, and the slope must remain the same
        //In upwards, we were DECREASING the value of i (AKA moving the row higher), we are now INCREASING the value of i (AKA moving down)
        //Return true if this type of connect4 is found. 
      }
    }
    return false;   
  }
  public static int computerMove(char[][] arr, char player, char com) {
    //Check for any horizontal pieces that create a connect4, anywhere in the board
    for(int i  = 0; i < arr.length; i++){
      for (int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i][j + 1] == player &&
            arr[i][j + 2] == player){
          return j + 3;
        }
        //As you can see, in the method above we are checking for 4 different pieces that are consecutive to each other,
        //which is why the row remains the same until a full iteration of the loop is completed.
        //Return true if this connect4 is found.
      }   
    }
    //Check for any vertical pieces that create a connect4, anywhere in the board.
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j] == player &&
            arr[i + 2][j] == player){
          return j;
        }
        //In the method above, we are checking the consecutive values of the vertical pieces, hence why the column never changes while checking for 4 consecutive pieces.
        //Return true if this connect4 is found.
      }
    }
    //Checking for any upward diagnol pieces that create a connect4, anywhere in the board.
    for(int i = 3; i < arr.length; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i - 1][j + 1] == player &&
            arr[i - 2][j + 2] == player &&
            arr[i - 3][j + 2] == player){
          return j + 3;
        }
        //If we are checking the diagnol, we need to change both the row and the column at the same time, and the slope must remain the same.
        //Return true if this connect4 is found
      }
    }
    //Check for downward diagnols anywhere in the board
    for(int i = 0; i < arr.length - 3; i++){
      for(int j = 0; j < arr[0].length - 3; j++){
        if (arr[i][j] == player   && 
            arr[i + 1][j + 1] == player &&
            arr[i + 2][j + 2] == player &&
            arr[i + 3][j + 2] == player){
          return j + 3;
        }
        //Similar to the upward diagnol, we need to change both the row and the column at the same time, and the slope must remain the same
        //In upwards, we were DECREASING the value of i (AKA moving the row higher), we are now INCREASING the value of i (AKA moving down)
        //Return true if this type of connect4 is found. 
      }
    }
    return 0;
  }
  public static int randomComMove(char[][] arr, char com) {
    Random rand = new Random();
    int num = rand.nextInt((8 - 2) + 1) + 2;
    return num;  
  }
}
