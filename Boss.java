
/**
 * Boss is a specific type of creature that cannot be taken
 * 
 * @author 162224
 * @version 13/11
 */
public class Boss extends Creature
{
        
    /**
     * Boss name is initialised in their respective room class, 
     * all bosses act the same so there is no need for seperate subclasses.
     */

    public Boss(String name, int x, int y, int width, int height)
    {
       super(x, y, width, height, name + ".png");
       this.name = name;
    }
    
    /**
     * An empty method here as bosses cannot be used by the player.
     * However subsequent versions of the game may utilise this method.
     * @param the current player, current room and game state
     */
    public void UseCompanion(Game game)
    {    
    }
}
