package reseau.couches;

import reseau.Imager;
import reseau.Paramètre;
import reseau.neurones.Neurone;

//Sous-classe de Couche pour les neurones de type Convolution.
public class CoucheCONV<N>  extends Couche<N>{
    
    //Constructeur de la sous-classe utilisant le constructeur parents.
    public CoucheCONV(int nombre, int indice, Imager img, Paramètre param) {
        super(nombre, indice, img, param);
    }
    
    //Méthode de calcul de la couche.
    public float[][][] calcul(float[][][] volumeEntrée) {
        float[][][] volumeSortie;   //Déclaration du volume de sortie.
        //Initialisation du volume de sortie de la bonne taille grâce à l'énumération.
        volumeSortie = new float[volumeEntrée.length * super.getNombre()]
                                [volumeEntrée[0].length * neurone.getCoeffVolume()]
                                [volumeEntrée[0][0].length * neurone.getCoeffVolume()];
            
        //On prépare les futures balayages du volume à venir.
        img.debutBalayage(volumeEntrée, neurone.getTailleFiltre(), neurone.getZeroPadding(), neurone.getPas());
            
            //Parcoure et complétion du volume de sortie grâce aux objets Imager et Paramètre.
        for(int z = 0; z < volumeSortie.length; z++) {
            for(int y = 0; y < volumeSortie[0].length; y++) {
            for(int x = 0; x < volumeSortie[0][0].length; x++) {
                int n = this.nextNeurone(z, volumeEntrée.length);
                volumeSortie[z][y][x] = neurones.get(n).calcul(img.balayer(), param.getPoids(super.getIndice(), n));}}}
            
        //On reset les valeurs de compteurs de Imager afin qu'il soit de nouveau opérationnel.
        img.finBalayage();
        return volumeSortie;
    }
    
    //Méthode privée qui indique l'indice du neurone à utiliser pour le calcul (suivant son type).
    private int nextNeurone(int z, int profondeur) {
        //Si la couche est de type Perceptron :
        if(neurone == Neurone.CONV)
            return (int)(z / profondeur);
        //Sinon on retourne 0.
        else return 0;
    }
}
