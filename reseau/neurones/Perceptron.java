package reseau.neurones;



//Neurone de type Perceptron
public class Perceptron extends NeuronePondéré implements Neuronable {
	
    //Méthode de sauvegarde du biais (ou seuil) du neurone, stocké comme première valeur de poids (indice 0).
    private float[] sansBiais(float[] p) {
        //On initialise un tableau de taille n-1 par rapport au tableau de poids donné.
        float[] poidsSansBiais = new float[p.length - 1];
        for(int i = 1; i < p.length; i++)	//On parcoure la liste des poids de 1 à n (donc sans le biais).
            poidsSansBiais[i - 1] = p[i];	//On transfert le tableau de poids sans biais.
        return poidsSansBiais;
    }
	
    //Méthode de calcul du neurone, fonction d'activation (ici représenté par une fonction sigmoïde).
    @Override
    public float calcul(float[] e, float[] p) {
        //Calcul de la somme pondérée entrées/poids moins le seuil (ou biais).
        double x = (double)(super.somme(e, this.sansBiais(p)) - p[0]);
        //Fonction d'activation du neurone (ici une fonction sigmoïde).
        return (float)(1/(1 + Math.exp(-x)));
    }
}
