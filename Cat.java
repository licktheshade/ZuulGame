
/**
 * The Cat can be recruited with any item (except the mushroom) and will flee at every boss
 * though can defeat the faerie
 * 
 * @author 162224
 * @version 13/11
 */

public class Cat extends Creature
{
 
    //Item description to be called if the player views companions
    public Cat (int x, int y, int width, int height)
    {
       super(x, y, width, height, "cat.png");
       name = "Winged Cat";
    }
    
     /**
     * Allows the faerie to be defeated.
     * There is no effect when used against the dragon or the princess, except fleeing.
     * @param the current player, current room and game state 
     */ 
    public void UseCompanion(Game game)
    {
       if (game.currentRoom.creatures.containsKey("princess")){
        Logger.Log("'A cat? Ew.' The princess seems totally unimpressed.");
        flees = true;
        }
       else if (game.currentRoom.creatures.containsKey("dragon")){
        Logger.Log("The cat freaks out and flies away. Why did you pit a cat against a dragon?");
        flees = true;
        }
       else if (game.currentRoom.creatures.containsKey("faerie")){
        Creature Faerie = game.currentRoom.getCreature("faerie");
        game.currentRoom.removeCreature("faerie");
        game.player.addBoss("faerie", Faerie);
        Logger.Log("Upon seeing the relaxing fae, the cat crouches low, pupils wide. It adjusts its position slightly before half leaping, half-flying and swatting the faerie with its paws.\nYou hear a contented purr amongst the tiny shrieks as the poor creature is tormented by the delighted cat.");
        flees = true;          
       }
       else {
         Logger.Log("The cat chirrups as it looks up at you, before preening its luxurious wings.");
        }
    
    }
  
}
