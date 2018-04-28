package reseau;

import reseau.neurones.Neuronable;
import reseau.neurones.Neurone;
import java.util.ArrayList;     //Import de l'objet ArrayList (tableau a taille indéfini).

//Objet contenant plusieurs neurones.
public abstract class Couche<N> {
    protected ArrayList<? extends Neuronable> neurones;  //Liste des neurones.
    private Class<N> classe;    //Classe de type N servant à l'instanciation d'objet de type N.
    protected Neurone neurone;    //Énumération (constantes) du/des neurones.
    protected Imager img;		//Objet d'aide à la manipulation d'image et de volume d'entrée/sortie.
    protected Paramètre param;	//Objet contenant les poids des neurones pondérées.
	
    private boolean paramètrable;   //Défini si le neurone possède des poids.
    private int indice;		//Indice du neurone dans la liste des couches de l'objet Réseau.
    private int nombre;		//Nombre de neurones dans la couche.
	
    //Constructeur prenant en paramètre le type et le nombre de neurone.
    public Couche(int nombre, int indice, Imager img, Paramètre param) throws InstantiationException, IllegalAccessException {
        //Affectation des valeurs fourni en paramètre.
        this.nombre = nombre;
        this.indice = indice;
        this.paramètrable = neurone.getParamètrable();
        
        //Instanciation des références aux objets Imager et Paramètre du Réseau.
        this.img = img;
        this.param = param;
		
        //Initialisation de la liste de neurone suivant leur type.
        ArrayList liste = new ArrayList();
        for(int i = 0; i < nombre; i++)
            liste.add(newInstance(classe));
        neurones = liste;
        
        //Initialisation de la bonne constante en fonction du type générique.
        this.neurone = Neurone.valueOf(neurones.get(0).getClass().getName().toUpperCase());
    }
    
    //Accesseurs aux variables primitives.
    public int getIndice() {return this.indice;}
    public int getNombre() {return this.nombre;}
    
    //Méthode générique qui retourne une instance du type N.
    private <N> N newInstance(Class<N> classe) throws InstantiationException, IllegalAccessException {return classe.newInstance();}
	
    //Méthode de calcul de la couche à redéfinir par les objets héritants.
    public abstract float[][][] calcul(float[][][] volumeEntrée);
}
