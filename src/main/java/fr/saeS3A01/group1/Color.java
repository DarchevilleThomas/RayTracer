package fr.saeS3A01.group1;

/**
 * This class represents a color as a triplet of red, green, and blue
 * components.
 * Each component is represented as a double precision floating point number.
 */
public class Color {
    private Triplet triplet;

    /**
     * Returns the RGB triplet of this Color.
     * 
     * @return The RGB triplet of this Color.
     */
    public Triplet getTriplet() {
        return this.triplet;
    }

    /**
     * Sets the RGB triplet of this Color to the RGB triplet of another Color.
     * 
     * @param color The other Color whose RGB triplet is to be copied.
     */
    public void setTriplet(Color color) {
        this.triplet = color.getTriplet();
    }

    /**
     * Sets the RGB triplet of this Color.
     * 
     * @param triplet The new RGB triplet for this Color.
     */
    public void setTriplet(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Sets the RGB triplet of this Color using individual red, green, and blue
     * values.
     * 
     * @param red   The red component of the new RGB triplet.
     * @param green The green component of the new RGB triplet.
     * @param blue  The blue component of the new RGB triplet.
     */
    public void setTriplet(double red, double green, double blue) {
        this.triplet = new Triplet(red, green, blue);
    }

    /**
     * Constructs a new Color with the given red, green, and blue values.
     * 
     * @param red   The red component of the new Color.
     * @param green The green component of the new Color.
     * @param blue  The blue component of the new Color.
     */
    public Color(double red, double green, double blue) {
        this.triplet = new Triplet(red, green, blue);
    }

    /**
     * Constructs a new Color with the given RGB triplet.
     * 
     * @param triplet The RGB triplet for the new Color.
     */
    public Color(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Constructs a new Color by copying the RGB triplet from another Color.
     * 
     * @param color The other Color whose RGB triplet is to be copied.
     */
    public Color(Color color) {
        this.triplet = color.getTriplet();
    }

    /**
     * Returns a new Color that is the product of this Color and a scalar.
     * Each component (red, green, and blue) of the original color is multiplied by
     * the scalar to produce the new color.
     * 
     * @param scalar The scalar to multiply with.
     * @return A new Color that is the product of this Color and a scalar.
     */
    public Color multiply(double scalar) {
        return new Color(this.triplet.mul(scalar));
    }

    /**
     * Returns a new Color that is the sum of this and another Color.
     * Each corresponding component (red, green, and blue) from both colors are
     * added together to produce the new color.
     * 
     * @param other The other color to add with.
     * @return A new color that is the sum of this and another color.
     */
    public Color add(Color other) {
        return new Color(this.triplet.add(other.getTriplet()));
    }

    /**
     * Returns a new color that is the Schur product (element-wise multiplication)
     * of this and another color.
     * Each corresponding component (red, green, and blue) from both colors are
     * multiplied together to produce the new color.
     * 
     * @param other The other color to perform Schur product with.
     * @return A new color that is the Schur product of this and another color.
     */
    public Color schurProduct(Color other) {
        return new Color(this.triplet.schur(other.getTriplet()));
    }
}
