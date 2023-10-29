package fr.sae.group1.raytracing;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

/**
 * Ray class to create the finale png files with the scene created before where the color strategy is used.
 */
public class Ray {

    private Ray(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method for casting rays with intersection detection
     * @param scene a Scene
     * @param outputName a String
     */
    public static void ray(Scene scene, String outputName) {
        Color black = new Color(0,0,0);
        ColorStrategy strategy;
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
                int rgb = 0;
                if (lastShape != null) {
                    if (black.getTriplet().equals(lastShape.getDiffuse().getTriplet()) && black.getTriplet().equals(lastShape.getSpecular().getTriplet())){
                        strategy = new BasicStrategy();
                        rgb = strategy.colorCalculation(d,lastShape,scene,scene.getLights(), mint).getRGB();
                    }
                    else {
                        if (black.getTriplet().equals(lastShape.getSpecular().getTriplet())){
                            strategy = new LambertStrategy();
                            BasicStrategy basic = new BasicStrategy();
                            if(scene.getAmbient()==null){
                                rgb = basic.colorCalculation(d,lastShape,scene, scene.getLights(),mint).add(strategy.colorCalculation(d,lastShape,scene, scene.getLights(),mint)).add(black).getRGB();
                            }else {
                                rgb = basic.colorCalculation(d,lastShape,scene, scene.getLights(),mint).add(strategy.colorCalculation(d,lastShape,scene, scene.getLights(),mint)).add(scene.getAmbient()).getRGB();

                            }
                        }else {
                            strategy = new PhongStrategy();
                            rgb = strategy.colorCalculation(d,lastShape,scene, scene.getLights(),mint).getRGB();
                        }
                    }

                }
                image.setRGB(i,j,rgb);
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