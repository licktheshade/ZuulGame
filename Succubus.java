
/**
 * This is the Succubus companion, a subclass of Creature, who can be used to fight the Dragon boss
 * 
 * @author 162224
 * @version 13/11
 */
public class Succubus extends Creature
{
    
    //Item description to be called if the player views companions
  public Succubus(int x, int y, int width, int height)
    {
       super(x, y, width, height, "succubus.png");
       name = "Succubus";
    }
    
     /**
     * Allows the dragon to be defeated.
     * There is no effect when used against the faerie or princess.
     * @param the current player, current room and game state
     * 
     */ 
    public void UseCompanion(Game game)
    {
       if (game.currentRoom.creatures.containsKey("dragon")&&game.player.defeated.containsKey("faerie")){
        Creature Dragon = game.currentRoom.getCreature("dragon");
        game.currentRoom.removeCreature("dragon");
        game.player.addBoss("dragon", Dragon);
        Logger.Log("The dragon seems different somehow since you last saw it. Less... shiny.\n'Oh my!' the succubus exclaims, 'This poor dragon has had it's power leached!'. She puts her finger to her voluptuous lips. 'I bet it's the faeries...' she narrows her eyes at you. 'Is this your fault?!'\nWithout waiting for an answer she goes to the dragon and lays her palm on his jaw. 'Are you alright darling?!'\nThe dragon growls and she pats it lovingly.\n'There, there, it's alright. You'll get your power back.... Let's go somewhere and chill out, alright?'\nShe looks back at you with a glower. 'You better get out of here' she hisses, before vanishing in a flash of fire with the dragon in tow.");
        Logger.Log("Now that the bosses of the land are gone, perhaps you can seek a reward at the palace.");
        flees = true;
      }
       else if (game.currentRoom.creatures.containsKey("princess")){
        Logger.Log("'Ew' says the succubus. 'I hate this chick. I'm not helping you here.'");
        }
       else if (game.currentRoom.creatures.containsKey("dragon")){
        Logger.Log("'Ummm... no.' The succubus holds up her palm. 'This dude is super powerful.\nI really can't do anything right now. Perhaps if he's a bit more docile....'"); 
        }
       else if (game.currentRoom.creatures.containsKey("faerie")){
        Logger.Log("The succubus blushes furiously.\n'I could totally destroy these faeries. I just don't want to right now.'\nYou have the feeling her magic won't work here.");    
        }
       else {
         Logger.Log("The succubus picks at her claws.\n'What?'");
        }
    
    }
  
}

