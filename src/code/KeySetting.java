import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeySetting extends JFrame
{
     Character targetKey;

     public KeySetting(String title, Character prevKey) throws HeadlessException
     {
          super("Key Setting");
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setSize(250, 160);
          setResizable(false);
          setLocationRelativeTo(null);
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);

          targetKey = prevKey;

          JLabel guide = new JLabel("<html><body><center>다른 키로 변경하려면 원하는 키를<br>입력한 후 확인을 눌러주세요.</center></body></html>");
          guide.setBounds(23, 5, 250, 40);
          add(guide);

          JTextArea temp = new JTextArea(prevKey.toString(), 1, 1);
          temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
          temp.setBounds(3, 50, 230, 20);
          temp.setCaretPosition(temp.getText().length());
          temp.addKeyListener(new KeyListener()
          {
               @Override
               public void keyTyped(KeyEvent e)
               {
                    if(temp.getText().length() >= 1)
                    {
                         e.consume();
                    }
               }

               @Override
               public void keyPressed(KeyEvent e)
               {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                         if(temp.getText().length() != 0)
                         {
                              targetKey = temp.getText().charAt(0);
                              dispose();
                         }
                    }
               }

               @Override
               public void keyReleased(KeyEvent e)
               {

               }
          });
          add(temp);

          JButton confirmButton = new JButton("확인");
          confirmButton.setBounds(70, 80, 100, 30);
          confirmButton.addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                    if(temp.getText().length() != 0)
                    {
                         targetKey = temp.getText().charAt(0);
                         dispose();
                    }
               }
          });
          add(confirmButton);
     }

     public char getTargetKey()
     {
          return targetKey;
     }

     public void setTargetKey(char targetKey)
     {
          this.targetKey = targetKey;
     }


}
