package reseau.neurones;



//Neurone ReLU
public class ReLU implements Neuronable {

    //Méthode implémentée de calcul (celle qui sera utilisé par la suite).
    @Override
    public float calcul(float[] e, float[] p) {return this.calcul(e);}
    
        //Méthode de calcul qui prend en paramètre une entrée (stockée dans un tableau pour plus de commodité).
    public float calcul(float[] e) {
        //Fonction unité de rectification linéaire (ReLU).
        if(e.length == 1) {	//si la valeur est négative, elle vaut zéro.
            if(e[0] < 0) return 0.0f;
                else return e[0];	//Sinon elle est inchangée.
            }
        else return -1.0f;  //En cas d'erreur dans la valeur donnée, on retourne -1,
        //par exemple si le tableau contient plus d'une valeur.
    }
}
