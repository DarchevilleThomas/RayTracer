package fr.sae.group1;

public class BasicStrategy implements ColorStrategy{

    /**
     *
     Color Calculation Method with Basic Strategy
     * @param d a Vector
     * @param shape a Shape
     * @param scene a Scene
     * @param mint  a double
     * @return Color
     */
    @Override
    public Color colorCalculation(Vector d, Shape shape, Scene scene,double mint){
        Color res;
        if(scene.getAmbient()==null) res = new Color(0,0,0);
        else res = scene.getAmbient();
        return res.multiply(255);
    }

}
