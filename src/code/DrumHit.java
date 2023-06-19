import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

public class DrumHit implements KeyListener, ActionListener
{
     @Override
     public void keyTyped(KeyEvent e)
     {
          System.out.println(e.getKeyChar() + " typed");

          try
          {
               boolean right_input = true;
               long start = System.currentTimeMillis();
               Clip clip = null;
               File soundfile = null;

               int key = e.getKeyChar();
               if(key == '1') soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
               else if(key == '2') soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
               else if(key == '3') soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
               else if(key == '4') soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
               else if(key == '5') soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
               else if(key == '6') soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
               else if(key == '7') soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
               else if(key == '8') soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
               else if(key == '9') soundfile = new File("src/sound/Acoustic_Drum/ac_ride.wav");
               else right_input = false;

               if(right_input)
               {
                    clip = AudioSystem.getClip();
                    AudioInputStream sound = AudioSystem.getAudioInputStream(soundfile);
                    clip.open(sound);
                    clip.start();
               }

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
          }
     }

     @Override
     public void keyPressed(KeyEvent e) {}

     @Override
     public void keyReleased(KeyEvent e) {}

     @Override
     public void actionPerformed(ActionEvent e)
     {
          JButton clickedButton = (JButton) e.getSource();
          String part = clickedButton.getText();
          System.out.println(part+ " button clicked");

          try
          {
               boolean right_input = true;
               long start = System.currentTimeMillis();
               Clip clip = null;
               File soundfile = null;

               if(part.equals("Crash")) soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
               else if(part.equals("<html><body><center>Hihat<br>(Open)</center></body></html>")) soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
               else if(part.equals("<html><body><center>Hihat<br>(Close)</center></body></html>")) soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
               else if(part.equals("Snare")) soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
               else if(part.equals("<html><body><center>High<br>Tom</center></body></html>")) soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
               else if(part.equals("Kick")) soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
               else if(part.equals("<html><body><center>Low<br>Tom</center></body></html>")) soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
               else if(part.equals("<html><body><center>Floor<br>Tom</center></body></html>")) soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
               else if(part.equals("Ride")) soundfile = new File("src/sound/Acoustic_Drum/ac_ride.wav");
               else right_input = false;

               if(right_input)
               {
                    clip = AudioSystem.getClip();
                    AudioInputStream sound = AudioSystem.getAudioInputStream(soundfile);
                    clip.open(sound);
                    clip.start();
               }

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
          }
     }
}
