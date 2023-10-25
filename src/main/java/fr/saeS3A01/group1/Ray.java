package fr.saeS3A01.group1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Ray {
    private ColorStrategy colorStrat = new LambertStrategy();
    private ColorStrategy colorBasic = new BasicStrategy();
    /**
     * Method for casting rays with intersection detection
     * @param scene a Scene
     * @param outputName a String
     * @throws Exception Exception for the saving image
     */
    public void ray(Scene scene,String outputName) throws Exception {
        Color color, colorShape = null;
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

        ArrayList<Light> lights =scene.getLights();
        Color ambiantColor = scene.getAmbient();
        if(ambiantColor==null) ambiantColor = black;
        for (int i = 0; i < imgwidth; i++) {
            for (int j = 0; j < imgheight; j++) {

                double a = (-realwidth / 2) + (i + 0.5) * pixelwidth;
                double b = (realheight / 2) - (j + 0.5) * pixelheight;
                Vector d = (u.mul(a).add(v.mul(b)).sub(w)).normalize();
                double mint = -1;
                double t = -1;
                Shape lastShape = null;

                for (Shape shape : scene.getShapes()) {
                    t = shape.distance(lookFrom, d);
                    if (0 <= t && (mint < 0 || t < mint)) {
                        mint = t;
                        lastShape = shape;
                    }
                }

                int rgb;

                Point p = null;
                if (0 <= mint) {
                    p = new Point((d.mul(mint)).add(lookFrom).getTriplet());

                    if (lastShape.getDiffuse().getTriplet().x == black.getTriplet().x && lastShape.getDiffuse().getTriplet().y == black.getTriplet().y && lastShape.getDiffuse().getTriplet().z == black.getTriplet().z) {
                        colorShape = colorBasic.colorCalculation((Sphere) lastShape, p, lights, scene);
                    } else {
                        Color colorShape1 = colorBasic.colorCalculation((Sphere) lastShape, p, lights, scene);
                        Color colorShape2 = colorStrat.colorCalculation((Sphere) lastShape, p, lights, scene).schurProduct(lastShape.getDiffuse()).add(ambiantColor);
                        colorShape = colorShape1.add(colorShape2);
                    }

                }



                if (p != null) {
                    color = colorShape;
                } else {
                    color = black;
                }

                rgb = new java.awt.Color((int) color.getTriplet().x, (int) color.getTriplet().y, (int) color.getTriplet().z).getRGB();
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




