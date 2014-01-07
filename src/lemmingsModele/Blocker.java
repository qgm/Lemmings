package lemmingsModele;
import java.awt.Color;
import java.util.ArrayList;

/** La classe Blocker implante les m�thodes relatives aux bloqueurs
 * @author Quentin Glinel-Mortreuil
 */
public class Blocker implements Competence {
	
	/** Un Blocker emp�che les autres lemmings d'avancer, ces-derniers 
	 * rebrousseront donc chemin
	 */
	public void executer(Position positionInitiale, Map map,Lemming lemming) throws ConfigurationException {
		// Couleur du lemming en fonction de sa competence
		lemming.couleur = Color.gray;
		
		// Recuperation des cases necessaires au prochain deplacement
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
		ArrayList<Decor> colonneDecor = mapDecor.get(positionInitiale.abscisse);
		Decor blocker = new DecorDestructible();
		colonneDecor.set(positionInitiale.ordonnee,blocker);
	
	}

}
