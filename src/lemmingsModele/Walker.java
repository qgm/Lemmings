package lemmingsModele;
import java.awt.Color;

/**  La classe Walker qui sera celle d'un lemming auquel aucune comp�tence n'a �t� assign�e
 * @author Quentin Glinel-Mortreuil
 */

public class Walker implements Competence {
	
	
	
	/** Un walker se contente d'avancer la o� il peut, il se retourne s'il 
	 *  rencontre un obstacle ou un Blocker, et est de couleur blanche
	 */
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException {
		
		// Couleur du lemming en fonction de sa comp�tence
		lemming.couleur = Color.white;
		
		// Eventuelle position suivante du lemming pour les obstacles meurtriers
		Position positionSuivante = new Position (0,0);
		
		
		
		if (lemming.direction.droite) {
			positionSuivante = new Position (positionInitiale.abscisse + 1, positionInitiale.ordonnee);
		}
		
		if (lemming.direction.gauche) {
			positionSuivante = new Position (positionInitiale.abscisse - 1, positionInitiale.ordonnee);
		}
		
		if (lemming.direction.bas) {
			positionSuivante = new Position (positionInitiale.abscisse, positionInitiale.ordonnee + 1);
		}
		
		// Recuperation des cases necessaires au prochain deplacement
		
		Decor dessous = map.getDessous(positionInitiale,lemming.direction,map);
		Decor devant = map.getDevant(positionInitiale,lemming.direction,map);
		
		
		// La gravite prevaut 
		if (dessous.decorToChar() == ' ') {
			lemming.direction.bas = true;
			lemming.position.ordonnee += 1;
		} 
		else {
			// Si la case du dessous n'est pas vide alors
			lemming.direction.bas = false;
			if ( (devant.decorToChar() == ' ') ) {
				if (lemming.direction.gauche) {
					lemming.position.abscisse -= 1;
				}
				if (lemming.direction.droite) {
					lemming.position.abscisse += 1;
				}
			}
			
			// Si ni la case du dessous ou du devant n'est vide
			else {
				if (devant.estMortelle(positionInitiale,positionSuivante)) {
					System.out.println(" :__ RIP petit lemming :__ ");
					lemming.direction.bas = false;
					lemming.direction.gauche = false;
					lemming.direction.droite = false;
				}
					
				// Notre lemming n'est pas un climber et la case de devant n'est pas vide 
				// on change de direction horizontale
				if (lemming.direction.droite) {
					lemming.direction.droite = false;
					lemming.direction.gauche = true;
				}
				else {
					lemming.direction.droite = true;
					lemming.direction.gauche = false;
				}
				
			}
		}
	}

}


