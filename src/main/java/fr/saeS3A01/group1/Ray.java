package fr.saeS3A01.group1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

public class Ray {


    public void ray(Scene scene,String outputName) throws Exception {
        int imgwidth = scene.getWidth();
        int imgheight = scene.getHeight();
        double fovr = (scene.getCamera().getFov() * PI) / 180;
        double pixelheight = tan(fovr / 2);
        double pixelwidth = pixelheight * (imgwidth / imgheight);

        BufferedImage image = new BufferedImage(imgwidth, imgheight, 1);
        Color color;

        Point lookFrom = scene.getCamera().getPosition();
        Point lookAt = scene.getCamera().getTarget();

        for (int i = 0; i < imgwidth; i++) {
            for (int j = 0; j < imgheight; j++) {

                //calculer le vecteur unitaire d qui représente un rayon allant de l’œil lookF rom au centre du
                //pixel (i, j)
                Vector w = (lookFrom.sub(lookAt)).normalize();
                Vector u = null;

                double a = (-imgwidth / 2) + (i + 0.5) * pixelwidth;
                double b = (imgheight / 2) - (j + 0.5) * pixelwidth;

                Vector d = lookFrom.sub(new Point(a, b, 0));
                //rechercher le point p = lookF rom + d × t d’intersection le plus proche (t minimal) avec un
                //objet de la scène
                boolean p = false;

                //si p existe alors calculer sa couleur
                if (p) {
                    color = new Color(255, 255, 255);
                } else {
                    //sinon utiliser du noir
                    color = new Color(255, 255, 255);
                }

                //peindre le pixel (i, j) avec la couleur adéquate
                int rgb = new java.awt.Color((int) color.getTriplet().x, (int) color.getTriplet().y, (int) color.getTriplet().z).getRGB();
                image.setRGB(i, j, rgb);
            }
        }
        //sauvegarder l’image
        try {
            File outputfile = new File(outputName);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


