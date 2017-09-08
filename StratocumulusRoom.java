 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StratocumulusRoom extends Room
{
    public StratocumulusRoom(){
      super(12);
      description = "are low to the earth in the Stratocumulus";
      longdescription = "Behind some dark clouds there is an even darker shadow, followed by a bright flash and a harrowing, reptilian groan.\nIt's a dragon!!!";
      altdescription = "This plane of clouds seems much more peaceful without the dragon.";
      imageFile = "stratocumulus.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("dragon", new Boss("dragon", 100, 75, 400, 400));
    }
}
