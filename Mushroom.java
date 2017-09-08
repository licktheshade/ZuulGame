import java.util.Random;

/**
 * The Mushroom class is not actually used in gameplay but introduces the random possibiity of an early game termination on consumption
 * 
 * @author 162224
 * @version 09/11
 */
public class Mushroom extends Item
 {
    private Random random;
    
    
    //Item description to be called if the player views inventory
    public Mushroom(int x, int y, int width, int height)    
    {
      super(x, y, width, height, "mushroom.png");
      itemDesc = "Mysterious Mushroom";
    }
    
    /**
     * Retrieves a random number to use in the useItem method
     */
    public int getRandomInt() {
      random = new Random();
      int value = random.nextInt((100 - 1) + 1) + 1;
      return value;
    }
    
    /**
     * Using the mushroom has a 20% of ending the game. Otherwise returns a print statement and is removed from the inventory.
     * @param the current player, current room and game state 
     */
    public void UseItem(Game game)
    {
       
       int newvalue = getRandomInt();      
       
       if (newvalue > 20) {
       Logger.Log("You eat a mushroom. It's tasty!");
        }
        else {
           Logger.Log("You eat the mushroom.\nAfter 20 minutes the world darkens around you and you can't shake the feeling of creeping terror.\nTwisted hallucinations begin to dominate your vision and everything fades to black.");
           game.gameOver = true;
            }
       
    
    }
    
}