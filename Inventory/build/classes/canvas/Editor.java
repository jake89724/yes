/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import extra.Globals;
import static extra.Globals.canvasFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Jake
 */
public class Editor implements ActionListener{
    JComboBox colors = new JComboBox(Globals.colorChoices);
    public Editor(){
        setEditorOptions();
    }

    private void setEditorOptions() {
        
        colors.setBounds(canvasFrame.getWidth() - 150, canvasFrame.getHeight()/3 -75, 75, 25);
        colors.addActionListener(this);
    }
    public JComboBox getColors(){
        return colors;
    }
    public static void timer(){
        
        if(Globals.selected){
            Globals.colorEditor.setVisible(true);
            Color colorDefault = 
            Canvas.trueSquares.get(Globals.indexOfSelected).getColor();
            if(colorDefault == Color.red){
                Globals.colorEditor.setSelectedIndex(1);
            }else if(colorDefault == Color.black){
                 Globals.colorEditor.setSelectedIndex(0);
            }else if(colorDefault == Color.yellow){
                 Globals.colorEditor.setSelectedIndex(2);
            }
            return;
        }
        Globals.colorEditor.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String colorInput = (String) colors.getSelectedItem();
       
       if(colorInput.equals("black")){
           Canvas.trueSquares.get(Globals.indexOfSelected).setColor(Color.black);
       }
       else if(colorInput.equals("red")){
            Canvas.trueSquares.get(Globals.indexOfSelected).setColor(Color.red);
       }
       else if(colorInput.equals("yellow")){
           Canvas.trueSquares.get(Globals.indexOfSelected).setColor(Color.yellow);
       }
    }
   
}
