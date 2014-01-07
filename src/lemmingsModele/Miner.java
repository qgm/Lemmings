package lemmingsModele;
import java.awt.Color;

/** La classe Miner implante les methodes relatives aux mineurs
 * @author Quentin Glinel-Mortreuil
 */
public class Miner implements Competence {

	
	/** Les Miner creusent les obstacles destructibles en diagonale
	 * vers le bas
	 */	
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException {
			
			// Couleur du lemming en fonction de sa competence
			lemming.couleur = Color.yellow;
			
			// Eventuelle position suivante du lemming pour les obstacles meurtriers
			Position positionSuivante = new Position (0,0);
			Decor decorAMiner = new DecorVide();
			
			
			if (lemming.direction.droite) {
				positionSuivante = new Position (positionInitiale.abscisse + 1, positionInitiale.ordonnee + 1 );
				decorAMiner = map.getDessous(positionSuivante,lemming.direction, map);
			}
			
			if (lemming.direction.gauche) {
				positionSuivante = new Position (positionInitiale.abscisse - 1, positionInitiale.ordonnee + 1);
			    decorAMiner = map.getDessous(positionSuivante,lemming.direction, map);	
			}
			
			if (lemming.direction.bas) {
				positionSuivante = new Position (positionInitiale.abscisse, positionInitiale.ordonnee + 1);
			}
			
			// Recuperation des cases necessaires au prochain deplacement
			Decor dessous = map.getDessous(positionInitiale,lemming.direction,map);
			Decor devant = map.getDevant(positionInitiale,lemming.direction,map);
			
			/* Mise a jour de la position */
			
			// La gravite prevaut
			if ( dessous.decorToChar() == ' ') {
				lemming.position.ordonnee += 1;
			} 
			else {
				// Si la case du dessous n'est pas vide alors
				lemming.direction.bas = false;
					// Si on peut miner en diagonale
					if (decorAMiner.estDestructible(positionInitiale, positionSuivante)) {
						decorAMiner.detruireObstacle();
						positionInitiale = positionSuivante;
					}
					// Si on ne peut pas miner
					else {
						if ((devant.decorToChar() == ' ')) {
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
								lemming.direction.droite = false;
								lemming.direction.gauche = false;
								lemming.direction.bas = false;
							}	
							// Notre lemming n'est pas un climber et le case de devant n'est pas vide, il fait demi-tour
							if (lemming.direction.droite) {
								lemming.direction.droite = false;
								lemming.direction.gauche = true;
							}
							else {	
								lemming.direction.gauche = false;
								lemming.direction.droite = true;
							}
						}
					}
				}
			}
		}
