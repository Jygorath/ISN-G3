package reseau.fabriques;

import reseau.neurones.*;

public class FabriqueNeurone {
    
    public Neuronable createNeurone(Neurone n) {
        Neuronable neurone = null;
        switch(n) {
            case CONV : neurone = new ConV(); break;
            case MAXPOOL : neurone = new MaxPool(); break;
            case RELU : neurone = new ReLU(); break;
            case PERCEPTRON : neurone = new Perceptron(); break;}
        return neurone;
    }
}
