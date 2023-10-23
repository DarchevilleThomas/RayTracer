package fr.saeS3A01.group1;

// Une classe pour représenter une scène 3D
class Scene {
    // Les attributs de la scène
    private Camera camera; // La caméra qui capture la scène
    private int width; // La largeur de l'image en pixels
    private int height; // La hauteur de l'image en pixels
    private ArrayList<Light> lights; // La liste des lumières dans la scène
    private ArrayList<Shape3D> shapes; // La liste des formes 3D dans la scène

    // Le constructeur de la scène
    Scene(Camera camera, int width, int height) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = new ArrayList<Light>();
        this.shapes = new ArrayList<Shape3D>();
    }

    // Une méthode pour ajouter une lumière à la scène
    public void addLight(Light light) {
        this.lights.add(light);
    }

    // Une méthode pour ajouter une forme 3D à la scène
    public void addShape(Shape3D shape) {
        this.shapes.add(shape);
    }

}
