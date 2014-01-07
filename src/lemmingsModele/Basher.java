package lemmingsModele;
import java.awt.Color;

/** La classe Basher implante les m�thodes propres aux pelleteurs
 * @author Quentin Glinel-Mortreuil
 */

public class Basher implements Competence {
	/** Les Bashers creusent les obstacles destructibles a l'horizontale
	 */
	
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException {
		// Couleur du lemming en fonction de sa competence
		lemming.couleur = Color.blue;
				
		// Eventuelle position suivante du lemming pour les obstacles meurtriers ou destructibles
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
	
		// Mise a jour de la position
		// La gravite prevaut !
		if ( dessous.decorToChar() == ' ') {
			lemming.position.ordonnee += 1;
			lemming.direction.bas = true;
		} 
		else {
			// Si la case du dessous n'est pas vide alors...
			// Case du devant vide ou destructible
			lemming.direction.bas = false; 
			if ( devant.estDestructible(positionInitiale,positionSuivante)) {
				if (lemming.direction.droite) {
					devant.detruireObstacle();
					lemming.position.abscisse += 1;
				} else {
					devant.detruireObstacle();
					lemming.position.abscisse -= 1;
				}
				
			}
			else {
				// Si ni la case du dessous ni celle de devant ne sont vides ou destructibles
				// Obstacles meurtriers 
				if (devant.estMortelle(positionInitiale,positionSuivante)) {
					System.out.println(" :__ RIP petit lemming :__ ");
					lemming.direction.bas = false;
					lemming.direction.gauche = false;
					lemming.direction.droite = false;
				}
				// Obstacles non-destructibles : le lemming fait demi-tour 
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





