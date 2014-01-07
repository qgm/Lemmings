package lemmingsModele;
/** La classe direction donne la direction de d�placement du lemming
 * @author Quentin Glinel-Mortreuil
 */


public class Direction {

	/** Les differentes directions de deplacement possible pour un lemming */
	public boolean bas;
	public boolean gauche;
	public boolean droite;

	public Direction() {
	
	}

	public Direction(boolean bas, boolean gauche, boolean droite) {
		this.bas = bas;
		this.gauche = gauche;
		this.droite = droite;
	}



	public Direction(boolean haut, boolean bas, boolean gauche, boolean droite) {
		super();
		this.bas = bas;
		this.gauche = gauche;
		this.droite = droite;
	}

	public boolean isBas() {
		return bas;
	}

	public void setBas(boolean bas) {
		this.bas = bas;
	}

	public boolean isGauche() {
		return gauche;
	}

	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}

	public boolean isDroite() {
		return droite;
	}

	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	
	
}
