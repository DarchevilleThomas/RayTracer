# SAE 3.A.01

## Test the project

You can test the project in 2 different ways :

1. First way : 
 - Get the bash script 'scriptMain.sh' in the scripts folder at the root of the project as well as the jar file 'saeMain.jar'. 
 - Put them in the same folder; in a terminal go to this folder and run the command : ```bash scriptMain.sh [test.txt]```

This first way will carry out the tests with the Main branch of our project. 
In this main branch there are all the features that work perfectly.

Features that work perfectly :

 - Showing all shapes.  
 - Basic shape without any lights.  
 - Lambert algorithm on every shapes.  
 - Blinn-Phong algorithm on every shapes.




2. Second way : 
 - Get the bash script 'scriptMain2.sh' in the scripts folder at the root of the project as well as the jar file 'saeMain2.jar'.
 - Put them in the same folder, in a terminal go to this file and run the command : ```bash scriptMain2.sh [test.txt]```


This second way will carry out the tests with the Main2 branch of our project.
In this Main2 branch there are all the features that work perfectly and the features that work but not totally.

Features with bugs are :

 - the shadows, they create bugs on the triangles.
 - The reflection, when it takes place, the lights on the reflections are missing.
 - The checkerboard is present but there is a place where the checkerboard is not done.


## Task evaluation
1. Breakdown of the specifications into main tasks of development project:
    - **Task 1**: Manipulation of numerical triplets (points, vectors, colors).
    - **Task 2**: Reading text files representing 3D scenes.
    - **Task 3**: Generation of images with spheres in 2D.
    - **Task 4**: Taking into account diffuse light and light sources.
    - **Task 5**: Appearance of plane and triangle objects.
    - **Task 6**: Adding shadows and reflections.
    - **Task 7**: Procedural texture: checkerboard.
    - **Task 8**: Anti-aliasing.

## Project conventions
1. **Branch name:** *The branches must have the name of the corresponding task.*
2. **Task closure:** *#<the task name> in the final commit to close the task related to the branch*
3. **Comments, variable and function naming:** *IN ENGLISH!*
4. **Absolute rule:** *never push on the main branch !*
