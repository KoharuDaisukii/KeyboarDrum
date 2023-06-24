import javax.swing.*;
import java.awt.*;

public class KeySetting extends JFrame
{
     int targetKey;

     public KeySetting(String title, String prevKey) throws HeadlessException
     {
          super(title + " Key Setting");
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setSize(250, 200);
          setResizable(false);
          setLocationRelativeTo(null);
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);

          JLabel guide = new JLabel("<html><body><center>다른 키로 변경하려면 원하는 키를<br>입력한 후 확인을 눌러주세요.</center></body></html>");
          guide.setBounds(23,5,250,40);
          add(guide);

          JTextArea temp = new JTextArea(prevKey.toString(), 1, 1);
          temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
          temp.setBounds(3, 50, 230, 20);
          add(temp);
     }

     public int getTargetKey()
     {
          return targetKey;
     }

     public void setTargetKey(int targetKey)
     {
          this.targetKey = targetKey;
     }


}
