package reseau.neurones;



//Énumération des neurones
public enum Neurone {
    //Liste des types de neurone. Le booléen en paramètre détermine si ils sont pondérés ou non.
    CONV(true, 3, 1, 2, 1),
    PERCEPTRON(true, 0, 0, 0, 0),
    MAXPOOL(false, 2, 2, 0, 2),
    RELU(false, 1, 1, 0, 1);
	
    //Les variables informés en paramètre du constructeur.
    private boolean paramètrable;
    private int tailleFiltre;
    private int coeffVolumeSortie;
    private int zeroPadding;
    private int pas;
	
    //Constructeur comprenant en paramètre le booléen et la taille du filtre de chaque neurone.
    Neurone(boolean param, int tailleFiltre, int coeffVolumeSortie, int zeroPadding, int pas) {
        //Affectation des valeurs passés en paramètres
        this.paramètrable = param;
        this.tailleFiltre = tailleFiltre;
        this.coeffVolumeSortie = coeffVolumeSortie;
        this.zeroPadding = zeroPadding;
        this.pas = pas;
    }
	
    //Les accesseurs aux paramètres stockés.
    public boolean getParamètrable() {return paramètrable;}
    public int getTailleFiltre() {return tailleFiltre;}
    public int getCoeffVolume() {return coeffVolumeSortie;}
    public int getZeroPadding() {return zeroPadding;}
    public int getPas() {return pas;}
}
