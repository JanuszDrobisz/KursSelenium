package pl.coderslab.funkcje;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotMaking {

    public static final void makeScreenShot() {

        Date dateNow = new Date( );
        SimpleDateFormat formatDate = new SimpleDateFormat ("yyyy.MM.dd_HHmmss");

        String screenFileName = "scr_Presta_Shop_Confirmation" + formatDate.format(dateNow);


        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(image, "png", new File("src/main/screenshots/" + screenFileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}