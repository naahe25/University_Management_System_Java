import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        // For Adding Image
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Metro_Pic.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        add(image);

        // Set fixed size and center the window
        setSize(1000, 700);
        setLocationRelativeTo(null); // center the frame on screen
        setVisible(true);

        // Start the thread
        t = new Thread(this);
        t.start();
    }

    // run method for the thread
    public void run() {
        try {
            Thread.sleep(3000); // keep splash visible for 3 seconds
            setVisible(false);

            // Next Frame
            new Login(); // make sure Login class exists
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
