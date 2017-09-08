
/**
 * The Crystals class is used to recruit the succubus or cat companion, otherwise returns a generic message.
 * This gets removed from the inventory after use but can be re-looted.
 * 
 * @author 162224
 * @version 09/11
 */
public class Crystals extends Item
{
    
     //Item description to be called if the player views inventory
    public Crystals(int x, int y, int width, int height)
    {
        super(x, y, width, height, "crystal.png");
        this.itemDesc = "Crystals of Confidence"; //
    }

    
    /**
     * Using the potion in the presence of the succubus or cat will remove it from the room and add them to the inventory.
     * @param the current player, current room and game state 
     */ 
    
    public void UseItem(Game game)
    {
       if (game.currentRoom.creatures.containsKey("succubus")){ //Using the item only has an effect when in the room containing the succubus
        Creature Succubus = game.currentRoom.getCreature("succubus");
        game.currentRoom.removeCreature("succubus");
        game.player.addCompanion("succubus", Succubus);
        Logger.Log("You use the Crystals of Confidence.\nThe succubus stops ignoring you and comes over for a chat.\nAfter hearing of your plight, she takes pity and decides to help you.\nYou made a succubus friend!");
        }
        else if (game.currentRoom.creatures.containsKey("cat")){
        Creature Cat = game.currentRoom.getCreature("cat");
        game.currentRoom.removeCreature("cat");
        game.player.addCompanion("cat", Cat);
        Logger.Log("You use the Crystals of Confidence.\nYou stride up to the cat and demand it help you on your quest.\nThe cat, being very polite, obliges.\nYou made a cat friend!");
        }
        else {
         Logger.Log("You use the Crystals of Confidence.\nNot much happens, but you're much more hopeful about getting yourself home.");
        }
    }
    
    
}
