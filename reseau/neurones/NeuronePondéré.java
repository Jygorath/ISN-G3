package reseau.neurones;



//Surclasse de neurone (pondérée)
class NeuronePondéré {
	
    //Méthode qui calcule la somme pondérée des entrées et des poids.
    protected float somme(float[] e, float[] p) {
        float somme = 0;	//Initialisation d'une variable somme.
        //On parcoure les entrées et les poids afin de calculer la somme pondérées membres à membres.
        for(int i = 0; i < e.length && i < p.length; i++) {
            somme += e[i]*p[i];		//Calcule et ajout de chaque membre pondérée.
        }
        return somme;
    }
}
