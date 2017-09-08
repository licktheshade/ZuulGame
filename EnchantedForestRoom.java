
/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnchantedForestRoom extends Room
{
    public EnchantedForestRoom(){
        super(1);
        description = "are in an Enchanted Forest";
        longdescription = "The wilderness around you is wonderfully peaceful and lush.\nYou can hear the wind swaying through the trees and the twittering of sweet birds all around.\nTo the west, a brightly coloured slope rises above you.\nTo the east lies a delighful trail through the woods.\nSouth, there is a thickening of the forest.";
        imageFile = "enchantedForest.jpg";
    }
    
    @Override protected void setItems(){

    }
    
    @Override protected void setCreatures(){
        
    }
}
