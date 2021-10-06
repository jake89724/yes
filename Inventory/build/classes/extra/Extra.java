/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import canvas.Editor;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description: has methods that can be used in multiple classes to save 
 * space
 * @author Jake
 */
public class Extra {
    /**
     * has extra methods to use 
     */
    public Extra(){
        //main timer
        timer();
    }
    /**
     * generates a random number
     * @param low the low number
     * @param high the high number
     * @return int between low and high
     */
    public static int random(int low, int high) {
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }
    /**
     * main timer 
     */
    private void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(Globals.canvasFrame != null){
                    Globals.canvasFrame.repaint();
                    Editor.timer();
                }
                
            }

        }, 0, 17);
    }
}
