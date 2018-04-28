package reseau.neurones;



//Neurone Pooling (ici Pooling Max)
public class MaxPool implements Neuronable {

    //Méthode implémentée de calcul (celle qui sera utilisé par la suite).
    @Override
    public float calcul(float[] e, float[] p) {return this.calcul(e);}
    
    //Méthode de calcul du maximum dans une liste de valeur
    public float calcul(float[] e) {
        float max = e[0];	//Par défaut on définit le maximum comme étant la première valeur du tableau.
        for(int i = 0; i < e.length; i++)	//On parcoure le tableau.
            if(max < e[i]) max = e[i];	//Si l'une des valeur est supérieur au maximum, elle le devient.
        return max;
    }
}
