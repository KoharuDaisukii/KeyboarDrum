import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboarDrum extends JFrame
{
     private static final int BUTTON_COUNT = 2;
     private static final String IMAGEDIR = "src/image/";
     private static final String EXT = ".png";
     private static final String[] buttonName = {"start", "exit"};

     public KeyboarDrum()
     {
          setTitle("KeyboarDrum");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(700, 600);
          setResizable(false);
          setLocationRelativeTo(null);
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);

          JLabel title = new JLabel("KeyboarDrum");
          title.setBounds(215, 100, 300, 50);
          title.setFont(new Font("Arial", Font.BOLD, 30));
          title.setIcon(new ImageIcon(IMAGEDIR + "titleIcon" + ".jpg"));
          add(title);

          InitialScreenPanel();
     }

     public void InitialScreenPanel()
     {
          JButton[] initialButton = new JButton[BUTTON_COUNT];
          for(int i = 0; i < BUTTON_COUNT; i++)
          {
               initialButton[i] = new JButton(new ImageIcon(IMAGEDIR + buttonName[i] + EXT));
               initialButton[i].setBorderPainted(false);
               initialButton[i].setContentAreaFilled(false);
               initialButton[i].setFocusPainted(false);
               initialButton[i].setRolloverIcon(new ImageIcon(IMAGEDIR + buttonName[i] + "Rollover" + EXT));
               initialButton[i].setPressedIcon(new ImageIcon(IMAGEDIR + buttonName[i] + "Pressed" + EXT));
               initialButton[i].setBounds(266, 250 + i * 90, 167, 66);

               add(initialButton[i]);
          }

          initialButton[0].addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    dispose();
                    AcousticDrum test = new AcousticDrum();
                    test.setVisible(true);
               }
          });

          initialButton[1].addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    System.exit(1);
               }
          });
     }
}