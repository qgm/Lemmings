package lemmingsModele;
import java.awt.Color;

/** Classe Lemming qui repr�sente un lemming au moment o� il arrive sur la map,
 * i.e. avant qu'on lui ait assign� une ou plusieurs comp�tences.
 * @author Quentin Glinel-Mortreuil
 */

public class Lemming {
	
	public int numeroLemming; 		// Le numero du Lemming
	public Position position;		// la position du lemming sur la map
	public Direction direction;	// la direction vers laquelle il se d�place
	public Color couleur;			// couleur du lemming repr�sentant la comp�tence courante
	public float vitesseLemming;	// la vitesse � laquelle se d�place notre lemming
	public Competence competence;	// quelle comp�tence a-t-il ?
		
	/* Constructeur */
	public Lemming(int numeroLemming, Position position, Direction direction,
			Color couleur, float vitesseLemming, Competence competence) {

		this.numeroLemming = numeroLemming;
		this.position = position;
		this.direction = direction;
		this.couleur = couleur;
		this.vitesseLemming = vitesseLemming;
		this.competence = competence;
	}
	
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public float getVitesse() {
		return vitesseLemming;
	}
	public void setVitesse(float vitesse) {
		this.vitesseLemming = vitesse;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
}
