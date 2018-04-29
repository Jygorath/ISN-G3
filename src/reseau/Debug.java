package reseau;

import reseau.couches.CoucheCONV;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import reseau.neurones.ConV;
import reseau.neurones.Neuronable;

public class Debug {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
            ArrayList<float[][]> poids = new ArrayList<float[][]>(1);
            poids.add(new float[][]{});
            Paramètre param = new Paramètre(poids);
            Imager image = new Imager();
            
            CoucheCONV<ConV> couche = new CoucheCONV<ConV>(1, 0, image, param);
            
            Image img = ImageIO.read(new File("/home/kitakomatsu/Documents/test.png"));
	}
}
