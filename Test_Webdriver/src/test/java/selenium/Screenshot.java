package selenium;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;

public class Screenshot {
	
	 public static void screenshot(){
		 String Location = "D:\\Result_Snaps\\";
		 String Method_Name = new Throwable().getStackTrace()[1].getMethodName();
		 String timeStamp = new SimpleDateFormat("yyyy_MM_dd mm_ss").format(Calendar.getInstance().getTime());
		 try{
		 Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		 BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		 ImageIO.write(screenFullImage, "png", new File(Location+Method_Name+timeStamp+".png"));
	 } catch(Exception e){
		 System.out.println("Error occured");
	 }
	 }
}
