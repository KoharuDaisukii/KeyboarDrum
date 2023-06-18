import javax.sound.sampled.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

public class DrumHit implements KeyListener
{
     @Override
     public void keyTyped(KeyEvent e)
     {
          System.out.println(e.getKeyChar() + " typed");
          try
          {
               long start = System.currentTimeMillis();
               Clip clip = AudioSystem.getClip();
               File soundfile = null;

               int key = e.getKeyChar();
               if(key == '1') soundfile = new File("src/sounds/Acoustic_Drum/ac_crash.wav");
               else if(key == '2') soundfile = new File("src/sounds/Acoustic_Drum/ac_hihat_close.wav");
               else if(key == '3') soundfile = new File("src/sounds/Acoustic_Drum/ac_hihat_open.wav");
               else if(key == '4') soundfile = new File("src/sounds/Acoustic_Drum/ac_snare.wav");
               else if(key == '5') soundfile = new File("src/sounds/Acoustic_Drum/ac_tom1.wav");
               else if(key == '6') soundfile = new File("src/sounds/Acoustic_Drum/ac_kick.wav");
               else if(key == '7') soundfile = new File("src/sounds/Acoustic_Drum/ac_tom2.wav");
               else if(key == '8') soundfile = new File("src/sounds/Acoustic_Drum/ac_tom3.wav");
               else if(key == '9') soundfile = new File("src/sounds/Acoustic_Drum/ac_ride.wav");


               AudioInputStream sound = AudioSystem.getAudioInputStream(soundfile);
               clip.open(sound);
               clip.start();
               long end = System.currentTimeMillis();
               System.out.println("latency: " + (end - start) + "ms");
          }
          catch(LineUnavailableException ex)
          {
               ex.printStackTrace();
          }
          catch(UnsupportedAudioFileException ex)
          {
               ex.printStackTrace();
          }
          catch(IOException ex)
          {
               ex.printStackTrace();
          }
          catch(NullPointerException ex)
          {
               ex.printStackTrace();
               System.exit(1);
          }
     }

     @Override
     public void keyPressed(KeyEvent e) {}

     @Override
     public void keyReleased(KeyEvent e) {}
}
