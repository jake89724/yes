/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import controller.MouseController;
import controller.Point;
import extra.Globals;
import static extra.Globals.canvasFrame;
import inventory.Storage;
import items.Square;
import items.StoreShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import visual.UI;

/**
 * main canvas for making shapes
 * @author j.head
 */
public class Canvas extends JPanel {
    //holds rectagles for drawing and main storage
    public static LinkedList<Rectangle> squares = new LinkedList();
    //holds rectangles with other properties for storage
    public static LinkedList<Square> trueSquares = new LinkedList();
    //selected rectangle 
    public static Rectangle select = new Rectangle();
    //determines if it's the first launch of canvis
    int counter = 0; // so things don't happen twice
    
    /**
     * sets frame and declares buttons
     */
    public Canvas() {
        //creates frame from globals
        Globals.canvasFrame =  new JFrame("Canvas");
        MouseController controller = new MouseController();
        //mouse motion and stationary for mouse controller
        this.addMouseMotionListener(controller);
        this.addMouseListener(controller);
        //sets frame properties
        canvasFrame.setSize(700, 700);
        canvasFrame.setLocationRelativeTo(null);
        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvasFrame.setVisible(true);
        canvasFrame.add(this);
        canvasFrame.setResizable(false);
        //button for adding squares
        JButton btnAddButton = new JButton("New Square");
        btnAddButton.setLayout(null); //setting null for simplicity
        this.setLayout(null); // ditto top coment
        btnAddButton.setLayout(null); // ditto the ditto :)
        //sets bounds of add button 
        btnAddButton.setBounds(100, canvasFrame .getHeight() - 180, 120, 40);
        //exit button
        JButton btnClose = new JButton("Save");
        btnClose.setLayout(null); // dittor the previous dittos 
        //sets bounds for close button
        btnClose.setBounds(canvasFrame.getWidth() - 200, canvasFrame .getHeight() - 150, 120, 50);        
        if (counter == 0) { // determines if it's first launch
            this.add(btnClose); // adds buttons
            this.add(btnAddButton);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeCanvas(); // if close button is pressed
            }
        });
        btnAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // if square is added
                Globals.check = true; // confirms button press
                repaint(); //refreshes graphics
            }
        });
        //drop down to select colour of shape being added 
            Options options = new Options(this);
            this.add(options.getComboBox());
            Editor editor = new Editor();
            //sets global combo box to the one generated in options
            Globals.colorEditor = editor.getColors();
            this.add(Globals.colorEditor);
        }
        counter++;
    }
    /**
     * paints components of canvas
     * found in Paint class for simplicity of Canvas class
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Paint paint = new Paint(g); // painting graphics in Pain class
    }
    /**
     * repaints the canvas on a fast timer found in Extra class,
     * for when mouse is dragging objects or resizing...etc.
     */
//    public void repaintCanvas(){
//        repaint();
//    }
   /**
    * 
    * @param g 
    */
    public static void resizeShape(Graphics2D g) {
        //create 4 points 
        g.setColor(Color.red);
        int index = Globals.indexOfSelected; // gets the square selected
        Rectangle selected = new Rectangle(squares.get(index));
        //declares points associated with selected suare
        Point left = new Point((int) selected.getX() - 10,
                (int) selected.getY() + (int) selected.getHeight() / 2 - 5);
        Point right = new Point((int) selected.getX() + (int) selected.getWidth(), 
                (int) selected.getY() + (int) selected.getHeight() / 2 - 5);
        Point up = new Point((int) selected.getX() + (int) selected.getWidth() / 2 - 5, 
                (int) selected.getY() - 5);
        Point down = new Point((int) selected.getX() + (int) selected.getWidth() / 2 - 5, 
                (int) selected.getY() + (int) selected.getHeight());
        //creates point array in Globals
        Globals.points = new Point[4];
        Globals.points[0] = left; // sets the points at the proper indecies 
        Globals.points[1] = right;
        Globals.points[2] = up;
        Globals.points[3] = down;
        //paints points (ovals)
        for (int i = 0; i < Globals.points.length; i++) {
            g.fillOval(Globals.points[i].x, Globals.points[i].y, 10, 10);
        }
        //draws the red lines through the selected square
        g.setStroke(new BasicStroke(0.5f));
        g.drawLine(left.x - 20, left.y + 5, right.x + 20, right.y + 5);
        g.drawLine(up.x + 5, up.y - 20, down.x + 5, down.y + 20);
        //sets graphics back to default
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.black);
    }
    /**
     * stores shape
     * closes frame
     * resets variables
     */
    private void closeCanvas() {
        LinkedList<Square> storeSquares = new LinkedList<>();
//         for (int i = 0; i < squares.size(); i++) {
//             storeSquares.add(new Square(squares.get(i), ));
//         }
        System.out.println(trueSquares);
        LinkedList<Square> tempSquares = new LinkedList<>();
        tempSquares = trueSquares;
        Globals.shapes.add(new StoreShape("Name" , (new LinkedList(trueSquares))));
        UI.frame.setEnabled(true); // enables inventory frame
        Storage.item1.clear(); // clears previous storage shape
       // Storage.item1 = trueSquares; // stores this shape
        trueSquares.clear(); // clears color squares 
        Globals.indexOfSelected = -1; // resets indexOfSelected to impossible index
        squares.clear(); // cleares square list of rectangles
        Options.colorOfChoice = 0; // resets current color to default
        canvasFrame .dispose(); // disposes the frame
    }
    /**
     * runs on loop to update user motion for the editor
     */
    
}
