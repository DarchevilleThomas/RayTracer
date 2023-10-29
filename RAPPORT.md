# RAPPORT SAE 3.A.01

## Groupe 1 : Cuisset Matteo / Broulin Gregory / Darcheville Thomas / Hemery Noah

### Répartition des tâches avant le commencement du projet : 

Avant le commencement du projet, il fallait mettre en place notre méthode de travail.
Premièrement Thomas a créé le projet sur Gitlab ainsi que le squelette du projet pour pouvoir tous commencer sur la même base.
Suite à la création du Gitlab, Gregory et Noah ont décortiqué le sujet pour en extraire les tâches à réaliser pour ensuite créer les tickets.
En parallèle, Matteo s'est occupé de créer le README et de décrire les conventions du projet.

#### Nos portfolios :

Gregory : https://gitlab.univ-artois.fr/thomas_darcheville/sae-3.a.01/-/wikis/PORTFOLIO-BROULIN-Gregory

Matteo : https://gitlab.univ-artois.fr/thomas_darcheville/sae-3.a.01/-/wikis/PORTFOLIO-CUISSET-Matteo

Thomas : https://gitlab.univ-artois.fr/thomas_darcheville/sae-3.a.01/-/wikis/PORTFOLIO-DARCHEVILLE-Thomas

Noah : https://gitlab.univ-artois.fr/thomas_darcheville/sae-3.a.01/-/wikis/PORTFOLIO-HEMERY-Noah



---

### Manipulation de triplets numériques : 

Dans cette partie nous nous sommes réparti le travail de cette manière : 

Matteo a tout d'abord créé la classe Triplet avec toutes les méthodes de calcul (addition,soustraction,multiplicationc, etc...).
Thomas a ensuite créé la classe Point qui prend comme attribut un triplet pour ensuite réaliser toutes les opérations possibles sur un point.
Gregory a créé la classe Color qui prend également un triplet en attribut et qui réalise les opérations possibles avec une couleur.
Noah a finalement créé la classe Vector qui utilise un triplet en attribut pour effectuer les différentes opérations.
Nous avons chacun ajouté les getters et setters dans nos classes respectives pour faciliter l'accès et la modifications aux attributs si besoin.

Cette répartition des tâches nous a permis à chacun d'appliquer la compétence 1 : Réaliser un développement d’application. 

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
En ce qui concerne le parser, SonarLint nous indique une trop grande compléxité dans le parser à cause des switch/case.

Gregory a ensuite écrit les méthodes des classes Scene et SceneBuilder. Tout d'abord dans la classe SceneBuilder des setters pour les différents attributs récupérés à l'aide du parser et des fonctions add qui permettent d'ajouter une lumière à la liste des lumières et une forme à la liste des formes. De plus il a ajouté la méthode build qui permet de construire une scène.

Enfin Thomas a écrit la classe Main qui sera utilisée dans un script bash lorsque l'on voudra effectuer un rendu depuis la console d'une image à partir d'un fichier texte.

---

### Génération d’images avec des sphères en 2D :

La répartition des tâches pour cette tâches est :

Tout d'abord, Noah a implémenté dans Shape la méthode permettant de calculer la distance entre un point et une direction. Il a ensuite écrit la méthode dans Sphere et en attendant les méthodes de calcul des distances pour le plan et le triangle, il a ajouté une exception aux méthodes.
Ensuite, Gregory a créé la classe Ray qui créera l'image, il a également implémenté l'algorithme de lancer de rayon.
En parallèle, Matteo a modifié le parser pour qu'il gère les exceptions et il a aidé à l'implémentation de l'algorithme.
Thomas quant à lui, a modifier le main pour qu'il utilise la méthode ray de la classe Ray.

---

### Avec les couleurs, c’est mieux :

Nous nous sommes réparti les tâches de cette manière :

Premièrement Thomas a modifié la classe PointLight pour pouvoir récupérer la couleur de la lumière ainsi que la direction de la lumière en un point donné.
En parallèle Noah a réalisé le même travail sur la classe DirectionalLight.

Nous voulions pouvoir avoir le choix pour le calcul de la couleur d'un point entre le modèle de base et le modèle de Lambert.
Gregory a donc implémenté le patron de conception "stratégie" car ce dernier permet de rendre interchangeables des algorithmes ayant des rôles similaires. Ce patron est donc le plus adapté à notre besoin.
Matteo et Gregory ont ensuite modifié la méthode ray pour qu'elle s'adapte au modèle (soit basique soit Lambert) pour calculer la couleur du pixel.

---

### Apparition des objets plans et triangles :

Pour cette partie, la répartition des tâches est la suivante :

Thomas a complété la méthode pour calculer la distance dans la classe Triangle.
En parallèle Noah a complété la méthode distance dans la classe Plan. Il a également revu l'implémentation du patron de conception "stratégie" pour l'optimiser.
Une fois ces tâches faites, Matteo et Gregory ont encore modifié la méthode ray pour qu'elle fonctionne avec les triangles les plans.
Matteo a également modifié le parser pour corriger des problèmes.

---

### Des ombres et des réflexions :

Pour cette partie, nous avons réparti les tâches de cette manière :

Noah a ajouté au patron de conception (Strategy) l'algorithme de Blinn-Phong.
En parallèle Matteo a implémenté les ombres et il a modifié le parser, cependant les ombres ne sont pas parfaitement fonctionnelles, il y a des problèmes avec les triangles.
Gregory et Thomas se sont occupé des réflexions. Les réflexions fonctionnent mais les lumières n'apparaissent pas sur ces dernières.

---

### Texture procédurale : le damier : 

Noah a implémenté le damier mais ce dernier n'est pas parfait, il y a un endroit du plan où il y a deux lignes de carrés de la même couleur. 













