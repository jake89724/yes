
package controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import canvas.Canvas;
import extra.Globals;
/**
 * mouse dragging, selecting, and resizing logic
 * @author j.head
 */
public class MouseController implements MouseMotionListener, MouseListener {

    //the rectangle used once a square is being dragged
    Rectangle dragSquare; // insures that the rectangle will follow mouse 
    //^ no matter the speed 
    //if square is being dragged
    boolean draggingSquare = false;//multiplle squares can't be dragged at once
    boolean draggingPoint = false; // ditto but for points (points prioratize)
    int indexOfSquare = 0; // index of square being dragged in rectangle list
    int indexOfPoint = 0; // ditto but for points

    /**
     * Constructor does nothing right now
     */
    public MouseController() {
        //might move logic to movement class in visual
    }
    /**
     * mouse dragging logic (square and resizing with points)
     *
     * @param e mouse event
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        //create a rectangle at mouse position 
        //check using the .intesect method
        Resize resize = new Resize();
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);
        //if nothing is being dragged to assure mutiple things arn't dragged 
        //at once
        if (!draggingSquare) {
            if (!draggingPoint) {
                try { // try in case selected square hasn't been selected yet
                    //creates rectangles at the points of the selected square
                    //used so mouse rectangle can use .intersects
                    Rectangle[] pointPos = new Rectangle[4];
                    for (int i = 0; i < Globals.points.length; i++) {
                        pointPos[i] = new Rectangle(
                                Globals.points[i].x,
                                Globals.points[i].y,
                                10, 10
                        );
                    }
                    //checks if points and mouse are overlapping
                    for (int i = 0; i < Globals.points.length; i++) {
                        if (mousePos.intersects(pointPos[i])) {
                            //if overlapping set the index point to be dragged
                            if (i == 0) {
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                                System.out.println("at 0");
                            } else if (i == 1) {
                                System.out.println("at 1");
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                            } else if (i == 2) {
                                System.out.println("at 2");
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                            } else if (i == 3) {
                                System.out.println("at 3");
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                            }
                        }
                    }
                } catch (NullPointerException j) {
                    //irrelavent :) because nother ever goes wrong
                }
            }
        }
        /*
         Resized object at the indexofpoint in resize class
         */
        if (draggingPoint) {
            if (indexOfPoint == 0) {
                resize.reSizeLeft(mousePos);
            } else if (indexOfPoint == 1) {
                resize.reSizeRight(mousePos);
            } else if (indexOfPoint == 2) {
                resize.resizeUp(mousePos);
            } else if (indexOfPoint == 3) {
                resize.resizeDown(mousePos);
            }
        }
        /*
         point to be dragged with index of choice being set insures that 
         once somthing starts being dragged it will take priority and multiple
         things can't be draged at once. Also makes mouse speed irrelivant
         */
        if (!draggingPoint) {
            if (!draggingSquare) {
                for (int i = 0; i < Canvas.squares.size(); i++) {
                    if (mousePos.intersects(Canvas.squares.get(i))) {
                        //sets square to take priority in being dragged
                        dragSquare = new Rectangle(Canvas.squares.get(i));
                        draggingSquare = true;
                        indexOfSquare = i; // same proccess as points
                    }
                }
            }
            //drags square to mouse position if it's within allowed borders 
            //on canvas.
            //also snaps square to border if mouse is out of bounds
            if (draggingSquare) {
                //creates temp rectangle for name simplicity
                Rectangle temp = new Rectangle(dragSquare);
                if (mousePos.x < Globals.canvasFrame.getWidth()
                        - 200
                        - Canvas.squares.get(indexOfSquare).getHeight() / 2
                        && mousePos.y < Globals.canvasFrame.getHeight() - 200
                        - Canvas.squares.get(indexOfSquare).getHeight() / 2) {
                    Canvas.squares.get(indexOfSquare).setLocation(
                            (int) mousePos.x - (int) temp.getWidth() / 2,
                            (int) mousePos.y - (int) temp.getHeight() / 2
                    );
                } else {
                    if (mousePos.x > Globals.canvasFrame.getWidth()
                            - 200
                            - Canvas.squares.get(indexOfSquare).getWidth()
                            / 2) {
                        //snaps to position if mouse out of bounds
                        if(mousePos.y < Globals.canvasFrame.getHeight() - 200
                                - Canvas.squares.get(indexOfSquare).getHeight() / 2){
                            Canvas.squares.get(indexOfSquare).setLocation(
                                Globals.canvasFrame.getWidth()
                                - 200 - (int) Canvas.squares
                                        .get(indexOfSquare).getWidth(),
                                (int) mousePos.y - (int) temp.getHeight() / 2
                        );
                        }
                        
                        

                    } else {
                        //snaps on y pos (only other option)
                        
                        Canvas.squares.get(indexOfSquare).setLocation(
                                (int) mousePos.x - (int) temp.getWidth() / 2,
                                Globals.canvasFrame.getHeight() - 200
                                - (int) Canvas.squares
                                        .get(indexOfSquare).getHeight()
                        );
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    /**
     * selects object when mouse is click
     * @param e mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //sets mouse position as a rectangle
        //alloiws for .intersects method
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);
        boolean touching = false; // if mouse is touching point
        //determines if mouse is touching point
        for (int i = 0; i < Canvas.squares.size(); i++) {
            if (mousePos.intersects(Canvas.squares.get(i))) {
                Globals.indexOfSelected = i; // sets selected point 
                touching = true;
                Globals.selected = true;
            }
        }
        if (!touching) {
            Globals.indexOfSelected = - 1;//if not touching point set 
            //index to an impossible number so it wont be used by canvas 
            Globals.selected = false;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    /**
     * sets dragging square and selected square back to false
     * @param e mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        draggingSquare = false;
        draggingPoint = false;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
