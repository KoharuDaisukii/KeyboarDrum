import javax.swing.*;
import java.awt.*;

public class DrumPanel extends JPanel
{
     private static final int COMPONENT_COUNT = 9;
     private ImageIcon drumImage = new ImageIcon("src/image/drum.png");

     public DrumPanel()
     {
          JLabel imgLabel = new JLabel();
          imgLabel.setIcon(drumImage);
          setLayout(null);

          DrumHit test = new DrumHit();
          JButton[] drumKit = new JButton[COMPONENT_COUNT];
          int[] x = {173, 105, 105, 200, 241, 275, 328, 385, 435};
          int[] y = {40, 190, 115, 258, 127, 300, 127, 255, 100};
          String[] componentName = {"Crash", "<html><body><center>Hihat<br>(Close)</center></body></html>", "<html><body><center>Hihat<br>(Open)</center></body></html>", "Snare", "<html><body><center>High<br>Tom</center></body></html>", "Kick", "<html><body><center>Low<br>Tom</center></body></html>", "<html><body><center>Floor<br>Tom</center></body></html>", "Ride"};
          for(int i=0;i<COMPONENT_COUNT;i++)
          {
               drumKit[i] = new JButton(componentName[i]);
               drumKit[i].setBounds(x[i], y[i], 70, 45);
               add(drumKit[i]);
               drumKit[i].addActionListener(test);
          }

          requestFocus();
          setFocusable(true);

          addKeyListener(test);
     }

     @Override
     public void paintComponent(Graphics g)
     {
          super.paintComponent(g);
          g.drawImage(drumImage.getImage(), 87, 40, null);
     }
}
