package fr.sae.group1;

public abstract class Shape {

    private Color diffuse;
    private Color specular;
    private int shininess;

    /**
     *  Constructor of the Figure class
     * @param diffuse a Color
     * @param specular a Color
     * @param shininess a int
     */
    protected Shape(Color diffuse, Color specular, int shininess){
        this.diffuse=diffuse;
        this.specular=specular;
        this.shininess=shininess;
    }

    /**
     *  getter for diffuse
     * @return Color
     */
    public Color getDiffuse() {
        return diffuse;
    }

    /**
     *  getter for specular
     * @return Color
     */
    public Color getSpecular() {
        return specular;
    }

    /**
     *  getter for shininess
     * @return int
     */
    public int getShininess() {
        return shininess;
    }

    /**
     *  setter for diffuse
     * @param diffuse a Color
     */
    public void setDiffuse(Color diffuse) {
        this.diffuse = diffuse;
    }

    /**
     *  setter for shininess
     * @param shininess a int
     */
    public void setShininess(int shininess) {
        this.shininess = shininess;
    }

    /**
     *  Setter for specular
     * @param specular a Color
     */
    public void setSpecular(Color specular) {
        this.specular = specular;
    }

    /**
     * Abstract method distance.
     * @param lookFrom a Point
     * @param d a Vector
     * @return double
     * @throws AbstractMethodError throw Exception
     */
    public abstract double distance(Point lookFrom, Vector d) throws AbstractMethodError;

    /**
     * Method to get the normal of a shape
     * @param p a Point
     * @return a vector
     * @throws AbstractMethodError throw Exception
     */
    public abstract Vector getN(Point p) throws AbstractMethodError;

}
