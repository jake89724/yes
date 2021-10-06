
package controller;

import java.awt.Rectangle;
import canvas.Canvas;
import static extra.Globals.indexOfSelected;
import static extra.Globals.points;

/**
 * resizes the object based on mouse position
 * @author j.head
 */
public class Resize {
    public Resize(){
        
    }
    /**
     * resizes object towards the left 
     * @param mousePos the rectangle attached to mouse position
     */
    public void reSizeLeft(Rectangle mousePos){
        //point.x - mouse.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(points[0].x
                 - (int)mousePos.getX()
                 + (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)Canvas.squares.get(indexOfSelected).getHeight()
         );  
       //set location of point to the mosue 
         Canvas.squares.get(indexOfSelected).setLocation(
                (int)mousePos.getX() + 10,
                (int) Canvas.squares.get(indexOfSelected).getY()
         );
    }
    /**
     * resizes object towards the right 
     * @param mousePos rectangles attached to mouse 
     */
    public void reSizeRight(Rectangle mousePos){
        //mouse.x - point.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                 (int)mousePos.getX() - points[1].x
                 + (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)Canvas.squares.get(indexOfSelected).getHeight()
         );  
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                (int)mousePos.getX() - (int)temp.getWidth(),
                (int) Canvas.squares.get(indexOfSelected).getY()
         );
    }
    /**
     * resizes the object upwards 
     * @param mousePos rectangle attached to mouse
     */
    public void resizeUp(Rectangle mousePos){
      //point.y - mouse.y + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                          (int)Canvas.squares.get(indexOfSelected).getWidth(),
                          
                 points[2].y  - (int)mousePos.getY()
                 + (int)Canvas.squares.get(indexOfSelected).getHeight()
         );
         
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                 (int) Canvas.squares.get(indexOfSelected).getX(),
                (int)mousePos.getY() + 5
         );
    }
    /**
     * resizes object downward
     * @param mousePos rectangle attached to mouse position
     */
    public void resizeDown(Rectangle mousePos){
      //mouse.y-point.y + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                 (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)mousePos.getY() - points[3].y 
                 + (int)Canvas.squares.get(indexOfSelected).getHeight()
         );
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                 (int) Canvas.squares.get(indexOfSelected).getX(),
                (int)mousePos.getY() - (int)temp.getHeight()
         );
    }
}
