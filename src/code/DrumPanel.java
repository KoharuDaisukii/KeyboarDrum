import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DrumPanel extends JPanel
{
     private static final int COMPONENT_COUNT = 9;
     private ImageIcon drumImage = new ImageIcon("src/image/drum.png");
     JButton[] drumKit = new JButton[COMPONENT_COUNT];
     JLabel whatHit = new JLabel("None");
     String[] componentName = {"Crash", "<html><body><center>Hihat<br>(Close)</center></body></html>", "<html><body><center>Hihat<br>(Open)</center></body></html>", "Snare", "<html><body><center>High<br>Tom</center></body></html>", "Kick", "<html><body><center>Low<br>Tom</center></body></html>", "<html><body><center>Floor<br>Tom</center></body></html>", "Ride"};
     Character[] componentKey = {'y', 'r', 'e', 's', 'g', 'x', 'h', 'j', 'u'};


     public DrumPanel()
     {
          JLabel imgLabel = new JLabel();
          imgLabel.setIcon(drumImage);
          setLayout(null);
          setBackground(Color.WHITE);

          JLabel hitLabel = new JLabel("Hit :");;;;;
          hitLabel.setBounds(550, 0, 80, 80);
          add(hitLabel);

          whatHit.setBounds(557, 0, 80, 80);
          whatHit.setHorizontalAlignment(JLabel.CENTER);
          add(whatHit);

          DrumHit test = new DrumHit();
          addKeyListener(test);

          int[] x = {173, 105, 105, 200, 241, 275, 328, 385, 435};
          int[] y = {40, 190, 115, 258, 127, 300, 127, 255, 100};

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
                         requestFocus();
                         setFocusable(true);
                    }
               });
          }

          JLabel[] componentLabel = new JLabel[COMPONENT_COUNT];
          JLabel[] componentKeyLabel = new JLabel[COMPONENT_COUNT];
          for(int i = 0; i < COMPONENT_COUNT; i++)
          {
               componentLabel[i] = new JLabel(componentName[i]);
               componentLabel[i].setBounds(11 + 76 * i, 455, 70, 70);
               add(componentLabel[i]);

               int[] labelWeight = {0, 6, 6, 0, -5, -8, -6, -2, -7};
               componentKeyLabel[i] = new JLabel(" :  " + componentKey[i]);
               componentKeyLabel[i].setBounds(17 + 76 * i + labelWeight[i], 455, 70, 70);
               componentKeyLabel[i].setHorizontalAlignment(JLabel.CENTER);
               add(componentKeyLabel[i]);

               JButton keysetButton = new JButton("키 설정");
               keysetButton.setBounds(76 * i, 510, 74, 36);
               int finalI = i;
               keysetButton.addActionListener(new ActionListener()
               {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         KeySetting temp = new KeySetting(componentName[finalI], componentKey[finalI]);
                         temp.setVisible(true);
                         keysetButton.setEnabled(false);
                         temp.addWindowListener(new WindowListener()
                         {
                              @Override
                              public void windowOpened(WindowEvent e)
                              {

                              }

                              @Override
                              public void windowClosing(WindowEvent e)
                              {

                              }

                              @Override
                              public void windowClosed(WindowEvent e)
                              {
                                   keysetButton.setEnabled(true);
                                   componentKey[finalI] = temp.getTargetKey();
                                   componentKeyLabel[finalI].setText(": " + componentKey[finalI]);

                                   requestFocus();
                                   setFocusable(true);
                              }

                              @Override
                              public void windowIconified(WindowEvent e)
                              {

                              }

                              @Override
                              public void windowDeiconified(WindowEvent e)
                              {

                              }

                              @Override
                              public void windowActivated(WindowEvent e)
                              {

                              }

                              @Override
                              public void windowDeactivated(WindowEvent e)
                              {

                              }
                         });
                    }
               });
               add(keysetButton);

          }

          requestFocus();
          setFocusable(true);
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
                    if(key == componentKey[0])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
                         whatHit.setText(componentName[0]);
                    }
                    else if(key == componentKey[1])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
                         whatHit.setText(componentName[1]);
                    }
                    else if(key == componentKey[2])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
                         whatHit.setText(componentName[2]);
                    }
                    else if(key == componentKey[3])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
                         whatHit.setText(componentName[3]);
                    }
                    else if(key == componentKey[4])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
                         whatHit.setText(componentName[4]);
                    }
                    else if(key == componentKey[5])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
                         whatHit.setText(componentName[5]);
                    }
                    else if(key == componentKey[6])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
                         whatHit.setText(componentName[6]);
                    }
                    else if(key == componentKey[7])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
                         whatHit.setText(componentName[7]);
                    }
                    else if(key == componentKey[8])
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_ride.wav");
                         whatHit.setText(componentName[8]);
                    }
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

                    if(part.equals("Crash"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
                         whatHit.setText(componentName[0]);
                    }
                    else if(part.equals("<html><body><center>Hihat<br>(Close)</center></body></html>"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
                         whatHit.setText(componentName[1]);
                    }
                    else if(part.equals("<html><body><center>Hihat<br>(Open)</center></body></html>"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
                         whatHit.setText(componentName[2]);
                    }
                    else if(part.equals("Snare"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
                         whatHit.setText(componentName[3]);
                    }
                    else if(part.equals("<html><body><center>High<br>Tom</center></body></html>"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
                         whatHit.setText(componentName[4]);
                    }
                    else if(part.equals("Kick"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
                         whatHit.setText(componentName[5]);
                    }
                    else if(part.equals("<html><body><center>Low<br>Tom</center></body></html>"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
                         whatHit.setText(componentName[6]);
                    }
                    else if(part.equals("<html><body><center>Floor<br>Tom</center></body></html>"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
                         whatHit.setText(componentName[7]);
                    }
                    else if(part.equals("Ride"))
                    {
                         soundfile = new File("src/sound/Acoustic_Drum/ac_ride.wav");
                         whatHit.setText(componentName[8]);
                    }
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
