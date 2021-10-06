/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.util.LinkedList;

/**
 *
 * @author Jake
 */
public class StoreShape {
    private String name;
    private LinkedList<Square> squaresOfShape;
    /**
     * holds objects that make up shape in linked list
     * @param name name of the object you want to save
     * @param squaresOfShape the square linked list in canvas for shape
     */
    public StoreShape(String name, LinkedList<Square> squaresOfShape){
       this.name = name;
       this.squaresOfShape = squaresOfShape;
    }
    public LinkedList getStoredShape(){
        return squaresOfShape; // basically array of squares
    } 
    public String getName(){
        return name;
    }
}
