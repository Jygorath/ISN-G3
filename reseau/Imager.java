package reseau;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

//Objet d'aide à la manipulation d'image et des volumes entrées/sorties.
public class Imager {
	
    private Image img;
    private BufferedImage bImg;
    
    private float[][][] volume;
    private int compteur;
    private int compteurParMatrice;
    private int compteurParTableau;
    int pas; int tailleFiltre;
    private int z, x, y;
	
    //Méthode de conversion d'une image en volume de données.
    public float[][] convertir(Image I) {
        bImg = (BufferedImage) I;
        Raster rst = bImg.getRaster();
        float[][] image = new float[bImg.getWidth()][bImg.getHeight()];
        
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[i].length; j++)
                image[i][j] = (float) rst.getSample(i, j, 0);}
        
        return image;
    }
    
    //Méthode d'initialisation de balayer().
    public void debutBalayage(float[][][] volume, int tailleFiltre, int zeroPadding, int pas) {
        //Affectation des variables.
        this.tailleFiltre = tailleFiltre;
        this.pas = pas;
        
        //Affectation du volume suivant le zero padding (la marge).
        if(zeroPadding != 0) {
            //On détermine les limites dans les matrices (du volume) de la marge.
            int limiteInferieur = (int)(zeroPadding / 2);
            int limiteSuperieur = zeroPadding - limiteInferieur;
            
            //On instancie un nouveau volume à la taille ajustée en fonction de la marge.
            this.volume = new float[volume.length][volume[0].length + zeroPadding][volume[0][0].length + zeroPadding];
            
            //On parcoure le volume pour afin de lui assigner les bonnes valeurs.
            for(int z = 0; z < this.volume.length; z++) {
                for(int y = 0; y < this.volume[0].length; y++) {
                    for(int x = 0; x < this.volume[0][0].length; x++) {
                        //Si il est en dehors des limites, on assigne un zero.
                        if((y < limiteInferieur) || (y >= this.volume[0].length - limiteSuperieur) || 
                            (x < limiteInferieur) || (x >= this.volume[0][0].length - limiteSuperieur))
                            this.volume[z][y][x] = 0;
                        else    //Sinon on lui recopie les valeurs du volume d'origine en tenant compte de la marge.
                            this.volume[z][y][x] = volume[z][y - limiteInferieur][x - limiteInferieur];}}}}
        else this.volume = volume;
        
        //On détermine les valeurs que prend le compteur pour remplir une matrice et un tableau du volume.
        compteurParTableau = volume[0][0].length / this.pas;
        compteurParMatrice = compteurParTableau * (volume[0].length / this.pas);
    }
	
    //Méthode de balayage d'un volume de données suivant la taille du filtre et le zero padding.
    public float[] balayer() {
        //Initialisation (Instanciation) du tableau d'entrées à retourner
        float[] entrees = new float[tailleFiltre * tailleFiltre];
        
        //On trouve la zone du volume à renvoyer grâce au compteur et 
        //aux valeurs de compteur (par matrice et par tableau) défini dans débutBalayage().
        z = (int)(compteur / compteurParMatrice);
        y = (int)((compteur - (z * compteurParMatrice)) / compteurParTableau);
        x = compteur - ((z * compteurParMatrice) + (y * compteurParTableau));
        
        //On parcoure la matrice trouvée plus haut dans le volume avec comme indice
        //la localisation de la valeur du volume dans le tableau de sortie.
        int indice = 0;
        for(int i = y; i < y + tailleFiltre; i++) {
            for(int j = x; j < x + tailleFiltre; j++) {
                entrees[indice] = volume[z][i][j];
                indice++;}}
        
        //On incrémente le compteur.
        compteur++;
        
        return entrees;
    }
    
    //Méthode de fin de balayer(), retour à des valeurs par défaut.
    public void finBalayage() {
        z = 0; y = 0; x = 0;
        tailleFiltre = 1;
        pas = 1;
        
        //Important !! Le reste est optionnel.
        compteur = 0;
        compteurParTableau = 0;
        compteurParMatrice = 0;
    }
	
    //Méthode qui "applatit" un volume de données en un simple tableau à une dimension.
    public float[] aplatir(float[][][] volume) {
        float[] volumePlat = new float[volume.length * volume[0].length * volume[0][0].length];
        return new float[]{};
    }
}
