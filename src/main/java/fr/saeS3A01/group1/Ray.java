package fr.saeS3A01.group1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

public class Ray {

    /**
     * Method for creating a black image without shapes
     * @param scene a Scene
     * @param outputName a String
     * @throws Exception Exception for the saving image
     */
    public void ray(Scene scene,String outputName) throws Exception {
        Color color;
        int imgwidth = scene.getWidth();
        int imgheight = scene.getHeight();
        double fovr = (scene.getCamera().getFov() * PI) / 180;
        double pixelheight = tan(fovr / 2);
        double pixelwidth = pixelheight * (imgwidth / imgheight);

        BufferedImage image = new BufferedImage(imgwidth, imgheight, 1);
        Point lookFrom = scene.getCamera().getPosition();
        Point lookAt = scene.getCamera().getTarget();
        for (int i = 0; i < imgwidth; i++) {
            for (int j = 0; j < imgheight; j++) {
                Vector w = (lookFrom.sub(lookAt)).normalize();

                double a = (-imgwidth / 2) + (i + 0.5) * pixelwidth;
                double b = (imgheight / 2) - (j + 0.5) * pixelwidth;

                Vector d = lookFrom.sub(new Point(a, b, 0));

                boolean p = false;
                if (p) {
                    color = new Color(255, 255, 255);
                } else {
                    color = new Color(0, 0, 0);
                }

                int rgb = new java.awt.Color((int) color.getTriplet().x, (int) color.getTriplet().y, (int) color.getTriplet().z).getRGB();
                image.setRGB(i, j, rgb);
            }
        }

        try {
            File outputfile = new File(outputName);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




