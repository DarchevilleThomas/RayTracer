package fr.saeS3A01.group1;

import java.util.ArrayList;

public interface ColorStrategy {
    Color colorCalculation(Sphere sphere, Point p, ArrayList<Light> lights,Scene scene) throws Exception;

}
