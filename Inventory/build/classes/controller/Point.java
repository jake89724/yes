/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 * holds x and y coordinates
 * used for the resize points in canvas graphics 
 * @author lazyf
 */
public class Point {
    
    public int x; // x coordinate
    public int y; // y coordinate
    /**
     * Holds X and Y Coordinates
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
