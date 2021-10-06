/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import static canvas.Canvas.squares;
import static canvas.Canvas.trueSquares;
import extra.Extra;
import extra.Globals;
import static extra.Globals.canvasFrame;
import items.Square;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Jake
 */
public class Paint {
    //gtaphics from canvas 
    Graphics g;
    /**
     * Paints graphics to simplify canvas class
     * @param g graphics from canvas
     */
    public Paint(Graphics g){
        this.g = g;
        paintStart(g);
        drawForEditor(g);
    }
    /**
     * paints graphics backgrounds and adds square if button pressed
     * @param g graphics from canvas
     */
    private void paintStart(Graphics g){
        //fill background color 
        g.setColor(Color.lightGray);
        g.fillRect(0, canvasFrame .getHeight() - 200, canvasFrame .getWidth(), canvasFrame.getHeight() - 200);
        g.setColor(Color.GRAY);
        g.fillRect(canvasFrame .getWidth() - 200, 0, canvasFrame .getWidth() - 200, canvasFrame .getHeight() - 200);
        //Adds Edit text in canvas frame
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Editor", canvasFrame .getWidth() - 180, 50);
        //draws the seperating lines from option menue to editor menue
        g.setColor(Color.black);
        g.drawLine(canvasFrame .getWidth(), canvasFrame .getHeight() - 200, 0, canvasFrame .getHeight() - 200);
        g.drawLine(canvasFrame .getWidth() - 200, 0, canvasFrame .getWidth() - 200, canvasFrame .getHeight() - 200);
        //line under editor text
        g.drawLine(canvasFrame .getWidth() - 200, canvasFrame.getHeight() / 2 - 275, canvasFrame.getWidth(), canvasFrame.getHeight() / 2 - 275);

        //draws all squares and selected squares
        drawShapes(g);
        //checks if button was pressed and adds new square to canvas
        if (Globals.check) {
            Rectangle addedSquare = new Rectangle(Extra.random(1, canvasFrame .getWidth() - 300), Extra.random(1, canvasFrame .getHeight() - 300), 50, 50);
            squares.add(addedSquare);
            //true squares are for color
            trueSquares.add(new Square(addedSquare, Options.colors[Options.colorOfChoice]));
            Globals.check = false;
        }
        
        
    }
    /**
     * draws the squares and highlights if selected
     * @param g 
     */
    public void drawShapes(Graphics g) {
        //draw selected color as sample
        g.setColor(Options.colors[Options.colorOfChoice]);
        g.fillRect(canvasFrame .getWidth() / 2 + 20, canvasFrame .getHeight() - 175, 75, 75);
        g.setColor(Color.black); // set color back to default
        //loop squares (rectangle array)
        for (int i = 0; i < squares.size(); i++) {
            //get color assosiated with the rectangle (square)
            g.setColor(trueSquares.get(i).getColor());
            //set a temporary rectangle to for simplicity in getting information
            Rectangle temp = new Rectangle(squares.get(i));
            //draw the desired rectangle from squares
            g.fillRect((int) temp.getX(), (int) temp.getY(),
                    (int) squares.get(i).getWidth(), (int) squares.get(i).getHeight());
            //creates the selected object graphics
            if (i == Globals.indexOfSelected) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.cyan);
                g2.setStroke(new BasicStroke(3));
                g2.drawRect((int) temp.getX(), (int) temp.getY(),
                        (int) squares.get(i).getWidth(),
                        (int) squares.get(i).getHeight());
                //create 4 dots that let you resize the square
                Canvas.resizeShape(g2);
                //set stroke and color back to default
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke(1));
            }
        }
        
    }
    /**
     * draws for editor
     */
    public void drawForEditor(Graphics g){ // FOR COMPUTER SCIENCE //////////////
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Times New Romen", Font.BOLD, 15));
        g2.setStroke(new BasicStroke(1));
        if(Globals.selected){
            //displays shape number
            g2.drawString("Square Number " +  Globals.indexOfSelected, canvasFrame.getWidth() - 175, canvasFrame.getHeight() - 600);
            g2.setFont(new Font("Times New Romen", Font.CENTER_BASELINE, 12));
            //displays change color text for editor
            g.drawString("Change Color", canvasFrame.getWidth() - 150, canvasFrame.getHeight()/3 - 85);
            
            g.fillRect(canvasFrame.getWidth() - 135, canvasFrame.getHeight() / 2 - 150, 50, 50);    
        }
    }
    
}
