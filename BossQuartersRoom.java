/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossQuartersRoom extends Room
{
    public BossQuartersRoom(){
      super(16);
      description = "are in the scary Boss Quarters";
      longdescription = "In front of you, perched upon an exquisite ivory throne,\na clearly spoilt princess is sitting on it with her legs swung over the arms, chatting animatedly on a phone.\nAfter this long journey you've been on, you reckon if anyone can help you, it's her.\nBut she is totally uninterested in your presence and your attempts to get her attention are futile.";
      imageFile = "bossQuarters.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("princess", new Boss("Princess",330, 175, 203, 203));
    }
}
