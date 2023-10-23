package fr.saeS3A01.group1;

public class Triangle extends Shape{

    private Point point1;
    private Point point2;
    private Point point3;

    /**
     * Constructor of the Triangle class
     *
     * @param diffuse   a Color
     * @param specular  a Color
     * @param shininess a int
     */
    public Triangle(Color diffuse, Color specular, int shininess, Point point1, Point point2, Point point3) {
        super(diffuse, specular, shininess);
        this.point1=point1;
        this.point2=point2;
        this.point3=point3;
    }

}
