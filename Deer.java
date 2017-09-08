
/**
 * The deer can be recruited with the Herb and is used to defeat the princess, once the dragon and faerie have been eliminated
 * 
 * @author 162224
 * @version 13/11
 */
public class Deer extends Creature
 {
    
     //Item description to be called if the player views companions
    public Deer(int x, int y, int width, int height)
    {
       super(x, y, width, height, "deer.jpg");
       name = "Deer";
    }
    
     /**
     * Returns the true game ending if used against the pricess.
     * If used against the dragon, the game is over.
     * There is no effect when used against the faerie.
     * @param the current player, current room and game state
     * 
     */ 
    public void UseCompanion(Game game)
    {
    
       if (game.currentRoom.creatures.containsKey("princess")&&game.player.defeated.containsKey("dragon")&&game.player.defeated.containsKey("faerie")){
        Logger.Log("The princess is clearly bereaved from the loss of her favourite pets.\nAt the sight of your deer friend she pauses and runs her snotty nose on her sleeve.\n'Is that your pet?' she asks. Whilst you are fond of your deer friend, you feel this spoilt princess may be your ticket home.\n'Yes', you reply. 'Would you like to keep him?'\n'OMG Totes!!!' She throws her arms in the air with glee. 'I expect you want some kind of payment, little' + player.playerName '.'\n'I just want to go home...' you trail off.\n'Alright, whatever', the princess replies, and throws a magic ring at you.\nYou put it on and the world fades around you. The last thing you see is the reproachful look of your deer friend who you so willingly gave up.\nBut you are home! You win! Yay.");
        game.finished = true;
        }
       else if (game.currentRoom.creatures.containsKey("princess")){
        Logger.Log("The princess doesn't even look at you. Perhaps you should come back later...");
        }
        else if (game.currentRoom.creatures.containsKey("dragon")){
        Logger.Log("The dragon takes one look at your deer and roasts her on the spot. Now there is nothing between you and his huge, dripping jaws. The last thing you see is the yellow spark of ignition in his throat before you are engulfed in flames and then eaten like a flash-fried burger."); 
        game.gameOver = true;
        }
        else if (game.currentRoom.creatures.containsKey("faerie")){
        Logger.Log("The deer rears away from you. How could you try and make it fight these delightful faerie creatues?");    
        }
        else {
         Logger.Log("The deer looks at you with thinly veiled contempt. It's a deer, what can you expect it to do?");
        }
    
    }
  
}
