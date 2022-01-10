import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Type {
  /**
   * This getName mtehod is going to be used to get the names of the moves
   * 
   * @author Affan Amir
   * @param moves moves is where the moveset is being stored
   * @return returning the moves 2d array.
   */
  public String[][] getName(String[][] moves) {
    try {
      BufferedReader fileScanner = new BufferedReader(new FileReader("PokemonMoves.csv"));
      // Creating a reader, so that we can actually read a CSV file
      for (int i = 0; i < 3; i++) {
        moves[i] = fileScanner.readLine().split(",");
      }
      // Seperating values by comma

      fileScanner.close();
      // Closing reader
    } catch (IOException e) {
      System.out.println("File not Found");
    }
    // Exception for if file is not found
    return moves;
    // Returning the String[][] for moves
  }

  /**
   * PrintMoves is going to print out the moves
   * 
   * @author Affan Amir
   * @param moves the moves array, which is holding the moves themselves
   * @param type  is the string for the elemental type of the pokemon
   */
  public void printMoves(String[][] moves, String type) {

    HashMap<String, Integer> moveIndex = new HashMap<String, Integer>();
    moveIndex.put("Water", 0); // Put elements in Map
    moveIndex.put("Grass", 1);
    moveIndex.put("Fire", 2);
    int typeToIndex = moveIndex.get(type);
    // We need to check the index of the array, so we create a typeToIndex int.

    System.out.println("For Tackle, Press [1]\n" + "For " + moves[typeToIndex][0] + ", Press [2]\n" + "For "
        + moves[typeToIndex][1] + ", Press[3]");
    // Printing out the movesets
  }

}
