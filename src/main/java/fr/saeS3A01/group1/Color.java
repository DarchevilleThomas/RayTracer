package fr.saeS3A01.group1;

public class Color {

    private Triplet triplet;

    /**
     * Constructor of the triple corresponding to a color from the colors red, green and blue
     * @param red a double
     * @param green a double
     * @param blue a double
     */
    public Color(double red, double green, double blue){
        triplet = new Triplet(red,green,blue);
    }

    /**
     *Constructor of the triple corresponding to a color from a triplet
     * @param triplet a Triplet
     */
    public Color(Triplet triplet){
        this(triplet.x, triplet.y, triplet.z);
    }

    /**
     * Getter for triplet
     * @return Triplet
     */
    public Triplet getTriplet() {
        return triplet;
    }

    /**
     * Setter for triplet
     * @param triplet a Triplet
     */
    private void setTriplet(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Method for adding color
     * @param red a double
     * @param green a double
     * @param blue a double
     * @return Color
     */
    public Color add(double red, double green, double blue){
        return new Color(triplet.add(new Triplet(red,green,blue)));
    }

    /**
     * Method for multiplication by a scalar
     * @param d a double
     * @return Color
     */
    public Color mul(double d){
        return new Color(triplet.mul(d));
    }

    /**
     * Method for Schur product
     * @param red a double
     * @param green a double
     * @param blue a double
     * @return Color
     */
    public Color schur(double red, double green, double blue){
        return new Color(triplet.schur(red,green,blue));
    }

}
