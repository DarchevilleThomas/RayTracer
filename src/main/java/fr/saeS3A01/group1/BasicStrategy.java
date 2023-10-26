package fr.saeS3A01.group1;


import java.util.ArrayList;

public class BasicStrategy implements ColorStrategy{

    /**
     Method for calculating the color of a point using the basic method
     * @return Color
     */
    @Override
    public Color colorCalculation(Shape shape, Point p, ArrayList<Light> lights, Scene scene, Vector d) throws Exception {
        Color res;
        if( scene.getAmbient()==null) res = new Color(0,0,0);
        else res = scene.getAmbient();
        return res.multiply(255);
    }
}
