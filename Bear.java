
/**
 * This is the Bear companion, a subclass of Creature, who can be used to fight the Faerie boss
 * 
 * @author 162224
 * @version 13/11
 */
public class Bear extends Creature

{    
    //Item description to be called if the player views companions
    public Bear(int x, int y, int width, int height)
    {
       super(x, y, width, height, "bear.png");
       name = "Bear";
    }
    
     /**
     * Allows the faerie to be defeated.
     * If used against the princess, the game is over.
     * There is no effect when used against the dragon.
     * @param the current player, current room and game state 
     */ 
    public void UseCompanion(Game game)
    {
       if (game.currentRoom.creatures.containsKey("princess")){
        Logger.Log("'Ooh!' the princess shrieks, 'that pelt would look fabulous on the hall floor!\nShe pulls out a shotgun and begins to fire. Unfortunately for you, she is a terrible shot and misses the bear, getting you square between your shoulderblades as you turn to flee.");
        game.gameOver = true;
        }
       else if (game.currentRoom.creatures.containsKey("dragon")){
        Logger.Log("The bear roars and turns away. He has a good sense of self-preservation."); 
        flees = true;
        }
       else if (game.currentRoom.creatures.containsKey("faerie")){
        Creature Faerie = game.currentRoom.getCreature("faerie");
        game.currentRoom.removeCreature("faerie");
        game.player.addBoss("faerie", Faerie);
        Logger.Log("The huge bear lumbers over to where the faerie floats in the spring.\nBefore she has time to react, he takes her in his mouth and shakes his head furiously. You see her body go limp before the crunch of bones as he devours her and growls with joy.\nWith this seemingly satisfying meal, he himself climbs into the hot spring and takes the faerie's place.");            
        flees = true;
       }
       else {
         Logger.Log("The bear butts your shoulder with his large head.");
        }
    
    }
  
}
