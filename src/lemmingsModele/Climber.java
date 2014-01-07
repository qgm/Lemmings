package lemmingsModele;

import java.awt.Color;

/** La classe Climber implante les methodes propres aux escaladeurs
 * @author Quentin Glinel-Mortreuil
 */

public class Climber implements Competence {
	
	/** Les climber grimpent aux parois verticales plutot que de faire demi-tour
	 * @throws ConfigurationException 
	 * 
	 */
	boolean climbing; // savoir si notre lemming a entame une ascension ou non 
	
	public void executer(Position positionInitiale, Map map,Lemming lemming) throws ConfigurationException  {
		
		
		// Couleur du lemming en fonction de sa competence
		lemming.couleur = Color.pink;
		
		// Eventuelle position suivante du lemming pour les obstacles meurtriers 
		Position positionSuivante = new Position (0,0);
		
		
		if (climbing) {
			positionSuivante = new Position (positionInitiale.abscisse,positionInitiale.ordonnee - 1 );
		}
			
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
				Decor dessus = map.getDessus(positionInitiale, lemming.direction, map);
	
		
		// Mise a jour de la position
		// La gravite prevaut !
		if ( dessous.decorToChar() == ' ' && (!this.climbing))  {
			lemming.position.ordonnee += 1;
			lemming.direction.bas = true;
		} 
		else {
			lemming.direction.bas = false;
			// Si la case du dessous n'est pas vide alors...
			// Case du devant vide
			if ( devant.decorToChar() == ' ') {
				this.climbing = false;
				if (lemming.direction.gauche) {
					lemming.position.abscisse -= 1;
				}
				if (lemming.direction.droite) {
					lemming.position.abscisse += 1;
				}
			}
			else {
				// Si ni la case du dessous ni celle de devant ne sont vides
				// Obstacles meurtriers 
				if (devant.estMortelle(positionInitiale,positionSuivante)) {
					System.out.println(" :__ RIP petit lemming :__ ");
					lemming.direction.bas = false;
					lemming.direction.gauche = false;
					lemming.direction.droite = false;
				}
				// Obstacles non-destructibles : le lemming grimpe
				else {
					if ( dessus.decorToChar() == ' ') {
						positionInitiale.ordonnee -= 1;
						this.climbing = true;
					}
					else {
						this.climbing = false;
					}
				}
			}
		}
	}
}
	



