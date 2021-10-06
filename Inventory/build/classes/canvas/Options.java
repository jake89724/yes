
package canvas;

import extra.Globals;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * sets options menu for canvas
 * @author Jake
 */
public class Options implements ActionListener{
    //combo boc for selecting color
    JComboBox selectColor;
    //panel from canvas to alter
    JPanel panel;
    //array holding all possible colors in the universe 
    public static Color[] colors = {
      Color.black, Color.red, Color.yellow
    };
    //to determine the color by index in color array
    public static int colorOfChoice = 0;
    /**
     * sets Canvas panel to this one
     * @param panel panel from canvas
     */
    public Options(JPanel panel){
        this.panel = panel;
        colorSelection();
    }
    /**
     * combo box to be added to panel
     * @return combo box
     */
    public JComboBox getComboBox(){
        return selectColor;
    }
    /**
     * sets the color string array to combo box options,
     * adds event listener
     */
    public void colorSelection(){
        System.out.println("in options");
        
        selectColor = new JComboBox(Globals.colorChoices);
        System.out.println(selectColor);
        selectColor.setBounds(Globals.canvasFrame .getWidth() / 2 - 100, Globals.canvasFrame.getHeight() - 185, 80, 30);
        System.out.println("options");
        selectColor.addActionListener(this);
    }
    /**
     * gets the color of choice 
     * @param e actions performed event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String colorInput = (String)selectColor.getSelectedItem();
        if(colorInput.equals("black")){
            colorOfChoice = 0; // for index of color array to be used 
            //when setting colors in canvas graphics
        }
        else if(colorInput.equals("red")){
            colorOfChoice = 1;
        } 
        else if(colorInput.equals("yellow")){
            colorOfChoice = 2;
        }
    }
}
