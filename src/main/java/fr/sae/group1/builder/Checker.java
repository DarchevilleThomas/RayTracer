package fr.sae.group1.builder;

public class Checker {
    private Color color1;
    private Color color2;
    private double size;

    /**
     * Constructor for a checker
     *
     * @param color1 a color
     * @param color2 a color
     * @param size a double
     */
    public Checker(Color color1, Color color2, double size) {
        this.color1 = color1;
        this.color2 = color2;
        this.size = size;
    }

    /**
     * Return the first color of a checker
     *
     * @return Color
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * Set the first color of a checker
     *
     * @param color1 first color of a checker
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * Return the second color of a checker
     *
     * @return Color
     */
    public Color getColor2() {
        return color2;
    }

    /**
     * Set the second color of a checker
     *
     * @param color2 second color of a checker
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    /**
     * Return the size for a square of a checker
     *
     * @return Color
     */
    public double getSize() {
        return size;
    }

    /**
     * Set the size for a square of a checker
     *
     * @param size size for a square of a checker
     */
    public void setSize(double size) {
        this.size = size;
    }
}
