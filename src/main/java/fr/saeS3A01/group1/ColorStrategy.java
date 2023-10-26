package fr.saeS3A01.group1;

import java.util.ArrayList;

public interface ColorStrategy {
    Color colorCalculation(Shape shape, Point p, ArrayList<Light> lights,Scene scene,Vector d) throws Exception;

}
