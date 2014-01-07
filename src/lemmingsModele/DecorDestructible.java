package lemmingsModele;
public class DecorDestructible implements Decor{

	public char representationDecor='+';

	/**Donne la representation d'un decor sous la forme d'un char*/
	public char decorToChar(){
		return '+';
	}


	public Decor charToDecor(){
		Decor decor=new DecorDestructible();
		return decor;
	}

	/**Cette methode dit si l'obstacle est destructible ou pas en fonction de la position du lemming*/
	public boolean estDestructible(Position positionLemming, Position positionObstacle){
		return true;
	}

	public void detruireObstacle() {
		this.representationDecor=' ';
	}

	public boolean estMortelle(Position positionLemming, Position positionObstacle){
		return (false);
	}
}

