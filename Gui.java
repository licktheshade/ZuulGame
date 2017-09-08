import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.DefaultCaret;
import java.awt.Insets;

/**
 * The GUI class which implements the user interface and displays images of the rooms, items and inventories.
 * 
 * @author 162224 
 * @version 4
 */
public class Gui
{
    private boolean nameEntered = false;
    
    private Game _game;
    private JFrame frame;
    private JPanel _roomPanel;
    private JPanel _interactPanel;
    private JPanel _inventoryPanel;
    private JPanel _itemsPanel;
    private JPanel _creaturePanel;
    private JPanel _bossPanel;
    private JPanel _itemHead;
    private JLabel itemHead;
    private JPanel _creatureHead;
    private JLabel creatureHead;
    private JPanel _bossHead;
    private JLabel bossHead;
    private JTextArea _log;
    private JTextField _input;
    private File userLog;
    
    public Gui()
    {
       Create();
       Logger.setLogger(_log);
       _game = new Game();
       _game.welcomePartOne();      
       updateUi();
    }

    /**
     * Populates the Jframe
     */    
    public JFrame Create(){
        frame = new JFrame("Magical Realm Land");
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        addMenu(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,850);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        _roomPanel = createRoomPanel();
        _roomPanel.setPreferredSize(new Dimension(660, 520));
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        
        frame.add(_roomPanel, gbc);
        
        _inventoryPanel = createInventoryPanel();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        frame.add(_inventoryPanel, gbc);
        
        

        
        JPanel _logPanel = createLogPanel();
        //_log = new JTextArea();
        //_log.setEditable(false);
        //_log.setLineWrap(true);
        //_log.setWrapStyleWord(true);
        
        //JScrollPane scroll = new JScrollPane (_log, 
        //JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.anchor = GridBagConstraints.NONE;
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        
        frame.add(_logPanel, gbc);
        
        
        _interactPanel = createInteractPanel();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;
        //gbc.insets = new Insets(10,0,0,0);
        gbc.weighty = 0.25;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        
        frame.add(_interactPanel, gbc);
             
        frame.setVisible(true);
        frame.pack();
        
        return frame;
    }

    /**
     * Creates the panel to display the room. Items in the room are called upon in the Room class
     */ 
    private JPanel createRoomPanel(){
        JPanel result = new JPanel();
        //result.setLayout(new BorderLayout());
        //result.setBounds(0, 0, 650, 500);
        result.setBackground(Color.BLACK);
        return result;
    }
    
    /**
     * This is the panel which contains the three types of user inventory - the items, creatures and bosses defeated
     */ 
    private JPanel createInventoryPanel(){
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(1, 3));
        result.setPreferredSize(new Dimension(600, 200));
        result.setBackground(Color.BLUE);
        
        JPanel _allItemPanel = createItemsPanel();
        result.add(_allItemPanel);
        
        JPanel _allcreaturePanel = createCreaturePanel();
        result.add(_allcreaturePanel);
        
        JPanel _allbossPanel = createBossPanel();
        result.add(_allbossPanel);
        
        return result;
    }
    
    /**
     * Creates the user creature friend panel with a seperate header
     */ 
    private JPanel createCreaturePanel(){
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        
        JLabel temp = new JLabel("Friends");
        _creatureHead = new JPanel();
        _creatureHead.add(temp);
        _creatureHead.setBackground(Color.GRAY);

        result.add(_creatureHead, BorderLayout.NORTH);
       
        _creaturePanel = new JPanel();
        _creaturePanel.setLayout(new FlowLayout());
        _creaturePanel.setBackground(Color.BLACK);

        result.add( _creaturePanel, BorderLayout.CENTER);
        result.setBorder(BorderFactory.createLineBorder(Color.GRAY));
   
        return result;
    }
    
    /**
     * Creates the user item inventory panel with a seperate header
     */ 
        private JPanel createItemsPanel(){
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        
        JLabel temp = new JLabel("Items");
        _itemHead = new JPanel();
        _itemHead.add(temp);
        _itemHead.setBackground(Color.LIGHT_GRAY);

        result.add(_itemHead, BorderLayout.NORTH);
       
        _itemsPanel = new JPanel();
        _itemsPanel.setLayout(new FlowLayout());
        _itemsPanel.setBackground(Color.BLACK);

        result.add(_itemsPanel, BorderLayout.CENTER);
        result.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        return result;
    }
    
    /**
     * Creates the user boss defeated panel with a seperate header
     */ 
    private JPanel createBossPanel(){
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        
        JLabel temp = new JLabel("Defeated");
        temp.setForeground(Color.GRAY);
        _bossHead = new JPanel();
        _bossHead.add(temp);
        _bossHead.setBackground(Color.DARK_GRAY);

        result.add(_bossHead, BorderLayout.NORTH);
       
        _bossPanel = new JPanel();
        _bossPanel.setLayout(new FlowLayout());
        _bossPanel.setBackground(Color.BLACK);

        result.add(_bossPanel, BorderLayout.CENTER);
        result.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));    
        return result;
    }
    
    /**
     * Creates the panel which contains the user input field, a 'go' button (that works the same as pressing enter)
     * and a header
     */     
    private JPanel createInteractPanel(){
        JPanel result = new JPanel();
        //result.setPreferredSize(new Dimension(100,100));
        result.setLayout(new BorderLayout());
        
        _input = new JTextField();
        //_log.setPreferredSize( new Dimension(100, 100) );
        JLabel _label = new JLabel("What would you like to do?");
        JButton _go = new JButton("Go!");
        
        _go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {              
                processCommand();
            } 
                
         });
            
        _input.addActionListener(new ActionListener() {
            // for a JTextField, this is only called when enter is pressed
            public void actionPerformed(ActionEvent e){
                processCommand();
            }
        });
        
        result.add(_input,BorderLayout.CENTER);
        result.add(_label,BorderLayout.NORTH);
        result.add(_go,BorderLayout.EAST);
        
        return result;
    }
    
     /**
     * Creates the scrollable panel which contains a log of the users journey and actions
     */ 
    private JPanel createLogPanel(){
        JPanel result = new JPanel();
        result.setPreferredSize(new Dimension (300,700));
        result.setLayout(new BorderLayout());
        
        _log = new JTextArea();
        _log.setEditable(false);
        _log.setLineWrap(true);
        _log.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(_log,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        
        result.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        result.add(scroll, BorderLayout.CENTER);
        return result;
    }
    
    /**
     * Processes user commands - checks if the username has been entered so that it can be set.
     */ 
    private void processCommand(){

        String command = _input.getText();

        
        if (!nameEntered){
            _game.player.playerName = command;
            nameEntered = true;
            createPanelNames();
            _input.setText("");  
            _game.welcomePartTwo();
            return;
        }

        _input.setText("");

        _game.guiCommand(command);
        updateUi();
    }
    
    /**
     * Customises each header for the inventory panels for the specific user once the player name is set
     */ 
    private void createPanelNames() {
        String user = _game.player.playerName;
        
        itemHead = new JLabel (user + "'s Items");
        _itemHead.removeAll();
        _itemHead.add(itemHead);
        
        JLabel creatureHead = new JLabel (user + "'s friends");
        //creatureHead.setForeground(Color.WHITE);
        _creatureHead.removeAll();
        _creatureHead.add(creatureHead);
        
        JLabel bossHead = new JLabel (user + " Defeated");
        bossHead.setForeground(Color.GRAY);
        _bossHead.removeAll();
        _bossHead.add(bossHead);
        
        repaintAll();
    }
    
    /**
     * Updates GUI images
     */ 
    private void repaintAll(){
        _roomPanel.revalidate();
        _roomPanel.repaint();
        
        _inventoryPanel.revalidate();
        _inventoryPanel.repaint();
        
        _interactPanel.revalidate();
        _interactPanel.repaint();        
       
    }
    
    /**
     * Creates menu items - stuck and quit
     */    
        public void addMenu(JMenuBar menu)
    {

        JMenuItem stuck = new JMenuItem("Stuck...?");
        stuck.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {printHelp(); } 
            });
        menu.add(stuck);
        
        
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _game.quitGame();
                    System.exit(0); }
            });
        menu.add(quit);
    }
    
    /**
     * Print out some help information.
     */
    private void printHelp() 
    {
        System.out.println("You have somehow ended up in this strange, magical land. But really you just want to go home.");
        System.out.println();
        System.out.println("Your command words are:");
        _game.parser.showCommands();
        System.out.println("You may view your inventory or your companions");
    }

    /**
     * Updates the UI graphics
     */     
    private void updateUi(){
        _roomPanel.removeAll();
        JPanel thing = _game.currentRoom.getUI();
        _roomPanel.add(thing);
        
        _itemsPanel.removeAll();
        _itemsPanel.add(updateDrawables(_game.getInventory()));
        
        _creaturePanel.removeAll();
        _creaturePanel.add(updateDrawables(_game.getCreatures()));
        
        _bossPanel.removeAll();
        _bossPanel.add(updateDrawables(_game.getBosses()));

        repaintAll();
    }
    
    /**
     * Retrieves user inventories to add them to the appropriate panels
     */ 
    private <T extends Drawable>JPanel updateDrawables(HashMap<String, T> items){
        JPanel result = new JPanel();
        result.setBackground(Color.BLACK);
        
        for(T item : items.values()){
            result.add(item.getSmallUi());
        }
        
        return result;
    }
    

    
}