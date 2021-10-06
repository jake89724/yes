/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import controller.Point;
import items.Shape;
import items.StoreShape;
import java.awt.Color;
import java.awt.Cursor;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Jake
 */
public class Globals {
    public static JFrame canvasFrame;
    //the index of the selected object for graphcis to highlight
    public static int indexOfSelected = -1; //-1 is impossible numebr
    //the points ofresixable dots
    public static Point[] points;
    //cursor for resizing
    public static Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
    //checking if add square was pressed for canvas.Paint.graphics
    public static boolean check = false; // default to false
    //where thr active shapes are held
    public static LinkedList<StoreShape> shapes = new LinkedList<>();
    //checks if a object is selected
    public static boolean selected = false; //default false
    //used for color editor on canvas
    public static JComboBox colorEditor = new JComboBox();
    //Colour Selection 
    public static String [] colorChoices = {
        "black", "red", "yellow"
    };
  
}
