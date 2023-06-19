import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboarDrum extends JFrame
{
     public KeyboarDrum()
     {
          setTitle("KeyboarDrum");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(700, 600);
          setResizable(false);
          setLocationRelativeTo(null);
          setLayout(new BorderLayout());
          getContentPane().setBackground(Color.WHITE);

          AcousticDrumZone();
     }

     public void AcousticDrumZone()
     {
          DrumPanel drumPanel = new DrumPanel();
          add(drumPanel, BorderLayout.CENTER);
     }
}