package fr.sae.group1.raytracing;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.DirectionalLight;
import fr.sae.group1.light.Light;
import fr.sae.group1.light.PointLight;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

import java.util.List;

import static java.lang.Math.max;

public class PhongStrategy implements ColorStrategy {

    /**
     * Method to calculate the color with Phong
     * @param d
     * @param shape
     * @param scene
     * @param mint
     * @return a color
     */
    @Override
    public Color colorCalculation(Vector d, Shape shape, Scene scene, List<Light> accessibleLights, double mint) {
        LambertStrategy strategy = new LambertStrategy();
        BasicStrategy basic = new BasicStrategy();
        Point p = new Point((d.mul(mint).add(scene.getCamera().getPosition()).getTriplet()));
        Vector n = shape.getN(p);
        Color res;
        if (scene.getAmbient() == null) res = new Color(0, 0, 0);
        else res = scene.getAmbient();
        Vector eyeDir = new Vector(d.getTriplet().getX()*-1,d.getTriplet().getY()*-1,d.getTriplet().getZ()*-1);
        Color col = new Color(0,0,0);
        for (Light light : scene.getLights()){
            if (light instanceof PointLight pointLight){
                Vector lightDir = pointLight.getPointLightVector(p);
                Vector h = lightDir.add(eyeDir).normalize();
                col = strategy.colorCalculation(d,shape,scene,accessibleLights,mint).add(light.getColor().multiply(Math.pow(Math.max(n.dot(h),0),shape.getShininess())).schurProduct(shape.getSpecular()));
            }else {
                Vector lightDir = ((DirectionalLight)light).getDirectionalLightVector();
                Vector h = lightDir.add(eyeDir).normalize();
                col = strategy.colorCalculation(d,shape,scene, accessibleLights,mint).add(light.getColor().multiply(Math.pow(Math.max(n.dot(h),0),shape.getShininess())).schurProduct(shape.getSpecular()));

            }

        }

        return basic.colorCalculation(d,shape,scene, accessibleLights,mint).add(res.add(col));


    }

}
