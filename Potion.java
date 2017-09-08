
/**
 * The Potion class is used to recruit the bear or cat companion, otherwise returns a generic message.
 * This gets removed from the inventory after use but can be re-looted.
 * 
 * @author 162224
 * @version 09/11
 */
public class Potion extends Item
  {

    
    //Item description to be called if the player views inventory
    public Potion(int x, int y, int width, int height)
    {
        super(x, y, width, height, "potion.png");
        itemDesc = "Potion of Questionable Intent";
    }     

     /**
     * Using the potion in the presence of the bear or cat will remove it from the room and add them to the inventory.
     * @param the current player, current room and game state 
     */ 
    public void UseItem(Game game)
    {
       if (game.currentRoom.creatures.containsKey("bear")){
        Creature Bear = game.currentRoom.getCreature("bear");
        game.currentRoom.removeCreature("bear");
        game.player.addCompanion("bear", Bear);
        Logger.Log("You use the Potion of Questionable Intent.\nYou have the brilliant idea of approaching the bear.\nHe actually is much more friendly than you first thought! See, you shouldn't judge.\nYou made a bear friend!");
        }
       else if (game.currentRoom.creatures.containsKey("cat")){
        Creature Cat = game.currentRoom.getCreature("cat");
        game.currentRoom.removeCreature("cat");
        game.player.addCompanion("cat", Cat);
        Logger.Log("You use the Potion of Questionable Intent.\nYou decide to chase the little winged kitty.\nLuckily for you it's extremely playful and enjoys the chase. After some frolicking, he follows you about.\nYou made a cat friend!");
        }
        else {
         Logger.Log("You use the Potion of Questionable Intent by uncorking it and glugging it down. The room swims a bit but you don't mind. You're having quite the adventure, after all!");
        }

    }
    
}

