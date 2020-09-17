
/**
 * Represents a block in the 2048 game grid.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class Block
{
    private int curValue;
    private int lockedValue;
    
    /**
     * Initializes a default Block object to have a value of 2 or 4 (randomly chosen).
     */
    public Block() 
    {
        int num = (int)(Math.random()*2 + 1) * 2;
        curValue = num;
        lockedValue = num;
    }
    
    /**
     * Returns the current value of the block.
     * @return the current value of the block.
     */
    public int getCurValue()
    {
        return curValue;
    }
    
    /**
     * Sets the current value of the block to a new desired integer value.
     * @param newValue desired integer value.
     */
    public void setCurValue(int newValue)
    {
        curValue = newValue;
    }
    
    /**
     * Temporarily locks, saves, and zeroes out the block's current value.
     */
    public void lock()
    {
        lockedValue = curValue;
        curValue = 0;
    }
    
    /**
     * Returns the block's value that has been locked away.
     * @return the block's value that has been locked away.
     */
    public int getLockedValue()
    {
        return lockedValue;
    }
}
