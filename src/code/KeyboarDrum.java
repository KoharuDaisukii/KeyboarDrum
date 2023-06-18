import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboarDrum extends JFrame
{
     public static void main(String[] args)
     {
          KeyboarDrum keyboardrum = new KeyboarDrum();
          keyboardrum.setVisible(true);
     }

     public KeyboarDrum()
     {
          setTitle("KeyboarDrum");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(100, 100);

          DrumHit test = new DrumHit();
          addKeyListener(test);
     }


}