import java.util.*;

class Moves {
    String move;
    int dmg, type, pp;
    private boolean terrainAdvantage = false;
    // Above we are declaring variables(AKA attributes) that all moves have.
    // Pay special attention to private typeAdvantage. This is because we do not
    // want anyone to be able to edit this, and should only be edited with getters
    // and setters.

    Moves(String move, int dmg, int type, int pp) {
        this.move = move;
        this.dmg = dmg;
        this.type = type;
        this.pp = pp;
    }

    /**
     * Getter for terrain advantages
     * 
     * @author Affan Amir
     * @return whether it is true if there is a terrain advantage or not
     */
    public boolean getTerrainAdvantage() {
        return terrainAdvantage;
    }

    /**
     * Setter for type advantages
     * 
     * @author Affan Amir
     * @param terrainAdvantage we need to understand that all we are doing is
     *                         changing a variable to true, hence taking in the
     *                         parameter
     */
    public void setTerrainAdvantage(boolean terrainAdvantage) {
        this.terrainAdvantage = terrainAdvantage;
    }

    /**
     * Method that calculates the amount of damage that should be done to the
     * pokemon
     * 
     * @author Affan Amir
     * @return the damage, as an integer
     */
    public int doDmg() {
        Random moveRNG = new Random();
        if ((moveRNG.nextInt(10) + 1) == 10) {
            System.out.println("Attack Missed!");
            return 0;
        } else if (terrainAdvantage == true) {
            int newDmg = (int) Math.round(dmg * 1.25);
            return newDmg;
        }
        return dmg;
    }

    /**
     * Getter for the name of the move
     * 
     * @author Affan Amir
     * @return the name of the move
     */
    public String getMove() {
        return move;
    }

    /**
     * Getter for the amount of PP the pokemon has left for a move
     * 
     * @author Affan Amir
     * @return the amount of pp left for the pokemon
     */
    public int getPP() {
        return pp;
    }

    /**
     * Setter for the amount of PP the pokemon has left.
     * 
     * @author Affan Amir
     * @param pp will literally just be current pp - 1
     */
    public void setPP(int pp) {
        this.pp = pp;
        if (pp == 0) {
            System.out.println("Move out of PP!");
        } else {
            System.out.println(pp + " PP remaining");
        }
    }
}