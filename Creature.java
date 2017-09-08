
/**
 * Abstract class Creature, the superclass for both Companions and Bosses
 * 
 * @author 162224
 * @version 13/11
 */
public abstract class Creature extends Drawable
{
    // name provided to each creature and a boolean to determine if they leave the player after a given interaction
    
    public boolean flees = false;
    public String name;
    
    public Creature(int x, int y, int w, int h, String image){
        super(x, y, w, h, image);
    }
    
    /**
     * A method for the player to use a recruited companion
     * @param the player, room and game state
     * @returns unique possibilities based on the companion
     * 
     */
    public abstract void UseCompanion(Game game);
    
    
}
