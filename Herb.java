
/**
 * The Herb class is used to recruit the deer or cat companion, otherwise returns a generic message.
 * This gets removed from the inventory after use but can be re-looted.
 * 
 * @author 162224
 * @version 09/11
 */
public class Herb extends Item
 {

    //Item description to be called if the player views inventory
    public Herb(int x, int y, int width, int height)
    {
        super(x, y, width, height, "herb.png");
        itemDesc = "Herb of Enlightenment";
    }
    
    /**
     * Using the potion in the presence of the deer or cat will remove it from the room and add them to the inventory.
     * @param the current player, current room and game state 
     */ 
    public void UseItem(Game game)
    {
    
       if (game.currentRoom.creatures.containsKey("deer")){
        Creature Deer = game.currentRoom.getCreature("deer");
        game.currentRoom.removeCreature("deer");
        game.player.addCompanion("deer", Deer);
        Logger.Log("You use the Herb of Enlightenment.\nThe deer blinks slowly and steps towards you.\nShe sniffs at the herb and gingerly nibbles it from your outstretched hand. Once it's gone, she nuzzles her head against you.\nYou made a deer friend!");
        }
        
       if (game.currentRoom.creatures.containsKey("cat")){
        Creature Cat = game.currentRoom.getCreature("cat");
        game.currentRoom.removeCreature("cat");
        game.player.addCompanion("cat", Cat);
        Logger.Log("You use the Herb of Enlightenment.\nThe cat stops rolling around in mid-air and glides closer. It begins to purr very loudly and rubs it's neck against you. It seems this cat wants to come with you now.");
        }
       else {
         Logger.Log("You use the Herb of Enlightenment. In this case, by eating it.\nYou feel a sense of calm and giddiness, and decide that being trapped in Magical Realm Land isn't really so bad after all.");
        }
    }
    }
