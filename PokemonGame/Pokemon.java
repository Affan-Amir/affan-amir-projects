class Pokemon extends Type {
    private boolean alive = true; // All pokemon are going to start off alive
    private long hp;
    private int speed;
    private int type;
    private String name;

    /*
     * For all variables above, we know that each pokemon is going to have a
     * specific value, so we can create a constructor that assigns values for all of
     * these.
     * It is also important to note that 'type' is an integer (ie, "water"
     * would be 1). The reason why this is done, is because it would be easier to
     * compare integers (comparing 1 to 2) than to compare string (comparing "fire"
     * to "water")
     * 
     * Water = 1, Fire = 2, Grass = 3
     */

    /**
     * This is the constructor for pokemon
     * 
     * @author Affan Amir
     * @param name  name of the pokemon
     * @param hp    hp of the pokemon
     * @param speed sped of the pokemon
     * @param type  type of pokemon
     */
    public Pokemon(String name, int hp, int speed, int type) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.type = type;
        // Setting all the variables
    }

    /**
     * This is a getter for name. It is important to note that we don't have a set
     * name method since we never would really need to change name
     * 
     * @author Affan Amir
     * @return just return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Pokemon needs to be able to get status
     * 
     * @author Affan Amir
     * @return the status
     */
    public boolean getStatus() {
        return alive;
    }

    /**
     * Set the status of the pokemon to the boolean
     * 
     * @author Affan Amir
     * @param alive the status of the parameter getting called
     */
    public void setStatus(boolean alive) {
        this.alive = alive;
    }

    /**
     * This is a getter for speed. We would never need to set speed since it's in
     * the constructor
     * 
     * @author Affan Amir
     * @return return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * This is a getter for the type. Don't need a setter since it's in constructor.
     * 
     * @author Affan Amir
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Getter for HP value. We DO need a set HP method since it's what's actually
     * dealing damage to pokemon.
     *
     * @author Affan Amir      
     * @return the hp of the pokemon
     */
    public long getHP() {
        return hp;
    }

    /**
     * This is a setter for HP. We need to constantly change the HP of a pokemon, as
     * we are dealing damage constantly
     * 
     * @author Affan Amir
     * @param hp we need to take a parameter, as we need to get the damage done to
     *           the pokemon, and subtract that from the current HP of the pokemon
     */
    public void setHP(long hp) {
        this.hp = hp;
        if (hp <= 0) {
            alive = false;
            System.out.println(name + " Fainted!!\n_________________________________");
        } else {
            System.out.println("HP of " + name + " is: " + hp + "\n_________________________________");
        }
    }
}