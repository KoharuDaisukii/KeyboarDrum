import javax.swing.*;
import java.io.File;

public class CustomButton extends JButton
{
     String buttonName;
     String ext;

     public CustomButton(String name, String file_Extension)
     {
          super(new ImageIcon(KeyboarDrum.IMAGEDIR + name + "." + file_Extension));
          setBorderPainted(false);
          setContentAreaFilled(false);
          setFocusPainted(false);
          setRolloverIcon(new ImageIcon(KeyboarDrum.IMAGEDIR + name + "Rollover." + file_Extension));
          setPressedIcon(new ImageIcon(KeyboarDrum.IMAGEDIR + name + "Pressed." + file_Extension));

          this.setButtonName(name);
          this.setExt(file_Extension);
     }

     public String getButtonName()
     {
          return buttonName;
     }

     public void setButtonName(String buttonName)
     {
          this.buttonName = buttonName;
     }

     public String getExt()
     {
          return ext;
     }

     public void setExt(String ext)
     {
          this.ext = ext;
     }

     @Override
     public String toString()
     {
          return "CustomButton {" + buttonName + "Button} Clicked";
     }
}

