import javax.swing.*;
import java.awt.*;

public class DrumPanel extends JPanel
{
     ImageIcon drumImage = new ImageIcon("src/image/drum.png");

     public DrumPanel()
     {
          JLabel imgLabel = new JLabel();
          imgLabel.setIcon(drumImage);
          // add(imgLabel);
          JButton newButton = new JButton();
          add(newButton);
          requestFocus();
          setFocusable(true);

          DrumHit test = new DrumHit();
          addKeyListener(test);
     }

     @Override
     public void paintComponent(Graphics g)
     {
          super.paintComponent(g);
          g.drawImage(drumImage.getImage(), 36, 40, null);
     }
}
