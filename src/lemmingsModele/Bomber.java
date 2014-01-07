package lemmingsModele;
import java.awt.Color;
import java.util.ArrayList;

/** La classe Bomber implantant les m�thodes relatives aux d�molisseurs
 * @author Quentin Glinel-Mortreuil
 */
public class Bomber implements Competence {
	
	/** Un Bomber explose apr�s 5 secondes et d�truit les obstacles destructibles environnants
	 * environnants
	 */
	int tempsRestant;
	public Bomber () {
		
	}
	
	public Bomber ( int tempsRestant ) {
		this.tempsRestant = tempsRestant;
	}
	
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException{
		
		// Couleur du lemming en fonction de sa competence
		lemming.couleur = Color.red;
		
		if (this.tempsRestant == 0) {
			
			// Recuperation des cases necessaires a la prochaine action
			Decor dessous = map.getDessous(positionInitiale,lemming.direction,map);
			Decor devant = map.getDevant(positionInitiale,lemming.direction,map);
			Decor dessus = map.getDessus(positionInitiale,lemming.direction,map);
			Decor derriere = map.getDerriere(positionInitiale,lemming.direction,map);
			Decor posLemming = map.getDecor(positionInitiale,map);
			
			Position positionDevant = new Position(positionInitiale.abscisse + 1,positionInitiale.ordonnee);
			Position positionDerriere = new Position(positionInitiale.abscisse - 1,positionInitiale.ordonnee);
			Position positionDessus = new Position(positionInitiale.abscisse,positionInitiale.ordonnee - 1);
			Position positionDessous = new Position(positionInitiale.abscisse,positionInitiale.ordonnee + 1);
			
			
			
			// Destruction des obstacles environnants
		
			posLemming.detruireObstacle();
			
			if (devant.estDestructible(positionInitiale,positionDevant)) {
				devant.detruireObstacle();
			}
			
			if (derriere.estDestructible(positionInitiale,positionDerriere)) {
				derriere.detruireObstacle();
			}
			
			if (dessus.estDestructible(positionInitiale,positionDessus)) {
				dessus.detruireObstacle();
			}
			
			if (dessous.estDestructible(positionInitiale,positionDessous)) {
				dessous.detruireObstacle();
			}
			
			// Mort du lemming a coder
			
		}
		
		else {
			
			// Temps restant != 0 : le Bomber arr�te son d�placement et attend 5 secondes
			// Recuperation des cases necessaires au prochain deplacement
			ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
			ArrayList<Decor> colonneDecor = mapDecor.get(positionInitiale.abscisse);
			Decor bomber = new DecorDestructible();
			colonneDecor.set(positionInitiale.ordonnee,bomber);
			this.tempsRestant -= 1;
		
		}
			
	
	
	
	}
}
