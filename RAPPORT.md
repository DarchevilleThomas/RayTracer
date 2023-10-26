# RAPPORT SAE 3.A.01

## Groupe 1 : Cuisset Matteo / Broulin Gregory / Darcheville Thomas / Hemery Noah


### Manipulation de triplets numériques : 

Dans cette partie nous nous sommes réparti le travail de cette manière : 

Matteo a tout d'abord créé la classe Triplet avec toutes les méthodes de calcul (addition,soustraction,multiplicationc, etc...).
Thomas a ensuite créé la classe Point qui prend comme attribut un triplet pour ensuite réaliser toutes les opérations possibles sur un point.
Gregory a créé la classe Color qui prend également un triplet en attribut et qui réalise les opérations possibles avec une couleur.
Noah a finalement créé la classe Vector qui utilise un triplet en attribut pour effectuer les différentes opérations.
Nous avons chacun ajouté les getters et setters dans nos classes respectives pour faciliter l'accès et la modifications aux attributs si besoin.

Cette réaprtition des tâches nous a permis à chacun d'appliquer la compétence 1 : Réaliser un développement d’application. 

---

### Lecture des fichiers textes représentant les scènes 3D :

Dans cette partie la répartition des tâches s'est déroulée de cette manière :

Thomas a créé la classe Triangle avec comme attribut 3 points, 2 couleurs et l'attribut shininess. Il a également ajouté les getters et les setters.
Noah a ajouté la classe Sphere avec comme attribut un point, un double représentant le rayon, 2 couleurs et shininess. Il a également ajouté les getters et les setters.
Gregory a implémenté la classe Plane qui représente un plan avec comme attribut un point, un vecteur, 2 couleurs ainsi que shininess. Il a également ajouté les getters et les setters.

En ajoutant ces trois classes nous avons remarqué qu'elles avaient comme attributs en commun : les 2 couleurs (diffuse,specular) ainsi que shininess. Pour optimiser le code, nous avons fait le choix d'implementer la classe abstraite Shape. Sphere,Plane et Triangle héritent donc de cette classe.


Matteo a implémenté les classes : -DirectionalLight qui prend un vecteur en attribut.
                                  -PointLight qui prend un point en attribut.
Ces deux objets ont également besoin d'une couleur pour être créé. C'est pourquoi Matteo a décidé de créer une classe abstraite Light dont les deux classes héritent.

Pour construire progressivement la scène nous avions besoin d'implémenter un patron de conception.
Noah s'est donc chargé d'implémenter le patron de conception "Builder" car ce dernier permet d'associer un à un les attributs à un objet. Noah a donc créé une interface Builder, une classe SceneBuilder et une classe Scene.

Pour pouvoir récupérer les informations du fichier texte de création, nous avions besoin de créer un Parser. Matteo a donc réalisé la classe SceneParser qui va lire le fichier ligne par ligne et utiliser les méthodes adéquates.

Gregory a ensuite écrit les méthodes des classes Scene et SceneBuilder. Tout d'abord dans la classe SceneBuilder des setters pour les différents attributs récupérés à l'aide du parser et des fonctions add qui permettent d'ajouter une lumière à la liste des lumières et une forme à la liste des formes. De plus il a ajouté la méthode build qui permet de construire une scène.

Enfin Thomas a écrit la classe Main qui sera utilisée dans un scirpt bash lorsque l'on voudra effectuer un rendu depuis la console d'une image à partir d'un fichier texte.

---

### Génération d’images avec des sphères en 2D






