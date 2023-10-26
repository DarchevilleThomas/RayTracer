package fr.saeS3A01.group1;

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
    public Shape(Color diffuse, Color specular, int shininess){
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
     * @param lookFrom
     * @param d
     * @return
     * @throws Exception
     */
    public abstract double distance(Point lookFrom, Vector d) throws Exception;

    /**
     * Method to get the normal of a shape
     * @param p
     * @return a vector
     * @throws Exception
     */
    public abstract Vector getN(Point p) throws Exception;

}