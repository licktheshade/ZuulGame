import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.util.Iterator;

/**
 * This is the main class of the Magical Realm Land program.
 * Users are to walk around rooms, interacting with items until they reach the end of the game.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, items and creatures, creates the parser and player and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author 162224
 * @version 15/11
 * 
 */

public class Game 
{
    public Parser parser;
    public Player player;
    public Room currentRoom;
    private ArrayList<Room> allrooms; //A store of all rooms for use by the Portal
    private ArrayList<String> userInputs;
    private Random random;
    boolean finished = false; //A boolean to determine the end of game
    boolean gameOver = false; //Another boolean to determine an early termination of the game through user actions
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        Logger.setLogger(null);
        createInstances();
        parser = new Parser();
        player = new Player();
        userInputs = new ArrayList<String>();
    }
    
   /**
     * A method which retrieves a random room from the array of available rooms
     * 
     */
   public Room getRandomRoom() {
        random = new Random();
        Room portal = allrooms.get(random.nextInt(allrooms.size()-1));
        return portal;
    }
    
    /**
     * Create all the rooms and link their exits together.
     * Also initialises items and creatures and places them
     * 
     */
    private void createInstances()
    {
        Room EnchantedForest, IdyllicGlade, GumdropHill, DenseWoods, VolcanoHell, SecretHotSpring, MagmaChamber, MysteriousCloud, SkyParadise, Cirrostratus, Nimbostratus, Stratocumulus, WaterTemple, Whirlpool, EyeoftheStorm, BossQuarters, Portal;
        
        random = new Random();
        allrooms = new ArrayList<Room>();
        
        // create the rooms providing an ID to be passed into the room constructor
        EnchantedForest = new EnchantedForestRoom();
        allrooms.add(EnchantedForest);
        IdyllicGlade = new IdyllicGladeRoom();
        allrooms.add(IdyllicGlade);
        GumdropHill = new GumdropHillRoom();
        allrooms.add(GumdropHill);
        DenseWoods = new DenseWoodsRoom();
        allrooms.add(DenseWoods);
        VolcanoHell = new VolcanoHellRoom();
        allrooms.add(VolcanoHell);
        SecretHotSpring = new SecretHotSpringRoom();
        allrooms.add(SecretHotSpring);
        MagmaChamber = new MagmaChamberRoom();
        allrooms.add(MagmaChamber);
        MysteriousCloud = new MysteriousCloudRoom();
        allrooms.add(MysteriousCloud);
        SkyParadise = new SkyParadiseRoom();
        allrooms.add(SkyParadise);
        Cirrostratus = new CirrostratusRoom();
        allrooms.add(Cirrostratus);
        Nimbostratus = new  NimbostratusRoom();
        allrooms.add(Nimbostratus);
        Stratocumulus = new StratocumulusRoom();
        allrooms.add(Stratocumulus);
        WaterTemple = new WaterTempleRoom();
        allrooms.add(WaterTemple);
        Whirlpool = new WhirlpoolRoom();
        allrooms.add(Whirlpool);
        EyeoftheStorm = new EyeoftheStormRoom();
        allrooms.add(EyeoftheStorm);
        BossQuarters = new BossQuartersRoom();       
        allrooms.add(BossQuarters);
        Portal = new PortalRoom();
        
        
        // initialise room exits, items and creatures
        EnchantedForest.setExit("east", IdyllicGlade);
        EnchantedForest.setExit("west", GumdropHill);
        EnchantedForest.setExit("south", DenseWoods);
                
        IdyllicGlade.setExit("west", EnchantedForest);
        
        GumdropHill.setExit("down", EnchantedForest);
        GumdropHill.setExit("up", MysteriousCloud);

        DenseWoods.setExit("north", EnchantedForest);
        DenseWoods.setExit("south", VolcanoHell);
        
        MagmaChamber.setExit("north",VolcanoHell);
        
        VolcanoHell.setExit("east", SecretHotSpring);
        VolcanoHell.setExit("north", DenseWoods);
        VolcanoHell.setExit("west", MysteriousCloud);
        VolcanoHell.setExit("south", MagmaChamber);
        
        SecretHotSpring.setExit("west", VolcanoHell);
        
        MysteriousCloud.setExit("west", VolcanoHell);
        MysteriousCloud.setExit("in", Portal);
        MysteriousCloud.setExit("up", SkyParadise);
        
        SkyParadise.setExit("down", MysteriousCloud);
        SkyParadise.setExit("up", Cirrostratus);
        SkyParadise.setExit("east", Nimbostratus);
        
        Cirrostratus.setExit("north", SkyParadise);
        Cirrostratus.setExit("down", WaterTemple);
 
        Nimbostratus.setExit("west", SkyParadise);
        Nimbostratus.setExit("east", Stratocumulus);
        
        Stratocumulus.setExit("west", Nimbostratus);
        Stratocumulus.setExit("down", WaterTemple);
        
        WaterTemple.setExit("up",Stratocumulus);
        WaterTemple.setExit("high", Cirrostratus);
        WaterTemple.setExit("down", Whirlpool);
        WaterTemple.setExit("in", BossQuarters);
        
        Whirlpool.setExit("up", WaterTemple);
        Whirlpool.setExit("down", EyeoftheStorm);
                
        EyeoftheStorm.setExit("up", Whirlpool);
        EyeoftheStorm.setExit("in", BossQuarters);
        
        BossQuarters.setExit("out", WaterTemple);
        
        currentRoom = EnchantedForest; 
    }
    
 
    
    
    public void guiCommand(String inputText){
        if (finished) return;
        
        inputText = inputText.trim().toLowerCase();
        
        Logger.Log("> " + inputText);
        userInputs.add(inputText);
        
        if (inputText.equals("quit")){
           Logger.Log("Thank you for playing.  Good bye.");
           finished = true;
           quitGame();
           return;
        }
        
        
        String[] words = inputText.split(" ");
    
        if (words.length != 2) {
            Logger.Log(inputText + " is not a valid command.");
            return;
        }
               
        String word1 = words[0];
        String word2 = words[1];
        
        Command command = new Command(parser.commands.getCommandWord(word1), word2);
        finished = processCommand(command);
        

        
        
        
        
        
        if (gameOver){
            Logger.Log("Your adventure is over...");
            finished = true;
            quitGame();
            return;
        }
        if (finished){
            Logger.Log("Thank you for playing.  Good bye.");
            quitGame();
            return;
        }
        

    }

    public void quitGame(){
      
       try{
            PrintWriter writer = new PrintWriter("userlog.txt", "UTF-8");
            for(String s : userInputs){
              writer.println(s);
            }
            writer.close();
        }
        catch (Exception e){
            Logger.Log("Unable to write to file");
        }
    }
    
    /**
     *  Main play routine for console version.  Loops until end of play.
     */
    public void playConsole(){
        consoleWelcome();
        
        while (! finished) {
            if (gameOver) {
                Logger.Log("Your adventure is over...");
                break;
            }
           Command command = parser.getCommand();
           finished = processCommand(command);    
        }
        if (!gameOver) {    
            Logger.Log("Thank you for playing.  Good bye.");
        }
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void consoleWelcome()
    {
        welcomePartOne();

        Scanner reader = new Scanner(System.in);
        String playerName = reader.nextLine();
        player.playerName = playerName;
        
        welcomePartTwo();
    }
    
    public void welcomePartOne(){
        Logger.Log("");
        Logger.Log("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        Logger.Log("Welcome to the Magical Realm Land");
        Logger.Log("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        Logger.Log("Magical Realm Land is a wonderous place full of secrets and adventure!");
        Logger.Log("");
        Logger.Log("What is your name, daring explorer?");
    }
    
    public void welcomePartTwo(){
        Logger.Log("");
        Logger.Log("");
        Logger.Log("Well hello there, " + player.playerName);
        Logger.Log("");
        Logger.Log("You seem to have found yourself in a land far away from home with no idea how you arrived.");
        Logger.Log("");
        Logger.Log("Your task is to get yourself home!");
        Logger.Log("");
        Logger.Log("There are a few things you can do to get yourself back.");
        Logger.Log("Try typing 'look' in new areas to see what you can find!");
        Logger.Log("You may be able to take items, or use them to recruit companions who you can use against bosses.");
        Logger.Log("");
        Logger.Log("Otherwise type'" + CommandWord.HELP + "' if you need help. Have a lovely time :)");
        Logger.Log("");
        Logger.Log(currentRoom.getShortDescription());
        Logger.Log("");
        Logger.Log(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
           Logger.Log("I don't know what you mean...");
            return false;
        }
        
        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        
        else if (commandWord == CommandWord.TAKE) {
            takeItem(command);
        }
        
        else if (commandWord == CommandWord.USE) {
            useItem(command);
       }
       
        else if (commandWord == CommandWord.LOOK) {
          Logger.Log(currentRoom.getLongDescription());
        }
        
         else if (commandWord == CommandWord.VIEW) {
             viewPlayer(command);
            }
      
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
      }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
       Logger.Log("You have somehow ended up in this strange, magical land. But really you just want to go home.");
       Logger.Log("");
       Logger.Log("Your command words are:");
        parser.showCommands();
       Logger.Log("You may view your inventory or your companions");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * If entering the portal, take user to a random room which is generated every time the portal is entered
     * 
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
           Logger.Log("Where are you trying to go?");
            return;
        }

        String direction = command.getSecondWord();      
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
           Logger.Log("You walk repeatedly into a wall... Please try another direction");
        }
        // If the portal is entered, call the random room method
        else {
            if (nextRoom.RoomID == 17){
                //System.out.println("????????"); //An unusable string which may be implemented later
               Logger.Log("~*~*~PoRtAl~*~*~");
                nextRoom = getRandomRoom();
         }
       
            currentRoom = nextRoom;
            Logger.Log(currentRoom.getShortDescription());
        }               
    }

    /**
     * Takes an item from the room and places it into the inventory.
     * Items in rooms are unlimited quantity so they can be re-looted.
     * 
     */ 
    private void takeItem(Command command)  
    {  
        if(!command.hasSecondWord()) {  
            // if there is no second word, we don't know where to go...  
           Logger.Log("What are you trying to take?");  
            return;  
        }  
  
        String itemName = command.getSecondWord();
        String secondName = itemName + "2";
        
        Item thisItem = currentRoom.getItem(itemName);
        Item secondItem = currentRoom.getItem(secondName);
        
        if (thisItem == null) {
           Logger.Log("There isn't a " + itemName + "in here!");
        }
        else if (player.inventory.containsKey(itemName)){
           Logger.Log("You take another " + itemName + " and put it in your backpack.");
           player.addItem(secondName, secondItem);            
        }
        else if (player.inventory.containsKey(itemName)&&(player.inventory.containsKey(secondName))){
            Logger.Log("You don't need any more " + itemName + "s!");
        }
        else {  
           Logger.Log("You take the " + itemName + " and put it in your backpack.");
           player.addItem(itemName, thisItem);
        }  
              
        }  
        
     /**
     * Determines which item the player wishes to use an calls the appropriate method.
     * In this case, the user string calls upon a creature OR item to be used.
     * Occasionally, if a creature is used, it may flee.
     * 
     */ 
    private void useItem(Command command)  
    {  
        if(!command.hasSecondWord()) {  
            // if there is no second word, we don't know where to go...  
           Logger.Log("What are you trying to use?");  
            return;  
        }  
  
        String itemUsed = command.getSecondWord();
        String secondUsed = itemUsed + "2";
        
        Item thisItem = player.getItem(itemUsed);
        Item secondItem = player.getItem(secondUsed);
        
        Creature thisFriend = player.getCompanion(itemUsed);
        
        //Tries to retrieve which item or creature to use. If not, an error message is returned       
            if  (thisItem == null&&secondItem == null&&thisFriend == null) {
           Logger.Log("You don't have a " + itemUsed);
            }
            else if (player.inventory.containsKey(itemUsed)) { 
                player.removeItem(itemUsed); //The item is removed from inventory
                thisItem.UseItem(this);
            }
            else if (player.inventory.containsKey(secondUsed)) {
                player.removeItem(secondUsed); //The item is removed from inventory
                secondItem.UseItem(this);
            }
            else if (player.friends.containsKey(itemUsed)){   
                thisFriend.UseCompanion(this);
            if (thisFriend.flees){
                player.removeCompanion(itemUsed); //Companions do not get removed from inventory unless the flees boolean has been set to true.
            }
        }      
    }

        
    /**
     * The command to view either inventory or current companions.
     * If an incompatible command is entered, return an error message.
     * If that particular inventory is empty, return a relevant statement.
     * 
     */ 
    private void viewPlayer(Command command)
        { if(!command.hasSecondWord()) {  
            // if there is no second word, we don't know where to go...  
           Logger.Log("What do you want to view?");  
            return;  
        }  
           
        String thingToView = command.getSecondWord();
        String inventory = "inventory";
        String companions = "companions";
        
        if (!thingToView.equals(inventory)&&!thingToView.equals(companions)){
           Logger.Log("You can only view your inventory or your current companions");
        }
        else if (thingToView.equals(inventory)&&!player.inventory.isEmpty()) {
           Logger.Log("~*" + player.playerName + "'s Backpack *~");
            player.viewInventory();
           Logger.Log("~*~*~*~*~*~");
        }
        else if (thingToView.equals(inventory)&&player.inventory.isEmpty()){
           Logger.Log("There is nothing in your backpack...");
        }
        else if (thingToView.equals(companions)&&!player.friends.isEmpty()) {
           Logger.Log("~*" + player.playerName + "'s Companions *~");
            player.viewCompanions();
           Logger.Log("~*~*~*~*~*~");
        }
        else if (thingToView.equals(companions)&&player.friends.isEmpty()) {
           Logger.Log("You don't have any companions at the moment :(");
          }
    
       
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
     private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
           Logger.Log("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    public HashMap<String, Item> getInventory(){
        return player.inventory;
    }
    
    public HashMap<String, Creature> getCreatures(){
        return player.friends;
    }
    
    public HashMap<String, Creature> getBosses(){
        return player.defeated;
    }
    
   // public ArrayList<
}
