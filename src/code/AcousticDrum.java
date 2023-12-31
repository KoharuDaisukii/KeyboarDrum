import javax.swing.*;
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
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);

          drumPanel.setBounds(3, 15, 745, 600);
          add(drumPanel);

          CustomButton backButton = new CustomButton("back", "png");
          backButton.setBounds(7,0,60,60);
          backButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    dispose();
                    KeyboarDrum restart = new KeyboarDrum();
                    restart.setVisible(true);
                    System.out.println(backButton);
               }
          });
          drumPanel.add(backButton);
     }
}
