package fr.sae.group1;

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
     */
    public void ray(Scene scene,String outputName,ColorStrategy strategy) {
        Color black = new Color(0,0,0);
        int imgwidth = scene.getWidth();
        int imgheight = scene.getHeight();
        double fovr = (scene.getCamera().getFov() * PI) / 180;
        double realheight = 2*tan(fovr / 2);
        double pixelheight = realheight/imgheight;
        double realwidth =imgwidth * pixelheight;
        double pixelwidth = realwidth/imgwidth;
        double aStart = -realwidth / 2;
        double bStart = realheight / 2;
        BufferedImage image = new BufferedImage(imgwidth,imgheight, 1);
        Point lookFrom = scene.getCamera().getPosition();
        Point lookAt = scene.getCamera().getTarget();
        Vector up = scene.getCamera().getUp();
        Vector w = (lookFrom.sub(lookAt)).normalize();
        Vector u = (up.cross(w)).normalize();
        Vector v = (w.cross(u)).normalize();
        Color ambiantColor = scene.getAmbient();
        if(ambiantColor==null) {
            ambiantColor = black;
        }
        for (int i = 0; i < imgwidth; i++) {
            for (int j = 0; j < imgheight; j++) {

                double a = aStart + (i + 0.5) * pixelwidth;
                double b = bStart - (j + 0.5) * pixelheight;
                Vector d = (u.mul(a).add(v.mul(b)).sub(w)).normalize();
                double mint = -1;
                double t;
                Shape lastShape = null;

                for (Shape shape : scene.getShapes()) {


                    t = shape.distance(lookFrom, d);
                    if (0 <= t && (mint < 0 || t < mint)) {
                        mint = t;
                        lastShape = shape;
                    }
                }
                if (lastShape != null && 0 <= mint) {
                    if ( black.getTriplet().equals(lastShape.getDiffuse().getTriplet())) {
                        image.setRGB(i, j,(new BasicStrategy()).colorCalculation(d,lastShape,scene,mint).getRGB());

                    } else {
                        BasicStrategy strategy2 = new BasicStrategy();
                        int rgb = strategy2.colorCalculation(d,lastShape,scene,mint).add((new LambertStrategy()).colorCalculation(d,lastShape,scene,mint).schurProduct(lastShape.getDiffuse()).add(ambiantColor)).getRGB();
                        image.setRGB(i, j,rgb) ;

                    }
                } else {
                    image.setRGB(i, j, 0);

                }
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