import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Represents a panel with right, left, up, and down keys to move the blocks around.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class ControlScreen extends JFrame
{
    private JPanel entirePanel;
    /**
     * Initializes a ControlScreen with up, down, right, and left arrow buttons.
     */
    public ControlScreen(Board gameBoard)
    {
        entirePanel = new JPanel();
        entirePanel.setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        entirePanel.setLayout(new GridLayout(3, 3, 0, 0));
        for (int j = 0; j < 9; j++)
        {
            JButton arrow = new JButton();
            if (j == 1)
            {
                arrow.setBackground(Color.BLUE);
                arrow.setText("▲");
                arrow.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        gameBoard.moveUp();
                    }
                });
                entirePanel.add(arrow);
            }
            
            else if (j == 3)
            {
                arrow.setBackground(Color.BLUE);
                arrow.setText("◄");
                arrow.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        gameBoard.moveLeft();
                    }
                });
                entirePanel.add(arrow);
            }
            
            else if (j == 5)
            {
                arrow.setBackground(Color.BLUE);
                arrow.setText("►");
                arrow.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        gameBoard.moveRight();
                    }
                });
                entirePanel.add(arrow);
            }
            
            else if (j == 7)
            {
                arrow.setBackground(Color.BLUE);
                arrow.setText("▼");
                arrow.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        gameBoard.moveDown();
                    }
                });
                entirePanel.add(arrow);
            }
            
            else 
            {
                JPanel controlGrid = new JPanel();
                controlGrid.setBackground(Color.GRAY);
                entirePanel.add(controlGrid);
            }
        }
    }
    
    /**
     * Returns the control screen's entire panel.
     * @return the control screen's entire panel
     */
    public JPanel getPanel()
    {
        return entirePanel;
    }
    
}
