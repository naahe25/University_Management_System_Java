
import java.awt.Image;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;

    Splash() {

        //For Adding Image
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Metro_Pic.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        add(image);

        t = new Thread(this);
        t.start(); //to call run method

        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 660; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);

            try {
                Thread.sleep(10); // Threading is used because to close the window automatically after 7 secounds
            } 
            catch (InterruptedException e) {
            }
        }
    }

    //run is the method of multithreading
    public void run()
    {
        try {
            Thread.sleep(7000); // Threading is used because to close the window automatically after 7 secounds
            setVisible(false);

            //Next Frame
            new Login();
            
            //Close this Window
        } 
        catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        new Splash();

    }
}