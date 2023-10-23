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

    // Une méthode pour rendre la scène et renvoyer une image
    public Image render() {
        // Créer une image vide de la taille spécifiée
        Image image = new Image(width, height);

        // Parcourir tous les pixels de l'image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Calculer le rayon qui part de la caméra vers le pixel
                Ray ray = camera.getRay(x, y);

                // Calculer la couleur du pixel en fonction des intersections avec les formes 3D et les lumières
                Color color = getColor(ray);

                // Affecter la couleur au pixel de l'image
                image.setPixel(x, y, color);
            }
        }

        // Renvoyer l'image générée
        return image;
    }

    // Une méthode pour calculer la couleur d'un pixel en fonction d'un rayon
    private Color getColor(Ray ray) {
        // Initialiser la couleur à noir
        Color color = Color.BLACK;

        // Initialiser la distance minimale à l'infini
        double minDistance = Double.POSITIVE_INFINITY;

        // Initialiser la forme 3D la plus proche à null
        Shape3D closestShape = null;

        // Parcourir toutes les formes 3D de la scène
        for (Shape3D shape : shapes) {
            // Calculer l'intersection entre le rayon et la forme 3D
            Intersection intersection = shape.intersect(ray);

            // Si il y a une intersection et que sa distance est inférieure à la distance minimale
            if (intersection != null && intersection.getDistance() < minDistance) {
                // Mettre à jour la distance minimale et la forme 3D la plus proche
                minDistance = intersection.getDistance();
                closestShape = shape;
            }
        }

        // Si il y a une forme 3D la plus proche
        if (closestShape != null) {
            // Calculer le point d'intersection entre le rayon et la forme 3D la plus proche
            Point point = ray.getPoint(minDistance);

            // Calculer la normale à la surface de la forme 3D au point d'intersection
            Vector normal = closestShape.getNormal(point);

            // Calculer la couleur diffuse de la forme 3D au point d'intersection
            Color diffuseColor = closestShape.getDiffuseColor(point);

            // Initialiser la couleur du pixel à la couleur diffuse de la forme 3D
            color = diffuseColor;

            // Parcourir toutes les lumières de la scène
            for (Light light : lights) {
                // Calculer le vecteur qui va du point d'intersection vers la lumière
                Vector lightVector = light.getPosition().subtract(point).normalize();

                // Calculer le produit scalaire entre le vecteur normal et le vecteur lumière
                double dotProduct = normal.dot(lightVector);

                // Si le produit scalaire est positif, c'est-à-dire que le point est éclairé par la lumière
                if (dotProduct > 0) {
                    // Calculer le facteur d'éclairage en fonction du produit scalaire et de l'intensité de la lumière
                    double factor = dotProduct * light.getIntensity();

                    // Calculer la couleur de la lumière en fonction de sa couleur et du facteur d'éclairage
                    Color lightColor = light.getColor().multiply(factor);

                    // Ajouter la couleur de la lumière à la couleur du pixel
                    color = color.add(lightColor);
                }
            }
        }

        // Renvoyer la couleur du pixel
        return color;
    }
}
