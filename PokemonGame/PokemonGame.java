import java.util.*;

public class PokemonGame {

    // Making public static Strings for the trainer names
    static String p1Name, p2Name = "";
    static int p1PkmnInPlay;
    static int p2PkmnInPlay;

    // Making static hashmaps that hold the pokemon for players.
    static HashMap<String, Pokemon[]> p1Pkmn = new HashMap<String, Pokemon[]>();
    static HashMap<String, Pokemon[]> p2Pkmn = new HashMap<String, Pokemon[]>();

    // Normal type moves are defined below
    static Moves tackle = new Moves("Tackle", 8, 0, 10);
    // Fire type moves are defined below
    static Moves ember = new Moves("Ember", 11, 2, 5);
    static Moves sunnyDay = new Moves("Sunny Day", 0, 2, 3);
    // Water type moves are defined below
    static Moves waterGun = new Moves("Water Gun", 10, 1, 5);
    static Moves rain = new Moves("Rain", 0, 1, 3);
    // Grass type moves are defined below
    static Moves vineWhip = new Moves("Vine Whip", 10, 3, 5);
    static Moves grassyTerrain = new Moves("Grassy Terrain", 0, 3, 3);

    static String[][] moves = new String[3][3];
    static boolean gameRun = true;

    // Creating moves and gameRun
    public static void main(String[] args) {

        // Creating the gen 1 pokemon
        Pokemon[] gen1Pkmn = new Pokemon[3];
        gen1Pkmn[0] = new Pokemon("Charmander", 40, 2, 2);
        gen1Pkmn[1] = new Pokemon("Squirtle", 43, 3, 1);
        gen1Pkmn[2] = new Pokemon("Bulbasaur", 45, 3, 3);
        // Creating the gen 2 pokemon
        Pokemon[] gen2Pkmn = new Pokemon[3];
        gen2Pkmn[0] = new Pokemon("Cyndaquil", 38, 5, 2);
        gen2Pkmn[1] = new Pokemon("Totodile", 42, 2, 1);
        gen2Pkmn[2] = new Pokemon("Chikorita", 49, 1, 3);

        trainerNames();
        // Getting trainer names

        mainMenu(gen1Pkmn, gen2Pkmn, p1Pkmn, p2Pkmn);
        // Player 1 is going to get to pick which generation of pokemon they would like
        // to get first, player 2 by default get's the one that isn't picked.
        int dmg;
        int dmg2;
        while (gameRun) {
            p1PkmnInPlay = iChooseYou(p1Pkmn, p1Name);
            p2PkmnInPlay = iChooseYou(p2Pkmn, p2Name);
            // While the game loop is on, we let the pokemon pokemon in play change
            // The reason why we're setting p1 and p2 pokemon in play, is because we need to
            // know the pokemon the users want to use (and such the index, hence p1 and p2
            // pokemon in play)
            
            dmg = moveSelection(p1Pkmn, p1PkmnInPlay, p2Pkmn, p2PkmnInPlay, p1Name, p2Name);
            dmg2 = moveSelection(p2Pkmn, p2PkmnInPlay, p1Pkmn, p1PkmnInPlay, p2Name, p1Name);
            // Letting dmg and dmg2 be dmg that p1 deals and dmg2 be the damage that p2
            // deals

            // The condition below is if p1 pokemon speed is greater then p2 pokemon speed,
            // then p1 attacks before p2
            if (p1Pkmn.get(p1Name)[p1PkmnInPlay].getSpeed() > p2Pkmn.get(p2Name)[p2PkmnInPlay].getSpeed()) {

                p2Pkmn.get(p2Name)[p2PkmnInPlay].setHP(p2Pkmn.get(p2Name)[p2PkmnInPlay].getHP() - dmg);
                // p2 pokemon gets damage dealt to it
                if (p2Pkmn.get(p2Name)[p2PkmnInPlay].getStatus() == true) {
                    // The if statement above is making sure that p2 is still alive after p1 deals
                    // damage
                    p1Pkmn.get(p1Name)[p1PkmnInPlay].setHP(p1Pkmn.get(p1Name)[p1PkmnInPlay].getHP() - dmg2);
                    // p1 pokemon gets damage dealt to it
                }
                // Condition below is p2 speed is faster than p1 speed
            } else if (p2Pkmn.get(p2Name)[p2PkmnInPlay].getSpeed() > p1Pkmn.get(p1Name)[p1PkmnInPlay].getSpeed()) {
                p1Pkmn.get(p1Name)[p1PkmnInPlay].setHP(p1Pkmn.get(p1Name)[p1PkmnInPlay].getHP() - dmg2);
                // Player 1 pokemon gets damage dealt to it
                if (p1Pkmn.get(p1Name)[p1PkmnInPlay].getStatus() == true) {
                    // Condition above is making sure that player 1 pokemon is still alive
                    p2Pkmn.get(p2Name)[p2PkmnInPlay].setHP(p2Pkmn.get(p2Name)[p2PkmnInPlay].getHP() - dmg);
                    // Deal damage to player 2 pokemon
                }
            }

            if (p1Pkmn.get(p1Name)[0].getStatus() == false && p1Pkmn.get(p1Name)[1].getStatus() == false
                    && p1Pkmn.get(p1Name)[2].getStatus() == false) {
                System.out.println("Good game. Game over." + p2Name + " is the winner!!");
                System.exit(0);
                // If all p1 pokemon are fainted, then end the game and p2 has won.
            }
            if (p2Pkmn.get(p2Name)[0].getStatus() == false && p2Pkmn.get(p2Name)[1].getStatus() == false
                    && p2Pkmn.get(p2Name)[2].getStatus() == false) {
                System.out.println("Good game. Game over. " + p1Name + " is the winner!!");
                System.exit(0);
                // If all p2 pokemon are fainted, then end the game and p1 has won.
            }
        }
    }

    /**
     * This method is simply getting the usernames of both trainers. Simple enough.
     * @author Affan Amir
     */
    public static void trainerNames() { // validates Trainer username
        boolean p1Choosing = true;
        boolean p2Choosing = true;
        // Both users need to pick their trainer names
        Scanner input = new Scanner(System.in);
        while (p1Choosing) {
            System.out.println("P1, enter your name."); // Asks user to input name
            p1Name = input.nextLine();
            System.out.println("Are you sure your name is " + p1Name + "? (y/n)"); // Professor Oak line
            String choice = input.nextLine(); // Stores user's inputted name
            if (choice.equalsIgnoreCase("y")) { // If user confirms choice...
                p1Choosing = false;
            }
        }
        while (p2Choosing) {
            System.out.println("P2, enter your name."); // Asks user to input name
            p2Name = input.nextLine();
            System.out.println("Are you sure your name is " + p2Name + "? (y/n)"); // Professor Oak line
            String p2Choice = input.nextLine(); // Stores user's inputted
            if (p2Choice.equalsIgnoreCase("y")) {
                p2Choosing = false;
                System.out.println();
            }
        }
    }

    /**
     * This mainMenu method, is essentially just the main menu for the game, where
     * Player 1 is going to get to pick what generation of pokemon they get.
     * @author Affan Amir
     * @param gen1Pkmn is the gen1Pkmn array
     * @param gen2Pkmn is the Gen2Pkmn array
     * @param p1Pkmn   is the Array that is filled with player 1's pokemon (Could be
     *                 gen 1 or 2)
     * @param p2Pkmn   is the Array that is filled with player 2's pokemon (Could be
     *                 gen 1 or 2)
     */
    public static void mainMenu(Pokemon[] gen1Pkmn, Pokemon[] gen2Pkmn, HashMap p1Pkmn, HashMap p2Pkmn) {
        boolean choosing = true; // User is choosing, therefore true
        String choice; // Initialzing the variable in which answer is stored
        Scanner scanner = new Scanner(System.in); // Initializes Scanner
        while (choosing) { // Keeps code running while user is choosing
            System.out.println(
                    p1Name + ", would  you like to have a gen 1 or gen 2 pokemon team?" +
                            "\nGen 1 team: Charmander, Squirtle, Bulbasaur" +
                            "\nGen 2 team: Cyndaquil, Totodile, Chikorita" +
                            "\nEnter [1] for Gen 1, [2] for Gen 2");
            // Printing out options for which gen pokemon user can pick
            choice = scanner.nextLine(); // Allowing user to make a choice
            if (Integer.valueOf(choice) == 1) {
                for (int i = 0; i < 3; i++) {
                    p1Pkmn.put(p1Name, gen1Pkmn);
                    p2Pkmn.put(p2Name, gen2Pkmn);
                }
                // gen1InPlay = p1PkmnInPlay;
                choosing = false;
                // If P1 picks gen 1, Hashmap key is p1, value is gen 1 pkmn, also
                // choosing is now false, so we can exit loop
            } else if (Integer.valueOf(choice) == 2) {
                for (int i = 0; i < 3; i++) {
                    p1Pkmn.put(p1Name, gen2Pkmn);
                    p2Pkmn.put(p2Name, gen1Pkmn);
                }
                choosing = false;
                // If p1 picks gen 2, Hashamp key is p1, value is gen 2 pkmn, also
                // choosing is now false, so we can exit loop
            } else {
                System.out.println("Incorrect input."); // Invalid Input response
            }
        }
    }

    /**
     * iChooseYou is going to allow the user a) to pick what pokemon they first send
     * in battle, and b) to swap their pokemon once in battle
     * @author Affan Amir
     * @param pkmn        is the pkmn array that is going to get the information of
     *                    what pokemon is selected
     * @param trainerName Just the name of the trainer
     * @return The way this game is setup, is that we have an array of pokemon. We
     *         can't just have the user pick squirtle, no, we need to get the INDEX
     *         of which squirtle resides. Hence, return an int
     */
    public static int iChooseYou(HashMap<String, Pokemon[]> pkmn, String trainerName) {
        String inPlay = ""; // Initializing the variable in which answer is stored
        boolean choosing = true; // Choosing is true
        Scanner scanner = new Scanner(System.in); // Creating scanner
        while (choosing) { // While we have not picked
            System.out.println(trainerName + ", what Pokemon would you like to send out?");
            for (int i = 0; i < 3; i++) {
                System.out.println(pkmn.get(trainerName)[i].getName() + ", press [" + i + "]" + " alive status: "
                        + pkmn.get(trainerName)[i].getStatus());
            }
            // What the code above is doing is, running thru the array that has been passed
            // as a parameter, checking the actual pokemon object at each index, and calling
            // the getName() method for each object, and tells the user the index at which
            // each pokemon reside
            inPlay = scanner.nextLine();
            if ((inPlay.equals("0") && pkmn.get(trainerName)[0].getStatus() == true)
                    || (inPlay.equals("1") && pkmn.get(trainerName)[1].getStatus() == true)
                    || (inPlay.equals("2")) && pkmn.get(trainerName)[2].getStatus() == true) {
                // if statement is making sure we aren't sending out a dead pokemon
                System.out.println(trainerName + " is sending out "
                        + pkmn.get(trainerName)[Integer.valueOf(inPlay)].getName() + "!");
                // Telling trainer what pokemon they sent out
                choosing = false;
                // Tell user which pokemon they selected and let choosing be false
            } else if (pkmn.get(trainerName)[Integer.valueOf(inPlay)].getStatus() == false) {
                System.out.println("Pokemon is dead, pick another.");
            } else {
                System.out.println("Not a valid pokemon, try again"); // Invalid input response
            }
        }
        return Integer.valueOf(inPlay); // Since technically what we have is a string, but we're returning an int, we
                                        // can simply call Integer.valueOf()
    }

    /**
     * Type advantage is going to calculate a float number which is calculated by
     * typing-matches
     * @author Affan Amir
     * @param type1 type 1 is the elemental type of the pokemon attacking
     * @param type2 type 2 is the elemental type of the pokemon defending
     * @param dmg   dmg is the damage going to be dealt after type advantages
     * @return the damage as a float number.
     */
    public static float typeAdvantage(int type1, int type2, int dmg) {
        // Float adv is going to be the number that is multiplied or divided by the
        // type-advantage
        float adv = 1.25f;

        if (type1 == (type2)) {
            return dmg;
            // Return the damage as the regular damage given if the types are the same
        } else if ((type1 == 1 && type2 == 2) || (type1 == 2 && type2 == 3) || (type1 == 3 && type2 == 1)) {
            System.out.println("Move was super effective!");
            return (dmg * adv);
            // Return the damage as damage * adv if move is super effective
        } else {
            System.out.println("Move was not very effective...");
            return (dmg / adv);
            // Return the damage as damage divided by advantaged if move is not effective
        }
    }

    /**
     * moveSelection is one step into the action selection, once the user has
     * selected to make a move
     * @author Affan Amir
     * @param pkmn        is the array of pkmn doing the attacking
     * @param inPlay      is the index number of the pkmn that is actually (hence
     *                    the name, in play)
     * @param enemyPkmn   is the array of pkmn defending/waiting to make a move
     * @param enemyInPlay is the index number of the enememy pokemon that is swapped
     *                    in (hence the name, enemy in play)
     * @param oppName     //I'll get back to this one later, broken asf as of rn
     */
    public static int moveSelection(HashMap<String, Pokemon[]> pkmn, int inPlay, HashMap<String, Pokemon[]> enemyPkmn,
            int enemyPkmnInPlay,
            String playerName, String enemyName) {

        Scanner scanner = new Scanner(System.in);
        String chooseMove = "";
        boolean choosingMove = true;
        // Creating scanner, and choosing move
        while (choosingMove) {

            if (pkmn.get(playerName)[inPlay].getType() == 1) {
                pkmn.get(playerName)[inPlay].getName(moves);
                pkmn.get(playerName)[inPlay].printMoves(moves, "Water");
                // Gettings the names, and printing the moves
                chooseMove = scanner.nextLine();
                if (chooseMove.equals("1")) {
                    choosingMove = false;
                    return tackle.doDmg();
                    // Returning the damage that tackle deals
                } else if (chooseMove.equals("2") && waterGun.getPP() != 0) {
                    choosingMove = false;
                    waterGun.setPP(waterGun.getPP() - 1);
                    return (int) typeAdvantage(pkmn.get(playerName)[inPlay].getType(),
                            enemyPkmn.get(enemyName)[enemyPkmnInPlay].getType(), waterGun.doDmg());
                    // Returning the damage that watergun deals
                }
            } else if (chooseMove.equals("3")) {
                System.out.println("It started raining!!! Water Type Moves are stronger!");
                vineWhip.setTerrainAdvantage(false);
                ember.setTerrainAdvantage(false);
                waterGun.setTerrainAdvantage(true);
                // user prompt to let them know terrain advantage is in play, also set terrain
                // advantage for everything else to false
                return 0;
                // Return 0 since move does no damage
            }

            if (pkmn.get(playerName)[inPlay].getType() == 2) {
                pkmn.get(playerName)[inPlay].getName(moves);
                pkmn.get(playerName)[inPlay].printMoves(moves, "Fire");
                // Getting the names, and then printing out the moves
                chooseMove = scanner.nextLine();
                if (chooseMove.equals("1")) {
                    choosingMove = false;
                    return tackle.doDmg();
                    // Returning the damage that tackle deals
                } else if (chooseMove.equals("2") && ember.getPP() != 0) {
                    choosingMove = false;
                    ember.setPP(ember.getPP() - 1);
                    return (int) typeAdvantage(pkmn.get(playerName)[inPlay].getType(),
                            enemyPkmn.get(enemyName)[enemyPkmnInPlay].getType(), ember.doDmg());
                    // If pokemon chooses to use tackle, remove the amount of HP tackle does from
                    // pokemon
                }

                else if (chooseMove.equals("3")) {
                    System.out.println("The sun is scorching!!!! Fire Type Moves are Stronger!!");
                    vineWhip.setTerrainAdvantage(false);
                    waterGun.setTerrainAdvantage(false);
                    ember.setTerrainAdvantage(true);
                    // Creating a fire advantage, but turning off advantage for all else
                    return 0;
                }
            }

            if (pkmn.get(playerName)[inPlay].getType() == 3) {
                pkmn.get(playerName)[inPlay].getName(moves);
                pkmn.get(playerName)[inPlay].printMoves(moves, "Grass");
                // Getting the names, and then printing out the moves
                chooseMove = scanner.nextLine();
                if (chooseMove.equals("1")) {
                    choosingMove = false;
                    return tackle.doDmg();
                    // If pokemon chooses to use tackle, remove the amount of HP tackle does from
                    // pokemon
                } else if (chooseMove.equals("2") && vineWhip.getPP() != 0) {
                    choosingMove = false;
                    vineWhip.setPP(vineWhip.getPP() - 1);
                    return (int) typeAdvantage(pkmn.get(playerName)[inPlay].getType(),
                            enemyPkmn.get(enemyName)[enemyPkmnInPlay].getType(), vineWhip.doDmg());
                    // Returning an integer for vineWhip
                } else if (chooseMove.equals("3")) {
                    System.out.println("Grass Grew All Over the Battle Field!!! Grass Type Moves are Stronger!!");
                    waterGun.setTerrainAdvantage(false);
                    ember.setTerrainAdvantage(false);
                    vineWhip.setTerrainAdvantage(true);
                    // Creating a grassy field, but turning off type advantage for all else
                    return 0;
                    // Move itself does no damage, return 0
                }
            }
        }
        return 0;
    }
}
