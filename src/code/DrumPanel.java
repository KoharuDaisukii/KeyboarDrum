import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class DrumPanel extends JPanel
{
     private static final int COMPONENT_COUNT = 9;
     private ImageIcon drumImage = new ImageIcon("src/image/drum.png");

     String[] ClickOrKeyboardStr = {"키보드로 연주하기", "마우스로 연주하기"};
     public JList ClickOrKeyboardList = new JList(ClickOrKeyboardStr);

     public DrumPanel()
     {
          JLabel imgLabel = new JLabel();
          imgLabel.setIcon(drumImage);
          setLayout(null);
          setBackground(Color.WHITE);

          DrumHit test = new DrumHit();
          JButton[] drumKit = new JButton[COMPONENT_COUNT];
          int[] x = {173, 105, 105, 200, 241, 275, 328, 385, 435};
          int[] y = {40, 190, 115, 258, 127, 300, 127, 255, 100};
          String[] componentName = {"Crash", "<html><body><center>Hihat<br>(Close)</center></body></html>", "<html><body><center>Hihat<br>(Open)</center></body></html>", "Snare", "<html><body><center>High<br>Tom</center></body></html>", "Kick", "<html><body><center>Low<br>Tom</center></body></html>", "<html><body><center>Floor<br>Tom</center></body></html>", "Ride"};
          for(int i = 0; i < COMPONENT_COUNT; i++)
          {
               drumKit[i] = new JButton(componentName[i]);
               drumKit[i].setBounds(x[i], y[i], 70, 45);
               add(drumKit[i]);
               drumKit[i].addActionListener(test);
               drumKit[i].addActionListener(new ActionListener()
               {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         ClickOrKeyboardList.setSelectedIndex(1);
                    }
               });
          }

          ClickOrKeyboardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일 선택
          ClickOrKeyboardList.setSelectedIndex(0);
          ClickOrKeyboardList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
          ClickOrKeyboardList.setBounds(575, 190, 107, 36);
          add(ClickOrKeyboardList);

          JButton setButton = new JButton("설정");

          setButton.setBounds(575, 270, 107, 36);
          setButton.addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    if(ClickOrKeyboardList.getSelectedIndex() == 0)
                    {
                         setButton.setFocusable(false);
                         requestFocus();
                         setFocusable(true);
                    }
               }
          });
          add(setButton);

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

     private class DrumHit implements KeyListener, ActionListener
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
               //clickedButton.set
               String part = clickedButton.getText();
               System.out.println(part + " button clicked");

               try
               {
                    boolean right_input = true;
                    long start = System.currentTimeMillis();
                    Clip clip = null;
                    File soundfile = null;

                    if(part.equals("Crash")) soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
                    else if(part.equals("<html><body><center>Hihat<br>(Close)</center></body></html>"))
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
                    else if(part.equals("<html><body><center>Hihat<br>(Open)</center></body></html>"))
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
                    else if(part.equals("Snare")) soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
                    else if(part.equals("<html><body><center>High<br>Tom</center></body></html>"))
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
                    else if(part.equals("Kick")) soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
                    else if(part.equals("<html><body><center>Low<br>Tom</center></body></html>"))
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
                    else if(part.equals("<html><body><center>Floor<br>Tom</center></body></html>"))
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
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
}
