package fr.saeS3A01.group1;

public class Sphere extends Shape {

    private Color diffuse;
    private Color specular;
    private int shininess;
    private double radius;
    private Point p;

    /**
     * Constructor of a sphere
     * @param diffuse a color
     * @param specular a color
     * @param shininess a int
     * @param p a point
     * @param radius a double
     */
    public Sphere(Color diffuse, Color specular, int shininess,Point p,double radius) {
        super(diffuse, specular, shininess);
        this.p = p;

        this.radius = radius;
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(double radius) {

        this.radius = radius;
    }

    public Point getP() {

        return p;
    }

    public void setP(Point p) {

        this.p = p;
    }

    /**
     * A method to calculate the distance
     * @param lookFrom
     * @param d
     * @return
     * @throws Exception
     */
    @Override
    public double distance(Point lookFrom,Vector d) throws Exception {
        double a = 1;
        double b = ((lookFrom.sub(p)).mul(2)).dot(d);
        double c = ((lookFrom.sub(p)).dot(lookFrom.sub(p))) - radius*radius;
        double delta = (b*b)-4*a*c;
        if(delta<0){
            return -1;
        }
        if(delta<0.001){
            return -b/2*a;
        }
        else {
            double t1 = (-b+Math.sqrt(delta))/2*a;
            double t2 = (-b-Math.sqrt(delta))/2*a;
            if(t2>0){
                return t2;
            }
            if(t1>0){
                return t1;
            }else{
                return -1;
            }
        }
    }
    
    /**
     * Returns a string representation of this Sphere.
     * 
     * @return A string representation of this Sphere.
     */
    @Override
    public String toString() {
        return "Sphere {point=" + p + ", radius=" + radius + "}";
    }
}
