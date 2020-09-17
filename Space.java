import javax.swing.*;
import java.awt.*;
/**
 * Represents a space of the 2048 game grid.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class Space extends JFrame
{
    private boolean isVacant;
    private Block curBlock;
    private JPanel curPanel;
    private JLabel curLabel;
    /**
     * Initializes a Space object to be gray and empty.
     */
    public Space()
    {
        isVacant = true;
        curBlock = null;
        curPanel = new JPanel();
        curPanel.setBackground(Color.LIGHT_GRAY);
        curLabel = new JLabel("");
        curPanel.add(curLabel);
    }
    
    /**
     * Returns the current block in the space.
     * @return the current block in the space.
     */
    public Block getCurBlock()
    {
        return curBlock;
    }
    
    /**
     * Removes whatever block is in the space and leaves the space empty.
     */
    public void nullifyBlock()
    {
        curBlock = null;
        curPanel.setBackground(Color.LIGHT_GRAY);
        changeLabelTo("");
    }
    
    /**
     * Returns the visible panel of the space.
     * @return the visible panel of the space.
     */
    public JPanel getCurPanel()
    {
        return curPanel;
    }
    
    /**
     * Inserts a new block into the space.
     */
    public void insertBlock()
    {
        curBlock = new Block();
        isVacant = false;
        if (curBlock.getCurValue() == 2)
            curPanel.setBackground(new Color(238, 228, 218));
        if (curBlock.getCurValue() == 4)
            curPanel.setBackground(new Color(237, 224, 200));
        curLabel.setText("" + curBlock.getCurValue());
        curLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 100));
        curLabel.setForeground(new Color(64, 64, 60));
    }
    
    /**
     * Returns the current label of the space.
     * @return the current label of the space.
     */
    public JLabel getCurLabel()
    {
        return curLabel;
    }
    
    /**
     * Inserts an existent block into the space.
     * @param b existent block being inserted into the space.
     */
    public void insertExistentBlock(Block b)
    {
        curBlock = b;
        isVacant = false;
        curLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 100));
        curLabel.setForeground(new Color(64, 64, 60));
    }
    
    /**
     * Changes the space's label's text to a desired String.
     */
    public void changeLabelTo(String str)
    {
        JLabel temp = curLabel;
        curPanel.remove(curLabel);
        curLabel.setText(str);
        curPanel.add(curLabel);
        curLabel = temp;
    }
}
