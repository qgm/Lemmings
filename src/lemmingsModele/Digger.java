package lemmingsModele;
import java.awt.Color;

/** La classe Digger implemente la mï¿½thode executer() pour les foreurs
 * @author Quentin Glinel-Mortreuil
 */


public class Digger {
	
	/** Un Digger creuse vers le Sud les obstacles destructibles */
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException {
		// Couleur du lemming en fonction de sa competence
		lemming.couleur = Color.orange;
		// Eventuelle position suivante du lemming 
		Position positionSuivanteDevant = new Position (0,0);
		
		if (lemming.direction.droite) {
		    positionSuivanteDevant = new Position (positionInitiale.abscisse + 1, positionInitiale.ordonnee);
		}
		
		if (lemming.direction.gauche ) {
		    positionSuivanteDevant = new Position (positionInitiale.abscisse - 1, positionInitiale.ordonnee);
		}
		
		// Recuperation des cases necessaires au prochain deplacement
		Decor dessous = map.getDessous(positionInitiale,lemming.direction,map);
		Decor devant = map.getDevant(positionInitiale,lemming.direction,map);
				
		// Le digger creuse dès qu'il le peut
		lemming.direction.bas = true;
			
		Position positionSuivanteBas = new Position (positionInitiale.abscisse, positionInitiale.ordonnee + 1);
	
	
		// Mise a jour de la position : Le lemming digger essaiera d'abord de creuser (englobe le cas d'une case vide en dessous)
		// Case du dessous vide ou destructible
		if (dessous.estDestructible(positionInitiale,positionSuivanteBas)) {
			dessous.detruireObstacle();
			lemming.direction.bas = true;
			lemming.position.ordonnee += 1;
		} else { // Si la case du dessous n'est ni vide ni destructible alors...
			lemming.direction.bas = false;
				// Case du dessous non-destructible : le lemming essaye d'avancer horizontalement
				
			/*  // Mise a jour de la position suivante
				positionSuivante = positionInitiale;
				if (lemming.direction.gauche){
					positionSuivante.abscisse -= 1;
				} else {
					positionSuivante.ordonnee += 1;
				} */
				
				// Case du devant vide ou destructible
			if (devant.estDestructible(positionInitiale,positionSuivanteDevant)) {
				if (lemming.direction.gauche) {
					devant.detruireObstacle();
					lemming.position.abscisse -= 1;
				}
				if (lemming.direction.droite) {
					devant.detruireObstacle();
					lemming.position.abscisse += 1;
				}
			}
			// Obstacles meurtriers 
			if (devant.estMortelle(positionInitiale,positionSuivanteDevant)) {
				System.out.println(" :__ RIP petit lemming :__ ");
				lemming.direction.bas = false;
			    lemming.direction.gauche = false;
				lemming.direction.droite = false;
			}
			// Obstacles non-destructibles : le lemming fait demi-tour
			if (lemming.direction.gauche) {
				lemming.direction.droite = true;
				lemming.direction.gauche = false;
			} 
			else {
				lemming.direction.gauche = false;
				lemming.direction.droite = true;
			}		
		}
	}	
}

	

	
