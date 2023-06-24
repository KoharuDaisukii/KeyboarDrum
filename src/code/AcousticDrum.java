import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcousticDrum extends JFrame
{
     public AcousticDrum()
     {
          DrumPanel drumPanel = new DrumPanel();

          setTitle("KeyboarDrum");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(700, 600);
          setResizable(false);
          setLocationRelativeTo(null);
          // getContentPane().setBackground(Color.WHITE);
          setLayout(null);

          drumPanel.setBounds(-45, 0, 745, 600);
          add(drumPanel);


     }
}
