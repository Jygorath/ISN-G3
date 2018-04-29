package reseau.fabriques;

import reseau.couches.*;
import reseau.Imager;
import reseau.Paramètre;
import reseau.neurones.*;

public class FabriqueCouche {
    
    private Paramètre param;
    private int indice;
    
    public FabriqueCouche(Paramètre param) {
        this.indice = 0;
        this.param = param;
    }
    
    public Couche createCouche(Neurone n, int nombre) {
        Couche<? extends Neuronable> couche = null;
        
        switch(n) {
            case CONV : couche = new CoucheCONV<ConV>(nombre, this.indice, new Imager(), param); indice++; break;
            case MAXPOOL : couche = new CoucheCONV<MaxPool>(1, this.indice, new Imager(), param); indice++; break;
            case RELU : couche = new CoucheCONV<ReLU>(1, this.indice, new Imager(), param); indice++; break;
            case PERCEPTRON : couche = new CoucheMLP<Perceptron>(nombre, this.indice, new Imager(), param); indice++; break;}
        
        return couche;
    }
}
