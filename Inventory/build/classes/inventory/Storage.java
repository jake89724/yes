/*
 * To change this license header, choose License Headers in Project Properties

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import items.Shape;
import items.Square;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *stores shapes for inventory
 * @author J.head
 */
public class Storage{
    public static LinkedList<Shape> item1 = new LinkedList<>();
    public Storage() {
        
        
        
        Rectangle rec = new Rectangle();
        Rectangle[] item = new Rectangle[10];
        Shape [] shapes = {
            new Square(rec, Color.red)
        };
    }
}
