/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecretHotSpringRoom extends Room
{
    public SecretHotSpringRoom(){
       super(6);
       description = "have found some Secret Hot Springs!";
       longdescription = "You get some respite from the pressing heat. As you wipe your brow, you see a faerie relaxing in the pool.\nShe looks at you, startled, then defensively raises her hand as if to cast some magic. Maybe one of your friends can help you.";
       altdescription = "The Hot Springs are eerily quiet after the earlier showdown. There is no sight of your old companion.";
       imageFile = "secretHotsprings.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("faerie", new Boss("faerie",300, 200, 185, 185));
    }
}
