package reseau;

import java.util.ArrayList;     //Import de l'objet ArrayList (tableau a taille indéfini).

//Objet qui centralise les poids de chaques neurones.
public class Paramètre {
    private ArrayList<float[][]> couches;      //Liste contenant les poids des neurones de chaque couche du réseau.
    
    //Constructeur par défaut.
    public Paramètre() {}
    
    //Constructeur prenant une liste de matrice (une par couche) contenant les poids des neurones de ces couches.
    public Paramètre(ArrayList<float[][]> couches) {
        this.couches = couches;
    }
    
    //Accesseur aux poids de chaque neurone.
    public float[] getPoids(int indiceCouche, int indiceNeurone) {return couches.get(indiceCouche)[indiceNeurone];}
}
