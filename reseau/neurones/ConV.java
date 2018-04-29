package reseau.neurones;

//Neurone convolutif
public class ConV extends NeuronePondéré implements Neuronable {

    //Méthode de calcul, prend en paramètre une liste d'entrées et de poids.
    public float calcul(float[] e, float[] p) {
        return (super.somme(e, p) / p.length);	//Fonction identité (de la somme pondérée entrées/poids).
    }
}
