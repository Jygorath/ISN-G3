package reseau.couches;

import reseau.Imager;
import reseau.Paramètre;


public class CoucheMLP<N> extends Couche<N> {
    
    //Constructeur de la sous-classe utilisant le constructeur parents.
    public CoucheMLP(int nombre, int indice, Imager img, Paramètre param) {
        super(nombre, indice, img, param);
    }
    
    //Méthode de calcul de la couche.
    public float[][][] calcul(float[][][] volumeEntrée) {
        float[][][] volumeSortie;   //Déclaration du volume de sortie.
        //Initialisation d'un nouveau volume d'entrée en 1 dimension grâce à Imager.
        float[] newVolumeEntrée = super.img.aplatir(volumeEntrée);
        
        //Initialisation du volume de sortie de la bonne taille.
        volumeSortie = new float[1][1][super.getNombre()];
            
        //Parcoure et complétion du volume de sortie par chaque neurone grâce à Paramètre.
        for(int x = 0; x < volumeSortie[0][0].length; x++)
            newVolumeEntrée[x] = super.neurones.get(x).calcul(newVolumeEntrée, param.getPoids(super.getIndice(), x));
        return volumeSortie;
    }
}
