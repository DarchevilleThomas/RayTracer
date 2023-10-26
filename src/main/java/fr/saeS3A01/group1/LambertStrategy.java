package fr.saeS3A01.group1;


import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

import static java.lang.Math.max;

public class LambertStrategy implements ColorStrategy{

    /**Method for calculating the color of a point using Lambert's method
     * @return Color
     */
    @Override
    public Color colorCalculation(Shape shape, Point p, ArrayList<Light> lights, Scene scene, Vector d) throws Exception {
        Color res = null;
        Vector n = new Vector(0,0,0);
        if (shape instanceof Sphere) {
            n = (p.sub(((Sphere) shape).getP())).normalize();
        }

        else if (shape instanceof Triangle) {
            n = ((((Triangle) shape).getPoint2().sub(((Triangle) shape).getPoint3())).cross((((Triangle) shape).getPoint1().sub(((Triangle) shape).getPoint3())))).normalize();
            Plane plane = new Plane(shape.getDiffuse(),shape.getSpecular(),shape.getShininess(),((Triangle) shape).getPoint1(),n);
            double t = plane.distance(scene.getCamera().getPosition(),d);
            Point pPlane = d.mul(t).add(scene.getCamera().getPosition());
            if( !(n.dot(((Triangle) shape).getPoint2().sub(((Triangle) shape).getPoint1()).cross(pPlane.sub(((Triangle) shape).getPoint1())))>= 0)
                    || !(n.dot(((Triangle) shape).getPoint3().sub(((Triangle) shape).getPoint2()).cross(pPlane.sub(((Triangle) shape).getPoint2())))>= 0)
                    || !(n.dot(((Triangle) shape).getPoint1().sub(((Triangle) shape).getPoint3()).cross(pPlane.sub(((Triangle) shape).getPoint3())))>= 0)) {
                return new Color(0,0,0);
            }
        }

        else if (shape instanceof Plane) {
            double t = shape.distance(scene.getCamera().getPosition(),d);
            Point pPlane = d.mul(t).add(scene.getCamera().getPosition());
            n = (pPlane.sub(((Plane) shape).getPoint())).normalize();
        }

        if (scene.getAmbient() == null) res = new Color(0, 0, 0);
        else res = scene.getAmbient();
        for (Light light : lights) {
            if (light instanceof PointLight plight) {
                res = res.add(shape.getDiffuse().schurProduct(light.getColor().multiply(max(n.dot(plight.getPointLightVector(p)), 0))));
            } else {
                DirectionalLight dlight = (DirectionalLight) light;
                res = res.add((dlight.getColor().multiply(max(n.dot(dlight.getDirectionalLightVector()), 0))));
            }
        }
        return res;
    }
}
