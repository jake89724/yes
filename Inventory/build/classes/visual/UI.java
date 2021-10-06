
package visual;
import canvas.Canvas;
import extra.Globals;
import inventory.Storage;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * main inventory page: holds main picture
 * @author j.head
 */
public class UI extends JPanel{
    //checks if button is pressed
    boolean check = false; // defaults to false
    //frame for inventory
    public static JFrame frame = new JFrame("Inventory");
    /**
     * creates frame and sets up buttons 
     */
    public UI(){
        //create frame
        setFrame(500, 500);
        //create button, adds to panel, and sets bounds
        JButton btnButton = new JButton("Add shape");
        this.add(btnButton);
        JButton btnShowLast = new JButton("Show Shape");
        this.add(btnShowLast);
        btnShowLast.setBounds(100, 10, 125, 25);
  
        //Determines if button is pressed
        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens canvas to create shape
                Canvas canvas = new Canvas();
//              //disables this frame 
                frame.setEnabled(false);
            }
        });
        btnShowLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sets check true so paint component will draw
                check = true;
                for (int i = 0; i < Globals.shapes.size(); i++) {
                    System.out.println(Globals.shapes.get(i).getName());
                    for (int j = 0; j <  Globals.shapes.get(i).getStoredShape().size(); j++) {
                        System.out.println("here");
                         System.out.println(Globals.shapes.get(i).getStoredShape());
                    }
                   
                }
               // System.out.println(Globals.shapes);
                //refreshes paint component by repainting 
                repaint();
            }
        });
        //sets button bounds again for some reason
        //I should probably take it out but meh why not leave it in
              btnButton.setBounds(250, 10, 125, 25);
    }
  /**
   * draws graphics
   * @param g graphics
   */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //rectangle for testing drawing shape (perimiter)
        g.drawRect(frame.getWidth()/2 - 50, frame.getHeight()/2 - 50, 100, 100);
      //if button was pressed (Show Shape)
      if(check){
          
          //storage item is a list of rectangles set from canvas close
          for (int i = 0; i < Globals.shapes.get(0).getStoredShape().size(); i++) {
              Rectangle temp = new Rectangle();
              
              System.out.println("here");
              //draws the rectangles of previous shapes
//              g.setColor(Storage.item1.get(i).getColor());
//              g.fillRect(Storage.item1.get(i).getX(),
//                      Storage.item1.get(i).getY(),
//                      Storage.item1.get(i).getWidth(),
//                      Storage.item1.get(i).getHeight());
          }
          check = false;
      }
    }
    /**
     * sets the frame of inventory
     * @param length length of frame 
     * @param width width of frame
     */
    private void setFrame(int length, int width) {
        frame.setSize(width, length);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);     
    }
}
