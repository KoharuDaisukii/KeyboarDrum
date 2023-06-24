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

     String[] ClickOrKeyboardStr = {"키보드로 연주하기", "마우스로 연주하기"};
     public JList ClickOrKeyboardList = new JList(ClickOrKeyboardStr);

     Integer crashKey = (int) 'y';
     int hihatClosedKey = 'r';
     int hihatOpenKey = 'e';
     int snareKey = 's';
     int highTomKey = 'g';
     int kickKey = 'x';
     int lowTomKey = 'h';
     int floorTomKey = 'j';
     int rideKey = 'u';


     public DrumPanel()
     {
          JLabel imgLabel = new JLabel();
          imgLabel.setIcon(drumImage);
          setLayout(null);
          setBackground(Color.WHITE);

          DrumHit test = new DrumHit();
          addKeyListener(test);

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
          ClickOrKeyboardList.setBounds(577, 190, 107, 36);
          add(ClickOrKeyboardList);

          JButton setButton = new JButton("설정");

          setButton.setBounds(577, 270, 107, 36);
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

          JButton keysetButton = new JButton("trasd");

          keysetButton.setBounds(300, 500, 107, 36);
          keysetButton.addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    KeySetting temp = new KeySetting("Crash", crashKey.toString());
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
                    if(key == crashKey) soundfile = new File("src/sound/Acoustic_Drum/ac_crash.wav");
                    else if(key == hihatClosedKey) soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_close.wav");
                    else if(key == hihatOpenKey) soundfile = new File("src/sound/Acoustic_Drum/ac_hihat_open.wav");
                    else if(key == snareKey) soundfile = new File("src/sound/Acoustic_Drum/ac_snare.wav");
                    else if(key == highTomKey) soundfile = new File("src/sound/Acoustic_Drum/ac_tom1.wav");
                    else if(key == kickKey) soundfile = new File("src/sound/Acoustic_Drum/ac_kick.wav");
                    else if(key == lowTomKey) soundfile = new File("src/sound/Acoustic_Drum/ac_tom2.wav");
                    else if(key == floorTomKey) soundfile = new File("src/sound/Acoustic_Drum/ac_tom3.wav");
                    else if(key == rideKey) soundfile = new File("src/sound/Acoustic_Drum/ac_ride.wav");
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
