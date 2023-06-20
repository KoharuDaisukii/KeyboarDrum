import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcousticDrum extends JFrame
{
     public AcousticDrum()
     {
          setTitle("KeyboarDrum");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(700, 600);
          setResizable(false);
          setLocationRelativeTo(null);
          // getContentPane().setBackground(Color.WHITE);
          setLayout(new BorderLayout());

          DrumPanel drumPanel = new DrumPanel();
          add(drumPanel, BorderLayout.CENTER);
     }
}
