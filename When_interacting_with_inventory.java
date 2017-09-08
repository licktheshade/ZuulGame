

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class When_interacting_with_inventory.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class When_interacting_with_inventory
{
    private Player _player;
    /**
     * Default constructor for test class When_interacting_with_inventory
     */
    public When_interacting_with_inventory()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _player = new Player();
    }

    @Test
    public void Should_be_able_to_add_items(){
        //assetEquals(_player.getInventory().size(), 0);
        //_player.addItem("herb", new Herb(....));
        //assetEquals(_player.getInventory().size(), 1);        
        
    }
    
    @Test
    public void Should_be_able_to_remove_items(){
        //assetEquals(_player.getInventory().size(), 0);
        //_player.addItem("herb", new Herb(....));
        //assetEquals(_player.getInventory().size(), 1);        
        //_player.removeItem("herb");
        //assetEquals(_player.getInventory().size(), 0);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
