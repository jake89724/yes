/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Color;
import java.awt.Rectangle;

/**
 * creates a square that is a rectangle and holds other properties
 *
 * @author j.head
 */
public class Square extends Shape{

    Rectangle rectangle; //rectangle of square for bounds
    Color color; //color of square
    int length; //length of square
    int width; //width of square
    int x; //x corrdinate of square
    int y ;//y corrdinate of square
    /**
     * create a square object to be saved for inventory
     * @param rectangle the rectangle for desired square bounds
     * @param color color of the square
     */
    public Square(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        x = (int) rectangle.getX();
        y = (int) rectangle.getY();
        this.color = color;
    }
    /**
     * get x
     * @return x coordinate of square 
     */
    public int getX() {
        return x;
    }
    /**
     * get y
     * @return y coordinate of square
     */
    public int getY() {
        return x;
    }
    /**
     * get width of square
     * @return width of rectangle associated with square
     */
    public int getWidth() {
        return (int) rectangle.getWidth();
    }
    /**
     * get height of square
     * @return height of rectangle associated with square
     */
    public int getHeight() {
        return (int) rectangle.getHeight();
    }
    /**
     * get rectangle of square
     * @return rectangle of square
     */
    public Rectangle getRect() {
        return rectangle;
    }
    /**
     * color of square
     * @return the color of the square
     */
    public Color getColor() {
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
