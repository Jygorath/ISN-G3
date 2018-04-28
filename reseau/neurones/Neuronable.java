package reseau.neurones;



//Interface qui décrit le comportement de tout les neurones.
public interface Neuronable {
    //Méthode de calcul des neurones.
    public float calcul(float[] e, float[] p);
}
