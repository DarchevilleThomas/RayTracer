package fr.saeS3A01.group1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.*;

public class Ray {

    /**
     * Method for casting rays with intersection detection
     * @param scene a Scene
     * @param outputName a String
     * @throws Exception Exception for the saving image
     */
    public void ray(Scene scene,String outputName) throws Exception {
        Color color, colorShape;
        Color black = new Color(0,0,0);

        int imgwidth = scene.getWidth();
        int imgheight = scene.getHeight();
        double fovr = (scene.getCamera().getFov() * PI) / 180;
        double realheight = 2*tan(fovr / 2);
        double pixelheight = realheight/imgheight;
        double realwidth =imgwidth * pixelheight;
        double pixelwidth = realwidth/imgwidth;
        BufferedImage image = new BufferedImage(imgwidth,imgheight, 1);
        Point lookFrom = scene.getCamera().getPosition();
        Point lookAt = scene.getCamera().getTarget();
        Vector up = scene.getCamera().getUp();
        Vector w = (lookFrom.sub(lookAt)).normalize();
        Vector u = (up.cross(w)).normalize();
        Vector v = (w.cross(u)).normalize();
        for (int i = 0; i < imgwidth; i++) {
            for (int j = 0; j < imgheight; j++) {

                double a = (-realwidth / 2) + (i + 0.5) * pixelwidth;
                double b = (realheight / 2) - (j + 0.5) * pixelheight;
                Vector d =  (u.mul(a).add(v.mul(b)).sub(w)).normalize();

                Point p = null;


                int nbShape = scene.getShapes().size();
                for(int k=0; k<nbShape; k++){
                    double t = scene.getShapes().get(k).distance(lookFrom,d);
                    if(t >= 0 ) {
                        p = (d.mul(t)).add(lookFrom);

                    }
                }

                if (p != null) {
                    color = scene.getAmbiant();
                } else {
                    color = black;
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




