package fr.saeS3A01.group1;


import java.util.ArrayList;

public class BasicStrategy implements ColorStrategy{


    @Override
    public Color colorCalculation(Vector d, Shape shape, Scene scene,double mint) throws Exception {

        Color res;
        if(scene.getAmbient()==null) res = new Color(0,0,0);
        else res = scene.getAmbient();
        return res.multiply(255);
    }

}
